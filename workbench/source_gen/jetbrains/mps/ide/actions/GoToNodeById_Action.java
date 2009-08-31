package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.project.MPSProject;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JOptionPane;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

public class GoToNodeById_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoToNodeById_Action.class);

  private MPSProject project;
  private Frame frame;
  private IOperationContext context;
  private SModelDescriptor model;

  public GoToNodeById_Action() {
    super("Go to Node by ID", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GoToNodeById", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.CONTEXT_MODEL);
    if (this.model == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      String value = JOptionPane.showInputDialog(GoToNodeById_Action.this.frame, "Enter node ID:", "Find node in model " + GoToNodeById_Action.this.model.getLongName(), JOptionPane.QUESTION_MESSAGE);
      if (value == null) {
        return;
      }
      SNode node = GoToNodeById_Action.this.model.getSModel().getNodeById(value);
      if (node == null) {
        JOptionPane.showMessageDialog(GoToNodeById_Action.this.frame, "Can't find node with id " + value);
        return;
      }
      GoToNodeById_Action.this.project.getComponent(MPSEditorOpener.class).editNode(node, GoToNodeById_Action.this.context);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoToNodeById", t);
      }
    }
  }
}
