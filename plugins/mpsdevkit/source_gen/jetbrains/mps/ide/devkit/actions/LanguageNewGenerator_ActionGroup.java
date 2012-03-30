package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class LanguageNewGenerator_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(LanguageNewGenerator_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.devkit.actions.LanguageNewGenerator_ActionGroup";

  public LanguageNewGenerator_ActionGroup() {
    super("LanguageNewGenerator", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      LanguageNewGenerator_ActionGroup.this.addAction("jetbrains.mps.ide.devkit.actions.NewGenerator_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
