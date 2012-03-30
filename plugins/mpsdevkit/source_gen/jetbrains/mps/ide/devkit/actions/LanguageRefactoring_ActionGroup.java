package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class LanguageRefactoring_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(LanguageRefactoring_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.devkit.actions.LanguageRefactoring_ActionGroup";

  public LanguageRefactoring_ActionGroup() {
    super("Refactoring", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      LanguageRefactoring_ActionGroup.this.addAction("jetbrains.mps.ide.devkit.actions.RenameLanguage_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
