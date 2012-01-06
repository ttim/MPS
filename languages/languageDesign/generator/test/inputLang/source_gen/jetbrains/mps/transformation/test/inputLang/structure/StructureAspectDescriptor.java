package jetbrains.mps.transformation.test.inputLang.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.transformation.test.inputLang.structure.ExpressionToReduceToStatement", "jetbrains.mps.transformation.test.inputLang.structure.InputNode", "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A", "jetbrains.mps.transformation.test.inputLang.structure.InputNode_B", "jetbrains.mps.transformation.test.inputLang.structure.InputNode_C", "jetbrains.mps.transformation.test.inputLang.structure.InputRoot", "jetbrains.mps.transformation.test.inputLang.structure.InputRootWithStatementList", "jetbrains.mps.transformation.test.inputLang.structure.RefTestClass", "jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression", "jetbrains.mps.transformation.test.inputLang.structure.RefTestMethod", "jetbrains.mps.transformation.test.inputLang.structure.RefTestMethodCall", "jetbrains.mps.transformation.test.inputLang.structure.RefTestParam", "jetbrains.mps.transformation.test.inputLang.structure.RefTestParamRef"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.ExpressionToReduceToStatement", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputNode", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputNode_A", "jetbrains.mps.transformation.test.inputLang.structure.InputNode", false, new String[]{"jetbrains.mps.transformation.test.inputLang.structure.InputNode"}, new String[]{"option"}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputNode_B", "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A", false, new String[]{"jetbrains.mps.transformation.test.inputLang.structure.InputNode_A"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputNode_C", "jetbrains.mps.transformation.test.inputLang.structure.InputNode_B", false, new String[]{"jetbrains.mps.transformation.test.inputLang.structure.InputNode_B"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputRoot", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{"useInTest"}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.InputRootWithStatementList", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{"useInTest"}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestClass", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.lang.core.structure.ScopeProvider"}, new String[]{}, new String[]{"extends"});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestMethod", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.lang.core.structure.ScopeProvider"}, new String[]{}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestMethodCall", "jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression", false, new String[]{"jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression"}, new String[]{}, new String[]{"method"});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestParam", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.transformation.test.inputLang.structure.RefTestParamRef", "jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression", false, new String[]{"jetbrains.mps.transformation.test.inputLang.structure.RefTestExpression"}, new String[]{}, new String[]{"declaration"});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
