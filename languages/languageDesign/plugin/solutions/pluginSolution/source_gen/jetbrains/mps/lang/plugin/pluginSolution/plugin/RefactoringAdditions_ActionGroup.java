package jetbrains.mps.lang.plugin.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class RefactoringAdditions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(RefactoringAdditions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.plugin.pluginSolution.plugin.RefactoringAdditions_ActionGroup";

  public RefactoringAdditions_ActionGroup() {
    super("RefactoringAdditions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      RefactoringAdditions_ActionGroup.this.addAction("jetbrains.mps.lang.plugin.pluginSolution.plugin.SortKeymapMembers_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
