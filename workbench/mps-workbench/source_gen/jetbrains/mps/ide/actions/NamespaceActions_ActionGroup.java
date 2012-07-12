package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;

public class NamespaceActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(NamespaceActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.NamespaceActions_ActionGroup";
  public static final String LABEL_ID_namespaceInternal = ID + "namespaceInternal";
  public static final String LABEL_ID_check = ID + "check";

  public NamespaceActions_ActionGroup() {
    super("NamespaceActions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      {
        LabelledAnchor action = new LabelledAnchor(NamespaceActions_ActionGroup.LABEL_ID_namespaceInternal);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        NamespaceActions_ActionGroup.this.addAction(action);
      }
      NamespaceActions_ActionGroup.this.addSeparator();
      {
        LabelledAnchor action = new LabelledAnchor(NamespaceActions_ActionGroup.LABEL_ID_check);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        NamespaceActions_ActionGroup.this.addAction(action);
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
