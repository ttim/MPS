package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class JUnitTestCaseActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(JUnitTestCaseActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.JUnitTestCaseActions_ActionGroup";

  public JUnitTestCaseActions_ActionGroup() {
    super("JUnitTestCaseActions", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
