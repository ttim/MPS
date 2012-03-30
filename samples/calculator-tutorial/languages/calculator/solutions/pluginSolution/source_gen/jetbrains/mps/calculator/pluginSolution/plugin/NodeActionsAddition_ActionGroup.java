package jetbrains.mps.calculator.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class NodeActionsAddition_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(NodeActionsAddition_ActionGroup.class);
  public static final String ID = "jetbrains.mps.calculator.pluginSolution.plugin.NodeActionsAddition_ActionGroup";

  public NodeActionsAddition_ActionGroup() {
    super("NodeActionsAddition", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      NodeActionsAddition_ActionGroup.this.addAction("jetbrains.mps.calculator.pluginSolution.plugin.ExecuteCalculator_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
