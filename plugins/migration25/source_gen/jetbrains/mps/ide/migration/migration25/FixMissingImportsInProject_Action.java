package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import java.util.Queue;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.kernel.model.MissingDependenciesFixer;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.progress.EmptyProgressMonitor;

public class FixMissingImportsInProject_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(FixMissingImportsInProject_Action.class);

  public FixMissingImportsInProject_Action() {
    super("Fix Missing Imports", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FixMissingImportsInProject", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Queue<IModule> modules = QueueSequence.fromQueueWithValues(new LinkedList<IModule>(), ((Project) MapSequence.fromMap(_params).get("project")).getComponent(MPSProject.class).getModules());
      while (QueueSequence.fromQueue(modules).isNotEmpty()) {
        IModule module = QueueSequence.fromQueue(modules).removeFirstElement();
        if (module.isPackaged()) {
          continue;
        }
        if (module instanceof Language) {
          QueueSequence.fromQueue(modules).addSequence(CollectionSequence.fromCollection(((Language) module).getGenerators()));
        }
        for (SModelDescriptor model : ListSequence.fromList(module.getOwnModelDescriptors())) {
          if (!(SModelStereotype.isUserModel(model))) {
            continue;
          }
          if (!(model instanceof EditableSModelDescriptor)) {
            continue;
          }

          new MissingDependenciesFixer(model).fix(false);
          module.invalidateCaches();
        }
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FixMissingImportsInProject", t);
      }
    }
  }
}
