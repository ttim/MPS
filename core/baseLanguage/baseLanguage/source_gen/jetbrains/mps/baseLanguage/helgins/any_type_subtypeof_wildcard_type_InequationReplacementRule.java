package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class any_type_subtypeof_wildcard_type_InequationReplacementRule extends InequationReplacementRule_Runtime {

  public any_type_subtypeof_wildcard_type_InequationReplacementRule() {
  }

  public void processInequation(SNode subtype, SNode supertype, EquationInfo equationInfo) {
    // do I have to say more? 
  }

  public boolean checkInequation(SNode subtype, SNode supertype, EquationInfo equationInfo) {
    // do I have to say more? 
    return true;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicableSubtype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
  }

  public boolean isApplicableSupertype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.WildCardType";
  }

}
