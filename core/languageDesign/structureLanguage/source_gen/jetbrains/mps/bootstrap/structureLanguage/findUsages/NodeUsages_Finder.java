package jetbrains.mps.bootstrap.structureLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.findusages.model.searchquery.SearchQuery;
import jetbrains.mps.ide.findusages.model.result.SearchResults;
import java.util.Set;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.ide.findusages.model.result.SearchResult;
import jetbrains.mps.smodel.SNodePointer;

public class NodeUsages_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeUsages_Finder");

  public String getConcept() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

  public String getDescription() {
    return "Node Usages";
  }

  public boolean isApplicable(SNode node) {
    return true;
  }

  public boolean isVisible() {
    return true;
  }

  public void doFind(SearchQuery searchQuery, SearchResults results) {
    Set<SReference> resRefs = FindUsagesManager.getInstance().findUsages(searchQuery.getNodePointer().getNode(), searchQuery.getScope());
    for(SReference reference : resRefs) {
      results.getSearchResults().add(new SearchResult(new SNodePointer(reference.getSourceNode()), "Node Usages"));
    }
    results.getSearchedNodePointers().add(new SNodePointer(searchQuery.getNodePointer().getNode()));
  }

}
