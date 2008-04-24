package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SplitExpression extends Expression implements RegexpUsingConstruction {
  public static final String concept = "jetbrains.mps.regexp.structure.SplitExpression";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String EXPR = "expr";
  public static String REGEXP = "regexp";

  public SplitExpression(SNode node) {
    super(node);
  }

  public static SplitExpression newInstance(SModel sm, boolean init) {
    return (SplitExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.structure.SplitExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SplitExpression newInstance(SModel sm) {
    return SplitExpression.newInstance(sm, false);
  }


  public String getShortDescription() {
    return this.getProperty(SplitExpression.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(SplitExpression.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(SplitExpression.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(SplitExpression.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(SplitExpression.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(SplitExpression.VIRTUAL_PACKAGE, value);
  }

  public Expression getExpr() {
    return (Expression)this.getChild(SplitExpression.EXPR);
  }

  public void setExpr(Expression node) {
    super.setChild(SplitExpression.EXPR, node);
  }

  public RegexpExpression getRegexp() {
    return (RegexpExpression)this.getChild(SplitExpression.REGEXP);
  }

  public void setRegexp(RegexpExpression node) {
    super.setChild(SplitExpression.REGEXP, node);
  }

}
