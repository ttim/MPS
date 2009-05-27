package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationManager;
import jetbrains.mps.util.CollectionUtil;

public class ObjectArraySupertypes_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  /* package */_Patterns.Pattern_8 myMatchingPattern;

  public ObjectArraySupertypes_SubtypingRule() {
  }

  public List<SNode> getSubOrSuperTypes(SNode objectArrayType, EquationManager equationManager) {
    // see JLS 3.0
    return CollectionUtil.list(new _Quotations.QuotationClass_79().createNode(), new _Quotations.QuotationClass_80().createNode(), new _Quotations.QuotationClass_81().createNode());
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ArrayType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new _Patterns.Pattern_8();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return false;
  }

}
