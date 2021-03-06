package jetbrains.mps.vcs.concrete;

/*Generated by MPS */

import jetbrains.mps.ide.vcs.SourceRevision;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.platform.util.PluginUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import git4idea.GitBranch;
import jetbrains.mps.util.NameUtil;
import com.intellij.openapi.vcs.VcsException;
import git4idea.commands.GitSimpleHandler;
import git4idea.commands.GitCommand;

public class MPSSourceRevision extends SourceRevision {
  public MPSSourceRevision() {
    // This class is put in mergedriver module just to avoid creating new module for only one class. 
    // It cannot be put to vcs module, because the latter should not depend on git4idea plugin. 
  }

  @Nullable
  public String get() {
    if (!(PluginUtil.isGitPluginEnabled())) {
      return null;
    }
    VirtualFile mpsHome = LocalFileSystem.getInstance().findFileByPath(PathManager.getHomePath());
    if (mpsHome == null) {
      return null;
    }
    Project project = ProjectManager.getInstance().getOpenProjects()[0];
    try {
      String currentBranchName = check_9qzcwz_a0a0e0a(GitBranch.current(project, mpsHome));
      String currentRevision = getCurrentRevision(project, mpsHome);
      String mergeBase = getMergeBase(project, mpsHome);
      int distance = getDistance(project, mpsHome);

      String headDescription = currentRevision;
      if (mergeBase != null || distance == 0) {
        headDescription += String.format(", origin/master@%s + %s", mergeBase, NameUtil.formatNumericalString(distance, "commit"));
      }
      if (currentBranchName != null) {
        headDescription = String.format("%s (%s)", currentBranchName, headDescription);
      }
      return headDescription;
    } catch (VcsException e) {
    }
    return null;
  }

  private static String getCurrentRevision(Project project, VirtualFile root) throws VcsException {
    GitSimpleHandler h = new GitSimpleHandler(project, root, GitCommand.LOG);
    h.setNoSSH(true);
    h.setSilent(true);
    h.addParameters("--max-count=1", "--pretty=%h");
    return check_9qzcwz_a4a0(h.run());
  }

  public static String getMergeBase(Project project, VirtualFile root) throws VcsException {
    GitSimpleHandler h = new GitSimpleHandler(project, root, GitCommand.MERGE_BASE);
    h.setNoSSH(true);
    h.setSilent(true);
    h.addParameters("origin/master", "HEAD");
    String longRev = h.run();
    if (longRev.length() > 20) {
      return longRev.substring(0, 8);
    } else {
      return null;
    }
  }

  public static int getDistance(Project project, VirtualFile root) throws VcsException {
    GitSimpleHandler h = new GitSimpleHandler(project, root, GitCommand.REV_LIST);
    h.setNoSSH(true);
    h.setSilent(true);
    h.addParameters("origin/master..HEAD", "--count");
    String count = h.run();
    return Integer.parseInt(count.trim());
  }

  private static String check_9qzcwz_a4a0(String checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.trim();
    }
    return null;
  }

  private static String check_9qzcwz_a0a0e0a(GitBranch checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getName();
    }
    return null;
  }
}
