package jetbrains.mps.xmlInternal.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.xml.structure.XmlRoot;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.xmlSchema.structure.Schema;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class XmlFile extends BaseConcept implements INamedConcept, XmlRoot {
  public static final String concept = "jetbrains.mps.xmlInternal.structure.XmlFile";
  public static final String FILE_NAME = "fileName";
  public static final String EXTENSION = "extension";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SCHEMA = "schema";
  public static final String DOCUMENT = "document";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public XmlFile(SNode node) {
    super(node);
  }

  public String getFileName() {
    return this.getProperty(XmlFile.FILE_NAME);
  }

  public void setFileName(String value) {
    this.setProperty(XmlFile.FILE_NAME, value);
  }

  public String getExtension() {
    return this.getProperty(XmlFile.EXTENSION);
  }

  public void setExtension(String value) {
    this.setProperty(XmlFile.EXTENSION, value);
  }

  public String getName() {
    return this.getProperty(XmlFile.NAME);
  }

  public void setName(String value) {
    this.setProperty(XmlFile.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(XmlFile.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(XmlFile.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(XmlFile.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(XmlFile.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(XmlFile.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(XmlFile.VIRTUAL_PACKAGE, value);
  }

  public Schema getSchema() {
    return (Schema) this.getReferent(Schema.class, XmlFile.SCHEMA);
  }

  public void setSchema(Schema node) {
    super.setReferent(XmlFile.SCHEMA, node);
  }

  public Document getDocument() {
    return (Document) this.getChild(Document.class, XmlFile.DOCUMENT);
  }

  public void setDocument(Document node) {
    super.setChild(XmlFile.DOCUMENT, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(XmlFile.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, XmlFile.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, XmlFile.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(XmlFile.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, XmlFile.SMODEL_ATTRIBUTE, node);
  }

  public static XmlFile newInstance(SModel sm, boolean init) {
    return (XmlFile) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlInternal.structure.XmlFile", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static XmlFile newInstance(SModel sm) {
    return XmlFile.newInstance(sm, false);
  }
}
