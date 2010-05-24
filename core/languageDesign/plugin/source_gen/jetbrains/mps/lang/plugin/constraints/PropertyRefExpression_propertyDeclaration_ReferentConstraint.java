package jetbrains.mps.lang.plugin.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class PropertyRefExpression_propertyDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public PropertyRefExpression_propertyDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.plugin.structure.PropertyRefExpression", "propertyDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.plugin.structure.PropertyRefExpression", "propertyDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    if (!(SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getReferenceNode(), "nodeExpr", true)), "jetbrains.mps.lang.smodel.structure.SNodeType"))) {
      return new ArrayList<SNode>();
    }
    return AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(SLinkOperations.getTarget(SNodeOperations.cast(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getReferenceNode(), "nodeExpr", true)), "jetbrains.mps.lang.smodel.structure.SNodeType"), "concept", false));
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590361(jetbrains.mps.lang.plugin.constraints)", "1628770029971140585");
  }
}
