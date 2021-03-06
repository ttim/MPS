/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.newTypesystem;

import gnu.trove.THashMap;
import gnu.trove.THashSet;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.smodel.*;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/*
 *   Non-reenterable.
 */
class TypeSystemComponent extends CheckingComponent {
  private static final Logger LOG = Logger.getLogger(TypeSystemComponent.class);

  private boolean myInvalidationResult = false;

  private State myState;

  private Map<SNode, Set<SNode>> myNodesToDependentNodes_A;
  private Map<SNode, Set<SNode>> myNodesToDependentNodes_B;

  private Set<SNode> myNodes = new THashSet<SNode>();

  private Map<SNode, Set<Pair<String, String>>> myNodesToRules;
  private Set<SNode> myFullyCheckedNodes = new THashSet<SNode>(); //nodes which are checked with their children
  private Set<SNode> myPartlyCheckedNodes = new THashSet<SNode>(); // nodes which are checked themselves but not children
  private Set<SNode> myNodesDependentOnCaches;
  private Queue<SNode> myQueue = new LinkedList<SNode>();
  private SNode myCurrentCheckedNode;
  private boolean myCurrentTypeAffected = false;

  public TypeSystemComponent(TypeChecker typeChecker, State state, NodeTypesComponent component) {
    myState = state;
    myTypeChecker = typeChecker;
    myNodeTypesComponent = component;
    if (!myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation()) {
      myNodesToRules = new THashMap<SNode, Set<Pair<String, String>>>();
      myNodesDependentOnCaches = new THashSet<SNode>();
      myNodesToDependentNodes_A = new THashMap<SNode, Set<SNode>>();
      myNodesToDependentNodes_B = new THashMap<SNode, Set<SNode>>();
    }
  }

  //returns true if something was invalidated
  protected boolean doInvalidate() {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation(); //incremental
    if (myInvalidationWasPerformed) {
      return myInvalidationResult;
    }
    boolean result;
    Set<SNode> invalidatedNodes_A = new THashSet<SNode>();
    Set<SNode> invalidatedNodes_B = new THashSet<SNode>();
    Set<SNode> newNodesToInvalidate_A = new THashSet<SNode>();
    Set<SNode> newNodesToInvalidate_B = new THashSet<SNode>();
    Set<SNode> currentNodesToInvalidate_A = myCurrentNodesToInvalidate;
    Set<SNode> currentNodesToInvalidate_B = new THashSet<SNode>();

    if (myCacheWasRebuilt) {
      currentNodesToInvalidate_A.addAll(myNodesDependentOnCaches);
    }

    //A means invalidated and type will be recalculated, B means invalidated but type not affected. A => B then.
    while (!currentNodesToInvalidate_A.isEmpty() || !currentNodesToInvalidate_B.isEmpty()) {
      for (SNode nodeToInvalidate : currentNodesToInvalidate_A) {
        if (invalidatedNodes_A.contains(nodeToInvalidate)) continue;
        invalidateNodeTypeSystem(nodeToInvalidate, true);
        invalidatedNodes_A.add(nodeToInvalidate);
        Set<SNode> nodes = myNodesToDependentNodes_A.get(nodeToInvalidate);
        if (nodes != null) {
          newNodesToInvalidate_A.addAll(nodes);
        }
        nodes = myNodesToDependentNodes_B.get(nodeToInvalidate);
        if (nodes != null) {
          newNodesToInvalidate_B.addAll(nodes);
        }
      }

      for (SNode nodeToInvalidate : currentNodesToInvalidate_B) {
        if (invalidatedNodes_A.contains(nodeToInvalidate)) continue;
        if (invalidatedNodes_B.contains(nodeToInvalidate)) continue;
        invalidateNodeTypeSystem(nodeToInvalidate, false);
        invalidatedNodes_B.add(nodeToInvalidate);
        Set<SNode> nodes = myNodesToDependentNodes_A.get(nodeToInvalidate);
        if (nodes != null) {
          newNodesToInvalidate_B.addAll(nodes);
        }
        nodes = myNodesToDependentNodes_B.get(nodeToInvalidate);
        if (nodes != null) {
          newNodesToInvalidate_B.addAll(nodes);
        }
      }
      currentNodesToInvalidate_A = newNodesToInvalidate_A;
      currentNodesToInvalidate_B = newNodesToInvalidate_B;
      newNodesToInvalidate_A = new THashSet<SNode>();
      newNodesToInvalidate_B = new THashSet<SNode>();
    }
    result = !invalidatedNodes_A.isEmpty() || !invalidatedNodes_B.isEmpty();
    myCurrentNodesToInvalidate.clear();
    myCacheWasRebuilt = false;
    myInvalidationWasPerformed = true;
    myInvalidationResult = result;
    return result;
  }

