package jetbrains.mps.make.script.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueryParameterDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.make.script.structure.QueryParameterDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String PARAMETER_TYPE = "parameterType";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public QueryParameterDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(QueryParameterDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(QueryParameterDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(QueryParameterDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(QueryParameterDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(QueryParameterDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(QueryParameterDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(QueryParameterDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(QueryParameterDeclaration.VIRTUAL_PACKAGE, value);
  }

  public Type getParameterType() {
    return (Type) this.getChild(Type.class, QueryParameterDeclaration.PARAMETER_TYPE);
  }

  public void setParameterType(Type node) {
    super.setChild(QueryParameterDeclaration.PARAMETER_TYPE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(QueryParameterDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, QueryParameterDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, QueryParameterDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(QueryParameterDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, QueryParameterDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static QueryParameterDeclaration newInstance(SModel sm, boolean init) {
    return (QueryParameterDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.make.script.structure.QueryParameterDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static QueryParameterDeclaration newInstance(SModel sm) {
    return QueryParameterDeclaration.newInstance(sm, false);
  }
}
