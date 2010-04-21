package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.plugins.MacrosUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import javax.swing.tree.TreeNode;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.ModelRootUtil;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.ide.projectPane.ProjectPane;
import java.util.List;
import jetbrains.mps.ide.projectPane.SortUtil;

public class NewSubTestModel_Action extends GeneratedAction {
  private static final Icon ICON = IconManager.loadIcon(MacrosUtil.expandPath("${mps_home}/workbench/source/jetbrains/mps/ide/projectPane/nodes/testModel.png", "jetbrains.mps.ide"), true);
  protected static Log log = LogFactory.getLog(NewSubTestModel_Action.class);

  private Project ideaProject;
  private IOperationContext context;
  private SModelDescriptor model;
  private TreeNode treeNode;

  public NewSubTestModel_Action() {
    super("Test Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    if (!(NewSubTestModel_Action.this.treeNode instanceof SModelTreeNode)) {
      return false;
    }
    return SModelStereotype.NONE.equals(NewSubTestModel_Action.this.model.getStereotype());
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewSubTestModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.ideaProject = event.getData(MPSDataKeys.PROJECT);
    if (this.ideaProject == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.CONTEXT_MODEL);
    if (this.model == null) {
      return false;
    }
    this.treeNode = event.getData(MPSDataKeys.LOGICAL_VIEW_NODE);
    if (this.treeNode == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<SModelDescriptor> result = new Wrappers._T<SModelDescriptor>();
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          String namespace = NewSubTestModel_Action.this.getNamespace();
          String name = NewSubTestModel_Action.this.getTestModelName();
          SModelFqName newModelFqName = new SModelFqName(namespace, name, SModelStereotype.TESTS);
          result.value = NewSubTestModel_Action.this.model.getModule().createModel(newModelFqName, ModelRootUtil.getSModelRoot(NewSubTestModel_Action.this.model));
          SModel createdModel = result.value.getSModel();
          SModel sourceModel = NewSubTestModel_Action.this.model.getSModel();
          createdModel.addImportedModel(sourceModel.getSModelReference());
          for (SModel.ImportElement importElement : sourceModel.getImportElements()) {
            createdModel.addImportedModel(importElement.getModelReference());
          }
          for (ModuleReference importedLanguage : sourceModel.getExplicitlyImportedLanguages()) {
            createdModel.addLanguage(importedLanguage);
          }
          for (ModuleReference devKit : sourceModel.getDevKitRefs()) {
            createdModel.addDevKit(devKit);
          }
        }
      });
      ProjectPane.getInstance(NewSubTestModel_Action.this.ideaProject).selectModel(result.value);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewSubTestModel", t);
      }
    }
  }

  /*package*/ String getTestModelName() {
    StringBuilder builder = new StringBuilder();
    builder.append(NewSubTestModel_Action.this.model.getName());
    int testModelCount = 0;
    List<SModelDescriptor> models = NewSubTestModel_Action.this.model.getModule().getOwnModelDescriptors();
    List<SModelDescriptor> sortedModels = SortUtil.sortModels(models);
    for (SModelDescriptor md : sortedModels) {
      if (!(SModelStereotype.TESTS.equals(md.getStereotype()))) {
        continue;
      }
      String name = NewSubTestModel_Action.this.model.getLongName() + ((testModelCount == 0 ?
        "" :
        testModelCount
      ));
      if (name.equals(md.getLongName())) {
        testModelCount++;
      }
    }
    if (testModelCount != 0) {
      builder.append(testModelCount + "");
    }
    return builder.toString();
  }

  /*package*/ String getNamespace() {
    return NewSubTestModel_Action.this.model.getSModelFqName().getNamespace();
  }
}
