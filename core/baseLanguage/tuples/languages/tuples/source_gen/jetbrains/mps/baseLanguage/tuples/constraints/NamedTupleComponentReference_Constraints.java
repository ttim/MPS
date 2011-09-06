package jetbrains.mps.baseLanguage.tuples.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Map;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseReferenceScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.tuples.behavior.NamedTupleDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ITranslator2;

public class NamedTupleComponentReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_2jtvdm_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:3d04bd03-b6d9-4be1-8a52-d7b756e1d85b(jetbrains.mps.baseLanguage.tuples.constraints)", "1239575924538");

  public NamedTupleComponentReference_Constraints() {
    super("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleComponentReference");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("componentDeclaration", new BaseReferenceConstraintsDescriptor("componentDeclaration", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            return ListSequence.fromList(NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(SLinkOperations.getTarget(SNodeOperations.as(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleLiteral"), "tupleDeclaration", false))).reversedList().<SNode>translate(new ITranslator2<SNode, SNode>() {
              public Iterable<SNode> translate(SNode ntd) {
                return SLinkOperations.getTargets(ntd, "component", true);
              }
            });
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_2jtvdm_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    return references;
  }
}
