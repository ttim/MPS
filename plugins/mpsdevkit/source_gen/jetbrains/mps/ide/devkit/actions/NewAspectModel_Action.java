package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.LanguageAspect;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.smodel.SModelDescriptor;
import javax.swing.SwingUtilities;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;

public class NewAspectModel_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewAspectModel_Action.class);

  private LanguageAspect aspect;

  public NewAspectModel_Action(LanguageAspect aspect_par) {
    super("Aspect Model", "", ICON);
    this.aspect = aspect_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      event.getPresentation().setText(NameUtil.capitalize(NewAspectModel_Action.this.aspect.getName()) + " Aspect");
      event.getPresentation().setIcon(IconManager.getIconForAspect(NewAspectModel_Action.this.aspect));
      if (((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language) {
        NewAspectModel_Action.this.setEnabledState(event.getPresentation(), NewAspectModel_Action.this.aspect.get(((Language) ((IModule) MapSequence.fromMap(_params).get("module")))) == null);
      } else {
        NewAspectModel_Action.this.setEnabledState(event.getPresentation(), false);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewAspectModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("ideaProject", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("ideaProject") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final SModelDescriptor modelDescriptor = NewAspectModel_Action.this.aspect.createNew(((Language) ((IModule) MapSequence.fromMap(_params).get("module"))));
      // we need it since tree is updated later 
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("ideaProject"))).selectModel(modelDescriptor, false);
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewAspectModel", t);
      }
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(aspect_State((LanguageAspect) this.aspect));
    res.append("!");
    return res.toString();
  }

  public static String aspect_State(LanguageAspect object) {
    return object.getName();
  }
}
