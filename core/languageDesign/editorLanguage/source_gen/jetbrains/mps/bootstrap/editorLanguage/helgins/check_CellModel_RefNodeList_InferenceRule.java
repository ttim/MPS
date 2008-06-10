package jetbrains.mps.bootstrap.editorLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_CellModel_RefNodeList_InferenceRule implements InferenceRule_Runtime {

  public check_CellModel_RefNodeList_InferenceRule() {
  }

  public void applyRule(final SNode refNodeList) {
    SNode lnk = SLinkOperations.getTarget(refNodeList, "relationDeclaration", false);
    if (!(SPropertyOperations.hasValue(lnk, "metaClass", "aggregation", "reference"))) {
      TypeChecker.getInstance().reportTypeError(refNodeList, "aggregation link expected", "jetbrains.mps.bootstrap.editorLanguage.helgins", "1180295464579");
    }
    if (!(SPropertyOperations.hasValue(lnk, "sourceCardinality", "0..n", "0..1") || SPropertyOperations.hasValue(lnk, "sourceCardinality", "1..n", "0..1"))) {
      TypeChecker.getInstance().reportTypeError(refNodeList, "multiple cardinality expected", "jetbrains.mps.bootstrap.editorLanguage.helgins", "1180295464588");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
