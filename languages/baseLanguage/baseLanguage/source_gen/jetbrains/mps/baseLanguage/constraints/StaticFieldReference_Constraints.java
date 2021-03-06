package jetbrains.mps.baseLanguage.constraints;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.scope.EmptyScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopes;

public class StaticFieldReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_amrbnf_a0a0a0a0a1a0b0a1a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)", "7898359107948137439");
  private static SNodePointer breakingNode_amrbnf_a0a0a0a0a1a0b0a2a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)", "7898359107948137459");

  public StaticFieldReference_Constraints() {
    super("jetbrains.mps.baseLanguage.structure.StaticFieldReference");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("variableDeclaration", new BaseReferenceConstraintsDescriptor("variableDeclaration", this) {
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
            return breakingNode_amrbnf_a0a0a0a0a1a0b0a1a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            if (!(SNodeOperations.isInstanceOf(_context.getContextNode(), "jetbrains.mps.baseLanguage.structure.StaticFieldReference"))) {
              return new EmptyScope();
            }
            if ((SLinkOperations.getTarget(SNodeOperations.cast(_context.getContextNode(), "jetbrains.mps.baseLanguage.structure.StaticFieldReference"), "classifier", false) == null)) {
              return new EmptyScope();
            }
            return Classifier_Behavior.call_getVisibleMembers_8083692786967356611(SLinkOperations.getTarget(SNodeOperations.cast(_context.getContextNode(), "jetbrains.mps.baseLanguage.structure.StaticFieldReference"), "classifier", false), _context.getContextNode(), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"));
          }
        };
      }
    });
    references.put("classifier", new BaseReferenceConstraintsDescriptor("classifier", this) {
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
            return breakingNode_amrbnf_a0a0a0a0a1a0b0a2a0;
          }

          @Override
          public Scope createScope(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return ClassifierScopes.getClassesForStaticFieldReference(_context.getContextNode(), operationContext.getScope());
          }
        };
      }
    });
    return references;
  }
}
