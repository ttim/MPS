package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.ide.generator.GenerationSettings;
import jetbrains.mps.ide.generator.Icons;
import com.intellij.util.ui.EmptyIcon;

public class CheckModelsBeforeGeneration_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CheckModelsBeforeGeneration_Action.class);

  public CheckModelsBeforeGeneration_Action() {
    super("Check Models Before Generation", "Check models for errors before generation", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
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

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
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
