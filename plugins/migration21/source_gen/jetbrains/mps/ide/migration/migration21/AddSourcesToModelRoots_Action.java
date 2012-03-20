package jetbrains.mps.ide.migration.migration21;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import java.util.Collection;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.model.ModelRootManager;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.progress.EmptyProgressMonitor;

public class AddSourcesToModelRoots_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddSourcesToModelRoots_Action.class);

  public AddSourcesToModelRoots_Action() {
    super("Add classes__gen to Model Roots for Modules With Sources", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AddSourcesToModelRoots", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      for (IModule module : ListSequence.fromList(MPSModuleRepository.getInstance().getAllModules())) {
        ModuleDescriptor descriptor = module.getModuleDescriptor();
        if (descriptor == null) {
          continue;
        }

        Collection<String> sp = descriptor.getSourcePaths();
        if (sp == null || sp.isEmpty()) {
          continue;
        }

        ModelRoot mr = new ModelRoot();
        mr.setPath(module.getClassesGen().getPath());
        mr.setManager(new ModelRootManager(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("f3061a53-9226-4cc5-a443-f952ceaf5816")).getModuleReference().getModuleId().toString(), "jetbrains.mps.baseLanguage.stubs.JavaStubs"));

        Collection<ModelRoot> mrs = descriptor.getModelRoots();
        if (!(mrs.contains(mr))) {
          mrs.add(mr);
        }

        module.setModuleDescriptor(descriptor, false);
        module.save();
      }

      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddSourcesToModelRoots", t);
      }
    }
  }
}
