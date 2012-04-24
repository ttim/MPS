package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class OptionalMigrations_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(OptionalMigrations_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.migration.migration25.OptionalMigrations_ActionGroup";

  public OptionalMigrations_ActionGroup() {
    super("Optional", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
      OptionalMigrations_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MovePluginsOutOfLanguages_Action");
      OptionalMigrations_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.CorrectIconsAfterPluhinMove_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
