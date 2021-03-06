package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.devkit.newDevkitDialog.NewDevKitDialog;
import java.awt.Frame;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.StandaloneMPSProject;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;

public class NewDevKit_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("devkit.png");
  protected static Log log = LogFactory.getLog(NewDevKit_Action.class);

  public NewDevKit_Action() {
    super("DevKit", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewDevKit", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("ideaProject", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("ideaProject") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("namespace", event.getData(MPSDataKeys.NAMESPACE));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      NewDevKitDialog dialog = new NewDevKitDialog(((Frame) MapSequence.fromMap(_params).get("frame")));
      dialog.setProject(((MPSProject) MapSequence.fromMap(_params).get("project")));
      dialog.showDialog();
      final DevKit devkit = dialog.getResult();
      if (devkit == null) {
        return;
      }
      ModelAccess.instance().runWriteAction(new Runnable() {
        public void run() {
          ((StandaloneMPSProject) ((MPSProject) MapSequence.fromMap(_params).get("project"))).setFolderFor(devkit, (((String) MapSequence.fromMap(_params).get("namespace")) == null ?
            "" :
            ((String) MapSequence.fromMap(_params).get("namespace"))
          ));
        }
      });
      ProjectPane projectPane = ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("ideaProject")));
      projectPane.rebuildTree();
      projectPane.selectModule(devkit, false);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewDevKit", t);
      }
    }
  }
}
