package jetbrains.mps.build.packaging.mps.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class InternalChecks_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(InternalChecks_ActionGroup.class);
  public static final String ID = "jetbrains.mps.build.packaging.mps.pluginSolution.plugin.InternalChecks_ActionGroup";

  public InternalChecks_ActionGroup() {
    super("Checks", ID);
    this.setIsInternal(true);
    this.setPopup(true);
    try {
      InternalChecks_ActionGroup.this.addAction("jetbrains.mps.build.packaging.mps.pluginSolution.plugin.CheckSamples_Action");
      InternalChecks_ActionGroup.this.addAction("jetbrains.mps.build.packaging.mps.pluginSolution.plugin.CheckCoreRuntimeDeps_Action");
      InternalChecks_ActionGroup.this.addAction("jetbrains.mps.build.packaging.mps.pluginSolution.plugin.CheckIncludedLanguages_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
