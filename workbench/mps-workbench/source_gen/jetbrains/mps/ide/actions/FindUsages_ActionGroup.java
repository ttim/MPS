package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;

public class FindUsages_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(FindUsages_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.FindUsages_ActionGroup";
  public static final String LABEL_ID_find_instances = ID + "find_instances";

  public FindUsages_ActionGroup() {
    super("FindUsages", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      FindUsages_ActionGroup.this.addAction("jetbrains.mps.ide.actions.FindSpecificNodeUsages_Action");
      {
        LabelledAnchor action = new LabelledAnchor(FindUsages_ActionGroup.LABEL_ID_find_instances);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        FindUsages_ActionGroup.this.addAction(action);
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
