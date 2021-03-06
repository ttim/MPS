package jetbrains.mps.vcs.diff.ui;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public abstract class RevertRootsAction extends BaseAction implements DumbAware {
  private ModelDifferenceDialog myModelDifferenceDialog;

  public RevertRootsAction(ModelDifferenceDialog modelDifferenceDialog) {
    super("Revert Root", null, IconLoader.getIcon("/actions/rollback.png"));
    myModelDifferenceDialog = modelDifferenceDialog;
  }

  protected void doExecute(AnActionEvent event, Map<String, Object> map) {
    Iterable<ModelChange> changes = Sequence.fromIterable(Sequence.fromArray(getRoots())).translate(new ITranslator2<SNodeId, ModelChange>() {
      public Iterable<ModelChange> translate(SNodeId r) {
        return (r == null ?
          myModelDifferenceDialog.getMetadataChanges() :
          myModelDifferenceDialog.getChangesForRoot(r)
        );
      }
    });
    myModelDifferenceDialog.rollbackChanges(changes, new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        after();
      }
    });
  }

  @Override
  protected void doUpdate(AnActionEvent event, Map<String, Object> map) {
    super.doUpdate(event, map);
    SModel newModel = myModelDifferenceDialog.getChangeSet().getNewModel();
    boolean enabled = getRoots().length != 0 && newModel.getModelDescriptor() instanceof EditableSModelDescriptor && SModelRepository.getInstance().getModelDescriptor(newModel.getSModelReference()).getSModel() == newModel;
    event.getPresentation().setEnabled(enabled);
    event.getPresentation().setVisible(enabled);
    String what = "Roots";
    if (getRoots().length == 1) {
      what = (getRoots()[0] == null ?
        "Properties" :
        "Root"
      );
    } else {
      if (Sequence.fromIterable(Sequence.fromArray(getRoots())).any(new IWhereFilter<SNodeId>() {
        public boolean accept(SNodeId r) {
          return r == null;
        }
      })) {
        what = "Roots and Properties";
      }
    }
    event.getPresentation().setText("Revert " + what);
  }

  protected abstract void after();

  protected abstract SNodeId[] getRoots();
}
