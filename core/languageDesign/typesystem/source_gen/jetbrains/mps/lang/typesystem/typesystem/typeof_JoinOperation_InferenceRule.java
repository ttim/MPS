package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_JoinOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_JoinOperation_InferenceRule() {
  }

  public void applyRule(final SNode expression, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = expression;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1239038069332", true), (SNode)new _Quotations.QuotationClass_43().createNode(SLinkOperations.getTarget(expression, "conceptOfInstance", false), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1239038069330", intentionProvider);
    }
    for (SNode argument : SLinkOperations.getTargets(expression, "argument", true)) {
      {
        SNode _nodeToCheck_1029348928467 = argument;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1239038069348", true), (SNode)new _Quotations.QuotationClass_44().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1239038069343", false, 0, intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.CreateJoinExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
