package jetbrains.mps.lang.behavior.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import java.awt.Frame;
import jetbrains.mps.ide.actions.StratergyAddMethodDialog;
import jetbrains.mps.ide.actions.AddConceptMethodStrategy;
import jetbrains.mps.ide.actions.MethodsToImplementStrategy;
import jetbrains.mps.ide.actions.ImplementMethodStrategy;

public class ImplementBehaviorMethod_Action extends BaseAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ImplementBehaviorMethod_Action.class);

  public ImplementBehaviorMethod_Action() {
    super("Implement Behavior Method...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
    this.setMnemonic("I".charAt(0));
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return !(((EditorContext) MapSequence.fromMap(_params).get("editorContext")).isInspector()) && (SNodeOperations.getAncestor(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false) != null);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ImplementBehaviorMethod", t);
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
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Project project = ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")).getProject();
      Frame frame = ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getMainFrame();
      new StratergyAddMethodDialog(((EditorContext) MapSequence.fromMap(_params).get("editorContext")), frame, new AddConceptMethodStrategy(((SNode) MapSequence.fromMap(_params).get("selectedNode"))), new MethodsToImplementStrategy(), new ImplementMethodStrategy(project)).showDialog();

    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ImplementBehaviorMethod", t);
    }
  }
}
