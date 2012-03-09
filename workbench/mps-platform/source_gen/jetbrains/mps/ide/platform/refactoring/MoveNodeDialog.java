package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import javax.swing.JOptionPane;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import jetbrains.mps.smodel.SModelDescriptor;

public class MoveNodeDialog extends ModelOrNodeChooserDialog {
  private SNode myNodeToMove;
  private MoveNodeDialog.NodeFilter myNodeFilter;
  private SNode mySelectedObject;

  public MoveNodeDialog(@NotNull Project project, SNode node) {
    super(project);
    myNodeToMove = node;
    init();
    setTitle(REFACTORING_NAME + " " + "node");
    setHorizontalStretch(1.5f);
    setVerticalStretch(2.0f);
  }

  protected void doRefactoringAction() {
    Object selectedObject = myChooser.getSelectedObject();
    if (!(selectedObject instanceof SNode)) {
      JOptionPane.showMessageDialog(myChooser.getComponent(), "Choose node", "Node can't be moved", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    if (myNodeFilter == null || myNodeFilter.checkForObject(((SNode) selectedObject), myNodeToMove, myNodeToMove.getModel().getModelDescriptor(), myChooser.getComponent())) {
      mySelectedObject = ((SNode) selectedObject);
      super.doRefactoringAction();
    }
  }

  public void setFilter(MoveNodeDialog.NodeFilter filter) {
    myNodeFilter = filter;
  }

  @Nullable
  protected JComponent createCenterPanel() {
    myChooser = RefactoringAccess.getInstance().createTargetChooser(myProject, myNodeToMove);

    return myChooser.getComponent();
  }

  public static SNode getSelectedObject(@NotNull Project project, SNode node) {
    MoveNodeDialog dialog = new MoveNodeDialog(project, node);
    dialog.show();
    return dialog.mySelectedObject;
  }

  public static SNode getSelectedObject(@NotNull Project project, SNode node, MoveNodeDialog.NodeFilter filter) {
    MoveNodeDialog dialog = new MoveNodeDialog(project, node);
    dialog.setFilter(filter);
    dialog.show();
    return dialog.mySelectedObject;
  }

  public static abstract class NodeFilter extends ModelOrNodeChooserDialog.Filter {
    public NodeFilter() {
    }

    public NodeFilter(String errorMessage) {
      super(errorMessage);
    }

    public abstract boolean check(SNode selectedObject, SNode nodeToMove, SModelDescriptor modelOfSelectedNode);

    private boolean checkForObject(SNode selectedObject, SNode nodeToMove, SModelDescriptor modelOfSelectedNode, JComponent component) {
      if (!(check(selectedObject, nodeToMove, modelOfSelectedNode))) {
        showError("Nodes can't be moved", component);
        return false;
      }
      return true;
    }
  }
}
