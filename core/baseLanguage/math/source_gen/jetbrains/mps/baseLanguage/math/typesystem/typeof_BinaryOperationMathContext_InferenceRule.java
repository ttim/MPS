package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.math.behavior.MathUtil;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;

public class typeof_BinaryOperationMathContext_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_BinaryOperationMathContext_InferenceRule() {
  }

  public void applyRule(final SNode oper, final TypeCheckingContext typeCheckingContext) {
    final String S = "Operation only applicable to arguments of big decimal type";
    final SNode rightExpressionType_typevar_8613885519962201007 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode leftExpressionType_typevar_8613885519962201008 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(oper, "rightExpression", true);
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation((SNode)typeCheckingContext.getEquationManager().getRepresentator(rightExpressionType_typevar_8613885519962201007), (SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201011", true), _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201009", intentionProvider);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(oper, "leftExpression", true);
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.createEquation((SNode)typeCheckingContext.getEquationManager().getRepresentator(leftExpressionType_typevar_8613885519962201008), (SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201019", true), _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201017", intentionProvider);
    }
    {
      final SNode leftType = typeCheckingContext.getEquationManager().getRepresentator(leftExpressionType_typevar_8613885519962201008);
      typeCheckingContext.whenConcrete(leftType, new Runnable() {
        public void run() {
          {
            final SNode rightType = typeCheckingContext.getEquationManager().getRepresentator(rightExpressionType_typevar_8613885519962201007);
            typeCheckingContext.whenConcrete(rightType, new Runnable() {
              public void run() {
                SNode op;
                do {
                  SNode matchedNode_0 = oper;
                  {
                    boolean matches_0 = false;
                    {
                      SNode matchingNode_0 = oper;
                      if (matchingNode_0 != null) {
                        matches_0 = SModelUtil_new.isAssignableConcept(matchingNode_0.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.DecimalDivExpression");
                      }
                    }
                    if (matches_0) {
                      op = new _Quotations.QuotationClass_43().createNode(typeCheckingContext);
                      break;
                    }
                  }
                  {
                    boolean matches_1 = false;
                    {
                      SNode matchingNode_1 = oper;
                      if (matchingNode_1 != null) {
                        matches_1 = SModelUtil_new.isAssignableConcept(matchingNode_1.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.DecimalMinusExpression");
                      }
                    }
                    if (matches_1) {
                      op = new _Quotations.QuotationClass_44().createNode(typeCheckingContext);
                      break;
                    }
                  }
                  {
                    boolean matches_2 = false;
                    {
                      SNode matchingNode_2 = oper;
                      if (matchingNode_2 != null) {
                        matches_2 = SModelUtil_new.isAssignableConcept(matchingNode_2.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.DecimalMulExpression");
                      }
                    }
                    if (matches_2) {
                      op = new _Quotations.QuotationClass_45().createNode(typeCheckingContext);
                      break;
                    }
                  }
                  {
                    boolean matches_3 = false;
                    {
                      SNode matchingNode_3 = oper;
                      if (matchingNode_3 != null) {
                        matches_3 = SModelUtil_new.isAssignableConcept(matchingNode_3.getConceptFqName(), "jetbrains.mps.baseLanguage.math.structure.DecimalPlusExpression");
                      }
                    }
                    if (matches_3) {
                      op = new _Quotations.QuotationClass_46().createNode(typeCheckingContext);
                      break;
                    }
                  }
                  op = null;
                } while(false);
                SNode opType = typeCheckingContext.getOverloadedOperationType(op, typeCheckingContext.getEquationManager().getRepresentator(leftType), typeCheckingContext.getEquationManager().getRepresentator(rightType));
                if (!(SNodeOperations.isInstanceOf(opType, "jetbrains.mps.baseLanguage.math.structure.BigComplexType") || SNodeOperations.isInstanceOf(opType, "jetbrains.mps.baseLanguage.math.structure.BigDecimalType") || (SNodeOperations.isInstanceOf(opType, "jetbrains.mps.baseLanguage.math.structure.MatrixOrVectorType") && (SNodeOperations.isInstanceOf(MathUtil.getUnboxedElementType(opType), "jetbrains.mps.baseLanguage.math.structure.BigComplexType") || SNodeOperations.isInstanceOf(MathUtil.getUnboxedElementType(opType), "jetbrains.mps.baseLanguage.math.structure.BigDecimalType"))))) {
                  {
                    BaseIntentionProvider intentionProvider = null;
                    intentionProvider = new BaseIntentionProvider("jetbrains.mps.baseLanguage.math.typesystem.DeleteMathContext_QuickFix", false);
                    IErrorTarget errorTarget = new NodeErrorTarget();
                    typeCheckingContext.reportTypeError(oper, S, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962202373", intentionProvider, errorTarget);
                  }
                }
                if ((opType != null)) {
                  {
                    SNode _nodeToCheck_1029348928467 = oper;
                    BaseIntentionProvider intentionProvider = null;
                    typeCheckingContext.createEquation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201043", true), (SNode)opType, _nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201041", intentionProvider);
                  }
                } else {
                  {
                    BaseIntentionProvider intentionProvider = null;
                    IErrorTarget errorTarget = new NodeErrorTarget();
                    typeCheckingContext.reportTypeError(op, "operation can't be applied to these operands", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201052", intentionProvider, errorTarget);
                  }
                }
              }
            }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201027", false, false);
          }
        }
      }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "8613885519962201025", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.DecimalBinaryOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
