package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import jetbrains.mps.project.MPSProject;
import com.intellij.ui.content.ContentManager;
import com.intellij.ui.content.ContentManagerListener;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.icons.IconManager;
import com.intellij.openapi.wm.ToolWindowAnchor;
import javax.swing.JComponent;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.generator.GenerationSettings;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchResult;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManagerAdapter;
import com.intellij.ui.content.ContentManagerEvent;

public class ModelCheckerTool_Tool extends GeneratedTool {
  private MPSProject myProject;
  private ContentManager myContentManager;
  private ContentManagerListener myListener = null;
  private List<ModelCheckerViewer> myViewers = ListSequence.fromList(new ArrayList<ModelCheckerViewer>());

  public ModelCheckerTool_Tool(Project project) {
    super(project, "Model Checker", -1, IconManager.EMPTY_ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public JComponent getComponent() {
    return null;
  }

  public void init(Project project) {
    ModelCheckerTool_Tool.this.myProject = project.getComponent(MPSProjectHolder.class).getMPSProject();
    ModelCheckerTool_Tool.this.myContentManager = ModelCheckerTool_Tool.this.getContentManager();
  }

  public void dispose() {
    ModelCheckerTool_Tool.this.myContentManager.removeAllContents(true);
  }

  public ModelCheckerViewer checkModel(SModelDescriptor modelDescriptor, IOperationContext operationContext, boolean showTab) {
    ModelCheckerViewer newViewer = ModelCheckerTool_Tool.this.createViewer(operationContext);
    newViewer.checkModel(modelDescriptor);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkModels(List<SModelDescriptor> modelDescriptors, IOperationContext operationContext, boolean showTab) {
    ModelCheckerViewer newViewer = ModelCheckerTool_Tool.this.createViewer(operationContext);
    newViewer.checkModels(modelDescriptors);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkModule(IModule module, IOperationContext operationContext, boolean showTab) {
    ModelCheckerViewer newViewer = ModelCheckerTool_Tool.this.createViewer(operationContext);
    newViewer.checkModule(module);
    ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    return newViewer;
  }

  public ModelCheckerViewer checkModules(List<IModule> modules, IOperationContext operationContext, boolean showTab) {
    ModelCheckerViewer newViewer = ModelCheckerTool_Tool.this.createViewer(operationContext);
    newViewer.checkModules(modules);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkProject(MPSProject mpsProject, IOperationContext operationContext, boolean showTab) {
    ModelCheckerViewer newViewer = ModelCheckerTool_Tool.this.createViewer(operationContext);
    newViewer.checkProject(mpsProject);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public boolean checkModelsBeforeGenerationIfNeeded(IOperationContext operationContext, List<SModelDescriptor> modelDescriptors, Runnable regenerationRunnable) {
    boolean checkModels = ApplicationManager.getApplication().getComponent(GenerationSettings.class).isCheckModelsBeforeGeneration();
    if (!(checkModels)) {
      return true;
    }
    ModelCheckerViewer viewer = ModelCheckerTool_Tool.this.checkModels(modelDescriptors, operationContext, false);
    SearchResults<ModelCheckerIssue> issues = viewer.getSearchResults();
    int warnings = 0;
    int errors = 0;
    for (SearchResult<ModelCheckerIssue> issue : ListSequence.fromList(issues.getSearchResults())) {
      String category = issue.getCategory();
      if (ModelCheckerViewer.MyNodeRepresentator.CATEGORY_ERROR.equals(category)) {
        errors++;
      } else if (ModelCheckerViewer.MyNodeRepresentator.CATEGORY_WARNING.equals(category)) {
        warnings++;
      }
    }

    if (errors != 0) {
      String dialogMessage = "Model checker found " + errors + " errors and " + warnings + " warnings. Review them and don't generate models or ignore them?";
      int dialogAnswer = Messages.showDialog(operationContext.getProject(), dialogMessage, "Check Before Generation", new String[]{"Review Errors","Ignore Errors"}, 0, null);
      if (dialogAnswer == 0) {
        // review errors and warnings, don't generate 
        ModelCheckerTool_Tool.this.showTabWithResults(viewer);
        viewer.saveGenerationRunnable(regenerationRunnable);
        return false;
      } else if (dialogAnswer == 1) {
        // ignore errors and warnings 
        return true;
      }
    }
    return true;
  }

  public void closeTab(JComponent component) {
    ContentManager contentManager = ModelCheckerTool_Tool.this.getContentManager();
    Content content = contentManager.getContent(component);
    contentManager.removeContent(content, true);
  }

  private void closeCurrentTabIfUnpinned() {
    ContentManager contentManager = ModelCheckerTool_Tool.this.getContentManager();
    Content selectedContent = contentManager.getSelectedContent();
    if (selectedContent == null) {
      return;
    }
    if (!(selectedContent.isPinned())) {
      contentManager.removeContent(selectedContent, true);
    }
  }

  public void showTabWithResults(ModelCheckerViewer newViewer) {
    ModelCheckerTool_Tool.this.addListenerIfNeeded();
    ModelCheckerTool_Tool.this.closeCurrentTabIfUnpinned();
    ModelCheckerTool_Tool.this.addContent(newViewer, newViewer.getTabTitle(), newViewer.getTabIcon(), true);
    ModelCheckerTool_Tool.this.setSelectedComponent(newViewer);
    ListSequence.fromList(ModelCheckerTool_Tool.this.myViewers).addElement(newViewer);
    ModelCheckerTool_Tool.this.openToolLater(true);
  }

  private void addListenerIfNeeded() {
    if (ModelCheckerTool_Tool.this.myListener != null) {
      return;
    }
    ModelCheckerTool_Tool.this.myListener = new ContentManagerAdapter() {
      public void contentRemoved(ContentManagerEvent event) {
        int index = event.getIndex();
        ModelCheckerViewer elem = ListSequence.fromList(ModelCheckerTool_Tool.this.myViewers).getElement(index);
        elem.getUsagesView().dispose();
        ListSequence.fromList(ModelCheckerTool_Tool.this.myViewers).removeElement(elem);
      }
    };
    ModelCheckerTool_Tool.this.myContentManager.addContentManagerListener(ModelCheckerTool_Tool.this.myListener);
  }

  private ModelCheckerViewer createViewer(IOperationContext operationContext) {
    return new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, operationContext) {
      protected void close() {
        ModelCheckerTool_Tool.this.closeTab(this);
      }
    };
  }
}
