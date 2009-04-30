package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.workbench.MPSDataKeys;

public class GoToTypeErrorRule_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(GoToTypeErrorRule_Action.class);

  public IOperationContext operationContext;
  public MPSProject project;
  public SNode node;

  public GoToTypeErrorRule_Action() {
    super("Go To Rule Which Caused Error", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "ctrl alt R";
  }

  public boolean isApplicable(AnActionEvent event) {
    IErrorReporter error = TypeChecker.getInstance().getTypeErrorDontCheck(GoToTypeErrorRule_Action.this.node);
    return !(error == null || error.getRuleId() == null || error.getRuleModel() == null);
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "GoToTypeErrorRule", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.operationContext = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.operationContext == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    this.node = event.getData(MPSDataKeys.SNODE);
    if (this.node == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      IErrorReporter error = TypeChecker.getInstance().getTypeErrorDontCheck(GoToTypeErrorRule_Action.this.node);
      GoToTypeErrorRuleUtil.goToTypeErrorRule(GoToTypeErrorRule_Action.this.operationContext, error);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "GoToTypeErrorRule", t);
    }
  }

}
