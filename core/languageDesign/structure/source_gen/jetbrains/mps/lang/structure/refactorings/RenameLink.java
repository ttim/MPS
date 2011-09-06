package jetbrains.mps.lang.structure.refactorings;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseLoggableRefactoring;
import jetbrains.mps.lang.core.refactorings.Rename;
import jetbrains.mps.refactoring.framework.IRefactoringTarget;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.refactoring.framework.paramchooser.mps.MPSChooserFactory;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.Language;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.view.FindUtils;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.project.GlobalScope;

public class RenameLink extends BaseLoggableRefactoring {
  public RenameLink() {
    this.addTransientParameter("newName");
    this.addTransientParameter("myNewName");
  }

  public String getUserFriendlyName() {
    return "Rename Link";
  }

  public String getKeyStroke() {
    return getKeyStroke_static();
  }

  public Class getOverridenRefactoringClass() {
    return Rename.class;
  }

  public IRefactoringTarget getRefactoringTarget() {
    return new RenameLink_Target();
  }

  public boolean init(final RefactoringContext refactoringContext) {
    // myNewName can be pre-set in context to skip chooser dialog - temporary solution 
    if (((String) refactoringContext.getParameter("myNewName")) == null) {
      if (!(RenameLink.this.ask(refactoringContext, MPSChooserFactory.createStringChooser(refactoringContext, "newName", new RenameLink_newName_Settings(refactoringContext))))) {
        return false;
      }
      refactoringContext.setParameter("myNewName", ((String) refactoringContext.getParameter("newName")));
    }
    return true;
  }

  public void refactor(final RefactoringContext refactoringContext) {
    SNode concept = SNodeOperations.getAncestor(refactoringContext.getSelectedNode(), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration", false, false);
    String newLinkName = SNodeOperations.getModel(concept).getSModelFqName() + "." + SPropertyOperations.getString(concept, "name");
    refactoringContext.changeFeatureName(refactoringContext.getSelectedNode(), newLinkName, ((String) refactoringContext.getParameter("myNewName")));
  }

  public List<SModel> getModelsToGenerate(final RefactoringContext refactoringContext) {
    List<SModel> result = ListSequence.fromList(new ArrayList<SModel>());
    Language sourceLanguage = Language.getLanguageFor(refactoringContext.getSelectedModel());
    if (sourceLanguage == null) {
      return result;
    }
    Map<IModule, List<SModel>> modelMap = RefactoringUtil.getLanguageAndItsExtendingLanguageModels(refactoringContext.getSelectedProject(), sourceLanguage);
    for (List<SModel> modelList : Sequence.fromIterable(modelMap.values())) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(modelList));
    }
    return result;
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    return FindUtils.getSearchResults(new EmptyProgressIndicator(), refactoringContext.getSelectedNode(), GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.LinkInstances_Finder", "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder");
  }

  public void updateModel(final SModel model, final RefactoringContext refactoringContext) {
    refactoringContext.updateByDefault(model);
  }

  public static String getKeyStroke_static() {
    return Rename.getKeyStroke_static();
  }
}
