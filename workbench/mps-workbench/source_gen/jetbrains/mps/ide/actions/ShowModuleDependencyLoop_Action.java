package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import javax.swing.tree.TreeNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.depanalyzer.ModuleDependencyNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.project.Project;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;

public class ShowModuleDependencyLoop_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowModuleDependencyLoop_Action.class);

  public ShowModuleDependencyLoop_Action() {
    super("Show Cycle Paths", "Show All Cycle Paths for Selected Module", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return check_mdxcvg_a0a0((as_hir9am_a0a0a0b(((TreeNode) MapSequence.fromMap(_params).get("treenode")), ModuleDependencyNode.class)));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowModuleDependencyLoop", t);
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
    MapSequence.fromMap(_params).put("treenode", event.getData(MPSDataKeys.LOGICAL_VIEW_NODE));
    if (MapSequence.fromMap(_params).get("treenode") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModuleDependenies_Tool.class).ShowLoops(as_hir9am_a0a0a0a0e(((TreeNode) MapSequence.fromMap(_params).get("treenode")), ModuleDependencyNode.class));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowModuleDependencyLoop", t);
      }
    }
  }

  private static boolean check_mdxcvg_a0a0(ModuleDependencyNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.isCyclic();
    }
    return false;
  }

  private static <T> T as_hir9am_a0a0a0b(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }

  private static <T> T as_hir9am_a0a0a0a0e(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }
}
