package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.findusages.view.optionseditor.DefaultSearchOptionsComponent;
import jetbrains.mps.ide.findusages.view.UsagesViewTool;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import java.awt.Frame;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.findusages.view.optionseditor.FindUsagesOptions;
import jetbrains.mps.ide.findusages.view.optionseditor.FindUsagesDialog;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.view.optionseditor.options.ViewOptions;
import jetbrains.mps.ide.findusages.view.optionseditor.options.FindersOptions;
import jetbrains.mps.ide.findusages.view.optionseditor.options.ScopeOptions;

/*package*/ class FindUsagesHelper {
  private Project myProject;
  private boolean myWithDialog;

  /*package*/ FindUsagesHelper(Project project, boolean withDialog) {
    myProject = project;
    myWithDialog = withDialog;
  }

  private DefaultSearchOptionsComponent getOptionsComponent() {
    return myProject.getComponent(DefaultSearchOptionsComponent.class);
  }

  private UsagesViewTool getTool() {
    return myProject.getComponent(UsagesViewTool.class);
  }

  /*package*/ boolean isApplicable() {
    return getTool() != null && getOptionsComponent() != null;
  }

  /*package*/ void invoke(final EditorCell cell, final SNode node, Frame frame, final IOperationContext context, final SModelDescriptor model) {
    // get node 
    final Wrappers._T<SNode> operationNode = new Wrappers._T<SNode>();
    final Wrappers._T<String> concept = new Wrappers._T<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        operationNode.value = (cell == null ?
          node :
          cell.getSNodeWRTReference()
        );
        concept.value = operationNode.value.getConceptFqName();
      }
    });
    // show dialog 
    final Wrappers._T<FindUsagesOptions> options = new Wrappers._T<FindUsagesOptions>(getOptionsComponent().getDefaultOptions().getDefaultSearchOptions(concept.value));
    FindUsagesDialog dialog = new FindUsagesDialog(options.value, operationNode.value, myProject, frame);
    if (myWithDialog) {
      dialog.showDialog();
      if (dialog.isCancelled()) {
        return;
      }
    }
    options.value = dialog.getResult();
    getOptionsComponent().getDefaultOptions().setDefaultSearchOptions(concept.value, options.value);
    // start 
    final Wrappers._T<IResultProvider> provider = new Wrappers._T<IResultProvider>();
    final Wrappers._T<SearchQuery> query = new Wrappers._T<SearchQuery>();
    final Wrappers._T<ViewOptions> viewOptions = new Wrappers._T<ViewOptions>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        provider.value = options.value.getOption(FindersOptions.class).getResult();
        query.value = options.value.getOption(ScopeOptions.class).getResult(operationNode.value, context, model);
        viewOptions.value = options.value.getOption(ViewOptions.class);
      }
    });
    getTool().findUsages(provider.value, query.value, true, viewOptions.value.myShowOneResult, viewOptions.value.myNewTab, "No usages for that node");
  }
}
