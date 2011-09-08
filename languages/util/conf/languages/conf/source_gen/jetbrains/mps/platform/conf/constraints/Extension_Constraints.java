package jetbrains.mps.platform.conf.constraints;

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
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class Extension_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_uaqgor_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:2fe958f4-f755-4faa-af2a-c5125dc0cfc1(jetbrains.mps.platform.conf.constraints)", "8515964913726301651");

  public Extension_Constraints() {
    super("jetbrains.mps.platform.conf.structure.Extension");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("extensionPoint", new BaseReferenceConstraintsDescriptor("extensionPoint", this) {
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
            return Sequence.fromIterable(ConfUtil.visibleConfModels(operationContext.getScope())).translate(new ITranslator2<SModel, SNode>() {
              public Iterable<SNode> translate(SModel m) {
                return SModelOperations.getNodes(m, "jetbrains.mps.platform.conf.structure.ExtensionPoint");
              }
            });
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_uaqgor_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    return references;
  }
}
