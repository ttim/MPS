package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.BaseActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.action.Label;
import jetbrains.mps.ide.actions.make.MakeProjectAction;
import jetbrains.mps.ide.actions.make.CleanProjectAction;
import jetbrains.mps.ide.actions.project.OptimizeProjectImportsAction;
import jetbrains.mps.ide.actions.file.ProjectSettingsAction;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.ide.action.IActionGroupElementOwner;

public class ProjectActions_ActionGroup extends BaseActionGroup {
  public static Logger LOG = Logger.getLogger(ProjectActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ProjectActions";
  public static final String LABEL_ID_projectNew = "projectNew";

  public ProjectActions_ActionGroup(MPSProject project) {
    super("", ProjectActions_ActionGroup.ID);
    this.setInternal(false);
    try {
      this.add(new Label(ProjectActions_ActionGroup.LABEL_ID_projectNew), this);
      this.addSeparator();
      this.add(new MakeProjectAction(), this);
      this.add(new CleanProjectAction(), this);
      this.addSeparator();
      this.add(new OptimizeProjectImportsAction(), this);
      this.addSeparator();
      this.add(new ProjectSettingsAction(), this);
    } catch (Throwable t) {
      ProjectActions_ActionGroup.LOG.error("User group error", t);
    }
  }

  public void adjust(ActionManager manager, IActionGroupElementOwner owner) {
  }

}
