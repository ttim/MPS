package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.ide.actions.Tools_ActionGroup;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.Anchor;

public class ToolsInternal_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ToolsInternal_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Internal";

  public ToolsInternal_ActionGroup() {
    super("Internal", ID);
    this.setIsInternal(true);
    this.setPopup(false);
    try {
      this.addAction("jetbrains.mps.ide.actions.RemoveTransientModels_Action", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.ide.actions.DumpKeyStrokes_Action", "jetbrains.mps.ide");
      this.addSeparator();
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    ActionUtils.getGroup(Tools_ActionGroup.ID).add(this, new Constraints(Anchor.AFTER, Tools_ActionGroup.INTERNAL_LABEL_ID_Internal));
  }

}
