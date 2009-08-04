package jetbrains.mps.lang.test.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.ide.actions.EditorInternal_ActionGroup;

public class EditorInternalAddition_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(EditorInternalAddition_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.test.plugin.EditorInternalAddition";

  public EditorInternalAddition_ActionGroup() {
    super("EditorInternalAddition", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      EditorInternalAddition_ActionGroup.this.addAction("jetbrains.mps.lang.test.plugin.RunTestInMPS_Action", "jetbrains.mps.lang.test");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    this.insertGroupIntoAnother(EditorInternal_ActionGroup.ID, null);
  }

}
