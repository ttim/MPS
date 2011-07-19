package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class TextPreviewGroup_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(TextPreviewGroup_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.make.actions.TextPreviewGroup_ActionGroup";

  public TextPreviewGroup_ActionGroup() {
    super("TextPreviewGroup", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      TextPreviewGroup_ActionGroup.this.addAction("jetbrains.mps.ide.make.actions.TextPreviewModel_Action");
      TextPreviewGroup_ActionGroup.this.addAction("jetbrains.mps.ide.make.actions.ShowMappingsPartitioning_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
