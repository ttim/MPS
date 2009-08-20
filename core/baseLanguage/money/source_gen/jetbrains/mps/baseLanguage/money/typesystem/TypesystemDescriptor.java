package jetbrains.mps.baseLanguage.money.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.OverloadedOperationsTypesProvider;
import jetbrains.mps.smodel.SNode;

public class TypesystemDescriptor extends BaseHelginsDescriptor {
  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyGetAmountMethodCall_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyGetCurrencyMethodCall_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyIsZeroMethodCall_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyCreator_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyLiteral_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      OverloadedOperationsTypesProvider provider = new OverloadedOperationsTypesProvider() {
        {
          this.myLeftOperandType = new _Quotations.QuotationClass_5().createNode();
          this.myRightOperandType = new _Quotations.QuotationClass_6().createNode();
          this.myOperationConceptFQName = "jetbrains.mps.baseLanguage.structure.PlusExpression";
          this.myLeftTypeIsExact = true;
          this.myRightTypeIsExact = true;
        }

        public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
          return new _Quotations.QuotationClass_7().createNode();
        }
      };
      this.myOverloadedOperationsTypesProviders.add(provider);
    }
    {
      OverloadedOperationsTypesProvider provider = new OverloadedOperationsTypesProvider() {
        {
          this.myLeftOperandType = new _Quotations.QuotationClass_8().createNode();
          this.myRightOperandType = new _Quotations.QuotationClass_9().createNode();
          this.myOperationConceptFQName = "jetbrains.mps.baseLanguage.structure.MinusExpression";
          this.myLeftTypeIsExact = true;
          this.myRightTypeIsExact = true;
        }

        public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
          return new _Quotations.QuotationClass_10().createNode();
        }
      };
      this.myOverloadedOperationsTypesProviders.add(provider);
    }
    {
      OverloadedOperationsTypesProvider provider = new OverloadedOperationsTypesProvider() {
        {
          this.myLeftOperandType = new _Quotations.QuotationClass_11().createNode();
          this.myRightOperandType = new _Quotations.QuotationClass_13().createNode();
          this.myOperationConceptFQName = "jetbrains.mps.baseLanguage.structure.DivExpression";
          this.myLeftTypeIsExact = true;
          this.myRightTypeIsExact = true;
        }

        public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
          return new _Quotations.QuotationClass_12().createNode();
        }
      };
      this.myOverloadedOperationsTypesProviders.add(provider);
    }
    {
      OverloadedOperationsTypesProvider provider = new OverloadedOperationsTypesProvider() {
        {
          this.myLeftOperandType = new _Quotations.QuotationClass_14().createNode();
          this.myRightOperandType = new _Quotations.QuotationClass_15().createNode();
          this.myOperationConceptFQName = "jetbrains.mps.baseLanguage.structure.MulExpression";
          this.myLeftTypeIsExact = true;
          this.myRightTypeIsExact = true;
        }

        public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
          return new _Quotations.QuotationClass_16().createNode();
        }
      };
      this.myOverloadedOperationsTypesProviders.add(provider);
    }
    {
      OverloadedOperationsTypesProvider provider = new OverloadedOperationsTypesProvider() {
        {
          this.myLeftOperandType = new _Quotations.QuotationClass_17().createNode();
          this.myRightOperandType = new _Quotations.QuotationClass_18().createNode();
          this.myOperationConceptFQName = "jetbrains.mps.baseLanguage.structure.MulExpression";
          this.myLeftTypeIsExact = true;
          this.myRightTypeIsExact = true;
        }

        public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
          return new _Quotations.QuotationClass_19().createNode();
        }
      };
      this.myOverloadedOperationsTypesProviders.add(provider);
    }
  }
}
