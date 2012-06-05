package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.vfs.VirtualFile;
import javax.swing.SwingUtilities;
import com.intellij.openapi.fileChooser.FileChooser;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SModel;
import java.io.File;
import jetbrains.mps.vcs.platform.util.MergeBackupUtil;
import jetbrains.mps.vcs.util.MergeVersion;
import jetbrains.mps.vcs.diff.ui.merge.MergeModelsDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.vcs.diff.ui.common.SimpleDiffRequest;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;

public class TestMergeAction_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(TestMergeAction_Action.class);

  public TestMergeAction_Action() {
    super("Merge test data from ZIP", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "TestMergeAction", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final FileChooserDescriptor descriptor = new FileChooserDescriptor(true, true, true, true, false, false) {
        @Override
        public boolean isFileSelectable(VirtualFile file) {
          return !((file.isDirectory())) && file.getName().toLowerCase().endsWith(".zip");
        }
      };

      descriptor.setTitle("select archive with merge files");
      descriptor.setDescription("Zip files (*.zip) ");
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          VirtualFile vFile = FileChooser.chooseFile(((Project) MapSequence.fromMap(_params).get("project")), descriptor);

          String resString;
          SModel[] zipped;
          try {
            resString = File.createTempFile("mpstmd", "").getAbsolutePath();
            zipped = MergeBackupUtil.loadZippedModels(new File(vFile.getCanonicalPath()), MergeVersion.values());
          } catch (Exception e) {
            e.printStackTrace();
            return;
          }

          final String resFile = resString;
          final SModel[] models = zipped;

          MergeModelsDialog dialog = ModelAccess.instance().runReadAction(new Computable<MergeModelsDialog>() {
            public MergeModelsDialog compute() {
              return new MergeModelsDialog(models[0], models[1], models[2], new SimpleDiffRequest(((Project) MapSequence.fromMap(_params).get("project")), null, new String[]{"Local Version", "Merge Result", "Remote Version"}));
            }
          });
          dialog.show();
          final SModel result = dialog.getResultModel();
          if (result == null) {
            dialog.close(0);
          }
          ModelAccess.instance().runWriteAction(new Runnable() {
            public void run() {
              IFile iFile = FileSystem.getInstance().getFileByPath(resFile);
              if (!(iFile.exists())) {
                iFile.createNewFile();
              }
              ModelPersistence.saveModel(result, iFile);
            }
          });
          dialog.close(0);

          //  final SModel[] models = MergeBackupUtil.loadZippedModels(vFile, MergeVersion.values);  
          //  final string resultFile = File.createTempFile("mpstmd", "").getAbsolutePath();  
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "TestMergeAction", t);
      }
    }
  }
}
