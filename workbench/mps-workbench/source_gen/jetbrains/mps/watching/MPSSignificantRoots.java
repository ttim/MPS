package jetbrains.mps.watching;

/*Generated by MPS */

import jetbrains.mps.ide.platform.watching.SignificantRoots;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.ProjectManager;
import jetbrains.mps.library.LibraryManager;
import java.util.Set;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.HashSet;
import com.intellij.openapi.project.Project;
import jetbrains.mps.library.ProjectLibraryManager;
import jetbrains.mps.library.Library;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import java.util.Arrays;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class MPSSignificantRoots extends SignificantRoots implements ApplicationComponent {
  private final ProjectManager myProjectManager;
  private LibraryManager libMan;

  public MPSSignificantRoots(ProjectManager manager, LibraryManager libMan) {
    myProjectManager = manager;
    this.libMan = libMan;
  }

  public Set<VirtualFile> getSignificantRoots() {
    Set<VirtualFile> roots = new HashSet<VirtualFile>();
    for (Project p : myProjectManager.getOpenProjects()) {
      roots.add(p.getBaseDir());
      ProjectLibraryManager projectLibraryManager = p.getComponent(ProjectLibraryManager.class);
      if (projectLibraryManager != null) {
        for (Library lib : projectLibraryManager.getUILibraries()) {
          VirtualFile file = VirtualFileUtils.getVirtualFile(lib.getPath());
          if (file != null) {
            roots.add(file);
          }
        }
      }
      ProjectLevelVcsManager manager = ProjectLevelVcsManager.getInstance(p);
      if (manager != null) {
        roots.addAll(Arrays.asList(manager.getAllVersionedRoots()));
      }
    }
    for (Library lib : libMan.getUILibraries()) {
      VirtualFile file = VirtualFileUtils.getVirtualFile(lib.getPath());
      if (file != null) {
        roots.add(file);
      }
    }
    return roots;
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Significant Roots";
  }
}
