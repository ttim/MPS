package jetbrains.mps.lang.core.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BaseConcept extends BaseAdapter {
  public static final String concept = "jetbrains.mps.lang.core.structure.BaseConcept";
  public static final String CPR_Abstract = "abstract";
  public static final String CPR_Alias = "alias";
  public static final String CPR_Short_description = "short_description";
  public static final String CPR_DontSubstituteByDefault = "dontSubstituteByDefault";
  public static final String CPR_Deprecated_798 = "deprecated_798";
  public static final String CPR_Deprecated_944 = "deprecated_944";
  public static final String CPR_Deprecated_1045 = "deprecated_1045";
  public static final String CPR_Deprecated_1117 = "deprecated_1117";
  public static final String CPR_Deprecated_next_after_1117 = "deprecated_next_after_1117";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";

  public BaseConcept(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BaseConcept.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BaseConcept.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BaseConcept.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BaseConcept.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BaseConcept.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BaseConcept.VIRTUAL_PACKAGE, value);
  }


  public static BaseConcept newInstance(SModel sm, boolean init) {
    return (BaseConcept)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BaseConcept newInstance(SModel sm) {
    return BaseConcept.newInstance(sm, false);
  }

}
