package webr.xml.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.SModelSearchUtil_new;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import webr.xmlSchema.constraints.ElementDeclaration_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class Attribute_attributeDeclaration_ReferentConstraint implements IModelConstraints, INodeReferentSearchScopeProvider {

  public  Attribute_attributeDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("webr.xml.structure.Attribute", "attributeDeclaration", this);
  }
  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("webr.xml.structure.Attribute", "attributeDeclaration");
  }
  public boolean canCreateNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    return true;
  }
  public ISearchScope createNodeReferentSearchScope(SModel model, SNode enclosingNode, SNode referenceNode, IScope scope) {
    ISearchScope searchScope;
    SNode element = SNodeOperations.getAncestor(enclosingNode, "webr.xml.structure.Element", false, false);
    if((element == null)) {
      searchScope = SModelSearchUtil_new.createModelAndImportedModelsScope(model, scope);
    } else
    {
      searchScope = new SimpleSearchScope(ElementDeclaration_Behavior.getAttributeDeclarations_1183587644932(SLinkOperations.getTarget(element, "elementDeclaration", false)));
    }
    return searchScope;
  }
  public String getNodeReferentSearchScopeDescription() {
    return "<no description>";
  }
}
