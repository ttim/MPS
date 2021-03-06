package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.ide.util.GroupedNodesChooser;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.project.Project;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class SelectConstructorsDialog extends GroupedNodesChooser {
  public SelectConstructorsDialog(SNodePointer[] ctors, Project project) {
    super(ctors, false, true, ProjectHelper.toIdeaProject(project));
  }

  @Override
  protected String getText(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Classifier")) {
      return ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"), "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    }
    return super.getText(node);
  }
}