  private void invalidateNodeTypeSystem(SNode node, boolean typeWillBeRecalculated) {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation(); //incremental

    myPartlyCheckedNodes.remove(node);
    myFullyCheckedNodes.remove(node);
    myState.clearNode(node);
    if (typeWillBeRecalculated) {
      TypeChecker.getInstance().fireTypeWillBeRecalculatedForTerm(node);
    }
    myNodesToRules.remove(node);
  }

  public Map<SNode, List<IErrorReporter>> getNodesToErrorsMap() {
    return myState.getNodeMaps().getNodesToErrors();
  }

  public void clear() {
    myIsChecked = false;
    clearCaches();
    clearState();
    clearNodeTypes();
  }

  private void clearState() {
    myState.clear(true);
  }

  public void clearNodeTypes() {
    myCurrentNodesToInvalidate.clear();
  }

  public void typeOfNodeCalled(SNode node) {
    if (myCurrentCheckedNode == node) {
      myCurrentTypeAffected = true;
    }
  }

  public void addDependencyOnCurrent(SNode node) {
    addDependencyOnCurrent(node, true);
  }

  //"type affected" means that *type* of this node depends on current
  // used to decide whether call "type will be recalculated" if current invalidated
  public void addDependencyOnCurrent(SNode node, boolean typeAffected) {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation(); //incremental

    Set<SNode> hashSet = new THashSet<SNode>(1);
    hashSet.add(myCurrentCheckedNode);

    if (node == null) {
      LOG.error("Typesystem dependency not tracked. ");
      return;
    }

    addDependentNodesTypeSystem(node, hashSet, typeAffected);
  }

  public void addDependencyForCurrent(SNode node, SNode nonTSCurrent) {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation(); //incremental

    Set<SNode> hashSet = new THashSet<SNode>(1);
    hashSet.add(node);
    if (myCurrentCheckedNode == null) {
      myCurrentCheckedNode = nonTSCurrent;
    }
    if (myCurrentCheckedNode == null) {
      LOG.error("Typesystem dependency not tracked. ");
      return;
    }
    addDependentNodesTypeSystem(myCurrentCheckedNode, hashSet, true);
  }

  private void computeTypesSpecial(SNode nodeToCheck, boolean forceChildrenCheck, Collection<SNode> additionalNodes, boolean finalExpansion, SNode initialNode) {
    computeTypesForNode(nodeToCheck, forceChildrenCheck, additionalNodes, initialNode);
    if (typeCalculated(initialNode) != null) return;
    solveInequalitiesAndExpandTypes(finalExpansion);
  }

  protected void computeTypes(SNode nodeToCheck, boolean refreshTypes, boolean forceChildrenCheck, Collection<SNode> additionalNodes, boolean finalExpansion, SNode initialNode) {
    try {
      if (refreshTypes) {
        clear();
        if (myState.getTypeCheckingContext().isSingleTypeComputation()) {
          myState.setTargetNode(initialNode);
        }
      } else {
        myState.clearStateObjects();
        doInvalidate();
        myPartlyCheckedNodes.addAll(myFullyCheckedNodes);
        myFullyCheckedNodes.clear();
      }
      computeTypesForNode(nodeToCheck, forceChildrenCheck, additionalNodes, initialNode);
      if (typeCalculated(initialNode) != null) return;
      solveInequalitiesAndExpandTypes(finalExpansion);
      if  (!myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation()){
        performActionsAfterChecking();
      }
      myState.performActionsAfterChecking();
    } finally {
      myInvalidationWasPerformed = false;
    }
  }

  public void clearCaches() {
    if (myNodesToDependentNodes_A!= null) {
      myNodesToDependentNodes_A.clear();
      myNodesToDependentNodes_B.clear();
      myNodesDependentOnCaches.clear();
      myNodesToRules.clear();
    }
    myFullyCheckedNodes.clear();
    myPartlyCheckedNodes.clear();
  }

