package jetbrains.mps.baseLanguage.closures.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.baseLanguage.closures.structure.AbstractFunctionType", "jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.CompactInvokeFunctionExpression", "jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionContainer", "jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionDeclaration", "jetbrains.mps.baseLanguage.closures.structure.ControlClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.FunctionMethodDeclaration", "jetbrains.mps.baseLanguage.closures.structure.FunctionType", "jetbrains.mps.baseLanguage.closures.structure.InvokeExpression", "jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression", "jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation", "jetbrains.mps.baseLanguage.closures.structure.PairOfInts", "jetbrains.mps.baseLanguage.closures.structure.StringPropertyHolder", "jetbrains.mps.baseLanguage.closures.structure.UnboundClosureParameterDeclaration", "jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType", "jetbrains.mps.baseLanguage.closures.structure.YieldAllStatement", "jetbrains.mps.baseLanguage.closures.structure.YieldStatement"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.AbstractFunctionType", "jetbrains.mps.baseLanguage.structure.Type", false, new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement", "jetbrains.mps.baseLanguage.structure.Statement", false, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{"controlMethod"});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.baseLanguage.structure.IStatementListContainer", "jetbrains.mps.baseLanguage.structure.IContainsStatementList", "jetbrains.mps.baseLanguage.structure.IMethodLike", "jetbrains.mps.baseLanguage.structure.IFinalWrapper", "jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter"}, new String[]{"forceMultiLine"}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.CompactInvokeFunctionExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionContainer", "jetbrains.mps.baseLanguage.structure.Classifier", false, new String[]{"jetbrains.mps.baseLanguage.structure.Classifier"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlAbstractionDeclaration", "jetbrains.mps.baseLanguage.structure.GenericDeclaration", false, new String[]{"jetbrains.mps.baseLanguage.structure.GenericDeclaration", "jetbrains.mps.baseLanguage.structure.ClassifierMember", "jetbrains.mps.lang.core.structure.IResolveInfo", "jetbrains.mps.baseLanguage.structure.HasAnnotation"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.ControlClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral", false, new String[]{"jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral"}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.FunctionMethodDeclaration", "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", false, new String[]{"jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.FunctionType", "jetbrains.mps.baseLanguage.structure.Type", false, new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"runtimeIface"});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression"}, new String[]{}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionExpression", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.lang.core.structure.IDeprecatable"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.baseLanguage.structure.IOperation"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.PairOfInts", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"first", "second"}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.StringPropertyHolder", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"value"}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnboundClosureParameterDeclaration", "jetbrains.mps.baseLanguage.structure.ParameterDeclaration", false, new String[]{"jetbrains.mps.baseLanguage.structure.ParameterDeclaration"}, new String[]{}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedClosureLiteral", "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", false, new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"}, new String[]{}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.UnrestrictedFunctionType", "jetbrains.mps.baseLanguage.closures.structure.FunctionType", false, new String[]{"jetbrains.mps.baseLanguage.closures.structure.FunctionType"}, new String[]{}, new String[]{});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.YieldAllStatement", "jetbrains.mps.baseLanguage.structure.Statement", false, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.baseLanguage.closures.structure.YieldStatement", "jetbrains.mps.baseLanguage.structure.Statement", false, new String[]{"jetbrains.mps.baseLanguage.structure.Statement"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
