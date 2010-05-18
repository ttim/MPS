/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.generator.impl;

import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.generator.*;
import jetbrains.mps.generator.dependencies.DependenciesData;
import jetbrains.mps.generator.dependencies.DependenciesListener;
import jetbrains.mps.generator.impl.FastRuleFinder.BlockedReductionsData;
import jetbrains.mps.generator.impl.TemplateProcessor.TemplateProcessingFailureException;
import jetbrains.mps.generator.template.*;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.lang.generator.plugin.debug.IGenerationTracer;
import jetbrains.mps.lang.generator.structure.*;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.lang.sharedConcepts.structure.Options_DefaultTrue;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.typesystem.runtime.incremental.INodesReadListener;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.Pair;
import jetbrains.mps.util.performance.IPerformanceTracer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by: Sergey Dmitriev
 * Date: Jan 23, 2007
 * <p/>
 * Created once per micro-step.
 */
public class TemplateGenerator extends AbstractTemplateGenerator {

  private static final Logger LOG = Logger.getLogger(TemplateGenerator.class);

  private boolean myChanged = false;
  private final RuleManager myRuleManager;
  private final DelayedChanges myDelayedChanges;
  private final Map<SNode, SNode> myNewToOldRoot = new HashMap<SNode, SNode>();
  private final Map<SNode, Object> myAdditionalInputNodes = new ConcurrentHashMap<SNode, Object>();
  protected final ArrayList<SNode> myOutputRoots;

  private final IQueryExecutor myExecutor;
  private Map<INodesReadListener, IQueryExecutor> myExecutorsMap;

  private final boolean myIsStrict;
  private boolean myAreMappingsReady = false;

  /* cached session data */
  private BlockedReductionsData myReductionData;
  
  private final IGenerationTracer myGenerationTracer;
  private IPerformanceTracer ttrace;
  private DependenciesData myDependenciesData;

  public TemplateGenerator(GenerationSessionContext operationContext, ProgressIndicator progressMonitor,
                           IGeneratorLogger logger, RuleManager ruleManager,
                           SModel inputModel, SModel outputModel, GenerationProcessContext generationContext,
                           DependenciesData dependenciesData, IPerformanceTracer performance) {

    super(operationContext, progressMonitor, logger, inputModel, outputModel);
    myRuleManager = ruleManager;
    myGenerationTracer = getGeneratorSessionContext().getGenerationTracer();
    myIsStrict = generationContext.isStrictMode();
    myDelayedChanges = new DelayedChanges(this);
    myDependenciesData = dependenciesData;
    ttrace = performance;
    myOutputRoots = new ArrayList<SNode>();
    myExecutor = generationContext.getTracingMode() >= GenerationSettings.TRACE_LANGS
      ? new TraceableQueryExecutor(new QueryExecutor(this), performance)
      : new QueryExecutor(this);

  }

  public boolean apply(boolean isPrimary) throws GenerationFailureException, GenerationCanceledException {
    checkMonitorCanceled();
    myAreMappingsReady = false;

    ttrace.push("reductions", false);
    applyReductions(isPrimary);
    ttrace.pop();

    myAreMappingsReady = true;

    // optimization: no changes? quit
    if (!isPrimary && !myChanged && myDelayedChanges.isEmpty() && !myRuleManager.hasWeavings()) {
      return false;
    }

    // publish roots
    for (SNode outputRoot : myOutputRoots) {
      myOutputModel.addRoot(outputRoot);
    }

    // weaving
    ttrace.push("weavings", false);
    applyWeaving_MappingRules();
    ttrace.pop();

    // optimization: no changes? quit
    if (!isPrimary && !myChanged && myDelayedChanges.isEmpty()) {
      return false;
    }

    // execute mapper in all $MAP_SRC$/$MAP_SRCL$
    ttrace.push("delayed mappings", false);
    myDelayedChanges.doAllChanges();
    ttrace.pop();

    if (myChanged || isPrimary) {
      // new unresolved references could appear after applying reduction rules (all delayed changes should be done before this, like replacing children)
      ttrace.push("restoring references", false);
      revalidateAllReferences();
      ttrace.pop();
      checkMonitorCanceled();

      // advance blocked reduction data
      getBlockedReductionsData().advanceStep();
    }
    return myChanged;
  }

