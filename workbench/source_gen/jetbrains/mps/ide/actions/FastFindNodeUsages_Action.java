package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;

public class FastFindNodeUsages_Action extends GeneratedAction {
  private static final Icon ICON = new ImageIcon(FastFindNodeUsages_Action.class.getResource("find.png"));
  protected static Log log = LogFactory.getLog(FastFindNodeUsages_Action.class);

  public FastFindNodeUsages_Action() {
    super("Find Usages (Without Options Dialog)", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return new FindUsagesHelper(((Project) MapSequence.<String,Object>fromMap(_params).get("project")), false).isApplicable();
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FastFindNodeUsages", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.<String,Object>fromMap(_params).put("node", node);
    }
    if (MapSequence.<String,Object>fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("cell", event.getData(MPSDataKeys.EDITOR_CELL));
    MapSequence.<String,Object>fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.<String,Object>fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.<String,Object>fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    if (MapSequence.<String,Object>fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      new FindUsagesHelper(((Project) MapSequence.<String,Object>fromMap(_params).get("project")), false).invoke(((EditorCell) MapSequence.<String,Object>fromMap(_params).get("cell")), ((SNode) MapSequence.<String,Object>fromMap(_params).get("node")), ((Frame) MapSequence.<String,Object>fromMap(_params).get("frame")), ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")), ((SModelDescriptor) MapSequence.<String,Object>fromMap(_params).get("model")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FastFindNodeUsages", t);
      }
    }
  }
}
