package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelOperations;

public class UpdateRefactoringVersions_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(UpdateRefactoringVersions_Action.class);

  public UpdateRefactoringVersions_Action() {
    super("Update model version according to .history, save the latest imported model versions", "Update model version according to .history, save the latest imported model versions", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "UpdateRefactoringVersions", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("mpsProject", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("mpsProject") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      for (SModelDescriptor model : ListSequence.fromList(((MPSProject) MapSequence.fromMap(_params).get("mpsProject")).getProjectModels())) {
        if (!(model instanceof DefaultSModelDescriptor)) {
          continue;
        }
        if (SModelStereotype.isStubModelStereotype(model.getStereotype())) {
          continue;
        }
        UpdateRefactoringVersions_Action.this.updateModelVersion((DefaultSModelDescriptor) model, _params);
      }
      for (SModelDescriptor model : ListSequence.fromList(((MPSProject) MapSequence.fromMap(_params).get("mpsProject")).getProjectModels())) {
        if (!(model instanceof DefaultSModelDescriptor)) {
          continue;
        }
        if (SModelStereotype.isStubModelStereotype(model.getStereotype())) {
          continue;
        }
        UpdateRefactoringVersions_Action.this.updateImportVersions((DefaultSModelDescriptor) model, _params);
      }
      SModelRepository.getInstance().saveAll();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "UpdateRefactoringVersions", t);
      }
    }
  }

  /*package*/ void updateModelVersion(DefaultSModelDescriptor model, final Map<String, Object> _params) {
    int modelVersion = model.getVersion();
    int historyVersion = model.getStructureModificationLog().getLatestVersion(model.getSModelReference());
    if (modelVersion < historyVersion) {
      if (log.isErrorEnabled()) {
        log.error("updating version of " + model + " from " + modelVersion + " to .history version " + historyVersion);
      }
      model.setVersion(historyVersion);
      model.setChanged(true);
    } else if (modelVersion > historyVersion) {
      if (log.isErrorEnabled()) {
        log.error("history version of " + model + " is smaller than model version: " + historyVersion + "<" + modelVersion);
      }
    }
  }

  /*package*/ void updateImportVersions(DefaultSModelDescriptor model, final Map<String, Object> _params) {
    SModel m = model.getSModel();
    for (SModel.ImportElement importElement : ListSequence.fromList(SModelOperations.getAllImportElements(model.getSModel()))) {
      DefaultSModelDescriptor usedModel = as_hexye9_a0a0a1a4(SModelRepository.getInstance().getModelDescriptor(importElement.getModelReference()), DefaultSModelDescriptor.class);
      if (usedModel == null) {
        continue;
      }
      if (importElement.getUsedVersion() < usedModel.getVersion()) {
        if (log.isErrorEnabled()) {
          log.error(model + ": updating used version of " + importElement.getModelReference() + " from " + importElement.getUsedVersion() + " to " + usedModel.getVersion());
        }
      } else if (importElement.getUsedVersion() > usedModel.getVersion()) {
        if (log.isErrorEnabled()) {
          log.error(model + ": used version of " + importElement.getModelReference() + " is greater than model version: " + importElement.getUsedVersion() + ">" + usedModel.getVersion());
        }
        m.updateImportedModelUsedVersion(importElement.getModelReference(), usedModel.getVersion());
        model.setChanged(true);
      }
    }
  }

  private static <T> T as_hexye9_a0a0a1a4(Object o, Class<T> type) {
    return (type.isInstance(o) ?
      (T) o :
      null
    );
  }
}
