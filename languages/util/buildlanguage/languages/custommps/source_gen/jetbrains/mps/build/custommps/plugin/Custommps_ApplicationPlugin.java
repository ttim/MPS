package jetbrains.mps.build.custommps.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.build.packaging.plugin.ProjectPaneProjectAddition_ActionGroup;
import java.util.List;
import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Custommps_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.build.custommps");

  public Custommps_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new GenerateCustomMPSBuildForProjectAction_Action());
    // groups 
    addGroup(new ProjectAddition_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(ProjectAddition_ActionGroup.ID, ProjectPaneProjectAddition_ActionGroup.ID, null);
  }

  public List<BaseCustomApplicationPlugin> initCustomParts() {
    List<BaseCustomApplicationPlugin> res = ListSequence.fromList(new ArrayList<BaseCustomApplicationPlugin>());
    addCustomPart(res, new RunConfigurationsInitializer_CustomApplicationPlugin());
    return res;
  }

  private void addCustomPart(List<BaseCustomApplicationPlugin> plugins, BaseCustomApplicationPlugin plugin) {
    ListSequence.fromList(plugins).addElement(plugin);
    plugin.init();
  }
}
