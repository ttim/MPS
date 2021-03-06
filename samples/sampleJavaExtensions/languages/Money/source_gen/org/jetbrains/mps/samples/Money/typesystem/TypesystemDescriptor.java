package org.jetbrains.mps.samples.Money.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.OverloadedOperationsTypesProvider;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TypesystemDescriptor extends BaseHelginsDescriptor {
  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_ConvertTo_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_MoneyLiteral_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new Money_extends_java_lang_Object_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a("jetbrains.mps.baseLanguage.structure.MinusExpression"));
    this.myOverloadedOperationsTypesProviders.add(new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a("jetbrains.mps.baseLanguage.structure.PlusExpression"));
  }

  public static class CustomOverloadedOperationsTypesProvider_a extends OverloadedOperationsTypesProvider {
    public CustomOverloadedOperationsTypesProvider_a(String conceptFQ) {
      this.myLeftOperandType = new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a.QuotationClass_3ist9o_a0a0a0a().createNode();
      this.myRightOperandType = new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a.QuotationClass_3ist9o_a0a1a0a().createNode();
      this.myOperationConceptFQName = conceptFQ;
      this.myLeftTypeIsExact = false;
      this.myRightTypeIsExact = false;
      this.myRightIsStrong = false;
      this.myLeftIsStrong = false;
    }

    public SNode getOperationType(SNode operation, SNode leftOperandType, SNode rightOperandType) {
      return new TypesystemDescriptor.CustomOverloadedOperationsTypesProvider_a.QuotationClass_3ist9o_a0a0a0().createNode();
    }

    public static class QuotationClass_3ist9o_a0a0a0 {
      public QuotationClass_3ist9o_a0a0a0() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.Money.structure.MoneyType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_3ist9o_a0a0a0a {
      public QuotationClass_3ist9o_a0a0a0a() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.Money.structure.MoneyType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_3ist9o_a0a1a0a {
      public QuotationClass_3ist9o_a0a1a0a() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("org.jetbrains.mps.samples.Money.structure.MoneyType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          result = quotedNode1_2;
        }
        return result;
      }
    }
  }
}
