package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.nodeEditor.CellActionType;

public class Delete_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(Delete_Action.class);

  public Delete_Action() {
    super("Delete", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return EditorActionUtils.isWriteActionEnabled(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "Delete", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().getSelection().executeAction(CellActionType.DELETE);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "Delete", t);
      }
    }
  }
}
