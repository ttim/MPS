package jetbrains.mps.ide.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.project.ProjectHelper;
import java.util.Iterator;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.refactoring.framework.IRefactoring;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;

public class DeleteNodesHelper {
  private List<SNode> myNodes;
  private IOperationContext myContext;
  private boolean mySafe;

  public DeleteNodesHelper(List<SNode> nodes, IOperationContext context, boolean safe) {
    myNodes = nodes;
    myContext = context;
    mySafe = safe;
  }

  public void deleteNodes(boolean fromProjectPane) {
    if (myNodes.size() == 0) {
      return;
    }
    ProjectPane projectPane = ProjectPane.getInstance(ProjectHelper.toIdeaProject(myContext.getProject()));
    if (myNodes.size() == 1) {
      deleteSingle(projectPane, fromProjectPane, myNodes.get(0));
    } else {
      deleteMultiple(fromProjectPane, projectPane);
    }
  }

  private void deleteMultiple(boolean fromProjectPane, ProjectPane projectPane) {
    for (Iterator<SNode> iterator = myNodes.iterator(); iterator.hasNext();) {
      SNode sNode = iterator.next();
      if (!(iterator.hasNext()) && fromProjectPane) {
        projectPane.rebuildTree();
        projectPane.selectNextNode(sNode);
      }
      doDeleteNode(sNode);
    }
  }

  private void deleteSingle(ProjectPane projectPane, boolean fromProjectPane, SNode node) {
    MPSTreeNode nextNode = null;
    fromProjectPane = fromProjectPane && projectPane.getTree() != null;
    if (fromProjectPane) {
      nextNode = projectPane.findNextTreeNode(node);
    }
    doDeleteNode(node);
    if (!(mySafe) && fromProjectPane) {
      projectPane.getTree().selectNode(nextNode);
    }
  }

  private void doDeleteNode(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration") && node.isRoot()) {
      if (mySafe) {
        safeDelete(myContext, node);
      } else {
        delete(node);
      }
    } else {
      delete(node);
    }
  }

  private void delete(SNode node) {
    node.delete();
  }

  private void safeDelete(final IOperationContext context, final SNode node) {
    String refactoringClass;
    if ((node == null)) {
      return;
    } else
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      refactoringClass = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.getNode("r:de5b7214-45ee-4f6d-89bf-acde59cdb050(jetbrains.mps.lang.structure.refactorings)", "1851015849775237139"), "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    } else
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.LinkDeclaration")) {
      refactoringClass = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.getNode("r:de5b7214-45ee-4f6d-89bf-acde59cdb050(jetbrains.mps.lang.structure.refactorings)", "1851015849775217786"), "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    } else {
      refactoringClass = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.getNode("r:d9efd362-28b8-4f70-9bcd-fb582528d11c(jetbrains.mps.lang.core.refactorings)", "1851015849775217755"), "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    }
    final IRefactoring refactoring = RefactoringUtil.getRefactoringByClassName(refactoringClass);
    final RefactoringContext refactoringContext = new RefactoringContext(refactoring);
    refactoringContext.setCurrentOperationContext(context);
    refactoringContext.setSelectedNode(node);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        refactoringContext.setSelectedModel(SNodeOperations.getModel(node).getModelDescriptor());
      }
    });
    refactoringContext.setSelectedModule(context.getModule());
    refactoringContext.setSelectedProject(context.getProject());
    new Thread() {
      public void run() {
        refactoringContext.setRefactoring(refactoring);
        RefactoringAccess.getInstance().getRefactoringFacade().execute(refactoringContext);
      }
    }.start();
  }
}
