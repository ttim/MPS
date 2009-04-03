package jetbrains.mps.baseLanguageInternal.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InternalThisExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguageInternal.structure.InternalThisExpression";

  public InternalThisExpression(SNode node) {
    super(node);
  }

  public static InternalThisExpression newInstance(SModel sm, boolean init) {
    return (InternalThisExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguageInternal.structure.InternalThisExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InternalThisExpression newInstance(SModel sm) {
    return InternalThisExpression.newInstance(sm, false);
  }

}
