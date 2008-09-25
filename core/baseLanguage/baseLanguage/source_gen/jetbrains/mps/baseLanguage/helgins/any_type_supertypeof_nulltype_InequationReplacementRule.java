package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.EquationInfo;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class any_type_supertypeof_nulltype_InequationReplacementRule extends InequationReplacementRule_Runtime {

  public any_type_supertypeof_nulltype_InequationReplacementRule() {
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo) {
    if (SNodeOperations.isInstanceOf(supertype, "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      {
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().reportTypeError(equationInfo.getNodeWithError(), "null type is not a subtype of primitive type", "r:f8affc78-bfdf-4de0-9e6a-97166f21591a(jetbrains.mps.baseLanguage.helgins@21_0)", "1222352232018", intentionProvider);
      }
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo) {
    boolean result_14532009 = true;
    if (SNodeOperations.isInstanceOf(supertype, "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      result_14532009 = false;
    }
    return result_14532009;
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
