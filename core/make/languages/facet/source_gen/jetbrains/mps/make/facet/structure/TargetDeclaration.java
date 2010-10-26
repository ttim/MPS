package jetbrains.mps.make.facet.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.make.script.structure.JobDeclaration;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TargetDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.make.facet.structure.TargetDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String OVERRIDES = "overrides";
  public static final String CONFIG = "config";
  public static final String JOB = "job";
  public static final String DEPENDENCY = "dependency";

  public TargetDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(TargetDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(TargetDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(TargetDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TargetDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TargetDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TargetDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TargetDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TargetDeclaration.VIRTUAL_PACKAGE, value);
  }

  public TargetDeclaration getOverrides() {
    return (TargetDeclaration) this.getReferent(TargetDeclaration.class, TargetDeclaration.OVERRIDES);
  }

  public void setOverrides(TargetDeclaration node) {
    super.setReferent(TargetDeclaration.OVERRIDES, node);
  }

  public TargetConfiguration getConfig() {
    return (TargetConfiguration) this.getChild(TargetConfiguration.class, TargetDeclaration.CONFIG);
  }

  public void setConfig(TargetConfiguration node) {
    super.setChild(TargetDeclaration.CONFIG, node);
  }

  public JobDeclaration getJob() {
    return (JobDeclaration) this.getChild(JobDeclaration.class, TargetDeclaration.JOB);
  }

  public void setJob(JobDeclaration node) {
    super.setChild(TargetDeclaration.JOB, node);
  }

  public int getDependenciesCount() {
    return this.getChildCount(TargetDeclaration.DEPENDENCY);
  }

  public Iterator<TargetDependency> dependencies() {
    return this.children(TargetDependency.class, TargetDeclaration.DEPENDENCY);
  }

  public List<TargetDependency> getDependencies() {
    return this.getChildren(TargetDependency.class, TargetDeclaration.DEPENDENCY);
  }

  public void addDependency(TargetDependency node) {
    this.addChild(TargetDeclaration.DEPENDENCY, node);
  }

  public void insertDependency(TargetDependency prev, TargetDependency node) {
    this.insertChild(prev, TargetDeclaration.DEPENDENCY, node);
  }

  public static TargetDeclaration newInstance(SModel sm, boolean init) {
    return (TargetDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.make.facet.structure.TargetDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TargetDeclaration newInstance(SModel sm) {
    return TargetDeclaration.newInstance(sm, false);
  }
}
