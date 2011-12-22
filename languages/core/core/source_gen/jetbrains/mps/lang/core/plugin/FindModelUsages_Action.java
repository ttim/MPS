package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.ide.findusages.findalgorithm.finders.specific.ModelUsagesFinder;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.findusages.view.UsagesViewTool;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import java.io.IOException;

public class FindModelUsages_Action extends BaseAction {
  private static final Icon ICON = getIcon();
  private static Logger LOG = Logger.getLogger(FindModelUsages_Action.class);

  public FindModelUsages_Action() {
    super("Find Usages", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "FindModelUsages", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("scope", event.getData(MPSCommonDataKeys.SCOPE));
    if (MapSequence.fromMap(_params).get("scope") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SearchQuery[] query = new SearchQuery[1];
      final IResultProvider[] provider = new IResultProvider[1];
      final SModel model = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getSModel();
      final IScope scope = ((IScope) MapSequence.fromMap(_params).get("scope"));
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          query[0] = new SearchQuery(model, scope);
          provider[0] = FindUtils.makeProvider(new ModelUsagesFinder());
        }
      });
      ((IOperationContext) MapSequence.fromMap(_params).get("context")).getComponent(UsagesViewTool.class).findUsages(provider[0], query[0], true, true, false, "Model has no usages");
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "FindModelUsages", t);
    }
  }

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(FindModelUsages_Action.class.getResourceAsStream("find.png")));
    } catch (IOException e) {
      LOG.warning("Couldn't load icon for FindModelUsages", e);
      return null;
    }
  }
}
