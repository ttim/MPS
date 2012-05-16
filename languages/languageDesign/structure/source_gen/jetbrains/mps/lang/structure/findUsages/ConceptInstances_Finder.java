package jetbrains.mps.lang.structure.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.findUsages.FindUsagesManager;
import java.util.Collections;
import jetbrains.mps.findUsages.SearchType;

public class ConceptInstances_Finder extends GeneratedFinder {
  private static Logger LOG = Logger.getLogger("jetbrains.mps.lang.structure.findUsages.ConceptInstances_Finder");

  public ConceptInstances_Finder() {
  }

  public String getDescription() {
    return "Concept Instances";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration";
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressMonitor monitor) {
    monitor.start(getDescription(), 0);
    try {
      List<SNode> resNodes = ListSequence.fromListWithValues(new ArrayList<SNode>(), FindUsagesManager.getInstance().findUsages(Collections.singleton(node), SearchType.INSTANCES, scope, monitor));
      for (SNode resNode : resNodes) {
        ListSequence.fromList(_results).addElement(resNode);
      }
    } finally {
      monitor.done();
    }
  }

  public String getNodeCategory(SNode node) {
    return "Concept Instances";
  }
}
