package jetbrains.mps.lang.typesystem.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.BaseKeymapChanges;
import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.DebugActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorInternal_ActionGroup;
import java.util.List;

import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.lang.typesystem.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new GoToTypeErrorRule_Action());
    addAction(new ShowExpectedType_Action());
    addAction(new ShowInferredNodeType_Action());
    addAction(new ShowNodeType_Action());
    addAction(new ShowRulesWhichAffectNodeType_Action());
    // groups 
    addGroup(new GoToTypeErrorGroup_ActionGroup());
    addGroup(new InternalTypeSystemActions_ActionGroup());
    addGroup(new TypesystemActions_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(GoToTypeErrorGroup_ActionGroup.ID, TypesystemActions_ActionGroup.ID, null);
    insertGroupIntoAnother(TypesystemActions_ActionGroup.ID, DebugActions_ActionGroup.ID, DebugActions_ActionGroup.LABEL_ID_types);
    insertGroupIntoAnother(InternalTypeSystemActions_ActionGroup.ID, EditorInternal_ActionGroup.ID, null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