  protected void applyReductions(boolean isPrimary) throws GenerationCanceledException, GenerationFailureException {
    // create all roots
    if (isPrimary) {
      ttrace.push("create root", false);
      for (CreateRootRule rule : myRuleManager.getCreateRootRules()) {
        checkMonitorCanceled();
        applyCreateRootRule(rule);
      }
      ttrace.pop();
    }

    // root mapping rules
    ttrace.push("root mappings", false);
    List<SNode> rootsToCopy = new ArrayList<SNode>(myInputModel.getRoots());
    for (Root_MappingRule rule : myRuleManager.getRoot_MappingRules()) {
      checkMonitorCanceled();
      applyRootMappingRule(rule, rootsToCopy);
    }
    ttrace.pop();

    // copy roots
    checkMonitorCanceled();
    getGeneratorSessionContext().clearCopiedRootsSet();
    for (SNode rootToCopy : rootsToCopy) {
      copyRootNodeFromInput(rootToCopy, getExecutorForNode(rootToCopy));
    }
  }

  private void applyCreateRootRule(CreateRootRule createRootRule) throws GenerationFailureException, GenerationCanceledException {
    final IQueryExecutor executor = getExecutorForNode(null);
    if (executor.checkCondition(createRootRule)) {
      INamedConcept templateNode = createRootRule.getTemplateNode();
      if (templateNode == null) {
        showErrorMessage(null, null, createRootRule.getNode(), "'create root' rule has no template");
      } else {
        myGenerationTracer.pushRule(createRootRule.getNode());
        try {
          createRootNodeFromTemplate(
            GeneratorUtil.getMappingName(createRootRule, null),
            BaseAdapter.fromAdapter(templateNode), null, false, executor);
        } finally {
          myGenerationTracer.closeRule(createRootRule.getNode());
        }
      }
    }
  }

  private void applyRootMappingRule(Root_MappingRule rule, List<SNode> rootsToCopy) throws GenerationFailureException, GenerationCanceledException {
    AbstractConceptDeclaration applicableConcept = rule.getApplicableConcept();
    if (applicableConcept == null) {
      showErrorMessage(null, null, BaseAdapter.fromAdapter(rule), "rule has no applicable concept defined");
      return;
    }
    boolean includeInheritors = rule.getApplyToConceptInheritors();
    Iterable<SNode> inputNodes = myInputModel.getFastNodeFinder().getNodes(applicableConcept, includeInheritors);
    for (SNode inputNode : inputNodes) {
      // do not apply root mapping if root node has been copied from input model on previous micro-step
      // because some roots can be already mapped and copied as well (if some rule has 'keep root' = true)
      if (getGeneratorSessionContext().isCopiedRoot(inputNode)) {
        continue;
      }

      final IQueryExecutor executor = getExecutorForNode(inputNode);
      if (executor.checkCondition(rule.getConditionFunction(), false, inputNode, rule.getNode())) {
        myGenerationTracer.pushInputNode(inputNode);
        myGenerationTracer.pushRule(rule.getNode());
        try {
          SNode templateNode = BaseAdapter.fromAdapter(rule.getTemplate());
          if (templateNode != null) {
            boolean copyRootOnFailure = false;
            if (inputNode.isRoot() && rule.getKeepSourceRoot() == Options_DefaultTrue.default_) {
              rootsToCopy.remove(inputNode);
              copyRootOnFailure = true;
            }
            createRootNodeFromTemplate(GeneratorUtil.getMappingName(rule, null), templateNode, inputNode, copyRootOnFailure, executor);
          } else {
            showErrorMessage(BaseAdapter.fromAdapter(rule), "no template is defined for the rule");
          }
        } finally {
          myGenerationTracer.closeInputNode(inputNode);
        }
      }
    }
  }

