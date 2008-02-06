package jetbrains.mps.generator.template;

import jetbrains.mps.smodel.*;
import jetbrains.mps.transformation.TLBase.plugin.debug.GenerationTracer;
import jetbrains.mps.transformation.TLBase.structure.*;
import jetbrains.mps.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.jetbrains.annotations.Nullable;

public class TemplateProcessor {
  private TemplateGenerator myGenerator;
  private SModel myOutputModel;
  private List<Pair<SNode, String>> myInputHistory = new ArrayList<Pair<SNode, String>>();
  private Map<String, SNode> myInputNodesByMappingName = new HashMap<String, SNode>();

  public TemplateProcessor(TemplateGenerator generator) {
    myGenerator = generator;
    myOutputModel = myGenerator.getOutputModel();
  }


  public static List<SNode> createOutputNodesForTemplateNode(String mappingName,
                                                             SNode templateNode,
                                                             SNode inputNode,
                                                             TemplateGenerator generator) throws DismissTopMappingRuleException, TemplateProcessingFailureException {
    TemplateProcessor templateProcessor = new TemplateProcessor(generator);
    Map<String, SNode> old = generator.setPreviousInputNodesByMappingName(templateProcessor.myInputNodesByMappingName);
    try {
      List<SNode> outputNodels = templateProcessor.createOutputNodesForTemplateNode(mappingName, templateNode, inputNode, 0, true);
      if (outputNodels == null) {
        throw new TemplateProcessingFailureException();
      }
      return outputNodels;
    } finally {
      generator.setPreviousInputNodesByMappingName(old);
    }
  }

