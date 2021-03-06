package jetbrains.mps.baseLanguage.extensionMethods.constraints;

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
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ExtensionStaticFieldReference_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_xefsui_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:8a519067-4481-4fce-a84b-d7a47e974dd7(jetbrains.mps.baseLanguage.extensionMethods.constraints)", "3097384118511835569");

  public ExtensionStaticFieldReference_Constraints() {
    super("jetbrains.mps.baseLanguage.extensionMethods.structure.ExtensionStaticFieldReference");
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
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            SNode container = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.extensionMethods.structure.BaseExtensionMethodContainer", false, false);
            return SLinkOperations.getTargets(container, "staticFields", true);
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_xefsui_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    return references;
  }
}
