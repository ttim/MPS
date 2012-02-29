package jetbrains.mps.ide.java.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SModelStereotype;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.project.IModule;
import javax.swing.JOptionPane;
import java.awt.Frame;
import jetbrains.mps.ide.actions.NewModelUtil;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.ide.dialogs.project.creation.NewModelDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.smodel.SModel;
import java.io.File;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.ide.java.parser.JavaCompiler;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.projectPane.ProjectPane;
import javax.swing.tree.TreeNode;
import jetbrains.mps.ide.StereotypeProvider;

public class NewModelFromSource_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewModelFromSource_Action.class);

  public NewModelFromSource_Action() {
    super("Model from Source", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    String stereotype = NewModelFromSource_Action.this.getStereotype(_params);
    if (stereotype == null) {
      return true;
    }
    for (String availableStereotype : SModelStereotype.values) {
      if (stereotype.equals(availableStereotype)) {
        return true;
      }
    }
    return false;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewModelFromSource", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.CONTEXT_MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("treeNode", event.getData(MPSDataKeys.LOGICAL_VIEW_NODE));
    if (MapSequence.fromMap(_params).get("treeNode") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      if (((IModule) MapSequence.fromMap(_params).get("module")).getSModelRoots().size() == 0) {
        int code = JOptionPane.showConfirmDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "There are no model roots. Do you want to create one?", "", JOptionPane.YES_NO_OPTION);
        if (code != JOptionPane.YES_OPTION) {
          return;
        } else {
          NewModelUtil.ShowModulePropertiesDialog(((IModule) MapSequence.fromMap(_params).get("module")), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
        }
      }
      if (((IModule) MapSequence.fromMap(_params).get("module")).getSModelRoots().size() == 0) {
        JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Can't create a model in solution with no model roots", "Can't create model", JOptionPane.ERROR_MESSAGE);
        return;
      }
      final Wrappers._T<NewModelDialog> dialog = new Wrappers._T<NewModelDialog>();
      final IOperationContext localContext = ((IOperationContext) MapSequence.fromMap(_params).get("context"));
      final IModule localModule = (localContext.getModule() != null ?
        localContext.getModule() :
        ((IModule) MapSequence.fromMap(_params).get("module"))
      );
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          String stereotype = NewModelFromSource_Action.this.getStereotype(_params);
          dialog.value = new NewModelDialog(localModule, NewModelFromSource_Action.this.getNamespace(_params), localContext, stereotype, NewModelFromSource_Action.this.isStrict(_params));
        }
      });
      dialog.value.showDialog();
      SModelDescriptor result = dialog.value.getResult();
      if (result != null) {
        TreeFileChooser treeFileChooser = new TreeFileChooser();
        treeFileChooser.setDirectoriesAreAlwaysVisible(true);
        treeFileChooser.setMode(TreeFileChooser.MODE_DIRECTORIES);
        final SModel sModel = result.getSModel();
        String generatorOutputPath = ((IModule) MapSequence.fromMap(_params).get("module")).getGeneratorOutputPath();
        File initial = null;
        File output = new File(generatorOutputPath);
        if (output.exists()) {
          initial = output;
          File sourceRoot = new File(initial.getParentFile(), "source");
          if (!(sourceRoot.exists())) {
            sourceRoot = new File(initial.getParentFile(), "src");
          }
          initial = sourceRoot;
          if (sourceRoot.exists()) {
            File modelSource = new File(sourceRoot, NameUtil.pathFromNamespace(sModel.getLongName()));
            if (modelSource.exists()) {
              initial = modelSource;
            }
          }
        }
        if (initial != null) {
          treeFileChooser.setInitialFile(FileSystem.getInstance().getFileByPath(initial.getAbsolutePath()));
        }
        IFile resultFile = treeFileChooser.showDialog(((Frame) MapSequence.fromMap(_params).get("frame")));
        if (resultFile != null) {
          JavaCompiler javaCompiler = new JavaCompiler(((IOperationContext) MapSequence.fromMap(_params).get("context")), ((IModule) MapSequence.fromMap(_params).get("module")), new File(resultFile.getPath()), false, sModel, ((Project) MapSequence.fromMap(_params).get("project")));
          javaCompiler.compile();
        }
        SModelDescriptor modelDescriptor = result;
        ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).selectModel(modelDescriptor, false);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewModelFromSource", t);
      }
    }
  }

  protected String getStereotype(final Map<String, Object> _params) {
    if (((TreeNode) MapSequence.fromMap(_params).get("treeNode")) instanceof StereotypeProvider) {
      return ((StereotypeProvider) ((TreeNode) MapSequence.fromMap(_params).get("treeNode"))).getStereotype();
    }
    return null;
  }

  protected boolean isStrict(final Map<String, Object> _params) {
    if (((TreeNode) MapSequence.fromMap(_params).get("treeNode")) instanceof StereotypeProvider) {
      return ((StereotypeProvider) ((TreeNode) MapSequence.fromMap(_params).get("treeNode"))).isStrict();
    }
    return false;
  }

  protected String getNamespace(final Map<String, Object> _params) {
    return null;
  }
}
