package jetbrains.mps.buildScript.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseScopeProvider;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class BuildVariableReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_b7yk30_a0a0a0a0a1a0b0a1a1 = new SNodePointer("r:5076fdb3-19c3-4563-aa26-7ace7591e78d(jetbrains.mps.buildScript.constraints)", "4903714810883713096");

  public BuildVariableReference_Constraints() {
    super("jetbrains.mps.buildScript.structure.BuildVariableReference");
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("name", new BasePropertyConstraintsDescriptor("name", this) {
      @Override
      public boolean hasOwnGetter() {
        return true;
      }

      @Override
      public Object getValue(SNode node, IScope scope) {
        String propertyName = "name";
        {
          String prefix = "";
          if (SNodeOperations.getAncestor(SLinkOperations.getTarget(node, "macro", false), "jetbrains.mps.buildScript.structure.BuildProject", false, false) != SNodeOperations.getAncestor(node, "jetbrains.mps.buildScript.structure.BuildProject", false, false)) {
            prefix = SPropertyOperations.getString(SNodeOperations.getAncestor(SLinkOperations.getTarget(node, "macro", false), "jetbrains.mps.buildScript.structure.BuildProject", false, false), "name") + ".";
          }
          return "${" + prefix + SPropertyOperations.getString(SLinkOperations.getTarget(node, "macro", false), "name") + "}";
        }
      }
    });
    return properties;
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
            return breakingNode_b7yk30_a0a0a0a0a1a0b0a1a1;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return Scope.getScope(_context.getContextNode(), _context.getContextRole(), _context.getPosition(), SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro"));
          }
        };
      }
    });
    return references;
  }
}
