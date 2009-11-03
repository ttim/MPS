package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import java.util.Map;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeOf_EnumConstantDeclaration_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeOf_EnumConstantDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode enumConstantDeclaration, final TypeCheckingContext typeCheckingContext) {
    final SNode methodClassifier = SNodeOperations.getAncestor(enumConstantDeclaration, "jetbrains.mps.baseLanguage.structure.EnumClass", false, false);
    SNode constructedType = new _Quotations.QuotationClass_108().createNode(methodClassifier, typeCheckingContext);
    // --- 
    {
      SNode _nodeToCheck_1029348928467 = enumConstantDeclaration;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1241009438604", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1241009438608", true), (SNode)constructedType, _info_12389875345);
    }
    final SNode instanceType_typevar_1241009438611 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = enumConstantDeclaration;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "1241009438612", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode)typeCheckingContext.getEquationManager().getRepresentator(instanceType_typevar_1241009438611), (SNode)constructedType, _info_12389875345);
    }
    // --- following piece of cake is identical for any method call --- 
    Map<SNode, List<SNode>> mmap = MapSequence.fromMap(new HashMap<SNode, List<SNode>>());
    RulesFunctions_BaseLanguage.inference_equateParametersAndReturnType(typeCheckingContext, enumConstantDeclaration, null, mmap);
    RulesFunctions_BaseLanguage.inference_matchConcreteTypesWithTypeVariables(typeCheckingContext, methodClassifier, typeCheckingContext.getEquationManager().getRepresentator(instanceType_typevar_1241009438611), mmap);
    RulesFunctions_BaseLanguage.inference_equateMatchingTypeVariables(typeCheckingContext, mmap);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }
}
