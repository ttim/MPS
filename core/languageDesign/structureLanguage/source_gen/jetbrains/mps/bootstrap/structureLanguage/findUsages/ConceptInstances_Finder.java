package jetbrains.mps.bootstrap.structureLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;

import java.util.List;

import jetbrains.mps.smodel.IScope;

import java.util.ArrayList;

import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import org.jetbrains.annotations.Nullable;

public class ConceptInstances_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.ConceptInstances_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Concept Instances";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration");
  }

  protected List<SNode> doFind(SNode node, IScope scope) {
    List<SNode> _results = new ArrayList<SNode>();
    {
      List<SNode> resNodes = FindUsagesManager.getInstance().findInstances(node, scope);
      for (SNode resNode : resNodes) {
        ListOperations.addElement(_results, resNode);
      }
      ListOperations.addElement(_results, node);
    }
    return _results;
  }

  public List<SNode> getSearchedNodes(SNode node, IScope scope) {
    List<SNode> _results = new ArrayList<SNode>();
    return _results;
  }

  public String getNodeCategory(SNode node) {
    return "Concept Instances";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
