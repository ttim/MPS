package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_CoerceExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeOf_CoerceExpression_InferenceRule() {
  }

  public void applyRule(final SNode coerceExpression, final TypeCheckingContext typeCheckingContext) {
    SNode concept;
    SNode pattern = SLinkOperations.getTarget(coerceExpression, "pattern", true);
    if (SNodeOperations.isInstanceOf(pattern, "jetbrains.mps.lang.typesystem.structure.ConceptReference")) {
      concept = SLinkOperations.getTarget(SNodeOperations.cast(pattern, "jetbrains.mps.lang.typesystem.structure.ConceptReference"), "concept", false);
    } else if (SNodeOperations.isInstanceOf(pattern, "jetbrains.mps.lang.typesystem.structure.PatternCondition")) {
      concept = SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(pattern, "jetbrains.mps.lang.typesystem.structure.PatternCondition"), "pattern", true), "patternNode", true));
    } else
    {
      return;
    }
    {
      SNode _nodeToCheck_1029348928467 = coerceExpression;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1195223916497", true), (SNode)new _Quotations.QuotationClass_14().createNode(concept, typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1195223916495", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.CoerceExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
