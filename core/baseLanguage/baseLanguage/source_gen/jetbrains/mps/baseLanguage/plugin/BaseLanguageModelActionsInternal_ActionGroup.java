package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.ide.actions.ModelActionsInternal_ActionGroup;

public class BaseLanguageModelActionsInternal_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(BaseLanguageModelActionsInternal_ActionGroup.class);
  public static final String ID = "jetbrains.mps.baseLanguage.plugin.BaseLanguageModelActionsInternal";

  public BaseLanguageModelActionsInternal_ActionGroup() {
    super("BaseLanguageModelActionsInternal", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    this.insertGroupIntoAnother(ModelActionsInternal_ActionGroup.ID, null);
  }

}