  protected void createRootNodeFromTemplate(String mappingName, @NotNull SNode templateNode, SNode inputNode, boolean copyRootOnFailure, IQueryExecutor executor)
    throws GenerationFailureException, GenerationCanceledException {

    try {
      List<SNode> outputNodes = new TemplateProcessor(this, new ReductionContext(executor)).processTemplateNode(mappingName, templateNode, new TemplateContext(inputNode, executor));
      for (SNode outputNode : outputNodes) {
        registerRoot(outputNode, inputNode, templateNode, false);
        setChanged();
      }
    } catch (DismissTopMappingRuleException e) {
      // it's ok, just continue
      if (copyRootOnFailure && inputNode.isRoot()) {
        copyRootNodeFromInput(inputNode, executor);
      }
    } catch (TemplateProcessingFailureException e) {
      showErrorMessage(inputNode, templateNode, "couldn't create root node");
    }
  }

  protected void copyRootNodeFromInput(@NotNull SNode inputRootNode, IQueryExecutor executor) throws GenerationFailureException, GenerationCanceledException {
    // check if can drop
    for (DropRootRule dropRootRule : myRuleManager.getDropRootRules()) {
      if (isApplicableDropRootRule(inputRootNode, dropRootRule, executor)) {
        return;
      }
    }

    // copy
    myGenerationTracer.pushInputNode(inputRootNode);
    try {
      boolean[] changed = new boolean[]{false};
      SNode root = copyNodeFromInputNode_internal(null, inputRootNode, new ReductionContext(executor), changed);
      registerRoot(root, inputRootNode, null, true);
      if (changed[0]) {
        setChanged();
      }
    } finally {
      myGenerationTracer.closeInputNode(inputRootNode);
    }
  }

  private void applyWeaving_MappingRules() throws GenerationFailureException, GenerationCanceledException {
    WeavingProcessor wp = new WeavingProcessor(this);
    for (Weaving_MappingRule rule : myRuleManager.getWeaving_MappingRules()) {
      checkMonitorCanceled();
      wp.apply(rule);
    }
  }

  private boolean isApplicableDropRootRule(SNode inputRootNode, DropRootRule rule, IQueryExecutor executor) throws GenerationFailureException {
    AbstractConceptDeclaration applicableConcept = rule.getApplicableConcept();
    if (applicableConcept == null) {
      showErrorMessage(null, null, rule.getNode(), "rule has no applicable concept defined");
      return false;
    }

    if (inputRootNode.isInstanceOfConcept(applicableConcept)) {
      if (executor.checkCondition(rule.getConditionFunction(), inputRootNode, rule.getNode())) {
        myGenerationTracer.pushInputNode(inputRootNode);
        myGenerationTracer.pushRule(rule.getNode());
        myGenerationTracer.closeInputNode(inputRootNode);
        return true;
      }
    }

    return false;
  }

  /**
   * Unsynchronized
   */
  IQueryExecutor getExecutorForNode(SNode inputNode) {
    final INodesReadListener listener = myDependenciesData.getListener(inputNode);
    if(listener != null) {
      IQueryExecutor value;
      if(myExecutorsMap == null) {
        myExecutorsMap = new HashMap<INodesReadListener, IQueryExecutor>();
        value = null;
      } else {
        value = myExecutorsMap.get(listener);
      }
      if(value == null) {
        value = new DependencyRecordingQueryExecutor(myExecutor, listener);
        myExecutorsMap.put(listener, value);
      }
      return value;
    }
    return myExecutor;
  }

  public IQueryExecutor getDefaultExecutor() {
    return myExecutor;
  }
  
