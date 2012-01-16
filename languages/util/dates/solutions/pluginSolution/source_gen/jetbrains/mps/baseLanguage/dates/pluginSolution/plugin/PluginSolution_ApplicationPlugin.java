package jetbrains.mps.baseLanguage.dates.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.ModelActionsInternal_ActionGroup;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.baseLanguage.dates.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new ConvertDateTimeOperations_Action());
    // groups 
    addGroup(new DateLangGroup_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(DateLangGroup_ActionGroup.ID, ModelActionsInternal_ActionGroup.ID, null);
  }
}
