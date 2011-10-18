package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.errors.IErrorReporter;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.errors.SimpleErrorReporter;
import jetbrains.mps.errors.MessageStatus;
import jetbrains.mps.smodel.IOperationContext;
import java.util.HashSet;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.event.SModelChildEvent;
import jetbrains.mps.smodel.event.SModelReferenceEvent;
import jetbrains.mps.smodel.event.SModelPropertyEvent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.AbstractNodesReadListener;
import jetbrains.mps.smodel.NodeReadEventsCaster;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModelRepositoryAdapter;

public class LanguageErrorsComponent {
  private Map<SNode, Set<IErrorReporter>> myNodesToErrors = new THashMap<SNode, Set<IErrorReporter>>();
  private Map<SNode, Set<SNode>> myDependenciesToNodes = new THashMap<SNode, Set<SNode>>();
  private Map<SNode, Set<SNode>> myNodesToDependecies = new THashMap<SNode, Set<SNode>>();
  private Set<SNode> myInvalidNodes = new THashSet<SNode>();
  private Set<SNode> myInvalidation = new THashSet<SNode>();
  private LanguageErrorsComponent.MyModelListener myModelListener = new LanguageErrorsComponent.MyModelListener();
  private LanguageErrorsComponent.MyModelRepositoryListener myModelRepositoryListener = new LanguageErrorsComponent.MyModelRepositoryListener();
  private Set<SModelDescriptor> myListenedModels = new THashSet<SModelDescriptor>();
  private boolean myCheckedRoot = false;
  private SNode myCurrentNode = null;
  private SNode myRoot;

  public LanguageErrorsComponent(SNode root) {
    myRoot = root;
    SModelRepository.getInstance().addModelRepositoryListener(myModelRepositoryListener);
  }

  public void dispose() {
    this.removeModelListener();
    SModelRepository.getInstance().removeModelRepositoryListener(myModelRepositoryListener);
  }

  private void removeModelListener() {
    for (SModelDescriptor modelDescriptor : myListenedModels) {
      modelDescriptor.removeModelListener(myModelListener);
    }
    SetSequence.fromSet(myListenedModels).clear();
  }

  public void addDependency(SNode dependency) {
    if (myCurrentNode != null) {
      addDependency(myCurrentNode, dependency);
    }
  }

  public void addDependency(SNode currentNode, SNode dependency) {
    if (dependency == null) {
      return;
    }
    Set<SNode> errorNodes = MapSequence.fromMap(myDependenciesToNodes).get(dependency);
    if (errorNodes == null) {
      errorNodes = new THashSet<SNode>(1);
      MapSequence.fromMap(myDependenciesToNodes).put(dependency, errorNodes);
    }
    SetSequence.fromSet(errorNodes).addElement(currentNode);
    Set<SNode> additional = MapSequence.fromMap(myNodesToDependecies).get(currentNode);
    if (additional == null) {
      additional = new THashSet<SNode>(1);
      MapSequence.fromMap(myNodesToDependecies).put(currentNode, additional);
    }
    SetSequence.fromSet(additional).addElement(dependency);
    addModelListener(SNodeOperations.getModel(dependency).getModelDescriptor());
  }

  public void addError(SNode node, String errorString, SNode ruleNode) {
    for (SNode anc : ListSequence.fromList(SNodeOperations.getAncestors(node, null, false))) {
      addDependency(anc);
    }
    addError(node, errorString, ruleNode, new NodeMessageTarget());
  }

  public void addError(SNode errorNode, String errorString, SNode ruleNode, MessageTarget messageTarget) {
    if (BaseConcept_Behavior.call_getMetaLevel_3981318653438234726(SNodeOperations.cast(errorNode, "jetbrains.mps.lang.core.structure.BaseConcept")) != 0) {
      return;
    }
    String id = (ruleNode == null ?
      null :
      ruleNode.getId()
    );
    String modelId = (ruleNode == null ?
      null :
      ruleNode.getModel() + ""
    );
    SimpleErrorReporter reporter = new SimpleErrorReporter(errorNode, errorString, modelId, id, MessageStatus.ERROR, messageTarget);
    Set<IErrorReporter> reporters = MapSequence.fromMap(myNodesToErrors).get(errorNode);
    if (reporters == null) {
      reporters = new THashSet<IErrorReporter>(1);
      MapSequence.fromMap(myNodesToErrors).put(errorNode, reporters);
    }
    SetSequence.fromSet(reporters).addElement(reporter);
  }

