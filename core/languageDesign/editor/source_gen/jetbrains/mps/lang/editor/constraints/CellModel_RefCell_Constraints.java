package jetbrains.mps.lang.editor.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.behavior.AbstractComponent_Behavior;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class CellModel_RefCell_Constraints extends ConstraintsDataHolder {
  public CellModel_RefCell_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.editor.structure.CellModel_RefCell";
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("relationDeclaration", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        // singular links declared in concept hierarchy and not overridden 
        SNode editorComponent = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.editor.structure.BaseEditorComponent", true, false);
        SNode editedConcept = AbstractComponent_Behavior.call_getConceptDeclaration_7055725856388417603(editorComponent);
        List<SNode> links = AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(editedConcept);
        return ListSequence.fromList(links).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return LinkDeclaration_Behavior.call_isSingular_1213877254557(it);
          }
        }).toListSequence();
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c89590298(jetbrains.mps.lang.editor.constraints)", "1213104846436");
      }
    });
    return result;
  }
}
