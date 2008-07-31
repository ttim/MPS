package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.ArrayList;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

public class EditNode_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(EditNode_Action.class);
  public static final Icon ICON = null;

  private List<SNode> nodes;
  public IOperationContext context;

  public EditNode_Action() {
    super("Edit", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "EditNode", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
      {
        List<SNode> nodes = event.getData(MPSDataKeys.SNODES);
        boolean error = false;
        if (nodes != null) {
        }
        if (error) {
          this.nodes = null;
        } else
        {
          this.nodes = new ArrayList<SNode>(nodes);
        }
      }
      if (this.nodes == null) {
        return false;
      }
      this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
      if (this.context == null) {
        return false;
      }
    } catch (Throwable t) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      MPSEditorOpener opener = this.context.getComponent(MPSEditorOpener.class);
      for(SNode node : this.nodes) {
        if (node != null) {
          opener.openNode(node, this.context);
        }
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "EditNode", t);
    }
  }

}
