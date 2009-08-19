package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TypeExpressionList extends BaseConcept {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.TypeExpressionList";
  public static final String IS_VERTICAL = "isVertical";
  public static final String TYPE_EXPRESSION = "typeExpression";

  public TypeExpressionList(SNode node) {
    super(node);
  }

  public boolean getIsVertical() {
    return this.getBooleanProperty(TypeExpressionList.IS_VERTICAL);
  }

  public void setIsVertical(boolean value) {
    this.setBooleanProperty(TypeExpressionList.IS_VERTICAL, value);
  }

  public int getTypeExpressionsCount() {
    return this.getChildCount(TypeExpressionList.TYPE_EXPRESSION);
  }

  public Iterator<TypeExpression> typeExpressions() {
    return this.children(TypeExpression.class, TypeExpressionList.TYPE_EXPRESSION);
  }

  public List<TypeExpression> getTypeExpressions() {
    return this.getChildren(TypeExpression.class, TypeExpressionList.TYPE_EXPRESSION);
  }

  public void addTypeExpression(TypeExpression node) {
    this.addChild(TypeExpressionList.TYPE_EXPRESSION, node);
  }

  public void insertTypeExpression(TypeExpression prev, TypeExpression node) {
    this.insertChild(prev, TypeExpressionList.TYPE_EXPRESSION, node);
  }

  public static TypeExpressionList newInstance(SModel sm, boolean init) {
    return (TypeExpressionList)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.TypeExpressionList", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TypeExpressionList newInstance(SModel sm) {
    return TypeExpressionList.newInstance(sm, false);
  }
}
