package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.util.Computable;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.Solution;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;

public class SolutionChooser implements Computable<List<ModuleReference>> {
  private final IBindedDialog myOwner;

  public SolutionChooser(IBindedDialog owner) {
    myOwner = owner;
  }

  public List<ModuleReference> compute() {
    final Wrappers._T<List<ModuleReference>> solRefs = new Wrappers._T<List<ModuleReference>>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        List<Solution> solutions = (List<Solution>) ModuleRepositoryFacade.getInstance().getAllModules(Solution.class);
        solRefs.value = ListSequence.fromList(solutions).select(new ISelector<Solution, ModuleReference>() {
          public ModuleReference select(Solution it) {
            return it.getModuleReference();
          }
        }).toListSequence();
      }
    });
    return CommonChoosers.showDialogModuleCollectionChooser(myOwner.getMainComponent(), "solution", solRefs.value, null);
  }
}
