package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.awt.Frame;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.IModule;
import javax.swing.tree.TreeNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.workbench.MPSDataKeys;
import javax.swing.JOptionPane;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.workbench.dialogs.project.creation.NewModelDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.IFileFilter;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.javaParser.JavaCompiler;
import java.io.File;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.ide.StereotypeProvider;

public class NewModelFromSource_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewModelFromSource_Action.class);

  private Frame frame;
  private Project project;
  private IOperationContext context;
  private IModule module;
  private TreeNode treeNode;

  public NewModelFromSource_Action() {
    super("Model from Source", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    String stereotype = NewModelFromSource_Action.this.getStereotype();
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

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewModelFromSource", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.module = event.getData(MPSDataKeys.CONTEXT_MODULE);
    if (this.module == null) {
      return false;
    }
    this.treeNode = event.getData(MPSDataKeys.LOGICAL_VIEW_NODE);
    if (this.treeNode == null) {
      return false;
    }
    return true;
  }

  protected void cleanup() {
    super.cleanup();
    this.frame = null;
    this.project = null;
    this.context = null;
    this.module = null;
    this.treeNode = null;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      if (NewModelFromSource_Action.this.module.getSModelRoots().size() == 0) {
        int code = JOptionPane.showConfirmDialog(NewModelFromSource_Action.this.frame, "There are no model roots. Do you want to create one?", "", JOptionPane.YES_NO_OPTION);
        if (code != JOptionPane.YES_OPTION) {
          return;
        } else {
          NewModelUtil.ShowModulePropertiesDialog(NewModelFromSource_Action.this.module, NewModelFromSource_Action.this.context);
        }
      }
      if (NewModelFromSource_Action.this.module.getSModelRoots().size() == 0) {
        JOptionPane.showMessageDialog(NewModelFromSource_Action.this.frame, "Can't create a model in solution with no model roots", "Can't create model", JOptionPane.ERROR_MESSAGE);
        return;
      }
      final Wrappers._T<NewModelDialog> dialog = new Wrappers._T<NewModelDialog>();
      final IOperationContext localContext = NewModelFromSource_Action.this.context;
      final IModule localModule = (localContext.getModule() != null ?
        localContext.getModule() :
        NewModelFromSource_Action.this.module
      );
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          String stereotype = NewModelFromSource_Action.this.getStereotype();
          dialog.value = new NewModelDialog(localModule, NewModelFromSource_Action.this.getNamespace(), localContext, stereotype, NewModelFromSource_Action.this.isStrict());
        }
      });
      dialog.value.showDialog();
      SModelDescriptor result = dialog.value.getResult();
      if (result != null) {
        TreeFileChooser treeFileChooser = new TreeFileChooser();
        treeFileChooser.setDirectoriesAreAlwaysVisible(true);
        treeFileChooser.setMode(TreeFileChooser.MODE_DIRECTORIES);
        final SModel sModel = result.getSModel();
        treeFileChooser.setFileFilter(new IFileFilter() {
          public boolean accept(IFile file) {
            return JavaCompiler.checkBaseModelMatchesSourceDirectory(sModel, new File(file.getAbsolutePath()));
          }
        });
        String generatorOutputPath = NewModelFromSource_Action.this.module.getGeneratorOutputPath();
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
        IFile resultFile = treeFileChooser.showDialog(NewModelFromSource_Action.this.frame);
        if (resultFile != null) {
          JavaCompiler javaCompiler = new JavaCompiler(NewModelFromSource_Action.this.context, NewModelFromSource_Action.this.module, new File(resultFile.getAbsolutePath()), false, sModel);
          javaCompiler.compile();
        }
        SModelDescriptor modelDescriptor = result;
        ProjectPane.getInstance(NewModelFromSource_Action.this.project).selectModel(modelDescriptor, false);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewModelFromSource", t);
      }
    }
  }

  protected String getStereotype() {
    if (NewModelFromSource_Action.this.treeNode instanceof StereotypeProvider) {
      return ((StereotypeProvider) NewModelFromSource_Action.this.treeNode).getStereotype();
    }
    return null;
  }

  protected boolean isStrict() {
    if (NewModelFromSource_Action.this.treeNode instanceof StereotypeProvider) {
      return ((StereotypeProvider) NewModelFromSource_Action.this.treeNode).isStrict();
    }
    return false;
  }

  protected String getNamespace() {
    return null;
  }
}
