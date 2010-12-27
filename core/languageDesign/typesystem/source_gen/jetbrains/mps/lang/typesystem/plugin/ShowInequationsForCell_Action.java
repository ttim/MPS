package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.cellMenu.NodeSubstituteInfo;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.typesystem.inference.InequationSystem;
import javax.swing.JOptionPane;

public class ShowInequationsForCell_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowInequationsForCell_Action.class);

  public ShowInequationsForCell_Action() {
    super("Show Inequalities for Cell", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowInequationsForCell", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("selectedCell", event.getData(MPSDataKeys.EDITOR_CELL));
    if (MapSequence.fromMap(_params).get("selectedCell") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      NodeSubstituteInfo substituteInfo = ((EditorCell) MapSequence.fromMap(_params).get("selectedCell")).getSubstituteInfo();
      InequationSystem inequationSystem = substituteInfo.getInequationSystem(((EditorCell) MapSequence.fromMap(_params).get("selectedCell")));
      if (inequationSystem == null) {
        JOptionPane.showMessageDialog(null, "no inequation system");
      } else {
        JOptionPane.showMessageDialog(null, inequationSystem.getPresentation());
      }
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowInequationsForCell", t);
    }
  }
}
