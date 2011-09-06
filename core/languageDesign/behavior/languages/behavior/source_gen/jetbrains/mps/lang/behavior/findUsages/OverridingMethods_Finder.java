package jetbrains.mps.lang.behavior.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class OverridingMethods_Finder extends GeneratedFinder {
  private static Logger LOG = Logger.getLogger("jetbrains.mps.lang.behavior.findUsages.OverridingMethods_Finder");

  public OverridingMethods_Finder() {
  }

  public String getDescription() {
    return "Overriding Methods";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration";
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.lang.behavior.structure.ConceptBehavior");
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    for (SNode nodeUsage : ListSequence.fromList(FindUtils.executeFinder("jetbrains.mps.lang.structure.findUsages.NodeUsages_Finder", node, scope, indicator))) {
      if (SNodeOperations.isInstanceOf(nodeUsage, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration") && SLinkOperations.getTarget(SNodeOperations.cast(nodeUsage, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "overriddenMethod", false) == node) {
        ListSequence.fromList(_results).addElement(nodeUsage);
        for (SNode overriding : ListSequence.fromList(FindUtils.executeFinder("jetbrains.mps.lang.behavior.findUsages.OverridingMethods_Finder", nodeUsage, scope, indicator))) {
          ListSequence.fromList(_results).addElement(overriding);
        }
      }
    }
  }
}
