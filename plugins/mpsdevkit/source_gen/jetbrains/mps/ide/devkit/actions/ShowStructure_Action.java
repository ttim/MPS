package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.ide.structureView.StructureView;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import jetbrains.mps.ide.devkit.structureview.FileStructureDialog;
import com.intellij.openapi.vfs.VirtualFile;

public class ShowStructure_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(ShowStructure_Action.class);

  public ShowStructure_Action() {
    super("Show Structure", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ShowStructure", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("fileEditor", event.getData(PlatformDataKeys.FILE_EDITOR));
    if (MapSequence.fromMap(_params).get("fileEditor") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("file", event.getData(PlatformDataKeys.VIRTUAL_FILE));
    if (MapSequence.fromMap(_params).get("file") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final StructureViewBuilder structureViewBuilder = ((FileEditor) MapSequence.fromMap(_params).get("fileEditor")).getStructureViewBuilder();
      if (structureViewBuilder == null) {
        return;
      }

      StructureView structureView = structureViewBuilder.createStructureView(((FileEditor) MapSequence.fromMap(_params).get("fileEditor")), ((Project) MapSequence.fromMap(_params).get("project")));
      DialogWrapper dialog = new FileStructureDialog(structureView.getTreeModel(), null, ((Project) MapSequence.fromMap(_params).get("project")), null, structureView, true);
      if (dialog != null) {
        if (((VirtualFile) MapSequence.fromMap(_params).get("file")) != null) {
          dialog.setTitle(((VirtualFile) MapSequence.fromMap(_params).get("file")).getPresentableUrl());
        }
        dialog.show();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ShowStructure", t);
      }
    }
  }
}
