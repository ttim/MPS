package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import java.awt.Dimension;
import org.jetbrains.annotations.NonNls;

public class MoveNodesDialog extends ModelOrNodeChooserDialog {
  private SModelDescriptor myModel;
  private MoveNodesDialog.ModelFilter myFilter;
  protected Object mySelectedObject;

  public MoveNodesDialog(@NotNull Project project, SModelDescriptor model) {
    super(project);
    myModel = model;
    init();
    setTitle(REFACTORING_NAME + " " + "nodes");
  }

  protected void doRefactoringAction() {
    Object selectedObject = myChooser.getSelectedObject();
    if (myFilter == null || myFilter.checkForObject(selectedObject, myModel, myChooser.getComponent())) {
      mySelectedObject = selectedObject;
      super.doRefactoringAction();
    }
  }

  @Nullable
  protected JComponent createCenterPanel() {
    myChooser = RefactoringAccess.getInstance().createTargetChooser(myProject, myModel);
    JComponent centerPanel = myChooser.getComponent();
    centerPanel.setPreferredSize(new Dimension(400, 900));
    return centerPanel;
  }

  public void setFilter(MoveNodesDialog.ModelFilter filter) {
    myFilter = filter;
  }

  @Nullable
  @NonNls
  @Override
  protected String getDimensionServiceKey() {
    return getClass().getName();
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

  public static abstract class ModelFilter extends ModelOrNodeChooserDialog.Filter {
    public ModelFilter() {
    }

    public ModelFilter(String errorMessage) {
      super(errorMessage);
    }

    public abstract boolean check(Object selectedObject, SModelDescriptor model);

    private boolean checkForObject(Object selectedObject, SModelDescriptor model, JComponent component) {
      if (!(check(selectedObject, model))) {
        showError("Nodes can't be moved", component);
        return false;
      }
      return true;
    }
  }
}
