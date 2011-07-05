package jetbrains.mps.vcs.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.Goto_ActionGroup;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorTabActions_ActionGroup;
import jetbrains.mps.ide.actions.NodeActions_ActionGroup;
import jetbrains.mps.ide.actions.CommonModuleActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorLeftPanelMenu_ActionGroup;

public class Vcs_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.vcs");

  public Vcs_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddToVcs_Action());
    addAction(new Annotate_Action());
    addAction(new GoToNextChange_Action());
    addAction(new GoToPreviousChange_Action());
    addAction(new IgnoreInVcs_Action());
    addAction(new InstalVcsAddons_Action());
    addAction(new ReRunMergeFromBackup_Action());
    addAction(new RollbackChanges_Action());
    addAction(new ShowDifferencesWithModelOnDisk_Action());
    addAction(new ShowDiffererenceWithCurrentRevision_Action());
    // groups 
    addGroup(new AnnotateGroup_ActionGroup());
    addGroup(new ChangesStrip_ActionGroup());
    addGroup(new GoToVCS_ActionGroup());
    addGroup(new InstallVcsAddons_ActionGroup());
    addGroup(new ShowDiffWithCurrRev_ActionGroup());
    addGroup(new VCSModelActions_ActionGroup());
    addGroup(new VCS_ActionGroup());
  }

  public void adjustInterfaceGroups() {
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(GoToVCS_ActionGroup.ID, Goto_ActionGroup.ID, Goto_ActionGroup.LABEL_ID_gotoVCS);
    insertGroupIntoAnother(VCSModelActions_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_mpsvcs);
    insertGroupIntoAnother(ShowDiffWithCurrRev_ActionGroup.ID, EditorTabActions_ActionGroup.ID, EditorTabActions_ActionGroup.LABEL_ID_diff);
    insertGroupIntoAnother(ShowDiffWithCurrRev_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_diff);
    insertGroupIntoAnother(VCS_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_vcs);
    insertGroupIntoAnother(AnnotateGroup_ActionGroup.ID, EditorLeftPanelMenu_ActionGroup.ID, null);
    insertGroupIntoAnother(InstallVcsAddons_ActionGroup.ID, "VcsGlobalGroup", null);
  }
}
