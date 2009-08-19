package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.typesystem.DataFlowUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_AbstractSubtypingRule_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_AbstractSubtypingRule_NonTypesystemRule() {
  }

  public void applyRule(final SNode abstractSubtypingRule, final TypeCheckingContext typeCheckingContext) {
    DataFlowUtil.checkDataFlow(typeCheckingContext, abstractSubtypingRule);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.AbstractSubtypingRule";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
