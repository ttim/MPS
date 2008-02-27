package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.findusages.model.searchquery.SearchQuery;
import jetbrains.mps.ide.findusages.model.result.SearchResults;

import java.util.List;
import java.util.ArrayList;

import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.ide.findusages.model.result.SearchResult;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;
import jetbrains.mps.smodel.SNodePointer;

public class FieldUsages_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.FieldUsages_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Field Usages";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.VariableDeclaration";
  }

  public boolean isApplicable(SNode node) {
    if (SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false) == null && SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.Interface", false, false) == null) {
      return false;
    }
    if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.FieldDeclaration")) && !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"))) {
      return false;
    }
    return true;
  }

  public void doFind(SearchQuery searchQuery, SearchResults results) {
    SNode searchedNode = (SNode) searchQuery.getNode();
    // null
    List<SNode> fieldDeclarations = new ArrayList<SNode>();
    ListOperations.addElement(fieldDeclarations, searchedNode);
    // null
    if (SNodeOperations.getAncestor(searchedNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false) != null) {
      List<SearchResult> fieldDeclarationsResult = new ArrayList<SearchResult>();
      try {
        GeneratedFinder _finder = (GeneratedFinder) Class.forName("jetbrains.mps.baseLanguage.findUsages.OverridingFields_Finder").newInstance();
        SNode _node = searchedNode;
        IScope _scope;
        _scope = searchQuery.getScope();
        boolean rightConcept = _node.isInstanceOfConcept("jetbrains.mps.baseLanguage.structure.VariableDeclaration");
        if (!(rightConcept)) {
          FieldUsages_Finder.LOG.error("Trying to use finder that is not applicable to the concept. Returning empty results." + "[finder: \"" + _finder.getDescription() + "\" ; concept: " + searchQuery.getNodePointer().getNode().getConceptFqName());
        } else {
          boolean isApplicable = _finder.isApplicable(_node);
          if (!(isApplicable)) {
            FieldUsages_Finder.LOG.error("Trying to use finder that is not applicable to the node. Returning empty results." + "[finder: \"" + _finder.getDescription() + "\" ; node: " + searchQuery.getNodePointer().getNode().toString());
          } else {
            SearchResults results_8 = _finder.find(new SearchQuery(_node, _scope));
            for (SearchResult result : results_8.getSearchResults()) {
              fieldDeclarationsResult.add(result);
            }
          }
        }
      } catch (Throwable t) {
        FieldUsages_Finder.LOG.error("Error instantiating finder \"" + "jetbrains.mps.baseLanguage.findUsages.OverridingFields_Finder" + "\"  Message:" + t.getMessage());
      }
      {
        ICursor<SearchResult> _zCursor2 = CursorFactory.createCursor(fieldDeclarationsResult);
        try {
          while (_zCursor2.moveToNext()) {
            SearchResult result = _zCursor2.getCurrent();
            ListOperations.addElement(fieldDeclarations, (SNode) result.getNode());
          }
        } finally {
          _zCursor2.release();
        }
      }
    } else {
    }
    // null
    for (SNode fieldDeclaration : fieldDeclarations) {
      results.getSearchedNodePointers().add(new SNodePointer(fieldDeclaration));
      List<SearchResult> fieldUsagesResult = new ArrayList<SearchResult>();
      try {
        GeneratedFinder _finder = (GeneratedFinder) Class.forName("jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeUsages_Finder").newInstance();
        SNode _node = fieldDeclaration;
        IScope _scope;
        _scope = searchQuery.getScope();
        boolean rightConcept = _node.isInstanceOfConcept("jetbrains.mps.core.structure.BaseConcept");
        if (!(rightConcept)) {
          FieldUsages_Finder.LOG.error("Trying to use finder that is not applicable to the concept. Returning empty results." + "[finder: \"" + _finder.getDescription() + "\" ; concept: " + searchQuery.getNodePointer().getNode().getConceptFqName());
        } else {
          boolean isApplicable = _finder.isApplicable(_node);
          if (!(isApplicable)) {
            FieldUsages_Finder.LOG.error("Trying to use finder that is not applicable to the node. Returning empty results." + "[finder: \"" + _finder.getDescription() + "\" ; node: " + searchQuery.getNodePointer().getNode().toString());
          } else {
            SearchResults results_9 = _finder.find(new SearchQuery(_node, _scope));
            for (SearchResult result : results_9.getSearchResults()) {
              fieldUsagesResult.add(result);
            }
          }
        }
      } catch (Throwable t) {
        FieldUsages_Finder.LOG.error("Error instantiating finder \"" + "jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeUsages_Finder" + "\"  Message:" + t.getMessage());
      }
      for (SearchResult usage : fieldUsagesResult) {
        results.getSearchResults().add(new SearchResult(new SNodePointer(usage.getNode()), "Field Usages"));
      }
    }
  }

}
