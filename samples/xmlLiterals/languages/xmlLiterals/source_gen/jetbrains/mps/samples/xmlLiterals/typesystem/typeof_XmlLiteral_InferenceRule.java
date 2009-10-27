package jetbrains.mps.samples.xmlLiterals.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_XmlLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_XmlLiteral_InferenceRule() {
  }

  public void applyRule(final SNode literal, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = literal;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:0264c2b0-f115-4504-b39f-f4dbddf68df1(jetbrains.mps.samples.xmlLiterals.typesystem)", "9152904044274382249", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:0264c2b0-f115-4504-b39f-f4dbddf68df1(jetbrains.mps.samples.xmlLiterals.typesystem)", "9152904044274367393", true), (SNode)new _Quotations.QuotationClass_0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.samples.xmlLiterals.structure.XmlLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
