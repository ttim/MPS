package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import javax.swing.tree.TreeNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.ModelRootUtil;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;
import java.util.List;
import jetbrains.mps.ide.projectPane.SortUtil;

public class NewSubTestModel_Action extends GeneratedAction {
  private static final Icon ICON = IconUtil.getIcon("testModel.png");
  protected static Log log = LogFactory.getLog(NewSubTestModel_Action.class);

  public NewSubTestModel_Action() {
    super("Test Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    if (!(((TreeNode) MapSequence.fromMap(_params).get("treeNode")) instanceof SModelTreeNode)) {
      return false;
    }
    return SModelStereotype.NONE.equals(((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getStereotype());
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewSubTestModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("ideaProject", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("ideaProject") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
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
      final Wrappers._T<SModelDescriptor> result = new Wrappers._T<SModelDescriptor>();
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          SModelFqName newModelFqName = new SModelFqName(NewSubTestModel_Action.this.getTestModelName(_params), SModelStereotype.TESTS);
          result.value = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getModule().createModel(newModelFqName, ModelRootUtil.getSModelRoot(((SModelDescriptor) MapSequence.fromMap(_params).get("model"))), null);
          SModel createdModel = result.value.getSModel();
          SModel sourceModel = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getSModel();
          createdModel.addModelImport(sourceModel.getSModelReference(), false);
          for (SModel.ImportElement importElement : sourceModel.importedModels()) {
            createdModel.addModelImport(sourceModel.getSModelReference(), false);
          }
          for (ModuleReference importedLanguage : sourceModel.importedLanguages()) {
            createdModel.addLanguage(importedLanguage);
          }
          for (ModuleReference devKit : sourceModel.importedDevkits()) {
            createdModel.addDevKit(devKit);
          }
        }
      });
      ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("ideaProject"))).selectModel(result.value, false);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewSubTestModel", t);
      }
    }
  }

  /*package*/ String getTestModelName(final Map<String, Object> _params) {
    StringBuilder builder = new StringBuilder();
    builder.append(((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getLongName());
    int testModelCount = 0;
    List<SModelDescriptor> models = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getModule().getOwnModelDescriptors();
    List<SModelDescriptor> sortedModels = SortUtil.sortModels(models);
    for (SModelDescriptor md : sortedModels) {
      if (!(SModelStereotype.TESTS.equals(md.getStereotype()))) {
        continue;
      }
      String name = ((SModelDescriptor) MapSequence.fromMap(_params).get("model")).getLongName() + ((testModelCount == 0 ?
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
}
