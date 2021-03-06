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
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.ui.MPSTree;
import javax.swing.tree.TreePath;
import jetbrains.mps.ide.ui.MPSTreeNode;

public class ExpandNode_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ExpandNode_Action.class);

  public ExpandNode_Action() {
    super("Expand All", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ExpandNode", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ProjectPane pane = ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("project")));
      MPSTree tree = pane.getTree();
      TreePath path = tree.getSelectionPath();
      if (path == null) {
        return;
      }
      tree.expandAll((MPSTreeNode) path.getLastPathComponent());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ExpandNode", t);
      }
    }
  }
}
