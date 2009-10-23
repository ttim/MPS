package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.math.behavior.MathUtil;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_LinearSolveOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_LinearSolveOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode matrixType = typeCheckingContext.typeOf(SLinkOperations.getTarget(op, "matrix", true), "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060115", true);
      typeCheckingContext.whenConcrete(matrixType, new Runnable() {
        public void run() {
          {
            final SNode vectorType = typeCheckingContext.typeOf(SLinkOperations.getTarget(op, "vector", true), "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060128", true);
            typeCheckingContext.whenConcrete(vectorType, new Runnable() {
              public void run() {
                final SNode T_typevar_5359814223490060193 = typeCheckingContext.createNewRuntimeTypesVariable();
                {
                  SNode _nodeToCheck_1029348928467 = op;
                  BaseIntentionProvider intentionProvider = null;
                  EquationInfo info = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060213", 0, intentionProvider);
                  info.setInequationGroup("default");
                  typeCheckingContext.createLessThanInequation((SNode)SNodeOperations.copyNode(MathTypeUtil.qFloat), (SNode)typeCheckingContext.getEquationManager().getRepresentator(T_typevar_5359814223490060193), false, info);
                }
                if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(matrixType), "jetbrains.mps.baseLanguage.math.structure.MatrixOrVectorType")) {
                  {
                    SNode _nodeToCheck_1029348928467 = op;
                    BaseIntentionProvider intentionProvider = null;
                    EquationInfo info = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060186", 0, intentionProvider);
                    info.setInequationGroup("default");
                    typeCheckingContext.createLessThanInequation((SNode)MathUtil.getUnboxedElementType(typeCheckingContext.getEquationManager().getRepresentator(matrixType)), (SNode)typeCheckingContext.getEquationManager().getRepresentator(T_typevar_5359814223490060193), false, info);
                  }
                } else {
                  {
                    BaseIntentionProvider intentionProvider = null;
                    IErrorTarget errorTarget = new NodeErrorTarget();
                    typeCheckingContext.reportTypeError(SLinkOperations.getTarget(op, "matrix", true), "Left side of the equation must have matrix type", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060240", intentionProvider, errorTarget);
                  }
                }
                if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(vectorType), "jetbrains.mps.baseLanguage.math.structure.MatrixOrVectorType")) {
                  {
                    SNode _nodeToCheck_1029348928467 = op;
                    BaseIntentionProvider intentionProvider = null;
                    EquationInfo info = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060227", 0, intentionProvider);
                    info.setInequationGroup("default");
                    typeCheckingContext.createLessThanInequation((SNode)MathUtil.getUnboxedElementType(typeCheckingContext.getEquationManager().getRepresentator(matrixType)), (SNode)typeCheckingContext.getEquationManager().getRepresentator(T_typevar_5359814223490060193), false, info);
                  }
                } else {
                  {
                    BaseIntentionProvider intentionProvider = null;
                    IErrorTarget errorTarget = new NodeErrorTarget();
                    typeCheckingContext.reportTypeError(SLinkOperations.getTarget(op, "vector", true), "Right side of the equation must have matrix type", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060245", intentionProvider, errorTarget);
                  }
                }
                {
                  SNode _nodeToCheck_1029348928467 = op;
                  BaseIntentionProvider intentionProvider = null;
                  EquationInfo info = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060200", 0, intentionProvider);
                  typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060197", true), (SNode)MathTypeUtil.qVector(typeCheckingContext.getEquationManager().getRepresentator(T_typevar_5359814223490060193)), info);
                }
              }
            }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060125", false, false);
          }
        }
      }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "5359814223490060106", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.LinearSolveOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
