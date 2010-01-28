package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.workbench.dialogs.project.creation.NewModelDialog;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.projectPane.ProjectPane;

public class NewSubModel_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${mps_home}/workbench/source/jetbrains/mps/ide/projectPane/nodes/model.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(NewSubModel_Action.class);

  private Project ideaProject;
  private IOperationContext context;
  private SModelDescriptor model;

  public NewSubModel_Action() {
    super("Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    boolean correctStereotype = false;
    String stereotype = NewSubModel_Action.this.model.getStereotype();
    for (String availableStereotype : SModelStereotype.values) {
      if (stereotype.equals(availableStereotype)) {
        correctStereotype = true;
        break;
      }
    }
    return correctStereotype;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewSubModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.ideaProject = event.getData(MPSDataKeys.PROJECT);
    if (this.ideaProject == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.CONTEXT_MODEL);
    if (this.model == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<NewModelDialog> dialog = new Wrappers._T<NewModelDialog>();
      final IModule localModule = (NewSubModel_Action.this.context.getModule() != null ?
        NewSubModel_Action.this.context.getModule() :
        NewSubModel_Action.this.model.getModule()
      );
      final String namespace = NewSubModel_Action.this.model.getLongName();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          String stereotype = NewSubModel_Action.this.model.getStereotype();
          dialog.value = new NewModelDialog(localModule, namespace, NewSubModel_Action.this.context, stereotype, true);
        }
      });
      dialog.value.showDialog();
      SModelDescriptor result = dialog.value.getResult();
      if (result != null) {
        SModelDescriptor modelDescriptor = result;
        ProjectPane.getInstance(NewSubModel_Action.this.ideaProject).selectModel(modelDescriptor);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewSubModel", t);
      }
    }
  }
}
