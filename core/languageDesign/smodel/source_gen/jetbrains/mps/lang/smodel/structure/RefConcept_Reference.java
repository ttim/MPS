package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RefConcept_Reference extends BaseConcept implements IRefConceptArg {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.RefConcept_Reference";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONCEPT_DECLARATION = "conceptDeclaration";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public RefConcept_Reference(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(RefConcept_Reference.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(RefConcept_Reference.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(RefConcept_Reference.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(RefConcept_Reference.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(RefConcept_Reference.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(RefConcept_Reference.VIRTUAL_PACKAGE, value);
  }

  public AbstractConceptDeclaration getConceptDeclaration() {
    return (AbstractConceptDeclaration) this.getReferent(AbstractConceptDeclaration.class, RefConcept_Reference.CONCEPT_DECLARATION);
  }

  public void setConceptDeclaration(AbstractConceptDeclaration node) {
    super.setReferent(RefConcept_Reference.CONCEPT_DECLARATION, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(RefConcept_Reference.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, RefConcept_Reference.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, RefConcept_Reference.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(RefConcept_Reference.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, RefConcept_Reference.SMODEL_ATTRIBUTE, node);
  }

  public static RefConcept_Reference newInstance(SModel sm, boolean init) {
    return (RefConcept_Reference) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.RefConcept_Reference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RefConcept_Reference newInstance(SModel sm) {
    return RefConcept_Reference.newInstance(sm, false);
  }
}
