package jetbrains.mps.ide.findusages.view.optionseditor;

/*Generated by MPS */

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.PersistentStateComponent;
import org.jdom.Element;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.make.StartupModuleMaker;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.MPSProject;
import com.intellij.openapi.startup.StartupManager;

@State(name = "DefaultSearchOptions2", storages = {@Storage(id = "other", file = "$WORKSPACE_FILE$")
})
public class DefaultSearchOptionsComponent implements ProjectComponent, PersistentStateComponent<Element> {
  private DefaultOptionsContainer myDefaultOptions = null;
  private Project myProject;
  private Element myState;

  public DefaultSearchOptionsComponent(Project project, StartupModuleMaker maker) {
    myProject = project;
  }

  public DefaultOptionsContainer getDefaultOptions() {
    return myDefaultOptions;
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return DefaultSearchOptionsComponent.class.getSimpleName();
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  public Element getState() {
    if (myDefaultOptions == null) {
      return myState;
    }
    myState = myDefaultOptions.writeOptions(myProject.getComponent(MPSProject.class));
    return myState;
  }

  public void loadState(Element state) {
    myState = (Element) state.clone();
    if (myDefaultOptions == null) {
      return;
    }
    myDefaultOptions.readOptions(myState, myProject.getComponent(MPSProject.class));
  }

  public void projectOpened() {
    StartupManager.getInstance(myProject).registerStartupActivity(new Runnable() {
      public void run() {
        myDefaultOptions = new DefaultOptionsContainer();
        if (myState == null) {
          return;
        }
        myDefaultOptions.readOptions(myState, myProject.getComponent(MPSProject.class));
      }
    });
  }

  public void projectClosed() {
  }
}
