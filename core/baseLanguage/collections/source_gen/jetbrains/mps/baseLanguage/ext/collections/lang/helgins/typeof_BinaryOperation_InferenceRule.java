package jetbrains.mps.baseLanguage.ext.collections.lang.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_BinaryOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_BinaryOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    SNode lValue = RulesFunctions_Collections.getInput(op);
    SNode rValue = SLinkOperations.getTarget(op, "rightExpression", true);
    final SNode elementType_typevar_1184848397564 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    final SNode sequenceType_typevar_1184848409899 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(sequenceType_typevar_1184848409899), new QuotationClass_35().createNode(TypeChecker.getInstance().getEquationManager().getRepresentator(elementType_typevar_1184848397564)), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848442457", intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(lValue, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848533289", true), TypeChecker.getInstance().getEquationManager().getRepresentator(sequenceType_typevar_1184848409899), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848544308", false, 0, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(rValue, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848549565", true), TypeChecker.getInstance().getEquationManager().getRepresentator(sequenceType_typevar_1184848409899), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848553704", false, 0, intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = op;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(op, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848561861", true), TypeChecker.getInstance().getEquationManager().getRepresentator(sequenceType_typevar_1184848409899), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.ext.collections.lang.helgins)", "1184848565182", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.BinaryOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
