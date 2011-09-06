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
import jetbrains.mps.ide.classpath.ClassPathViewerTool;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;

public class AnalyzeClasspath_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AnalyzeClasspath_Action.class);

  public AnalyzeClasspath_Action() {
    super("Analyze Classpath", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AnalyzeClasspath", t);
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      ClassPathViewerTool tool = ((IOperationContext) MapSequence.fromMap(_params).get("context")).getComponent(ClassPathViewerTool.class);
      tool.openToolLater(true);
      tool.analyzeModule(((IModule) MapSequence.fromMap(_params).get("module")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AnalyzeClasspath", t);
      }
    }
  }
}
