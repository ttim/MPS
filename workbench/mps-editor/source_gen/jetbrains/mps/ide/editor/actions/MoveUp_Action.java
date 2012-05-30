package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.nodeEditor.selection.Selection;
import jetbrains.mps.nodeEditor.CellActionType;

public class MoveUp_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveUp_Action.class);

  public MoveUp_Action() {
    super("Up", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isFocusOwner() && !(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getNodeSubstituteChooser().isVisible());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveUp", t);
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
      Selection selection = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().getSelection();
      if (selection != null) {
        ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().getSelection().executeAction(CellActionType.UP);
      } else {
        EditorActionUtils.runEditorComponentAction(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")), CellActionType.UP);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveUp", t);
      }
    }
  }
}
