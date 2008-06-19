package jetbrains.mps.ypath.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.ypath.behavior.TreePath_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_TreeNodeKindReference_InferenceRule implements InferenceRule_Runtime {

  public typeof_TreeNodeKindReference_InferenceRule() {
  }

  public void applyRule(final SNode treeNodeKindReference) {
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(treeNodeKindReference, "jetbrains.mps.ypath.helgins", "1179740518224", true), new QuotationClass_6().createNode(TreePath_Behavior.call_getNodeType_1213877481303(SLinkOperations.getTarget(treeNodeKindReference, "treePathAspect", false))), treeNodeKindReference, null, "jetbrains.mps.ypath.helgins", "1179740556071");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.ypath.structure.TreeNodeKindReference";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
