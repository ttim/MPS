package jetbrains.mps.bootstrap.dataFlow.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.CurrentProjectAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.action.ActionEventData;
import jetbrains.mps.dataFlow.framework.Program;
import jetbrains.mps.dataFlow.DataFlowManager;
import jetbrains.mps.dataFlow.presentation.ShowCFGDialog;

public class ShowDFA_Action extends CurrentProjectAction {
  public static final Logger LOG = Logger.getLogger(ShowDFA_Action.class);
  public static final Icon ICON = null;

  private SNode node;
  private IOperationContext context;

  public ShowDFA_Action(Project project) {
    super(project, "Show DFA (under construction)", "", ICON, false, false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public void dodoUpdate(@NotNull() AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowDFA", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean fillFieldsIfNecessary(AnActionEvent event) {
    try {
      {
        SNode node = new ActionEventData(event).getNode();
        if (node != null) {
        }
        this.node = node;
        /*
          if (!(<!IsSubtypeExpression TextGen not found!>)) {
            return false;
          }
        */
      }
      if (this.node == null) {
        return false;
      }
      this.context = new ActionEventData(event).getOperationContext();
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
      Program program = DataFlowManager.getInstance().buildProgramFor(this.node);
      new ShowCFGDialog(program, this.context);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowDFA", t);
    }
  }

}
