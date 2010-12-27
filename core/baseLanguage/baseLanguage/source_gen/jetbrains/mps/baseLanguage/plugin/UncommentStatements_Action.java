package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorComponent;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class UncommentStatements_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(UncommentStatements_Action.class);

  private SNode node;
  private EditorComponent editorComponent;

  public UncommentStatements_Action() {
    super("Uncomment Statements", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    return (SNodeOperations.getAncestor(UncommentStatements_Action.this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false) != null) && !(UncommentStatements_Action.this.editorComponent.isReadOnly());
  }

  public void doUpdate(@NotNull AnActionEvent event) {
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

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.core.structure.BaseConcept"))) {
          node = null;
        }
      }
      this.node = node;
    }
    if (this.node == null) {
      return false;
    }
    this.editorComponent = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editorComponent == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      SNode commentedStatementsBlock = SNodeOperations.getAncestor(UncommentStatements_Action.this.node, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock", false, false);
      for (SNode statement : ListSequence.fromList(SLinkOperations.getTargets(commentedStatementsBlock, "statement", true))) {
        SNodeOperations.insertPrevSiblingChild(commentedStatementsBlock, statement);
      }
      SNodeOperations.deleteNode(commentedStatementsBlock);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "UncommentStatements", t);
    }
  }
}
