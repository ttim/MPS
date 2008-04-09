package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.ConstructorDeclaration;

import java.util.Iterator;

import jetbrains.mps.baseLanguage.structure.Expression;

import java.util.List;

public class BeanCreator extends AbstractCreator {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.BeanCreator";
  public static String CONSTRUCTOR = "constructor";
  public static String PARAMETER = "parameter";

  public BeanCreator(SNode node) {
    super(node);
  }

  public static BeanCreator newInstance(SModel sm, boolean init) {
    return (BeanCreator) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.BeanCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BeanCreator newInstance(SModel sm) {
    return BeanCreator.newInstance(sm, false);
  }


  public ConstructorDeclaration getConstructor() {
    return (ConstructorDeclaration) this.getReferent(BeanCreator.CONSTRUCTOR);
  }

  public void setConstructor(ConstructorDeclaration node) {
    super.setReferent(BeanCreator.CONSTRUCTOR, node);
  }

  public int getParametersCount() {
    return this.getChildCount(BeanCreator.PARAMETER);
  }

  public Iterator<Expression> parameters() {
    return this.children(BeanCreator.PARAMETER);
  }

  public List<Expression> getParameters() {
    return this.getChildren(BeanCreator.PARAMETER);
  }

  public void addParameter(Expression node) {
    this.addChild(BeanCreator.PARAMETER, node);
  }

  public void insertParameter(Expression prev, Expression node) {
    this.insertChild(prev, BeanCreator.PARAMETER, node);
  }

}
