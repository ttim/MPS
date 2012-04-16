package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseScopeProvider;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopes;

public class Annotation_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_9e1z83_a0a0a0a0a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)", "7898359107948133146");

  public Annotation_Constraints() {
    super("jetbrains.mps.baseLanguage.structure.Annotation");
  }

  @Override
  public boolean hasOwnDefaultScopeProvider() {
    return true;
  }

  @Override
  public ReferenceScopeProvider getDefaultScopeProvider() {
    return new BaseScopeProvider() {
      @Override
      public SNodePointer getSearchScopeValidatorNode() {
        return breakingNode_9e1z83_a0a0a0a0a1;
      }

      @Override
      public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
        return ClassifierScopes.getAnnotationClassifiersScope(_context.getContextNode(), operationContext.getScope());
      }
    };
  }
}
