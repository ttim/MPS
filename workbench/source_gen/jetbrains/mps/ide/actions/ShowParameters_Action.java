package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import java.awt.Point;
import jetbrains.mps.ide.tooltips.MPSToolTipManager;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ShowParameters_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowParameters_Action.class);

  private EditorComponent editor;
  private EditorCell cell;

  public ShowParameters_Action() {
    super("Show Parameters", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "ctrl P";
  }

  public boolean isApplicable(AnActionEvent event) {
    if (ShowParameters_Action.this.getCellNode() == null) {
      return false;
    }
    if (ShowParameters_Action.this.getMethod() == null) {
      return false;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowParameters", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.editor = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editor == null) {
      return false;
    }
    this.cell = event.getData(MPSDataKeys.EDITOR_CELL);
    if (this.cell == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      Point p = new Point(ShowParameters_Action.this.cell.getX() + ShowParameters_Action.this.cell.getWidth(), ShowParameters_Action.this.cell.getY() + ShowParameters_Action.this.cell.getHeight());
      String text = ParametersInformationDialog.getNodeInfoText(ShowParameters_Action.this.getMethod());
      MPSToolTipManager.getInstance().showToolTip(text, ShowParameters_Action.this.editor, p);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowParameters", t);
      }
    }
  }

  /*package*/ SNode getMethod() {
    SNode methodCall = SNodeOperations.getAncestor(ShowParameters_Action.this.getCellNode(), "jetbrains.mps.baseLanguage.structure.IMethodCall", true, false);
    if (methodCall == null) {
      return null;
    }
    return SLinkOperations.getTarget(methodCall, "baseMethodDeclaration", false);
  }

  /*package*/ SNode getCellNode() {
    return ShowParameters_Action.this.cell.getSNode();
  }
}
