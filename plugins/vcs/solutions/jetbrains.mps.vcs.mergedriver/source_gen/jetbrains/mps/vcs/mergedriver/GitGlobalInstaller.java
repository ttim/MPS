package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.WorkbenchPathManager;
import java.io.File;
import com.intellij.openapi.ui.Messages;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.util.StringsIO;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.io.IOException;
import com.intellij.openapi.util.SystemInfo;
import java.io.FileNotFoundException;

/*package*/ class GitGlobalInstaller extends AbstractInstaller {
  protected static Log log = LogFactory.getLog(GitGlobalInstaller.class);

  public GitGlobalInstaller(Project project) {
    super(project);
  }

  @NotNull
  protected AbstractInstaller.State install(boolean dryRun) {
    String globalConfigPath = WorkbenchPathManager.getUserHome() + File.separator + ".gitconfig";
    File configFile = new File(globalConfigPath);
    if (!(configFile.exists())) {
      if (dryRun) {
        return AbstractInstaller.State.NOT_INSTALLED;
      } else {
        String msg = String.format("Git config (%s) file is not present. Do you want to create it?", configFile.getAbsolutePath());
        if (Messages.showYesNoDialog(myProject, msg, "No Git Config", Messages.getQuestionIcon()) != 0) {
          return AbstractInstaller.State.NOT_INSTALLED;
        }
      }
    }

    List<String> newConfigLines = ListSequence.fromList(new ArrayList<String>());
    ListSequence.fromList(newConfigLines).addElement("[merge \"mps\"]");
    ListSequence.fromList(newConfigLines).addElement("\tname = MPS merge driver");

    AbstractInstaller.State packerState = InternalRuntimePacker.packIfNeeded(dryRun);
    if (packerState != AbstractInstaller.State.INSTALLED) {
      return packerState;
    }

    String cmd = CommandLineGenerator.getCommandLine(false).replace("\\", "\\\\");
    ListSequence.fromList(newConfigLines).addElement(String.format("\tdriver = %s --git %%O %%A %%B %%L", cmd));
    ListSequence.fromList(newConfigLines).addElement("");

    List<String> configLines = StringsIO.readLines(configFile);
    int sectionStart = ListSequence.fromList(configLines).indexOf(ListSequence.fromList(configLines).findFirst(new IWhereFilter<String>() {
      public boolean accept(String line) {
        return line.matches("\\s*\\[merge\\s+\"mps\"\\]\\s*");
      }
    }));
    if (sectionStart != -1) {
      Iterable<String> skipped = ListSequence.fromList(configLines).skip(sectionStart);
      int sectionEnd = Sequence.fromIterable(skipped).indexOf(Sequence.fromIterable(skipped).findFirst(new IWhereFilter<String>() {
        public boolean accept(String line) {
          return line.trim().isEmpty();
        }
      })) + sectionStart + 1;
      List<String> section = ListSequence.fromList(configLines).page(sectionStart, sectionEnd).toListSequence();
      boolean equal = ListSequence.fromList(section).count() == ListSequence.fromList(newConfigLines).count();
      if (equal) {
        for (int i = 0; i < ListSequence.fromList(section).count(); i++) {
          if (neq_btx4zt_a0a0a0e0r0a(ListSequence.fromList(section).getElement(i), ListSequence.fromList(newConfigLines).getElement(i))) {
            equal = false;
            break;
          }
        }
      }
      if (equal) {
        return AbstractInstaller.State.INSTALLED;
      } else {
        if (dryRun) {
          return AbstractInstaller.State.OUTDATED;
        } else {
          configLines = ListSequence.fromList(configLines).take(sectionStart).concat(ListSequence.fromList(newConfigLines)).concat(ListSequence.fromList(configLines).skip(sectionEnd)).toListSequence();
        }
      }
    } else {
      if (dryRun) {
        return AbstractInstaller.State.NOT_INSTALLED;
      }

      ListSequence.fromList(configLines).addElement("");
      ListSequence.fromList(configLines).addSequence(ListSequence.fromList(newConfigLines));
    }

    try {
      StringsIO.writeLines(configFile, configLines);
      Messages.showInfoMessage(myProject, String.format("Successfully updated %s", configFile.getAbsolutePath()), "Global Git Merge Driver Installed");
      return AbstractInstaller.State.INSTALLED;
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("Writing gitconfig file failed", e);
      }
      String msg = e.getMessage() + ".";
      if (SystemInfo.isWindows && e instanceof FileNotFoundException) {
        msg += " Try unsetting hidden attribute for that file in Windows Explorer.";
      }
      Messages.showErrorDialog(myProject, "Writing gitconfig file failed. " + msg, "Writing .gitconfig Failed");
      return AbstractInstaller.State.NOT_INSTALLED;
    }
  }

  private static boolean neq_btx4zt_a0a0a0e0r0a(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }
}
