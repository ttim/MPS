package jetbrains.mps.vcs.platform.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.vcs.changesmanager.editor.ChangesStripActionsHelper;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;

public class CopyOldNodes_Action extends GeneratedAction {
  private static final Icon ICON = IconUtil.getIcon("menu-copy.png");
  protected static Log log = LogFactory.getLog(CopyOldNodes_Action.class);

  public CopyOldNodes_Action() {
    super("Copy Old Code", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ChangesStripActionsHelper.areOldNodesAvailable(((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CopyOldNodes", t);
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
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ChangesStripActionsHelper.copyOldNodes(((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CopyOldNodes", t);
      }
    }
  }
}
