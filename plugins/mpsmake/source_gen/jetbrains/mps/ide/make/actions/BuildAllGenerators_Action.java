package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.List;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.IOperationContext;

public class BuildAllGenerators_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(BuildAllGenerators_Action.class);

  public BuildAllGenerators_Action() {
    super("Rebuild All Generators", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "BuildAllGenerators", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
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
      final Wrappers._T<List<IModule>> m = new Wrappers._T<List<IModule>>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          m.value = ListSequence.fromListWithValues(new ArrayList<IModule>(), ModuleRepositoryFacade.getInstance().getAllModules(Generator.class));
        }
      });

      new MakeActionImpl(((IOperationContext) MapSequence.fromMap(_params).get("context")), new MakeActionParameters(((IOperationContext) MapSequence.fromMap(_params).get("context")), null, null, m.value, null), true).executeAction();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "BuildAllGenerators", t);
      }
    }
  }
}