  private List<SNode> createOutputNodesForTemplateNode(String mappingName,
                                                       SNode templateNode,
                                                       SNode inputNode,
                                                       int nodeMacrosToSkip,
                                                       boolean registerTopOutput) throws DismissTopMappingRuleException {
    GenerationTracer generationTracer = myGenerator.getGeneratorSessionContext().getGenerationTracer();
    putInputNodeByMappingName(mappingName, inputNode);

    int macroCount = 0;
    List<SNode> outputNodes = new ArrayList<SNode>();
    // templateNode has unprocessed node-macros?
    for (INodeAdapter templateChildNode : templateNode.getAdapter().getChildren()) {
      if (!(templateChildNode instanceof NodeMacro)) continue;
      macroCount++;
      if (macroCount <= nodeMacrosToSkip) continue;
      NodeMacro nodeMacro = (NodeMacro) templateChildNode;

      generationTracer.pushMacro(nodeMacro.getNode());
      try {
        return createOutputNodesForTemplateNodeWithMacro(nodeMacro, templateNode, inputNode, nodeMacrosToSkip, registerTopOutput);
      } finally {
        generationTracer.closeMacro(nodeMacro.getNode());
      }
    }

    // templateNode has no unprocessed node-macros - create output instance for the tempate node
    generationTracer.pushTemplateNode(templateNode);
    SNode outputNode = SModelUtil_new.instantiateConceptDeclaration(templateNode.getConceptFqName(), myOutputModel, myGenerator.getScope(), false);
    if (outputNode == null) {
      myGenerator.showErrorMessage(null, templateNode, "'createOutputNodesForTemplateNode' cannot create output node");
      return null;
    }
    outputNodes.add(outputNode);
    if (registerTopOutput) {
      myGenerator.addTopOutputNodeByInputNode(inputNode, outputNode);
    }
    myGenerator.addOutputNodeByInputAndTemplateNode(inputNode, templateNode, outputNode);
    if (!myInputHistory.isEmpty()) {
      for (Pair<SNode, String> nodeAndMappingName : myInputHistory) {
        myGenerator.addOutputNodeByIndirectInputAndTemplateNode(nodeAndMappingName.o1, templateNode, outputNode);
      }
    }
    myGenerator.addOutputNodeByInputNodeAndMappingName(inputNode, mappingName, outputNode);
    myGenerator.addTemplateNodeByOutputNode(outputNode, templateNode);
    myGenerator.addOutputNodeByTemplateNode(templateNode, outputNode);
    outputNode.putProperties(templateNode);

    SModel templateModel = templateNode.getModel();
    for (SReference reference : templateNode.getReferences()) {
      if (templateNode.getLinkAttribute("referenceMacro", reference.getRole()) != null) {
        continue;
      }
      SNode templateReferentNode = reference.getTargetNode();
      if (templateReferentNode == null) {
        myGenerator.showErrorMessage(null, templateNode, "'createOutputNodesForTemplateNode()' referent '" + reference.getRole() + "' is null in template model");
        continue;
      }
      if (templateReferentNode.getModel() == templateModel) { // internal reference
        ReferenceInfo_TemplateNode refInfo = new ReferenceInfo_TemplateNode(
          outputNode,
          reference,
          inputNode,
          getInputHistoryCopy());
        PostponedReference postponedReference = new PostponedReference(
          refInfo,
          myGenerator
        );
        outputNode.addReference(postponedReference);
      } else {
        outputNode.setReferent(reference.getRole(), templateReferentNode);
      }
    }

    // process property and reference macros
    List<INodeAdapter> templateChildNodes = new ArrayList<INodeAdapter>();
    for (INodeAdapter templateChildNode : templateNode.getAdapter().getChildren()) {
      if (templateChildNode instanceof PropertyMacro) {
        MacroUtil.expandPropertyMacro(myGenerator, (PropertyMacro) templateChildNode, inputNode, templateNode, outputNode);
      } else if (templateChildNode instanceof ReferenceMacro) {
        ReferenceInfo_Macro refInfo = new ReferenceInfo_Macro(
          outputNode, (ReferenceMacro) templateChildNode,
          inputNode,
          new HashMap<String, SNode>(myInputNodesByMappingName),
          templateNode
        );
        PostponedReference postponedReference = new PostponedReference(
          refInfo,
          myGenerator
        );
        outputNode.addReference(postponedReference);
      } else if (!GeneratorUtil.isTemplateLanguageElement(templateChildNode)) {
        templateChildNodes.add(templateChildNode);
      }
    }

    // process children
    try {
      for (INodeAdapter templateChildNode : templateChildNodes) {
        List<SNode> outputChildNodes = createOutputNodesForTemplateNode(null, templateChildNode.getNode(), inputNode, 0, false);
        if (outputChildNodes != null) {
          String role = templateChildNode.getRole_();
          for (SNode outputChildNode : outputChildNodes) {
            //          // check child
            //          if (!SModelUtil_new.isAcceptableTarget(outputNode, role, outputChildNode)) {
            //            myGenerator.showErrorMessage(outputChildNode, "unacceptable child node " + outputChildNode.getDebugText() + " for role '" + role + "'");
            //            myGenerator.showErrorMessage(templateChildNode.getNode(), " -- template node " + templateChildNode.getDebugText());
            //          }
            outputNode.addChild(role, outputChildNode);
          }
        }
      }
    } finally {
      generationTracer.pushOutputNode(outputNode);
      generationTracer.closeTemplateNode(templateNode);
    }
    return outputNodes;
  }

