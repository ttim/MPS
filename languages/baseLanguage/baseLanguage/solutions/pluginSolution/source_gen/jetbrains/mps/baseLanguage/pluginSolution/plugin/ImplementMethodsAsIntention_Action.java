package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.actions.OverrideImplementMethodAction;
import jetbrains.mps.nodeEditor.EditorContext;

public class ImplementMethodsAsIntention_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ImplementMethodsAsIntention_Action.class);

  public ImplementMethodsAsIntention_Action() {
    super("Implement Methods", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return SNodeOperations.isInstanceOf(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.baseLanguage.structure.ClassConcept") && ListSequence.fromList(((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.cast(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.baseLanguage.structure.ClassConcept"), "jetbrains.mps.baseLanguage.structure.IMemberContainer"), "virtual_getMethodsToImplement_5418393554803775106", new Class[]{SNode.class}))).isNotEmpty();
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ImplementMethodsAsIntention", t);
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
      final Project project = ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")).getProject();
      new OverrideImplementMethodAction(project, ((SNode) MapSequence.fromMap(_params).get("selectedNode")), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")), false).run();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ImplementMethodsAsIntention", t);
      }
    }
  }
}
