package jetbrains.mps.bootstrap.structureLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import org.jetbrains.annotations.Nullable;

public class NodeAndDescendantsUsages_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeAndDescendantsUsages_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Node & Descendants Usages";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

  public boolean isApplicable(SNode node) {
    return true;
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    Set<SNode> nodes = new HashSet<SNode>();
    nodes.add(node);
    for(SNode child : SNodeOperations.getDescendants(node, null, false)) {
      nodes.add(child);
    }
    // 
    Set<SReference> resRefs = FindUsagesManager.getInstance().findUsages(nodes, scope, new FindUsagesManager.ProgressAdapter(indicator), false);
    for(SReference reference : resRefs) {
      if (!(nodes.contains(reference.getSourceNode()))) {
        ListOperations.addElement(_results, reference.getSourceNode());
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    for(SNode child : SNodeOperations.getDescendants(node, null, false)) {
      ListOperations.addElement(_results, child);
    }
  }

  public String getNodeCategory(SNode node) {
    return "Node Descendants Usages";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
