package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ClosureParameterReference extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ClosureParameterReference";
  public static final String CLOSURE_PARAMETER = "closureParameter";

  public ClosureParameterReference(SNode node) {
    super(node);
  }

  public ClosureParameter getClosureParameter() {
    return (ClosureParameter)this.getReferent(ClosureParameter.class, ClosureParameterReference.CLOSURE_PARAMETER);
  }

  public void setClosureParameter(ClosureParameter node) {
    super.setReferent(ClosureParameterReference.CLOSURE_PARAMETER, node);
  }

  public static ClosureParameterReference newInstance(SModel sm, boolean init) {
    return (ClosureParameterReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClosureParameterReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ClosureParameterReference newInstance(SModel sm) {
    return ClosureParameterReference.newInstance(sm, false);
  }
}
