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
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;

public class ConceptInstances_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.bootstrap.structureLanguage.findUsages.ConceptInstances_Finder");

  public String getDescription() {
    return "Concept Instances";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration";
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    List<SNode> resNodes = new ArrayList<SNode>(FindUsagesManager.getInstance().findInstances((AbstractConceptDeclaration)((AbstractConceptDeclaration)SNodeOperations.getAdapter(node)), scope, new FindUsagesManager.ProgressAdapter(indicator), false));
    for(SNode resNode : resNodes) {
      ListOperations.addElement(_results, resNode);
    }
  }

  public String getNodeCategory(SNode node) {
    return "Concept Instances";
  }

}
