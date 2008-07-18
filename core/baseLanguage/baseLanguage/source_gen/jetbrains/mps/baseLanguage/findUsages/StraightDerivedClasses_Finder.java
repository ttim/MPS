package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SNode;

import java.util.List;

public class StraightDerivedClasses_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.StraightDerivedClasses_Finder");

  public String getDescription() {
    return "Straight Derivatives";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    for (SNode nodeUsage : FindUtils.executeFinder("jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeUsages_Finder", node, scope, indicator)) {
      if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(nodeUsage, null, false, false), "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
        if (SNodeOperations.hasRole(nodeUsage, "jetbrains.mps.baseLanguage.structure.ClassConcept", "superclass")) {
          ListOperations.addElement(_results, SNodeOperations.getParent(nodeUsage, null, false, false));
        }
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Straight Derivatives";
  }

}
