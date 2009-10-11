package jetbrains.mps.lang.core.refactorings;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseRefactoring;
import jetbrains.mps.refactoring.framework.IRefactoringTarget;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.core.scripts.RenameUtil;
import jetbrains.mps.refactoring.framework.paramchooser.mps.MPSChooserFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.view.FindUtils;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModel;

public class Rename extends BaseRefactoring {
  public Rename() {
    this.addTransientParameter("newName");
  }

  public String getUserFriendlyName() {
    return "Rename";
  }

  public String getKeyStroke() {
    return getKeyStroke_static();
  }

  public IRefactoringTarget getRefactoringTarget() {
    return new Rename_Target();
  }

  public boolean init(final RefactoringContext refactoringContext) {
    final Wrappers._boolean result = new Wrappers._boolean();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        result.value = RenameUtil.canBeRenamed(refactoringContext.getSelectedNode());
      }
    });
    if (!(result.value)) {
      return false;
    }
    return Rename.this.ask(refactoringContext, MPSChooserFactory.createStringChooser(refactoringContext, "newName", new Rename_newName_Settings(refactoringContext)));
  }

  public void refactor(final RefactoringContext refactoringContext) {
    SPropertyOperations.set(refactoringContext.getSelectedNode(), "name", ((String)refactoringContext.getParameter("newName")));
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    return FindUtils.getSearchResults(new EmptyProgressIndicator(), refactoringContext.getSelectedNode(), GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder");
  }

  public void updateModel(final SModel model, final RefactoringContext refactoringContext) {
  }

  public static String getKeyStroke_static() {
    return "shift F6";
  }
}
