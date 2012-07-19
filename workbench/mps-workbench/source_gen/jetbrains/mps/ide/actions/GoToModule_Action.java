package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.featureStatistics.FeatureUsageTracker;
import jetbrains.mps.workbench.choose.modules.BaseModuleModel;
import com.intellij.navigation.NavigationItem;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.choose.modules.BaseModuleItem;
import jetbrains.mps.ide.projectPane.ProjectPane;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.DevKit;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import jetbrains.mps.workbench.actions.goTo.matcher.MpsPopupFactory;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.keymap.KeymapManager;
import com.intellij.openapi.actionSystem.CustomShortcutSet;
import jetbrains.mps.workbench.actions.goTo.NavigateCallback;
import com.intellij.openapi.application.ModalityState;

public class GoToModule_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(GoToModule_Action.class);

  public GoToModule_Action() {
    super("Go to Module", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
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
        log.error("User's action doUpdate method failed. Action:" + "GoToModule", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Project project = event.getData(PlatformDataKeys.PROJECT);
      assert project != null;
      FeatureUsageTracker.getInstance().triggerFeatureUsed("navigation.goto.module");
      // PsiDocumentManager.getInstance(project).commitAllDocuments(); 
      BaseModuleModel goToModuleModel = new BaseModuleModel(project, "module") {
        public NavigationItem doGetNavigationItem(final ModuleReference ref) {
          return new BaseModuleItem(ref) {
            public void navigate(boolean requestFocus) {
              ProjectPane projectPane = ProjectPane.getInstance(project);
              IModule module = MPSModuleRepository.getInstance().getModule(ref);
              projectPane.selectModule(module, true);
            }
          };
        }

        public ModuleReference[] find(IScope scope) {
          List<ModuleReference> modules = new ArrayList<ModuleReference>();
          for (IModule module : scope.getVisibleModules()) {
            if (!((module instanceof Solution || module instanceof Language || module instanceof DevKit))) {
              continue;
            }
            modules.add(module.getModuleReference());
          }
          return modules.toArray(new ModuleReference[modules.size()]);
        }
      };
      ChooseByNamePopup popup = MpsPopupFactory.createPackagePopup(project, goToModuleModel);
      Shortcut[] shortcuts = KeymapManager.getInstance().getActiveKeymap().getShortcuts(GoToModule_Action.this.getActionId());
      popup.setCheckBoxShortcut(new CustomShortcutSet(shortcuts));

      popup.invoke(new NavigateCallback(), ModalityState.current(), true);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "GoToModule", t);
      }
    }
  }
}
