package jetbrains.mps.buildlanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.buildlanguage.behavior.IPropertyHolder_Behavior;
import jetbrains.mps.smodel.search.SimpleSearchScope;

public class PropertyReference_propertyDeclaration_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public PropertyReference_propertyDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.buildlanguage.structure.PropertyReference", "propertyDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.buildlanguage.structure.PropertyReference", "propertyDeclaration");
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> result = new ArrayList<SNode>();
    for(SNode holder : SNodeOperations.getAncestors(_context.getEnclosingNode(), "jetbrains.mps.buildlanguage.structure.IPropertyHolder", true)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(IPropertyHolder_Behavior.call_getProperties_1213877375726(holder)));
    }
    return new SimpleSearchScope(result);
  }

}
