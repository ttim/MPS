package jetbrains.mps.lang.typesystem.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;

public class SimpleRule_ProcedureCall_procedureDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public SimpleRule_ProcedureCall_procedureDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.SimpleRule_ProcedureCall", "procedureDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.typesystem.structure.SimpleRule_ProcedureCall", "procedureDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode conceptDeclaration = SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getReferenceNode(), "conceptReference", true), "concept", false);
    if ((conceptDeclaration != null)) {
      return AbstractConceptDeclaration_Behavior.call_getReferenceLinkDeclarations_1213877394496(conceptDeclaration);
    }
    return new ArrayList<SNode>();
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)", "1223057283782");
  }
}
