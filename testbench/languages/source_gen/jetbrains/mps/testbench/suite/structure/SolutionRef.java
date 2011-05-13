package jetbrains.mps.testbench.suite.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SolutionRef extends BaseConcept implements IModuleRef {
  public static final String concept = "jetbrains.mps.testbench.suite.structure.SolutionRef";
  public static final String MODULE_F_Q_NAME = "moduleFQName";
  public static final String MODULE_I_D = "moduleID";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public SolutionRef(SNode node) {
    super(node);
  }

  public String getModuleFQName() {
    return this.getProperty(SolutionRef.MODULE_F_Q_NAME);
  }

  public void setModuleFQName(String value) {
    this.setProperty(SolutionRef.MODULE_F_Q_NAME, value);
  }

  public String getModuleID() {
    return this.getProperty(SolutionRef.MODULE_I_D);
  }

  public void setModuleID(String value) {
    this.setProperty(SolutionRef.MODULE_I_D, value);
  }

  public String getShortDescription() {
    return this.getProperty(SolutionRef.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(SolutionRef.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(SolutionRef.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(SolutionRef.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(SolutionRef.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(SolutionRef.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(SolutionRef.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, SolutionRef.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, SolutionRef.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(SolutionRef.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, SolutionRef.SMODEL_ATTRIBUTE, node);
  }

  public static SolutionRef newInstance(SModel sm, boolean init) {
    return (SolutionRef) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.testbench.suite.structure.SolutionRef", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SolutionRef newInstance(SModel sm) {
    return SolutionRef.newInstance(sm, false);
  }
}
