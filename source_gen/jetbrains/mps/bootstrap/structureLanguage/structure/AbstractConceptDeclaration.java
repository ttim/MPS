package jetbrains.mps.bootstrap.structureLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;

public class AbstractConceptDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String LINK_DECLARATION = "linkDeclaration";
  public static String PROPERTY_DECLARATION = "propertyDeclaration";
  public static String CONCEPT_PROPERTY = "conceptProperty";
  public static String CONCEPT_LINK = "conceptLink";
  public static String CONCEPT_PROPERTY_DECLARATION = "conceptPropertyDeclaration";
  public static String CONCEPT_LINK_DECLARATION = "conceptLinkDeclaration";

  public  AbstractConceptDeclaration(SNode node) {
    super(node);
  }

  public static AbstractConceptDeclaration newInstance(SModel sm, boolean init) {
    return (AbstractConceptDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractConceptDeclaration newInstance(SModel sm) {
    return AbstractConceptDeclaration.newInstance(sm, false);
  }


  public String getName() {
    return this.getProperty(AbstractConceptDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(AbstractConceptDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(AbstractConceptDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AbstractConceptDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AbstractConceptDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AbstractConceptDeclaration.ALIAS, value);
  }

  public int getLinkDeclarationsCount() {
    return this.getChildCount(AbstractConceptDeclaration.LINK_DECLARATION);
  }

  public Iterator<LinkDeclaration> linkDeclarations() {
    return this.children(AbstractConceptDeclaration.LINK_DECLARATION);
  }

  public List<LinkDeclaration> getLinkDeclarations() {
    return this.getChildren(AbstractConceptDeclaration.LINK_DECLARATION);
  }

  public void addLinkDeclaration(LinkDeclaration node) {
    this.addChild(AbstractConceptDeclaration.LINK_DECLARATION, node);
  }

  public void insertLinkDeclaration(LinkDeclaration prev, LinkDeclaration node) {
    this.insertChild(prev, AbstractConceptDeclaration.LINK_DECLARATION, node);
  }

  public int getPropertyDeclarationsCount() {
    return this.getChildCount(AbstractConceptDeclaration.PROPERTY_DECLARATION);
  }

  public Iterator<PropertyDeclaration> propertyDeclarations() {
    return this.children(AbstractConceptDeclaration.PROPERTY_DECLARATION);
  }

  public List<PropertyDeclaration> getPropertyDeclarations() {
    return this.getChildren(AbstractConceptDeclaration.PROPERTY_DECLARATION);
  }

  public void addPropertyDeclaration(PropertyDeclaration node) {
    this.addChild(AbstractConceptDeclaration.PROPERTY_DECLARATION, node);
  }

  public void insertPropertyDeclaration(PropertyDeclaration prev, PropertyDeclaration node) {
    this.insertChild(prev, AbstractConceptDeclaration.PROPERTY_DECLARATION, node);
  }

  public int getConceptPropertysCount() {
    return this.getChildCount(AbstractConceptDeclaration.CONCEPT_PROPERTY);
  }

  public Iterator<ConceptProperty> conceptPropertys() {
    return this.children(AbstractConceptDeclaration.CONCEPT_PROPERTY);
  }

  public List<ConceptProperty> getConceptPropertys() {
    return this.getChildren(AbstractConceptDeclaration.CONCEPT_PROPERTY);
  }

  public void addConceptProperty(ConceptProperty node) {
    this.addChild(AbstractConceptDeclaration.CONCEPT_PROPERTY, node);
  }

  public void insertConceptProperty(ConceptProperty prev, ConceptProperty node) {
    this.insertChild(prev, AbstractConceptDeclaration.CONCEPT_PROPERTY, node);
  }

  public int getConceptLinksCount() {
    return this.getChildCount(AbstractConceptDeclaration.CONCEPT_LINK);
  }

  public Iterator<ConceptLink> conceptLinks() {
    return this.children(AbstractConceptDeclaration.CONCEPT_LINK);
  }

  public List<ConceptLink> getConceptLinks() {
    return this.getChildren(AbstractConceptDeclaration.CONCEPT_LINK);
  }

  public void addConceptLink(ConceptLink node) {
    this.addChild(AbstractConceptDeclaration.CONCEPT_LINK, node);
  }

  public void insertConceptLink(ConceptLink prev, ConceptLink node) {
    this.insertChild(prev, AbstractConceptDeclaration.CONCEPT_LINK, node);
  }

  public int getConceptPropertyDeclarationsCount() {
    return this.getChildCount(AbstractConceptDeclaration.CONCEPT_PROPERTY_DECLARATION);
  }

  public Iterator<ConceptPropertyDeclaration> conceptPropertyDeclarations() {
    return this.children(AbstractConceptDeclaration.CONCEPT_PROPERTY_DECLARATION);
  }

  public List<ConceptPropertyDeclaration> getConceptPropertyDeclarations() {
    return this.getChildren(AbstractConceptDeclaration.CONCEPT_PROPERTY_DECLARATION);
  }

  public void addConceptPropertyDeclaration(ConceptPropertyDeclaration node) {
    this.addChild(AbstractConceptDeclaration.CONCEPT_PROPERTY_DECLARATION, node);
  }

  public void insertConceptPropertyDeclaration(ConceptPropertyDeclaration prev, ConceptPropertyDeclaration node) {
    this.insertChild(prev, AbstractConceptDeclaration.CONCEPT_PROPERTY_DECLARATION, node);
  }

  public int getConceptLinkDeclarationsCount() {
    return this.getChildCount(AbstractConceptDeclaration.CONCEPT_LINK_DECLARATION);
  }

  public Iterator<ConceptLinkDeclaration> conceptLinkDeclarations() {
    return this.children(AbstractConceptDeclaration.CONCEPT_LINK_DECLARATION);
  }

  public List<ConceptLinkDeclaration> getConceptLinkDeclarations() {
    return this.getChildren(AbstractConceptDeclaration.CONCEPT_LINK_DECLARATION);
  }

  public void addConceptLinkDeclaration(ConceptLinkDeclaration node) {
    this.addChild(AbstractConceptDeclaration.CONCEPT_LINK_DECLARATION, node);
  }

  public void insertConceptLinkDeclaration(ConceptLinkDeclaration prev, ConceptLinkDeclaration node) {
    this.insertChild(prev, AbstractConceptDeclaration.CONCEPT_LINK_DECLARATION, node);
  }

}
