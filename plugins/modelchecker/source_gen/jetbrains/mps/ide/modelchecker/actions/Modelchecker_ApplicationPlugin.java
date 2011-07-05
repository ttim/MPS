package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.Tools_ActionGroup;
import jetbrains.mps.ide.actions.ProjectActions_ActionGroup;
import jetbrains.mps.ide.actions.CommonModuleActions_ActionGroup;
import jetbrains.mps.ide.actions.GeneratorActions_ActionGroup;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.ToolsInternal_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Modelchecker_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.modelchecker");

  public Modelchecker_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new CheckModel_Action());
    addAction(new CheckModule_Action());
    addAction(new CheckProject_Action());
    addAction(new FindAllAdapterUsages_Action());
    addAction(new FindlAllBrokenReferences_Action());
    addAction(new ShowModelChecker_Action());
    // groups 
    addGroup(new CheckModel_ActionGroup());
    addGroup(new CheckModule_ActionGroup());
    addGroup(new CheckProject_ActionGroup());
    addGroup(new ShowModelCheckerTool_ActionGroup());
    addGroup(new ToolsInternalEx_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(ShowModelCheckerTool_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_customTools);
    insertGroupIntoAnother(CheckProject_ActionGroup.ID, ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_check);
    insertGroupIntoAnother(CheckModule_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_check);
    insertGroupIntoAnother(CheckModule_ActionGroup.ID, GeneratorActions_ActionGroup.ID, GeneratorActions_ActionGroup.LABEL_ID_check);
    insertGroupIntoAnother(CheckModel_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_check);
    insertGroupIntoAnother(ToolsInternalEx_ActionGroup.ID, ToolsInternal_ActionGroup.ID, null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
