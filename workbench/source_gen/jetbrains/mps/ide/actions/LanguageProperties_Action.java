package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.properties.LanguagePropertiesDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.properties.StandardDialogs;
import jetbrains.mps.smodel.IOperationContext;

public class LanguageProperties_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/languageProperties.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(LanguageProperties_Action.class);

  public LanguageProperties_Action() {
    super("Language Properties", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "LanguageProperties", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
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
      final Language language = (Language) ((IModule) MapSequence.fromMap(_params).get("module"));
      final Wrappers._T<LanguagePropertiesDialog> dialog = new Wrappers._T<LanguagePropertiesDialog>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          dialog.value = StandardDialogs.createLanguagePropertiesDialog(language, ((IOperationContext) MapSequence.fromMap(_params).get("context")));
        }
      });
      dialog.value.showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "LanguageProperties", t);
      }
    }
  }
}
