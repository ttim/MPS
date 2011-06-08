package jetbrains.mps.baseLanguageInternal.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DescriptorProvider;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import java.util.Arrays;

public class BehaviorAspectDescriptor extends DescriptorProvider<BehaviorDescriptor> {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListInnerExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassConcept", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassCreator", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethodExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethod_CallExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantRefExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass", "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClassCreator", "jetbrains.mps.baseLanguageInternal.structure.InternalClassExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalClassifierType", "jetbrains.mps.baseLanguageInternal.structure.InternalNewExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalPartialFieldReference", "jetbrains.mps.baseLanguageInternal.structure.InternalPartialInstanceMethodCall", "jetbrains.mps.baseLanguageInternal.structure.InternalStaticFieldReference", "jetbrains.mps.baseLanguageInternal.structure.InternalStaticMethodCall", "jetbrains.mps.baseLanguageInternal.structure.InternalThisExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference", "jetbrains.mps.baseLanguageInternal.structure.TypeHintExpression", "jetbrains.mps.baseLanguageInternal.structure.WeakClassReference"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 17:
        return new InternalStaticMethodCall_BehaviorDescriptor();
      case 16:
        return new InternalStaticFieldReference_BehaviorDescriptor();
      case 13:
        return new InternalNewExpression_BehaviorDescriptor();
      case 15:
        return new InternalPartialInstanceMethodCall_BehaviorDescriptor();
      case 11:
        return new InternalClassExpression_BehaviorDescriptor();
      case 12:
        return new InternalClassifierType_BehaviorDescriptor();
      case 19:
        return new InternalVariableReference_BehaviorDescriptor();
      case 14:
        return new InternalPartialFieldReference_BehaviorDescriptor();
      case 20:
        return new TypeHintExpression_BehaviorDescriptor();
      case 18:
        return new InternalThisExpression_BehaviorDescriptor();
      case 7:
        return new ExtractToConstantExpression_BehaviorDescriptor();
      case 0:
        return new ExtractStatementListExpression_BehaviorDescriptor();
      case 1:
        return new ExtractStatementListInnerExpression_BehaviorDescriptor();
      case 5:
        return new ExtractStaticMethodExpression_BehaviorDescriptor();
      case 6:
        return new ExtractStaticMethod_CallExpression_BehaviorDescriptor();
      case 4:
        return new ExtractStaticInnerClassExpression_BehaviorDescriptor();
      case 3:
        return new ExtractStaticInnerClassCreator_BehaviorDescriptor();
      case 2:
        return new ExtractStaticInnerClassConcept_BehaviorDescriptor();
      case 8:
        return new ExtractToConstantRefExpression_BehaviorDescriptor();
      case 21:
        return new WeakClassReference_BehaviorDescriptor();
      case 10:
        return new InternalAnonymousClassCreator_BehaviorDescriptor();
      case 9:
        return new InternalAnonymousClass_BehaviorDescriptor();
      default:
        return null;
    }
  }
}
