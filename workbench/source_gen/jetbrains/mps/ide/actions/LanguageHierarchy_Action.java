package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.IModule;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.workbench.languagesFs.MPSLanguageVirtualFile;
import jetbrains.mps.workbench.languagesFs.MPSLanguagesVirtualFileSystem;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditor;
import jetbrains.mps.workbench.editors.MPSLanguageEditor;

public class LanguageHierarchy_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(LanguageHierarchy_Action.class);

  public Project project;
  public IModule module;

  public LanguageHierarchy_Action() {
    super("Language Diagram", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull()
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    return LanguageHierarchy_Action.this.module instanceof Language;
  }

  public void doUpdate(@NotNull() AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "LanguageHierarchy", t);
      }
      this.disable(event.getPresentation());
    }
  }

  @Override()
  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    this.module = event.getData(MPSDataKeys.MODULE);
    if (this.module == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull() final AnActionEvent event) {
    try {
      Language language = (Language)LanguageHierarchy_Action.this.module;
      MPSLanguageVirtualFile file = MPSLanguagesVirtualFileSystem.getInstance().getFileFor(language);
      FileEditorManager editorManager = FileEditorManager.getInstance(LanguageHierarchy_Action.this.project);
      FileEditor[] res = editorManager.openFile(file, true);
      MPSLanguageEditor languageEditor = (MPSLanguageEditor)res[0];
      languageEditor.getComponent().requestFocus();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "LanguageHierarchy", t);
      }
    }
  }

}
