package jetbrains.mps.debugger.api.ui.tree;

/*Generated by MPS */

import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.workbench.action.BaseGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.ide.ui.MPSTree;

/*package*/ abstract class AbstractWatchableNode extends MPSTreeNode {
  protected final SNode myNode;

  public AbstractWatchableNode(@Nullable SNode node) {
    this(null, node);
  }

  public AbstractWatchableNode(@Nullable IOperationContext context, @Nullable SNode node) {
    super(context);
    myNode = node;
  }

  @Nullable
  public SNode getNode() {
    return myNode;
  }

  @Override
  public ActionGroup getActionGroup() {
    return ((BaseGroup) ActionManager.getInstance().getAction("jetbrains.mps.debugger.api.ui.actions.AbstractWatchableNodeActions_ActionGroup"));
  }

  public void openNode(final boolean focus, final boolean select) {
    if (myNode == null) {
      return;
    }
    final Project project = getProject();
    final IOperationContext context = getOperationContext();
    if (project != null && context != null) {
      ModelAccess.instance().executeCommand(new Runnable() {
        public void run() {
          NavigationSupport.getInstance().openNode(context, myNode, focus, select);
        }
      }, project.getComponent(MPSProject.class));
    }
  }

  @Nullable
  private Project getProject() {
    MPSTree tree = getTree();
    if (tree != null && tree instanceof VariablesTree) {
      return ((VariablesTree) tree).getProject();
    }
    return null;
  }
}
