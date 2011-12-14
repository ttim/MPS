package jetbrains.mps.lang.core.refactorings;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseLoggableRefactoring;
import jetbrains.mps.refactoring.framework.IRefactoringTarget;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.search.ConceptAndSuperConceptsScope;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.view.FindUtils;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.project.GlobalScope;

public class MoveNodes extends BaseLoggableRefactoring {
  public MoveNodes() {
    this.addTransientParameter("target");
    this.addTransientParameter("role");
    this.addTransientParameter("nodeToOpen");
  }

  public String getUserFriendlyName() {
    return "Move Nodes";
  }

  public String getKeyStroke() {
    return getKeyStroke_static();
  }

  public IRefactoringTarget getRefactoringTarget() {
    return new MoveNodes_Target();
  }

  public boolean init(final RefactoringContext refactoringContext) {
    ((RefactoringContext) refactoringContext).setLocal(true);

    if (!(MoveNodes.this.ask(refactoringContext, new MoveNodes_target_Chooser(refactoringContext)))) {
      return false;
    }

    final Wrappers._boolean result = new Wrappers._boolean(false);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (((Object) refactoringContext.getParameter("target")) instanceof SNode) {
          SNode targetNode = ((SNode) ((Object) refactoringContext.getParameter("target")));
          SNode concept = SNodeOperations.getConceptDeclaration(targetNode);
          ConceptAndSuperConceptsScope superConceptsScope = new ConceptAndSuperConceptsScope(concept);
          List<SNode> linkDeclarations = (List<SNode>) superConceptsScope.getLinkDeclarationsExcludingOverridden();
          Iterable<SNode> childLinkDeclarations = ListSequence.fromList(linkDeclarations).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return SPropertyOperations.hasValue(it, "metaClass", "aggregation", "reference");
            }
          });
          Iterable<String> childLinksRoles = Sequence.fromIterable(childLinkDeclarations).select(new ISelector<SNode, String>() {
            public String select(SNode it) {
              return SModelUtil.getGenuineLinkRole(it);
            }
          });
          for (SNode node : refactoringContext.getSelectedNodes()) {
            String childRole = node.getRole_();
            if (!(Sequence.fromIterable(childLinksRoles).contains(childRole))) {
              return;
            }
            for (SNode linkDeclaration : childLinkDeclarations) {
              if (SPropertyOperations.getString(linkDeclaration, "role").equals(childRole)) {
                if (!(SConceptOperations.isSuperConceptOf(SLinkOperations.getTarget(linkDeclaration, "target", false), NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(node))))) {
                  return;
                }
              }
            }
          }
          result.value = true;
        } else if (((Object) refactoringContext.getParameter("target")) instanceof SModelDescriptor) {
          for (SNode node : refactoringContext.getSelectedNodes()) {
            if (!(SNodeOperations.isInstanceOf(SNodeOperations.getConceptDeclaration(node), "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) || !(SPropertyOperations.getBoolean(SNodeOperations.getConceptDeclaration(node), "rootable"))) {
              return;
            }
          }
          result.value = true;
        }
      }
    });
    return result.value;
  }

  public void refactor(final RefactoringContext refactoringContext) {
    List<SNode> nodes = refactoringContext.getSelectedNodes();
    SModel targetModel = null;
    List<SNode> movedNodes = null;
    if (((Object) refactoringContext.getParameter("target")) instanceof SModelDescriptor) {
      targetModel = ((SModelDescriptor) ((Object) refactoringContext.getParameter("target"))).getSModel();
      movedNodes = refactoringContext.moveNodesToModel(nodes, targetModel);
    }
    if (((Object) refactoringContext.getParameter("target")) instanceof SNode) {
      SNode targetNode = (SNode) ((Object) refactoringContext.getParameter("target"));
      movedNodes = refactoringContext.moveNodesToNode(nodes, ListSequence.fromList(nodes).first().getRole_(), targetNode);
      targetModel = SNodeOperations.getModel(targetNode);
    }
    if (targetModel != null) {
      refactoringContext.setParameter("nodeToOpen", ListSequence.fromList(movedNodes).first());
    }
  }

  public List<SModel> getModelsToGenerate(final RefactoringContext refactoringContext) {
    List<SModel> result = (List<SModel>) refactoringContext.getModelsFromUsages(refactoringContext.getSelectedModel().getSModel());
    if (((Object) refactoringContext.getParameter("target")) instanceof SModelDescriptor) {
      SModel model = ((SModelDescriptor) ((Object) refactoringContext.getParameter("target"))).getSModel();
      if (model != null && !(ListSequence.fromList(result).contains(model))) {
        ListSequence.fromList(result).addElement(model);
      }
    }
    return result;
  }

  public void doWhenDone(final RefactoringContext refactoringContext) {
    // todo: open target nodes 
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    SearchResults searchResults = new SearchResults();
    for (SNode selNode : ListSequence.fromList(refactoringContext.getSelectedNodes())) {
      searchResults.addAll(FindUtils.getSearchResults(new EmptyProgressIndicator(), selNode, GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder"));
    }
    return searchResults;
  }

  public void updateModel(final SModel model, final RefactoringContext refactoringContext) {
    refactoringContext.updateByDefault(model);
  }

  public static String getKeyStroke_static() {
    return " F6";
  }
}
