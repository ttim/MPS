package jetbrains.mps.ide.refactoring;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.MPSCoreComponents;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.platform.refactoring.ModelElementTargetChooser;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.ide.platform.refactoring.RefactoringFacade;
import jetbrains.mps.ide.platform.refactoring.RefactoringViewAction;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class RefactoringAccessImpl extends RefactoringAccess implements ApplicationComponent {
  private RefactoringFacade myRefactoringFacade;

  public RefactoringAccessImpl(MPSCoreComponents coreComponents) {
  }

  public void initComponent() {
    RefactoringAccess.setInstance(this);
  }

  public void disposeComponent() {
    RefactoringAccess.setInstance(null);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "MPS Workbench-specific Refactoring Access implementation";
  }

  public ModelElementTargetChooser createTargetChooser(Project project, SModelDescriptor model) {
    return new ModelOrNodeChooser(project, model);
  }

  public ModelElementTargetChooser createTargetChooser(Project project, SNode node) {
    return new ModelOrNodeChooser(project, node);
  }

  public void showRefactoringView(Project project, RefactoringViewAction callback, SearchResults searchResults, boolean hasModelsToGenerate, String name) {
    RefactoringView refactoringView = project.getComponent(RefactoringView.class);
    refactoringView.showRefactoringView(project, callback, searchResults, hasModelsToGenerate, name);
  }

  public RefactoringFacade getRefactoringFacade() {
    if (myRefactoringFacade == null) {
      myRefactoringFacade = new RefactoringFacadeImpl();
    }
    return myRefactoringFacade;
  }
}
