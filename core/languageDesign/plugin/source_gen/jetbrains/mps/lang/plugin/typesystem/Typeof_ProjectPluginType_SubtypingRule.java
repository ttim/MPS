package jetbrains.mps.lang.plugin.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.plugin.typesystem._Quotations;
import jetbrains.mps.smodel.SModelUtil_new;

public class Typeof_ProjectPluginType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  public Typeof_ProjectPluginType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode pluginType) {
    return new _Quotations.QuotationClass_3().createNode();
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.plugin.structure.ProjectPluginType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

}
