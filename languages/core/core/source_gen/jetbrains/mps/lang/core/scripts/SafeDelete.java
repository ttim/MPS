package jetbrains.mps.lang.core.scripts;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseGeneratedRefactoring;
import jetbrains.mps.refactoring.framework.RefactoringTarget;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.GlobalScope;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class SafeDelete extends BaseGeneratedRefactoring {
  public SafeDelete() {
  }

  public String getUserFriendlyName() {
    return "Safe Delete Node";
  }

  public String getKeyStroke() {
    return getKeyStroke_static();
  }

  public RefactoringTarget getRefactoringTarget() {
    return RefactoringTarget.NODE;
  }

  public boolean isApplicableWRTConcept(SNode node) {
    return SModelUtil.isAssignableConcept(SNodeOperations.getConceptDeclaration(node), SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept"));
  }

  public boolean refactorImmediatelyIfNoUsages() {
    return true;
  }

  public boolean showsAffectedNodes() {
    return true;
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    SearchResults<SNode> searchResults = FindUtils.getSearchResults(new EmptyProgressMonitor(), refactoringContext.getSelectedNode(), GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder");

    List<SearchResult<SNode>> searchResultsList = searchResults.getSearchResults();
    List<SearchResult<SNode>> searchResultsCopy = ListSequence.fromListWithValues(new ArrayList<SearchResult<SNode>>(), searchResultsList);

    for (SearchResult<SNode> searchResult : searchResultsCopy) {
      SNode resultNode = searchResult.getObject();
      if (ListSequence.fromList(SNodeOperations.getAncestors(resultNode, null, true)).contains(refactoringContext.getSelectedNode())) {
        searchResults.remove(searchResult);
      }
    }

    return searchResults;
  }

  public void doRefactor(final RefactoringContext refactoringContext) {
    SNodeOperations.deleteNode(refactoringContext.getSelectedNode());
  }

  public boolean isOneTargetOnly() {
    return true;
  }

  public static String getKeyStroke_static() {
    return "alt DELETE";
  }
}
