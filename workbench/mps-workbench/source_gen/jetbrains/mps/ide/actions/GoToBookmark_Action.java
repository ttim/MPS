package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.bookmark.BookmarkManager;
import com.intellij.openapi.actionSystem.PlatformDataKeys;

public class GoToBookmark_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoToBookmark_Action.class);

  private int num;

  public GoToBookmark_Action(int num_par) {
    super("Go to Bookmark", "", ICON);
    this.num = num_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setText("Go to Bookmark " + GoToBookmark_Action.this.num);
      event.getPresentation().setEnabled(((Project) MapSequence.fromMap(_params).get("project")).getComponent(BookmarkManager.class).getBookmark(GoToBookmark_Action.this.num) != null);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoToBookmark", t);
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
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ((Project) MapSequence.fromMap(_params).get("project")).getComponent(BookmarkManager.class).navigateToBookmark(GoToBookmark_Action.this.num);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoToBookmark", t);
      }
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(((Object) this.num).toString());
    res.append("!");
    return res.toString();
  }
}
