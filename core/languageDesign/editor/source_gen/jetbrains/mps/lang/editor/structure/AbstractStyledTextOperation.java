package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractStyledTextOperation extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.lang.editor.structure.AbstractStyledTextOperation";
  public static final String CPR_MethodToGenerate = "methodToGenerate";
  public static final String CLNK_OperandType = "operandType";
  public static final String CLNK_OperationReturnType = "operationReturnType";
  public static final String CLNK_OperationArgumentType = "operationArgumentType";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ACTUAL_ARGUMENT = "actualArgument";

  public AbstractStyledTextOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(AbstractStyledTextOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AbstractStyledTextOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AbstractStyledTextOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AbstractStyledTextOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AbstractStyledTextOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AbstractStyledTextOperation.VIRTUAL_PACKAGE, value);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(AbstractStyledTextOperation.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, AbstractStyledTextOperation.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, AbstractStyledTextOperation.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(AbstractStyledTextOperation.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, AbstractStyledTextOperation.ACTUAL_ARGUMENT, node);
  }

  public static AbstractStyledTextOperation newInstance(SModel sm, boolean init) {
    return (AbstractStyledTextOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.AbstractStyledTextOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractStyledTextOperation newInstance(SModel sm) {
    return AbstractStyledTextOperation.newInstance(sm, false);
  }
}
