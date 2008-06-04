package jetbrains.mps.bootstrap.structureLanguage.findUsages;

/*Generated by MPS */

import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.util.CollectionUtil;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class NodeUsages_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeUsages_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Node Usages";
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
    Set<SReference> resRefs = FindUsagesManager.getInstance().findUsages(CollectionUtil.asSet(node), scope, new FindUsagesManager.ProgressAdapter(indicator), false);
    for (SReference reference : resRefs) {
      ListOperations.addElement(_results, reference.getSourceNode());
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Node Usages";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
