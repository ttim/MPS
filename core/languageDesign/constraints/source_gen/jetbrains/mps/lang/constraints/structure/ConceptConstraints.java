package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.lang.structure.structure.IConceptAspect;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.ConceptDeclaration;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptConstraints extends BaseConcept implements INamedConcept, IConceptAspect {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.ConceptConstraints";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONCEPT = "concept";
  public static final String DEFAULT_CONCRETE_CONCEPT = "defaultConcreteConcept";
  public static final String DEFAULT_SCOPE = "defaultScope";
  public static final String CAN_BE_CHILD = "canBeChild";
  public static final String CAN_BE_ROOT = "canBeRoot";
  public static final String CAN_BE_PARENT = "canBeParent";
  public static final String CAN_BE_ANCESTOR = "canBeAncestor";
  public static final String ALTERNATIVE_ICON = "alternativeIcon";
  public static final String PROPERTY = "property";
  public static final String REFERENT = "referent";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ConceptConstraints(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ConceptConstraints.NAME);
  }

  public void setName(String value) {
    this.setProperty(ConceptConstraints.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ConceptConstraints.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConceptConstraints.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConceptConstraints.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConceptConstraints.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ConceptConstraints.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ConceptConstraints.VIRTUAL_PACKAGE, value);
  }

  public AbstractConceptDeclaration getConcept() {
    return (AbstractConceptDeclaration) this.getReferent(AbstractConceptDeclaration.class, ConceptConstraints.CONCEPT);
  }

  public void setConcept(AbstractConceptDeclaration node) {
    super.setReferent(ConceptConstraints.CONCEPT, node);
  }

  public ConceptDeclaration getDefaultConcreteConcept() {
    return (ConceptDeclaration) this.getReferent(ConceptDeclaration.class, ConceptConstraints.DEFAULT_CONCRETE_CONCEPT);
  }

  public void setDefaultConcreteConcept(ConceptDeclaration node) {
    super.setReferent(ConceptConstraints.DEFAULT_CONCRETE_CONCEPT, node);
  }

  public NodeDefaultSearchScope getDefaultScope() {
    return (NodeDefaultSearchScope) this.getChild(NodeDefaultSearchScope.class, ConceptConstraints.DEFAULT_SCOPE);
  }

  public void setDefaultScope(NodeDefaultSearchScope node) {
    super.setChild(ConceptConstraints.DEFAULT_SCOPE, node);
  }

  public ConstraintFunction_CanBeAChild getCanBeChild() {
    return (ConstraintFunction_CanBeAChild) this.getChild(ConstraintFunction_CanBeAChild.class, ConceptConstraints.CAN_BE_CHILD);
  }

  public void setCanBeChild(ConstraintFunction_CanBeAChild node) {
    super.setChild(ConceptConstraints.CAN_BE_CHILD, node);
  }

  public ConstraintFunction_CanBeARoot getCanBeRoot() {
    return (ConstraintFunction_CanBeARoot) this.getChild(ConstraintFunction_CanBeARoot.class, ConceptConstraints.CAN_BE_ROOT);
  }

  public void setCanBeRoot(ConstraintFunction_CanBeARoot node) {
    super.setChild(ConceptConstraints.CAN_BE_ROOT, node);
  }

  public ConstraintFunction_CanBeAParent getCanBeParent() {
    return (ConstraintFunction_CanBeAParent) this.getChild(ConstraintFunction_CanBeAParent.class, ConceptConstraints.CAN_BE_PARENT);
  }

  public void setCanBeParent(ConstraintFunction_CanBeAParent node) {
    super.setChild(ConceptConstraints.CAN_BE_PARENT, node);
  }

  public ConstraintFunction_CanBeAnAncestor getCanBeAncestor() {
    return (ConstraintFunction_CanBeAnAncestor) this.getChild(ConstraintFunction_CanBeAnAncestor.class, ConceptConstraints.CAN_BE_ANCESTOR);
  }

  public void setCanBeAncestor(ConstraintFunction_CanBeAnAncestor node) {
    super.setChild(ConceptConstraints.CAN_BE_ANCESTOR, node);
  }

  public ConstraintFunction_GetAlternativeIcon getAlternativeIcon() {
    return (ConstraintFunction_GetAlternativeIcon) this.getChild(ConstraintFunction_GetAlternativeIcon.class, ConceptConstraints.ALTERNATIVE_ICON);
  }

  public void setAlternativeIcon(ConstraintFunction_GetAlternativeIcon node) {
    super.setChild(ConceptConstraints.ALTERNATIVE_ICON, node);
  }

  public int getPropertiesCount() {
    return this.getChildCount(ConceptConstraints.PROPERTY);
  }

  public Iterator<NodePropertyConstraint> properties() {
    return this.children(NodePropertyConstraint.class, ConceptConstraints.PROPERTY);
  }

  public List<NodePropertyConstraint> getProperties() {
    return this.getChildren(NodePropertyConstraint.class, ConceptConstraints.PROPERTY);
  }

  public void addProperty(NodePropertyConstraint node) {
    this.addChild(ConceptConstraints.PROPERTY, node);
  }

  public void insertProperty(NodePropertyConstraint prev, NodePropertyConstraint node) {
    this.insertChild(prev, ConceptConstraints.PROPERTY, node);
  }

  public int getReferentsCount() {
    return this.getChildCount(ConceptConstraints.REFERENT);
  }

  public Iterator<NodeReferentConstraint> referents() {
    return this.children(NodeReferentConstraint.class, ConceptConstraints.REFERENT);
  }

  public List<NodeReferentConstraint> getReferents() {
    return this.getChildren(NodeReferentConstraint.class, ConceptConstraints.REFERENT);
  }

  public void addReferent(NodeReferentConstraint node) {
    this.addChild(ConceptConstraints.REFERENT, node);
  }

  public void insertReferent(NodeReferentConstraint prev, NodeReferentConstraint node) {
    this.insertChild(prev, ConceptConstraints.REFERENT, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ConceptConstraints.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ConceptConstraints.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ConceptConstraints.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ConceptConstraints.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ConceptConstraints.SMODEL_ATTRIBUTE, node);
  }

  public static ConceptConstraints newInstance(SModel sm, boolean init) {
    return (ConceptConstraints) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.ConceptConstraints", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptConstraints newInstance(SModel sm) {
    return ConceptConstraints.newInstance(sm, false);
  }
}
