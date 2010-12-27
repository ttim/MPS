package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.swing.tree.TreeNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.ui.popup.ListPopup;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.ide.ui.MPSTreeNode;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.ActionManager;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.ui.popup.JBPopupFactory;

public class QuickCreate_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(QuickCreate_Action.class);

  private TreeNode node;

  public QuickCreate_Action() {
    super("Quick Create", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "QuickCreate", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.node = event.getData(MPSDataKeys.LOGICAL_VIEW_NODE);
    if (this.node == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<ListPopup> popup = new Wrappers._T<ListPopup>(null);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          ActionGroup group = ((MPSTreeNode) QuickCreate_Action.this.node).getQuickCreateGroup(event.getInputEvent().isControlDown());
          if (group != null) {
            Presentation pres = new Presentation();
            AnActionEvent e = new AnActionEvent(event.getInputEvent(), event.getDataContext(), ActionPlaces.UNKNOWN, pres, ActionManager.getInstance(), 0);
            ActionUtils.updateGroup(group, e);
            popup.value = JBPopupFactory.getInstance().createActionGroupPopup("New", group, event.getDataContext(), JBPopupFactory.ActionSelectionAid.SPEEDSEARCH, false);
          }
        }
      });
      if (popup.value == null) {
        return;
      }
      popup.value.showInBestPositionFor(event.getDataContext());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "QuickCreate", t);
      }
    }
  }
}
