package jetbrains.mps.bootstrap.constraintsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;

public class ConceptBehavior extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior";
  public static String CONSTRUCTOR = "constructor";
  public static String DEFAULT_SCOPE = "defaultScope";
  public static String PROPERTIES = "properties";
  public static String REFERENCES = "references";
  public static String METHOD = "method";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String CONCEPT = "concept";

  public  ConceptBehavior(SNode node) {
    super(node);
  }

  public static ConceptBehavior newInstance(SModel sm, boolean init) {
    return (ConceptBehavior)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptBehavior newInstance(SModel sm) {
    return ConceptBehavior.newInstance(sm, false);
  }


  public ConceptConstructorDeclaration getConstructor() {
    return (ConceptConstructorDeclaration)this.getChild(ConceptBehavior.CONSTRUCTOR);
  }

  public void setConstructor(ConceptConstructorDeclaration node) {
    super.setChild(ConceptBehavior.CONSTRUCTOR, node);
  }

  public NodeDefaultSearchScope getDefaultScope() {
    return (NodeDefaultSearchScope)this.getChild(ConceptBehavior.DEFAULT_SCOPE);
  }

  public void setDefaultScope(NodeDefaultSearchScope node) {
    super.setChild(ConceptBehavior.DEFAULT_SCOPE, node);
  }

  public int getPropertiesesCount() {
    return this.getChildCount(ConceptBehavior.PROPERTIES);
  }

  public Iterator<NodePropertyConstraint> propertieses() {
    return this.children(ConceptBehavior.PROPERTIES);
  }

  public List<NodePropertyConstraint> getPropertieses() {
    return this.getChildren(ConceptBehavior.PROPERTIES);
  }

  public void addProperties(NodePropertyConstraint node) {
    this.addChild(ConceptBehavior.PROPERTIES, node);
  }

  public void insertProperties(NodePropertyConstraint prev, NodePropertyConstraint node) {
    this.insertChild(prev, ConceptBehavior.PROPERTIES, node);
  }

  public int getReferencesesCount() {
    return this.getChildCount(ConceptBehavior.REFERENCES);
  }

  public Iterator<NodeReferentConstraint> referenceses() {
    return this.children(ConceptBehavior.REFERENCES);
  }

  public List<NodeReferentConstraint> getReferenceses() {
    return this.getChildren(ConceptBehavior.REFERENCES);
  }

  public void addReferences(NodeReferentConstraint node) {
    this.addChild(ConceptBehavior.REFERENCES, node);
  }

  public void insertReferences(NodeReferentConstraint prev, NodeReferentConstraint node) {
    this.insertChild(prev, ConceptBehavior.REFERENCES, node);
  }

  public int getMethodsCount() {
    return this.getChildCount(ConceptBehavior.METHOD);
  }

  public Iterator<ConceptMethodDeclaration> methods() {
    return this.children(ConceptBehavior.METHOD);
  }

  public List<ConceptMethodDeclaration> getMethods() {
    return this.getChildren(ConceptBehavior.METHOD);
  }

  public void addMethod(ConceptMethodDeclaration node) {
    this.addChild(ConceptBehavior.METHOD, node);
  }

  public void insertMethod(ConceptMethodDeclaration prev, ConceptMethodDeclaration node) {
    this.insertChild(prev, ConceptBehavior.METHOD, node);
  }

  public String getName() {
    return this.getProperty(ConceptBehavior.NAME);
  }

  public void setName(String value) {
    this.setProperty(ConceptBehavior.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ConceptBehavior.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConceptBehavior.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConceptBehavior.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConceptBehavior.ALIAS, value);
  }

  public AbstractConceptDeclaration getConcept() {
    return (AbstractConceptDeclaration)this.getReferent(ConceptBehavior.CONCEPT);
  }

  public void setConcept(AbstractConceptDeclaration node) {
    super.setReferent(ConceptBehavior.CONCEPT, node);
  }

}
