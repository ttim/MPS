package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleReference;
import jetbrains.mps.workbench.action.ActionFactory;
import jetbrains.mps.workbench.actions.language.GenerateTemplateQueriesAction;
import jetbrains.mps.workbench.actions.module.ShowModuleDependenciesAction;
import jetbrains.mps.workbench.actions.language.DeleteGeneratorAction;

public class GeneratorActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(GeneratorActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.GeneratorActions";
  public static final String LABEL_ID_generatorNew = ID + "generatorNew";

  public GeneratorActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.addAnchor(GeneratorActions_ActionGroup.LABEL_ID_generatorNew);
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(GenerateTemplateQueriesAction.class, module.getModuleFqName(), true));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(GenerateTemplateQueriesAction.class, module.getModuleFqName(), false));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(ShowModuleDependenciesAction.class, module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(DeleteGeneratorAction.class, module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.CheckGenerator_Action"), module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.GeneratorProperties_Action"), module.getModuleFqName()));
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
