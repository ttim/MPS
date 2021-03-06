package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConstraintFunctionParameter_parentNode extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_parentNode";

  public ConstraintFunctionParameter_parentNode(SNode node) {
    super(node);
  }

  public static ConstraintFunctionParameter_parentNode newInstance(SModel sm, boolean init) {
    return (ConstraintFunctionParameter_parentNode) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_parentNode", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConstraintFunctionParameter_parentNode newInstance(SModel sm) {
    return ConstraintFunctionParameter_parentNode.newInstance(sm, false);
  }
}
