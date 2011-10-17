package jetbrains.mps.ide.vcs;

/*Generated by MPS */

import com.intellij.openapi.vcs.impl.BasicDefaultVcsRootPolicy;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.changes.DirtBuilder;
import com.intellij.openapi.vcs.changes.VcsGuess;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.vcs.VcsRoot;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.platform.ProjectBaseDirectory;

public class ExtendedDefaultVcsRootPolicy extends BasicDefaultVcsRootPolicy {
  private Project myProject;

  public ExtendedDefaultVcsRootPolicy(Project project) {
    super(project);
    myProject = project;
  }

  @Override
  public void markDefaultRootsDirty(DirtBuilder builder, final VcsGuess vcsGuess) {
    super.markDefaultRootsDirty(builder, vcsGuess);
    // TODO is it needed? 
    ProjectLevelVcsManager manager = ProjectLevelVcsManager.getInstance(myProject);
    VcsRoot[] roots = manager.getAllVcsRoots();
    for (VcsRoot root : roots) {
      builder.addDirtyDirRecursively(root);
    }
  }

  @Override
  public boolean matchesDefaultMapping(VirtualFile file, Object matchContext) {
    if (ProjectBaseDirectory.getInstance(myProject).getBaseDir() == null) {
      // TODO is it needed? 
      return false;
    }
    return super.matchesDefaultMapping(file, matchContext);
  }
}
