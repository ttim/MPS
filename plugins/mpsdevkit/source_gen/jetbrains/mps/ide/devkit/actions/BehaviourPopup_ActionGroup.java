package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class BehaviourPopup_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(BehaviourPopup_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.devkit.actions.BehaviourPopup_ActionGroup";

  public BehaviourPopup_ActionGroup() {
    super("BehaviourPopup", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      BehaviourPopup_ActionGroup.this.addAction("jetbrains.mps.ide.devkit.actions.GoToOverridingMethod_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
