package jetbrains.mps.bootstrap.structureLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.ArrayList;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import org.jetbrains.annotations.Nullable;

public class ExactConceptInstances_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.ExactConceptInstances_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Exact Concept Instances";
  }

  public String getLongDescription() {
    return "only instances of the specified concept, not including instances of it's subconcepts";
  }

  public String getConcept() {
    return "jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration";
  }

  public boolean isApplicable(SNode node) {
    return true;
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    List<SNode> resNodes = new ArrayList<SNode>(FindUsagesManager.getInstance().findExactInstances((AbstractConceptDeclaration)((ConceptDeclaration)SNodeOperations.getAdapter(node)), scope, new FindUsagesManager.ProgressAdapter(indicator), false));
    for(SNode resNode : resNodes) {
      ListOperations.addElement(_results, resNode);
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Concept Instances";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
