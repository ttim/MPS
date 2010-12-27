package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.NodeHighlightManager;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.util.Set;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.SNodePointer;

public class HighlightCellDependencies_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(HighlightCellDependencies_Action.class);

  public HighlightCellDependencies_Action() {
    super("Higlighted Cell's Dependent Nodes", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "HighlightCellDependencies", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorCell", event.getData(MPSDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("editorCell") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      NodeHighlightManager highlightManager = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightManager();
      EditorMessageOwner messageOwner = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightMessagesOwner();
      highlightManager.mark(((EditorCell) MapSequence.fromMap(_params).get("editorCell")).getSNode(), HighlightConstants.NODE_COLOR, "node", messageOwner);
      Set<SNode> nodes = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getNodesCellDependOn(((EditorCell) MapSequence.fromMap(_params).get("editorCell")));
      if (nodes != null) {
        for (SNode node : SetSequence.fromSet(nodes)) {
          highlightManager.mark(node, HighlightConstants.DEPENDENCY_COLOR, "usage", messageOwner);
        }
      }
      Set<SNodePointer> copyOfRefTargets = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getCopyOfRefTargetsCellDependsOn(((EditorCell) MapSequence.fromMap(_params).get("editorCell")));
      if (copyOfRefTargets != null) {
        for (SNodePointer nodePointer : SetSequence.fromSet(copyOfRefTargets)) {
          if (nodePointer.getNode() != null) {
            highlightManager.mark(nodePointer.getNode(), HighlightConstants.DEPENDENCY_COLOR, "usage", messageOwner);
          }
        }
      }
      highlightManager.repaintAndRebuildEditorMessages();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "HighlightCellDependencies", t);
      }
    }
  }
}
