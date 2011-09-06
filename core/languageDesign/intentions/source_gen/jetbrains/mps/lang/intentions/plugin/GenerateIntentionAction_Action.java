package jetbrains.mps.lang.intentions.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.intentions.GenerateIntention;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.intentions.IntentionContext;
import jetbrains.mps.smodel.ModelAccess;

public class GenerateIntentionAction_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(GenerateIntentionAction_Action.class);

  private GenerateIntention intention;
  private SNode node;

  public GenerateIntentionAction_Action(GenerateIntention intention_par, SNode node_par) {
    super("<no caption>", "", ICON);
    this.intention = intention_par;
    this.node = node_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setText(GenerateIntentionAction_Action.this.intention.getDescription(GenerateIntentionAction_Action.this.node, ((EditorContext) MapSequence.fromMap(_params).get("context"))));
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "GenerateIntentionAction", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final IntentionContext intentionContext = new IntentionContext();
      if (GenerateIntentionAction_Action.this.intention.executeUI(GenerateIntentionAction_Action.this.node, ((EditorContext) MapSequence.fromMap(_params).get("context")), intentionContext)) {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            GenerateIntentionAction_Action.this.intention.execute(GenerateIntentionAction_Action.this.node, ((EditorContext) MapSequence.fromMap(_params).get("context")), intentionContext);
          }
        });
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "GenerateIntentionAction", t);
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(intention_State((GenerateIntention) this.intention));
    res.append("!");
    res.append(node_State((SNode) this.node));
    res.append("!");
    return res.toString();
  }

  public static String intention_State(GenerateIntention object) {
    return "";
  }

  public static String node_State(SNode object) {
    return "";
  }
}
