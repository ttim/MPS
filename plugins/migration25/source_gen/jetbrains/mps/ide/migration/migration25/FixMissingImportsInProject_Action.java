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
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
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

  @Override
  public boolean isDumbAware() {
    return true;
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
      Queue<ModuleReference> modules = QueueSequence.fromQueueWithValues(new LinkedList<ModuleReference>(), ((Project) MapSequence.fromMap(_params).get("project")).getComponent(MPSProject.class).getModuleReferences());
      while (QueueSequence.fromQueue(modules).isNotEmpty()) {
        IModule module = ModuleRepositoryFacade.getInstance().getModule(QueueSequence.fromQueue(modules).removeFirstElement());
        if (module.isPackaged()) {
          continue;
        }
        if (module instanceof Language) {
          Iterable<Generator> generators = ((Language) module).getGenerators();
          QueueSequence.fromQueue(modules).addSequence(Sequence.fromIterable(generators).select(new ISelector<Generator, ModuleReference>() {
            public ModuleReference select(Generator it) {
              return it.getModuleReference();
            }
          }));
        }
        for (SModelDescriptor model : ListSequence.fromList(module.getOwnModelDescriptors())) {
          if (!(SModelStereotype.isUserModel(model))) {
            continue;
          }
          if (!(model instanceof EditableSModelDescriptor)) {
            continue;
          }

          new MissingDependenciesFixer(model).fix(false);
        }
        module.invalidateCaches();
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
