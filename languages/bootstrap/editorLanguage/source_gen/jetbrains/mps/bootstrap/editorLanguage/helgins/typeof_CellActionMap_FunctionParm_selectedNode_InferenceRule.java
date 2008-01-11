package jetbrains.mps.bootstrap.editorLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_CellActionMap_FunctionParm_selectedNode_InferenceRule implements InferenceRule_Runtime {

  public  typeof_CellActionMap_FunctionParm_selectedNode_InferenceRule() {
  }

  public void applyRule(final SNode node) {
    SNode applicableConcept = SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapDeclaration", false, false), "applicableConcept", false);
    if(applicableConcept == null) {
      applicableConcept = SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.editorLanguage.structure.BaseEditorComponent", false, false), "conceptDeclaration", false);
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_1().createNode(applicableConcept), node, "jetbrains.mps.bootstrap.editorLanguage.helgins", "1179767185667");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_FunctionParm_selectedNode";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
