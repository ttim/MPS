package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.library.BootstrapLanguages_DevKit;
import jetbrains.mps.smodel.SModelRepository;

public class RemoveBootstrapLanguagesDevKitFromLanguageModels_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(RemoveBootstrapLanguagesDevKitFromLanguageModels_Action.class);

  public RemoveBootstrapLanguagesDevKitFromLanguageModels_Action() {
    super("Remove Bootstrap Languages Devkit from Language Models", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      this.enable(event.getPresentation());
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RemoveBootstrapLanguagesDevKitFromLanguageModels", t);
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
      for (Language l : ListSequence.fromList(MPSModuleRepository.getInstance().getAllLanguages())) {
        for (EditableSModelDescriptor aspect : SetSequence.fromSet(l.getAspectModelDescriptors())) {
          SModel sModel = aspect.getSModel();
          if (sModel.importedDevkits().contains(BootstrapLanguages_DevKit.MODULE_REFERENCE)) {
            sModel.deleteDevKit(BootstrapLanguages_DevKit.MODULE_REFERENCE);
          }
        }
      }
      SModelRepository.getInstance().saveAll();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RemoveBootstrapLanguagesDevKitFromLanguageModels", t);
      }
    }
  }
}
