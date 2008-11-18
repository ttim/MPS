package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.action.ActionFactory;
import jetbrains.mps.workbench.action.BaseGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.ide.actions.ProjectNewActions_ActionGroup;

public class ProjectPaneProjectAddition_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ProjectPaneProjectAddition_ActionGroup.class);
  public static final String ID = "jetbrains.mps.build.packaging.plugin.ProjectPaneProjectAddition";

  public ProjectPaneProjectAddition_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.addSeparator();
      this.add(ActionFactory.getInstance().getRegisteredAction(new GenerateBuildForProjectAction_Action()));
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    {
      BaseGroup gToBase = ActionUtils.getGroup(ProjectNewActions_ActionGroup.ID);
      BaseGroup gWhat = ActionUtils.getGroup(ProjectPaneProjectAddition_ActionGroup.ID);
      if (gToBase == null || gWhat == null) {
        return;
      }
      gToBase.add(gWhat);
    }
  }

}
