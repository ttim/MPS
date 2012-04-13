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
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferencePresentationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.build.util.ScopeUtil;
import jetbrains.mps.scope.ModelPlusImportedScope;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.build.workflow.behavior.FilteringScope;

public class BuildLayout_ImportContent_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_cl5pbm_a0a2a0a0a1a0b0a1a0 = new SNodePointer("r:5076fdb3-19c3-4563-aa26-7ace7591e78d(jetbrains.mps.build.constraints)", "5610619299013068425");

  public BuildLayout_ImportContent_Constraints() {
    super("jetbrains.mps.build.structure.BuildLayout_ImportContent");
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
          public boolean hasPresentation() {
            return true;
          }

          @Override
          public String getPresentation(final IOperationContext operationContext, final ReferencePresentationContext _context) {
            SNode contextProject = SNodeOperations.getAncestor(_context.getContextNode(), "jetbrains.mps.build.structure.BuildProject", true, false);
            String target = null;
            if ((contextProject != null)) {
              Scope importedArtifactsScope = ScopeUtil.getVisibleArtifactsScope(contextProject);
              if (importedArtifactsScope != null && !(importedArtifactsScope instanceof ModelPlusImportedScope)) {
                target = importedArtifactsScope.getReferenceText(_context.getContextNode(), _context.getParameterNode());
              }
            }
            if (target == null) {
              target = BaseConcept_Behavior.call_getPresentation_1213877396640(_context.getParameterNode());
            }
            return (_context.getSmartReference() ?
              "import " + target :
              target
            );
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_cl5pbm_a0a2a0a0a1a0b0a1a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            SNode contextProject = SNodeOperations.getAncestor(_context.getContextNode(), "jetbrains.mps.build.structure.BuildProject", true, false);
            if ((contextProject != null)) {
              return new FilteringScope(ScopeUtil.getVisibleArtifactsScope(contextProject)) {
                @Override
                public boolean isExcluded(SNode node) {
                  return !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildLayout_Container"));
                }
              };
            }
            return new ModelPlusImportedScope(_context.getModel(), false, operationContext.getScope(), "jetbrains.mps.build.structure.BuildLayout_Node");
          }
        };
      }
    });
    return references;
  }
}
