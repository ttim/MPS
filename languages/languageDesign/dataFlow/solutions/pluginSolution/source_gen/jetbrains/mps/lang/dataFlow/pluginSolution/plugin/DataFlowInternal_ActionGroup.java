package jetbrains.mps.lang.dataFlow.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class DataFlowInternal_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(DataFlowInternal_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.dataFlow.pluginSolution.plugin.DataFlowInternal_ActionGroup";

  public DataFlowInternal_ActionGroup() {
    super("DataFlowInternal", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      DataFlowInternal_ActionGroup.this.addAction("jetbrains.mps.lang.dataFlow.pluginSolution.plugin.PrintDFAResult_Action");
      DataFlowInternal_ActionGroup.this.addAction("jetbrains.mps.lang.dataFlow.pluginSolution.plugin.PrintInitializationInformation_Action");
      DataFlowInternal_ActionGroup.this.addAction("jetbrains.mps.lang.dataFlow.pluginSolution.plugin.PrintReachingDefinintionsInformation_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
