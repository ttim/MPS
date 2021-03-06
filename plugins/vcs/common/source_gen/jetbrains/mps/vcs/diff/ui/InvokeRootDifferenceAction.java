package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import jetbrains.mps.vcs.diff.ui.common.BaseDiffModelTreeAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.ActionManager;

public class InvokeRootDifferenceAction extends BaseDiffModelTreeAction {
  private ModelDifferenceDialog myModelDifferenceDialog;

  public InvokeRootDifferenceAction(ModelDifferenceDialog modelDifferenceDialog) {
    super("", getDefaultDiffAction().getTemplatePresentation().getIcon());
    myModelDifferenceDialog = modelDifferenceDialog;
    copyShortcutFrom(getDefaultDiffAction());
  }

  protected void doExecute(AnActionEvent event, Map<String, Object> map) {
    myModelDifferenceDialog.invokeRootDifference(getRootId(event));
  }

  @Override
  protected void doUpdate(AnActionEvent event, Map<String, Object> map) {
    super.doUpdate(event, map);
    event.getPresentation().setText((getRootId(event) == null ?
      "Show Changes" :
      "Show Difference"
    ));
  }

  private static AnAction getDefaultDiffAction() {
    return ActionManager.getInstance().getAction("ChangesView.Diff");
  }
}
