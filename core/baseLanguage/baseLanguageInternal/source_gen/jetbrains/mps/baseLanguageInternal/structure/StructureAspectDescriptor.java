package jetbrains.mps.baseLanguageInternal.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListInnerExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassConcept", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassCreator", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethodExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethod_CallExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantExpression", "jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantRefExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass", "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClassCreator", "jetbrains.mps.baseLanguageInternal.structure.InternalClassExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalClassifierType", "jetbrains.mps.baseLanguageInternal.structure.InternalNewExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalPartialFieldReference", "jetbrains.mps.baseLanguageInternal.structure.InternalPartialInstanceMethodCall", "jetbrains.mps.baseLanguageInternal.structure.InternalStaticFieldReference", "jetbrains.mps.baseLanguageInternal.structure.InternalStaticMethodCall", "jetbrains.mps.baseLanguageInternal.structure.InternalThisExpression", "jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference", "jetbrains.mps.baseLanguageInternal.structure.TypeHintExpression", "jetbrains.mps.baseLanguageInternal.structure.WeakClassReference"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStatementListInnerExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.ILocalVariableElement"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassConcept", "jetbrains.mps.baseLanguage.structure.ClassConcept", false, new String[]{"jetbrains.mps.baseLanguage.structure.ClassConcept"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassCreator", "jetbrains.mps.baseLanguage.structure.ClassCreator", false, new String[]{"jetbrains.mps.baseLanguage.structure.ClassCreator"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"makeUnique", "nonStatic"}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethodExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"makeUnique"}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractStaticMethod_CallExpression", "jetbrains.mps.baseLanguage.structure.BaseMethodCall", false, new String[]{"jetbrains.mps.baseLanguage.structure.BaseMethodCall"}, new String[]{}, new String[]{"staticMethodDeclaration"});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"fieldName", "makeUnique"}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.ExtractToConstantRefExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"original"});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass", "jetbrains.mps.baseLanguage.structure.ClassConcept", false, new String[]{"jetbrains.mps.baseLanguage.structure.ClassConcept", "jetbrains.mps.baseLanguage.structure.IAnonymousClass", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter"}, new String[]{"fqClassName"}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClassCreator", "jetbrains.mps.baseLanguage.structure.AbstractCreator", false, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractCreator"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalClassExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalClassifierType", "jetbrains.mps.baseLanguage.structure.ClassifierType", false, new String[]{"jetbrains.mps.baseLanguage.structure.ClassifierType"}, new String[]{"fqClassName"}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalNewExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"fqClassName"}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalPartialFieldReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IOperation"}, new String[]{"fieldName"}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalPartialInstanceMethodCall", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IOperation"}, new String[]{"methodName"}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalStaticFieldReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"fqClassName", "fieldName"}, new String[]{});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalStaticMethodCall", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"fqClassName", "methodName"}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalThisExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{"name"}, new String[]{});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.TypeHintExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 21:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguageInternal.structure.WeakClassReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{"classifier"});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
