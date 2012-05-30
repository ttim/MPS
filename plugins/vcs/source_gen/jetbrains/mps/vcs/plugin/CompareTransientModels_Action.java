package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.generator.TransientModelsModule;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.projectPane.SortUtil;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.vcs.diff.ui.ModelDifferenceDialog;
import com.intellij.openapi.project.Project;

public class CompareTransientModels_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("diff.png");
  protected static Log log = LogFactory.getLog(CompareTransientModels_Action.class);

  public CompareTransientModels_Action() {
    super("Compare Models", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")).size() == 2 && ((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")).get(0) instanceof TransientModelsModule.TransientSModelDescriptor && ((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")).get(1) instanceof TransientModelsModule.TransientSModelDescriptor && eq_5whyyr_a0a0a1(((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")).get(0).getLongName(), ((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")).get(1).getLongName());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CompareTransientModels", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("models", event.getData(MPSCommonDataKeys.MODELS));
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final List<SModelDescriptor> sortedModels = SortUtil.sortModels(((List<SModelDescriptor>) MapSequence.fromMap(_params).get("models")));
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          final SModel first = sortedModels.get(0).getSModel();
          final SModel second = sortedModels.get(1).getSModel();
          ApplicationManager.getApplication().invokeLater(new Runnable() {
            public void run() {
              new ModelDifferenceDialog(first, second, ((Project) MapSequence.fromMap(_params).get("project")), first.getSModelReference().getSModelFqName().toString(), second.getSModelReference().getSModelFqName().toString()).show();
            }
          });
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CompareTransientModels", t);
      }
    }
  }

  private static boolean eq_5whyyr_a0a0a1(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
