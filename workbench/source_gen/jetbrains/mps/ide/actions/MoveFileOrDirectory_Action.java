package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.workbench.dialogs.MoveFileDialog;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.ide.projectView.ProjectView;
import javax.swing.SwingUtilities;
import jetbrains.mps.ide.projectPane.fileSystem.FileViewProjectPane;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.awt.Frame;
import jetbrains.mps.vfs.FileSystem;
import java.io.File;

public class MoveFileOrDirectory_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveFileOrDirectory_Action.class);

  public MoveFileOrDirectory_Action() {
    super("Move...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveFileOrDirectory", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("selectedFile", event.getData(MPSDataKeys.VIRTUAL_FILE));
    if (MapSequence.fromMap(_params).get("selectedFile") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      String path = ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")).getParent().getPath();
      MoveFileDialog dialog = new MoveFileDialog(((Project) MapSequence.fromMap(_params).get("project")), path, ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")).isDirectory());
      dialog.show();
      if (!(dialog.isOK())) {
        return;
      }
      final String result = dialog.getResult();
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          try {
            if (MoveFileOrDirectory_Action.this.isNotValid(result, _params)) {
              return;
            }
            VirtualFile virtualFile = LocalFileSystem.getInstance().findFileByPath(result);
            ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")).move(null, virtualFile);
            ProjectView.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).refresh();
            SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                ProjectView.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).getProjectViewPaneById(FileViewProjectPane.ID).select(null, ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")), true);
              }
            });
          } catch (IOException e) {
          }
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveFileOrDirectory", t);
      }
    }
  }

  /*package*/ boolean isNotValid(String result, final Map<String, Object> _params) {
    if (result == null || result.length() == 0) {
      JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Enter valid name");
      return true;
    }
    if (FileSystem.getInstance().getFileByPath(result + File.separator + ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")).getName()).exists()) {
      JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), ((VirtualFile) MapSequence.fromMap(_params).get("selectedFile")).getName() + " already exists");
      return true;
    }
    return false;
  }
}
