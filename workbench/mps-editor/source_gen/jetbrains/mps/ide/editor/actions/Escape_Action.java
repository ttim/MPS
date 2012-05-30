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
import com.intellij.openapi.actionSystem.PlatformDataKeys;

public class Escape_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(Escape_Action.class);

  public Escape_Action() {
    super("Escape", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getNodeSubstituteChooser().isVisible() || ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).hasNodeInformationDialog()) {
      return false;
    }

    return ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().getSelectionStackSize() > 1 || ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isSearchPanelVisible() || ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightManager().hasMessages(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightMessagesOwner());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "Escape", t);
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
    MapSequence.fromMap(_params).put("isModalContext", event.getData(PlatformDataKeys.IS_MODAL_CONTEXT));
    if (MapSequence.fromMap(_params).get("isModalContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      if (((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isSearchPanelVisible()) {
        ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSearchPanel().deactivate();
      }

      ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightManager().clearForOwner(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightMessagesOwner());
      ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).onEscape();

      ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().setSelection(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectionManager().getDeepestSelection());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "Escape", t);
      }
    }
  }
}
