package jetbrains.mps.lang.refactoring.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.refactoring.framework.IRefactoring;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.refactoring.framework.IRefactoringTarget;

public class ModelRefactorings_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ModelRefactorings_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.refactoring.plugin.ModelRefactorings_ActionGroup";

  public ModelRefactorings_ActionGroup() {
    super("ModelRefactorings", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      for (IRefactoring refactoring : ListSequence.fromList(RefactoringUtil.getAllRefactorings())) {
        if (refactoring.getRefactoringTarget().getTarget() == IRefactoringTarget.TargetType.MODEL) {
          ModelRefactorings_ActionGroup.this.add(RefactoringHelper.getActionForRefactoring(refactoring));
        }
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
