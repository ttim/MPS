package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ModelNewActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ModelNewActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ModelNewActions";
  public static final String LABEL_ID_newRoot = ID + "newRoot";

  public ModelNewActions_ActionGroup() {
    super("New", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
      ModelNewActions_ActionGroup.this.addAnchor(ModelNewActions_ActionGroup.LABEL_ID_newRoot);
      ModelNewActions_ActionGroup.this.addSeparator();
      ModelNewActions_ActionGroup.this.addAction("jetbrains.mps.ide.actions.NewSubModel_Action", "jetbrains.mps.ide");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    this.insertGroupIntoAnother(ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_newActions);
  }
}
