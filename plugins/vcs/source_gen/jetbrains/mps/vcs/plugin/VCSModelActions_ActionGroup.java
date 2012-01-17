package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class VCSModelActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(VCSModelActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.vcs.plugin.VCSModelActions_ActionGroup";

  public VCSModelActions_ActionGroup() {
    super("VCSModelActions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      VCSModelActions_ActionGroup.this.addAction("jetbrains.mps.vcs.plugin.ShowDifferencesWithModelOnDisk_Action");
      VCSModelActions_ActionGroup.this.addAction("jetbrains.mps.vcs.plugin.ReRunMergeFromBackup_Action");
      VCSModelActions_ActionGroup.this.addAction("jetbrains.mps.vcs.plugin.CompareTransientModels_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
