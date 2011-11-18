package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.LanguageActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorPopup_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Core_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.lang.core");

  public Core_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new FindLanguageConceptsUsages_Action());
    addAction(new FindLanguageUsages_Action());
    addAction(new FindModelUsages_Action());
    addAction(new Rename_Action());
    addAction(new ShowNodeMessages_Action());
    // groups 
    addGroup(new CoreActions_ActionGroup());
    addGroup(new FindLanguageUsages_ActionGroup());
    addGroup(new FindModelUsages_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(FindModelUsages_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_modelUsages);
    insertGroupIntoAnother(FindLanguageUsages_ActionGroup.ID, LanguageActions_ActionGroup.ID, LanguageActions_ActionGroup.LABEL_ID_find_usages);
    insertGroupIntoAnother(CoreActions_ActionGroup.ID, EditorPopup_ActionGroup.ID, null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
