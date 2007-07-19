package jetbrains.mps.helgins.inference;

import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.helgins.runtime.RuntimeSupport;
import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.helgins.structure.*;
import jetbrains.mps.ide.IStatus;
import jetbrains.mps.ide.Status;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.NodeReadAccessCaster;
import jetbrains.mps.project.ApplicationComponents;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.refactoring.CopyUtil;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.event.*;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.Mapper;
import jetbrains.mps.util.Pair;
import jetbrains.mps.util.WeakSet;
import jetbrains.mps.util.annotation.Hack;
import jetbrains.mps.util.annotation.UseCarefully;
import jetbrains.mps.generator.template.Statistics;
import jetbrains.mpswiki.queryLanguage.evaluator.ConditionMatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.commons.AnalyzerAdapter;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 06.03.2006
 * Time: 16:47:20
 * To change this template use File | Settings | File Templates.
 */
public class TypeChecker {
  private static final Logger LOG = Logger.getLogger(TypeChecker.class);

  private static final String RUNTIME_TYPES = "$runtimeTypes$";
  private static final String TYPES_MODEL_NAME = "typesModel";
  public static final SModelUID TYPES_MODEL_UID = new SModelUID(TYPES_MODEL_NAME, RUNTIME_TYPES);
  private static final ModelOwner RUNTIME_TYPES_MODEL_OWNER = new ModelOwner() {};

  private Set<SNode> myCheckedRoots = new WeakSet<SNode>();

  //todo Cyril, you don't clear this map during model removal. So it leaks memory. Do it somewhere
  //todo I temporarily added clear invocation in GeneratorManager 
  private Map<SNode, WeakSet<SNode>> myNodesToDependentRoots = new WeakHashMap<SNode, WeakSet<SNode>>();

  private MySModelCommandListener myListener = new MySModelCommandListener();

  private SubtypingManager mySubtypingManager;
  private RuntimeSupport myRuntimeSupport;
  private RulesManager myRulesManager;
  private INodeTypesComponent myCurrentTypesComponent = null;

  private MPSProject myProject;

  public TypeChecker() {
    mySubtypingManager = new SubtypingManager(this);
    myRuntimeSupport = new RuntimeSupport(this);
    myRulesManager = new RulesManager(this);
  }

  @Hack
  @Deprecated
  public void setProject(MPSProject project) {
    myProject = project;
  }

  public MPSProject getProject() {
    return myProject;
  }

  public static TypeChecker getInstance() {
    return ApplicationComponents.getInstance().getComponent(TypeChecker.class);
  }

  public Map<SNode, SNode> getMainContext() {
    return myCurrentTypesComponent.getMainContext();
  }

  public EquationManager getEquationManager() {
    if (myCurrentTypesComponent == null) return new EquationManager(this, null);
    return myCurrentTypesComponent.getEquationManager();
  }

  public SubtypingManager getSubtypingManager() {
    return mySubtypingManager;
  }


  public RuntimeSupport getRuntimeSupport() {
    return myRuntimeSupport;
  }

  public RulesManager getRulesManager() {
    return myRulesManager;
  }

  @UseCarefully
  public void setCurrentTypesComponent(INodeTypesComponent component) {
    myCurrentTypesComponent = component;
  }

  @UseCarefully
  public void clearCurrentTypesComponent() {
    myCurrentTypesComponent = null;
  }

  public void clearForReload() {
    myNodesToDependentRoots.clear();

    myRulesManager.clear();
    mySubtypingManager.clearSupertypesCache();
    myCurrentTypesComponent = null;
    myCheckedRoots.clear();
  }

  public void reportTypeError(SNode nodeWithError, String errorString) {
    myCurrentTypesComponent.reportTypeError(nodeWithError, errorString);
  }

  public void reportTypeError(SNode nodeWithError, IErrorReporter errorReporter) {
    myCurrentTypesComponent.reportTypeError(nodeWithError, errorReporter);
  }

  public static SNode asType(Object o) {
    if (o instanceof SNode) {
      return (SNode) o;
    }
    if (o instanceof BaseAdapter) {
      return ((BaseAdapter)o).getNode();
    }
    return null;
  }

  public boolean isCheckedRoot(SNode node) {
    return myCheckedRoots.contains(node);
  }

  public void checkRoot(SNode node) {
    assert node.isRoot();

    try {
      MyReadAccessListener listener = new MyReadAccessListener();
      NodeReadAccessCaster.setNodeAccessListener(listener);
      NodeTypesComponentsRepository.getInstance().createNodeTypesComponent(node).computeTypes();
      myCheckedRoots.add(node);

      for (SNode nodeToDependOn : listener.getNodesToDependOn()) {
        WeakSet<SNode> dependentRoots = myNodesToDependentRoots.get(nodeToDependOn);
        if (dependentRoots == null) {
          dependentRoots = new WeakSet<SNode>();
          myNodesToDependentRoots.put(nodeToDependOn, dependentRoots);
        }
        dependentRoots.add(node);
      }

      SModel model = node.getModel();
      model.removeSModelCommandListener(myListener);
      model.removeSModelListener(myListener);
      model.addSModelCommandListener(myListener);
      model.addSModelListener(myListener);
    } finally {
      NodeReadAccessCaster.removeNodeAccessListener();
    }
  }

