package jetbrains.mps.xmlQuery.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import java.util.Map;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class XMLSAXAttributeReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:e79b58b4-ea58-4c9d-b43b-c3a260addf6a(jetbrains.mps.xmlQuery.constraints)", "2286463592495220224");
  private static SNodePointer breakingNode_4osf4s_a0a1a0a0a1a0b0a1a2 = new SNodePointer("r:e79b58b4-ea58-4c9d-b43b-c3a260addf6a(jetbrains.mps.xmlQuery.constraints)", "2286463592495228153");

  public XMLSAXAttributeReference_Constraints() {
    super("jetbrains.mps.xmlQuery.structure.XMLSAXAttributeReference");
  }

  @Override
  public boolean hasOwnCanBeChildMethod() {
    return true;
  }

  @Override
  public boolean canBeChild(@Nullable SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext, @Nullable final CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAChild(node, parentNode, link, childConcept, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
    }

    return result;
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("attribute", new BaseReferenceConstraintsDescriptor("attribute", this) {
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
            SNode creator = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.xmlQuery.structure.XMLSAXNodeCreator", true, false);
            List<SNode> n = ListSequence.fromList(new ArrayList<SNode>());
            if ((creator != null) && SNodeOperations.isInstanceOf(SNodeOperations.getParent(creator), "jetbrains.mps.xmlQuery.structure.XMLSAXNodeRule")) {
              ListSequence.fromList(n).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(SNodeOperations.getParent(creator), "jetbrains.mps.xmlQuery.structure.XMLSAXNodeRule"), "attrs", true)).where(new IWhereFilter<SNode>() {
                public boolean accept(SNode it) {
                  return SPropertyOperations.getBoolean(it, "isRequired");
                }
              }));
            }
            return n;
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_4osf4s_a0a1a0a0a1a0b0a1a2;
          }
        };
      }
    });
    return references;
  }

  public static boolean static_canBeAChild(SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext) {
    return (SNodeOperations.getAncestor(parentNode, "jetbrains.mps.xmlQuery.structure.XMLSAXNodeCreator", true, false) != null);
  }
}
