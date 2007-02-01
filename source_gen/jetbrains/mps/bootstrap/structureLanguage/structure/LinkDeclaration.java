package jetbrains.mps.bootstrap.structureLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.project.GlobalScope;

public class LinkDeclaration extends BaseConcept {
  public static String SPECIALIZED_LINK = "specializedLink";
  public static String TARGET = "target";
  public static String ROLE = "role";
  public static String META_CLASS = "metaClass";
  public static String SOURCE_CARDINALITY = "sourceCardinality";
  public static String TARGET_CARDINALITY = "targetCardinality";

  public  LinkDeclaration(SNode node) {
    super(node);
  }

  public static LinkDeclaration newInstance(SModel sm) {
    return (LinkDeclaration)SModelUtil.instantiateConceptDeclaration("jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration", sm, GlobalScope.getInstance()).getAdapter();
  }

  public LinkDeclaration getSpecializedLink() {
    return (LinkDeclaration)this.getReferent(LinkDeclaration.SPECIALIZED_LINK);
  }
  public void setSpecializedLink(LinkDeclaration node) {
    super.setReferent(LinkDeclaration.SPECIALIZED_LINK, node);
  }
  public ConceptDeclaration getTarget() {
    return (ConceptDeclaration)this.getReferent(LinkDeclaration.TARGET);
  }
  public void setTarget(ConceptDeclaration node) {
    super.setReferent(LinkDeclaration.TARGET, node);
  }
  public String getRole() {
    return this.getProperty(LinkDeclaration.ROLE);
  }
  public void setRole(String value) {
    this.setProperty(LinkDeclaration.ROLE, value);
  }
  public LinkMetaclass getMetaClass() {
    String value = super.getProperty(LinkDeclaration.META_CLASS);
    return LinkMetaclass.parseValue(value);
  }
  public void setMetaClass(LinkMetaclass value) {
    super.setProperty(LinkDeclaration.META_CLASS, value.getValueAsString());
  }
  public Cardinality getSourceCardinality() {
    String value = super.getProperty(LinkDeclaration.SOURCE_CARDINALITY);
    return Cardinality.parseValue(value);
  }
  public void setSourceCardinality(Cardinality value) {
    super.setProperty(LinkDeclaration.SOURCE_CARDINALITY, value.getValueAsString());
  }
  public Cardinality getTargetCardinality() {
    String value = super.getProperty(LinkDeclaration.TARGET_CARDINALITY);
    return Cardinality.parseValue(value);
  }
  public void setTargetCardinality(Cardinality value) {
    super.setProperty(LinkDeclaration.TARGET_CARDINALITY, value.getValueAsString());
  }
}
