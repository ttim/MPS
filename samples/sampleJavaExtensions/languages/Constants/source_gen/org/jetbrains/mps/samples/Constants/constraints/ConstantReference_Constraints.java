package org.jetbrains.mps.samples.Constants.constraints;

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
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class ConstantReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_nqxbkv_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:af985d7a-c914-498c-96e5-c3fe0f4471b1(org.jetbrains.mps.samples.Constants.constraints)", "3990190717072399940");

  public ConstantReference_Constraints() {
    super("org.jetbrains.mps.samples.Constants.structure.ConstantReference");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("original", new BaseReferenceConstraintsDescriptor("original", this) {
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
            SNode root = SNodeOperations.getAncestor(_context.getEnclosingNode(), "org.jetbrains.mps.samples.Constants.structure.Constants", false, false);
            SNode parentConstant = SNodeOperations.getAncestor(_context.getEnclosingNode(), "org.jetbrains.mps.samples.Constants.structure.Constant", false, false);
            List<SNode> allConstants = SLinkOperations.getTargets(root, "constants", true);
            List<SNode> approved = new ArrayList<SNode>();
            for (int i = 0; i < ListSequence.fromList(allConstants).count(); i++) {
              SNode candidate = ListSequence.fromList(allConstants).getElement(i);
              if (candidate != parentConstant) {
                ListSequence.fromList(approved).addElement(candidate);
              } else {
                return approved;
              }
            }
            return allConstants;

          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_nqxbkv_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    return references;
  }
}
