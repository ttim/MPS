package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.ide.dialogs.DevKitPropertiesDialog;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.MacrosUtil;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.workbench.action.ActionEventData;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class DevkitProperties_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(DevkitProperties_Action.class);
  public static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}\\icons\\languageProperties.png", "jetbrains.mps.ide"), true);

  public IOperationContext context;

  public DevkitProperties_Action() {
    super("DevKit Properties", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull()
  public String getKeyStroke() {
    return "alt ENTER";
  }

  public void doUpdate(@NotNull()AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "DevkitProperties", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      ActionEventData data = new ActionEventData(event);
      final DevKit devkit = DevkitProperties_Action.this.getDevKit(data);
      final IOperationContext localContext = DevkitProperties_Action.this.context;
      final DevKitPropertiesDialog[] dialog = new DevKitPropertiesDialog[1];
      ModelAccess.instance().runReadAction(new Runnable() {

        public void run() {
          dialog[0] = new DevKitPropertiesDialog(devkit, localContext);
        }

      });
      dialog[0].showDialog();
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "DevkitProperties", t);
    }
  }

  private DevKit getDevKit(ActionEventData data) {
    IModule module = data.getModule();
    if (module instanceof DevKit) {
      return (DevKit) module;
    }
    return null;
  }

}
