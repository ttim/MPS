package jetbrains.mps.ide.modelchecker.actions;

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
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelStereotype;
import com.intellij.openapi.project.Project;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;
import jetbrains.mps.smodel.IOperationContext;

public class FindlAllBrokenReferences_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(FindlAllBrokenReferences_Action.class);

  public FindlAllBrokenReferences_Action() {
    super("Find All Broken References", "Finds broken references in all available models", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FindlAllBrokenReferences", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.<String,Object>fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("operationContext", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("operationContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      List<SModelDescriptor> modelDescriptors = SModelRepository.getInstance().getModelDescriptors();
      modelDescriptors = ListSequence.<SModelDescriptor>fromList(modelDescriptors).where(new IWhereFilter<SModelDescriptor>() {
        public boolean accept(SModelDescriptor md) {
          return SModelStereotype.isUserModel(md);
        }
      }).toListSequence();
      ((Project) MapSequence.<String,Object>fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModelCheckerTool_Tool.class).checkModels(modelDescriptors, ((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("operationContext")), true, new BrokenReferencesFinder());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FindlAllBrokenReferences", t);
      }
    }
  }
}
