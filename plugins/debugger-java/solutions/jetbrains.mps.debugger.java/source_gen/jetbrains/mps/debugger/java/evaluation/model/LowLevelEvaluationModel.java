package jetbrains.mps.debugger.java.evaluation.model;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import com.sun.jdi.InvalidStackFrameException;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.baseLanguage.search.AbstractClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.baseLanguage.search.ReachableClassifiersScope;
import jetbrains.mps.debug.evaluation.ui.EvaluationAuxModule;
import jetbrains.mps.debug.runtime.DebugSession;
import jetbrains.mps.internal.collections.runtime.*;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.*;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.project.StubPath;
import jetbrains.mps.reloading.EachClassPathItemVisitor;
import jetbrains.mps.reloading.FileClassPathItem;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.reloading.JarFileClassPathItem;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.stubs.javastub.classpath.StubHelper;
import jetbrains.mps.util.Condition;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class LowLevelEvaluationModel extends AbstractEvaluationModel {
  protected static Log log = LogFactory.getLog(LowLevelEvaluationModel.class);

  private AbstractClassifiersScope myScope;
  private boolean myVariablesInitialized = false;

  public LowLevelEvaluationModel(Project project, @NotNull DebugSession session, @NotNull EvaluationAuxModule module, boolean isShowContext) {
    this(project, session, module, new StackFrameContext(session.getUiState()), isShowContext);
  }

  public LowLevelEvaluationModel(Project project, @NotNull DebugSession session, @NotNull EvaluationAuxModule module, EvaluationContext context, boolean isShowContext) {
    super(project, session, module, context, isShowContext);

    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        IClassPathItem classPath = myEvaluationContext.getClassPathItem();
        final Set<StubPath> pathsToAdd = SetSequence.fromSet(new HashSet<StubPath>());
        classPath.accept(new EachClassPathItemVisitor() {
          @Override
          public void visit(JarFileClassPathItem item) {
            String path = item.getFile().getAbsolutePath();
            StubPath stubPath = myAuxModule.addStubPath(path);
            if (stubPath != null) {
              SetSequence.fromSet(pathsToAdd).addElement(stubPath);
            }
          }

          @Override
          public void visit(FileClassPathItem item) {
            String path = item.getPath();
            StubPath stubPath = myAuxModule.addStubPath(path);
            if (stubPath != null) {
              SetSequence.fromSet(pathsToAdd).addElement(stubPath);
            }
          }
        });
        myAuxModule.loadNewModels();

        createNodesToShow(myAuxModel);
      }
    });
  }

  @Nullable
  private SNode createClassifierType(final String unitFqName) {
    int lastDot = unitFqName.lastIndexOf(".");
    if (lastDot > 0) {
      String unitPackage = unitFqName.substring(0, lastDot);
      importStubForFqName(unitPackage);
    }
    List<SNode> classifiers = myScope.getNodes(new Condition<SNode>() {
      public boolean met(@NotNull SNode node) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.traceable.structure.UnitConcept"))) {
          return false;
        }

        String nodesUnitName = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.cast(node, "jetbrains.mps.lang.traceable.structure.UnitConcept"), "jetbrains.mps.lang.traceable.structure.UnitConcept"), "virtual_getUnitName_5067982036267369911", new Class[]{SNode.class}));
        if (StringUtils.isEmpty(nodesUnitName)) {
          return false;
        }
        return nodesUnitName.equals(unitFqName);
      }
    });
    if (classifiers.isEmpty()) {
      return null;
    }
    SNode classifierType = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
    SLinkOperations.setTarget(classifierType, "classifier", SNodeOperations.cast(classifiers.get(0), "jetbrains.mps.baseLanguage.structure.Classifier"), false);
    return classifierType;
  }

  @NotNull
  public SNode getNodeToShow() {
    return myEvaluator;
  }

  @NotNull
  public SNode getRootToShow() {
    return myEvaluator;
  }

  @Override
  public void updateState() {
    super.updateState();
    if (myDebugSession.getEvaluationProvider().canEvaluate()) {
      createVars();
    }
  }

  @Override
  public void createNodesToShow(EditableSModelDescriptor model) {
    super.createNodesToShow(model);

    SModel locationModel = getLocationModel();
    if (locationModel != null) {
      LowLevelEvaluationModel.this.importStubForFqName(locationModel.getSModelFqName().toString());
    }

    createVars();
  }

  @Override
  protected SNode createEvaluator(SModelDescriptor model) {
    SNode evaluatorConcept = super.createEvaluator(model);
    AttributeOperations.createAndSetAttrbiute(SLinkOperations.getTarget(evaluatorConcept, "evaluatedStatements", true), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debug.evaluation.structure.ToEvaluateAnnotation")), "jetbrains.mps.debug.evaluation.structure.ToEvaluateAnnotation");
    return evaluatorConcept;
  }

  private void importStubForFqName(String fqName) {
    SModelReference stubReference = ((EvaluationAuxModule.JAVA_STUBS ?
      StubHelper.uidForPackageInStubs(fqName) :
      StubHelper.uidForPackageInStubs(fqName, "debugger_java", myAuxModule.getModuleReference(), false)
    ));
    if (stubReference == null) {
      if (log.isErrorEnabled()) {
        log.error("Stub for " + fqName + " was not found.");
      }
      return;
    }
    myAuxModel.getSModel().addModelImport(stubReference, false);
  }

  private void createVars() {
    if (myScope == null) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          // creating scope 
          myScope = new ReachableClassifiersScope(myAuxModel.getSModel(), IClassifiersSearchScope.CLASSIFFIER, getModule().getScope());
        }
      });
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        fillVariables();
      }
    });
  }

  private void fillVariables() {
    SNode evaluatorConcept = myEvaluator;
    try {
      _FunctionTypes._return_P1_E0<? extends SNode, ? super String> createClassifierType = new _FunctionTypes._return_P1_E0<SNode, String>() {
        public SNode invoke(String name) {
          return createClassifierType(name);
        }
      };
      Map<String, SNode> contextVariables = myEvaluationContext.getVariables(createClassifierType);

      Map<String, SNode> declaredVariables = MapSequence.fromMap(new LinkedHashMap<String, SNode>(16, (float) 0.75, false));
      for (SNode var : ListSequence.fromList(SLinkOperations.getTargets(evaluatorConcept, "variables", true))) {
        MapSequence.fromMap(declaredVariables).put(SPropertyOperations.getString(var, "name"), var);
      }

      final Set<SNode> foundVars = SetSequence.fromSet(new HashSet<SNode>());
      for (String variable : SetSequence.fromSet(MapSequence.fromMap(contextVariables).keySet())) {

        String name = variable;
        SNode lowLevelVarNode = MapSequence.fromMap(declaredVariables).get(name);

        if (needUpdateVariables()) {
          // we should update variables if we are first time here or if we do not show context (i.e. in evaluation) 
          if (lowLevelVarNode == null) {
            lowLevelVarNode = SConceptOperations.createNewNode("jetbrains.mps.debug.evaluation.structure.LowLevelVariable", null);
            SPropertyOperations.set(lowLevelVarNode, "name", name);
            ListSequence.fromList(SLinkOperations.getTargets(evaluatorConcept, "variables", true)).addElement(lowLevelVarNode);
            MapSequence.fromMap(declaredVariables).put(name, lowLevelVarNode);
          }
          SNode deducedType = MapSequence.fromMap(contextVariables).get(name);
          if (deducedType == null) {
            if (log.isErrorEnabled()) {
              log.error("Could not deduce type for variable " + name);
            }
            continue;
          }
          SLinkOperations.setTarget(lowLevelVarNode, "type", deducedType, true);
        }

        SetSequence.fromSet(foundVars).addElement(lowLevelVarNode);
      }

      // now mark vars which are currently out of scope 
      Sequence.fromIterable(MapSequence.fromMap(declaredVariables).values()).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          SPropertyOperations.set(it, "isOutOfScope", "" + (!(SetSequence.fromSet(foundVars).contains(it))));
        }
      });

      if (needUpdateVariables()) {
        // create static context type 
        SLinkOperations.setTarget(evaluatorConcept, "staticContextType", myEvaluationContext.getStaticContextType(createClassifierType), true);
        // create this 
        SLinkOperations.setTarget(evaluatorConcept, "thisType", myEvaluationContext.getThisClassifierType(createClassifierType), true);
      }
      // todo highlight when this type or static context type are invalid 
    } catch (InvalidStackFrameException e) {
      if (log.isWarnEnabled()) {
        log.warn("InvalidStackFrameException", e);
      }
    }
    myVariablesInitialized = true;
  }

  private boolean needUpdateVariables() {
    return !(myVariablesInitialized) || !(myShowContext);
  }

  public LowLevelEvaluationModel copy(final boolean isShowConetxt) {
    LowLevelEvaluationModel evaluationModel;
    final SNode evaluator = myEvaluator;
    evaluationModel = new LowLevelEvaluationModel(myDebugSession.getProject(), myDebugSession, myAuxModule, isShowConetxt) {
      @Override
      protected SNode createEvaluator(SModelDescriptor model) {
        SNode newEvaluator = (SNode) CopyUtil.copyAndPreserveId(evaluator, true);
        SPropertyOperations.set(newEvaluator, "isShowContext", "" + (isShowConetxt));
        return newEvaluator;
      }
    };

    return evaluationModel;
  }
}
