package jetbrains.mps.build.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Map;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseScopeProvider;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class BuildVarRefStringPart_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_99t0ze_a0a0a0a0a1a0b0a1a0 = new SNodePointer("r:5076fdb3-19c3-4563-aa26-7ace7591e78d(jetbrains.mps.build.constraints)", "4903714810883713096");

  public BuildVarRefStringPart_Constraints() {
    super("jetbrains.mps.build.structure.BuildVarRefStringPart");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("macro", new BaseReferenceConstraintsDescriptor("macro", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseScopeProvider() {
          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_99t0ze_a0a0a0a0a1a0b0a1a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return Scope.getScope(_context.getContextNode(), _context.getContextRole(), _context.getPosition(), SConceptOperations.findConceptDeclaration("jetbrains.mps.build.structure.BuildMacro"));
          }
        };
      }
    });
    return references;
  }
}
