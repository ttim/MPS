package jetbrains.mps.vcs.platform.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import java.util.List;
import com.intellij.openapi.vcs.VcsDirectoryMapping;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.blame.dialog.BlameDialog;
import jetbrains.mps.ide.blame.dialog.BlameDialogComponent;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import com.intellij.openapi.application.PathManager;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.io.FilenameFilter;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.vcs.platform.util.MergeBackupUtil;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ISelector;
import com.intellij.openapi.ui.Messages;

public class ReportModelMergeProblem_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ReportModelMergeProblem_Action.class);

  public ReportModelMergeProblem_Action() {
    super("Report Model Merge Problem...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    List<VcsDirectoryMapping> mappings = ProjectLevelVcsManager.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).getDirectoryMappings();
    return ListSequence.fromList(mappings).any(new IWhereFilter<VcsDirectoryMapping>() {
      public boolean accept(VcsDirectoryMapping m) {
        return StringUtils.isNotEmpty(m.getVcs());
      }
    });
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ReportModelMergeProblem", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final BlameDialog blameDialog = BlameDialogComponent.getInstance().createDialog(((Project) MapSequence.fromMap(_params).get("project")), ((Frame) MapSequence.fromMap(_params).get("frame")));
      blameDialog.setIssueHidden(true);
      blameDialog.setSubsystem("Version Control");
      blameDialog.setIssueTitle("Model merge problem");
      List<File> filesToAttach = ListSequence.fromList(new ArrayList<File>());
      ListSequence.fromList(filesToAttach).addElement(new File(System.getProperty("user.home") + File.separator + ".gitconfig"));
      ListSequence.fromList(filesToAttach).addElement(new File(PathManager.getConfigPath() + File.separator + "mps-merger.sh"));
      ListSequence.fromList(filesToAttach).addSequence(Sequence.fromIterable(Sequence.fromArray(new File(PathManager.getLogPath()).listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.startsWith("mergedriver.log");
        }
      }))));
      ListSequence.fromList(filesToAttach).visitAll(new IVisitor<File>() {
        public void visit(File f) {
          blameDialog.addFile(f);
        }
      });

      // Select merge-backup to attach 
      File backupDir = new File(MergeBackupUtil.getMergeBackupDirPath());
      File[] listFiles = backupDir.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          return name.endsWith(".zip");
        }
      });
      if (listFiles == null) {
        ReportModelMergeProblem_Action.this.showNoBackupsAvailable(_params);
      } else {
        List<File> zipFiles = Arrays.asList(listFiles);
        String[] zipNames = ListSequence.fromList(zipFiles).sort(new ISelector<File, Comparable<?>>() {
          public Comparable<?> select(File f) {
            return f.lastModified();
          }
        }, false).select(new ISelector<File, String>() {
          public String select(File f) {
            return f.getName();
          }
        }).toGenericArray(String.class);
        if (zipNames.length == 0) {
          ReportModelMergeProblem_Action.this.showNoBackupsAvailable(_params);
        } else {
          int selectedIndex = Messages.showChooseDialog(((Project) MapSequence.fromMap(_params).get("project")), "Choose merge backup file to attach", "Model Merge Problem", Messages.getQuestionIcon(), zipNames, zipNames[0]);
          if (selectedIndex < 0) {
            return;
          }
          blameDialog.addFile(new File(backupDir, zipNames[selectedIndex]));
          blameDialog.show();
        }
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ReportModelMergeProblem", t);
      }
    }
  }

  private void showNoBackupsAvailable(final Map<String, Object> _params) {
    Messages.showInfoMessage(((Project) MapSequence.fromMap(_params).get("project")), "No merge backups available, that is MPS merge was not invoked.", "Model Merge Problem");
  }
}
