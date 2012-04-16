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

public class Interface_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_y7fug_a0a0a0a0a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)", "7898359107948137248");

  public Interface_Constraints() {
    super("jetbrains.mps.baseLanguage.structure.Interface");
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
        return breakingNode_y7fug_a0a0a0a0a1;
      }

      @Override
      public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
        return ClassifierScopes.getVisibleInterfacesScope(_context.getContextNode(), operationContext.getScope());
      }
    };
  }
}
