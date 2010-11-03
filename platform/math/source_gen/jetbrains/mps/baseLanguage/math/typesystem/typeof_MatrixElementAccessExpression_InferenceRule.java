package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_MatrixElementAccessExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_MatrixElementAccessExpression_InferenceRule() {
  }

  public void applyRule(final SNode mea, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "rowIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard"))) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(mea, "rowIndex", true);
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492694", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492699", true), (SNode) SNodeOperations.copyNode(MathTypeUtil.qInt), false, _info_12389875345);
      }
    }
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "colIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard"))) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(mea, "colIndex", true);
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492706", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492711", true), (SNode) SNodeOperations.copyNode(MathTypeUtil.qInt), false, _info_12389875345);
      }
    }
    final SNode T_typevar_964810815943338296 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(mea, "expression", true);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943338307", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943338299", true), (SNode) MathTypeUtil.qMatrix(typeCheckingContext.getRepresentative(T_typevar_964810815943338296)), false, _info_12389875345);
    }
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "rowIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "colIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard")) {
      {
        BaseQuickFixProvider intentionProvider = null;
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(mea, "Illegal expression", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943562072", intentionProvider, errorTarget);
      }
    }
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "rowIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard") || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(mea, "colIndex", true), "jetbrains.mps.baseLanguage.math.structure.MatrixIndexWildcard")) {
      {
        SNode _nodeToCheck_1029348928467 = mea;
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492768", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492770", true), (SNode) MathTypeUtil.qVector(typeCheckingContext.getRepresentative(T_typevar_964810815943338296)), _info_12389875345);
      }
    } else {
      {
        SNode _nodeToCheck_1029348928467 = mea;
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492762", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "964810815943492764", true), (SNode) typeCheckingContext.getRepresentative(T_typevar_964810815943338296), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.MatrixElementAccessExpression";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }
}
