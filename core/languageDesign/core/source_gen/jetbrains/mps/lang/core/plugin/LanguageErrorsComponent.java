package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.SimpleErrorReporter;
import jetbrains.mps.errors.MessageStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.event.SModelChildEvent;
import jetbrains.mps.smodel.event.SModelReferenceEvent;
import jetbrains.mps.smodel.event.SModelPropertyEvent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModelRepositoryAdapter;

public class LanguageErrorsComponent {
  private Map<SNode, Set<IErrorReporter>> myNodesToErrors = MapSequence.fromMap(new HashMap<SNode, Set<IErrorReporter>>());
  private Map<SNode, Set<SNode>> myAdditionalToErrorNodes = MapSequence.fromMap(new HashMap<SNode, Set<SNode>>());
  private Map<SNode, Set<SNode>> myErrorNodesToAdditional = MapSequence.fromMap(new HashMap<SNode, Set<SNode>>());
  private Set<SNode> myInvalidNodes = SetSequence.fromSet(new HashSet<SNode>());
  private Set<SNode> myInvalidation = SetSequence.fromSet(new HashSet<SNode>());
  private LanguageErrorsComponent.MyModelListener myModelListener = new LanguageErrorsComponent.MyModelListener();
  private LanguageErrorsComponent.MyModelRepositoryListener myModelRepositoryListener = new LanguageErrorsComponent.MyModelRepositoryListener();
  private Set<SModelDescriptor> myListenedModels;
  private boolean myCheckedRoot = false;
  private SNode myRoot;

  public LanguageErrorsComponent(SNode root) {
    myRoot = root;
    SModelRepository.getInstance().addModelRepositoryListener(myModelRepositoryListener);
  }

  public void dispose() {
    for (SModelDescriptor modelDescriptor : myListenedModels) {
      modelDescriptor.removeModelListener(myModelListener);
    }
    SModelRepository.getInstance().removeModelRepositoryListener(myModelRepositoryListener);
  }

  public void addError(SNode node, String errorString, SNode ruleNode) {
    addError(node, errorString, ruleNode, SetSequence.fromSet(new HashSet<SNode>()), new NodeMessageTarget());
  }

  public void addError(SNode node, String errorString, SNode ruleNode, Set<SNode> additionalNodes, MessageTarget messageTarget) {
    SimpleErrorReporter reporter = new SimpleErrorReporter(node, errorString, ruleNode.getModel() + "", ruleNode.getId(), MessageStatus.ERROR, messageTarget);
    this.registerError(reporter, additionalNodes, ruleNode, null);
  }

  public void addError(SNode node, String errorString, SModelDescriptor ruleModel) {
    addError(node, errorString, ruleModel, SetSequence.fromSet(new HashSet<SNode>()), new NodeMessageTarget());
  }

  public void addError(SNode node, String errorString, SModelDescriptor ruleModel, Set<SNode> additionalNodes, MessageTarget messageTarget) {
    SimpleErrorReporter reporter = new SimpleErrorReporter(node, errorString, null, null, MessageStatus.ERROR, messageTarget);
    registerError(reporter, additionalNodes, null, ruleModel);
  }

  private void registerError(SimpleErrorReporter reporter, Set<SNode> additionalNodes, SNode ruleNode, SModelDescriptor modelDescriptor) {
    SNode errorNode = reporter.getSNode();
    // error 
    Set<IErrorReporter> reporters = MapSequence.fromMap(myNodesToErrors).get(errorNode);
    if (reporters == null) {
      reporters = SetSequence.fromSet(new HashSet<IErrorReporter>());
      MapSequence.fromMap(myNodesToErrors).put(errorNode, reporters);
    }
    SetSequence.fromSet(reporters).addElement(reporter);

    // listeners 
    addModelListener(SNodeOperations.getModel(ruleNode).getModelDescriptor());
    addModelListener(modelDescriptor);
    for (SNode additional : additionalNodes) {
      addModelListener(SNodeOperations.getModel(additional).getModelDescriptor());
    }

    // additional terms to depend on 
    Set<SNode> dependencies = SetSequence.fromSetWithValues(new HashSet<SNode>(), additionalNodes);
    SetSequence.fromSet(dependencies).addElement(reporter.getSNode());
    for (SNode dependency : dependencies) {
      Set<SNode> errorNodes = MapSequence.fromMap(myAdditionalToErrorNodes).get(dependency);
      if (errorNodes == null) {
        errorNodes = SetSequence.fromSet(new HashSet<SNode>());
        MapSequence.fromMap(myAdditionalToErrorNodes).put(dependency, errorNodes);
      }
      SetSequence.fromSet(errorNodes).addElement(errorNode);
    }
    Set<SNode> additional = MapSequence.fromMap(myErrorNodesToAdditional).get(errorNode);
    if (additional == null) {
      additional = SetSequence.fromSet(new HashSet<SNode>());
      MapSequence.fromMap(myErrorNodesToAdditional).put(errorNode, additional);
    }
    SetSequence.fromSet(additional).addSequence(SetSequence.fromSet(dependencies));
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
    Set<SNode> additionals = MapSequence.fromMap(myErrorNodesToAdditional).removeKey(errorNode);
    if (additionals != null) {
      for (SNode additional : additionals) {
        Set<SNode> errors = MapSequence.fromMap(myAdditionalToErrorNodes).get(additional);
        if (errors != null) {
          SetSequence.fromSet(errors).removeElement(errorNode);
          if (SetSequence.fromSet(errors).isEmpty()) {
            MapSequence.fromMap(myAdditionalToErrorNodes).removeKey(additional);
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
    Set<SNode> frontier = SetSequence.fromSetAndArray(new HashSet<SNode>(), root);
    Set<SNode> newFrontier = SetSequence.fromSet(new HashSet<SNode>());
    while (!(SetSequence.fromSet(frontier).isEmpty())) {
      for (SNode node : frontier) {
        if (!(myCheckedRoot) || SetSequence.fromSet(myInvalidNodes).contains(node)) {
          for (AbstractConstraintsChecker checker : checkers) {
            checker.checkNode(node, this, operationContext);
          }
        }
        SetSequence.fromSet(newFrontier).addSequence(ListSequence.fromList(SNodeOperations.getChildren(node)));
      }
      frontier = newFrontier;
      newFrontier = SetSequence.fromSet(new HashSet<SNode>());
    }
    myCheckedRoot = true;
    return true;
  }

  public Set<IErrorReporter> getErrors() {
    Set<IErrorReporter> result = SetSequence.fromSet(new HashSet<IErrorReporter>());
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
    Set<SNode> nodes = MapSequence.fromMap(myAdditionalToErrorNodes).removeKey(affectedNode);
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
    if (SNodeOperations.getModel(myRoot) == model) {
      return;
    }
    for (SNode additional : SetSequence.fromSetWithValues(new HashSet<SNode>(), MapSequence.fromMap(myAdditionalToErrorNodes).keySet())) {
      if (SNodeOperations.getModel(additional) == model) {
        processNodeChange(additional);
      }
    }
  }

  public void processModelRemoved(SModelDescriptor modelDescriptor) {
    SetSequence.fromSet(myListenedModels).removeElement(modelDescriptor);
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
