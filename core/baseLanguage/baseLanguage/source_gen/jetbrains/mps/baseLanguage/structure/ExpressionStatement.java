package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.IWrapper;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExpressionStatement extends Statement implements IWrapper {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ExpressionStatement";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String EXPRESSION = "expression";

  public ExpressionStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ExpressionStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExpressionStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExpressionStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExpressionStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExpressionStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExpressionStatement.VIRTUAL_PACKAGE, value);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(ExpressionStatement.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(ExpressionStatement.EXPRESSION, node);
  }


  public static ExpressionStatement newInstance(SModel sm, boolean init) {
    return (ExpressionStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ExpressionStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExpressionStatement newInstance(SModel sm) {
    return ExpressionStatement.newInstance(sm, false);
  }

}
