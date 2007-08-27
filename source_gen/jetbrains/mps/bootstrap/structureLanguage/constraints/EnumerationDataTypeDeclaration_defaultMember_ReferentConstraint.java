package jetbrains.mps.bootstrap.structureLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.SubnodesSearchScope;

public class EnumerationDataTypeDeclaration_defaultMember_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public  EnumerationDataTypeDeclaration_defaultMember_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationDataTypeDeclaration", "defaultMember", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationDataTypeDeclaration", "defaultMember");
  }

  public boolean canCreateNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    return referenceNode != null;
  }

  public ISearchScope createNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    return new SubnodesSearchScope(referenceNode);
  }

  public String getNodeReferentSearchScopeDescription() {
    return "members declared here";
  }

}
