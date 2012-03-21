package jetbrains.mps.lang.scopes.constraints;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.scopes.SimpleScope;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;

public class ComeFromExpression_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_t1q7r2_a0a0a0a0a1a0b0a1a0 = new SNodePointer("r:ff944d67-5440-4132-a4a9-2198c9221961(jetbrains.mps.lang.scopes.constraints)", "8077936094962945825");

  public ComeFromExpression_Constraints() {
    super("jetbrains.mps.lang.scopes.structure.ComeFromExpression");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("link", new BaseReferenceConstraintsDescriptor("link", this) {
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
            return breakingNode_t1q7r2_a0a0a0a0a1a0b0a1a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            // todo: use new scopes =) 
            SNode concept = SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getContextNode(), "jetbrains.mps.lang.behavior.structure.ConceptBehavior", false, false), "concept", false);
            return new SimpleScope(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(concept));
          }
        };
      }
    });
    return references;
  }
}
