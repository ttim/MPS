package jetbrains.mps.lang.smodel.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.LanguageActions_ActionGroup;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.lang.smodel.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new CheckLangForJavaStubModels_Action());
    // groups 
    addGroup(new LanguageInternalAddition_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(LanguageInternalAddition_ActionGroup.ID, LanguageActions_ActionGroup.ID, LanguageActions_ActionGroup.LABEL_ID_find_javastub_usages);
  }
}
