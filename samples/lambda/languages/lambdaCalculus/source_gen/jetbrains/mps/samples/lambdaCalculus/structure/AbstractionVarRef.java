package jetbrains.mps.samples.lambdaCalculus.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractionVarRef extends BaseConcept {
  public static final String concept = "jetbrains.mps.samples.lambdaCalculus.structure.AbstractionVarRef";
  public static final String VARIABLE = "variable";

  public AbstractionVarRef(SNode node) {
    super(node);
  }

  public AbstractionVariable getVariable() {
    return (AbstractionVariable) this.getReferent(AbstractionVariable.class, AbstractionVarRef.VARIABLE);
  }

  public void setVariable(AbstractionVariable node) {
    super.setReferent(AbstractionVarRef.VARIABLE, node);
  }

  public static AbstractionVarRef newInstance(SModel sm, boolean init) {
    return (AbstractionVarRef) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.lambdaCalculus.structure.AbstractionVarRef", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractionVarRef newInstance(SModel sm) {
    return AbstractionVarRef.newInstance(sm, false);
  }
}
