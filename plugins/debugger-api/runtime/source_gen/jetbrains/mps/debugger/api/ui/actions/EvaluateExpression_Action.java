package jetbrains.mps.debugger.api.ui.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.debug.api.evaluation.IEvaluationProvider;
import jetbrains.mps.debugger.api.ui.DebugActionsUtil;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import java.util.List;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.selection.Selection;
import jetbrains.mps.nodeEditor.selection.EditorCellLabelSelection;
import jetbrains.mps.nodeEditor.selection.EditorCellSelection;
import jetbrains.mps.nodeEditor.selection.MultipleSelection;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.IOperationContext;

public class EvaluateExpression_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("evaluate.png");
  protected static Log log = LogFactory.getLog(EvaluateExpression_Action.class);

  public EvaluateExpression_Action() {
    super("Evaluate Expression", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        IEvaluationProvider evaluationProvider = DebugActionsUtil.getEvaluationProvider(event);
        event.getPresentation().setEnabled(evaluationProvider != null && evaluationProvider.canEvaluate());
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "EvaluateExpression", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("component", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      IEvaluationProvider evaluationProvider = DebugActionsUtil.getEvaluationProvider(event);
      if (evaluationProvider != null) {
        final List<SNodePointer> nodePointers = ListSequence.fromList(new ArrayList<SNodePointer>());
        if (((EditorComponent) MapSequence.fromMap(_params).get("component")) != null) {
          final Selection selection = ((EditorComponent) MapSequence.fromMap(_params).get("component")).getSelectionManager().getSelection();
          if ((selection instanceof EditorCellLabelSelection && ((EditorCellLabelSelection) selection).hasNonTrivialSelection()) || (selection instanceof EditorCellSelection && !((selection instanceof EditorCellLabelSelection))) || (selection instanceof MultipleSelection)) {
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                ListSequence.fromList(nodePointers).addSequence(Sequence.fromIterable(Sequence.fromClosure(new ISequenceClosure<SNode>() {
                  public Iterable<SNode> iterable() {
                    return selection.getSelectedNodes();
                  }
                })).select(new ISelector<SNode, SNodePointer>() {
                  public SNodePointer select(SNode it) {
                    return new SNodePointer(it);
                  }
                }));
              }
            });
          }
        }
        evaluationProvider.showEvaluationDialog(((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), nodePointers);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "EvaluateExpression", t);
      }
    }
  }
}
