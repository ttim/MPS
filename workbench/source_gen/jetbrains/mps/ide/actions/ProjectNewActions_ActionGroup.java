package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import jetbrains.mps.ide.actions.project.NewLanguageAction;
import jetbrains.mps.ide.actions.project.NewSolutionAction;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.action.BaseGroup;

public class ProjectNewActions_ActionGroup extends GeneratedActionGroup {
  public static Logger LOG = Logger.getLogger(ProjectNewActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ProjectNewActions";

  public ProjectNewActions_ActionGroup() {
    super("New", ID);
    this.setIsAlwaysVisible(true);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
      this.add(new NewSolutionAction());
      this.add(new NewLanguageAction());
      this.add(new NewDevKit_Action());
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    {
      BaseGroup gToBase = ActionUtils.getGroup(ProjectActions_ActionGroup.ID);
      BaseGroup gWhat = ActionUtils.getGroup(ProjectNewActions_ActionGroup.ID);
      if (gToBase == null || gWhat == null) {
        return;
      }
      {
        String labelName = null;
        labelName = ProjectActions_ActionGroup.LABEL_ID_projectNew;
        Constraints constraints = new Constraints(Anchor.AFTER, labelName);
        gToBase.add(gWhat, constraints);
      }
    }
  }

}
