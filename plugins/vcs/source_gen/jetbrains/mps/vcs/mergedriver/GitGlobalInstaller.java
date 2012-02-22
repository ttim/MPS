package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.File;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.WorkbenchPathManager;
import com.intellij.openapi.application.PathManager;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.vcs.util.PluginUtil;
import com.intellij.openapi.ui.Messages;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.openapi.util.SystemInfo;
import jetbrains.mps.util.StringsIO;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.io.IOException;
import java.io.FileNotFoundException;

/*package*/ class GitGlobalInstaller extends AbstractInstaller {
  protected static Log log = LogFactory.getLog(GitGlobalInstaller.class);

  private File myConfigFile;
  private File myScriptFile;

  public GitGlobalInstaller(Project project) {
    super(project);
    myConfigFile = new File(WorkbenchPathManager.getUserHome() + File.separator + ".gitconfig");
    myScriptFile = new File(PathManager.getConfigPath() + File.separator + "mps-merger.sh");
  }

  @NotNull
  protected AbstractInstaller.State install(boolean dryRun) {
    if (!(PluginUtil.isGitPluginEnabled())) {
      return AbstractInstaller.State.INSTALLED;
    }
    // TODO rewrite it using git4idea util classes 
    if (!(myConfigFile.exists())) {
      if (dryRun) {
        return AbstractInstaller.State.NOT_INSTALLED;
      } else {
        String msg = String.format("Git config (%s) file is not present. Do you want to create it?", myConfigFile.getAbsolutePath());
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

    AbstractInstaller.State createScriptResult = ScriptGenerator.generateScript(myProject, ScriptGenerator.GIT, myScriptFile, dryRun);
    if (createScriptResult != AbstractInstaller.State.INSTALLED) {
      return createScriptResult;
    }

    String scriptPath = myScriptFile.getAbsolutePath();
    if (SystemInfo.isWindows) {
      scriptPath = CommandLineGenerator.adaptPathForMsysGit(scriptPath);
    }
    ListSequence.fromList(newConfigLines).addElement(String.format("\tdriver = \"\\\"%s\\\" %%O %%A %%B %%L\"", scriptPath));

    List<String> configLines = StringsIO.readLines(myConfigFile);
    int sectionStart = ListSequence.fromList(configLines).indexOf(ListSequence.fromList(configLines).findFirst(new IWhereFilter<String>() {
      public boolean accept(String line) {
        return line.trim().matches("\\[merge\\s+\"mps\"\\]");
      }
    }));
    if (sectionStart != -1) {
      int toSkip = sectionStart + 1;
      Iterable<String> skipped = ListSequence.fromList(configLines).skip(toSkip);
      int sectionEnd = Sequence.fromIterable(skipped).indexOf(Sequence.fromIterable(skipped).findFirst(new IWhereFilter<String>() {
        public boolean accept(String line) {
          return line.trim().startsWith("[");
        }
      }));
      if (sectionEnd == -1) {
        // last section 
        sectionEnd = ListSequence.fromList(configLines).count();
      } else {
        sectionEnd = sectionEnd + toSkip;
      }
      List<String> section = ListSequence.fromList(configLines).page(sectionStart, sectionEnd).where(new IWhereFilter<String>() {
        public boolean accept(String line) {
          return !(line.trim().isEmpty());
        }
      }).toListSequence();
      boolean equal = (int) ListSequence.fromList(section).count() == (int) ListSequence.fromList(newConfigLines).count();
      if (equal) {
        for (int i = 0; i < ListSequence.fromList(section).count(); i++) {
          if (neq_btx4zt_a0a0a0g0u0a(ListSequence.fromList(section).getElement(i), ListSequence.fromList(newConfigLines).getElement(i))) {
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
      StringsIO.writeLines(myConfigFile, configLines);
      Messages.showInfoMessage(myProject, String.format("Successfully updated %s", myConfigFile.getAbsolutePath()), "Global Git Merge Driver Installed");
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

  public String getActionTitle() {
    return "Git global merge driver setting (~/.gitconfig)";
  }

  public String getAffectedVcsName() {
    return "Git";
  }

  private static boolean neq_btx4zt_a0a0a0g0u0a(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }
}
