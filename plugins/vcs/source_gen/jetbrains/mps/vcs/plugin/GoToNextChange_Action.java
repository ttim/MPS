package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.vcs.changesmanager.EditorChangesHighlighter;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;

public class GoToNextChange_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("nextOccurence.png");
  protected static Log log = LogFactory.getLog(GoToNextChange_Action.class);

  public GoToNextChange_Action() {
    super("Next Change", "Go to next change", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setVisible(true);
      event.getPresentation().setEnabled(EditorChangesHighlighter.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).isNextChangeAvailable(((EditorContext) MapSequence.fromMap(_params).get("editorContext"))));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoToNextChange", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
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
      EditorChangesHighlighter.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).goToNextChange(((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoToNextChange", t);
      }
    }
  }
}
