package jetbrains.mps.build.dependency.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Cycle extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.build.dependency.structure.Cycle";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String MODULE_DESCRIPTION = "moduleDescription";
  public static final String DEPENDENCY = "dependency";
  public static final String CLASSPATH = "classpath";

  public Cycle(SNode node) {
    super(node);
  }


  public String getName() {
    return this.getProperty(Cycle.NAME);
  }

  public void setName(String value) {
    this.setProperty(Cycle.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(Cycle.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Cycle.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Cycle.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Cycle.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Cycle.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Cycle.VIRTUAL_PACKAGE, value);
  }

  public int getModuleDescriptionsCount() {
    return this.getChildCount(Cycle.MODULE_DESCRIPTION);
  }

  public Iterator<ModuleDescription> moduleDescriptions() {
    return this.children(ModuleDescription.class, Cycle.MODULE_DESCRIPTION);
  }

  public List<ModuleDescription> getModuleDescriptions() {
    return this.getChildren(ModuleDescription.class, Cycle.MODULE_DESCRIPTION);
  }

  public void addModuleDescription(ModuleDescription node) {
    this.addChild(Cycle.MODULE_DESCRIPTION, node);
  }

  public void insertModuleDescription(ModuleDescription prev, ModuleDescription node) {
    this.insertChild(prev, Cycle.MODULE_DESCRIPTION, node);
  }

  public int getDependenciesCount() {
    return this.getChildCount(Cycle.DEPENDENCY);
  }

  public Iterator<CycleReference> dependencies() {
    return this.children(CycleReference.class, Cycle.DEPENDENCY);
  }

  public List<CycleReference> getDependencies() {
    return this.getChildren(CycleReference.class, Cycle.DEPENDENCY);
  }

  public void addDependency(CycleReference node) {
    this.addChild(Cycle.DEPENDENCY, node);
  }

  public void insertDependency(CycleReference prev, CycleReference node) {
    this.insertChild(prev, Cycle.DEPENDENCY, node);
  }

  public int getClasspathsCount() {
    return this.getChildCount(Cycle.CLASSPATH);
  }

  public Iterator<PathHolder> classpaths() {
    return this.children(PathHolder.class, Cycle.CLASSPATH);
  }

  public List<PathHolder> getClasspaths() {
    return this.getChildren(PathHolder.class, Cycle.CLASSPATH);
  }

  public void addClasspath(PathHolder node) {
    this.addChild(Cycle.CLASSPATH, node);
  }

  public void insertClasspath(PathHolder prev, PathHolder node) {
    this.insertChild(prev, Cycle.CLASSPATH, node);
  }

  public static Cycle newInstance(SModel sm, boolean init) {
    return (Cycle)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.dependency.structure.Cycle", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Cycle newInstance(SModel sm) {
    return Cycle.newInstance(sm, false);
  }
}
