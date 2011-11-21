package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.EditorComponent;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class CopyThisDown_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CopyThisDown_Action.class);

  public CopyThisDown_Action() {
    super("Duplicate Node", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).count() > 0 && !(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).isReadOnly());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CopyThisDown", t);
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
    {
      List<SNode> nodes = event.getData(MPSCommonDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("inputNodes", null);
      } else {
        MapSequence.fromMap(_params).put("inputNodes", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.fromMap(_params).get("inputNodes") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      if ((int) ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).count() == 1) {
        SNode nodeToCopy = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).first();
        while (SNodeOperations.getParent(nodeToCopy) != null) {
          SNode parent = SNodeOperations.getParent(nodeToCopy);
          String role = nodeToCopy.getRole_();
          SNode link = ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.getConceptDeclaration(parent), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "call_findLinkDeclaration_1213877394467", new Class[]{SNode.class, String.class}, role));
          if (link == null) {
            return;
          }
          if (!(((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(link, "jetbrains.mps.lang.structure.structure.LinkDeclaration"), "call_isSingular_1213877254557", new Class[]{SNode.class})))) {
            SNode copy = SNodeOperations.copyNode(nodeToCopy);
            parent.insertChild(nodeToCopy, role, copy);
            ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getEditorContext().selectWRTFocusPolicy(copy);
            ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).selectNode(copy);
            return;
          }
          nodeToCopy = parent;
        }
      } else {
        SNode firstNode = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).first();
        SNode lastNode = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).last();
        String role = firstNode.getRole_();
        SNode parent = SNodeOperations.getParent(firstNode);
        SNode link = ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.getConceptDeclaration(parent), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "call_findLinkDeclaration_1213877394467", new Class[]{SNode.class, String.class}, role));
        if (link == null) {
          return;
        }
        for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("inputNodes"))).reversedList()) {
          parent.insertChild(lastNode, role, SNodeOperations.copyNode(node));
        }
        ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getEditorContext().selectRange(firstNode, lastNode);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CopyThisDown", t);
      }
    }
  }
}
