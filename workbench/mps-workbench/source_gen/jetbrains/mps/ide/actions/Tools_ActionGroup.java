package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;

public class Tools_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(Tools_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Tools_ActionGroup";
  public static final String LABEL_ID_migration = ID + "migration";
  public static final String LABEL_ID_customTools = ID + "customTools";
  public static final String LABEL_ID_devkitTools = ID + "devkitTools";
  public static final String LABEL_ID_internal = ID + "internal";

  public Tools_ActionGroup() {
    super("Tools", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      Tools_ActionGroup.this.addSeparator();
      {
        LabelledAnchor action = new LabelledAnchor(Tools_ActionGroup.LABEL_ID_migration);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Tools_ActionGroup.this.addAction(action);
      }
      Tools_ActionGroup.this.addSeparator();
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ShowBookmarks_Action");
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ShowTodoViewer_Action");
      {
        LabelledAnchor action = new LabelledAnchor(Tools_ActionGroup.LABEL_ID_customTools);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Tools_ActionGroup.this.addAction(action);
      }
      Tools_ActionGroup.this.addSeparator();
      {
        LabelledAnchor action = new LabelledAnchor(Tools_ActionGroup.LABEL_ID_devkitTools);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Tools_ActionGroup.this.addAction(action);
      }
      Tools_ActionGroup.this.addSeparator();
      {
        LabelledAnchor action = new LabelledAnchor(Tools_ActionGroup.LABEL_ID_internal);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Tools_ActionGroup.this.addAction(action);
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
