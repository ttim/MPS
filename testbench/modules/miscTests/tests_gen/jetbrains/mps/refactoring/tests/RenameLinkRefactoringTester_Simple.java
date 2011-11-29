package jetbrains.mps.refactoring.tests;

/*Generated by MPS */

import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.refactoring.framework.IRefactoring;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.smodel.ModelLoadingState;

public class RenameLinkRefactoringTester_Simple implements IRefactoringTester {
  public RenameLinkRefactoringTester_Simple() {
  }

  public boolean testRefactoring(final Project project, final SModelDescriptor sandbox1, final SModelDescriptor sandbox2, final Language testRefactoringLanguage, final Language testRefactoringTargetLanguage) {
    final String newLinkName = "sister";
    final Wrappers._T<IRefactoring> refactoring = new Wrappers._T<IRefactoring>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        refactoring.value = RefactoringUtil.getRefactoringByClassName(((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.getNode("r:de5b7214-45ee-4f6d-89bf-acde59cdb050(jetbrains.mps.lang.structure.refactorings)", "1347577327951781638"), "jetbrains.mps.lang.core.structure.INamedConcept"), "virtual_getFqName_1213877404258", new Class[]{SNode.class})));
      }
    });
    final RefactoringContext refactoringContext = new RefactoringContext(refactoring.value);
    refactoringContext.setCurrentOperationContext(new ProjectOperationContext(project));
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SModelDescriptor structureModelDescriptor = testRefactoringLanguage.getStructureModelDescriptor();
        SModel model = structureModelDescriptor.getSModel();
        SNode node = SModelOperations.getRootByName(model, "MyVeryGoodConcept1");
        SNode link = ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(node, "jetbrains.mps.lang.structure.structure.ConceptDeclaration"), "linkDeclaration", true)).first();
        refactoringContext.setSelectedProject(project);
        refactoringContext.setSelectedNode(link);
        refactoringContext.setSelectedModel(structureModelDescriptor);
        refactoringContext.setParameter("newName", newLinkName);
      }
    });
    new RefactoringTestFacade().doExecuteInTest(refactoringContext);
    final boolean[] result = new boolean[]{false};
    ThreadUtils.runInUIThreadAndWait(new Runnable() {
      public void run() {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            try {
              if (sandbox1.getLoadingState() != ModelLoadingState.NOT_LOADED) {
                System.err.println("test environment is invalid: model sandbox1 is already initialized, should be not");
                result[0] = false;
                return;
              }
              SModel sModel = sandbox1.getSModel();
              SNode root = sModel.rootsIterator().next();
              SNode referent = root.getReferent(newLinkName);
              if (referent == null) {
                System.err.println("referent is null");
                result[0] = false;
                return;
              }
              result[0] = "MyGood2".equals(referent.getName());
            } catch (Throwable t) {
              t.printStackTrace();
              result[0] = false;
              return;
            }
          }
        });
      }
    });
    return result[0];
  }
}
