package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class PackageActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(PackageActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.PackageActions";
  public static final String LABEL_ID_newActions = ID + "newActions";

  public PackageActions_ActionGroup() {
    super("PackageActions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      PackageActions_ActionGroup.this.addAnchor(PackageActions_ActionGroup.LABEL_ID_newActions);
      PackageActions_ActionGroup.this.addSeparator();
      PackageActions_ActionGroup.this.addAction("jetbrains.mps.ide.actions.PasteNode_Action", "jetbrains.mps.ide");
      PackageActions_ActionGroup.this.addSeparator();
      PackageActions_ActionGroup.this.addAction("jetbrains.mps.ide.actions.RenamePackage_Action", "jetbrains.mps.ide");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
