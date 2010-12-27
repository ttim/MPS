package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.nodeEditor.NodeHighlightManager;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.ModelFindOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class HighlightUsages_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(HighlightUsages_Action.class);

  private EditorComponent editorComponent;
  private EditorCell editorCell;
  private SModelDescriptor model;

  public HighlightUsages_Action() {
    super("Highlight Usages", "", ICON);
    this.setIsAlwaysVisible(true);
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
        log.error("User's action doUpdate method failed. Action:" + "HighlightUsages", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.editorComponent = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editorComponent == null) {
      return false;
    }
    this.editorCell = event.getData(MPSDataKeys.EDITOR_CELL);
    if (this.editorCell == null) {
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
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          NodeHighlightManager highlightManager = HighlightUsages_Action.this.editorComponent.getHighlightManager();
          EditorMessageOwner messageOwner = HighlightUsages_Action.this.editorComponent.getHighlightMessagesOwner();
          SNode node = HighlightUsages_Action.this.editorCell.getSNodeWRTReference();
          Set<SReference> usages = new ModelFindOperations(HighlightUsages_Action.this.model).findUsages(node);
          boolean highlight = highlightManager.getMessagesFor(node, messageOwner).isEmpty();
          if (SNodeOperations.getContainingRoot(node) == HighlightUsages_Action.this.editorComponent.getRootCell().getSNode().getContainingRoot()) {
            if (highlight) {
              highlightManager.mark(node, HighlightConstants.NODE_COLOR, "source node", messageOwner);
            } else {
              for (EditorMessage message : ListSequence.fromList(highlightManager.getMessagesFor(node, messageOwner))) {
                highlightManager.unmark(message);
              }
            }
          }
          for (SReference ref : SetSequence.fromSet(usages)) {
            if (ref.getSourceNode().getContainingRoot() == HighlightUsages_Action.this.editorComponent.getRootCell().getSNode().getContainingRoot()) {
              if (highlight) {
                highlightManager.mark(ref.getSourceNode(), HighlightConstants.USAGES_COLOR, "usage", messageOwner);
              } else {
                for (EditorMessage message : ListSequence.fromList(highlightManager.getMessagesFor(ref.getSourceNode(), messageOwner))) {
                  highlightManager.unmark(message);
                }
              }
            }
          }
          highlightManager.repaintAndRebuildEditorMessages();
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "HighlightUsages", t);
      }
    }
  }
}
