package jetbrains.mps.ide.devkit.actions;

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
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.reloading.ClassLoaderManager;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import java.io.IOException;

public class ReloadAll_Action extends GeneratedAction {
  private static final Icon ICON = getIcon();
  protected static Log log = LogFactory.getLog(ReloadAll_Action.class);

  public ReloadAll_Action() {
    super("Reload All Classes", "Reload all MPS classes", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ReloadAll", t);
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
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ProgressManager.getInstance().run(new Task.Modal(((Project) MapSequence.fromMap(_params).get("project")), "Reloading Classes", false) {
        public void run(@NotNull final ProgressIndicator indicator) {
          indicator.setIndeterminate(true);
          ModelAccess.instance().runWriteAction(new Runnable() {
            public void run() {
              ClassLoaderManager.getInstance().reloadAll(indicator);
            }
          });
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ReloadAll", t);
      }
    }
  }

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(ReloadAll_Action.class.getResourceAsStream("reload.png")));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for ReloadAll", e);
      }
      return null;
    }
  }
}
