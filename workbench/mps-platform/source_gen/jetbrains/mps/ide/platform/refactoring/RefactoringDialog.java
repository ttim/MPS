package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import javax.swing.Action;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import com.intellij.refactoring.RefactoringBundle;
import java.awt.event.ActionEvent;

public abstract class RefactoringDialog extends DialogWrapper {
  protected Action myRefactorAction;
  protected final Project myProject;

  public RefactoringDialog(@NotNull Project project, boolean canBeParent) {
    super(project, canBeParent);
    myProject = project;
  }

  protected final Action getRefactorAction() {
    return myRefactorAction;
  }

  protected Action[] createActions() {
    List<Action> actions = ListSequence.fromList(new ArrayList<Action>());
    ListSequence.fromList(actions).addElement(getRefactorAction());
    ListSequence.fromList(actions).addElement(getCancelAction());
    return ListSequence.fromList(actions).toGenericArray(Action.class);
  }

  @Override
  protected void createDefaultActions() {
    super.createDefaultActions();
    myRefactorAction = new RefactoringDialog.RefactorAction();
  }

  /**
   * This method will be called on pressing "Refactor" button in dialog.
   * 
   */
  protected void doRefactoringAction() {
    close(OK_EXIT_CODE);
  }

  private class RefactorAction extends AbstractAction {
    public RefactorAction() {
      putValue(NAME, RefactoringBundle.message("refactor.button"));
      putValue(DialogWrapper.DEFAULT_ACTION, Boolean.TRUE);
    }

    public void actionPerformed(ActionEvent event) {
      doRefactoringAction();
    }
  }
}
