package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildMacro extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildMacro";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BuildMacro(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(BuildMacro.NAME);
  }

  public void setName(String value) {
    this.setProperty(BuildMacro.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BuildMacro.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuildMacro.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuildMacro.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuildMacro.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuildMacro.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuildMacro.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BuildMacro.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BuildMacro.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BuildMacro.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BuildMacro.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BuildMacro.SMODEL_ATTRIBUTE, node);
  }

  public static BuildMacro newInstance(SModel sm, boolean init) {
    return (BuildMacro) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildMacro newInstance(SModel sm) {
    return BuildMacro.newInstance(sm, false);
  }
}
