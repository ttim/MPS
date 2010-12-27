package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.workbench.MPSDataKeys;

public class ShowHelpForRoot_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowHelpForRoot_Action.class);

  public ShowHelpForRoot_Action() {
    super("Show Help for Root", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return HelpHelper.helpForRootIsAvailable(((SNode) MapSequence.fromMap(_params).get("node"))) && HelpHelper.getDefaultHelpFor(((IModule) MapSequence.fromMap(_params).get("module")), ((SModelDescriptor) MapSequence.fromMap(_params).get("model")), ((SNode) MapSequence.fromMap(_params).get("node"))) != HelpHelper.HelpType.ROOT_NODE;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowHelpForRoot", t);
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
    MapSequence.fromMap(_params).put("model", event.getData(MPSDataKeys.CONTEXT_MODEL));
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.CONTEXT_MODULE));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      HelpHelper.showHelpForRoot(((SNode) MapSequence.fromMap(_params).get("node")));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowHelpForRoot", t);
    }
  }
}
