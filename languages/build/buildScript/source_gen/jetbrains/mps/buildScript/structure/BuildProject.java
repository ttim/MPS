package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.ScopeProvider;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuildProject extends BaseConcept implements ScopeProvider, INamedConcept {
  public static final String concept = "jetbrains.mps.buildScript.structure.BuildProject";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String NAME = "name";
  public static final String LAYOUT = "layout";
  public static final String DEPENDENCIES = "dependencies";
  public static final String MACROS = "macros";
  public static final String PARTS = "parts";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BuildProject(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BuildProject.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuildProject.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuildProject.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuildProject.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuildProject.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuildProject.VIRTUAL_PACKAGE, value);
  }

  public String getName() {
    return this.getProperty(BuildProject.NAME);
  }

  public void setName(String value) {
    this.setProperty(BuildProject.NAME, value);
  }

  public BuildLayout getLayout() {
    return (BuildLayout) this.getChild(BuildLayout.class, BuildProject.LAYOUT);
  }

  public void setLayout(BuildLayout node) {
    super.setChild(BuildProject.LAYOUT, node);
  }

  public int getDependenciesesCount() {
    return this.getChildCount(BuildProject.DEPENDENCIES);
  }

  public Iterator<BuildDependency> dependencieses() {
    return this.children(BuildDependency.class, BuildProject.DEPENDENCIES);
  }

  public List<BuildDependency> getDependencieses() {
    return this.getChildren(BuildDependency.class, BuildProject.DEPENDENCIES);
  }

  public void addDependencies(BuildDependency node) {
    this.addChild(BuildProject.DEPENDENCIES, node);
  }

  public void insertDependencies(BuildDependency prev, BuildDependency node) {
    this.insertChild(prev, BuildProject.DEPENDENCIES, node);
  }

  public int getMacrosesCount() {
    return this.getChildCount(BuildProject.MACROS);
  }

  public Iterator<BuildMacro> macroses() {
    return this.children(BuildMacro.class, BuildProject.MACROS);
  }

  public List<BuildMacro> getMacroses() {
    return this.getChildren(BuildMacro.class, BuildProject.MACROS);
  }

  public void addMacros(BuildMacro node) {
    this.addChild(BuildProject.MACROS, node);
  }

  public void insertMacros(BuildMacro prev, BuildMacro node) {
    this.insertChild(prev, BuildProject.MACROS, node);
  }

  public int getPartsesCount() {
    return this.getChildCount(BuildProject.PARTS);
  }

  public Iterator<BuildProjectPart> partses() {
    return this.children(BuildProjectPart.class, BuildProject.PARTS);
  }

  public List<BuildProjectPart> getPartses() {
    return this.getChildren(BuildProjectPart.class, BuildProject.PARTS);
  }

  public void addParts(BuildProjectPart node) {
    this.addChild(BuildProject.PARTS, node);
  }

  public void insertParts(BuildProjectPart prev, BuildProjectPart node) {
    this.insertChild(prev, BuildProject.PARTS, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BuildProject.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BuildProject.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BuildProject.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BuildProject.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BuildProject.SMODEL_ATTRIBUTE, node);
  }

  public static BuildProject newInstance(SModel sm, boolean init) {
    return (BuildProject) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.BuildProject", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuildProject newInstance(SModel sm) {
    return BuildProject.newInstance(sm, false);
  }
}
