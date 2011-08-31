package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.workbench.dialogs.project.BasePropertiesDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.ide.properties.StandardDialogs;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.Library;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.smodel.Generator;

public class ModuleProperties_Action extends GeneratedAction {
  private static final Icon ICON = new ImageIcon(ModuleProperties_Action.class.getResource("solutionProperties.png"));
  protected static Log log = LogFactory.getLog(ModuleProperties_Action.class);

  public ModuleProperties_Action() {
    super("Module Properties", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ModuleProperties", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.<String,Object>fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<BasePropertiesDialog> dialog = new Wrappers._T<BasePropertiesDialog>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")) instanceof Language) {
            dialog.value = StandardDialogs.createLanguagePropertiesDialog((Language) ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")) instanceof Solution) {
            dialog.value = StandardDialogs.createSolutionPropertiesDialog((Solution) ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")) instanceof Library) {
            dialog.value = StandardDialogs.createLibraryPropertiesDialog((Library) ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")) instanceof DevKit) {
            dialog.value = StandardDialogs.createDevKitPropertiesDialog((DevKit) ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.<String,Object>fromMap(_params).get("module")) instanceof Generator) {
            dialog.value = StandardDialogs.createGeneratorPropertiesDialog(((Generator) ((IModule) MapSequence.<String,Object>fromMap(_params).get("module"))), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")));
          } else {
            throw new IllegalArgumentException("Unknown module type: " + ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")).getClass().getName());
          }
        }
      });
      dialog.value.showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ModuleProperties", t);
      }
    }
  }
}