  protected SNode computeTypesForNode_special(SNode initialNode, Collection<SNode> givenAdditionalNodes) {
    assert myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation() || myState.getInequalitySystem() !=null;

    assert myFullyCheckedNodes.isEmpty();
    SNode type = null;
    SNode prevNode = null;
    SNode node = initialNode;
    long start = System.currentTimeMillis();
    myState.setTargetNode(initialNode);
    while (node != null) {
      Collection<SNode> additionalNodes = givenAdditionalNodes;
      if (prevNode != null) {
        additionalNodes = new ArrayList<SNode>(additionalNodes);
        additionalNodes.add(prevNode);
      }
      computeTypesSpecial(node, false, additionalNodes, false, initialNode);
      type = typeCalculated(initialNode);
      if (type == null) {
        if (node.isRoot()) {
          //System.out.println("Root: " + initialNode.getDebugText());
          if (myState.getInequalitySystem() == null) {
            computeTypes(node,true, true, Collections.<SNode>emptyList(), true, initialNode);
          }
          type = getType(initialNode);
          if (type == null && node != initialNode && myTypeChecker.isGenerationMode()) {
            LOG.error("No typesystem rule for " + initialNode.getDebugText() + " in root " + initialNode.getContainingRoot() + ": type calculation took " + (System.currentTimeMillis() - start) + " ms", new Throwable(), new SNodePointer(initialNode));
          }
          return type;
        }
        prevNode = node;
        node = node.getParent();
      } else {
        type = typeCalculated(initialNode);
        return type;
      }
    }
    return type;
  }

  public SNode getType(SNode node) {
    if (myFullyCheckedNodes.contains(node)) {
      return getRawTypeFromContext(node);
    }
    return null;
  }

  public SNode getRawTypeFromContext(SNode node) {
    return myNodeTypesComponent.getTypeCheckingContext().getTypeDontCheck(node);
  }

  public void markNodeAsAffectedByRule(SNode node, String ruleModel, String ruleId) {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation();
    Set<Pair<String, String>> rulesWhichAffectNodesType = myNodesToRules.get(node);
    if (rulesWhichAffectNodesType == null) {
      rulesWhichAffectNodesType = new THashSet<Pair<String, String>>(1);
      myNodesToRules.put(node, rulesWhichAffectNodesType);
    }
    rulesWhichAffectNodesType.add(new Pair<String, String>(ruleModel, ruleId));
  }

  public Set<Pair<String, String>> getRulesWhichAffectNodeType(SNode node) {
    Set<Pair<String, String>> set = myNodesToRules.get(node);
    if (set == null) return null;
    return new THashSet<Pair<String, String>>(set);
  }

  private void computeTypesForNode(SNode node, boolean forceChildrenCheck, Collection<SNode> additionalNodes, SNode targetNode) {
    if (node == null) return;
    boolean incrementalMode = isIncrementalMode();
    MyEventsReadListener nodesReadListener = incrementalMode ? new MyEventsReadListener() : null;

    myQueue.add(node);
    myQueue.addAll(additionalNodes);
    for (SNode sNode = myQueue.poll(); sNode != null; sNode = myQueue.poll()) {
      if (myFullyCheckedNodes.contains(sNode)) {
        continue;
      }
      Set<SNode> candidatesForFrontier = new LinkedHashSet<SNode>();
      if (myNodeTypesComponent.isSpecial()) {
        candidatesForFrontier.addAll(myTypeChecker.getRulesManager().getDependencies(sNode));
      }
      if (forceChildrenCheck) {
        candidatesForFrontier.addAll(sNode.getChildren());
      }
      for (SNode candidate : candidatesForFrontier) {
        if (candidate == null || myFullyCheckedNodes.contains(candidate)) continue;
        myQueue.add(candidate);
      }
      if (!myPartlyCheckedNodes.contains(sNode)) {
        MyLanguageCachesReadListener languageCachesReadListener = null;
        if (incrementalMode) {
          languageCachesReadListener = new MyLanguageCachesReadListener();
          nodesReadListener.clear();
          NodeReadEventsCaster.setNodesReadListener(nodesReadListener);
          LanguageHierarchyCache.getInstance().setReadAccessListener(languageCachesReadListener);
        }
        boolean typeAffected = false;
        try {
          myNodes.add(sNode);
          typeAffected = applyRulesToNode(sNode);
        } finally {
          if (incrementalMode) {
            LanguageHierarchyCache.getInstance().removeReadAccessListener();
            NodeReadEventsCaster.removeNodesReadListener();
          }
        }
        if (incrementalMode) {
          nodesReadListener.setAccessReport(true);
          Set<SNode> accessedNodes = nodesReadListener.getAccessedNodes();
          addDependentNodesTypeSystem(sNode, accessedNodes, typeAffected);
          nodesReadListener.setAccessReport(false);
          if (languageCachesReadListener != null) { //redundant checking, in fact; but without this IDEA underlines the next line with red
            languageCachesReadListener.setAccessReport(true);
            if (languageCachesReadListener.isCacheAccessed()) {
              addCacheDependentNodesTypesystem(sNode);
            }
            languageCachesReadListener.setAccessReport(false);
          }
          nodesReadListener.clear();
        }
        myPartlyCheckedNodes.add(sNode);
      }
      myFullyCheckedNodes.add(sNode);
      if (typeCalculated(targetNode) != null) return;
    }
  }

