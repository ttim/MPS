package jetbrains.mps.uiLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_GenericNewExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_GenericNewExpression_InferenceRule() {
  }

  public void applyRule(final SNode expression, final TypeCheckingContext typeCheckingContext) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(expression, "creator", true), "jetbrains.mps.uiLanguage.structure.BeanCreator")) {
      {
        SNode _nodeToCheck_1029348928467 = expression;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1207754534566", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1207754534577", true), (SNode)typeCheckingContext.typeOf(SNodeOperations.getAncestor(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(expression, "creator", true), "jetbrains.mps.uiLanguage.structure.BeanCreator"), "constructor", false), "jetbrains.mps.uiLanguage.structure.BeanDeclaration", false, false), "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1207754534568", true), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.GenericNewExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }
}
