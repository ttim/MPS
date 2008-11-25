package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleReference;
import jetbrains.mps.workbench.action.ActionFactory;
import jetbrains.mps.workbench.actions.project.AddModuleToProjectAction;
import jetbrains.mps.workbench.actions.module.DeleteModuleAction;
import jetbrains.mps.workbench.actions.module.GenerateAllModelsInModuleAction;
import jetbrains.mps.workbench.actions.solution.GenerateTextFromAllModelsInSolutionAction;
import jetbrains.mps.workbench.actions.solution.OptimizeSolutionImportsAction;
import jetbrains.mps.workbench.actions.module.ShowModuleDependenciesAction;

public class SolutionActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(SolutionActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.SolutionActions";
  public static final String LABEL_ID_solutionNew = ID + "solutionNew";
  public static final String LABEL_ID_refactoring = ID + "refactoring";

  public SolutionActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.addAnchor(SolutionActions_ActionGroup.LABEL_ID_solutionNew);
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(AddModuleToProjectAction.class, module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.RemoveModuleFromProject_Action"), module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(DeleteModuleAction.class, module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(GenerateAllModelsInModuleAction.class, module.getModuleFqName(), true));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(GenerateAllModelsInModuleAction.class, module.getModuleFqName(), false));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(GenerateTextFromAllModelsInSolutionAction.class, module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.CheckSolution_Action"), module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(OptimizeSolutionImportsAction.class, module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.AnalyzeClasspath_Action"), module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(ShowModuleDependenciesAction.class, module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.MakeModule_Action"), module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.RebuildModule_Action"), module.getModuleFqName()));
      }
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.CleanModule_Action"), module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.SetModuleFolder_Action"), module.getModuleFqName()));
      }
      this.addSeparator();
      {
        IModule module = MPSModuleRepository.getInstance().getModule(new ModuleReference("jetbrains.mps.ide"));
        this.add(ActionFactory.getInstance().acquireRegisteredAction(module.getClass("jetbrains.mps.ide.actions.SolutionProperties_Action"), module.getModuleFqName()));
      }
      this.addSeparator();
      this.addAnchor(SolutionActions_ActionGroup.LABEL_ID_refactoring);
      this.addSeparator();
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
