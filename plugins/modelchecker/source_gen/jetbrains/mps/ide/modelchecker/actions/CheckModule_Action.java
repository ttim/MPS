package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.List;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.project.Project;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;
import jetbrains.mps.smodel.IOperationContext;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class CheckModule_Action extends BaseAction {
  private static final Icon ICON = getIcon();
  protected static Log log = LogFactory.getLog(CheckModule_Action.class);

  public CheckModule_Action() {
    super("Check [Module]", "Check [module] for structure and typesystem rules", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        String whatToCheck = ((IModule) MapSequence.fromMap(_params).get("module")).getClass().getSimpleName();
        if (((List<IModule>) MapSequence.fromMap(_params).get("modules")).size() > 1) {
          whatToCheck = ((List<IModule>) MapSequence.fromMap(_params).get("modules")).size() + " Modules";
        }
        event.getPresentation().setText("Check " + whatToCheck);
        event.getPresentation().setDescription("Check " + whatToCheck.toLowerCase() + " for structure and typesystem rules");
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CheckModule", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("modules", event.getData(MPSDataKeys.MODULES));
    if (MapSequence.fromMap(_params).get("modules") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      if (((List<IModule>) MapSequence.fromMap(_params).get("modules")).size() > 1) {
        ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModelCheckerTool_Tool.class).checkModules(((List<IModule>) MapSequence.fromMap(_params).get("modules")), ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), true);
      } else {
        ((Project) MapSequence.fromMap(_params).get("project")).getComponent(ProjectPluginManager.class).getTool(ModelCheckerTool_Tool.class).checkModule(((IModule) MapSequence.fromMap(_params).get("module")), ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")), true);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CheckModule", t);
      }
    }
  }

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(CheckModule_Action.class.getResource("modelChecker.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for CheckModule", e);
      }
      return null;
    }
  }
}
