package jetbrains.mps.bootstrap.structureLanguage.structure;

/*Generated by MPS  */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.project.GlobalScope;

public class PropertyDeclaration extends BaseConcept implements INamedConcept {
  public static String DATA_TYPE = "dataType";
  public static String NAME = "name";

  public  PropertyDeclaration(SNode node) {
    super(node);
  }

  public static PropertyDeclaration newInstance(SModel sm) {
    return (PropertyDeclaration)SModelUtil.instantiateConceptDeclaration("jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration", sm, GlobalScope.getInstance()).getAdapter();
  }

  public DataTypeDeclaration getDataType() {
    return (DataTypeDeclaration)this.getReferent(PropertyDeclaration.DATA_TYPE);
  }
  public void setDataType(DataTypeDeclaration node) {
    super.setReferent(PropertyDeclaration.DATA_TYPE, node);
  }
  public String getName() {
    return this.getProperty(PropertyDeclaration.NAME);
  }
  public void setName(String value) {
    this.setProperty(PropertyDeclaration.NAME, value);
  }
}
