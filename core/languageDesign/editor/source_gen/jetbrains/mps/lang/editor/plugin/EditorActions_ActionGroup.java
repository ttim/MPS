package jetbrains.mps.lang.editor.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.ide.actions.EditorPopup_ActionGroup;
import jetbrains.mps.ide.actions.Edit_ActionGroup;

public class EditorActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(EditorActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.editor.plugin.EditorActions";

  public EditorActions_ActionGroup() {
    super("EditorActions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      EditorActions_ActionGroup.this.addAction("jetbrains.mps.lang.editor.plugin.CopyThisDown_Action", "jetbrains.mps.lang.editor");
      EditorActions_ActionGroup.this.addAction("jetbrains.mps.lang.editor.plugin.DeleteLine_Action", "jetbrains.mps.lang.editor");
      EditorActions_ActionGroup.this.addAction("jetbrains.mps.lang.editor.plugin.ExtractComponent_Action", "jetbrains.mps.lang.editor");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    this.insertGroupIntoAnother(EditorPopup_ActionGroup.ID, null);
    this.insertGroupIntoAnother(Edit_ActionGroup.ID, Edit_ActionGroup.LABEL_ID_custom);
  }
}
