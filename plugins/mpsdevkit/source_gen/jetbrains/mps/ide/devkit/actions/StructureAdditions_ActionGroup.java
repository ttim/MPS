package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class StructureAdditions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(StructureAdditions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.devkit.actions.StructureAdditions_ActionGroup";

  public StructureAdditions_ActionGroup() {
    super("StructureAdditions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      StructureAdditions_ActionGroup.this.addAction("jetbrains.mps.ide.devkit.actions.ShowStructure_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
