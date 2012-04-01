package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import java.awt.Point;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.editor.runtime.ParametersInformation;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import java.awt.Component;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.ide.tooltips.MPSToolTipManager;
import jetbrains.mps.ide.tooltips.ToolTipData;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SNode;

public class ShowParameters_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowParameters_Action.class);

  public ShowParameters_Action() {
    super("Show Parameters", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (ShowParameters_Action.this.getCellNode(_params) == null) {
      return false;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowParameters", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editor", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editor") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("cell", event.getData(MPSEditorDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("cell") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Point p = new Point(((EditorCell) MapSequence.fromMap(_params).get("cell")).getX() + ((EditorCell) MapSequence.fromMap(_params).get("cell")).getWidth(), ((EditorCell) MapSequence.fromMap(_params).get("cell")).getY() + ((EditorCell) MapSequence.fromMap(_params).get("cell")).getHeight());
      EditorCell currentCell = ((EditorCell) MapSequence.fromMap(_params).get("cell"));
      while (currentCell != null) {
        ParametersInformation parametersInformation = currentCell.getStyle().get(StyleAttributes.PARAMETERS_INFORMATION);
        if (parametersInformation != null) {
          Component componet = parametersInformation.getComponent(currentCell.getSNode(), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
          MPSToolTipManager.getInstance().showToolTip(new ToolTipData(componet), ((EditorComponent) MapSequence.fromMap(_params).get("editor")), p);
          return;
        }
        currentCell = currentCell.getParent();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowParameters", t);
      }
    }
  }

  /*package*/ SNode getCellNode(final Map<String, Object> _params) {
    return ((EditorCell) MapSequence.fromMap(_params).get("cell")).getSNode();
  }
}
