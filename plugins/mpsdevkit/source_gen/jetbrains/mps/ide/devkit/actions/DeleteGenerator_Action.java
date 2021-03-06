package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Generator;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.workbench.dialogs.DeleteDialog;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.devkit.util.DeleteGeneratorHelper;

public class DeleteGenerator_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(DeleteGenerator_Action.class);

  public DeleteGenerator_Action() {
    super("Delete Generator...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
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
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("contxet", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("contxet") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final DeleteDialog.DeleteOption safeOption = new DeleteDialog.DeleteOption("Safe Delete", true, false);
      final DeleteDialog.DeleteOption filesOption = new DeleteDialog.DeleteOption("Delete Files", false, false);

      DeleteDialog dialog = new DeleteDialog(((Project) MapSequence.fromMap(_params).get("project")), "Delete Generator", "Are you sure you want to delete generator?\n\nThis operation is not undoable.", safeOption, filesOption);
      dialog.show();
      if (!(dialog.isOK())) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          Generator generator = ((Generator) ((IModule) MapSequence.fromMap(_params).get("module")));
          Language sourceLanguage = generator.getSourceLanguage();
          for (GeneratorDescriptor gen : ListSequence.fromList(sourceLanguage.getModuleDescriptor().getGenerators())) {
            if (generator.getModuleReference().getModuleId().equals(gen.getId())) {
              DeleteGeneratorHelper.deleteGenerator(((Project) MapSequence.fromMap(_params).get("project")), sourceLanguage, generator, gen, safeOption.selected, filesOption.selected);
              break;
            }
          }
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "DeleteGenerator", t);
      }
    }
  }
}
