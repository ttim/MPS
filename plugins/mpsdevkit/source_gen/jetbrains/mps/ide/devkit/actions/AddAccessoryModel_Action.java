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
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.IModule;
import java.util.List;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import java.awt.Frame;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.smodel.IScope;
import javax.swing.JOptionPane;
import jetbrains.mps.smodel.SModelRepository;

public class AddAccessoryModel_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddAccessoryModel_Action.class);

  public AddAccessoryModel_Action() {
    super("Add Accessory Model", "", ICON);
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
        log.error("User's action doUpdate method failed. Action:" + "AddAccessoryModel", t);
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
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.CONTEXT_MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
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
      final Language language = ((Language) ((IModule) MapSequence.fromMap(_params).get("module")));
      final List<SModelReference> models = ListSequence.fromList(new ArrayList<SModelReference>());
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          List<SModelDescriptor> descriptors = GlobalScope.getInstance().getModelDescriptors();
          ListSequence.fromList(models).addSequence(ListSequence.fromList(descriptors).select(new ISelector<SModelDescriptor, SModelReference>() {
            public SModelReference select(SModelDescriptor it) {
              return it.getSModelReference();
            }
          }));
        }
      });
      final SModelReference result = CommonChoosers.showDialogModelChooser(((Frame) MapSequence.fromMap(_params).get("frame")), models, null);
      if (result == null) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          LanguageDescriptor descriptor;
          descriptor = language.getModuleDescriptor();
          descriptor.getAccessoryModels().add(result);
          language.setLanguageDescriptor(descriptor, true);
          IScope scope = language.getScope();
          if (scope.getModelDescriptor(result) == null) {
            int res = JOptionPane.showConfirmDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "<html>Model <b>" + result.getLongName() + "</b> is added to accessories</html>\n\n" + "Do you want to automatically the module add to dependency?", "Add Dependency", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
              SModelDescriptor md = SModelRepository.getInstance().getModelDescriptor(result);
              language.addDependency(md.getModule().getModuleReference(), false);
            }
          }
          language.save();
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddAccessoryModel", t);
      }
    }
  }
}
