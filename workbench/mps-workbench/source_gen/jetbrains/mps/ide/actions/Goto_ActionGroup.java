package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import com.intellij.ide.actions.GotoActionAction;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.ide.actions.GotoFileAction;

public class Goto_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(Goto_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Goto_ActionGroup";
  public static final String LABEL_ID_gotoVCS = ID + "gotoVCS";
  public static final String LABEL_ID_gotoConceptAspects = ID + "gotoConceptAspects";

  public Goto_ActionGroup() {
    super("Go To", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      Goto_ActionGroup.this.addParameterizedAction(new GoToAction_Action(new GotoActionAction()), PluginId.getId("jetbrains.mps.ide"), new GotoActionAction());
      {
        LabelledAnchor action = new LabelledAnchor(Goto_ActionGroup.LABEL_ID_gotoVCS);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Goto_ActionGroup.this.addAction(action);
      }
      Goto_ActionGroup.this.addSeparator();
      Goto_ActionGroup.this.addParameterizedAction(new GoToFile_Action(new GotoFileAction()), PluginId.getId("jetbrains.mps.ide"), new GotoFileAction());
      Goto_ActionGroup.this.addAction("jetbrains.mps.ide.actions.GoToRootNode_Action");
      Goto_ActionGroup.this.addSeparator();
      {
        LabelledAnchor action = new LabelledAnchor(Goto_ActionGroup.LABEL_ID_gotoConceptAspects);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        Goto_ActionGroup.this.addAction(action);
      }
      Goto_ActionGroup.this.addSeparator();
      Goto_ActionGroup.this.addAction("jetbrains.mps.ide.actions.GoToModel_Action");
      Goto_ActionGroup.this.addAction("jetbrains.mps.ide.actions.GoToModule_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
