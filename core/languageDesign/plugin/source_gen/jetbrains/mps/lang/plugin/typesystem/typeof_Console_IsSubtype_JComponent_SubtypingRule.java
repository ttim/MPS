package jetbrains.mps.lang.plugin.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_Console_IsSubtype_JComponent_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public typeof_Console_IsSubtype_JComponent_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode consoleType, TypeCheckingContext typeCheckingContext) {
    return new _Quotations.QuotationClass_25().createNode(typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.plugin.structure.ConsoleType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }
}
