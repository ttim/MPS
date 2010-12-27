package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.workbench.dialogs.DeleteDialog;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.workbench.actions.language.DeleteGeneratorHelper;

public class DeleteGenerator_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(DeleteGenerator_Action.class);

  public DeleteGenerator_Action() {
    super("Delete Generator...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((IModule) MapSequence.fromMap(_params).get("module")) instanceof Generator;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "DeleteGenerator", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("contxet", event.getData(MPSDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("contxet") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final DeleteDialog dialog = new DeleteDialog(((Project) MapSequence.fromMap(_params).get("project")), "Delete Generator", "Are you sure you want to delete generator?\n\nThis operation is not undoable.");
      dialog.setOptions(true, false, false, false);
      dialog.show();
      if (!(dialog.isOK())) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          Generator generator = ((Generator) ((IModule) MapSequence.fromMap(_params).get("module")));
          Language sourceLanguage = generator.getSourceLanguage();
          int genIndex = sourceLanguage.getGenerators().indexOf(generator);
          GeneratorDescriptor genToDelete = sourceLanguage.getModuleDescriptor().getGenerators().get(genIndex);
          DeleteGeneratorHelper.deleteGenerator(((Project) MapSequence.fromMap(_params).get("project")), sourceLanguage, generator, genToDelete, dialog.isSafe(), dialog.isDeleteFiles());
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "DeleteGenerator", t);
      }
    }
  }
}
