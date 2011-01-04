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
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.ide.DataManager;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.ui.popup.ListPopup;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.workbench.action.ActionFactory;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.awt.RelativePoint;
import java.awt.Point;

public class GenerationIntentions_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GenerationIntentions_Action.class);

  public GenerationIntentions_Action() {
    super("Show Generation Intentions Menu", "Shows the popup menu with available generation intentions", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GenerationIntentions", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final EditorCell selectedCell = ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getSelectedCell();
      int x = selectedCell.getX();
      int y = selectedCell.getY();
      if (selectedCell instanceof EditorCell_Label) {
        y += ((EditorCell_Label) selectedCell).getHeight();
      }
      final DataContext dataContext = DataManager.getInstance().getDataContext(((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getNodeEditorComponent(), x, y);
      final Wrappers._T<ListPopup> popup = new Wrappers._T<ListPopup>(null);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          ActionGroup group = ActionFactory.getInstance().acquireRegisteredGroup("jetbrains.mps.ide.actions.GenerationIntentions_ActionGroup", "jetbrains.mps.ide");
          group.update(event);
          if (group.getChildren(event).length == 0) {
            return;
          }
          popup.value = JBPopupFactory.getInstance().createActionGroupPopup("Generate", group, dataContext, JBPopupFactory.ActionSelectionAid.NUMBERING, false);
        }
      });
      if (popup.value == null) {
        return;
      }

      RelativePoint relativePoint = new RelativePoint(((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getNodeEditorComponent(), new Point(x, y));
      popup.value.show(relativePoint);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GenerationIntentions", t);
      }
    }
  }
}