  private List<SNode> createOutputNodesForTemplateNodeWithMacro(NodeMacro nodeMacro, SNode templateNode, SNode inputNode, int nodeMacrosToSkip, boolean registerTopOutput) throws DismissTopMappingRuleException {
    GenerationTracer generationTracer = myGenerator.getGeneratorSessionContext().getGenerationTracer();
    List<SNode> outputNodes = new ArrayList<SNode>();
    String mappingName = GeneratorUtil.getMappingName(nodeMacro, null);

    if (nodeMacro instanceof LoopMacro) {
      // $LOOP$
      List<SNode> newInputNodes = MacroUtil.getNewInputNodes(nodeMacro, inputNode, myGenerator);
      for (SNode newInputNode : newInputNodes) {
        boolean inputChanged = (newInputNode != inputNode);
        if (inputChanged) {
          pushInputHistory(inputNode);
          generationTracer.pushInputNode(newInputNode);
        }
        try {
          List<SNode> _outputNodes = createOutputNodesForTemplateNode(mappingName, templateNode, newInputNode, nodeMacrosToSkip + 1, inputChanged);
          if (_outputNodes != null) outputNodes.addAll(_outputNodes);
          if (registerTopOutput && !inputChanged) {
            myGenerator.addTopOutputNodesByInputNode(inputNode, _outputNodes);
          }
        } finally {
          if (inputChanged) {
            popInputHistory();
            generationTracer.closeInputNode(newInputNode);
          }
        }
      }
      return outputNodes;

    } else if (nodeMacro instanceof CopySrcNodeMacro || nodeMacro instanceof CopySrcListMacro) {
      // $COPY-SRC$ / $COPY-SRCL$
      List<SNode> newInputNodes = MacroUtil.getNewInputNodes(nodeMacro, inputNode, myGenerator);
      for (SNode newInputNode : newInputNodes) {
        List<SNode> _outputNodes = copyNodeFromInputNode(mappingName, templateNode, newInputNode);
        if (_outputNodes != null) outputNodes.addAll(_outputNodes);
      }
      return outputNodes;

    } else if (nodeMacro instanceof IfMacro) {
      // $IF$
      List<SNode> _outputNodes = null;
      if (MacroUtil.checkConditionForIfMacro(inputNode, (IfMacro) nodeMacro, myGenerator)) {
        _outputNodes = createOutputNodesForTemplateNode(mappingName, templateNode, inputNode, nodeMacrosToSkip + 1, false);
      } else {
        // alternative consequence
        RuleConsequence altConsequence = ((IfMacro) nodeMacro).getAlternativeConsequence();
        if (altConsequence != null) {
          Pair<SNode, String> nodeAndMappingName = GeneratorUtil.getTemplateNodeFromRuleConsequence(altConsequence, inputNode, nodeMacro.getNode(), myGenerator);
          if (nodeAndMappingName == null) {
            myGenerator.showErrorMessage(inputNode, null, nodeMacro.getNode(), "error processing $IF$/alternative");
            return null;
          }
          SNode altTemplateNode = nodeAndMappingName.o1;
          if (nodeAndMappingName.o2 != null) {
            mappingName = nodeAndMappingName.o2;
          }
          _outputNodes = createOutputNodesForExternalTemplateNode(mappingName, altTemplateNode, inputNode, false);
        }
      }
      if (_outputNodes != null) outputNodes.addAll(_outputNodes);
      if (registerTopOutput) {
        myGenerator.addTopOutputNodesByInputNode(inputNode, _outputNodes);
      }
      return outputNodes;

    } else if (nodeMacro instanceof MapSrcNodeMacro || nodeMacro instanceof MapSrcListMacro) {
      // $MAP-SRC$ or $MAP-SRCL$
      MapSrcMacro_MapperFunction macro_mapperFunction;
      String mapperId; // old
      if (nodeMacro instanceof MapSrcNodeMacro) {
        macro_mapperFunction = ((MapSrcNodeMacro) nodeMacro).getMapperFunction();
        mapperId = ((MapSrcNodeMacro) nodeMacro).getSourceNodeMapperId();
      } else {
        macro_mapperFunction = ((MapSrcListMacro) nodeMacro).getMapperFunction();
        mapperId = ((MapSrcListMacro) nodeMacro).getSourceNodeMapperId();
      }

      List<SNode> newInputNodes = MacroUtil.getNewInputNodes(nodeMacro, inputNode, myGenerator);
      for (SNode newInputNode : newInputNodes) {
        boolean inputChanged = (newInputNode != inputNode);
        if (inputChanged) {
          pushInputHistory(inputNode);
          generationTracer.pushInputNode(newInputNode);
        }
        try {
          if (mapperId != null || macro_mapperFunction != null) {
            SNode childToReplaceLater = SModelUtil_new.instantiateConceptDeclaration(templateNode.getConceptFqName(), myOutputModel, myGenerator.getScope(), false);
            generationTracer.pushOutputNodeToReplaceLater(childToReplaceLater);
            outputNodes.add(childToReplaceLater);
            // execute the 'mapper' function later
            putInputNodeByMappingName(mappingName, newInputNode);
            myGenerator.getDelayedChanges().addExecuteMapSrcNodeMacroChange(
              nodeMacro,
              childToReplaceLater,
              newInputNode,
              new HashMap<String, SNode>(myInputNodesByMappingName),
              myGenerator);
          } else {
            List<SNode> _outputNodes = createOutputNodesForTemplateNode(mappingName, templateNode, newInputNode, nodeMacrosToSkip + 1, inputChanged);
            if (_outputNodes != null) outputNodes.addAll(_outputNodes);
            if (registerTopOutput && !inputChanged) {
              myGenerator.addTopOutputNodesByInputNode(inputNode, _outputNodes);
            }
          }
        } finally {
          if (inputChanged) {
            popInputHistory();
            generationTracer.closeInputNode(newInputNode);
          }
        }
      }
      return outputNodes;

    } else if (nodeMacro instanceof SwitchMacro) {
      // $SWITCH$
      TemplateSwitch templateSwitch = ((SwitchMacro) nodeMacro).getTemplateSwitch();
      if (templateSwitch == null) {
        myGenerator.showErrorMessage(inputNode, nodeMacro.getNode(), "error processing $SWITCH$ - bad TemplateSwitch reference");
        return null;
      }

      SNode newInputNode = MacroUtil.getNewInputNode(nodeMacro, inputNode, myGenerator);
      if (newInputNode == null) {
        return outputNodes; // skip template
      }

      boolean inputChanged = (newInputNode != inputNode);
      if (inputChanged) {
        pushInputHistory(inputNode);
        generationTracer.pushInputNode(newInputNode);
      }
      generationTracer.pushSwitch(templateSwitch.getNode());

      try {
        RuleConsequence consequenceForCase = (RuleConsequence) myGenerator.getConsequenceForSwitchCase(newInputNode, templateSwitch);
        SNode templateNodeForCase = null;
        if (consequenceForCase != null) {
          Pair<SNode, String> nodeAndMappingName = GeneratorUtil.getTemplateNodeFromRuleConsequence(consequenceForCase, newInputNode, nodeMacro.getNode(), myGenerator);
          if (nodeAndMappingName == null) {
            myGenerator.showErrorMessage(newInputNode, nodeMacro.getNode(), consequenceForCase.getNode(), "error processing $SWITCH$");
            return null;
          }
          templateNodeForCase = nodeAndMappingName.o1;
          if (nodeAndMappingName.o2 != null) {
            mappingName = nodeAndMappingName.o2;
          }
        } else {
          // for back compatibility
          generationTracer.pushRule(templateSwitch.getNode());
          TemplateDeclaration templateForSwitchCase = myGenerator.getTemplateForSwitchCase_deprecated(newInputNode, templateSwitch);
          if (templateForSwitchCase != null) {
            TemplateFragment fragment = GeneratorUtil.getFragmentFromTemplate(templateForSwitchCase, newInputNode, nodeMacro.getNode(), myGenerator);
            if (fragment != null) {
              mappingName = GeneratorUtil.getMappingName(fragment, mappingName);
              templateNodeForCase = fragment.getParent().getNode();
            }
          }
        }

        List<SNode> _outputNodes;
        if (templateNodeForCase != null) {
          _outputNodes = createOutputNodesForExternalTemplateNode(mappingName, templateNodeForCase, newInputNode, inputChanged);
        } else {
          // no switch-case found for the inputNode - continue with templateNode under the $switch$
          _outputNodes = createOutputNodesForTemplateNode(mappingName, templateNode, newInputNode, nodeMacrosToSkip + 1, inputChanged);
        }
        if (_outputNodes != null) outputNodes.addAll(_outputNodes);
        if (registerTopOutput && !inputChanged) {
          myGenerator.addTopOutputNodesByInputNode(inputNode, _outputNodes);
        }
      } finally {
        if (inputChanged) {
          popInputHistory();
          generationTracer.closeInputNode(newInputNode);
        }
      }
      return outputNodes;

    } else if (nodeMacro instanceof IncludeMacro) {
      // $INCLUDE$
      SNode newInputNode = MacroUtil.getNewInputNode(nodeMacro, inputNode, myGenerator);
      if (newInputNode == null) {
        return outputNodes; // skip template
      }

      IncludeMacro includeMacro = (IncludeMacro) nodeMacro;
      TemplateDeclaration includeTemplate = includeMacro.getIncludeTemplate();
      if (includeTemplate == null) {
        myGenerator.showErrorMessage(newInputNode, null, nodeMacro.getNode(), "error processing $INCLIDE$ : no 'include template'");
        return null;
      }
      TemplateFragment fragment = GeneratorUtil.getFragmentFromTemplate(includeTemplate, newInputNode, nodeMacro.getNode(), myGenerator);
      if (fragment == null) {
        myGenerator.showErrorMessage(newInputNode, null, nodeMacro.getNode(), "error processing $INCLIDE$");
        return null;
      }

      boolean inputChanged = (newInputNode != inputNode);
      if (inputChanged) {
        pushInputHistory(inputNode);
        generationTracer.pushInputNode(newInputNode);
      }
      generationTracer.pushTemplateNode(includeTemplate.getNode());

      try {
        SNode templateForInclude = fragment.getParent().getNode();
        mappingName = GeneratorUtil.getMappingName(fragment, mappingName);
        List<SNode> _outputNodes = createOutputNodesForExternalTemplateNode(mappingName, templateForInclude, newInputNode, inputChanged);
        if (_outputNodes != null) outputNodes.addAll(_outputNodes);
        if (registerTopOutput && !inputChanged) {
          myGenerator.addTopOutputNodesByInputNode(inputNode, _outputNodes);
        }
      } finally {
        if (inputChanged) {
          popInputHistory();
          generationTracer.closeInputNode(newInputNode);
        }
      }

      return outputNodes;
    }

    // $$
    List<SNode> newInputNodes = MacroUtil.getNewInputNodes(nodeMacro, inputNode, myGenerator);
    for (SNode newInputNode : newInputNodes) {
      boolean inputChanged = (newInputNode != inputNode);
      if (inputChanged) {
        pushInputHistory(inputNode);
        generationTracer.pushInputNode(newInputNode);
      }
      try {
        List<SNode> _outputNodes = createOutputNodesForTemplateNode(mappingName, templateNode, newInputNode, nodeMacrosToSkip + 1, inputChanged);
        if (_outputNodes != null) outputNodes.addAll(_outputNodes);
        if (registerTopOutput && !inputChanged) {
          myGenerator.addTopOutputNodesByInputNode(inputNode, outputNodes);
        }
      } finally {
        if (inputChanged) {
          popInputHistory();
          generationTracer.closeInputNode(newInputNode);
        }
      }
    }
    return outputNodes;
  }

