package jetbrains.mps.calculator.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.lang.reflect.Method;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class ExecuteCalculator_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ExecuteCalculator_Action.class);

  public ExecuteCalculator_Action() {
    super("Execute Calculator", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ExecuteCalculator_Action.this.getMainMethod(_params) != null;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ExecuteCalculator", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.calculator.structure.Calculator"))) {
          node = null;
        }
      }
      MapSequence.fromMap(_params).put("calcNode", node);
    }
    if (MapSequence.fromMap(_params).get("calcNode") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      try {
        final Method method = ExecuteCalculator_Action.this.getMainMethod(_params);
        Thread thread = new Thread(new Runnable() {
          public void run() {
            try {
              String[] args = new String[0];
              method.invoke(null, new Object[]{args});
            } catch (Throwable e) {
              e.printStackTrace();
            }
          }
        });
        thread.start();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ExecuteCalculator", t);
      }
    }
  }

  private Class getCalcClass(final Map<String, Object> _params) {
    String className = SPropertyOperations.getString(((SNode) MapSequence.fromMap(_params).get("calcNode")), "name");
    String fqClassName = SNodeOperations.getModel(((SNode) MapSequence.fromMap(_params).get("calcNode"))).getLongName() + "." + className;
    return SNodeOperations.getModel(((SNode) MapSequence.fromMap(_params).get("calcNode"))).getModelDescriptor().getModule().getClass(fqClassName);
  }

  private Method getMainMethod(final Map<String, Object> _params) {
    final Class c = ExecuteCalculator_Action.this.getCalcClass(_params);
    if (c == null) {
      return null;
    }
    try {
      return c.getDeclaredMethod("main", new String[0].getClass());
    } catch (NoSuchMethodException e) {
      return null;
    }
  }
}
