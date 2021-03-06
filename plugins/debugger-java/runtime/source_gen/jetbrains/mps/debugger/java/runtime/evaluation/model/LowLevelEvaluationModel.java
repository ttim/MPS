package jetbrains.mps.debugger.java.runtime.evaluation.model;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.baseLanguage.search.AbstractClassifiersScope;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.debugger.java.runtime.DebugSession;
import java.util.List;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.LinkedListSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.DynamicReference;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.stubs.javastub.classpath.StubHelper;
import jetbrains.mps.baseLanguage.search.ReachableClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.LinkedHashMap;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.Sequence;
import com.sun.jdi.InvalidStackFrameException;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import java.util.ArrayList;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.ide.plugins.PluginManager;
import jetbrains.mps.debug.api.Debuggers;
import jetbrains.mps.debugger.java.JavaDebugger;
import java.io.File;
import com.intellij.ide.plugins.IdeaPluginDescriptorImpl;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class LowLevelEvaluationModel extends AbstractEvaluationModel {
  protected static Log log = LogFactory.getLog(LowLevelEvaluationModel.class);

  private AbstractClassifiersScope myScope;
  private boolean myVariablesInitialized = false;
  protected SNode myEvaluator;

  public LowLevelEvaluationModel(Project project, @NotNull DebugSession session, @NotNull EvaluationAuxModule module, boolean isShowContext, List<SNodePointer> nodesToImport) {
    this(project, session, module, new StackFrameContext(session.getUiState()), isShowContext, nodesToImport);
  }

  public LowLevelEvaluationModel(Project project, @NotNull DebugSession session, @NotNull EvaluationAuxModule module, EvaluationContext context, boolean isShowContext, final List<SNodePointer> nodesToImport) {
    super(project, session, module, context, isShowContext);
    ListSequence.fromList(myLanguages).addSequence(LinkedListSequence.fromLinkedList(LinkedListSequence.fromListAndArray(new LinkedList<Language>(), ModuleRepositoryFacade.getInstance().getModule("jetbrains.mps.debugger.java.evaluation", Language.class), ModuleRepositoryFacade.getInstance().getModule("jetbrains.mps.debugger.java.privateMembers", Language.class))));

    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        myAuxModule.setContextModule(myEvaluationContext.getLocationModule());
        ListSequence.fromList(myEvaluationContext.getClassPath()).union(ListSequence.fromList(getDebuggerStubPath())).visitAll(new IVisitor<String>() {
          public void visit(String it) {
            myAuxModule.addStubPath(it);
          }
        });
        myAuxModule.doUpdateModelsSet();
      }
    });

    ApplicationManager.getApplication().invokeLater(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            createNodesToShow(myAuxModel, nodesToImport);
          }
        });
      }
    });
  }

  @NotNull
  public SNode getNodeToShow() {
    return myEvaluator;
  }

  private SModel getLocationModel() {
    return myEvaluationContext.getLocationModel();
  }

  @Override
  public void updateState() {
    super.updateState();
    if (myDebugSession.getEvaluationProvider().canEvaluate()) {
      ModelAccess.instance().runWriteAction(new Runnable() {
        public void run() {
          myAuxModule.setContextModule(myEvaluationContext.getLocationModule());
          createVars();
        }
      });
    }
  }

  public void createNodesToShow(EditableSModelDescriptor auxilaryModel, List<SNodePointer> nodesToImport) {
    myEvaluator = createEvaluator(auxilaryModel);
    SModel smodel = auxilaryModel.getSModel();
    smodel.addRoot(myEvaluator);

    SModel locationModel = getLocationModel();
    if (locationModel != null) {
      LowLevelEvaluationModel.this.importStubForFqName(locationModel.getSModelFqName().toString());
    }

    createVars();
    tryToImport(nodesToImport);

    SModelOperations.validateLanguagesAndImports(smodel, false, true);
  }

  protected SNode createEvaluator(SModelDescriptor model) {
    SNode evaluatorConcept = SNodeFactoryOperations.createNewNode("jetbrains.mps.debugger.java.evaluation.structure.EvaluatorConcept", null);
    SPropertyOperations.set(evaluatorConcept, "isShowContext", "" + (myShowContext));
    AttributeOperations.createAndSetAttrbiute(SLinkOperations.getTarget(evaluatorConcept, "evaluatedStatements", true), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debugger.java.evaluation.structure.ToEvaluateAnnotation")), "jetbrains.mps.debugger.java.evaluation.structure.ToEvaluateAnnotation");
    return evaluatorConcept;
  }

  private void tryToImport(List<SNodePointer> nodesToImport) {
    List<SNode> nodes = CopyUtil.copy(ListSequence.fromList(nodesToImport).select(new ISelector<SNodePointer, SNode>() {
      public SNode select(SNodePointer it) {
        return (SNode) it.getNode();
      }
    }).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (it != null);
      }
    }).toListSequence());
    for (SNode node : ListSequence.fromList(nodes)) {
      if (node == null) {
        continue;
      }
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Expression")) {
        SNode clone = new LowLevelEvaluationModel.QuotationClass_qkk2f2_a0a0a1a1a5().createNode(node);
        transformNode(clone);
        ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(myEvaluator, "evaluatedStatements", true), "statement", true)).addElement(clone);
      } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Statement")) {
        transformNode(node);
        ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(myEvaluator, "evaluatedStatements", true), "statement", true)).addElement(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Statement"));
      }
    }
  }

  private void transformNode(SNode node) {
    // try to resolve variables 
    ListSequence.fromList(SNodeOperations.getDescendants(node, null, false, new String[]{})).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return ListSequence.fromList(SNodeOperations.getChildren(it)).isEmpty();
      }
    }).visitAll(new IVisitor<SNode>() {
      public void visit(SNode it) {
        transformNodeToProperVariableReference(it);
      }
    });
    // all links to subs -> to debugger stubs 
    for (SNode d : ListSequence.fromList(SNodeOperations.getDescendants(node, null, true, new String[]{}))) {
      replaceStubReferences(d);
    }
  }

  private void replaceStubReferences(SNode node) {
    for (SReference reference : ListSequence.fromList(SNodeOperations.getReferences(node))) {
      SModel targetModel = SNodeOperations.getModel(SLinkOperations.getTargetNode(reference));
      if (neq_qkk2f2_a0b0a0h(targetModel, myAuxModel.getSModel())) {
        SModelDescriptor scopeModel = myAuxModule.getScope().getModelDescriptor(targetModel.getSModelReference());
        if (scopeModel != null && neq_qkk2f2_a0a1a1a0a7(scopeModel.getSModel(), targetModel)) {
          String resolveInfo = SLinkOperations.getResolveInfo(reference);
          if ((resolveInfo == null || resolveInfo.length() == 0)) {
            resolveInfo = SLinkOperations.getTargetNode(reference).getResolveInfo();
          }
          node.replaceReference(reference, new DynamicReference(SLinkOperations.getRole(reference), node, scopeModel.getSModelReference(), resolveInfo));
        }
      }
    }
  }

  private void transformNodeToProperVariableReference(SNode node) {
    if ((int) ListSequence.fromList(SNodeOperations.getReferences(node)).count() == 1) {
      final SReference reference = ListSequence.fromList(SNodeOperations.getReferences(node)).first();
      if (neq_qkk2f2_a0a1a0a8(SNodeOperations.getModel(SLinkOperations.getTargetNode(reference)), myAuxModel.getSModel()) && SNodeOperations.isInstanceOf(SLinkOperations.getTargetNode(reference), "jetbrains.mps.lang.core.structure.INamedConcept")) {
        SNode matchingVar = ListSequence.fromList(SLinkOperations.getTargets(myEvaluator, "variables", true)).findFirst(new IWhereFilter<SNode>() {
          public boolean accept(SNode variable) {
            return eq_qkk2f2_a0a0a0a0a0a0a1a0a8(SPropertyOperations.getString(variable, "highLevelNodeId"), SLinkOperations.getTargetNode(reference).getSNodeId().toString());
          }
        });
        if (matchingVar == null) {
          matchingVar = ListSequence.fromList(SLinkOperations.getTargets(myEvaluator, "variables", true)).findFirst(new IWhereFilter<SNode>() {
            public boolean accept(SNode variable) {
              return eq_qkk2f2_a0a0a0a0a0a0a1a1a0a8(SPropertyOperations.getString(variable, "name"), SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTargetNode(reference), "jetbrains.mps.lang.core.structure.INamedConcept"), "name"));
            }
          });
        }
        if (matchingVar != null) {
          SNode newVariableReference = SConceptOperations.createNewNode("jetbrains.mps.debugger.java.evaluation.structure.LowLevelVariableReference", null);
          SLinkOperations.setTarget(newVariableReference, "baseVariableDeclaration", matchingVar, false);
          SNodeOperations.replaceWithAnother(node, newVariableReference);
        }
      }
    }
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

        String nodesUnitName = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(node, "jetbrains.mps.lang.traceable.structure.UnitConcept"), "virtual_getUnitName_5067982036267369911", new Class[]{SNode.class}));
        if ((nodesUnitName == null || nodesUnitName.length() == 0)) {
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

  private void importStubForFqName(String fqName) {
    SModelReference stubReference = StubHelper.uidForPackageInStubs(fqName);
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
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
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
      Map<String, VariableDescription> contextVariables = myEvaluationContext.getVariables(createClassifierType);

      Map<String, SNode> declaredVariables = MapSequence.fromMap(new LinkedHashMap<String, SNode>(16, (float) 0.75, false));
      for (SNode var : ListSequence.fromList(SLinkOperations.getTargets(evaluatorConcept, "variables", true))) {
        MapSequence.fromMap(declaredVariables).put(SPropertyOperations.getString(var, "lowLevelName"), var);
      }

      final Set<SNode> foundVars = SetSequence.fromSet(new HashSet<SNode>());
      for (String variable : SetSequence.fromSet(MapSequence.fromMap(contextVariables).keySet())) {

        String name = variable;
        SNode lowLevelVarNode = MapSequence.fromMap(declaredVariables).get(name);

        if (needUpdateVariables()) {
          // we should update variables if we are first time here or if we do not show context (i.e. in evaluation) 
          if (lowLevelVarNode == null) {
            lowLevelVarNode = SConceptOperations.createNewNode("jetbrains.mps.debugger.java.evaluation.structure.LowLevelVariable", null);
            ListSequence.fromList(SLinkOperations.getTargets(evaluatorConcept, "variables", true)).addElement(lowLevelVarNode);
            MapSequence.fromMap(declaredVariables).put(name, lowLevelVarNode);
          }
          MapSequence.fromMap(contextVariables).get(variable).updateLowLevelVariable(lowLevelVarNode);
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
        SLinkOperations.setTarget(evaluatorConcept, "contextNode", myEvaluationContext.getStaticContextType(createClassifierType), true);
        // create this 
        SLinkOperations.setTarget(evaluatorConcept, "thisNode", myEvaluationContext.getThisClassifierType(createClassifierType), true);
      }
      // todo highlight when this type or static context type are invalid 
    } catch (InvalidStackFrameException e) {
      if (log.isWarnEnabled()) {
        log.warn("InvalidStackFrameException", e);
      }
    }
    myVariablesInitialized = true;
  }

  @Override
  public List<Language> getRequiredLanguages() {
    SModelDescriptor descriptor = SNodeOperations.getModel(myEvaluationContext.getLocationNode()).getModelDescriptor();
    return ListSequence.fromList(super.getRequiredLanguages()).union(CollectionSequence.fromCollection(descriptor.getModule().getImplicitlyImportedLanguages(descriptor))).toListSequence();
  }

  private boolean needUpdateVariables() {
    return !(myVariablesInitialized) || !(myShowContext);
  }

  public LowLevelEvaluationModel copy(final boolean isShowConetxt) {
    LowLevelEvaluationModel evaluationModel;
    final SNode evaluator = myEvaluator;
    evaluationModel = new LowLevelEvaluationModel(myDebugSession.getProject(), myDebugSession, myAuxModule, isShowConetxt, ListSequence.fromList(new ArrayList<SNodePointer>())) {
      @Override
      protected SNode createEvaluator(SModelDescriptor model) {
        SNode newEvaluator = (SNode) CopyUtil.copyAndPreserveId(evaluator, true);
        SPropertyOperations.set(newEvaluator, "isShowContext", "" + (isShowConetxt));
        return newEvaluator;
      }
    };

    return evaluationModel;
  }

  public static List<String> getDebuggerStubPath() {
    PluginId apiPlugin = PluginManager.getPluginByClassName(Debuggers.class.getName());
    PluginId javaPlugin = PluginManager.getPluginByClassName(JavaDebugger.class.getName());

    List<File> paths = ListSequence.fromList(new ArrayList<File>());
    ListSequence.fromList(paths).addSequence(ListSequence.fromList(((IdeaPluginDescriptorImpl) PluginManager.getPlugin(apiPlugin)).getClassPath()));
    ListSequence.fromList(paths).addSequence(ListSequence.fromList(((IdeaPluginDescriptorImpl) PluginManager.getPlugin(javaPlugin)).getClassPath()));

    return ListSequence.fromList(paths).select(new ISelector<File, String>() {
      public String select(File it) {
        return it.getAbsolutePath();
      }
    }).toListSequence();
  }

  private static boolean neq_qkk2f2_a0b0a0h(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean neq_qkk2f2_a0a1a1a0a7(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean eq_qkk2f2_a0a0a0a0a0a0a1a0a8(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_qkk2f2_a0a0a0a0a0a0a1a1a0a8(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean neq_qkk2f2_a0a1a0a8(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  public static class QuotationClass_qkk2f2_a0a0a1a1a5 {
    public QuotationClass_qkk2f2_a0a0a1a1a5() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("expression", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
