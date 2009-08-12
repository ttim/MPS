package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractContainerCreator extends AbstractCreator {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator";
  public static final String CLNK_AvailableFor = "availableFor";
  public static final String ELEMENT_TYPE = "elementType";
  public static final String COPY_FROM = "copyFrom";
  public static final String INIT_VALUE = "initValue";

  public AbstractContainerCreator(SNode node) {
    super(node);
  }

  public Type getElementType() {
    return (Type)this.getChild(Type.class, AbstractContainerCreator.ELEMENT_TYPE);
  }

  public void setElementType(Type node) {
    super.setChild(AbstractContainerCreator.ELEMENT_TYPE, node);
  }

  public Expression getCopyFrom() {
    return (Expression)this.getChild(Expression.class, AbstractContainerCreator.COPY_FROM);
  }

  public void setCopyFrom(Expression node) {
    super.setChild(AbstractContainerCreator.COPY_FROM, node);
  }

  public int getInitValuesCount() {
    return this.getChildCount(AbstractContainerCreator.INIT_VALUE);
  }

  public Iterator<Expression> initValues() {
    return this.children(Expression.class, AbstractContainerCreator.INIT_VALUE);
  }

  public List<Expression> getInitValues() {
    return this.getChildren(Expression.class, AbstractContainerCreator.INIT_VALUE);
  }

  public void addInitValue(Expression node) {
    this.addChild(AbstractContainerCreator.INIT_VALUE, node);
  }

  public void insertInitValue(Expression prev, Expression node) {
    this.insertChild(prev, AbstractContainerCreator.INIT_VALUE, node);
  }


  public static AbstractContainerCreator newInstance(SModel sm, boolean init) {
    return (AbstractContainerCreator)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractContainerCreator newInstance(SModel sm) {
    return AbstractContainerCreator.newInstance(sm, false);
  }

}
