package jetbrains.mps.baseLanguage.ext.collections.lang.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForEachVariableReference extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference";
  public static String VARIABLE = "variable";

  public ForEachVariableReference(SNode node) {
    super(node);
  }

  public ForEachVariable getVariable() {
    return (ForEachVariable)this.getReferent(ForEachVariableReference.VARIABLE);
  }

  public void setVariable(ForEachVariable node) {
    super.setReferent(ForEachVariableReference.VARIABLE, node);
  }


  public static ForEachVariableReference newInstance(SModel sm, boolean init) {
    return (ForEachVariableReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForEachVariableReference newInstance(SModel sm) {
    return ForEachVariableReference.newInstance(sm, false);
  }

}
