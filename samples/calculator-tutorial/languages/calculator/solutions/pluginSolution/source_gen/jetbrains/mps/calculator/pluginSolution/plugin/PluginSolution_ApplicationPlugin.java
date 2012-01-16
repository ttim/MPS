package jetbrains.mps.calculator.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.NodeActions_ActionGroup;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.calculator.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new ExecuteCalculator_Action());
    // groups 
    addGroup(new NodeActionsAddition_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(NodeActionsAddition_ActionGroup.ID, NodeActions_ActionGroup.ID, null);
  }
}
