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
import java.util.ArrayList;

public class FindCrossTemplateReferences_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(FindCrossTemplateReferences_Action.class);

  public FindCrossTemplateReferences_Action() {
    super("Find Cross-template References", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FindCrossTemplateReferences", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      List<SModelDescriptor> modelDescriptors = SModelRepository.getInstance().getModelDescriptors();
      modelDescriptors = ListSequence.fromList(modelDescriptors).where(new IWhereFilter<SModelDescriptor>() {
        public boolean accept(SModelDescriptor md) {
          return SModelStereotype.isGeneratorModel(md) && md.isGeneratable();
        }
      }).toListSequence();
      ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModelCheckerTool_Tool.class).checkModels(modelDescriptors, ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), true, new ModelCheckerIssueFinder() {
        @Override
        protected List<SpecificChecker> getSpecificCheckers() {
          return ListSequence.fromListAndArray(new ArrayList<SpecificChecker>(), new GeneratorTemplatesChecker());
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FindCrossTemplateReferences", t);
      }
    }
  }
}
