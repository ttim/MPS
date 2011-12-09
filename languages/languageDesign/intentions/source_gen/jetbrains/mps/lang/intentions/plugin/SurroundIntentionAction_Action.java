package jetbrains.mps.lang.intentions.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.intentions.SurroundWithIntention;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;

public class SurroundIntentionAction_Action extends BaseAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(SurroundIntentionAction_Action.class);

  private SurroundWithIntention intention;
  private SNode node;

  public SurroundIntentionAction_Action(SurroundWithIntention intention_par, SNode node_par) {
    super("<no caption>", "", ICON);
    this.intention = intention_par;
    this.node = node_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setText(SurroundIntentionAction_Action.this.intention.getDescription(SurroundIntentionAction_Action.this.node, ((EditorContext) MapSequence.fromMap(_params).get("context"))));
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "SurroundIntentionAction", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      SurroundIntentionAction_Action.this.intention.execute(SurroundIntentionAction_Action.this.node, ((EditorContext) MapSequence.fromMap(_params).get("context")));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "SurroundIntentionAction", t);
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(intention_State((SurroundWithIntention) this.intention));
    res.append("!");
    res.append(node_State((SNode) this.node));
    res.append("!");
    return res.toString();
  }

  public static String intention_State(SurroundWithIntention object) {
    return "";
  }

  public static String node_State(SNode object) {
    return "";
  }
}
