package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.ui.InputValidator;
import jetbrains.mps.smodel.ModelAccess;
import java.io.IOException;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.project.Project;
import com.intellij.ide.IdeBundle;
import com.intellij.ide.projectView.ProjectView;
import javax.swing.SwingUtilities;
import jetbrains.mps.ide.projectPane.fileSystem.FileViewProjectPane;

public class NewDirectory_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewDirectory_Action.class);

  public NewDirectory_Action() {
    super("Directory", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setIcon(Icons.OPENED_FOLDER);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewDirectory", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("selectedFile", event.getData(MPSDataKeys.VIRTUAL_FILE));
    if (MapSequence.<String,Object>fromMap(_params).get("selectedFile") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.<String,Object>fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final VirtualFile dir = (((VirtualFile) MapSequence.<String,Object>fromMap(_params).get("selectedFile")).isDirectory() ?
        ((VirtualFile) MapSequence.<String,Object>fromMap(_params).get("selectedFile")) :
        ((VirtualFile) MapSequence.<String,Object>fromMap(_params).get("selectedFile")).getParent()
      );
      final VirtualFile[] result = new VirtualFile[1];
      InputValidator validator = new InputValidator() {
        public boolean checkInput(String p) {
          return true;
        }

        public boolean canClose(final String p) {
          if (p.length() == 0) {
            return false;
          }
          if (p.contains(System.getProperty("file.separator"))) {
            return false;
          }
          ModelAccess.instance().runWriteAction(new Runnable() {
            public void run() {
              try {
                result[0] = dir.createChildDirectory(null, p);
              } catch (IOException e) {
              }
            }
          });
          return true;
        }
      };
      Messages.showInputDialog(((Project) MapSequence.<String,Object>fromMap(_params).get("project")), IdeBundle.message("prompt.enter.new.directory.name"), IdeBundle.message("title.new.directory"), Messages.getQuestionIcon(), "", validator);
      if (result[0] != null) {
        ProjectView.getInstance(((Project) MapSequence.<String,Object>fromMap(_params).get("project"))).refresh();
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            ProjectView.getInstance(((Project) MapSequence.<String,Object>fromMap(_params).get("project"))).getProjectViewPaneById(FileViewProjectPane.ID).select(null, result[0], true);
          }
        });
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewDirectory", t);
      }
    }
  }
}
