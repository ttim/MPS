package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PrimitiveClassExpression extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression";
  public static final String PRIMITIVE_TYPE = "primitiveType";

  public PrimitiveClassExpression(SNode node) {
    super(node);
  }

  public PrimitiveType getPrimitiveType() {
    return (PrimitiveType) this.getChild(PrimitiveType.class, PrimitiveClassExpression.PRIMITIVE_TYPE);
  }

  public void setPrimitiveType(PrimitiveType node) {
    super.setChild(PrimitiveClassExpression.PRIMITIVE_TYPE, node);
  }

  public static PrimitiveClassExpression newInstance(SModel sm, boolean init) {
    return (PrimitiveClassExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PrimitiveClassExpression newInstance(SModel sm) {
    return PrimitiveClassExpression.newInstance(sm, false);
  }
}
