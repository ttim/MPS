package jetbrains.mps.vcs.plugin;

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
import java.util.List;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.vcs.changes.ChangeListManagerImpl;

public class AddToVcs_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddToVcs_Action.class);

  public AddToVcs_Action() {
    super("Add to VCS", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
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
        log.error("User's action doUpdate method failed. Action:" + "AddToVcs", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("modules", event.getData(MPSDataKeys.MODULES));
    if (MapSequence.fromMap(_params).get("modules") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      List<VirtualFile> unversionedFiles = VcsActionsHelper.getUnversionedFilesForModules(((Project) MapSequence.fromMap(_params).get("project")), ((List<IModule>) MapSequence.fromMap(_params).get("modules")));
      if (ListSequence.fromList(unversionedFiles).isEmpty()) {
        Messages.showInfoMessage(((Project) MapSequence.fromMap(_params).get("project")), "Nothing to add", "Add to VCS");
        return;
      }
      ChangeListManagerImpl changeListManager = ChangeListManagerImpl.getInstanceImpl(((Project) MapSequence.fromMap(_params).get("project")));
      changeListManager.addUnversionedFiles(changeListManager.getDefaultChangeList(), unversionedFiles);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddToVcs", t);
      }
    }
  }
}
