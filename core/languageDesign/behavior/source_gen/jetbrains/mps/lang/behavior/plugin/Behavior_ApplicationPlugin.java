package jetbrains.mps.lang.behavior.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.EditorPopup_ActionGroup;
import jetbrains.mps.ide.actions.Code_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Behavior_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.lang.behavior");

  public Behavior_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new ImplementBehaviorMethod_Action());
    addAction(new OverrideBehaviorMethod_Action());
    // groups 
    addGroup(new BehaviorCodeOverrideImplementMenuGroup_ActionGroup());
    addGroup(new BehaviourPopup_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(BehaviourPopup_ActionGroup.ID, EditorPopup_ActionGroup.ID, null);
    insertGroupIntoAnother(BehaviorCodeOverrideImplementMenuGroup_ActionGroup.ID, Code_ActionGroup.ID, Code_ActionGroup.LABEL_ID_overrideImplement);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
