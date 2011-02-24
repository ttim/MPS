package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.action.LabelledAnchor;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.actionSystem.AnAction;

public class Tools_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(Tools_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Tools_ActionGroup";
  public static final String LABEL_ID_customTools = ID + "customTools";
  public static final String LABEL_ID_internal = ID + "internal";

  public Tools_ActionGroup() {
    super("Tools", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ShowBookmarks_Action");
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ShowModelChecker_Action");
      {
        LabelledAnchor action = new LabelledAnchor(Tools_ActionGroup.LABEL_ID_customTools);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Tools_ActionGroup.this.addAction(action);
      }
      Tools_ActionGroup.this.addSeparator();
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ReloadAll_Action");
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.ReloadStubs_Action");
      Tools_ActionGroup.this.addSeparator();
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.InstallIDEAPlugin_Action");
      Tools_ActionGroup.this.addAction("jetbrains.mps.ide.actions.RenameAspects_Action");
      Tools_ActionGroup.this.addSeparator();
      {
        GeneratedActionGroup newAction = new ToolsUpgrade_ActionGroup();
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        AnAction oldAction = manager.getAction(newAction.getId());
        if (oldAction == null) {
          manager.registerAction(newAction.getId(), newAction, PluginId.getId("jetbrains.mps.ide"));
          oldAction = newAction;
        }
        Tools_ActionGroup.this.addAction(oldAction);
      }
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
