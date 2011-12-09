package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.Solution;
import java.util.Set;
import jetbrains.mps.smodel.MPSModuleOwner;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.navigation.NavigationSupport;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.ide.navigation.NavigationProvider;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class GoByCurrentReference_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoByCurrentReference_Action.class);

  public GoByCurrentReference_Action() {
    super("Declaration", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    SNode targetNode = ((EditorCell) MapSequence.fromMap(_params).get("cell")).getSNodeWRTReference();
    if (targetNode == null) {
      return false;
    }
    if (targetNode == ((EditorCell) MapSequence.fromMap(_params).get("cell")).getSNode()) {
      return false;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoByCurrentReference", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("cell", event.getData(MPSEditorDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("cell") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SNode targetNode = ((EditorCell) MapSequence.fromMap(_params).get("cell")).getSNodeWRTReference();
      String targetSter = SNodeOperations.getModel(targetNode).getStereotype();
      String stubSter = SModelStereotype.getStubStereotypeForId(LanguageID.JAVA);

      if (neq_1m2c1e_a0e0a0d(stubSter, targetSter)) {
        GoByCurrentReference_Action.this.open(targetNode, _params);
      } else {
        SNode node = ((EditorCell) MapSequence.fromMap(_params).get("cell")).getSNodeWRTReference();
        SModel model = node.getModel();
        IModule module = model.getModelDescriptor().getModule();
        assert module != null;
        if (module instanceof Solution && ((Solution) module).isStub()) {
          Set<MPSModuleOwner> owners = MPSModuleRepository.getInstance().getOwners(module);
          assert !(owners.isEmpty());
          module = ((IModule) owners.iterator().next());
        } else if (module instanceof Generator) {
          module = ((Generator) module).getSourceLanguage();
        } else if (module.getDescriptorFile() == null) {
          assert false;
        }
        final String modulePath = module.getDescriptorFile().getPath();

        new Thread() {
          public void run() {
            // todo command here is a must for read action. Without it, openNode will be deadlocked for now 
            ModelAccess.instance().runWriteInEDT(new Runnable() {
              public void run() {
                if (!(GoByCurrentReference_Action.this.navigateToJavaStub(modulePath, targetNode, _params))) {
                  GoByCurrentReference_Action.this.open(targetNode, _params);
                }
              }
            });
          }
        }.start();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoByCurrentReference", t);
      }
    }
  }

  private void open(SNode targetNode, final Map<String, Object> _params) {
    NavigationSupport.getInstance().openNode(((IOperationContext) MapSequence.fromMap(_params).get("context")), targetNode, true, !(targetNode.isRoot()));
  }

  private boolean navigateToJavaStub(@NotNull String projectPath, SNode targetNode, final Map<String, Object> _params) {
    SModelReference ref = SNodeOperations.getModel(targetNode).getSModelReference();
    boolean isClassifier = SNodeOperations.isInstanceOf(targetNode, "jetbrains.mps.baseLanguage.structure.Classifier");
    boolean isConstructor = SNodeOperations.isInstanceOf(targetNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
    boolean isMethod = SNodeOperations.isInstanceOf(targetNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration") && SNodeOperations.isInstanceOf(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.Classifier");
    boolean isField = (SNodeOperations.isInstanceOf(targetNode, "jetbrains.mps.baseLanguage.structure.FieldDeclaration") || SNodeOperations.isInstanceOf(targetNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration")) && SNodeOperations.isInstanceOf(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.Classifier");
    if (!(isClassifier || isConstructor || isMethod || isField)) {
      return false;
    }
    if (isClassifier) {
      String fqName = ref.getLongName() + "." + SPropertyOperations.getString(SNodeOperations.cast(targetNode, "jetbrains.mps.baseLanguage.structure.Classifier"), "name");
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openClass(projectPath, fqName)) {
          return true;
        }
      }
    } else if (isConstructor) {
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref, _params);
      int paramCount = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(targetNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "parameter", true)).count();
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openClass(projectPath, classifierName)) {
          if (np.openConstructor(projectPath, classifierName, paramCount)) {
            return true;
          }
        }
      }
    } else if (isMethod) {
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref, _params);
      SNode method = SNodeOperations.cast(targetNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openMethod(projectPath, classifierName, SPropertyOperations.getString(method, "name"), ListSequence.fromList(SLinkOperations.getTargets(method, "parameter", true)).count())) {
          return true;
        }
      }
    } else {
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref, _params);
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openField(projectPath, classifierName, targetNode.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  private String getClassifierName(SNode targetNode, SModelReference ref, final Map<String, Object> _params) {
    SNode classifier = SNodeOperations.cast(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.Classifier");
    assert classifier != null;
    return ref.getLongName() + "." + SPropertyOperations.getString(classifier, "name");
  }

  private static boolean neq_1m2c1e_a0e0a0d(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }
}