  /**
   * @return null if no reductions found
   */
  @Nullable
  List<SNode> tryToReduce(SNode inputNode, String mappingName, @NotNull ReductionContext reductionContext) throws GenerationFailureException, GenerationCanceledException {
    ReductionRule reductionRule = null;
    GeneratedMatchingPattern pattern = null;
    checkGenerationCanceledFast();
    try {
      // find rule
      ReductionRule[] conceptRules = myRuleManager.getRuleFinder().findReductionRules(inputNode);
      if (conceptRules == null) {
        return null;
      }
      for (ReductionRule rule : conceptRules) {
        if (!getBlockedReductionsData().isReductionBlocked(inputNode, rule, reductionContext)) {
          if (rule instanceof Reduction_MappingRule) {
            if (reductionContext.getExecutor().checkCondition(((Reduction_MappingRule) rule).getConditionFunction(), false, inputNode, rule.getNode())) {
              reductionRule = rule;
              break;
            }
          } else if (rule instanceof PatternReduction_MappingRule) {
            pattern = reductionContext.getExecutor().checkIfApplicable(inputNode, (PatternReduction_MappingRule) rule, reductionContext);
            if (pattern != null) {
              reductionRule = rule;
              break;
            }
          }
        }
      }

      // apply
      if (reductionRule != null) {
        List<SNode> outputNodes = applyReductionRule(inputNode, reductionRule, pattern, new ReductionContext(reductionContext, inputNode, reductionRule));
        if (outputNodes != null && outputNodes.size() == 1) {
          SNode reducedNode = outputNodes.get(0);
          // register copied node
          getMappings().addOutputNodeByInputNodeAndMappingName(inputNode, mappingName, reducedNode);
          // output node should be accessible via 'findCopiedNode'
          getMappings().addCopiedOutputNodeForInputNode(inputNode, reducedNode);
          // preserve user objects
          reducedNode.putUserObjects(inputNode);
          // keep track of 'original input node'
          if (inputNode.getModel() == getGeneratorSessionContext().getOriginalInputModel()) {
            reducedNode.putUserObject(TemplateQueryContext.ORIGINAL_INPUT_NODE, inputNode);
            reducedNode.putUserObject(TemplateQueryContext.ORIGINAL_DEBUG_NODE, inputNode);
          }
        }
        return outputNodes;
      }
    } catch (DismissTopMappingRuleException ex) {
      // it's ok, just continue
      if (ex.isLoggingNeeded()) {
        String messageText = "-- dismissed reduction rule: " + reductionRule.getDebugText();
        if (ex.isInfo()) {
          showInformationMessage(reductionRule.getNode(), messageText);
        } else if (ex.isWarning()) {
          showWarningMessage(reductionRule.getNode(), messageText);
        } else {
          showErrorMessage(reductionRule.getNode(), messageText);
        }
      }
    }
    return null;
  }

  protected void checkGenerationCanceledFast() throws GenerationCanceledException {
  }

  @Nullable
  private List<SNode> applyReductionRule(SNode inputNode, ReductionRule rule, GeneratedMatchingPattern pattern, @NotNull ReductionContext reductionContext) throws DismissTopMappingRuleException, GenerationFailureException, GenerationCanceledException {
    myGenerationTracer.pushRule(rule.getNode());
    try {
      return applyReductionRule_internal(inputNode, rule, pattern, reductionContext);
    } catch (AbandonRuleInputException e) {
      return Collections.emptyList();
    } finally {
      myGenerationTracer.closeRule(rule.getNode());
    }
  }

