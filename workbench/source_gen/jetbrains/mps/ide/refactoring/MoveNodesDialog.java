package jetbrains.mps.ide.refactoring;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;

public class MoveNodesDialog extends NodeChooserDialog {
  private SModelDescriptor myModel;
  private MoveNodesDialog.ModelFilter myFilter;

  public MoveNodesDialog(@NotNull Project project, SModelDescriptor model) {
    super(project);
    this.myModel = model;
    init();
    setTitle(REFACTORING_NAME + " " + "nodes");
  }

  protected void doRefactoringAction() {
    Object selectedObject = this.myPanel.getSelectedObject();
    if (myFilter == null || myFilter.checkForObject(selectedObject, this.myModel, this.myPanel)) {
      this.mySelectedObject = selectedObject;
      this.dispose();
    }

  }

  @Nullable
  protected JComponent createCenterPanel() {
    this.myPanel = ModelOrNodeChooser.createChooser(myProject, myModel);
    return this.myPanel;
  }

  public void setFilter(MoveNodesDialog.ModelFilter filter) {
    this.myFilter = filter;
  }

  public static Object getSelectedObject(@NotNull Project project, SModelDescriptor model) {
    MoveNodesDialog dialog = new MoveNodesDialog(project, model);
    dialog.show();
    return dialog.mySelectedObject;
  }

  public static Object getSelectedObject(@NotNull Project project, SModelDescriptor model, MoveNodesDialog.ModelFilter filter) {
    MoveNodesDialog dialog = new MoveNodesDialog(project, model);
    dialog.setFilter(filter);
    dialog.show();
    return dialog.mySelectedObject;
  }

  public static abstract class ModelFilter extends NodeChooserDialog.Filter {
    public ModelFilter() {
    }

    public ModelFilter(String errorMessage) {
      super(errorMessage);
    }

    public abstract boolean check(Object selectedObject, SModelDescriptor model);

    public boolean checkForObject(Object selectedObject, SModelDescriptor model, JComponent component) {
      if (!(check(selectedObject, model))) {
        showError("Nodes can't be moved", component);
        return false;
      }
      return true;
    }
  }
}
