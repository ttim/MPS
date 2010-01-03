package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConstructorInvocationStatement extends Statement implements IMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ConstructorInvocationStatement";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BASE_METHOD_DECLARATION = "baseMethodDeclaration";
  public static final String ACTUAL_ARGUMENT = "actualArgument";
  public static final String TYPE_ARGUMENT = "typeArgument";

  public ConstructorInvocationStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ConstructorInvocationStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConstructorInvocationStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConstructorInvocationStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConstructorInvocationStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ConstructorInvocationStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ConstructorInvocationStatement.VIRTUAL_PACKAGE, value);
  }

  public BaseMethodDeclaration getBaseMethodDeclaration() {
    return (BaseMethodDeclaration) this.getReferent(BaseMethodDeclaration.class, ConstructorInvocationStatement.BASE_METHOD_DECLARATION);
  }

  public void setBaseMethodDeclaration(BaseMethodDeclaration node) {
    super.setReferent(ConstructorInvocationStatement.BASE_METHOD_DECLARATION, node);
  }

  public ConstructorDeclaration getConstructorDeclaration() {
    return this.ensureAdapter(ConstructorDeclaration.class, "baseMethodDeclaration", this.getBaseMethodDeclaration());
  }

  public void setConstructorDeclaration(ConstructorDeclaration node) {
    this.setBaseMethodDeclaration(node);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(ConstructorInvocationStatement.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, ConstructorInvocationStatement.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, ConstructorInvocationStatement.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(ConstructorInvocationStatement.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, ConstructorInvocationStatement.ACTUAL_ARGUMENT, node);
  }

  public int getTypeArgumentsCount() {
    return this.getChildCount(ConstructorInvocationStatement.TYPE_ARGUMENT);
  }

  public Iterator<Type> typeArguments() {
    return this.children(Type.class, ConstructorInvocationStatement.TYPE_ARGUMENT);
  }

  public List<Type> getTypeArguments() {
    return this.getChildren(Type.class, ConstructorInvocationStatement.TYPE_ARGUMENT);
  }

  public void addTypeArgument(Type node) {
    this.addChild(ConstructorInvocationStatement.TYPE_ARGUMENT, node);
  }

  public void insertTypeArgument(Type prev, Type node) {
    this.insertChild(prev, ConstructorInvocationStatement.TYPE_ARGUMENT, node);
  }

  public static ConstructorInvocationStatement newInstance(SModel sm, boolean init) {
    return (ConstructorInvocationStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ConstructorInvocationStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConstructorInvocationStatement newInstance(SModel sm) {
    return ConstructorInvocationStatement.newInstance(sm, false);
  }
}
