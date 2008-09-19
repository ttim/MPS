package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;

public class FileActions_ActionGroup extends GeneratedActionGroup {
  public static Logger LOG = Logger.getLogger(FileActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.FileActions";
  public static final String LABEL_ID_abstractFileActions = ID + "abstractFileActions";

  public FileActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.addAnchor(FileActions_ActionGroup.LABEL_ID_abstractFileActions);
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
  }

}
