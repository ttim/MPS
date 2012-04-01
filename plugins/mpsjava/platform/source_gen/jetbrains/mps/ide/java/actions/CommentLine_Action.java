package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;

public class CommentLine_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CommentLine_Action.class);

  public CommentLine_Action() {
    super("Comment Line", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isReadOnly()) {
      return false;
    }
    SNode singleLineComment = CommentLine_Action.this.getSingleLineComment(_params);
    if (singleLineComment != null) {
      return (int) ListSequence.fromList(SLinkOperations.getTargets(singleLineComment, "commentPart", true)).count() == 1 && SNodeOperations.isInstanceOf(ListSequence.fromList(SLinkOperations.getTargets(singleLineComment, "commentPart", true)).first(), "jetbrains.mps.baseLanguage.structure.StatementCommentPart");
    }
    SNode statement = CommentLine_Action.this.getStatement(_params);
    if (statement == null) {
      return false;
    }
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(statement), "jetbrains.mps.baseLanguage.structure.StatementList");
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CommentLine", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("selectedNode", node);
    }
    if (MapSequence.fromMap(_params).get("selectedNode") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      SNode singleLineComment = CommentLine_Action.this.getSingleLineComment(_params);
      if (singleLineComment != null) {
        // uncommenting 
        SNode innerStatement = SLinkOperations.getTarget(SNodeOperations.cast(ListSequence.fromList(SLinkOperations.getTargets(singleLineComment, "commentPart", true)).first(), "jetbrains.mps.baseLanguage.structure.StatementCommentPart"), "commentedStatement", true);
        SNodeOperations.replaceWithAnother(singleLineComment, innerStatement);
        SNodeOperations.deleteNode(singleLineComment);
      } else {
        SNode statement = CommentLine_Action.this.getStatement(_params);
        assert statement != null : "Statement should not be null due to the isApplicable() constraints";
        // commenting 
        SNode comment = SNodeOperations.replaceWithNewChild(statement, "jetbrains.mps.baseLanguage.structure.SingleLineComment");
        SNode commentPart = SLinkOperations.addNewChild(comment, "commentPart", "jetbrains.mps.baseLanguage.structure.StatementCommentPart");
        SLinkOperations.setTarget(commentPart, "commentedStatement", statement, true);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CommentLine", t);
      }
    }
  }

  private SNode getStatement(final Map<String, Object> _params) {
    return SNodeOperations.getAncestor(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.baseLanguage.structure.Statement", true, false);
  }

  private SNode getSingleLineComment(final Map<String, Object> _params) {
    return SNodeOperations.getAncestor(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.baseLanguage.structure.SingleLineComment", true, false);
  }
}
