package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.CurrentProjectGroup;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.action.LabelledAnchor;
import jetbrains.mps.ide.actions.project.AddModuleToProjectAction;
import jetbrains.mps.ide.actions.project.RemoveModuleFromProjectAction;
import jetbrains.mps.ide.actions.module.GenerateAllModelsInModuleAction;
import jetbrains.mps.ide.actions.solution.GenerateTextFromAllModelsInSolutionAction;
import jetbrains.mps.ide.modelchecker.CheckSolutionAction;
import jetbrains.mps.ide.actions.solution.OptimizeSolutionImportsAction;
import jetbrains.mps.ide.classpath.AnalyzeClassPathAction;
import jetbrains.mps.ide.actions.make.MakeModuleAction;
import jetbrains.mps.ide.actions.make.RebuildModuleAction;
import jetbrains.mps.ide.actions.make.CleanModuleAction;
import jetbrains.mps.ide.actions.module.SetModuleFolderAction;
import jetbrains.mps.ide.actions.solution.SolutionPropertiesAction;

public class SolutionActions_ActionGroup extends CurrentProjectGroup {
  public static Logger LOG = Logger.getLogger(SolutionActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.SolutionActions";
  public static final String LABEL_ID_solutionNew = ID + "solutionNew";

  public SolutionActions_ActionGroup(Project project) {
    super("", ID, true, false, null, project);
    this.setPopup(false);
    try {
      this.add(new LabelledAnchor(SolutionActions_ActionGroup.LABEL_ID_solutionNew));
      this.addSeparator();
      this.add(new AddModuleToProjectAction());
      this.add(new RemoveModuleFromProjectAction());
      this.addSeparator();
      this.add(new GenerateAllModelsInModuleAction(true));
      this.add(new GenerateAllModelsInModuleAction(false));
      this.add(new GenerateTextFromAllModelsInSolutionAction());
      this.add(new CheckSolutionAction());
      this.add(new OptimizeSolutionImportsAction());
      this.add(new AnalyzeClassPathAction());
      this.addSeparator();
      this.add(new MakeModuleAction());
      this.add(new RebuildModuleAction());
      this.add(new CleanModuleAction());
      this.addSeparator();
      this.add(new SetModuleFolderAction());
      this.addSeparator();
      this.add(new SolutionPropertiesAction());
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
  }

}
