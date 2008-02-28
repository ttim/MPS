package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.ErrorInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class any_type_supertypeof_nulltype_InequationReplacementRule extends InequationReplacementRule_Runtime {

  public  any_type_supertypeof_nulltype_InequationReplacementRule() {
  }

  public void processInequation(SNode subtype, SNode supertype, ErrorInfo errorInfo) {
    // truth
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
    return "jetbrains.mps.baseLanguage.structure.NullType";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

}
