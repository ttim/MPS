package jetbrains.mps.lang.structure.scripts;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseGeneratedRefactoring;
import jetbrains.mps.lang.core.scripts.SafeDelete;
import jetbrains.mps.refactoring.framework.RefactoringTarget;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.ide.findusages.view.FindUtils;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.LinkedHashMap;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.refactoring.framework.RefactoringUtil;

public class SafeDeleteConcept extends BaseGeneratedRefactoring {
  public static final String nodeAspects = "nodeAspects";

  public SafeDeleteConcept() {
    this.addTransientParameter("nodeAspects");
  }

  public String getUserFriendlyName() {
    return "Safe Delete Concept";
  }

  public String getKeyStroke() {
    return getKeyStroke_static();
  }

  public Class getOverridenRefactoringClass() {
    return SafeDelete.class;
  }

  public RefactoringTarget getRefactoringTarget() {
    return RefactoringTarget.NODE;
  }

  public boolean isApplicableWRTConcept(SNode node) {
    return SModelUtil.isAssignableConcept(SNodeOperations.getConceptDeclaration(node), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"));
  }

  public boolean refactorImmediatelyIfNoUsages() {
    return true;
  }

  public boolean showsAffectedNodes() {
    return true;
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    // all usages excluding concept's aspects
    refactoringContext.setParameter("nodeAspects", AbstractConceptDeclaration_Behavior.call_findAllAspects_7754459869734028917(refactoringContext.getSelectedNode(), GlobalScope.getInstance()));

    SearchResults searchResults = new SearchResults();
    searchResults.addAll(FindUtils.getSearchResults(new EmptyProgressIndicator(), refactoringContext.getSelectedNode(), GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.ConceptInstances_Finder", "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder"));
    for (SNode aspect : ListSequence.fromList(((List<SNode>)((List)refactoringContext.getParameter("nodeAspects"))))) {
      searchResults.addAll(FindUtils.getSearchResults(new EmptyProgressIndicator(), aspect, GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder"));
    }

    List<SearchResult<SNode>> searchResultsList = searchResults.getSearchResults();
    List<SearchResult<SNode>> searchResultsCopy = ListSequence.fromListWithValues(new ArrayList<SearchResult<SNode>>(), searchResultsList);

    for (SearchResult<SNode> searchResult : searchResultsCopy) {
      SNode containingRoot = searchResult.getObject().getContainingRoot();
      if (((List)refactoringContext.getParameter("nodeAspects")).contains(containingRoot)) {
        searchResults.remove(searchResult);
      }
    }

    return searchResults;
  }

  public void doRefactor(final RefactoringContext refactoringContext) {
    for (SNode aspectNode : ((List<SNode>)((List)refactoringContext.getParameter("nodeAspects")))) {
      SNodeOperations.deleteNode(aspectNode);
    }
    SNodeOperations.deleteNode(refactoringContext.getSelectedNode());
  }

  public Map<IModule, List<SModel>> getModelsToGenerate(final RefactoringContext refactoringContext) {
    Map<IModule, List<SModel>> result = MapSequence.fromMap(new LinkedHashMap<IModule, List<SModel>>(16, (float)0.75, false));
    Language sourceLanguage = Language.getLanguageFor(SNodeOperations.getModel(refactoringContext.getSelectedNode()).getModelDescriptor());
    if (sourceLanguage != null) {
      MapSequence.fromMap(result).putAll(RefactoringUtil.getLanguageModels(refactoringContext.getSelectedMPSProject(), sourceLanguage));
    }
    return result;
  }

  public boolean isOneTargetOnly() {
    return true;
  }

  public static String getKeyStroke_static() {
    return SafeDelete.getKeyStroke_static();
  }
}
