package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InequationReplacementRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.OverloadedOperationsTypesProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.SubtypingManager;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.baseLanguage.math.behavior.MathUtil;

public class TypesystemDescriptor extends BaseHelginsDescriptor {
  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_AbsExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ArithmSymbol_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_BinaryOperationMathContext_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ComplexLiteral_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ConjugateOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_Determinant_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_DivOperationFraction_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ExtrSymbol_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ILiteral_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_InIntervalExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IntervalContainsExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IntervalLiteral_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IntervalType_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_LinearSolveOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MathSymbol_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MathSymbolFromToIndex_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MathSymbolIndex_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MathSymbolReference_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MathTypeCast_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixConstructor_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixElementAccessExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixInitializer_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixInitializerIndexReference_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixInverseOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixNorm_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixUnit_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MatrixZero_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_PowExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TransposeOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TrigonometricExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_VectorInitializer_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new IntervalSupertypes_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new bigcomplex_extends_BigComplex_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new bigdecimal_extends_BigDecimal_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new bigdecimal_extends_bigcomplex_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new biginteger_extends_BigInteger_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new biginteger_extends_bigdecimal_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new complex_extends_Complex_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new complex_extends_bigcomplex_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new double_extends_bigdecimal_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new double_extends_complex_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new long_extends_biginteger_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new matrix_subtype_of_object_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new vector_subtype_of_matrix_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      InequationReplacementRule_Runtime eliminationRule = new matrix_replacement_rule_InequationReplacementRule();
      this.myInequationReplacementRules.add(eliminationRule);
    }
    {
      InequationReplacementRule_Runtime eliminationRule = new matrix_vector_replacement_rule_InequationReplacementRule();
      this.myInequationReplacementRules.add(eliminationRule);
    }
    {
      InequationReplacementRule_Runtime eliminationRule = new vector_vector_replacement_rule_InequationReplacementRule();
      this.myInequationReplacementRules.add(eliminationRule);
    }
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_f("jetbrains.mps.baseLanguage.structure.ShiftLeftExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_h("jetbrains.mps.baseLanguage.structure.BitwiseAndExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_i("jetbrains.mps.baseLanguage.structure.BitwiseOrExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_j("jetbrains.mps.baseLanguage.structure.BitwiseXorExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_g("jetbrains.mps.baseLanguage.structure.ShiftRightExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_e("jetbrains.mps.baseLanguage.structure.RemExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_k("jetbrains.mps.baseLanguage.structure.LessThanExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_l("jetbrains.mps.baseLanguage.structure.GreaterThanExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_m("jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_n("jetbrains.mps.baseLanguage.structure.GreaterThanOrEqualsExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a("jetbrains.mps.baseLanguage.structure.PlusExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_b("jetbrains.mps.baseLanguage.structure.MinusExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_c("jetbrains.mps.baseLanguage.structure.MulExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_d("jetbrains.mps.baseLanguage.structure.DivExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_o("jetbrains.mps.baseLanguage.structure.PlusExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_p("jetbrains.mps.baseLanguage.structure.MinusExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_q("jetbrains.mps.baseLanguage.structure.MulExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_r("jetbrains.mps.baseLanguage.structure.MulExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_s("jetbrains.mps.baseLanguage.structure.DivExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_t("jetbrains.mps.baseLanguage.structure.MulExpression"));
  }

  public static class CustomOverloadedOperationsTypesProvider_f extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_f(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qInt;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.qBigInteger;
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_h extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_h(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qBigInteger;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBigInteger);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_i extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_i(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qBigInteger;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBigInteger);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_j extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_j(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qBigInteger;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBigInteger);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_g extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_g(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qInt;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.qBigInteger;
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_e extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_e(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigInteger;
      this.myRightOperandType = MathTypeUtil.qBigInteger;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBigInteger);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.BigIntegerType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_k extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_k(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigDecimal;
      this.myRightOperandType = MathTypeUtil.qBigDecimal;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = true;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBoolean);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return !(SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.structure.NullType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.structure.NullType"));
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_l extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_l(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigDecimal;
      this.myRightOperandType = MathTypeUtil.qBigDecimal;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = true;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBoolean);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return !(SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.structure.NullType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.structure.NullType"));
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_m extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_m(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigDecimal;
      this.myRightOperandType = MathTypeUtil.qBigDecimal;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = true;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBoolean);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return !(SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.structure.NullType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.structure.NullType"));
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_n extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_n(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigDecimal;
      this.myRightOperandType = MathTypeUtil.qBigDecimal;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = true;
      this.myRightTypeIsExact = true;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.copyNode(MathTypeUtil.qBoolean);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return !(SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.structure.NullType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.structure.NullType"));
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_a extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_a(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigComplex;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.join(leftOperandType, rightOperandType);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_b extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_b(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigComplex;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.join(leftOperandType, rightOperandType);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_c extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_c(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigComplex;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.join(leftOperandType, rightOperandType);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_d extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_d(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigComplex;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.join(leftOperandType, rightOperandType);
    }

    public boolean isApplicable(SubtypingManager subtypingManager, SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return SNodeOperations.isInstanceOf(leftOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType") || SNodeOperations.isInstanceOf(rightOperandType, "jetbrains.mps.baseLanguage.math.structure.MathPrimitiveType");
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_o extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_o(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBCMatrix;
      this.myRightOperandType = MathTypeUtil.qBCMatrix;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.ML_matrixOp(leftOperandType, rightOperandType, false);
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_p extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_p(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBCMatrix;
      this.myRightOperandType = MathTypeUtil.qBCMatrix;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.ML_matrixOp(leftOperandType, rightOperandType, false);
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_q extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_q(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBigComplex;
      this.myRightOperandType = MathTypeUtil.qBCMatrix;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.typeOfMatrixScalarMultiplication(leftOperandType, rightOperandType);
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_r extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_r(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBCMatrix;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(MathUtil.getUnboxedElementType(leftOperandType), rightOperandType)) {
        return MathTypeUtil.qMatrix(rightOperandType);
      } else {
        return leftOperandType;
      }
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_s extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_s(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBCMatrix;
      this.myRightOperandType = MathTypeUtil.qBigComplex;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(MathUtil.getUnboxedElementType(leftOperandType), rightOperandType)) {
        return MathTypeUtil.qMatrix(rightOperandType);
      } else {
        return leftOperandType;
      }
    }
  }

  public static class CustomOverloadedOperationsTypesProvider_t extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_t(String conceptFQ) {
      this.myLeftOperandType = MathTypeUtil.qBCMatrix;
      this.myRightOperandType = MathTypeUtil.qBCMatrix;
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return MathTypeUtil.ML_matrixOp(leftOperandType, rightOperandType, true);
    }
  }
}
