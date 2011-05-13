package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.textGen.structure.ScopeConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForStatement extends AbstractForStatement implements ScopeConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ForStatement";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONDITION = "condition";
  public static final String ITERATION = "iteration";
  public static final String ADDITIONAL_VAR = "additionalVar";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ForStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ForStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ForStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ForStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ForStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ForStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ForStatement.VIRTUAL_PACKAGE, value);
  }

  public Expression getCondition() {
    return (Expression) this.getChild(Expression.class, ForStatement.CONDITION);
  }

  public void setCondition(Expression node) {
    super.setChild(ForStatement.CONDITION, node);
  }

  public int getIterationsCount() {
    return this.getChildCount(ForStatement.ITERATION);
  }

  public Iterator<Expression> iterations() {
    return this.children(Expression.class, ForStatement.ITERATION);
  }

  public List<Expression> getIterations() {
    return this.getChildren(Expression.class, ForStatement.ITERATION);
  }

  public void addIteration(Expression node) {
    this.addChild(ForStatement.ITERATION, node);
  }

  public void insertIteration(Expression prev, Expression node) {
    this.insertChild(prev, ForStatement.ITERATION, node);
  }

  public int getAdditionalVarsCount() {
    return this.getChildCount(ForStatement.ADDITIONAL_VAR);
  }

  public Iterator<AdditionalForLoopVariable> additionalVars() {
    return this.children(AdditionalForLoopVariable.class, ForStatement.ADDITIONAL_VAR);
  }

  public List<AdditionalForLoopVariable> getAdditionalVars() {
    return this.getChildren(AdditionalForLoopVariable.class, ForStatement.ADDITIONAL_VAR);
  }

  public void addAdditionalVar(AdditionalForLoopVariable node) {
    this.addChild(ForStatement.ADDITIONAL_VAR, node);
  }

  public void insertAdditionalVar(AdditionalForLoopVariable prev, AdditionalForLoopVariable node) {
    this.insertChild(prev, ForStatement.ADDITIONAL_VAR, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ForStatement.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ForStatement.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ForStatement.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ForStatement.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ForStatement.SMODEL_ATTRIBUTE, node);
  }

  public static ForStatement newInstance(SModel sm, boolean init) {
    return (ForStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ForStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForStatement newInstance(SModel sm) {
    return ForStatement.newInstance(sm, false);
  }
}
