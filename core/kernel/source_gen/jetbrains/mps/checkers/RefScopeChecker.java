package jetbrains.mps.checkers;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SNodeUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsUtil;
import jetbrains.mps.smodel.constraints.SearchScopeStatus;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.errors.messageTargets.ReferenceMessageTarget;

public class RefScopeChecker extends AbstractConstraintsChecker {
  public RefScopeChecker() {
  }

  public void checkNode(final SNode node, LanguageErrorsComponent component, final IOperationContext operationContext, IScope scope) {
    if (operationContext == null) {
      return;
    }
    if (SNodeUtil.getMetaLevel(node) != 0) {
      return;
    }
    SNode concept = SNodeOperations.getConceptDeclaration(node);
    for (SReference ref : SNodeOperations.getReferences(node)) {
      SNode target = SLinkOperations.getTargetNode(ref);
      SNode ld = SLinkOperations.findLinkDeclaration(ref);
      // don't check unresolved and broken references, they should already have an error message 
      if ((target == null) || ld == null) {
        continue;
      }
      component.addDependency(target);
      component.addDependency(ld);
      component.addDependency(node);
      component.addDependency(SNodeOperations.getParent(node));
      for (SNode c : SNodeOperations.getChildren(node)) {
        component.addDependency(c);
      }
      String linkRole = SModelUtil.getGenuineLinkRole(ld);
      final SNode linkTarget = SLinkOperations.getTarget(ld, "target", false);
      final INodeReferentSearchScopeProvider scopeProvider = ModelConstraintsUtil.getSearchScopeProvider(concept, linkRole);
      SearchScopeStatus searchScopeStatus = component.runCheckingAction(new _FunctionTypes._return_P0_E0<SearchScopeStatus>() {
        public SearchScopeStatus invoke() {
          return ModelConstraintsUtil.createSearchScope(scopeProvider, SNodeOperations.getModel(node), SNodeOperations.getParent(node), node, linkTarget, SNodeOperations.getContainingLinkDeclaration(node), operationContext);
        }
      });
      if (searchScopeStatus.isError()) {
        component.addError(node, searchScopeStatus.getMessage(), (SNode) null, new ReferenceMessageTarget(SLinkOperations.getRole(ref)));
      } else if (!(searchScopeStatus.isDefault() || searchScopeStatus.getSearchScope().isInScope(target))) {
        String name = target.getName();
        component.addError(node, "reference" + ((name == null ?
          "" :
          " " + name
        )) + " (" + SLinkOperations.getRole(ref) + ") is out of search scope", searchScopeStatus.getReferenceValidatorNode(), new ReferenceMessageTarget(SLinkOperations.getRole(ref)));
      }
    }
  }
}
