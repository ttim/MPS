package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.properties.LanguagePropertiesDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.properties.StandardDialogs;

public class LanguageProperties_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${solution_descriptor}/icons/languageProperties.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(LanguageProperties_Action.class);

  private IOperationContext context;
  private IModule module;

  public LanguageProperties_Action() {
    super("Language Properties", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    return LanguageProperties_Action.this.module instanceof Language;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "LanguageProperties", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.module = event.getData(MPSDataKeys.MODULE);
    if (this.module == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Language language = (Language) LanguageProperties_Action.this.module;
      final Wrappers._T<LanguagePropertiesDialog> dialog = new Wrappers._T<LanguagePropertiesDialog>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          dialog.value = StandardDialogs.createLanguagePropertiesDialog(language, LanguageProperties_Action.this.context);
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
