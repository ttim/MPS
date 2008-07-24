package jetbrains.mps.plugins.projectplugins;

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.project.Project;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.custom.BaseCustomProjectPlugin;
import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.workbench.editors.MPSEditorOpenHandler;
import jetbrains.mps.workbench.editors.MPSEditorOpenHandlerOwner;
import jetbrains.mps.workbench.editors.MPSEditorOpener;

import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseProjectPlugin implements IProjectPlugin, MPSEditorOpenHandlerOwner {
  private static Logger LOG = Logger.getLogger(BaseProjectPlugin.class);

  private Project myProject;
  private List<GeneratedTool> myTools = new ArrayList<GeneratedTool>();
  private List<GeneratedTool> myInitializedTools = new ArrayList<GeneratedTool>();
  private List<BaseCustomProjectPlugin> myCustomPartsToDispose = new ArrayList<BaseCustomProjectPlugin>();

  //------------------stuff to generate-----------------------

  protected abstract void initEditors(MPSProject project);

  protected abstract List<GeneratedTool> initTools(Project project);

  protected abstract List<BaseCustomProjectPlugin> initCustomParts(MPSProject project);

  //------------------quick access stuff-----------------------

  protected ActionManager getActionManager() {
    return ActionManager.getInstance();
  }

  protected ProjectPluginManager getPluginManager() {
    return getProject().getPluginManager();
  }

  protected Project getIDEAProject() {
    return getProject().getComponent(Project.class);
  }

  public MPSProject getProject() {
    return myProject.getComponent(MPSProjectHolder.class).getMPSProject();
  }

  //------------------shared stuff-----------------------

  public void init(MPSProject project) {
    myProject = project.getComponent(Project.class);
    myCustomPartsToDispose = initCustomParts(project);

    initEditors(project);
    myTools = (List) (initTools(myProject));
    final Project ideaProject = getIDEAProject();
    for (final GeneratedTool tool : myTools) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          if (ideaProject.isDisposed()) return;
          try {
            tool.init(ideaProject);
          } catch (Throwable t) {
            LOG.error(t);
          }
          doAdd(tool, false);
          myInitializedTools.add(tool);
        }
      });
    }
  }

  public void dispose() {
    for (BaseCustomProjectPlugin customPart : myCustomPartsToDispose) {
      customPart.dispose();
    }
    myCustomPartsToDispose.clear();

    for (final GeneratedTool tool : myTools) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          if (!myInitializedTools.contains(tool)) return;
          try {
            tool.dispose();
          } catch (Throwable t) {
            LOG.error(t);
          }
          tool.unregister();
        }
      });
    }
    myTools.clear();

    MPSEditorOpener opener = myProject.getComponent(MPSEditorOpener.class);
    if (opener != null) {
      opener.unregisterOpenHandlers(this);
    }
  }

  //------------------tools stuff-----------------------

  public List<GeneratedTool> getTools() {
    return Collections.unmodifiableList(myTools);
  }

  protected void doAdd(final GeneratedTool tool, final boolean isVisibleByDefault) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            tool.registerLater();
            if (isVisibleByDefault) tool.openToolLater(false);
          }
        });
      }
    });
  }

  //------------------tabbed editors stuff-----------------------

  public void addEditorOpenHandler(MPSEditorOpenHandler handler) {
    MPSEditorOpener editorsPane = getProject().getComponent(MPSEditorOpener.class);
    if (editorsPane != null) {
      editorsPane.registerOpenHandler(handler, this);
    }
  }
}