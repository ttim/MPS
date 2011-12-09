package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.navigation.NavigationSupport;
import jetbrains.mps.smodel.IOperationContext;

public class EditGivenNode_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(EditGivenNode_Action.class);

  private SNodePointer targetNode;
  private String text;

  public EditGivenNode_Action(SNodePointer targetNode_par, String text_par) {
    super("<no caption>", "", ICON);
    this.targetNode = targetNode_par;
    this.text = text_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setText(EditGivenNode_Action.this.text);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "EditGivenNode", t);
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      NavigationSupport.getInstance().openNode(((IOperationContext) MapSequence.fromMap(_params).get("context")), EditGivenNode_Action.this.targetNode.getNode(), true, true);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "EditGivenNode", t);
      }
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(targetNode_State((SNodePointer) this.targetNode));
    res.append("!");
    res.append(text_State((String) this.text));
    res.append("!");
    return res.toString();
  }

  public static String targetNode_State(SNodePointer object) {
    return object.toString();
  }

  public static String text_State(String object) {
    return "";
  }
}
