package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.vcs.diff.ui.ModelDifferenceDialog;
import jetbrains.mps.vcs.diff.ui.common.SimpleDiffRequest;
import com.intellij.openapi.project.Project;

public class ShowDifferencesWithModelOnDisk_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowDifferencesWithModelOnDisk_Action.class);

  public ShowDifferencesWithModelOnDisk_Action() {
    super("Show Differences with Model on Disk", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((SModelDescriptor) MapSequence.fromMap(_params).get("modelDescriptor")) instanceof EditableSModelDescriptor;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowDifferencesWithModelOnDisk", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("modelDescriptor", event.getData(MPSCommonDataKeys.MODEL));
    if (MapSequence.fromMap(_params).get("modelDescriptor") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SModel memory = ((SModelDescriptor) MapSequence.fromMap(_params).get("modelDescriptor")).getSModel();
      final SModel disk = ModelPersistence.readModel(((EditableSModelDescriptor) ((SModelDescriptor) MapSequence.fromMap(_params).get("modelDescriptor"))).getModelFile(), false);
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          new ModelDifferenceDialog(disk, memory, new SimpleDiffRequest(((Project) MapSequence.fromMap(_params).get("project")), "Disk", "Memory")).showDialog();
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowDifferencesWithModelOnDisk", t);
      }
    }
  }
}
