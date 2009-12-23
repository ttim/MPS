package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConstraintFunctionParameter_visible extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_visible";

  public ConstraintFunctionParameter_visible(SNode node) {
    super(node);
  }

  public static ConstraintFunctionParameter_visible newInstance(SModel sm, boolean init) {
    return (ConstraintFunctionParameter_visible) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.ConstraintFunctionParameter_visible", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConstraintFunctionParameter_visible newInstance(SModel sm) {
    return ConstraintFunctionParameter_visible.newInstance(sm, false);
  }
}
