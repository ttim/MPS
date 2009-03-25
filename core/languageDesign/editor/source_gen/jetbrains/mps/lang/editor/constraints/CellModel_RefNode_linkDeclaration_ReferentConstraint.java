package jetbrains.mps.lang.editor.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;

public class CellModel_RefNode_linkDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {

  public CellModel_RefNode_linkDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.editor.structure.CellModel_RefNode", "relationDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.editor.structure.CellModel_RefNode", "relationDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    //     aggregation links declared in concept hierarchy and not overridden
    SNode editorComponent = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.editor.structure.BaseEditorComponent", true, false);
    SNode editedConcept = SLinkOperations.getTarget(editorComponent, "conceptDeclaration", false);
    List<SNode> links = AbstractConceptDeclaration_Behavior.call_getAggregationLinkDeclarations_1213877394521(editedConcept);
    return new SimpleSearchScope(ListSequence.fromList(links).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return LinkDeclaration_Behavior.call_isSingular_1213877254557(it);
      }
    }).toListSequence());
  }

}
