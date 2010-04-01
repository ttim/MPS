package jetbrains.mps.lang.structure.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.findUsages.FindUsagesManager;

public class NodeAndDescendantsUsages_Finder extends GeneratedFinder {
  private static Logger LOG = Logger.getLogger("jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder");

  public String getDescription() {
    return "Node & Descendants Usages";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    Set<SNode> nodes = SetSequence.fromSet(new HashSet<SNode>());
    SetSequence.fromSet(nodes).addElement(node);
    for (SNode child : ListSequence.fromList(SNodeOperations.getDescendants(node, null, false, new String[]{}))) {
      SetSequence.fromSet(nodes).addElement(child);
    }
    // 
    Set<SReference> resRefs = FindUsagesManager.getInstance().findUsages(nodes, scope, new FindUsagesManager.ProgressAdapter(indicator), false);
    for (SReference reference : resRefs) {
      if (!(SetSequence.fromSet(nodes).contains(reference.getSourceNode()))) {
        ListSequence.fromList(_results).addElement(reference.getSourceNode());
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListSequence.fromList(_results).addElement(node);
  }

  public String getNodeCategory(SNode node) {
    return "Node Descendants Usages";
  }
}
