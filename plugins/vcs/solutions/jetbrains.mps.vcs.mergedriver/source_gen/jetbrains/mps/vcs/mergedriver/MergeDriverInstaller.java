package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import java.util.Arrays;
import java.util.List;
import com.intellij.openapi.vcs.VcsDirectoryMapping;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import javax.swing.SwingUtilities;

public class MergeDriverInstaller {
  private MergeDriverInstaller() {
  }

  public static boolean isApplicable(Project project) {
    return isApplicable(project, true);
  }

  public static boolean isApplicable(Project project, boolean allVcses) {
    return getCompositeState(project, allVcses) != AbstractInstaller.State.INSTALLED;
  }

  public static AbstractInstaller.State getCompositeState(Project project, boolean allVcses) {
    Iterable<AbstractInstaller> installers = Arrays.asList(new GitGlobalInstaller(project), new GitGlobalInstaller(project), new GitRepositoriesInstaller(project), new SvnInstaller(project, false), new SvnInstaller(project, true));
    if (!(allVcses)) {
      final List<VcsDirectoryMapping> directoryMappings = ProjectLevelVcsManager.getInstance(project).getDirectoryMappings();
      installers = Sequence.<AbstractInstaller>fromIterable(installers).where(new IWhereFilter<AbstractInstaller>() {
        public boolean accept(final AbstractInstaller i) {
          return ListSequence.<VcsDirectoryMapping>fromList(directoryMappings).any(new IWhereFilter<VcsDirectoryMapping>() {
            public boolean accept(VcsDirectoryMapping dm) {
              return dm.getVcs().equals(i.getAffectedVcsName());
            }
          });
        }
      });
    }
    if (Sequence.<AbstractInstaller>fromIterable(installers).any(new IWhereFilter<AbstractInstaller>() {
      public boolean accept(AbstractInstaller i) {
        return i.getCurrentState() == AbstractInstaller.State.NOT_INSTALLED;
      }
    })) {
      return AbstractInstaller.State.NOT_INSTALLED;
    } else if (Sequence.<AbstractInstaller>fromIterable(installers).any(new IWhereFilter<AbstractInstaller>() {
      public boolean accept(AbstractInstaller i) {
        return i.getCurrentState() == AbstractInstaller.State.OUTDATED;
      }
    })) {
      return AbstractInstaller.State.OUTDATED;
    } else {
      return AbstractInstaller.State.INSTALLED;
    }
  }

  public static void installWhereNeeded(final Project project) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MergeDriverOptionsDialog(project).showDialog();
      }
    });
  }
}