  private void addModelListener(SModelDescriptor modelDescriptor) {
    if (modelDescriptor == null) {
      return;
    }
    if (!(SetSequence.fromSet(myListenedModels).contains(modelDescriptor))) {
      modelDescriptor.addModelListener(myModelListener);
      SetSequence.fromSet(myListenedModels).addElement(modelDescriptor);
    }
  }

  private void invalidate(SNode errorNode) {
    SetSequence.fromSet(myInvalidNodes).addElement(errorNode);
    MapSequence.fromMap(myNodesToErrors).removeKey(errorNode);
    Set<SNode> additionals = MapSequence.fromMap(myNodesToDependecies).removeKey(errorNode);
    if (additionals != null) {
      for (SNode additional : additionals) {
        Set<SNode> errors = MapSequence.fromMap(myDependenciesToNodes).get(additional);
        if (errors != null) {
          SetSequence.fromSet(errors).removeElement(errorNode);
          if (SetSequence.fromSet(errors).isEmpty()) {
            MapSequence.fromMap(myDependenciesToNodes).removeKey(additional);
          }
        }
      }
    }

  }

  public boolean check(SNode root, Set<AbstractConstraintsChecker> checkers, IOperationContext operationContext) {
    // returns whether state has been changed after check 
    invalidate();
    if (myCheckedRoot && SetSequence.fromSet(myInvalidNodes).isEmpty()) {
      return false;
    }
    Set<SNode> frontier = new HashSet<SNode>(1);
    SetSequence.fromSet(frontier).addElement(root);
    Set<SNode> newFrontier = new HashSet<SNode>(1);
    IScope scope = SNodeOperations.getModel(root).getModelDescriptor().getModule().getScope();
    while (!(SetSequence.fromSet(frontier).isEmpty())) {
      for (SNode node : frontier) {
        if (!(myCheckedRoot) || SetSequence.fromSet(myInvalidNodes).contains(node)) {
          try {
            myCurrentNode = node;
            addDependency(node);
            for (AbstractConstraintsChecker checker : checkers) {
              checker.checkNode(node, this, operationContext, scope);
            }
          } finally {
            myCurrentNode = null;
            SetSequence.fromSet(myInvalidNodes).removeElement(node);
          }
        }
        SetSequence.fromSet(newFrontier).addSequence(ListSequence.fromList(SNodeOperations.getChildren(node)));
      }
      frontier = newFrontier;
      newFrontier = new HashSet<SNode>(1);
    }
    myCheckedRoot = true;
    return true;
  }

  public Set<IErrorReporter> getErrors() {
    Set<IErrorReporter> result = new THashSet<IErrorReporter>(1);
    for (SNode errorNode : MapSequence.fromMap(myNodesToErrors).keySet()) {
      SetSequence.fromSet(result).addSequence(SetSequence.fromSet(MapSequence.fromMap(myNodesToErrors).get(errorNode)));
    }
    return result;
  }

  public void invalidate() {
    if (SetSequence.fromSet(myInvalidation).isEmpty()) {
      return;
    }
    for (SNode toInvalidate : myInvalidation) {
      processNodeChange(toInvalidate);
    }
    SetSequence.fromSet(myInvalidation).clear();
  }

  private void processNodeChange(SNode affectedNode) {
    Set<SNode> nodes = MapSequence.fromMap(myDependenciesToNodes).removeKey(affectedNode);
    if (nodes != null) {
      for (SNode errorNode : nodes) {
        invalidate(errorNode);
      }
    }
  }

