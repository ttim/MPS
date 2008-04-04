package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.ide.progress.IAdaptiveProgressMonitor;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import org.jetbrains.annotations.Nullable;

public class ClassAncestors_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.ClassAncestors_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Ancestors";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }

  public boolean isApplicable(SNode node) {
    return SLinkOperations.getTarget(node, "superclass", true) != null;
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, IAdaptiveProgressMonitor monitor) {
    SNode current = node;
    while(current != null) {
      current = SLinkOperations.getTarget(SLinkOperations.getTarget(current, "superclass", true), "classifier", false);
      if (current != null) {
        ListOperations.addElement(_results, current);
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Ancestor";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
