package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.ide.findusages.findalgorithm.finders.specific.LanguageConceptsUsagesFinder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.findusages.view.UsagesViewTool;

public class FindLanguageConceptsUsages_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("find.png");
  protected static Log log = LogFactory.getLog(FindLanguageConceptsUsages_Action.class);

  public FindLanguageConceptsUsages_Action() {
    super("Find Concepts Usages", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (!(((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language)) {
      return false;
    }
    Language language = (Language) ((IModule) MapSequence.fromMap(_params).get("module"));
    SModelDescriptor structureModelDescriptor = language.getStructureModelDescriptor();
    if (structureModelDescriptor == null) {
      return false;
    }
    if (structureModelDescriptor.getSModel().rootsCount() == 0) {
      return false;
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "FindLanguageConceptsUsages", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("scope", event.getData(MPSCommonDataKeys.SCOPE));
    if (MapSequence.fromMap(_params).get("scope") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SearchQuery[] query = new SearchQuery[1];
      final IResultProvider[] provider = new IResultProvider[1];
      final IModule module = ((IModule) MapSequence.fromMap(_params).get("module"));
      final IScope scope = ((IScope) MapSequence.fromMap(_params).get("scope"));
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          query[0] = new SearchQuery(module, scope);
          provider[0] = FindUtils.makeProvider(new LanguageConceptsUsagesFinder());
        }
      });
      ((IOperationContext) MapSequence.fromMap(_params).get("context")).getComponent(UsagesViewTool.class).findUsages(provider[0], query[0], true, true, false, "There are no usages of language's concepts");
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "FindLanguageConceptsUsages", t);
      }
    }
  }
}