  public void processEvent(SModelChildEvent event) {
    SetSequence.fromSet(myInvalidation).addElement(event.getParent());
    if (event.isRemoved()) {
      SetSequence.fromSet(myInvalidation).addElement(event.getChild());
    }
  }

  public void processEvent(SModelReferenceEvent event) {
    SetSequence.fromSet(myInvalidation).addElement(event.getReference().getSourceNode());
  }

  public void processEvent(SModelPropertyEvent event) {
    SetSequence.fromSet(myInvalidation).addElement(event.getNode());
  }

  public void processBeforeModelDisposed(SModel model) {
    if (!(myRoot.shouldHaveBeenDisposed()) && SNodeOperations.getModel(myRoot) == model) {
      return;
    }
    for (SNode additional : new HashSet<SNode>(MapSequence.fromMap(myDependenciesToNodes).keySet())) {
      if (additional.shouldHaveBeenDisposed() || SNodeOperations.getModel(additional) == model) {
        processNodeChange(additional);
      }
    }
  }

  public void processModelRemoved(SModelDescriptor modelDescriptor) {
    SetSequence.fromSet(myListenedModels).removeElement(modelDescriptor);
  }

  public void clear() {
    myCheckedRoot = false;
    SetSequence.fromSet(myInvalidation).clear();
    SetSequence.fromSet(myInvalidNodes).clear();
    myCurrentNode = null;
    MapSequence.fromMap(myDependenciesToNodes).clear();
    MapSequence.fromMap(myNodesToDependecies).clear();
    MapSequence.fromMap(myNodesToErrors).clear();
    removeModelListener();
  }

  public <Result> Result runCheckingAction(_FunctionTypes._return_P0_E0<? extends Result> action) {
    final Set<SNode> accessedNodes = new THashSet<SNode>();
    final Object[] result = new Object[1];
    try {
      AbstractNodesReadListener listener = new AbstractNodesReadListener() {
        public void nodeUnclassifiedReadAccess(SNode node) {
          SetSequence.fromSet(accessedNodes).addElement(node);
        }

        public void nodePropertyReadAccess(SNode node, String name, String value) {
          SetSequence.fromSet(accessedNodes).addElement(node);
        }

        public void nodeReferentReadAccess(SNode node, String role, SNode referent) {
          SetSequence.fromSet(accessedNodes).addElement(node);
          SetSequence.fromSet(accessedNodes).addElement(referent);
        }

        public void nodeChildReadAccess(SNode node, String role, SNode child) {
          SetSequence.fromSet(accessedNodes).addElement(node);
          SetSequence.fromSet(accessedNodes).addElement(child);
        }
      };
      NodeReadEventsCaster.setNodesReadListener(listener);
      result[0] = action.invoke();
    } finally {
      NodeReadEventsCaster.removeNodesReadListener();
    }
    for (SNode accessedNode : accessedNodes) {
      addDependency(accessedNode);
    }
    return (Result) result[0];
  }

  public class MyModelListener extends SModelAdapter {
    public MyModelListener() {
    }

    public void beforeModelDisposed(SModel model) {
      processBeforeModelDisposed(model);
    }

    public void referenceRemoved(SModelReferenceEvent event) {
      processEvent(event);
    }

    public void referenceAdded(SModelReferenceEvent event) {
      processEvent(event);
    }

    public void childRemoved(SModelChildEvent event) {
      processEvent(event);
    }

    public void childAdded(SModelChildEvent event) {
      processEvent(event);
    }

    public void propertyChanged(SModelPropertyEvent event) {
      processEvent(event);
    }
  }

  public class MyModelRepositoryListener extends SModelRepositoryAdapter {
    public MyModelRepositoryListener() {
    }

    public void modelRemoved(SModelDescriptor descriptor) {
      processModelRemoved(descriptor);
    }

    public void modelDeleted(SModelDescriptor descriptor) {
      processModelRemoved(descriptor);
    }
  }
}
