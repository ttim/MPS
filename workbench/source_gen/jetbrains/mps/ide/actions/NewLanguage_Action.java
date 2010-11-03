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
import jetbrains.mps.ide.newLanguageDialog.NewLanguageDialog;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.ide.projectPane.ProjectPane;

public class NewLanguage_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewLanguage_Action.class);

  private MPSProject project;
  private Project ideaProject;
  private Frame frame;
  private String folder;

  public NewLanguage_Action(String folder_par) {
    super("Language", "", ICON);
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
        log.error("User's action doUpdate method failed. Action:" + "NewLanguage", t);
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
      NewLanguageDialog dialog = new NewLanguageDialog(NewLanguage_Action.this.frame);
      dialog.setProject(NewLanguage_Action.this.project);
      dialog.showDialog();
      Language l = dialog.getResult();
      if (l == null) {
        return;
      }
      NewLanguage_Action.this.project.setFolderFor(l, NewLanguage_Action.this.folder);
      ProjectPane projectPane = ProjectPane.getInstance(NewLanguage_Action.this.ideaProject);
      projectPane.rebuildTree();
      projectPane.selectModule(l, false);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewLanguage", t);
      }
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder(500);
    res.append(NewLanguage_Action.class.getName());
    res.append("#");
    res.append(folder_State((String) this.folder));
    res.append("!");
    return res.toString();
  }

  public static String folder_State(String object) {
    return object;
  }
}