  private SNode typeCalculated(SNode initialNode) {
    if (myState.getInequalitySystem() != null) {
      SNode expectedType = myState.getInequalitySystem().getExpectedType();
      if (expectedType != null && !TypesUtil.hasVariablesInside(expectedType) && !HUtil.isRuntimeHoleType(expectedType)) {
        return expectedType;
      }
    } else {
      if (initialNode == null) return null;
      if (!myState.isTargetTypeCalculated()) return null;
      SNode type = myState.expand(getType(initialNode));
      if (type != null && !TypesUtil.hasVariablesInside(type)) return type;
    }
    return null;
  }

  //"type affected" means that *type* of this node depends on this set
  // used to decide whether call "type will be recalculated" if node from set invalidated
  private void addDependentNodesTypeSystem(@NotNull SNode sNode, Set<SNode> nodesToDependOn, boolean typesAffected) {
    Map<SNode, Set<SNode>> dependencies = typesAffected ? myNodesToDependentNodes_A : myNodesToDependentNodes_B;
    for (SNode nodeToDependOn : nodesToDependOn) {
      if (nodeToDependOn == null) continue;
      if (sNode == nodeToDependOn) continue;
      Set<SNode> dependentNodes = dependencies.get(nodeToDependOn);
      if (dependentNodes == null) {
        dependentNodes = new THashSet<SNode>(1);
        dependencies.put(nodeToDependOn, dependentNodes);
        myNodeTypesComponent.track(nodeToDependOn);
      }
      dependentNodes.add(sNode);
    }
  }

  public void solveInequalitiesAndExpandTypes(boolean finalExpansion) {
    myState.solveInequalities();
    myState.expandAll(myNodes, finalExpansion);
    myNodes.clear();
  }

  public void addError(SNode node, IErrorReporter reporter) {
    myState.addError(node, reporter, null);
  }

  public void computeTypes(boolean refreshTypes) {
    computeTypes(myNodeTypesComponent.getNode(), refreshTypes, true, Collections.<SNode>emptyList(), true, null);
  }

  private void performActionsAfterChecking() {
    assert !myNodeTypesComponent.getTypeCheckingContext().isSingleTypeComputation();
    myNodeTypesComponent.getModelListenerManager().updateGCedNodes();
    TypeChecker.getInstance().addTypeRecalculatedListener(myNodeTypesComponent.getTypeRecalculatedListener());//method checks if already exists
    LanguageHierarchyCache.getInstance().addCacheChangeListener(myLanguageCacheListener);
  }

  protected boolean applyRulesToNode(SNode node) {
    List<Pair<InferenceRule_Runtime, IsApplicableStatus>> newRules = myTypeChecker.getRulesManager().getInferenceRules(node);
    boolean result = false;
    if (newRules != null) {
      myCurrentTypeAffected = false;
      SNode oldCheckedNode = myCurrentCheckedNode;
      myCurrentCheckedNode = node;
      for (Pair<InferenceRule_Runtime, IsApplicableStatus> rule : newRules) {
        myState.applyRuleToNode(node, rule.o1, rule.o2);
      }
      myCurrentCheckedNode = oldCheckedNode;
      result = myCurrentTypeAffected;
      myCurrentTypeAffected = false;
    }
    return result;
  }

  public void addNodeToFrontier(SNode node) {
    if (node == null || myPartlyCheckedNodes.contains(node)) return;
    myQueue.add(node);
  }

  private void addCacheDependentNodesTypesystem(SNode node) {
    myNodesDependentOnCaches.add(node);
  }
}
