package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleReference;
import jetbrains.mps.workbench.action.ActionFactory;

public class TransientModulesActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(TransientModulesActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.TransientModulesActions";

  public TransientModulesActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.RemoveTransientModels_Action"), module.getModuleFqName()));
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
