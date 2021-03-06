package jetbrains.mps.lang.editor.constraints;

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
import jetbrains.mps.lang.editor.behavior.AbstractComponent_Behavior;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;

public class CellMenuComponentFeature_Link_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_1eovyz_a0a1a0a0a1a0b0a1a0 = new SNodePointer("r:00000000-0000-4000-0000-011c89590298(jetbrains.mps.lang.editor.constraints)", "1213104846220");

  public CellMenuComponentFeature_Link_Constraints() {
    super("jetbrains.mps.lang.editor.structure.CellMenuComponentFeature_Link");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("relationDeclaration", new BaseReferenceConstraintsDescriptor("relationDeclaration", this) {
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
            // links declared in edited concept' hierarchy and not overridden 
            SNode editorComponent = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.editor.structure.CellMenuComponent", true, false);
            SNode editedConcept = AbstractComponent_Behavior.call_getConceptDeclaration_7055725856388417603(editorComponent);
            return AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(editedConcept);
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_1eovyz_a0a1a0a0a1a0b0a1a0;
          }
        };
      }
    });
    return references;
  }
}
