package jetbrains.mps.vcs;

/*Generated by MPS */

import jetbrains.mps.smodel.DiskMemoryConflictResolver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.watching.ModelChangesWatcher;
import jetbrains.mps.util.Computable;
import java.io.File;
import java.io.IOException;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import jetbrains.mps.vcs.diff.ui.ModelDifferenceDialog;
import javax.swing.SwingUtilities;

public class DiskMemoryConflictResolverImpl extends DiskMemoryConflictResolver {
  protected static Log log = LogFactory.getLog(DiskMemoryConflictResolverImpl.class);

  public DiskMemoryConflictResolverImpl() {
  }

  public void resolveDiskMemoryConflict(final IFile file, final SModel model, final DefaultSModelDescriptor modelDescriptor) {
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      public void run() {
        boolean needSave = ModelChangesWatcher.instance().executeUnderBlockedReload(new Computable<Boolean>() {
          public Boolean compute() {
            try {
              File backupFile = doBackup(file, model);
              if (file.exists()) {
                return showDiskMemoryQuestion(file, model, backupFile);
              } else {
                return showDeletedFromDiskQuestion(model, backupFile);
              }
            } catch (IOException e) {
              if (log.isErrorEnabled()) {
                log.error("", e);
              }
              throw new RuntimeException(e);
            }
          }
        });
        if (needSave) {
          ModelAccess.instance().runWriteActionInCommand(new Runnable() {
            public void run() {
              modelDescriptor.updateDiskTimestamp();
              modelDescriptor.save();
            }
          });
        } else {
          ModelAccess.instance().runWriteAction(new Runnable() {
            public void run() {
              modelDescriptor.reloadFromDisk();
            }
          });
        }
      }
    });
  }

  private static boolean showDeletedFromDiskQuestion(SModel inMemory, File backupFile) {
    int result = Messages.showYesNoDialog("Model file for model " + inMemory + " was externally deleted from disk.\n" + "Backup of it was saved to \"" + backupFile.getAbsolutePath() + "\"\nDo you wish to restore it?", "Model Deleted Externally", Messages.getQuestionIcon());
    return result == 0;
  }

  private static boolean showDiskMemoryQuestion(IFile modelFile, SModel inMemory, File backupFile) {
    String message = "Changes have been made to " + inMemory + " model in memory and on disk.\n" + "Backup of both versions was saved to \"" + backupFile.getAbsolutePath() + "\"\n" + "Which version to use?";
    String title = "Model Versions Conflict";
    String diskVersion = "Load &File System Version";
    String memoryVersion = "Save &Memory Version";
    String showDiffDialog = "Show &Difference";
    String[] options = {diskVersion, memoryVersion, showDiffDialog};
    int result = Messages.showDialog(message, title, options, 0, Messages.getQuestionIcon());
    if (result == -1) {
      result = 2;
    }
    if (options[result].equals(diskVersion)) {
      return false;
    } else
    if (options[result].equals(memoryVersion)) {
      return true;
    } else {
      openDiffDialog(modelFile, inMemory);
      return true;
    }
  }

  private static File doBackup(IFile modelFile, SModel inMemory) throws IOException {
    File tmp = FileUtil.createTmpDir();
    MergeBackupUtil.writeContentsToFile(ModelPersistence.modelToString(inMemory), modelFile.getName(), tmp, DiskMemoryConflictResolverImpl.DiskMemoryConflictVersion.MEMORY.getSuffix());
    if (modelFile.exists()) {
      com.intellij.openapi.util.io.FileUtil.copy(new File(modelFile.getPath()), new File(tmp.getAbsolutePath(), modelFile.getName() + "." + DiskMemoryConflictResolverImpl.DiskMemoryConflictVersion.FILE_SYSTEM.getSuffix()));
    }
    File zipfile = MergeBackupUtil.chooseZipFileForModelFile(modelFile);
    zipfile.getParentFile().mkdirs();
    FileUtil.zip(tmp, zipfile);
    FileUtil.delete(tmp);
    return zipfile;
  }

  private static void openDiffDialog(IFile modelFile, SModel inMemory) {
    SModel onDisk = new SModel(inMemory.getSModelReference());
    try {
      onDisk = ModelPersistence.readModel(modelFile, false);
    } catch (ModelReadException e) {
      if (log.isErrorEnabled()) {
        log.error("Could not read model", e);
      }
    }
    Project project = ProjectManager.getInstance().getOpenProjects()[0];
    final ModelDifferenceDialog dialog = new ModelDifferenceDialog(onDisk, inMemory, project, "Filesystem version (Read-Only)", "Memory Version");
    dialog.showDialog();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        dialog.toFront();
      }
    });
  }

  public static   enum DiskMemoryConflictVersion implements ModelVersion {
    FILE_SYSTEM("filesystem"),
    MEMORY("memory");

    private final String mySuffix;

    DiskMemoryConflictVersion(String suffix) {
      mySuffix = suffix;
    }

    public String getSuffix() {
      return mySuffix;
    }
  }
}
