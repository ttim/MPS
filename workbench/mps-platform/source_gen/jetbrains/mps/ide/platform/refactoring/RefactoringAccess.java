package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelDescriptor;

public abstract class RefactoringAccess {
  private static RefactoringAccess ourInstance;

  public RefactoringAccess() {
  }

  public abstract RefactoringFacade getRefactoringFacade();

  public abstract ModelElementTargetChooser createTargetChooser(Project project, SNode node);

  public abstract ModelElementTargetChooser createTargetChooser(Project project, SModelDescriptor model);

  public static RefactoringAccess getInstance() {
    return ourInstance;
  }

  protected static void setInstance(RefactoringAccess instance) {
    ourInstance = instance;
  }
}
