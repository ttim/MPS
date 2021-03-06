package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.traceable.structure.ScopeConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ForeachStatement extends AbstractForStatement implements ScopeConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ForeachStatement";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ITERABLE = "iterable";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ForeachStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ForeachStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ForeachStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ForeachStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ForeachStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ForeachStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ForeachStatement.VIRTUAL_PACKAGE, value);
  }

  public Expression getIterable() {
    return (Expression) this.getChild(Expression.class, ForeachStatement.ITERABLE);
  }

  public void setIterable(Expression node) {
    super.setChild(ForeachStatement.ITERABLE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ForeachStatement.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ForeachStatement.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ForeachStatement.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ForeachStatement.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ForeachStatement.SMODEL_ATTRIBUTE, node);
  }

  public static ForeachStatement newInstance(SModel sm, boolean init) {
    return (ForeachStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ForeachStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ForeachStatement newInstance(SModel sm) {
    return ForeachStatement.newInstance(sm, false);
  }
}
