package jetbrains.mps.lang.textGen.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class UtilityMethodCall extends Expression {
  public static final String concept = "jetbrains.mps.lang.textGen.structure.UtilityMethodCall";
  public static final String FUNCTION = "function";
  public static final String PARAMETER = "parameter";

  public UtilityMethodCall(SNode node) {
    super(node);
  }

  public UtilityMethodDeclaration getFunction() {
    return (UtilityMethodDeclaration) this.getReferent(UtilityMethodDeclaration.class, UtilityMethodCall.FUNCTION);
  }

  public void setFunction(UtilityMethodDeclaration node) {
    super.setReferent(UtilityMethodCall.FUNCTION, node);
  }

  public int getParametersCount() {
    return this.getChildCount(UtilityMethodCall.PARAMETER);
  }

  public Iterator<Expression> parameters() {
    return this.children(Expression.class, UtilityMethodCall.PARAMETER);
  }

  public List<Expression> getParameters() {
    return this.getChildren(Expression.class, UtilityMethodCall.PARAMETER);
  }

  public void addParameter(Expression node) {
    this.addChild(UtilityMethodCall.PARAMETER, node);
  }

  public void insertParameter(Expression prev, Expression node) {
    this.insertChild(prev, UtilityMethodCall.PARAMETER, node);
  }

  public static UtilityMethodCall newInstance(SModel sm, boolean init) {
    return (UtilityMethodCall) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.textGen.structure.UtilityMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static UtilityMethodCall newInstance(SModel sm) {
    return UtilityMethodCall.newInstance(sm, false);
  }
}
