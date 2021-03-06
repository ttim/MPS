package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ParameterWrapper extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.ypath.structure.ParameterWrapper";
  public static final String PARAM_VALUE = "paramValue";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String PARAM_REF = "paramRef";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ParameterWrapper(SNode node) {
    super(node);
  }

  public String getParamValue() {
    return this.getProperty(ParameterWrapper.PARAM_VALUE);
  }

  public void setParamValue(String value) {
    this.setProperty(ParameterWrapper.PARAM_VALUE, value);
  }

  public String getName() {
    return this.getProperty(ParameterWrapper.NAME);
  }

  public void setName(String value) {
    this.setProperty(ParameterWrapper.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ParameterWrapper.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ParameterWrapper.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ParameterWrapper.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ParameterWrapper.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ParameterWrapper.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ParameterWrapper.VIRTUAL_PACKAGE, value);
  }

  public BaseConcept getParamRef() {
    return (BaseConcept) this.getReferent(BaseConcept.class, ParameterWrapper.PARAM_REF);
  }

  public void setParamRef(BaseConcept node) {
    super.setReferent(ParameterWrapper.PARAM_REF, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ParameterWrapper.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ParameterWrapper.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ParameterWrapper.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ParameterWrapper.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ParameterWrapper.SMODEL_ATTRIBUTE, node);
  }

  public static ParameterWrapper newInstance(SModel sm, boolean init) {
    return (ParameterWrapper) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.ParameterWrapper", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ParameterWrapper newInstance(SModel sm) {
    return ParameterWrapper.newInstance(sm, false);
  }
}
