package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_Link_DeleteChildOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeOf_Link_DeleteChildOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    final SNode Concept_typevar_1206099630117 = typeCheckingContext.createNewRuntimeTypesVariable();
    RulesUtil.equate_inputNodeConcept(typeCheckingContext, op, typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1206099630117));
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation(typeCheckingContext.typeOf(op, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1205528931094", true), new _Quotations.QuotationClass_54().createNode(typeCheckingContext.getEquationManager().getRepresentator(Concept_typevar_1206099630117), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1205528931092", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.Link_DeleteChildOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
