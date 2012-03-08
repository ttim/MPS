package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildProjectDependency extends BuildDependency implements BuildLayout_PathElement {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildProjectDependency";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SCRIPT = "script";
  public static final String ARTIFACTS = "artifacts";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BuildProjectDependency(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BuildProjectDependency.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuildProjectDependency.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuildProjectDependency.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuildProjectDependency.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuildProjectDependency.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuildProjectDependency.VIRTUAL_PACKAGE, value);
  }

  public BuildProject getScript() {
    return (BuildProject) this.getReferent(BuildProject.class, BuildProjectDependency.SCRIPT);
  }

  public void setScript(BuildProject node) {
    super.setReferent(BuildProjectDependency.SCRIPT, node);
  }

  public BuildSourcePath getArtifacts() {
    return (BuildSourcePath) this.getChild(BuildSourcePath.class, BuildProjectDependency.ARTIFACTS);
  }

  public void setArtifacts(BuildSourcePath node) {
    super.setChild(BuildProjectDependency.ARTIFACTS, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BuildProjectDependency.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BuildProjectDependency.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BuildProjectDependency.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BuildProjectDependency.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BuildProjectDependency.SMODEL_ATTRIBUTE, node);
  }

  public static BuildProjectDependency newInstance(SModel sm, boolean init) {
    return (BuildProjectDependency) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildProjectDependency", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildProjectDependency newInstance(SModel sm) {
    return BuildProjectDependency.newInstance(sm, false);
  }
}
