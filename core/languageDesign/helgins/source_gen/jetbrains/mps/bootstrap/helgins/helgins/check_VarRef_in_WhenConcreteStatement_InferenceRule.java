package jetbrains.mps.bootstrap.helgins.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_VarRef_in_WhenConcreteStatement_InferenceRule implements InferenceRule_Runtime {

  public  check_VarRef_in_WhenConcreteStatement_InferenceRule() {
  }

  public void applyRule(final SNode variableReference) {
    SNode ancestor = SNodeOperations.getAncestor(variableReference, "jetbrains.mps.bootstrap.helgins.structure.WhenConcreteStatement", false, false);
    if (ancestor != null) {
      SNode argument = SLinkOperations.getTarget(ancestor, "argument", true);
      SNode parent = variableReference;
      while(parent != null && parent != ancestor) {
        if (parent == argument) {
          return;
        } else
        {
          parent = SNodeOperations.getParent(parent, null, false, false);
        }
      }
      SNode variableDeclaration = SLinkOperations.getTarget(variableReference, "variableDeclaration", false);
      if (variableDeclaration != null && !(SequenceOperations.contains(SNodeOperations.getAncestors(variableDeclaration, "jetbrains.mps.bootstrap.helgins.structure.WhenConcreteStatement", false), ancestor))) {
        if (!(SPropertyOperations.getBoolean(variableDeclaration, "isFinal"))) {
          TypeChecker.getInstance().reportTypeError(variableReference, "variable is used inside WHEN CONCRETE block. should be declared final", "jetbrains.mps.bootstrap.helgins.helgins", "1185875417873");
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.VariableReference";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
