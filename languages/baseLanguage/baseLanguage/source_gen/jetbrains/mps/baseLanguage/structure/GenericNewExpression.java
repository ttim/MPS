package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GenericNewExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.GenericNewExpression";
  public static final String CREATOR = "creator";

  public GenericNewExpression(SNode node) {
    super(node);
  }

  public AbstractCreator getCreator() {
    return (AbstractCreator) this.getChild(AbstractCreator.class, GenericNewExpression.CREATOR);
  }

  public void setCreator(AbstractCreator node) {
    super.setChild(GenericNewExpression.CREATOR, node);
  }

  public static GenericNewExpression newInstance(SModel sm, boolean init) {
    return (GenericNewExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.GenericNewExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GenericNewExpression newInstance(SModel sm) {
    return GenericNewExpression.newInstance(sm, false);
  }
}
