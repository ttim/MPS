package jetbrains.mps.build.mps.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.build.behavior.BuildProject_Behavior;
import jetbrains.mps.build.util.Context;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.vfs.FileSystem;
import java.awt.Frame;
import java.util.List;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.build.mps.util.VisibleModules;
import jetbrains.mps.build.mps.util.PathConverter;
import java.util.ArrayList;
import jetbrains.mps.project.structure.modules.ModuleReference;

public class ImportAllModulesFromFolder_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("import.png");
  protected static Log log = LogFactory.getLog(ImportAllModulesFromFolder_Action.class);

  public ImportAllModulesFromFolder_Action() {
    super("Import All Modules from Folder", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "ImportAllModulesFromFolder", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildProject"))) {
          node = null;
        }
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
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      TreeFileChooser chooser = new TreeFileChooser();
      chooser.setMode(TreeFileChooser.MODE_DIRECTORIES);
      chooser.setContext(((IOperationContext) MapSequence.fromMap(_params).get("context")));
      final Wrappers._T<IFile> projectFolder = new Wrappers._T<IFile>(null);
      final Wrappers._T<String> basePath = new Wrappers._T<String>(null);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          basePath.value = BuildProject_Behavior.call_getBasePath_4959435991187146924(((SNode) MapSequence.fromMap(_params).get("node")), Context.defaultContext());
          if (basePath.value != null && StringUtils.isNotEmpty(basePath.value)) {
            projectFolder.value = FileSystem.getInstance().getFileByPath(basePath.value);
          }
        }
      });
      if (basePath.value == null) {
        if (log.isErrorEnabled()) {
          log.error("working directory is not available");
        }
        return;
      }
      if (projectFolder.value != null) {
        chooser.setInitialFile(projectFolder.value);
      }
      final IFile dir = chooser.showDialog(((Frame) MapSequence.fromMap(_params).get("frame")));
      if (dir == null || !(dir.isDirectory())) {
        return;
      }

      ModelAccess.instance().runCommandInEDT(new Runnable() {
        public void run() {
          List<ModulesMiner.ModuleHandle> modules = ModulesMiner.getInstance().collectModules(dir, false);
          VisibleModules visible = new VisibleModules(((SNode) MapSequence.fromMap(_params).get("node")), null);
          visible.collect();

          PathConverter converter = new PathConverter(((SNode) MapSequence.fromMap(_params).get("node")));

          List<ImportModuleHelper> helpers = new ArrayList<ImportModuleHelper>();
          for (ModulesMiner.ModuleHandle handle : modules) {
            ModuleReference modRef = handle.getDescriptor().getModuleReference();
            if (visible.resolve(modRef.getModuleFqName(), modRef.getModuleId().toString()) != null) {
              continue;
            }

            ImportModuleHelper helper = new ImportModuleHelper(((SNode) MapSequence.fromMap(_params).get("node")), converter, handle.getFile(), handle.getDescriptor());
            helper.create();
            helpers.add(helper);
          }
          visible = new VisibleModules(((SNode) MapSequence.fromMap(_params).get("node")), null);
          visible.collect();

          for (ImportModuleHelper helper : helpers) {
            helper.update(visible);
          }

        }
      }, ((IOperationContext) MapSequence.fromMap(_params).get("context")).getProject());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "ImportAllModulesFromFolder", t);
      }
    }
  }
}
