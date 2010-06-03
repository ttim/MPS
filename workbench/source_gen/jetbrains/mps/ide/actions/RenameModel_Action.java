package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import java.awt.Frame;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.IModule;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.ModelRootUtil;
import jetbrains.mps.refactoring.renameModel.RenameModelDialog;

public class RenameModel_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RenameModel_Action.class);

  private Project project;
  private Frame frame;
  private SModelDescriptor model;
  private IModule module;

  public RenameModel_Action() {
    super("Rename Model", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "shift F6";
  }

  public boolean isApplicable(AnActionEvent event) {
    if (!(RenameModel_Action.this.module instanceof Language)) {
      return true;
    }
    return Language.isLanguageOwnedAccessoryModel(RenameModel_Action.this.model);
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RenameModel", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    this.model = event.getData(MPSDataKeys.MODEL);
    if (this.model == null) {
      return false;
    }
    this.module = event.getData(MPSDataKeys.CONTEXT_MODULE);
    if (this.module == null) {
      return false;
    }
    return true;
  }

  protected void cleanup() {
    super.cleanup();
    this.project = null;
    this.frame = null;
    this.model = null;
    this.module = null;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final Wrappers._T<SModelRoot> root = new Wrappers._T<SModelRoot>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          root.value = ModelRootUtil.getSModelRoot(RenameModel_Action.this.model);
        }
      });
      new RenameModelDialog(RenameModel_Action.this.project, RenameModel_Action.this.frame, root.value, RenameModel_Action.this.model).showDialog();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RenameModel", t);
      }
    }
  }
}
