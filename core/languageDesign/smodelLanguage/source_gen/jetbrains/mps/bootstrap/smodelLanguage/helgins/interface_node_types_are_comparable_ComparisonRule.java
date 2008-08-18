package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.ComparisonRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class interface_node_types_are_comparable_ComparisonRule extends ComparisonRule_Runtime {

  public interface_node_types_are_comparable_ComparisonRule() {
  }

  public boolean areComparable(SNode node1, SNode node2) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node1, "concept", false), "jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptDeclaration") || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node2, "concept", false), "jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptDeclaration")) {
      return true;
    }
    return false;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicable1(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableConceptFQName1());
  }

  public boolean isApplicable2(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableConceptFQName2());
  }

  public String getApplicableConceptFQName1() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType";
  }

  public String getApplicableConceptFQName2() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType";
  }

}