  private List<SNode> copyNodeFromInputNode(String mappingName, SNode templateNode, SNode inputNode) {
    putInputNodeByMappingName(mappingName, inputNode);
    myGenerator.getGeneratorSessionContext().getGenerationTracer().pushInputNode(inputNode);
    try {
      return copyNodeFromInputNode_internal(mappingName, templateNode, inputNode);
    } finally {
      myGenerator.getGeneratorSessionContext().getGenerationTracer().closeInputNode(inputNode);
    }
  }

  private List<SNode> copyNodeFromInputNode_internal(String mappingName, SNode templateNode, SNode inputNode) {
    List<SNode> outputNodes = tryToReduce(inputNode);
    if (outputNodes != null) {
      if (outputNodes.size() == 1) {
        SNode outputNode = outputNodes.get(0);
        { // register copied node
          myGenerator.addOutputNodeByInputNodeAndMappingName(inputNode, mappingName, outputNode);
          // output node should be accessible via 'findCopiedNode'
          myGenerator.addCopiedOutputNodeForInputNode(inputNode, outputNode);
        }
      }
      return outputNodes;
    }

    // no reduction found - do node copying
    myGenerator.getGeneratorSessionContext().getGenerationTracer().pushCopyOperation();
    SNode outputNode = SModelUtil_new.instantiateConceptDeclaration(inputNode.getConceptFqName(), myOutputModel, myGenerator.getScope(), false);
    if (outputNode == null) {
      myGenerator.showErrorMessage(inputNode, templateNode, "'copyNodeFromInputNode()' cannot create output node");
      return null;
    }

    myGenerator.addOutputNodeByInputAndTemplateNode(inputNode, templateNode, outputNode);
    myGenerator.addOutputNodeByInputNodeAndMappingName(inputNode, mappingName, outputNode);
    // output node should be accessible via 'findCopiedNode'
    myGenerator.addCopiedOutputNodeForInputNode(inputNode, outputNode);

    outputNode.putProperties(inputNode);

    SModel inputModel = myGenerator.getSourceModel();
    for (SReference inputReference : inputNode.getReferences()) {
      SNode inputTargetNode = inputReference.getTargetNode();
      if (inputTargetNode == null) {
        myGenerator.showErrorMessage(inputNode, templateNode, "'copyNodeFromInputNode()' referent '" + inputReference.getRole() + "' is null in template model");
        continue;
      }
      if (inputTargetNode.getModel().equals(inputModel)) {
        ReferenceInfo_CopiedInputNode refInfo = new ReferenceInfo_CopiedInputNode(
          inputReference.getRole(),
          outputNode,
          inputReference.getSourceNode(),
          inputReference.getTargetNode());
        PostponedReference reference = new PostponedReference(
          refInfo,
          myGenerator
        );
        outputNode.addReference(reference);
      } else {
        outputNode.setReferent(inputReference.getRole(), inputTargetNode);
      }
    }

    for (SNode inputChildNode : inputNode.getChildren()) {
      String childRole = inputChildNode.getRole_();
      assert childRole != null;
      List<SNode> outputChildNodes = copyNodeFromInputNode(null, inputChildNode, inputChildNode);
      if (outputChildNodes != null) {
        for (SNode outputChildNode : outputChildNodes) {
//          // check child
//          if (!SModelUtil_new.isAcceptableTarget(outputNode, childRole, outputChildNode)) {
//            myGenerator.showErrorMessage(outputChildNode, "unacceptable child node " + outputChildNode.getDebugText() + " for role '" + childRole + "'");
//            myGenerator.showErrorMessage(inputChildNode, " -- input node " + inputChildNode.getDebugText());
//          }
          outputNode.addChild(childRole, outputChildNode);
        }
      }
    }

    myGenerator.getGeneratorSessionContext().getGenerationTracer().pushOutputNode(outputNode);
    outputNodes = new ArrayList<SNode>(1);
    outputNodes.add(outputNode);
    return outputNodes;
  }

