package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.baseLanguage.structure.ClassConcept;

public class ComponentDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.ComponentDeclaration";
  public static String ROOT = "root";
  public static String EXTENDED_COMPONENT = "extendedComponent";
  public static String MAPPED_TO = "mappedTo";
  public static String MAP_TO = "mapTo";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String STUB = "stub";
  public static String ABSTRACT = "abstract";
  public static String ACTION_COMPONENT = "actionComponent";

  public  ComponentDeclaration(SNode node) {
    super(node);
  }

  public static ComponentDeclaration newInstance(SModel sm, boolean init) {
    return (ComponentDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.ComponentDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ComponentDeclaration newInstance(SModel sm) {
    return ComponentDeclaration.newInstance(sm, false);
  }


  public ComponentInstance getRoot() {
    return (ComponentInstance)this.getChild(ComponentDeclaration.ROOT);
  }

  public void setRoot(ComponentInstance node) {
    super.setChild(ComponentDeclaration.ROOT, node);
  }

  public ComponentDeclaration getExtendedComponent() {
    return (ComponentDeclaration)this.getReferent(ComponentDeclaration.EXTENDED_COMPONENT);
  }

  public void setExtendedComponent(ComponentDeclaration node) {
    super.setReferent(ComponentDeclaration.EXTENDED_COMPONENT, node);
  }

  public ClassConcept getMappedTo() {
    return (ClassConcept)this.getReferent(ComponentDeclaration.MAPPED_TO);
  }

  public void setMappedTo(ClassConcept node) {
    super.setReferent(ComponentDeclaration.MAPPED_TO, node);
  }

  public ClassConcept getMapTo() {
    return (ClassConcept)this.getReferent(ComponentDeclaration.MAP_TO);
  }

  public void setMapTo(ClassConcept node) {
    super.setReferent(ComponentDeclaration.MAP_TO, node);
  }

  public String getName() {
    return this.getProperty(ComponentDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(ComponentDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ComponentDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ComponentDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ComponentDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ComponentDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ComponentDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ComponentDeclaration.VIRTUAL_PACKAGE, value);
  }

  public boolean getStub() {
    return this.getBooleanProperty(ComponentDeclaration.STUB);
  }

  public void setStub(boolean value) {
    this.setBooleanProperty(ComponentDeclaration.STUB, value);
  }

  public boolean getAbstract() {
    return this.getBooleanProperty(ComponentDeclaration.ABSTRACT);
  }

  public void setAbstract(boolean value) {
    this.setBooleanProperty(ComponentDeclaration.ABSTRACT, value);
  }

  public boolean getActionComponent() {
    return this.getBooleanProperty(ComponentDeclaration.ACTION_COMPONENT);
  }

  public void setActionComponent(boolean value) {
    this.setBooleanProperty(ComponentDeclaration.ACTION_COMPONENT, value);
  }

}
