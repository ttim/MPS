package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_AddSetElementOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_AddSetElementOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    final SNode elementType_typevar_1226567148394 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createLessThanInequationStrong(typeCheckingContext.typeOf(IOperation_Behavior.call_getOperand_1213877410070(operation), "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226591597589", true), new _Quotations.QuotationClass_102().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1226567148394), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226591597587", false, 0, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createLessThanInequation(typeCheckingContext.typeOf(SLinkOperations.getTarget(operation, "argument", true), "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226567193852", true), typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1226567148394), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226567249137", false, 0, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation(typeCheckingContext.typeOf(operation, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226567264433", true), typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1226567148394), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1226567269197", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
