package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SmartClosureParameterDeclaration_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_SmartClosureParameterDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode scpd, final TypeCheckingContext typeCheckingContext) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(scpd), "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral") && SNodeOperations.isInstanceOf(SNodeOperations.getParent(SNodeOperations.getParent(scpd)), "jetbrains.mps.baseLanguage.structure.IOperation")) {
      final SNode paramType_typevar_1230315924141 = typeCheckingContext.createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.getParent(scpd)), "jetbrains.mps.baseLanguage.structure.IOperation"));
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1230315907234", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1230315907236", true), (SNode)new _Quotations.QuotationClass_91().createNode(typeCheckingContext.getEquationManager().getRepresentator(paramType_typevar_1230315924141), typeCheckingContext), false, _info_12389875345);
      }
      {
        SNode _nodeToCheck_1029348928467 = scpd;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1230315977451", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1230315969555", true), (SNode)typeCheckingContext.getEquationManager().getRepresentator(paramType_typevar_1230315924141), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