  private List<SNode> tryToReduce(SNode inputNode) {
    boolean wasChanged = myGenerator.isChanged();
    try {
      Reduction_MappingRule reductionRule = myGenerator.getRuleManager().findReductionRule(inputNode);
      if (reductionRule != null) {
        return GeneratorUtil.applyReductionRule(inputNode, reductionRule, myGenerator);
      }
    } catch (DismissTopMappingRuleException ex) {
      // it's ok, just continue
      myGenerator.setChanged(wasChanged);
    }
    return null;
  }

  private List<SNode> createOutputNodesForExternalTemplateNode(String mappingName,
                                                               SNode templateNode,
                                                               SNode inputNode,
                                                               boolean registerTopOutput) throws DismissTopMappingRuleException {
    TemplateProcessor templateProcessor = new TemplateProcessor(myGenerator);
    Map<String, SNode> old = myGenerator.setPreviousInputNodesByMappingName(templateProcessor.myInputNodesByMappingName);
    try {
      return templateProcessor.createOutputNodesForTemplateNode(mappingName, templateNode, inputNode, 0, registerTopOutput);
    } finally {
      myGenerator.setPreviousInputNodesByMappingName(old);
    }
  }


  private void pushInputHistory(SNode oldInputNode) {
    myInputHistory.add(new Pair<SNode, String>(oldInputNode, null));
  }

  private void popInputHistory() {
    myInputHistory.remove(myInputHistory.size() - 1);
  }

  @Nullable
  private List<Pair<SNode, String>> getInputHistoryCopy() {
    return myInputHistory.isEmpty() ? null : new ArrayList<Pair<SNode, String>>(myInputHistory);
  }

  private void putInputNodeByMappingName(String mappingName, SNode node) {
    if (mappingName == null || node == null) return;
    myInputNodesByMappingName.put(mappingName, node);
  }
}
