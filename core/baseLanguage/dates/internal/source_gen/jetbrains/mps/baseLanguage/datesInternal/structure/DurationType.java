package jetbrains.mps.baseLanguage.datesInternal.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.StaticMethodCall;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DurationType extends jetbrains.mps.lang.core.structure.BaseConcept implements jetbrains.mps.lang.core.structure.INamedConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.datesInternal.structure.DurationType";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String JODA_DURATION_FIELD_TYPE = "jodaDurationFieldType";

  public DurationType(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(DurationType.NAME);
  }

  public void setName(String value) {
    this.setProperty(DurationType.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(DurationType.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(DurationType.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(DurationType.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(DurationType.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(DurationType.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(DurationType.VIRTUAL_PACKAGE, value);
  }

  public jetbrains.mps.baseLanguage.structure.StaticMethodCall getJodaDurationFieldType() {
    return (jetbrains.mps.baseLanguage.structure.StaticMethodCall)this.getChild(StaticMethodCall.class, DurationType.JODA_DURATION_FIELD_TYPE);
  }

  public void setJodaDurationFieldType(jetbrains.mps.baseLanguage.structure.StaticMethodCall node) {
    super.setChild(DurationType.JODA_DURATION_FIELD_TYPE, node);
  }


  public static DurationType newInstance(SModel sm, boolean init) {
    return (DurationType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.datesInternal.structure.DurationType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DurationType newInstance(SModel sm) {
    return DurationType.newInstance(sm, false);
  }

}