  // we assume that type of a node does not depend on its ancestors
  @Hack
  @Nullable
  public SNode hackTypeOf(SNode node) {
    return getTypeOf(node);
  }

  public void markAsChecked(SNode node) {
    myCheckedRoots.add(node);
  }

  @Nullable
  public SNode getTypeOf(SNode node) {
    if (node == null) return null;
    SNode containingRoot = node.getContainingRoot();
    if (containingRoot == null) return null;
    if (!myCheckedRoots.contains(containingRoot) || NodeTypesComponentsRepository.getInstance().
            getNodeTypesComponent(node.getContainingRoot()) == null) {
      checkRoot(containingRoot);
    }
    return getTypeDontCheck(node);
  }

  @Nullable
  public SNode getTypeDontCheck(SNode node) {
    if (node == null) return null;
    INodeTypesComponent nodeTypesComponent = NodeTypesComponentsRepository.getInstance().
            getNodeTypesComponent(node.getContainingRoot());
    if (nodeTypesComponent == null) return null;
    return nodeTypesComponent.getType(node);
  }


  public SModelUID getRuntimeTypesModelUID() {
    return TYPES_MODEL_UID;
  }

  public SModel getRuntimeTypesModel() {
    SModelUID uid = getRuntimeTypesModelUID();
    SModelDescriptor modelDescriptor = (SModelRepository.getInstance().getModelDescriptor(uid));

    if (modelDescriptor == null) { // then create and register model descriptor
      modelDescriptor = new DefaultSModelDescriptor(IModelRootManager.NULL_MANAGER, null, uid) {
        {
          mySModel = new SModel(getModelUID());
          mySModel.setLoading(true);
        }

        public void save() {
          //do-nothing
        }
      };
      SModelRepository.getInstance().registerModelDescriptor(modelDescriptor, RUNTIME_TYPES_MODEL_OWNER);
    }

    return modelDescriptor.getSModel();
  }

  @Hack
  public void markUnchecked(SNode containingRoot) {
    myCheckedRoots.remove(containingRoot);
  }

  public INodeTypesComponent getCurrentTypesComponent() {
    return myCurrentTypesComponent;
  }

  public String getTypeErrorDontCheck(SNode node) {
    return NodeTypesComponentsRepository.getInstance().createNodeTypesComponent(node.getContainingRoot()).getError(node);
  }

  private static class MyReadAccessListener implements INodeReadAccessListener {
    protected HashSet<SNode> myNodesToDependOn = new HashSet<SNode>();
    private final Object myLock = new Object();

    public void readAccess(SNode node) {
      synchronized(myLock) {
        myNodesToDependOn.add(node);
      }
    }

    public Set<SNode> getNodesToDependOn() {
      synchronized(myLock) {
        return new HashSet<SNode>(myNodesToDependOn);
      }
    }
  }

  private class MySModelCommandListener extends SModelAdapter implements SModelCommandListener {
    private SModelEventVisitor myVisitor = new SModelEventVisitor() {
      public void visitRootEvent(SModelRootEvent event) {
        mySubtypingManager.clearSupertypesCache();
        Set<SNode> dependentRoots = myNodesToDependentRoots.get(event.getRoot());
        if (dependentRoots != null) {
          myCheckedRoots.removeAll(dependentRoots);
        }
        myCheckedRoots.remove(event.getRoot());
      }

      public void visitChildEvent(SModelChildEvent event) {
        mySubtypingManager.clearSupertypesCache();
        Set<SNode> dependentRoots = myNodesToDependentRoots.get(event.getParent());
        if (dependentRoots != null) {
          myCheckedRoots.removeAll(dependentRoots);
        }
        myCheckedRoots.remove(event.getParent().getContainingRoot());
      }

      public void visitPropertyEvent(SModelPropertyEvent event) {
        /*  Set<SNode> dependentRoots = myNodesToDependentRoots.get(event.getNode());
        if (dependentRoots != null) {
          myCheckedRoots.removeAll(dependentRoots);
        }
        myCheckedRoots.remove(event.getNode().getContainingRoot());*/
      }

      public void visitReferenceEvent(SModelReferenceEvent event) {
        mySubtypingManager.clearSupertypesCache();
        Set<SNode> dependentRoots = myNodesToDependentRoots.get(event.getReference().getSourceNode());
        if (dependentRoots != null) {
          myCheckedRoots.removeAll(dependentRoots);
        }
        myCheckedRoots.remove(event.getReference().getSourceNode().getContainingRoot());
      }
    };

    public void modelChangedInCommand(List<SModelEvent> events) {
      for (SModelEvent event : events) {
        event.accept(myVisitor);
      }
    }

    public void eventFired(SModelEvent event) {
      if (CommandProcessor.instance().isInsideCommand()) return;
      event.accept(myVisitor);
    }
  }

}
