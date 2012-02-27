package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildLayout_NamedContainer extends BuildLayout_AbstractContainer implements INamedConcept {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer";
  public static final String CPR_HasInputDir = "hasInputDir";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONTAINER_NAME = "containerName";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BuildLayout_NamedContainer(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(BuildLayout_NamedContainer.NAME);
  }

  public void setName(String value) {
    this.setProperty(BuildLayout_NamedContainer.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BuildLayout_NamedContainer.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuildLayout_NamedContainer.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuildLayout_NamedContainer.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuildLayout_NamedContainer.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuildLayout_NamedContainer.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuildLayout_NamedContainer.VIRTUAL_PACKAGE, value);
  }

  public BuildString getContainerName() {
    return (BuildString) this.getChild(BuildString.class, BuildLayout_NamedContainer.CONTAINER_NAME);
  }

  public void setContainerName(BuildString node) {
    super.setChild(BuildLayout_NamedContainer.CONTAINER_NAME, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BuildLayout_NamedContainer.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BuildLayout_NamedContainer.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BuildLayout_NamedContainer.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BuildLayout_NamedContainer.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BuildLayout_NamedContainer.SMODEL_ATTRIBUTE, node);
  }

  public static BuildLayout_NamedContainer newInstance(SModel sm, boolean init) {
    return (BuildLayout_NamedContainer) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildLayout_NamedContainer newInstance(SModel sm) {
    return BuildLayout_NamedContainer.newInstance(sm, false);
  }
}
