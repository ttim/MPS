package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ModelRefactoring_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ModelRefactoring_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ModelRefactoring_ActionGroup";

  public ModelRefactoring_ActionGroup() {
    super("Refactoring", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
      ModelRefactoring_ActionGroup.this.addAction("jetbrains.mps.ide.actions.RenameModel_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
