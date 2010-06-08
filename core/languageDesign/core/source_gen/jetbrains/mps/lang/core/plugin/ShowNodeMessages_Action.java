package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorComponent;
import java.awt.Frame;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.ui.Messages;

public class ShowNodeMessages_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowNodeMessages_Action.class);

  private Project project;
  private SNode node;
  private EditorComponent editorComponent;
  private Frame frame;

  public ShowNodeMessages_Action() {
    super("Show Node Messages", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "alt shift M";
  }

  public boolean isApplicable(AnActionEvent event) {
    return !(ListSequence.fromList(((List<EditorMessage>) ShowNodeMessages_Action.this.editorComponent.getHighlightManager().getMessagesFor(ShowNodeMessages_Action.this.node))).isEmpty());
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowNodeMessages", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    this.node = event.getData(MPSDataKeys.NODE);
    if (this.node == null) {
      return false;
    }
    this.editorComponent = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editorComponent == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    return true;
  }

  protected void cleanup() {
    super.cleanup();
    this.project = null;
    this.node = null;
    this.editorComponent = null;
    this.frame = null;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      List<EditorMessage> messages = ShowNodeMessages_Action.this.editorComponent.getHighlightManager().getMessagesFor(ShowNodeMessages_Action.this.node);
      StringBuilder sb = new StringBuilder();
      for (EditorMessage message : messages) {
        sb.append(message.getMessage());
        sb.append("; owner is ");
        sb.append(message.getOwner());
        sb.append("\n");
      }
      Messages.showMessageDialog(ShowNodeMessages_Action.this.project, sb.toString(), "Node Messages", Messages.getInformationIcon());
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowNodeMessages", t);
    }
  }
}
