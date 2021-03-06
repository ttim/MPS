package jetbrains.mps.build.dependency.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ProjectDescription extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.build.dependency.structure.ProjectDescription";
  public static final String BASEDIR = "basedir";
  public static final String PROPERTIES_FILE = "propertiesFile";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CYCLE = "cycle";
  public static final String COMMON_CLASSPATH = "commonClasspath";
  public static final String MACRO = "macro";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ProjectDescription(SNode node) {
    super(node);
  }

  public String getBasedir() {
    return this.getProperty(ProjectDescription.BASEDIR);
  }

  public void setBasedir(String value) {
    this.setProperty(ProjectDescription.BASEDIR, value);
  }

  public String getPropertiesFile() {
    return this.getProperty(ProjectDescription.PROPERTIES_FILE);
  }

  public void setPropertiesFile(String value) {
    this.setProperty(ProjectDescription.PROPERTIES_FILE, value);
  }

  public String getName() {
    return this.getProperty(ProjectDescription.NAME);
  }

  public void setName(String value) {
    this.setProperty(ProjectDescription.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ProjectDescription.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ProjectDescription.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ProjectDescription.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ProjectDescription.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ProjectDescription.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ProjectDescription.VIRTUAL_PACKAGE, value);
  }

  public int getCyclesCount() {
    return this.getChildCount(ProjectDescription.CYCLE);
  }

  public Iterator<Cycle> cycles() {
    return this.children(Cycle.class, ProjectDescription.CYCLE);
  }

  public List<Cycle> getCycles() {
    return this.getChildren(Cycle.class, ProjectDescription.CYCLE);
  }

  public void addCycle(Cycle node) {
    this.addChild(ProjectDescription.CYCLE, node);
  }

  public void insertCycle(Cycle prev, Cycle node) {
    this.insertChild(prev, ProjectDescription.CYCLE, node);
  }

  public int getCommonClasspathsCount() {
    return this.getChildCount(ProjectDescription.COMMON_CLASSPATH);
  }

  public Iterator<PathHolder> commonClasspaths() {
    return this.children(PathHolder.class, ProjectDescription.COMMON_CLASSPATH);
  }

  public List<PathHolder> getCommonClasspaths() {
    return this.getChildren(PathHolder.class, ProjectDescription.COMMON_CLASSPATH);
  }

  public void addCommonClasspath(PathHolder node) {
    this.addChild(ProjectDescription.COMMON_CLASSPATH, node);
  }

  public void insertCommonClasspath(PathHolder prev, PathHolder node) {
    this.insertChild(prev, ProjectDescription.COMMON_CLASSPATH, node);
  }

  public int getMacrosCount() {
    return this.getChildCount(ProjectDescription.MACRO);
  }

  public Iterator<Macros> macros() {
    return this.children(Macros.class, ProjectDescription.MACRO);
  }

  public List<Macros> getMacros() {
    return this.getChildren(Macros.class, ProjectDescription.MACRO);
  }

  public void addMacro(Macros node) {
    this.addChild(ProjectDescription.MACRO, node);
  }

  public void insertMacro(Macros prev, Macros node) {
    this.insertChild(prev, ProjectDescription.MACRO, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ProjectDescription.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ProjectDescription.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ProjectDescription.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ProjectDescription.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ProjectDescription.SMODEL_ATTRIBUTE, node);
  }

  public static ProjectDescription newInstance(SModel sm, boolean init) {
    return (ProjectDescription) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.dependency.structure.ProjectDescription", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ProjectDescription newInstance(SModel sm) {
    return ProjectDescription.newInstance(sm, false);
  }
}
