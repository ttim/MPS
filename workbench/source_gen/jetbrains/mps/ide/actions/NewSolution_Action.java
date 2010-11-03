package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.project.MPSProject;
import com.intellij.openapi.project.Project;
import java.awt.Frame;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.newSolutionDialog.NewSolutionDialog;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.projectPane.ProjectPane;

public class NewSolution_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewSolution_Action.class);

  private MPSProject project;
  private Project ideaProject;
  private Frame frame;
  private String folder;

  public NewSolution_Action(String folder_par) {
    super("Solution", "", ICON);
    this.folder = folder_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewSolution", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.MPS_PROJECT);
    if (this.project == null) {
      return false;
    }
    this.ideaProject = event.getData(MPSDataKeys.PROJECT);
    if (this.ideaProject == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    return true;
  }

  protected void cleanup() {
    super.cleanup();
    this.project = null;
    this.ideaProject = null;
    this.frame = null;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      NewSolutionDialog dialog = new NewSolutionDialog(NewSolution_Action.this.frame);
      dialog.setProject(NewSolution_Action.this.project);
      dialog.showDialog();
      final Solution s = dialog.getResult();
      if (s == null) {
        return;
      }
      ModelAccess.instance().runWriteAction(new Runnable() {
        public void run() {
          NewSolution_Action.this.project.setFolderFor(s, NewSolution_Action.this.folder);
        }
      });
      ProjectPane projectPane = ProjectPane.getInstance(NewSolution_Action.this.ideaProject);
      projectPane.rebuildTree();
      projectPane.selectModule(s, false);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewSolution", t);
      }
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder(500);
    res.append(NewSolution_Action.class.getName());
    res.append("#");
    res.append(folder_State((String) this.folder));
    res.append("!");
    return res.toString();
  }

  public static String folder_State(String object) {
    return object;
  }
}
