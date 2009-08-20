package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_IntervalLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_IntervalLiteral_InferenceRule() {
  }

  public void applyRule(final SNode literal, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1235747425275 = typeCheckingContext.createNewRuntimeTypesVariable();
    if ((SLinkOperations.getTarget(literal, "end", true) != null)) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(literal, "end", true);
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequationStrong((SNode)typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), (SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425282", true), _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425278", false, 0, intentionProvider);
      }
    }
    if ((SLinkOperations.getTarget(literal, "start", true) != null)) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(literal, "start", true);
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createLessThanInequationStrong((SNode)typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), (SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425297", true), _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425293", false, 0, intentionProvider);
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = literal;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425314", true), (SNode)new _Quotations.QuotationClass_5().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1235747425275), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "1235747425306", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.IntervalLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
