package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.Anchor;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.actions.model.NewModelAction;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.action.BaseGroup;
import jetbrains.mps.workbench.action.CurrentProjectGroup;

public class SolutionNewActions_ActionGroup extends CurrentProjectGroup {
  public static Logger LOG = Logger.getLogger(SolutionNewActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.SolutionNewActions";

  public SolutionNewActions_ActionGroup(Project project) {
    super("New", ID, true, false, null, project);
    this.setPopup(true);
    try {
      this.add(new NewModelAction());
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    {
      BaseGroup gToBase = ActionUtils.getGroup(SolutionActions_ActionGroup.ID);
      BaseGroup gWhat = ActionUtils.getGroup(SolutionNewActions_ActionGroup.ID);
      if (gToBase == null || gWhat == null) {
        return;
      }
      {
        String labelName = null;
        labelName = SolutionActions_ActionGroup.LABEL_ID_solutionNew;
        Constraints constraints = new Constraints(Anchor.AFTER, labelName);
        gToBase.add(gWhat, constraints);
      }
    }
  }

}
