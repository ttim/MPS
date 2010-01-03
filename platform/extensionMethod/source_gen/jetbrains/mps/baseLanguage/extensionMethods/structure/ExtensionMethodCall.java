package jetbrains.mps.baseLanguage.extensionMethods.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.baseLanguage.structure.IMethodCall;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.List;
import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExtensionMethodCall extends BaseConcept implements IOperation, IMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.extensionMethods.structure.ExtensionMethodCall";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BASE_METHOD_DECLARATION = "baseMethodDeclaration";
  public static final String ACTUAL_ARGUMENT = "actualArgument";
  public static final String TYPE_ARGUMENT = "typeArgument";

  public ExtensionMethodCall(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ExtensionMethodCall.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExtensionMethodCall.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExtensionMethodCall.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExtensionMethodCall.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExtensionMethodCall.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExtensionMethodCall.VIRTUAL_PACKAGE, value);
  }

  public BaseMethodDeclaration getBaseMethodDeclaration() {
    return (BaseMethodDeclaration) this.getReferent(BaseMethodDeclaration.class, ExtensionMethodCall.BASE_METHOD_DECLARATION);
  }

  public void setBaseMethodDeclaration(BaseMethodDeclaration node) {
    super.setReferent(ExtensionMethodCall.BASE_METHOD_DECLARATION, node);
  }

  public ExtensionMethodDeclaration getExtension() {
    return this.ensureAdapter(ExtensionMethodDeclaration.class, "baseMethodDeclaration", this.getBaseMethodDeclaration());
  }

  public void setExtension(ExtensionMethodDeclaration node) {
    this.setBaseMethodDeclaration(node);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(ExtensionMethodCall.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, ExtensionMethodCall.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, ExtensionMethodCall.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(ExtensionMethodCall.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, ExtensionMethodCall.ACTUAL_ARGUMENT, node);
  }

  public int getTypeArgumentsCount() {
    return this.getChildCount(ExtensionMethodCall.TYPE_ARGUMENT);
  }

  public Iterator<Type> typeArguments() {
    return this.children(Type.class, ExtensionMethodCall.TYPE_ARGUMENT);
  }

  public List<Type> getTypeArguments() {
    return this.getChildren(Type.class, ExtensionMethodCall.TYPE_ARGUMENT);
  }

  public void addTypeArgument(Type node) {
    this.addChild(ExtensionMethodCall.TYPE_ARGUMENT, node);
  }

  public void insertTypeArgument(Type prev, Type node) {
    this.insertChild(prev, ExtensionMethodCall.TYPE_ARGUMENT, node);
  }

  public static ExtensionMethodCall newInstance(SModel sm, boolean init) {
    return (ExtensionMethodCall) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.extensionMethods.structure.ExtensionMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExtensionMethodCall newInstance(SModel sm) {
    return ExtensionMethodCall.newInstance(sm, false);
  }
}
