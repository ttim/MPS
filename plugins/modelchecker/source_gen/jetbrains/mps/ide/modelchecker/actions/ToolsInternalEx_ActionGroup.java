package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ToolsInternalEx_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ToolsInternalEx_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.modelchecker.actions.ToolsInternalEx_ActionGroup";

  public ToolsInternalEx_ActionGroup() {
    super("ToolsInternalEx", ID);
    this.setIsInternal(true);
    this.setPopup(false);
    try {
      ToolsInternalEx_ActionGroup.this.addAction("jetbrains.mps.ide.modelchecker.actions.FindlAllBrokenReferences_Action");
      ToolsInternalEx_ActionGroup.this.addAction("jetbrains.mps.ide.modelchecker.actions.FindWrongAspectDependencies_Action");
      ToolsInternalEx_ActionGroup.this.addAction("jetbrains.mps.ide.modelchecker.actions.FindAllAdapterUsages_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
