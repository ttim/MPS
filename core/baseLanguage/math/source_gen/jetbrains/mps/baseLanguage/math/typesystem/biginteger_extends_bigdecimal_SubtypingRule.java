package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class biginteger_extends_bigdecimal_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public biginteger_extends_bigdecimal_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode bigIntegerType, TypeCheckingContext typeCheckingContext) {
    return SNodeOperations.copyNode(MathTypeUtil.qBigDecimal);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.BigIntegerType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }
}
