package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TreePathOperationExpression extends Expression implements ITreePathExpression {
  public static final String concept = "jetbrains.mps.ypath.structure.TreePathOperationExpression";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String EXPRESSION = "expression";
  public static String OPERATION = "operation";

  public TreePathOperationExpression(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(TreePathOperationExpression.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TreePathOperationExpression.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TreePathOperationExpression.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TreePathOperationExpression.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TreePathOperationExpression.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TreePathOperationExpression.VIRTUAL_PACKAGE, value);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(TreePathOperationExpression.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(TreePathOperationExpression.EXPRESSION, node);
  }

  public TreePathOperation getOperation() {
    return (TreePathOperation)this.getChild(TreePathOperationExpression.OPERATION);
  }

  public void setOperation(TreePathOperation node) {
    super.setChild(TreePathOperationExpression.OPERATION, node);
  }


  public static TreePathOperationExpression newInstance(SModel sm, boolean init) {
    return (TreePathOperationExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.TreePathOperationExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TreePathOperationExpression newInstance(SModel sm) {
    return TreePathOperationExpression.newInstance(sm, false);
  }

}
