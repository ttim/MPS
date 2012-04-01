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
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.generator.ModelGenerationStatusManager;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.IOperationContext;

public class RebuildRequiredModels_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RebuildRequiredModels_Action.class);

  public RebuildRequiredModels_Action() {
    super("Rebuild Required Models", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RebuildRequiredModels", t);
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
      final Wrappers._T<List<SModelDescriptor>> models = new Wrappers._T<List<SModelDescriptor>>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          Iterable<SModelDescriptor> allModels = SModelRepository.getInstance().getModelDescriptors();
          final ModelGenerationStatusManager mgsm = ModelGenerationStatusManager.getInstance();
          models.value = Sequence.fromIterable(allModels).where(new IWhereFilter<SModelDescriptor>() {
            public boolean accept(SModelDescriptor it) {
              return it.isGeneratable() && mgsm.generationRequired(it, ((IOperationContext) MapSequence.fromMap(_params).get("context")));
            }
          }).toListSequence();
        }
      });

      new MakeActionImpl(((IOperationContext) MapSequence.fromMap(_params).get("context")), new MakeActionParameters(((IOperationContext) MapSequence.fromMap(_params).get("context")), models.value, null, null, null), true).executeAction();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RebuildRequiredModels", t);
      }
    }
  }
}
