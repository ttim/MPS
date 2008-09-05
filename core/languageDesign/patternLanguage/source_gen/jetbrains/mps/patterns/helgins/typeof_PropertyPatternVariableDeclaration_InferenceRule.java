package jetbrains.mps.patterns.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PropertyPatternVariableDeclaration_InferenceRule implements InferenceRule_Runtime {

  public typeof_PropertyPatternVariableDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.patterns.helgins", "1202488170860", true), new QuotationClass_2().createNode(), _nodeToCheck_1029348928467, null, "jetbrains.mps.patterns.helgins", "1202488174301", intentionProvider);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.patterns.structure.PropertyPatternVariableDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
