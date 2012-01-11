package jetbrains.mps.baseLanguageInternal.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InternalClassCreator extends AbstractCreator {
  public static final String concept = "jetbrains.mps.baseLanguageInternal.structure.InternalClassCreator";
  public static final String FQ_CLASS_NAME = "fqClassName";
  public static final String TYPE = "type";
  public static final String PARAMETER = "parameter";
  public static final String ACTUAL_ARGUMENT = "actualArgument";

  public InternalClassCreator(SNode node) {
    super(node);
  }

  public String getFqClassName() {
    return this.getProperty(InternalClassCreator.FQ_CLASS_NAME);
  }

  public void setFqClassName(String value) {
    this.setProperty(InternalClassCreator.FQ_CLASS_NAME, value);
  }

  public Type getType() {
    return (Type) this.getChild(Type.class, InternalClassCreator.TYPE);
  }

  public void setType(Type node) {
    super.setChild(InternalClassCreator.TYPE, node);
  }

  public int getParametersCount() {
    return this.getChildCount(InternalClassCreator.PARAMETER);
  }

  public Iterator<Type> parameters() {
    return this.children(Type.class, InternalClassCreator.PARAMETER);
  }

  public List<Type> getParameters() {
    return this.getChildren(Type.class, InternalClassCreator.PARAMETER);
  }

  public void addParameter(Type node) {
    this.addChild(InternalClassCreator.PARAMETER, node);
  }

  public void insertParameter(Type prev, Type node) {
    this.insertChild(prev, InternalClassCreator.PARAMETER, node);
  }

  public int getActualArgumentsCount() {
    return this.getChildCount(InternalClassCreator.ACTUAL_ARGUMENT);
  }

  public Iterator<Expression> actualArguments() {
    return this.children(Expression.class, InternalClassCreator.ACTUAL_ARGUMENT);
  }

  public List<Expression> getActualArguments() {
    return this.getChildren(Expression.class, InternalClassCreator.ACTUAL_ARGUMENT);
  }

  public void addActualArgument(Expression node) {
    this.addChild(InternalClassCreator.ACTUAL_ARGUMENT, node);
  }

  public void insertActualArgument(Expression prev, Expression node) {
    this.insertChild(prev, InternalClassCreator.ACTUAL_ARGUMENT, node);
  }

  public static InternalClassCreator newInstance(SModel sm, boolean init) {
    return (InternalClassCreator) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguageInternal.structure.InternalClassCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InternalClassCreator newInstance(SModel sm) {
    return InternalClassCreator.newInstance(sm, false);
  }
}
