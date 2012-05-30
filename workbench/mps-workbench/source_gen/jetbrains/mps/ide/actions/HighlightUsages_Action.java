package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.nodeEditor.NodeHighlightManager;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.util.Set;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.findUsages.FindUsagesManager;
import java.util.Collections;
import jetbrains.mps.findUsages.SearchType;
import jetbrains.mps.smodel.ModelsOnlyScope;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class HighlightUsages_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(HighlightUsages_Action.class);

  public HighlightUsages_Action() {
    super("Highlight Usages", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "HighlightUsages", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorCell", event.getData(MPSEditorDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("editorCell") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          NodeHighlightManager highlightManager = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightManager();
          EditorMessageOwner messageOwner = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightMessagesOwner();
          SNode node = ((EditorCell) MapSequence.fromMap(_params).get("editorCell")).getSNodeWRTReference();
          Set<SReference> usages = FindUsagesManager.getInstance().findUsages(Collections.singleton(node), SearchType.USAGES, new ModelsOnlyScope(((SModelDescriptor) MapSequence.fromMap(_params).get("model"))), null);
          boolean highlight = highlightManager.getMessagesFor(node, messageOwner).isEmpty();
          if (SNodeOperations.getContainingRoot(node) == ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getRootCell().getSNode().getContainingRoot()) {
            if (highlight) {
              highlightManager.mark(node, HighlightConstants.NODE_COLOR, "source node", messageOwner);
            } else {
              for (EditorMessage message : ListSequence.fromList(highlightManager.getMessagesFor(node, messageOwner))) {
                highlightManager.unmark(message);
              }
            }
          }
          for (SReference ref : SetSequence.fromSet(usages)) {
            if (ref.getSourceNode().getContainingRoot() == ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getRootCell().getSNode().getContainingRoot()) {
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
