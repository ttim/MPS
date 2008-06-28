package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.CurrentProjectAction;
import jetbrains.mps.logging.Logger;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.action.ActionEventData;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class UncommentStatements_Action extends CurrentProjectAction {
  public static final Logger LOG = Logger.getLogger(UncommentStatements_Action.class);
  public static final Icon ICON = null;

  private SNode node;

  public UncommentStatements_Action(Project project) {
    super(project, "Uncomment Statements", "", ICON, false, false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "ctrl shift SLASH";
  }

  public boolean isApplicable(AnActionEvent event) {
    return (SNodeOperations.getAncestor(this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false) != null);
  }

  public void dodoUpdate(@NotNull() AnActionEvent event) {
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

  protected boolean fillFieldsIfNecessary(AnActionEvent event) {
    try {
      {
        SNode node = new ActionEventData(event).getNode();
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
      SNode commentedStatementsBlock = SNodeOperations.getAncestor(this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false);
      for(SNode statement : SLinkOperations.getTargets(commentedStatementsBlock, "statement", true)) {
        SNodeOperations.insertPrevSiblingChild(commentedStatementsBlock, statement);
      }
      SNodeOperations.deleteNode(commentedStatementsBlock);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "UncommentStatements", t);
    }
  }

}
