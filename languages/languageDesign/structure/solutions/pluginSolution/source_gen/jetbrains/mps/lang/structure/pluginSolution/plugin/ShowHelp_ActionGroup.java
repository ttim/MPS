package jetbrains.mps.lang.structure.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ShowHelp_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ShowHelp_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.structure.pluginSolution.plugin.ShowHelp_ActionGroup";

  public ShowHelp_ActionGroup() {
    super("ShowHelp", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      ShowHelp_ActionGroup.this.addAction("jetbrains.mps.lang.structure.pluginSolution.plugin.ShowDefaultHelp_Action");
      ShowHelp_ActionGroup.this.addAction("jetbrains.mps.lang.structure.pluginSolution.plugin.ShowHelpForNode_Action");
      ShowHelp_ActionGroup.this.addAction("jetbrains.mps.lang.structure.pluginSolution.plugin.ShowHelpForRoot_Action");
      ShowHelp_ActionGroup.this.addAction("jetbrains.mps.lang.structure.pluginSolution.plugin.ShowHelpForAspect_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
