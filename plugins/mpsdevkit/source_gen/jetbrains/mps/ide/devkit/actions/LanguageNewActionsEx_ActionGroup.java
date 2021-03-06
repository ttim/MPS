package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class LanguageNewActionsEx_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(LanguageNewActionsEx_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.devkit.actions.LanguageNewActionsEx_ActionGroup";

  public LanguageNewActionsEx_ActionGroup() {
    super("LanguageNewActionsEx", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      LanguageNewActionsEx_ActionGroup.this.addAction("jetbrains.mps.ide.devkit.actions.NewAccessoryModel_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
