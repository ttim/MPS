package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;

import java.util.List;

import jetbrains.mps.smodel.IScope;

import java.util.ArrayList;

import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;

import java.util.Set;
import java.util.HashSet;

import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.constraints.BaseMethodDeclaration_Behavior;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.ide.findusages.model.result.SearchResult;
import jetbrains.mps.ide.findusages.model.searchquery.SearchQuery;

public class InterfaceMethodImplementations_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.InterfaceMethodImplementations_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Interface Method Implementations";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration";
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(node, null, false, false), "jetbrains.mps.baseLanguage.structure.Interface") && SNodeOperations.hasRole(node, "jetbrains.mps.baseLanguage.structure.Interface", "method");
  }

  protected List<SNode> doFind(SNode node, IScope scope) {
    List<SNode> _results = new ArrayList<SNode>();
    {
      ListOperations.addElement(_results, node);
      // null
      List<SNode> implementorsAndAncestorsList = new ArrayList<SNode>();
      {
        ICursor<SNode> _zCursor6 = CursorFactory.createCursor(this.executejetbrainsMpsBaseLanguageFindUsagesImplementingClasses_Finder(SNodeOperations.getParent(node, null, false, false), scope));
        try {
          while (_zCursor6.moveToNext()) {
            SNode implementor = _zCursor6.getCurrent();
            ListOperations.addElement(implementorsAndAncestorsList, implementor);
            ListOperations.addAllElements(implementorsAndAncestorsList, this.executejetbrainsMpsBaseLanguageFindUsagesClassAncestors_Finder(implementor, scope));
          }
        } finally {
          _zCursor6.release();
        }
      }
      // null
      Set<SNode> implementorsAndAncestorsNodes = new HashSet<SNode>();
      {
        ICursor<SNode> _zCursor7 = CursorFactory.createCursor(implementorsAndAncestorsList);
        try {
          while (_zCursor7.moveToNext()) {
            SNode implementorOrAncestor = _zCursor7.getCurrent();
            implementorsAndAncestorsNodes.add(implementorOrAncestor);
          }
        } finally {
          _zCursor7.release();
        }
      }
      // null
      {
        ICursor<SNode> _zCursor8 = CursorFactory.createCursor(implementorsAndAncestorsNodes);
        try {
          while (_zCursor8.moveToNext()) {
            SNode classNode = _zCursor8.getCurrent();
            {
              ICursor<SNode> _zCursor9 = CursorFactory.createCursor(SLinkOperations.getTargets(classNode, "method", true));
              try {
                while (_zCursor9.moveToNext()) {
                  SNode sMethod = _zCursor9.getCurrent();
                  if (BaseMethodDeclaration_Behavior.call_hasSameSignature_1204901126405(sMethod, node)) {
                    ListOperations.addElement(_results, sMethod);
                  }
                }
              } finally {
                _zCursor9.release();
              }
            }
          }
        } finally {
          _zCursor8.release();
        }
      }
    }
    return _results;
  }

  public List<SNode> getSearchedNodes(SNode node, IScope scope) {
    List<SNode> _results = new ArrayList<SNode>();
    return _results;
  }

  public String getNodeCategory(SNode node) {
    return "Method Implementation";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

  public List<SNode> executejetbrainsMpsBaseLanguageFindUsagesImplementingClasses_Finder(SNode node, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    try {
      GeneratedFinder finder = (GeneratedFinder) Class.forName("jetbrains.mps.baseLanguage.findUsages.ImplementingClasses_Finder").newInstance();
      {
        ICursor<SearchResult> _zCursor31 = CursorFactory.createCursor(finder.find(new SearchQuery(node, scope)).getSearchResults());
        try {
          while (_zCursor31.moveToNext()) {
            SearchResult searchResult = _zCursor31.getCurrent();
            ListOperations.addElement(result, searchResult.getNode());
          }
        } finally {
          _zCursor31.release();
        }
      }
    } catch (Throwable t) {
      InterfaceMethodImplementations_Finder.LOG.error("Error instantiating finder \"" + "jetbrains.mps.baseLanguage.findUsages.ImplementingClasses_Finder" + "\"  Message:" + t.getMessage());
    }
    return result;
  }

  public List<SNode> executejetbrainsMpsBaseLanguageFindUsagesClassAncestors_Finder(SNode node, IScope scope) {
    List<SNode> result = new ArrayList<SNode>();
    try {
      GeneratedFinder finder = (GeneratedFinder) Class.forName("jetbrains.mps.baseLanguage.findUsages.ClassAncestors_Finder").newInstance();
      {
        ICursor<SearchResult> _zCursor32 = CursorFactory.createCursor(finder.find(new SearchQuery(node, scope)).getSearchResults());
        try {
          while (_zCursor32.moveToNext()) {
            SearchResult searchResult = _zCursor32.getCurrent();
            ListOperations.addElement(result, searchResult.getNode());
          }
        } finally {
          _zCursor32.release();
        }
      }
    } catch (Throwable t) {
      InterfaceMethodImplementations_Finder.LOG.error("Error instantiating finder \"" + "jetbrains.mps.baseLanguage.findUsages.ClassAncestors_Finder" + "\"  Message:" + t.getMessage());
    }
    return result;
  }

}
