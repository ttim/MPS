package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.util.Pair;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.nodeEditor.GoToTypeErrorRuleUtil;
import jetbrains.mps.smodel.IOperationContext;

public class GoToTypeErrorRule_InGroup_Action extends BaseAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(GoToTypeErrorRule_InGroup_Action.class);

  private Pair<String, String> errorId;
  private boolean immediate;

  public GoToTypeErrorRule_InGroup_Action(Pair<String, String> errorId_par, boolean immediate_par) {
    super("Go to Rule Which Caused Error", "", ICON);
    this.errorId = errorId_par;
    this.immediate = immediate_par;
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        String text = (GoToTypeErrorRule_InGroup_Action.this.immediate ?
          "Go To Immediate Rule" :
          "Go To Rule " + GoToTypeErrorRule_InGroup_Action.this.errorId.o2
        );
        event.getPresentation().setText(text);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "GoToTypeErrorRule_InGroup", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      GoToTypeErrorRuleUtil.goToRuleById(((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), new Pair<String, String>(GoToTypeErrorRule_InGroup_Action.this.errorId.o1, GoToTypeErrorRule_InGroup_Action.this.errorId.o2));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "GoToTypeErrorRule_InGroup", t);
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(errorId_State((Pair<String, String>) this.errorId));
    res.append("!");
    res.append(((Object) this.immediate).toString());
    res.append("!");
    return res.toString();
  }

  public static String errorId_State(Pair<String, String> object) {
    return object.o1 + "#" + object.o2;
  }
}
