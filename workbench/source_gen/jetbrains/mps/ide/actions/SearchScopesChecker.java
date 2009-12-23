package jetbrains.mps.ide.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.constraints.SearchScopeStatus;
import jetbrains.mps.smodel.constraints.ModelConstraintsUtil;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;

public class SearchScopesChecker extends SpecificChecker {
  public SearchScopesChecker() {
  }

  public List<SearchResult<ModelCheckerIssue>> checkModel(SModel model, ProgressContext progressContext, IOperationContext operationContext) {
    List<SearchResult<ModelCheckerIssue>> results = ListSequence.fromList(new ArrayList<SearchResult<ModelCheckerIssue>>());

    for (SNode node : ListSequence.fromList(SModelOperations.getNodes(model, null))) {
      if (!(progressContext.checkAndUpdateIndicator("Checking " + SModelOperations.getModelName(model) + " for valid search scopes in references..."))) {
        break;
      }
      SNode concept = SNodeOperations.getConceptDeclaration(node);

      for (SReference ref : ListSequence.fromList(SNodeOperations.getReferences(node)).where(new IWhereFilter<SReference>() {
        public boolean accept(SReference it) {
          return ModelCheckerUtils.isDeclaredLink(SLinkOperations.findLinkDeclaration(it), false) && (SLinkOperations.getTargetNode(it) != null);
        }
      })) {
        SNode targetNode = SLinkOperations.getTargetNode(ref);
        try {
          SNode genuineLinkDeclaration = LinkDeclaration_Behavior.call_getGenuineLink_1213877254523(SLinkOperations.findLinkDeclaration(ref));

          IModule thisModelModule = model.getModelDescriptor().getModule();
          if (checkScope(concept, node, targetNode, genuineLinkDeclaration, operationContext)) {
          } else if (checkScope(concept, node, targetNode, genuineLinkDeclaration, new ModuleContext(thisModelModule, operationContext.getMPSProject()))) {
          } else {
            addIssue(results, node, "Reference in role \"" + SPropertyOperations.getString(genuineLinkDeclaration, "role") + "\" is out of search scope", ModelChecker.CATEGORY_WARNING, null);
          }
        } catch (Exception e) {
          e.printStackTrace();
          addIssue(results, node, "Exception \"" + e.getMessage() + "\" during search scope checking", ModelChecker.CATEGORY_WARNING, null);
        }
      }
    }

    return results;
  }

  private static boolean checkScope(SNode concept, SNode node, SNode targetNode, SNode linkDeclaration, IOperationContext operationContext) {
    SearchScopeStatus status = ModelConstraintsUtil.getSearchScope(null, node, ((AbstractConceptDeclaration) SNodeOperations.getAdapter(concept)), ((LinkDeclaration) SNodeOperations.getAdapter(linkDeclaration)), operationContext);
    if (status.isOk() && !(status.isDefault())) {
      List<SNode> nodes = status.getSearchScope().getNodes();
      if (!(ListSequence.fromList(nodes).contains(targetNode))) {
        return false;
      }
    }
    return true;
  }
}
