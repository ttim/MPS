package jetbrains.mps.build.mps.constraints;

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
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.scope.EmptyScope;
import jetbrains.mps.scope.SimpleRoleScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class BuildMps_IdeaPluginGroupCustomModule_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_q09jue_a0a0a0a0a1a0b0a1a0 = new SNodePointer("r:76dda237-5120-4688-b749-201ab5c5059d(jetbrains.mps.build.mps.constraints)", "4034578608468929486");

  public BuildMps_IdeaPluginGroupCustomModule_Constraints() {
    super("jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroupCustomModule");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("target", new BaseReferenceConstraintsDescriptor("target", this) {
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
            return breakingNode_q09jue_a0a0a0a0a1a0b0a1a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            {
              SNode group = (SNodeOperations.isInstanceOf(_context.getContextNode(), "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroup") ?
                SNodeOperations.cast(_context.getContextNode(), "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroup") :
                SNodeOperations.as(SNodeOperations.getParent(_context.getContextNode()), "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroup")
              );
              if ((group == null)) {
                return new EmptyScope();
              }
              return SimpleRoleScope.forNamedElements(SLinkOperations.getTarget(group, "group", false), SLinkOperations.findLinkDeclaration("jetbrains.mps.build.mps.structure.BuildMps_Group", "modules"));
            }
          }
        };
      }
    });
    return references;
  }
}
