package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.workbench.choose.modules.BaseModuleModel;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ISelector;
import com.intellij.navigation.NavigationItem;
import jetbrains.mps.workbench.choose.modules.BaseModuleItem;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.ide.ui.MPSTreeNode;
import javax.swing.tree.TreeNode;
import jetbrains.mps.ide.util.gotoByName.ChooseByNamePopupMPS;
import jetbrains.mps.workbench.choose.base.FakePsiContext;
import com.intellij.ide.util.gotoByName.ChooseByNamePopupComponent;
import com.intellij.openapi.application.ModalityState;

public class NewRuntimeModule_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewRuntimeModule_Action.class);

  public NewRuntimeModule_Action() {
    super("New Runtime Module", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((IModule) MapSequence.fromMap(_params).get("contextModule")) instanceof Language;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewRuntimeModule", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("contextModule", event.getData(MPSDataKeys.CONTEXT_MODULE));
    if (MapSequence.fromMap(_params).get("contextModule") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
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
      final List<IModule> modules = ListSequence.fromList(new ArrayList<IModule>());
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          ListSequence.fromList(modules).addSequence(ListSequence.fromList(MPSModuleRepository.getInstance().getAllModules()));
        }
      });
      BaseModuleModel baseSolutionModel = new BaseModuleModel(((Project) MapSequence.fromMap(_params).get("project")), "runtime module") {
        public ModuleReference[] find(IScope p0) {
          return ListSequence.fromList(modules).<ModuleReference>select(new ISelector<IModule, ModuleReference>() {
            public ModuleReference select(IModule it) {
              return it.getModuleReference();
            }
          }).toGenericArray(ModuleReference.class);
        }

        public NavigationItem doGetNavigationItem(final ModuleReference module) {
          return new BaseModuleItem(module) {
            public void navigate(boolean p0) {
              if (module == null) {
                return;
              }
              Language language = (Language) ((IModule) MapSequence.fromMap(_params).get("contextModule"));
              Dependency dependency = new Dependency();
              dependency.setModuleRef(module);
              language.getModuleDescriptor().getRuntimeModules().add(dependency);
              language.save();
              ((MPSTreeNode) ((TreeNode) MapSequence.fromMap(_params).get("treeNode"))).getTree().rebuildLater();
            }
          };
        }
      };
      ChooseByNamePopupMPS popup = ChooseByNamePopupMPS.createPopup(((Project) MapSequence.fromMap(_params).get("project")), baseSolutionModel, new FakePsiContext());
      popup.invoke(new ChooseByNamePopupComponent.Callback() {
        public void elementChosen(Object p0) {
          ((NavigationItem) p0).navigate(true);
        }
      }, ModalityState.current(), true);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewRuntimeModule", t);
      }
    }
  }
}
