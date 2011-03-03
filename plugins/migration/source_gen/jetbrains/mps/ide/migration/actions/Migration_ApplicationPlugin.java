package jetbrains.mps.ide.migration.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.Tools_ActionGroup;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.DevkitActions_ActionGroup;
import jetbrains.mps.ide.actions.LanguageActions_ActionGroup;
import jetbrains.mps.ide.actions.SolutionActions_ActionGroup;
import jetbrains.mps.ide.actions.ProjectActions_ActionGroup;

public class Migration_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.migration");

  public Migration_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new FixVirtualPackages_Action());
    addAction(new UpgradeModelPersistenceGlobally_Action());
    addAction(new UpgradeModelPersistenceInModel_Action());
    addAction(new UpgradeModelPersistenceInModule_Action());
    addAction(new UpgradeModelPersistenceInProject_Action());
    addAction(new UpgradeModulePersistenceGlobally_Action());
    // groups 
    addGroup(new MigrateModel_ActionGroup());
    addGroup(new MigrateModule_ActionGroup());
    addGroup(new MigrateProject_ActionGroup());
    addGroup(new Upgrade_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(Upgrade_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_internal);
    insertGroupIntoAnother(MigrateModel_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_migration);
    insertGroupIntoAnother(MigrateModule_ActionGroup.ID, DevkitActions_ActionGroup.ID, DevkitActions_ActionGroup.LABEL_ID_migration);
    insertGroupIntoAnother(MigrateModule_ActionGroup.ID, LanguageActions_ActionGroup.ID, LanguageActions_ActionGroup.LABEL_ID_migration);
    insertGroupIntoAnother(MigrateModule_ActionGroup.ID, SolutionActions_ActionGroup.ID, SolutionActions_ActionGroup.LABEL_ID_migration);
    insertGroupIntoAnother(MigrateProject_ActionGroup.ID, ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_migration);
  }
}
