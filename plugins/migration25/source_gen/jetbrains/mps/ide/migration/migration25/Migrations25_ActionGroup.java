package jetbrains.mps.ide.migration.migration25;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;

public class Migrations25_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(Migrations25_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.migration.migration25.Migrations25_ActionGroup";
  public static final String LABEL_ID_optional = ID + "optional";

  public Migrations25_ActionGroup() {
    super("Migrations 2.5", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.UpgradePersistence_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.AddStubsToModelRoots_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.AddSourcesToModelRoots_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.AddPluginDependencies_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.AddGenerationSupportLanguages_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.AddExtendedLanguagesAsUsed_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_APIMigration_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_APIMigrationStandalone_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_ConvertActionParameterCondition_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_ExecutionAPIMigration_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_JavaAPIMigration_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_DebuggerMoved_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_FixReferencesToMpsLaunch_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_SplitMPSClasspath_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_RemoveKeystrokes_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_UpgradeProcessBuilder_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.MigrationScript_ResolveBrokenRefs_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.ExecuteModelCheckerFixes_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.ExecuteJavaModelCheckerFixes_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.OptimizeImportsInProject_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.FixMissingImportsInProject_Action");
      Migrations25_ActionGroup.this.addAction("jetbrains.mps.ide.migration.migration25.ImportModelsWithUsedClassifiers_Action");
      {
        LabelledAnchor action = new LabelledAnchor(Migrations25_ActionGroup.LABEL_ID_optional);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide.migration25"));
        Migrations25_ActionGroup.this.addAction(action);
      }
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
