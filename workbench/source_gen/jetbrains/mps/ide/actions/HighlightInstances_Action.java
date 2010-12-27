package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.NodeHighlightManager;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.ModelFindOperations;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IScope;

public class HighlightInstances_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(HighlightInstances_Action.class);

  public HighlightInstances_Action() {
    super("Highlight Instances", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "HighlightInstances", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
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
    MapSequence.fromMap(_params).put("scope", event.getData(MPSDataKeys.SCOPE));
    if (MapSequence.fromMap(_params).get("scope") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      NodeHighlightManager highlightManager = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightManager();
      EditorMessageOwner messageOwner = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getHighlightMessagesOwner();
      for (SNode ref : SetSequence.fromSet(new ModelFindOperations(((SModelDescriptor) MapSequence.fromMap(_params).get("model"))).findInstances(((AbstractConceptDeclaration) SNodeOperations.getAdapter(SNodeOperations.getConceptDeclaration(((SNode) MapSequence.fromMap(_params).get("node"))))), ((IScope) MapSequence.fromMap(_params).get("scope"))))) {
        if (ref.getContainingRoot() == ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getRootCell().getSNode().getContainingRoot()) {
          highlightManager.mark(ref, HighlightConstants.INSTANCES_COLOR, "usage", messageOwner);
        }
      }
      highlightManager.repaintAndRebuildEditorMessages();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "HighlightInstances", t);
      }
    }
  }
}
