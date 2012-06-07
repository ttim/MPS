package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.Tools_ActionGroup;

public class Migration25_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.migration25");

  public Migration25_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddExtendedLanguagesAsUsed_Action());
    addAction(new AddGenerationSupportLanguages_Action());
    addAction(new AddPluginDependencies_Action());
    addAction(new AddSourcesToModelRoots_Action());
    addAction(new AddStubsToModelRoots_Action());
    addAction(new ConvertLanguageRuntimes_Action());
    addAction(new CorrectIconsAfterPluginMove_Action());
    addAction(new ExecuteJavaModelCheckerFixes_Action());
    addAction(new ExecuteModelCheckerFixes_Action());
    addAction(new FixMissingImportsInProject_Action());
    addAction(new ImportModelsWithUsedClassifiers_Action());
    addAction(new MigrationScript_APIMigrationStandalone_Action());
    addAction(new MigrationScript_APIMigration_Action());
    addAction(new MigrationScript_ConvertActionParameterCondition_Action());
    addAction(new MigrationScript_DebuggerMoved_Action());
    addAction(new MigrationScript_ExecutionAPIMigration_Action());
    addAction(new MigrationScript_FixReferencesToMpsLaunch_Action());
    addAction(new MigrationScript_JavaAPIMigration_Action());
    addAction(new MigrationScript_RemoveKeystrokes_Action());
    addAction(new MigrationScript_ResolveBrokenRefs_Action());
    addAction(new MigrationScript_SplitMPSClasspath_Action());
    addAction(new MigrationScript_UpgradeProcessBuilder_Action());
    addAction(new MovePluginsOutOfLanguages_Action());
    addAction(new OptimizeImportsInProject_Action());
    addAction(new OptimizeProjectImports_Action());
    addAction(new UpdateRefactoringVersions_Action());
    addAction(new UpgradePersistence_Action());
    // groups 
    addGroup(new Migrations25_ActionGroup());
    addGroup(new OptionalMigrations_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(Migrations25_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_migration);
    insertGroupIntoAnother(OptionalMigrations_ActionGroup.ID, Migrations25_ActionGroup.ID, Migrations25_ActionGroup.LABEL_ID_optional);
  }
}
