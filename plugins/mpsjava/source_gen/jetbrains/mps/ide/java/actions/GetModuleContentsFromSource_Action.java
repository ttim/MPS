package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.IFileFilter;
import jetbrains.mps.vfs.IFile;
import java.awt.Frame;
import jetbrains.mps.ide.java.parser.JavaCompiler;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import java.io.File;

public class GetModuleContentsFromSource_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GetModuleContentsFromSource_Action.class);

  public GetModuleContentsFromSource_Action() {
    super("Get Module Contents from Source", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "GetModuleContentsFromSource", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.<String,Object>fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("context", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.<String,Object>fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.<String,Object>fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.<String,Object>fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      TreeFileChooser treeFileChooser = new TreeFileChooser();
      treeFileChooser.setDirectoriesAreAlwaysVisible(true);
      treeFileChooser.setMode(TreeFileChooser.MODE_DIRECTORIES);
      treeFileChooser.setFileFilter(new IFileFilter() {
        public boolean accept(IFile file) {
          return file.isDirectory();
        }
      });
      IFile result = treeFileChooser.showDialog(((Frame) MapSequence.<String,Object>fromMap(_params).get("frame")));
      if (result != null) {
        JavaCompiler javaCompiler = new JavaCompiler(((IOperationContext) MapSequence.<String,Object>fromMap(_params).get("context")), ((IModule) MapSequence.<String,Object>fromMap(_params).get("module")), new File(result.getPath()), true);
        javaCompiler.compile();
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GetModuleContentsFromSource", t);
      }
    }
  }
}
