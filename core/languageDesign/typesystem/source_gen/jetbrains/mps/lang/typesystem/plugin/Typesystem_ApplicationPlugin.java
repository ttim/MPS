package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import java.util.List;
import jetbrains.mps.workbench.action.BaseGroup;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.workbench.action.ActionFactory;

public class Typesystem_ApplicationPlugin extends BaseApplicationPlugin {

  public List<BaseGroup> initGroups() {
    List<BaseGroup> groups = ListSequence.fromList(new ArrayList<BaseGroup>());
    String moduleName = "jetbrains.mps.lang.typesystem";
    this.addGroup(groups, moduleName, "jetbrains.mps.lang.typesystem.plugin.TypesystemActions_ActionGroup");
    this.addGroup(groups, moduleName, "jetbrains.mps.lang.typesystem.plugin.HelginsNodeActions_ActionGroup");
    this.addGroup(groups, moduleName, "jetbrains.mps.lang.typesystem.plugin.HelginsEditorPopupInternal_ActionGroup");
    this.addGroup(groups, moduleName, "jetbrains.mps.lang.typesystem.plugin.HelginsModelActions_ActionGroup");
    this.addGroup(groups, moduleName, "jetbrains.mps.lang.typesystem.plugin.HelginsToolsAddition_ActionGroup");
    return groups;
  }

  private void addGroup(List<BaseGroup> groups, String moduleName, String groupName) {
    BaseGroup group = ActionFactory.getInstance().acquireRegisteredGroup(groupName, moduleName);
    if (group != null) {
      ListSequence.fromList(groups).addElement(group);
    }
  }

}
