package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;

public class SuperConstructorInvocation extends Statement {
  public static String CONSTRUCTOR_DECLARATION = "constructorDeclaration";
  public static String ACTUAL_ARGUMENT = "actualArgument";

  public  SuperConstructorInvocation(SNode node) {
    super(node);
  }

  public static SuperConstructorInvocation newInstance(SModel sm, boolean init) {
    return (SuperConstructorInvocation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.SuperConstructorInvocation", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static SuperConstructorInvocation newInstance(SModel sm) {
    return SuperConstructorInvocation.newInstance(sm, false);
  }

  public ConstructorDeclaration getConstructorDeclaration() {
    return (ConstructorDeclaration)this.getReferent(SuperConstructorInvocation.CONSTRUCTOR_DECLARATION);
  }
  public void setConstructorDeclaration(ConstructorDeclaration node) {
    super.setReferent(SuperConstructorInvocation.CONSTRUCTOR_DECLARATION, node);
  }
  public int getActualArgumentsCount() {
    return this.getChildCount(SuperConstructorInvocation.ACTUAL_ARGUMENT);
  }
  public Iterator<Expression> actualArguments() {
    return this.children(SuperConstructorInvocation.ACTUAL_ARGUMENT);
  }
  public List<Expression> getActualArguments() {
    return this.getChildren(SuperConstructorInvocation.ACTUAL_ARGUMENT);
  }
  public void addActualArgument(Expression node) {
    this.addChild(SuperConstructorInvocation.ACTUAL_ARGUMENT, node);
  }
  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, SuperConstructorInvocation.ACTUAL_ARGUMENT, node);
  }
}
