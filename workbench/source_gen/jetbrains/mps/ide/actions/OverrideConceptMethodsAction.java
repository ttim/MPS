package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import java.util.List;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class OverrideConceptMethodsAction {
  private Project myProject;
  private SNode mySelectedNode;
  private EditorContext myEditorContext;
  private boolean myIsOverride;

  public OverrideConceptMethodsAction(Project project, SNode selectedNode, EditorContext editorContext, boolean isOverride) {
    myProject = project;
    mySelectedNode = selectedNode;
    myEditorContext = editorContext;
    myIsOverride = isOverride;
  }

  public void run() {
    final SNode contextClass = SNodeOperations.getAncestor(mySelectedNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false);
    final SNode contextMethod = SNodeOperations.getAncestor(mySelectedNode, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration", true, false);
    final SNodePointer[] methods = ModelAccess.instance().runReadAction(new Computable<SNodePointer[]>() {
      public SNodePointer[] compute() {
        List<SNode> methodsToOverride = (myIsOverride ?
          ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(contextClass, "jetbrains.mps.baseLanguage.structure.IMemberContainer"), "virtual_getMethodsToOverride_5418393554803767537", new Class[]{SNode.class})) :
          ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(contextClass, "jetbrains.mps.baseLanguage.structure.IMemberContainer"), "virtual_getMethodsToImplement_5418393554803775106", new Class[]{SNode.class}))
        );
        return OverrideConceptMethodsDialog.toNodePointers(OverrideConceptMethodsDialog.sortMethods(contextClass, methodsToOverride));
      }
    });

    final OverrideConceptMethodsDialog dialog = new OverrideConceptMethodsDialog(methods, ProjectHelper.toIdeaProject(myProject)) {
      @Override
      protected boolean showInsertOverride() {
        return myIsOverride;
      }
    };
    dialog.setTitle((myIsOverride ?
      "Select Behavior Methods to Override" :
      "Select Behavior Methods to Implement"
    ));
    dialog.show();

    if (dialog.isOK()) {
      final Iterable<SNodePointer> selectedElements = (Iterable<SNodePointer>) dialog.getSelectedElements();

      ModelAccess.instance().runCommandInEDT(new Runnable() {
        public void run() {
          List<SNode> selection = Sequence.fromIterable(selectedElements).select(new ISelector<SNodePointer, SNode>() {
            public SNode select(SNodePointer it) {
              return SNodeOperations.cast(it.getNode(), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
            }
          }).toListSequence();

          OverrideConceptMethodsHelper helper = new OverrideConceptMethodsHelper(myProject, contextClass, contextMethod, dialog.isRemoveAttributes(), dialog.isAddReturn());
          List<SNode> insertedMethods = helper.insertMethods(selection);
          if (insertedMethods.isEmpty()) {
            return;
          }
          if (insertedMethods.size() == 1) {
            myEditorContext.selectAfter(ListSequence.fromList(insertedMethods).first());
          } else {
            myEditorContext.select(ListSequence.fromList(insertedMethods).last());
            myEditorContext.selectRange(ListSequence.fromList(insertedMethods).last(), ListSequence.fromList(insertedMethods).first());
          }

        }
      }, myProject);
    }
  }
}
