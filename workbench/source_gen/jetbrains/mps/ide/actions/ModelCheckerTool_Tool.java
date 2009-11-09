package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import jetbrains.mps.project.MPSProject;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.icons.IconManager;
import com.intellij.openapi.wm.ToolWindowAnchor;
import javax.swing.JComponent;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.List;
import jetbrains.mps.project.IModule;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.generator.GenerationSettings;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.content.ContentManager;
import com.intellij.ui.content.Content;

public class ModelCheckerTool_Tool extends GeneratedTool {
  private MPSProject myProject;

  public ModelCheckerTool_Tool(Project project) {
    super(project, "Model Checker", -1, IconManager.EMPTY_ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public JComponent getComponent() {
    return null;
  }

  public void init(Project project) {
    ModelCheckerTool_Tool.this.myProject = project.getComponent(MPSProjectHolder.class).getMPSProject();
  }

  public ModelCheckerViewer checkModel(SModelDescriptor modelDescriptor, boolean showTab) {
    ModelCheckerViewer newViewer = new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, ModelCheckerTool_Tool.this);
    newViewer.checkModel(modelDescriptor);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkModels(List<SModelDescriptor> modelDescriptors, boolean showTab) {
    ModelCheckerViewer newViewer = new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, ModelCheckerTool_Tool.this);
    newViewer.checkModels(modelDescriptors);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkModule(IModule module, boolean showTab) {
    ModelCheckerViewer newViewer = new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, ModelCheckerTool_Tool.this);
    newViewer.checkModule(module);
    ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    return newViewer;
  }

  public ModelCheckerViewer checkModules(List<IModule> modules, boolean showTab) {
    ModelCheckerViewer newViewer = new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, ModelCheckerTool_Tool.this);
    newViewer.checkModules(modules);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public ModelCheckerViewer checkProject(MPSProject mpsProject, boolean showTab) {
    ModelCheckerViewer newViewer = new ModelCheckerViewer(ModelCheckerTool_Tool.this.myProject, ModelCheckerTool_Tool.this);
    newViewer.checkProject(mpsProject);
    if (showTab) {
      ModelCheckerTool_Tool.this.showTabWithResults(newViewer);
    }
    return newViewer;
  }

  public boolean checkModelsBeforeGenerationIfNeeded(Project project, List<SModelDescriptor> modelDescriptors) {
    boolean checkModels = ApplicationManager.getApplication().getComponent(GenerationSettings.class).isCheckModelsBeforeGeneration();
    if (!(checkModels)) {
      return true;
    }
    ModelCheckerViewer viewer = ModelCheckerTool_Tool.this.checkModels(modelDescriptors, false);
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
      int dialogAnswer = Messages.showDialog(project, dialogMessage, "Check Before Generation", new String[]{"Review Errors","Ignore Errors"}, 0, null);
      if (dialogAnswer == 0) {
        // review errors and warnings, don't generate 
        viewer.showTabWithResults();
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
    ModelCheckerTool_Tool.this.closeCurrentTabIfUnpinned();
    ModelCheckerTool_Tool.this.addContent(newViewer, newViewer.getTabTitle(), newViewer.getTabIcon(), true);
    ModelCheckerTool_Tool.this.setSelectedComponent(newViewer);
    ModelCheckerTool_Tool.this.openToolLater(true);
  }
}
