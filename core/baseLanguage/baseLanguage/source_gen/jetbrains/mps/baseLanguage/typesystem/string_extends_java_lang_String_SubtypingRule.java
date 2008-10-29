package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;

public class string_extends_java_lang_String_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  public string_extends_java_lang_String_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode stringType) {
    return new _Quotations.QuotationClass_107().createNode();
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.StringType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

}
