package jetbrains.mps.ypath.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;

public class TypesystemDescriptor extends BaseHelginsDescriptor {

  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathType_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathCreator_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathAspect_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathAdapterExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathOperationExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreePathOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeOf_LambdaMethodParameter_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreeNodeKind_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreeNodeKindProperty_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_TreeNodeKindReference_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_VisitNodesStatement_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new check_VisitChildrenExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_NodeFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IndexFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ValueFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_NodeTypeFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ParamFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ExpressionFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_WritePathExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new check_IndexAnchor_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new check_ElementAnchor_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_RangeFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ReplaceExpressionFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IsWithinRangeExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_IsAtInsertionPointExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new check_NextElementStatement_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_InsertExpressionFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_EmptySequenceExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_GeneratorFunctionParam_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      NonTypesystemRule_Runtime nonTypesystemRule = new check_ExpressionWritePathStatement_NonTypesystemRule();
      this.myNonTypesystemRules.add(nonTypesystemRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new TreePathType_extends_SequenceType_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
  }
}
