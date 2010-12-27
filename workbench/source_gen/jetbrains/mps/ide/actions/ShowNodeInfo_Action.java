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
import java.awt.Point;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import javax.swing.SwingUtilities;
import jetbrains.mps.nodeEditor.EditorComponent;
import java.awt.Frame;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.NodeInformationDialog;

public class ShowNodeInfo_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowNodeInfo_Action.class);

  public ShowNodeInfo_Action() {
    super("Show Node Info", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
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
        log.error("User's action doUpdate method failed. Action:" + "ShowNodeInfo", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editor", event.getData(MPSDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editor") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("cell", event.getData(MPSDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("cell") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSDataKeys.NODE));
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Point point = new Point(((EditorCell) MapSequence.fromMap(_params).get("cell")).getX() + ((EditorCell) MapSequence.fromMap(_params).get("cell")).getWidth(), ((EditorCell) MapSequence.fromMap(_params).get("cell")).getY());
      SwingUtilities.convertPointToScreen(point, ((EditorComponent) MapSequence.fromMap(_params).get("editor")));
      // Displaying this action in .invokeLater call to let popup menu be disposed first ( <node> will be diposed immediately by corresponding events otherwise) 
      final Frame frame = ((Frame) MapSequence.fromMap(_params).get("frame"));
      final SNode node = ((SNode) MapSequence.fromMap(_params).get("node"));
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          new NodeInformationDialog(frame, point, node).setVisible(true);
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowNodeInfo", t);
      }
    }
  }
}
