package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.generator.GenerationSettings;
import jetbrains.mps.generator.Icons;
import com.intellij.util.ui.EmptyIcon;

public class CheckModelsBeforeGeneration_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CheckModelsBeforeGeneration_Action.class);

  public CheckModelsBeforeGeneration_Action() {
    super("Check Models Before Generation", "Check models for errors before generation", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean optionEnabled = GenerationSettings.getInstance().isCheckModelsBeforeGeneration();
        if (optionEnabled) {
          event.getPresentation().setIcon(Icons.CHECK_ICON);
        } else {
          event.getPresentation().setIcon(new EmptyIcon(18, 18));
        }
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CheckModelsBeforeGeneration", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      GenerationSettings settings = GenerationSettings.getInstance();
      settings.setCheckModelsBeforeGeneration(!(settings.isCheckModelsBeforeGeneration()));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CheckModelsBeforeGeneration", t);
      }
    }
  }
}