  @Nullable
  private List<SNode> applyReductionRule_internal(SNode inputNode, ReductionRule rule, GeneratedMatchingPattern pattern, @NotNull ReductionContext reductionContext)
    throws DismissTopMappingRuleException, AbandonRuleInputException, GenerationFailureException, GenerationCanceledException {

    String ruleMappingName = GeneratorUtil.getMappingName(rule, null);
    RuleConsequence ruleConsequence = GeneratorUtil.getReductionConsequence(rule);
    if (ruleConsequence == null) {
      showErrorMessage(inputNode, null, rule.getNode(), "error processing reduction rule: no rule consequence");
      return null;
    }
    TemplateContext conseqContext = GeneratorUtil.createTemplateContext(inputNode, pattern == null ? null : new TemplateContext(pattern, null, inputNode, reductionContext.getExecutor()), reductionContext, ruleConsequence, inputNode, this);

    List<Pair<SNode, String>> nodeAndMappingNamePairs = GeneratorUtil.getTemplateNodesFromRuleConsequence(ruleConsequence, inputNode, rule.getNode(), reductionContext, this);
    if (nodeAndMappingNamePairs == null) {
      showErrorMessage(inputNode, null, ruleConsequence.getNode(), "error processing reduction rule consequence");
      return null;
    }

    List<SNode> result = new ArrayList<SNode>(nodeAndMappingNamePairs.size());
    TemplateProcessor templateProcessor = new TemplateProcessor(this, reductionContext);
    for (Pair<SNode, String> nodeAndMappingNamePair : nodeAndMappingNamePairs) {
      SNode templateNode = nodeAndMappingNamePair.o1;
      String mappingName = nodeAndMappingNamePair.o2 != null ? nodeAndMappingNamePair.o2 : ruleMappingName;
      try {
        result.addAll(templateProcessor.processTemplateNode(mappingName, templateNode, conseqContext));
      } catch (DismissTopMappingRuleException e) {
        throw e;
      } catch (TemplateProcessingFailureException e) {
        showErrorMessage(inputNode, templateNode, rule.getNode(), "error processing reduction rule");
      } catch (GenerationFailureException e) {
        throw e;
      } catch (GenerationCanceledException e) {
        throw e;
      } catch (Throwable t) {
        LOG.error(t, BaseAdapter.fromNode(templateNode));
        showErrorMessage(inputNode, templateNode, rule.getNode(), "error processing reduction rule");
      }
    }
    return result;
  }

  List<SNode> copyNodeFromExternalNode(String mappingName, SNode templateNode, SNode inputNode, ReductionContext reductionContext) throws GenerationFailureException, GenerationCanceledException {
    if (inputNode.isRegistered()) {
      // TODO fail in strict mode
      inputNode = CopyUtil.copy(inputNode);
      // TODO inputNode.changeModel();
    }

    synchronized (myAdditionalInputNodes) {
      if (!myAdditionalInputNodes.containsKey(inputNode)) {
        for (SNode n : inputNode.getDescendantsIterable(null, true)) {
          myAdditionalInputNodes.put(n, Boolean.TRUE);
        }
      }
    }

    // replace all references to input model => output model
    //invalidateReferencesInCopiedNode(inputNode);
    //return Collections.singletonList(inputNode);

    return copyNodeFromInputNode(mappingName, templateNode, inputNode, reductionContext, new boolean[]{false});
  }

  List<SNode> copyNodeFromInputNode(String mappingName, SNode templateNode, SNode inputNode, ReductionContext reductionContext, boolean[] changed) throws GenerationFailureException, GenerationCanceledException {
    myGenerationTracer.pushInputNode(inputNode);
    try {
      List<SNode> outputNodes = tryToReduce(inputNode, mappingName, reductionContext);
      if (outputNodes != null) {
        changed[0] = true;
        return outputNodes;
      }

      SNode copiedNode = copyNodeFromInputNode_internal(templateNode, inputNode, reductionContext, changed);
      myMappings.addOutputNodeByInputNodeAndMappingName(inputNode, mappingName, copiedNode);
      return Collections.singletonList(copiedNode);
    } finally {
      myGenerationTracer.closeInputNode(inputNode);
    }
  }

