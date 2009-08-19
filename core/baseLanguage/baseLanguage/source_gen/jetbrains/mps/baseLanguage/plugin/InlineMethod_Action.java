package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import java.awt.Frame;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;

public class InlineMethod_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(InlineMethod_Action.class);

  private SNode node;
  private Frame frame;
  private Project project;
  private IOperationContext operationContext;

  public InlineMethod_Action() {
    super("Inline Method", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "ctrl alt N";
  }

  public boolean isApplicable(AnActionEvent event) {
    final Wrappers._T<Boolean> b = new Wrappers._T<Boolean>(false);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        b.value = MethodCallAdapter.isMethodCall(InlineMethod_Action.this.node) || SNodeOperations.isInstanceOf(InlineMethod_Action.this.node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
      }
    });
    return b.value;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "InlineMethod", t);
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    this.operationContext = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.operationContext == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      InlineMethodDialog dialog = new InlineMethodDialog(InlineMethod_Action.this.node, InlineMethod_Action.this.project, InlineMethod_Action.this.operationContext);
      dialog.tryToShow();
      dialog.pack();
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "InlineMethod", t);
    }
  }
}
