package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.smodel.SModel;
import java.util.Set;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.MPSModuleOwner;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.ide.navigation.NavigationProvider;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class GoByCurrentReference_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoByCurrentReference_Action.class);

  private EditorComponent editorComponent;
  private EditorCell cell;
  private IOperationContext context;
  private SNode node;

  public GoByCurrentReference_Action() {
    super("Go by Current Reference", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    SNode targetNode = GoByCurrentReference_Action.this.cell.getSNodeWRTReference();
    if (targetNode == null) {
      return false;
    }
    if (targetNode == GoByCurrentReference_Action.this.cell.getSNode()) {
      return false;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoByCurrentReference", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.editorComponent = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editorComponent == null) {
      return false;
    }
    this.cell = event.getData(MPSDataKeys.EDITOR_CELL);
    if (this.cell == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.node = event.getData(MPSDataKeys.NODE);
    if (this.node == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final SNode targetNode = GoByCurrentReference_Action.this.cell.getSNodeWRTReference();
      String targetSter = SNodeOperations.getModel(targetNode).getStereotype();
      String stubSter = SModelStereotype.getStubStereotypeForId(LanguageID.JAVA);

      if (neq_1m2c1e_a0e0a0e(stubSter, targetSter)) {
        GoByCurrentReference_Action.this.open(targetNode);
      } else {
        SNode node = GoByCurrentReference_Action.this.cell.getSNodeWRTReference();
        SModel model = node.getModel();
        Set<IModule> modules = model.getModelDescriptor().getModules();
        assert !(modules.isEmpty());
        IModule module = modules.iterator().next();
        if (module instanceof Solution && ((Solution) module).isStub()) {
          Set<MPSModuleOwner> owners = MPSModuleRepository.getInstance().getOwners(module);
          assert !(owners.isEmpty());
          module = ((IModule) owners.iterator().next());
        } else if (module instanceof Generator) {
          module = ((Generator) module).getSourceLanguage();
        }
        final String modulePath = module.getDescriptorFile().getAbsolutePath();

        new Thread() {
          public void run() {
            // todo command here is a must for read action. Without it, openNode will be deadlocked for now 
            ModelAccess.instance().runWriteInEDT(new Runnable() {
              public void run() {
                if (!(GoByCurrentReference_Action.this.navigateToJavaStub(modulePath, targetNode))) {
                  GoByCurrentReference_Action.this.open(targetNode);
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

  private void open(SNode targetNode) {
    GoByCurrentReference_Action.this.context.getComponent(MPSEditorOpener.class).openNode(targetNode, GoByCurrentReference_Action.this.context, true, !(targetNode.isRoot()));
  }

  private boolean navigateToJavaStub(@NotNull String projectPath, SNode targetNode) {
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
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref);
      int paramCount = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(targetNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "parameter", true)).count();
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openClass(projectPath, classifierName)) {
          if (np.openConstructor(projectPath, classifierName, paramCount)) {
            return true;
          }
        }
      }
    } else if (isMethod) {
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref);
      SNode method = SNodeOperations.cast(targetNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openMethod(projectPath, classifierName, SPropertyOperations.getString(method, "name"), ListSequence.fromList(SLinkOperations.getTargets(method, "parameter", true)).count())) {
          return true;
        }
      }
    } else {
      String classifierName = GoByCurrentReference_Action.this.getClassifierName(targetNode, ref);
      for (NavigationProvider np : NavigationProvider.EP_NAME.getExtensions()) {
        if (np.openField(projectPath, classifierName, targetNode.getName())) {
          return true;
        }
      }
    }
    return false;
  }

  private String getClassifierName(SNode targetNode, SModelReference ref) {
    SNode classifier = SNodeOperations.cast(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.Classifier");
    assert classifier != null;
    return ref.getLongName() + "." + SPropertyOperations.getString(classifier, "name");
  }

  private static boolean neq_1m2c1e_a0e0a0e(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }
}
