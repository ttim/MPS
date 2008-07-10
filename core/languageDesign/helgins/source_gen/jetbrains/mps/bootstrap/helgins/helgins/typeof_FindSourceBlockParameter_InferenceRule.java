package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_FindSourceBlockParameter_InferenceRule implements InferenceRule_Runtime {

  public typeof_FindSourceBlockParameter_InferenceRule() {
  }

  public void applyRule(final SNode findSourceBlockParameter) {
    SNode dependency = SNodeOperations.getAncestor(findSourceBlockParameter, "jetbrains.mps.bootstrap.helgins.structure.Dependency", false, false);
    if ((dependency != null)) {
      {
        SNode _nodeToCheck_1029348928467 = findSourceBlockParameter;
        TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(_nodeToCheck_1029348928467, "jetbrains.mps.bootstrap.helgins.helgins", "1193734407573", true), new QuotationClass_17().createNode(SLinkOperations.getTarget(dependency, "targetConcept", false)), _nodeToCheck_1029348928467, null, "jetbrains.mps.bootstrap.helgins.helgins@5_0", "1215688284155");
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.helgins.structure.FindSourceBlockParameter";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
