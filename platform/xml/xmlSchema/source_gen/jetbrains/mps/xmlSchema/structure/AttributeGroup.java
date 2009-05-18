package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AttributeGroup extends Declaration {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.AttributeGroup";
  public static final String ATTRIBUTE_GROUP_NAME = "attributeGroupName";
  public static final String ATTRIBUTE_EXPRESSION = "attributeExpression";

  public AttributeGroup(SNode node) {
    super(node);
  }

  public String getAttributeGroupName() {
    return this.getProperty(AttributeGroup.ATTRIBUTE_GROUP_NAME);
  }

  public void setAttributeGroupName(String value) {
    this.setProperty(AttributeGroup.ATTRIBUTE_GROUP_NAME, value);
  }

  public int getAttributeExpressionsCount() {
    return this.getChildCount(AttributeGroup.ATTRIBUTE_EXPRESSION);
  }

  public Iterator<AttributeExpression> attributeExpressions() {
    return this.children(AttributeExpression.class, AttributeGroup.ATTRIBUTE_EXPRESSION);
  }

  public List<AttributeExpression> getAttributeExpressions() {
    return this.getChildren(AttributeExpression.class, AttributeGroup.ATTRIBUTE_EXPRESSION);
  }

  public void addAttributeExpression(AttributeExpression node) {
    this.addChild(AttributeGroup.ATTRIBUTE_EXPRESSION, node);
  }

  public void insertAttributeExpression(AttributeExpression prev, AttributeExpression node) {
    this.insertChild(prev, AttributeGroup.ATTRIBUTE_EXPRESSION, node);
  }


  public static AttributeGroup newInstance(SModel sm, boolean init) {
    return (AttributeGroup)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.AttributeGroup", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AttributeGroup newInstance(SModel sm) {
    return AttributeGroup.newInstance(sm, false);
  }

}
