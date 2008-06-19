package jetbrains.mps.patterns.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.structureLanguage.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_PatternVariableDeclaration_InferenceRule implements InferenceRule_Runtime {

  public typeof_PatternVariableDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck) {
    SNode attributedNode = SNodeOperations.getParent(nodeToCheck, null, false, false);
    SNode parent = SNodeOperations.getParent(attributedNode, null, false, false);
    if (parent == null) {
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.patterns.helgins", "1202488469553", true), new QuotationClass_3().createNode(), nodeToCheck, null, "jetbrains.mps.patterns.helgins", "1202488480088");
    } else
    {
      String role = attributedNode.getRole_();
      SNode linkDeclaration = AbstractConceptDeclaration_Behavior.call_findLinkDeclaration_1213877394467(SNodeOperations.getConceptDeclaration(parent), role);
      TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(nodeToCheck, "jetbrains.mps.patterns.helgins", "1202488496552", true), new QuotationClass_4().createNode(SLinkOperations.getTarget(linkDeclaration, "target", false)), nodeToCheck, null, "jetbrains.mps.patterns.helgins", "1202488496543");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.patterns.structure.PatternVariableDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
