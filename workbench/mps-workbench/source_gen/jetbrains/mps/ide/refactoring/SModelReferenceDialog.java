package jetbrains.mps.ide.refactoring;

/*Generated by MPS */

import jetbrains.mps.ide.platform.refactoring.RefactoringDialog;
import jetbrains.mps.workbench.actions.goTo.matcher.ChooseByNamePanel;
import com.intellij.openapi.project.Project;
import java.util.List;
import jetbrains.mps.smodel.SModelReference;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.choose.models.BaseModelModel;
import jetbrains.mps.smodel.IScope;
import com.intellij.navigation.NavigationItem;
import jetbrains.mps.workbench.choose.models.BaseModelItem;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.workbench.actions.goTo.matcher.MpsPopupFactory;
import com.intellij.ide.util.gotoByName.ChooseByNamePopupComponent;
import com.intellij.openapi.application.ModalityState;
import javax.swing.JComponent;
import org.jetbrains.annotations.Nullable;

public class SModelReferenceDialog extends RefactoringDialog {
  protected static String REFACTORING_NAME = "Move Concepts";

  private ChooseByNamePanel myChooser;
  private Project myProject;
  private List<SModelReference> myModels;
  private SModelReference selectedModel;

  public SModelReferenceDialog(@NotNull Project project, List<SModelReference> models) {
    super(project, true);
    myProject = project;
    myModels = models;
    setTitle(REFACTORING_NAME);
    init();
  }

  protected void init() {
    setModal(true);
    setHorizontalStretch(2.5f);
    setVerticalStretch(2);

    BaseModelModel goToModelModel = new BaseModelModel(this.myProject) {
      public SModelReference[] find(IScope scope) {
        throw new UnsupportedOperationException("must not be used");
      }

      public NavigationItem doGetNavigationItem(final SModelReference modelReference) {
        return new BaseModelItem(modelReference) {
          public void navigate(boolean p0) {
          }
        };
      }

      @Override
      public SModelReference[] find(boolean checkBoxState) {
        return ListSequence.fromList(myModels).toGenericArray(SModelReference.class);
      }

      public boolean loadInitialCheckBoxState() {
        return false;
      }
    };
    myChooser = MpsPopupFactory.createPanelForPackage(goToModelModel, false);
    myChooser.invoke(new ChooseByNamePopupComponent.Callback() {
      public void elementChosen(Object p0) {
        doRefactoringAction();
      }
    }, ModalityState.current(), false);
    super.init();
  }

  public JComponent getPreferredFocusedComponent() {
    return myChooser.getPreferredFocusedComponent();
  }

  protected void doRefactoringAction() {
    Object item = myChooser.getChosenElement();
    if (item instanceof BaseModelItem) {
      selectedModel = ((BaseModelItem) item).getModelReference();
    }
    dispose();
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myChooser.getPanel();
  }

  public static SModelReference getSelectedModel(@NotNull Project project, List<SModelReference> models) {
    final SModelReferenceDialog dialog = new SModelReferenceDialog(project, models);
    dialog.show();
    return dialog.selectedModel;
  }
}
