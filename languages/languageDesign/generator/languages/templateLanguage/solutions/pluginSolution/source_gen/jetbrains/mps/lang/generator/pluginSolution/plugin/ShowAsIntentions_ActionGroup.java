package jetbrains.mps.lang.generator.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ShowAsIntentions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ShowAsIntentions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.generator.pluginSolution.plugin.ShowAsIntentions_ActionGroup";

  public ShowAsIntentions_ActionGroup() {
    super("ShowAsIntentions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      ShowAsIntentions_ActionGroup.this.addAction("jetbrains.mps.lang.generator.pluginSolution.plugin.AttachMappingLabel_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
