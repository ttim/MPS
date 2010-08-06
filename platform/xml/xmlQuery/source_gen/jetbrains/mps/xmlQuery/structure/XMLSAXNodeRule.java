package jetbrains.mps.xmlQuery.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class XMLSAXNodeRule extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.xmlQuery.structure.XMLSAXNodeRule";
  public static final String TAG_NAME = "tagName";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String IS_COMPACT = "isCompact";
  public static final String TYPE = "type";
  public static final String TEXT = "text";
  public static final String CREATOR = "creator";
  public static final String VALIDATOR = "validator";
  public static final String ATTRS = "attrs";
  public static final String CHILDREN = "children";

  public XMLSAXNodeRule(SNode node) {
    super(node);
  }

  public String getTagName() {
    return this.getProperty(XMLSAXNodeRule.TAG_NAME);
  }

  public void setTagName(String value) {
    this.setProperty(XMLSAXNodeRule.TAG_NAME, value);
  }

  public String getName() {
    return this.getProperty(XMLSAXNodeRule.NAME);
  }

  public void setName(String value) {
    this.setProperty(XMLSAXNodeRule.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(XMLSAXNodeRule.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(XMLSAXNodeRule.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(XMLSAXNodeRule.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(XMLSAXNodeRule.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(XMLSAXNodeRule.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(XMLSAXNodeRule.VIRTUAL_PACKAGE, value);
  }

  public boolean getIsCompact() {
    return this.getBooleanProperty(XMLSAXNodeRule.IS_COMPACT);
  }

  public void setIsCompact(boolean value) {
    this.setBooleanProperty(XMLSAXNodeRule.IS_COMPACT, value);
  }

  public Type getType() {
    return (Type) this.getChild(Type.class, XMLSAXNodeRule.TYPE);
  }

  public void setType(Type node) {
    super.setChild(XMLSAXNodeRule.TYPE, node);
  }

  public XMLSAXTextRule getText() {
    return (XMLSAXTextRule) this.getChild(XMLSAXTextRule.class, XMLSAXNodeRule.TEXT);
  }

  public void setText(XMLSAXTextRule node) {
    super.setChild(XMLSAXNodeRule.TEXT, node);
  }

  public XMLSAXNodeCreator getCreator() {
    return (XMLSAXNodeCreator) this.getChild(XMLSAXNodeCreator.class, XMLSAXNodeRule.CREATOR);
  }

  public void setCreator(XMLSAXNodeCreator node) {
    super.setChild(XMLSAXNodeRule.CREATOR, node);
  }

  public XMLSAXNodeValidator getValidator() {
    return (XMLSAXNodeValidator) this.getChild(XMLSAXNodeValidator.class, XMLSAXNodeRule.VALIDATOR);
  }

  public void setValidator(XMLSAXNodeValidator node) {
    super.setChild(XMLSAXNodeRule.VALIDATOR, node);
  }

  public int getAttrsesCount() {
    return this.getChildCount(XMLSAXNodeRule.ATTRS);
  }

  public Iterator<XMLSAXAttributeRule> attrses() {
    return this.children(XMLSAXAttributeRule.class, XMLSAXNodeRule.ATTRS);
  }

  public List<XMLSAXAttributeRule> getAttrses() {
    return this.getChildren(XMLSAXAttributeRule.class, XMLSAXNodeRule.ATTRS);
  }

  public void addAttrs(XMLSAXAttributeRule node) {
    this.addChild(XMLSAXNodeRule.ATTRS, node);
  }

  public void insertAttrs(XMLSAXAttributeRule prev, XMLSAXAttributeRule node) {
    this.insertChild(prev, XMLSAXNodeRule.ATTRS, node);
  }

  public int getChildrensCount() {
    return this.getChildCount(XMLSAXNodeRule.CHILDREN);
  }

  public Iterator<XMLSAXChildRule> childrens() {
    return this.children(XMLSAXChildRule.class, XMLSAXNodeRule.CHILDREN);
  }

  public List<XMLSAXChildRule> getChildrens() {
    return this.getChildren(XMLSAXChildRule.class, XMLSAXNodeRule.CHILDREN);
  }

  public void addChildren(XMLSAXChildRule node) {
    this.addChild(XMLSAXNodeRule.CHILDREN, node);
  }

  public void insertChildren(XMLSAXChildRule prev, XMLSAXChildRule node) {
    this.insertChild(prev, XMLSAXNodeRule.CHILDREN, node);
  }

  public static XMLSAXNodeRule newInstance(SModel sm, boolean init) {
    return (XMLSAXNodeRule) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlQuery.structure.XMLSAXNodeRule", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static XMLSAXNodeRule newInstance(SModel sm) {
    return XMLSAXNodeRule.newInstance(sm, false);
  }
}
