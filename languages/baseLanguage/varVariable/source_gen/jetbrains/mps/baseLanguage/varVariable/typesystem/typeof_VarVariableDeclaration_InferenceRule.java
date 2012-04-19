package jetbrains.mps.baseLanguage.varVariable.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_VarVariableDeclaration_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_VarVariableDeclaration_InferenceRule() {
  }

  public void applyRule(final SNode varVariableDeclaration, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    final SNode initializerType_typevar_8425555512443936489 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(varVariableDeclaration, "initializer", true);
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:376aaabb-efff-403a-9afa-fc63fa67c6b3(jetbrains.mps.baseLanguage.varVariable.typesystem)", "1236696586241", 0, null);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.getRepresentative(initializerType_typevar_8425555512443936489), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:376aaabb-efff-403a-9afa-fc63fa67c6b3(jetbrains.mps.baseLanguage.varVariable.typesystem)", "1236696598890", true), _info_12389875345);
    }
    {
      final SNode _concreteInitializerType = typeCheckingContext.getRepresentative(initializerType_typevar_8425555512443936489);
      typeCheckingContext.whenConcrete(_concreteInitializerType, new Runnable() {
        public void run() {
          SNode concreteInitializerType = SNodeOperations.cast(typeCheckingContext.getExpandedNode(_concreteInitializerType), "jetbrains.mps.baseLanguage.structure.Type");
          concreteInitializerType = ClassifierTypeUtil.copyTypeRecursively(ClassifierTypeUtil.getTypeCoercedToClassifierType(concreteInitializerType));
          {
            SNode _nodeToCheck_1029348928467 = varVariableDeclaration;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:376aaabb-efff-403a-9afa-fc63fa67c6b3(jetbrains.mps.baseLanguage.varVariable.typesystem)", "8425555512443936533", 0, null);
            typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:376aaabb-efff-403a-9afa-fc63fa67c6b3(jetbrains.mps.baseLanguage.varVariable.typesystem)", "8425555512443936528", true), (SNode) concreteInitializerType, _info_12389875345);
          }
        }
      }, "r:376aaabb-efff-403a-9afa-fc63fa67c6b3(jetbrains.mps.baseLanguage.varVariable.typesystem)", "8425555512443936496", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.varVariable.structure.VarVariableDeclaration";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return true;
  }
}
