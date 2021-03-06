package jetbrains.mps.plugin;

/*Generated by MPS */

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.wm.IdeFrame;
import com.intellij.openapi.wm.WindowManager;

public class PluginStateMonitor implements ProjectComponent {
  private final Project myProject;
  private StatusBar myStatusBar;
  private PluginStateWidget myWidget;

  public PluginStateMonitor(Project project) {
    myProject = project;
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return PluginStateMonitor.class.getSimpleName();
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  public void projectOpened() {
    myStatusBar = getStatusBar();
    if (myStatusBar == null) {
      return;
    }

    this.myWidget = new PluginStateWidget(myProject);
    myStatusBar.addWidget(this.myWidget);
  }

  public void projectClosed() {
    if (myStatusBar == null) {
      return;
    }
    myStatusBar.removeWidget(myWidget.ID());
  }

  @Nullable
  private StatusBar getStatusBar() {
    IdeFrame ideFrame = WindowManager.getInstance().getIdeFrame(myProject);
    if (ideFrame == null) {
      return null;
    }
    return ideFrame.getStatusBar();
  }
}
