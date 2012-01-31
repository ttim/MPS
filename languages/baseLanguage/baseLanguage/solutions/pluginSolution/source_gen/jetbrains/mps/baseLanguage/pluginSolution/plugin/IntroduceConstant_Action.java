package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.IntroduceConstantRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.EditorComponent;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import java.awt.Frame;
import jetbrains.mps.nodeEditor.EditorContext;
import javax.swing.JOptionPane;

public class IntroduceConstant_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(IntroduceConstant_Action.class);

  public IntroduceConstant_Action() {
    super("Introduce Constant...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return IntroduceConstantRefactoring.isApplicable(((SNode) MapSequence.fromMap(_params).get("node"))) && !(((EditorComponent) MapSequence.fromMap(_params).get("component")).isReadOnly());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "IntroduceConstant", t);
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
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("component", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("component") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<IntroduceConstantRefactoring> refactoring = new Wrappers._T<IntroduceConstantRefactoring>();
      final Wrappers._T<String> error = new Wrappers._T<String>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          refactoring.value = new IntroduceConstantRefactoring();
          error.value = refactoring.value.init(((SNode) MapSequence.fromMap(_params).get("node")), ((EditorComponent) MapSequence.fromMap(_params).get("component")));
        }
      });
      if (error.value == null) {
        IntroduceConstantDialog dialog = new IntroduceConstantDialog(((Frame) MapSequence.fromMap(_params).get("frame")), refactoring.value, ((EditorContext) MapSequence.fromMap(_params).get("context")));
        dialog.showDialog();
      } else {
        JOptionPane.showMessageDialog(((EditorComponent) MapSequence.fromMap(_params).get("component")), error.value, "Error", JOptionPane.ERROR_MESSAGE);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "IntroduceConstant", t);
      }
    }
  }
}
