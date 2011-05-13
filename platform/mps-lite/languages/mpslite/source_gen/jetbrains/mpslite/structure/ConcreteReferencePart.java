package jetbrains.mpslite.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConcreteReferencePart extends ReferencePart implements INamedConcept {
  public static final String concept = "jetbrains.mpslite.structure.ConcreteReferencePart";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONCEPT_REFERENCE = "conceptReference";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ConcreteReferencePart(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ConcreteReferencePart.NAME);
  }

  public void setName(String value) {
    this.setProperty(ConcreteReferencePart.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ConcreteReferencePart.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ConcreteReferencePart.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ConcreteReferencePart.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ConcreteReferencePart.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ConcreteReferencePart.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ConcreteReferencePart.VIRTUAL_PACKAGE, value);
  }

  public AbstractConceptReference getConceptReference() {
    return (AbstractConceptReference) this.getChild(AbstractConceptReference.class, ConcreteReferencePart.CONCEPT_REFERENCE);
  }

  public void setConceptReference(AbstractConceptReference node) {
    super.setChild(ConcreteReferencePart.CONCEPT_REFERENCE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ConcreteReferencePart.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ConcreteReferencePart.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ConcreteReferencePart.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ConcreteReferencePart.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ConcreteReferencePart.SMODEL_ATTRIBUTE, node);
  }

  public static ConcreteReferencePart newInstance(SModel sm, boolean init) {
    return (ConcreteReferencePart) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mpslite.structure.ConcreteReferencePart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConcreteReferencePart newInstance(SModel sm) {
    return ConcreteReferencePart.newInstance(sm, false);
  }
}
