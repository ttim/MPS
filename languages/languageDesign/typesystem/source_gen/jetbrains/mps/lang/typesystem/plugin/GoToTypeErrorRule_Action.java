package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.nodeEditor.GoToTypeErrorRuleUtil;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.util.Pair;

public class GoToTypeErrorRule_Action extends BaseAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(GoToTypeErrorRule_Action.class);

  public GoToTypeErrorRule_Action() {
    super("Go to Rule Which Caused Error", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    IErrorReporter error = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getErrorReporterFor(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectedCell());
    return !(error == null || error.getRuleId() == null || error.getRuleModel() == null || !(error.getAdditionalRulesIds().isEmpty()));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "GoToTypeErrorRule", t);
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
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    if (MapSequence.fromMap(_params).get("node") == null) {
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
      IErrorReporter error = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getErrorReporterFor(((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectedCell());
      GoToTypeErrorRuleUtil.goToRuleById(((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), new Pair<String, String>(error.getRuleModel(), error.getRuleId()));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "GoToTypeErrorRule", t);
    }
  }
}
