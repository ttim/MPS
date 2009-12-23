package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.IOperationContext;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.workbench.dialogs.project.utildialogs.clonemodel.CloneModelDialog;
import jetbrains.mps.smodel.ModelAccess;

public class CloneModel_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CloneModel_Action.class);

  private SModelDescriptor model;
  private IOperationContext context;
  private Integer selSize;

  public CloneModel_Action() {
    super("Clone Model", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "shift F5";
  }

  public boolean isApplicable(AnActionEvent event) {
    if (CloneModel_Action.this.selSize != 1) {
      return false;
    }
    IModule module = CloneModel_Action.this.model.getModule();
    if (module instanceof Language) {
      Language language = (Language) module;
      return language.getAspectForModel(CloneModel_Action.this.model) == null;
    } else {
      return true;
    }
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CloneModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.MODEL);
    if (this.model == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.selSize = event.getData(MPSDataKeys.LOGICAL_VIEW_SELECTION_SIZE);
    if (this.selSize == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<CloneModelDialog> dialog = new Wrappers._T<CloneModelDialog>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          dialog.value = new CloneModelDialog(CloneModel_Action.this.model, CloneModel_Action.this.context);
        }
      });
      dialog.value.showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CloneModel", t);
      }
    }
  }
}
