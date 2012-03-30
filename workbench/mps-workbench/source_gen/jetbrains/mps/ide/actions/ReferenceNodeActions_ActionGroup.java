package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ReferenceNodeActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ReferenceNodeActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ReferenceNodeActions_ActionGroup";

  public ReferenceNodeActions_ActionGroup() {
    super("ReferenceNodeActions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      ReferenceNodeActions_ActionGroup.this.addAction("jetbrains.mps.ide.actions.DeleteReferenceAction_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
