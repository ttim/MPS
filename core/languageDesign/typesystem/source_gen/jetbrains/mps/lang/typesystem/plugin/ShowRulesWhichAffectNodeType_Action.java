package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.typesystem.uiActions.AffectingRulesFinder;
import jetbrains.mps.ide.findusages.view.UsagesViewTool;

public class ShowRulesWhichAffectNodeType_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowRulesWhichAffectNodeType_Action.class);

  public ShowRulesWhichAffectNodeType_Action() {
    super("Show Rules Which Affect Node's Type", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowRulesWhichAffectNodeType", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
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
      final Wrappers._T<SearchQuery> query = new Wrappers._T<SearchQuery>();
      final Wrappers._T<IResultProvider> provider = new Wrappers._T<IResultProvider>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          query.value = new SearchQuery(((SNode) MapSequence.fromMap(_params).get("node")), ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")).getScope());
          provider.value = FindUtils.makeProvider(new AffectingRulesFinder());
        }
      });
      ((IOperationContext) MapSequence.fromMap(_params).get("operationContext")).getComponent(UsagesViewTool.class).findUsages(provider.value, query.value, false, true, false, "no rules found");
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowRulesWhichAffectNodeType", t);
    }
  }
}
