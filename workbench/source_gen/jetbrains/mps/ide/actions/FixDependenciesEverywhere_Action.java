package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.MissingDependenciesFixer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.reloading.ClassLoaderManager;
import com.intellij.openapi.progress.EmptyProgressIndicator;

public class FixDependenciesEverywhere_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(FixDependenciesEverywhere_Action.class);

  public FixDependenciesEverywhere_Action() {
    super("Add Necessary Module Deps Everywhere", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FixDependenciesEverywhere", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      for (SModelDescriptor model : ListSequence.fromList(SModelRepository.getInstance().getModelDescriptors())) {
        if (!(model instanceof EditableSModelDescriptor)) {
          continue;
        }
        new MissingDependenciesFixer(((IOperationContext) MapSequence.fromMap(_params).get("context")), model).fix(false);
      }
      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressIndicator());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FixDependenciesEverywhere", t);
      }
    }
  }
}
