package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class UncommentStatements_Action extends GeneratedAction {
  public static final Logger LOG = Logger.getLogger(UncommentStatements_Action.class);
  public static final Icon ICON = null;

  private SNode node;

  public UncommentStatements_Action() {
    super("Uncomment Statements", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "ctrl shift SLASH";
  }

  public boolean isApplicable(AnActionEvent event) {
    return (SNodeOperations.getAncestor(UncommentStatements_Action.this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false) != null);
  }

  public void doUpdate(@NotNull()AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "UncommentStatements", t);
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    try {
      if (!(super.collectActionData(event))) {
        return false;
      }
      {
        SNode node = event.getData(MPSDataKeys.SNODE);
        if (node != null) {
          if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.core.structure.BaseConcept"))) {
            node = null;
          }
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
    } catch (Throwable t) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      SNode commentedStatementsBlock = SNodeOperations.getAncestor(UncommentStatements_Action.this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false);
      for (SNode statement : SLinkOperations.getTargets(commentedStatementsBlock, "statement", true)) {
        SNodeOperations.insertPrevSiblingChild(commentedStatementsBlock, statement);
      }
      SNodeOperations.deleteNode(commentedStatementsBlock);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "UncommentStatements", t);
    }
  }

}
