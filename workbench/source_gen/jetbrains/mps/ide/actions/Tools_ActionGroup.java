package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.BaseActionGroup;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.actions.tools.InstallIDEAPluginAction;
import jetbrains.mps.ide.actions.tools.ReloadAllAction;
import jetbrains.mps.ide.action.Label;
import jetbrains.mps.svn.gui.SVNCheckOutAction;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.ide.action.IActionGroupElementOwner;
import jetbrains.mps.ide.action.ActionGroup;

public class Tools_ActionGroup extends BaseActionGroup {
  public static final String ID = "jetbrains.mps.ide.actions.Tools";
  public static final String INTERNAL_LABEL_ID_Internal = "Internal";

  public  Tools_ActionGroup(MPSProject project) {
    super("Tools", Tools_ActionGroup.ID);
    this.setMnemonic("T".charAt(0));
    this.setInternal(false);
    this.add(new InstallIDEAPluginAction(), this);
    this.add(new ReloadAllAction(), this);
    this.add(new Label(Tools_ActionGroup.INTERNAL_LABEL_ID_Internal));
    this.addSeparator();
    this.add(new SVNCheckOutAction(), this);
  }

  public void adjust(ActionManager manager, IActionGroupElementOwner owner) {
    {
      ActionGroup gTo = manager.getGroup(MainMenu_ActionGroup.ID);
      ActionGroup gWhat = manager.getGroup(Tools_ActionGroup.ID);
      if(gTo == null || gWhat == null) {
        return;
      }
      {
        String labelName;
        labelName = MainMenu_ActionGroup.LABEL_ID_tools;
        gTo.add(gWhat, owner, labelName);
      }
    }
  }

}
