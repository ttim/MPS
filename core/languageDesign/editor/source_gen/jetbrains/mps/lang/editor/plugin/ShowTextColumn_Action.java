package jetbrains.mps.lang.editor.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.leftHighlighter.DummyTextColumn2;

public class ShowTextColumn_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(ShowTextColumn_Action.class);

  private EditorComponent editor;
  private SNode node;

  public ShowTextColumn_Action() {
    super("Show Text Column (internal)", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "ShowTextColumn", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.editor = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editor == null) {
      return false;
    }
    this.node = event.getData(MPSDataKeys.NODE);
    if (this.node == null) {
      return false;
    }
    return true;
  }

  protected void cleanup() {
    super.cleanup();
    this.editor = null;
    this.node = null;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      SNode root = ShowTextColumn_Action.this.node.getContainingRoot();
      ShowTextColumn_Action.this.editor.getLeftEditorHighlighter().addTextColumn(new DummyTextColumn2(root));
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "ShowTextColumn", t);
    }
  }
}
