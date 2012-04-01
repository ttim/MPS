package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import java.awt.Frame;
import jetbrains.mps.ide.dialogs.project.creation.NewGeneratorDialog;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.project.Project;

public class NewGenerator_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(NewGenerator_Action.class);

  public NewGenerator_Action() {
    super("Generator", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((IModule) MapSequence.fromMap(_params).get("module")) != null && ((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language && ((Language) ((IModule) MapSequence.fromMap(_params).get("module"))).getGenerators().isEmpty();
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "NewGenerator", t);
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
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Frame localFrame = ((Frame) MapSequence.fromMap(_params).get("frame"));
      final NewGeneratorDialog[] dialog = new NewGeneratorDialog[1];
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          dialog[0] = new NewGeneratorDialog(localFrame, ((Language) ((IModule) MapSequence.fromMap(_params).get("module"))));
        }
      });
      dialog[0].showDialog();
      Generator result = dialog[0].getResult();
      if (result != null) {
        ProjectPane.getInstance(((Project) MapSequence.fromMap(_params).get("project"))).selectModule(result, false);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "NewGenerator", t);
      }
    }
  }
}
