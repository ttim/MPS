package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.datatransfer.CopyPasteUtil;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class CopyNodeName_Action extends GeneratedAction {
  private static final Logger LOG = Logger.getLogger(CopyNodeName_Action.class);
  private static final Icon ICON = null;

  public SNode node;

  public CopyNodeName_Action() {
    super("Copy Node FQName", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    return CopyNodeName_Action.this.node.isRoot();
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "CopyNodeName", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
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
      CopyPasteUtil.copyTextToClipboard(CopyNodeName_Action.this.node.getModel().getLongName() + "." + CopyNodeName_Action.this.node.getName());
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "CopyNodeName", t);
    }
  }

}