  private SNode copyNodeFromInputNode_internal(SNode templateNode, SNode inputNode, ReductionContext reductionContext, boolean[] changed) throws GenerationFailureException, GenerationCanceledException {
    // no reduction found - do node copying
    myGenerationTracer.pushCopyOperation();
    SNode outputNode = new SNode(myOutputModel, inputNode.getConceptFqName(), false);
    if (inputNode.hasId() && inputNode.isRegistered()) {
      outputNode.setId(inputNode.getSNodeId());
    }
    blockReductionsForCopiedNode(inputNode, outputNode, reductionContext); // prevent infinite applying of the same reduction to the 'same' node.

    myMappings.addOutputNodeByInputAndTemplateNode(inputNode, templateNode, outputNode);
    // output node should be accessible via 'findCopiedNode'
    myMappings.addCopiedOutputNodeForInputNode(inputNode, outputNode);

    outputNode.putProperties(inputNode);
    outputNode.putUserObjects(inputNode);
    // keep track of 'original input node'
    if (inputNode.getModel() == getGeneratorSessionContext().getOriginalInputModel()) {
      outputNode.putUserObject(TemplateQueryContext.ORIGINAL_INPUT_NODE, inputNode);
      outputNode.putUserObject(TemplateQueryContext.ORIGINAL_DEBUG_NODE, inputNode);
    }

    for (SReference inputReference : inputNode.getReferencesIterable()) {
      if (inputNode.isRegistered() && (inputReference instanceof DynamicReference || inputReference.isExternal())) {
        // dynamic & external references don't need validation => replace input model with output
        SModelReference targetModelReference = inputReference.isExternal() ? inputReference.getTargetSModelReference() : myOutputModel.getSModelReference();
        if (targetModelReference == null) {
          showErrorMessage(inputNode, templateNode, "broken reference '" + inputReference.getRole() + "' in " + inputNode.getDebugText() + " (target model is null)");
          continue;
        }

        if (inputReference instanceof StaticReference) {
          outputNode.addReference(new StaticReference(
            inputReference.getRole(),
            outputNode,
            targetModelReference,
            ((StaticReference) inputReference).getTargetNodeId(),
            inputReference.getResolveInfo()));
        } else if (inputReference instanceof DynamicReference) {
          outputNode.addReference(new DynamicReference(
            inputReference.getRole(),
            outputNode,
            targetModelReference,
            inputReference.getResolveInfo()));
        } else {
          LOG.error("internal error: can't clone reference '" + inputReference.getRole() + "' in " + inputNode.getDebugText(), inputNode);
          LOG.error(" -- was reference class : " + inputReference.getClass().getName());
        }
        continue;
      }

      SNode inputTargetNode = inputReference.getTargetNode();
      if (inputTargetNode == null) {
        showErrorMessage(inputNode, templateNode, "broken reference '" + inputReference.getRole() + "' in " + inputNode.getDebugText());
        continue;
      }
      if (inputTargetNode.isRegistered() && inputTargetNode.getModel().equals(myInputModel) || myAdditionalInputNodes.containsKey(inputTargetNode)) {
        ReferenceInfo_CopiedInputNode refInfo = new ReferenceInfo_CopiedInputNode(
          inputReference.getRole(),
          outputNode,
          inputReference.getSourceNode(),
          inputTargetNode);
        PostponedReference reference = new PostponedReference(
          refInfo,
          this
        );
        outputNode.addReference(reference);
      } else if (inputTargetNode.isRegistered()) {
        outputNode.setReferent(inputReference.getRole(), inputTargetNode);
      } else {
        showErrorMessage(inputNode, templateNode, "broken reference '" + inputReference.getRole() + "' in " + inputNode.getDebugText() + " (unregistered target node)");
      }
    }

    for (SNode inputChildNode : inputNode.getChildrenIterable()) {
      String childRole = inputChildNode.getRole_();
      assert childRole != null;
      myGenerationTracer.pushInputNode(inputChildNode);
      try {
        List<SNode> outputChildNodes = tryToReduce(inputChildNode, null, reductionContext);
        if (outputChildNodes != null) {
          changed[0] = true;
          for (SNode outputChildNode : outputChildNodes) {
            // check child
            if (!GeneratorUtil.checkChild(outputNode, childRole, outputChildNode)) {
              showWarningMessage(inputNode, " -- was input: " + inputNode.getDebugText());
              if (templateNode != null && SModelStereotype.isGeneratorModel(templateNode.getModel())) {
                showWarningMessage(templateNode, " -- was template: " + templateNode.getDebugText());
              }
            }
            outputNode.addChild(childRole, outputChildNode);
          }
        } else {
          outputNode.addChild(childRole, copyNodeFromInputNode_internal(null, inputChildNode, reductionContext, changed));
        }
      } finally {
        myGenerationTracer.closeInputNode(inputChildNode);
      }
    }

    myGenerationTracer.pushOutputNode(outputNode);
    return outputNode;
  }

