package jetbrains.mps.build.workflow.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BwfJavaModule extends BwfProjectPart implements INamedConcept {
  public static final String concept = "jetbrains.mps.build.workflow.structure.BwfJavaModule";
  public static final String OUTPUT_FOLDER = "outputFolder";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CLASSPATH = "classpath";
  public static final String SOURCES = "sources";
  public static final String DEPENDENCIES = "dependencies";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BwfJavaModule(SNode node) {
    super(node);
  }

  public String getOutputFolder() {
    return this.getProperty(BwfJavaModule.OUTPUT_FOLDER);
  }

  public void setOutputFolder(String value) {
    this.setProperty(BwfJavaModule.OUTPUT_FOLDER, value);
  }

  public String getName() {
    return this.getProperty(BwfJavaModule.NAME);
  }

  public void setName(String value) {
    this.setProperty(BwfJavaModule.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(BwfJavaModule.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BwfJavaModule.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BwfJavaModule.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BwfJavaModule.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BwfJavaModule.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BwfJavaModule.VIRTUAL_PACKAGE, value);
  }

  public int getClasspathsCount() {
    return this.getChildCount(BwfJavaModule.CLASSPATH);
  }

  public Iterator<BwfPath> classpaths() {
    return this.children(BwfPath.class, BwfJavaModule.CLASSPATH);
  }

  public List<BwfPath> getClasspaths() {
    return this.getChildren(BwfPath.class, BwfJavaModule.CLASSPATH);
  }

  public void addClasspath(BwfPath node) {
    this.addChild(BwfJavaModule.CLASSPATH, node);
  }

  public void insertClasspath(BwfPath prev, BwfPath node) {
    this.insertChild(prev, BwfJavaModule.CLASSPATH, node);
  }

  public int getSourcesesCount() {
    return this.getChildCount(BwfJavaModule.SOURCES);
  }

  public Iterator<BwfPath> sourceses() {
    return this.children(BwfPath.class, BwfJavaModule.SOURCES);
  }

  public List<BwfPath> getSourceses() {
    return this.getChildren(BwfPath.class, BwfJavaModule.SOURCES);
  }

  public void addSources(BwfPath node) {
    this.addChild(BwfJavaModule.SOURCES, node);
  }

  public void insertSources(BwfPath prev, BwfPath node) {
    this.insertChild(prev, BwfJavaModule.SOURCES, node);
  }

  public int getDependenciesesCount() {
    return this.getChildCount(BwfJavaModule.DEPENDENCIES);
  }

  public Iterator<BwfJavaModuleReference> dependencieses() {
    return this.children(BwfJavaModuleReference.class, BwfJavaModule.DEPENDENCIES);
  }

  public List<BwfJavaModuleReference> getDependencieses() {
    return this.getChildren(BwfJavaModuleReference.class, BwfJavaModule.DEPENDENCIES);
  }

  public void addDependencies(BwfJavaModuleReference node) {
    this.addChild(BwfJavaModule.DEPENDENCIES, node);
  }

  public void insertDependencies(BwfJavaModuleReference prev, BwfJavaModuleReference node) {
    this.insertChild(prev, BwfJavaModule.DEPENDENCIES, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BwfJavaModule.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BwfJavaModule.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BwfJavaModule.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BwfJavaModule.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BwfJavaModule.SMODEL_ATTRIBUTE, node);
  }

  public static BwfJavaModule newInstance(SModel sm, boolean init) {
    return (BwfJavaModule) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfJavaModule", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BwfJavaModule newInstance(SModel sm) {
    return BwfJavaModule.newInstance(sm, false);
  }
}
