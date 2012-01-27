package jetbrains.mps.lang.extension.structure;

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

public class ExtensionFieldDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.lang.extension.structure.ExtensionFieldDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String FIELD_TYPE = "fieldType";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ExtensionFieldDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ExtensionFieldDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(ExtensionFieldDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ExtensionFieldDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ExtensionFieldDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ExtensionFieldDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ExtensionFieldDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ExtensionFieldDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ExtensionFieldDeclaration.VIRTUAL_PACKAGE, value);
  }

  public Type getFieldType() {
    return (Type) this.getChild(Type.class, ExtensionFieldDeclaration.FIELD_TYPE);
  }

  public void setFieldType(Type node) {
    super.setChild(ExtensionFieldDeclaration.FIELD_TYPE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ExtensionFieldDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ExtensionFieldDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ExtensionFieldDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ExtensionFieldDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ExtensionFieldDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static ExtensionFieldDeclaration newInstance(SModel sm, boolean init) {
    return (ExtensionFieldDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.extension.structure.ExtensionFieldDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExtensionFieldDeclaration newInstance(SModel sm) {
    return ExtensionFieldDeclaration.newInstance(sm, false);
  }
}
