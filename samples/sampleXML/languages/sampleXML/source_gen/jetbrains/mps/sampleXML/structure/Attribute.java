package jetbrains.mps.sampleXML.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Attribute extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.sampleXML.structure.Attribute";
  public static final String VALUE = "value";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public Attribute(SNode node) {
    super(node);
  }

  public String getValue() {
    return this.getProperty(Attribute.VALUE);
  }

  public void setValue(String value) {
    this.setProperty(Attribute.VALUE, value);
  }

  public String getName() {
    return this.getProperty(Attribute.NAME);
  }

  public void setName(String value) {
    this.setProperty(Attribute.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Attribute.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Attribute.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Attribute.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Attribute.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Attribute.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Attribute.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(Attribute.SMODEL_ATTRIBUTE);
  }

  public Iterator<jetbrains.mps.lang.core.structure.Attribute> smodelAttributes() {
    return this.children(jetbrains.mps.lang.core.structure.Attribute.class, Attribute.SMODEL_ATTRIBUTE);
  }

  public List<jetbrains.mps.lang.core.structure.Attribute> getSmodelAttributes() {
    return this.getChildren(jetbrains.mps.lang.core.structure.Attribute.class, Attribute.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(jetbrains.mps.lang.core.structure.Attribute node) {
    this.addChild(Attribute.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(jetbrains.mps.lang.core.structure.Attribute prev, jetbrains.mps.lang.core.structure.Attribute node) {
    this.insertChild(prev, Attribute.SMODEL_ATTRIBUTE, node);
  }

  public static Attribute newInstance(SModel sm, boolean init) {
    return (Attribute) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.sampleXML.structure.Attribute", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Attribute newInstance(SModel sm) {
    return Attribute.newInstance(sm, false);
  }
}
