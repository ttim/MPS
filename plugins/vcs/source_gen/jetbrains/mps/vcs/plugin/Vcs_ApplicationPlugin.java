package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorTabActions_ActionGroup;
import jetbrains.mps.ide.actions.NodeActions_ActionGroup;
import jetbrains.mps.ide.actions.CommonModuleActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorLeftPanelMenu_ActionGroup;

public class Vcs_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.vcs");

  public Vcs_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddModuleToVcs_Action());
    addAction(new Annotate_Action());
    addAction(new CompareTransientModels_Action());
    addAction(new IgnoreModuleInVcs_Action());
    addAction(new InstalVcsAddons_Action());
    addAction(new ReRunMergeFromBackup_Action());
    addAction(new ReportModelMergeProblem_Action());
    addAction(new ShowDifferencesWithModelOnDisk_Action());
    addAction(new ShowDiffererenceWithCurrentRevision_Action());
    // groups 
    addGroup(new AnnotateGroup_ActionGroup());
    addGroup(new MPSGlobalVcsGroup_ActionGroup());
    addGroup(new MakeFromChangesView_ActionGroup());
    addGroup(new ModuleVcsActions_ActionGroup());
    addGroup(new ShowDiffWithCurrRev_ActionGroup());
    addGroup(new VCSModelActions_ActionGroup());
  }

  public void adjustInterfaceGroups() {
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(MakeFromChangesView_ActionGroup.ID, "ChangesViewPopupMenu", null);
    insertGroupIntoAnother(VCSModelActions_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_mpsvcs);
    insertGroupIntoAnother(ShowDiffWithCurrRev_ActionGroup.ID, EditorTabActions_ActionGroup.ID, EditorTabActions_ActionGroup.LABEL_ID_diff);
    insertGroupIntoAnother(ShowDiffWithCurrRev_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_diff);
    insertGroupIntoAnother(ModuleVcsActions_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_ideavcs);
    insertGroupIntoAnother(AnnotateGroup_ActionGroup.ID, EditorLeftPanelMenu_ActionGroup.ID, null);
    insertGroupIntoAnother(MPSGlobalVcsGroup_ActionGroup.ID, "VcsGlobalGroup", null);
  }
}
