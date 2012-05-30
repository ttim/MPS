package jetbrains.mps.ide.migration.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.smodel.SModelRepository;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;
import java.util.Set;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class RemoveMPSClasspathDependencies_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RemoveMPSClasspathDependencies_Action.class);

  public RemoveMPSClasspathDependencies_Action() {
    super("Remove imports of MPS.Classpath models", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RemoveMPSClasspathDependencies", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("modules", event.getData(MPSDataKeys.MODULES));
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SModelRepository repo = SModelRepository.getInstance();
      List<SModelDescriptor> mpsclasspathModels = repo.getModelDescriptors(MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("37a3367b-1fb2-44d8-aa6b-18075e74e003")));
      final Set<SModelReference> toRemove = SetSequence.fromSetWithValues(new HashSet<SModelReference>(), ListSequence.fromList(mpsclasspathModels).select(new ISelector<SModelDescriptor, SModelReference>() {
        public SModelReference select(SModelDescriptor it) {
          return it.getSModelReference();
        }
      }));

      Iterable<SModelDescriptor> models = (((List<IModule>) MapSequence.fromMap(_params).get("modules")) == null || ((List<IModule>) MapSequence.fromMap(_params).get("modules")).isEmpty() ?
        repo.getModelDescriptors() :
        ListSequence.fromList(((List<IModule>) ((List<IModule>) MapSequence.fromMap(_params).get("modules")))).translate(new ITranslator2<IModule, SModelDescriptor>() {
          public Iterable<SModelDescriptor> translate(IModule it) {
            return repo.getModelDescriptors(it);
          }
        })
      );
      // imports: 
      for (SModelDescriptor model : Sequence.fromIterable(models)) {
        if (!(model instanceof EditableSModelDescriptor)) {
          continue;
        }
        List<SModel.ImportElement> importElements = model.getSModel().importedModels();
        for (SModelReference modelRef : ListSequence.fromList(importElements).select(new ISelector<SModel.ImportElement, SModelReference>() {
          public SModelReference select(SModel.ImportElement it) {
            return it.getModelReference();
          }
        }).where(new IWhereFilter<SModelReference>() {
          public boolean accept(SModelReference it) {
            return SetSequence.fromSet(toRemove).contains(it);
          }
        }).toGenericArray(SModelReference.class)) {
          model.getSModel().deleteModelImport(modelRef);
        }
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RemoveMPSClasspathDependencies", t);
      }
    }
  }
}
