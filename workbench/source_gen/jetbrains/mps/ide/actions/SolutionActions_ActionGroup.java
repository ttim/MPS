package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.BaseActionGroup;
import jetbrains.mps.ide.actions.project.AddModuleToProjectAction;
import jetbrains.mps.ide.actions.project.RemoveModuleFromProjectAction;
import jetbrains.mps.ide.actions.solution.GenerateAllModelsInSolutionAction_true;
import jetbrains.mps.ide.actions.solution.GenerateAllModelsInSolutionAction_false;
import jetbrains.mps.ide.actions.solution.GenerateTextFromAllModelsInSolutionAction;
import jetbrains.mps.ide.modelchecker.CheckSolutionAction;
import jetbrains.mps.ide.actions.solution.OptimizeSolutionImportsAction;
import jetbrains.mps.ide.actions.make.MakeModuleAction;
import jetbrains.mps.ide.actions.make.CleanModuleAction;
import jetbrains.mps.ide.actions.module.SetModuleFolderAction;
import jetbrains.mps.ide.actions.solution.SolutionPropertiesAction;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.ide.action.IActionGroupElementOwner;

public class SolutionActions_ActionGroup extends BaseActionGroup {

  public SolutionActions_ActionGroup() {
    super("", "jetbrains.mps.ide.actions.SolutionActions");
    this.setMnemonic("".charAt(0));
    this.setInternal(false);
    this.add(new solutionNew_ExtentionPoint());
    this.addSeparator();
    this.add(new AddModuleToProjectAction());
    this.add(new RemoveModuleFromProjectAction());
    this.addSeparator();
    this.add(new GenerateAllModelsInSolutionAction_true());
    this.add(new GenerateAllModelsInSolutionAction_false());
    this.add(new GenerateTextFromAllModelsInSolutionAction());
    this.add(new CheckSolutionAction());
    this.add(new OptimizeSolutionImportsAction());
    this.addSeparator();
    this.add(new MakeModuleAction());
    this.add(new CleanModuleAction());
    this.addSeparator();
    this.add(new SetModuleFolderAction());
    this.addSeparator();
    this.add(new SolutionPropertiesAction());
  }

  public void adjust(ActionManager manager, IActionGroupElementOwner owner) {
  }

}
