package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.List;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.behavior.IMemberContainer_Behavior;
import jetbrains.mps.ide.platform.dialogs.choosers.NodeChooserDialog;
import com.intellij.openapi.project.Project;
import jetbrains.mps.nodeEditor.EditorComponent;

public class ShowMembers_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowMembers_Action.class);

  public ShowMembers_Action() {
    super("Show Members", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return (SNodeOperations.getAncestor(((SNode) MapSequence.fromMap(_params).get("node")), "jetbrains.mps.baseLanguage.structure.IMemberContainer", true, false) != null);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowMembers", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("projct", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("projct") == null) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("node", node);
    }
    if (MapSequence.fromMap(_params).get("node") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    if (MapSequence.fromMap(_params).get("editorComponent") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<List<SNode>> members = new Wrappers._T<List<SNode>>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          members.value = IMemberContainer_Behavior.call_getMembers_1213877531970(SNodeOperations.getAncestor(((SNode) MapSequence.fromMap(_params).get("node")), "jetbrains.mps.baseLanguage.structure.IMemberContainer", true, false));
        }
      });

      NodeChooserDialog nodeChooserDialog = new NodeChooserDialog(((Project) MapSequence.fromMap(_params).get("projct")), members.value);
      nodeChooserDialog.show();
      SNode snode = nodeChooserDialog.getResult();

      if (snode == null) {
        return;
      }
      ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).selectNode(snode);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowMembers", t);
      }
    }
  }
}
