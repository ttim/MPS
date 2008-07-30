package jetbrains.mps.baseLanguage.classifiers.helgins;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.baseLanguage.classifiers.behavior.BaseClassifierType_Behavior;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.bootstrap.helgins.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.patterns.IMatchingPattern;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SNode;

public class check_IMemberOperation_NonTypesystemRule implements NonTypesystemRule_Runtime {

  public check_IMemberOperation_NonTypesystemRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    {
      final SNode operandType = TypeChecker.getInstance().getRuntimeSupport().typeOf(IOperation_Behavior.call_getOperand_1213877410070(nodeToCheck), "jetbrains.mps.baseLanguage.classifiers.helgins", "1205921836720", true);
      TypeChecker.getInstance().getRuntimeSupport().whenConcrete(operandType, new Runnable() {

        public void run() {
          {
            IMatchingPattern pattern_ = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.classifiers.structure.BaseClassifierType");
            SNode coercedNode_ = TypeChecker.getInstance().getRuntimeSupport().coerce(TypeChecker.getInstance().getEquationManager().getRepresentator(operandType), pattern_);
            if (coercedNode_ != null) {
              if (!(ListSequence.fromList(BaseClassifierType_Behavior.call_getMembers_1213877402148(coercedNode_, nodeToCheck)).contains(SLinkOperations.getTarget(nodeToCheck, "member", false)))) {
                {
                  BaseIntentionProvider intentionProvider = null;
                  TypeChecker.getInstance().reportTypeError(nodeToCheck, "Declaration is out of scope", "jetbrains.mps.baseLanguage.classifiers.helgins@16_0", "1217434393591", intentionProvider);
                }
              }
            }
          }
        }

      }, "jetbrains.mps.baseLanguage.classifiers.helgins", "1205921833059");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.classifiers.structure.IMemberOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