  private void revalidateAllReferences() throws GenerationCanceledException {
    // replace all postponed references
    List<SNode> roots = myOutputModel.getRoots();
    for (SNode root : roots) {
      checkMonitorCanceled();
      revalidateAllReferences(root);
    }
  }

  private void revalidateAllReferences(SNode node) throws GenerationCanceledException {
    for (SReference reference : node.getReferencesArray()) {
      checkMonitorCanceled();
      if (reference instanceof PostponedReference) {
        ((PostponedReference) reference).validateAndReplace();
      }
    }

    List<SNode> children = node.getChildren();
    for (SNode child : children) {
      checkMonitorCanceled();
      revalidateAllReferences(child);
    }
  }

  /**
   * prevents applying of reduction rules which have already been applied to the input node.
   */
  void blockReductionsForCopiedNode(SNode inputNode, SNode outputNode, ReductionContext reductionContext) {
    getBlockedReductionsData().blockReductionsForCopiedNode(inputNode, outputNode, reductionContext);
  }

  BlockedReductionsData getBlockedReductionsData() {
    if (myReductionData == null) {
      Object blockedReductions = getGeneratorSessionContext().getStepObject(BlockedReductionsData.KEY);
      if (blockedReductions == null) {
        blockedReductions = new BlockedReductionsData();
        getGeneratorSessionContext().putStepObject(BlockedReductionsData.KEY, blockedReductions);
      }
      myReductionData = (BlockedReductionsData) blockedReductions;
    }
    return myReductionData;
  }

  IGenerationTracer getGenerationTracer() {
    return myGenerationTracer;
  }

  DelayedChanges getDelayedChanges() {
    return myDelayedChanges;
  }

  RuleManager getRuleManager() {
    return myRuleManager;
  }

  @Override
  public boolean areMappingsAvailable() {
    return myIsStrict ? myAreMappingsReady : true;
  }

  public GenerationSessionContext getGeneratorSessionContext() {
    return (GenerationSessionContext) getOperationContext();
  }

  public boolean isStrict() {
    return myIsStrict;
  }

  void setChanged() {
    myChanged = true;
  }

  private void registerRoot(@NotNull SNode outputRoot, SNode inputNode, SNode templateNode, boolean isCopied) {
    synchronized (this) {
      registerInModel(outputRoot, inputNode, templateNode);
      myNewToOldRoot.put(outputRoot, inputNode);
      myDependenciesData.registerRoot(outputRoot, inputNode);
      if (isCopied) {
        getGeneratorSessionContext().registerCopiedRoot(outputRoot);
      }
    }
  }

  protected void registerInModel(SNode outputRoot, SNode inputNode, SNode templateNode) {
    myOutputRoots.add(outputRoot);
  }

  SNode getOriginalRootByGenerated(SNode root) {
    SNode node = myNewToOldRoot.get(root);
    if (node != null && !node.isRoot()) {
      SNode noderoot = node.getContainingRoot();
      if (noderoot != null) {
        return noderoot;
      }
    }
    return node;
  }
}
