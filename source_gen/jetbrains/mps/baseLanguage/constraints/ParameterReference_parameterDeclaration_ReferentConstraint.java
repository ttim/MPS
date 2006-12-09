package jetbrains.mps.baseLanguage.constraints;

/*Generated by MPS  */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class ParameterReference_parameterDeclaration_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public  ParameterReference_parameterDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.ParameterReference", "variableDeclaration", this);
  }
  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.structure.ParameterReference", "variableDeclaration");
  }
  public boolean canCreateNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    SNode enclosingMethod = SNodeOperations.getParent(enclosingNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", true, false);
    return enclosingMethod != null;
  }
  public ISearchScope createNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    SNode enclosingMethod = SNodeOperations.getParent(enclosingNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", true, false);
    return new SimpleSearchScope(SLinkOperations.getTargets(enclosingMethod, "parameter", true));
  }
  public String getNodeReferentSearchScopeDescription() {
    return "parameters declared in enclosing method";
  }
}
