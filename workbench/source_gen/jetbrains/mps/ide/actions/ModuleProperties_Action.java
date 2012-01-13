package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
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
import jetbrains.mps.project.DevKit;
import jetbrains.mps.smodel.Generator;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class ModuleProperties_Action extends BaseAction {
  private static final Icon ICON = getIcon();
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<BasePropertiesDialog> dialog = new Wrappers._T<BasePropertiesDialog>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language) {
            dialog.value = StandardDialogs.createLanguagePropertiesDialog((Language) ((IModule) MapSequence.fromMap(_params).get("module")), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.fromMap(_params).get("module")) instanceof Solution) {
            dialog.value = StandardDialogs.createSolutionPropertiesDialog((Solution) ((IModule) MapSequence.fromMap(_params).get("module")), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.fromMap(_params).get("module")) instanceof DevKit) {
            dialog.value = StandardDialogs.createDevKitPropertiesDialog((DevKit) ((IModule) MapSequence.fromMap(_params).get("module")), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
          } else if (((IModule) MapSequence.fromMap(_params).get("module")) instanceof Generator) {
            dialog.value = StandardDialogs.createGeneratorPropertiesDialog(((Generator) ((IModule) MapSequence.fromMap(_params).get("module"))), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
          } else {
            throw new IllegalArgumentException("Unknown module type: " + ((IModule) MapSequence.fromMap(_params).get("module")).getClass().getName());
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

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(ModuleProperties_Action.class.getResource("solutionProperties.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for ModuleProperties", e);
      }
      return null;
    }
  }
}
