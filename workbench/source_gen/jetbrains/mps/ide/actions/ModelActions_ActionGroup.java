package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.workbench.actions.model.CreateRootNodeGroup;

public class ModelActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ModelActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.ModelActions";
  public static final String LABEL_ID_refactoring = ID + "refactoring";
  public static final String LABEL_ID_vcs = ID + "vcs";

  public ModelActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.add(new CreateRootNodeGroup());
      this.addAction("jetbrains.mps.workbench.actions.nodes.PasteNodeAction", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.workbench.actions.model.DeleteModelsAction", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.ide.actions.CloneModel_Action", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.ide.actions.CopyModelName_Action", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.workbench.actions.model.OptimizeImportsAction", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.ide.actions.AddMissingImports_Action", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.workbench.actions.model.ShowReferencesToMissingStuffAction", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.ide.actions.CheckModel_Action", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.workbench.actions.model.GenerateModelFilesAction", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.workbench.actions.model.GenerateModelTextAction", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.workbench.actions.model.ShowMappingsPartitioningAction", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.ide.actions.ShowDifferencesWithModelOnDisk_Action", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAction("jetbrains.mps.ide.actions.RevertMemoryChanges_Action", "jetbrains.mps.ide");
      this.addAction("jetbrains.mps.ide.actions.SaveModel_Action", "jetbrains.mps.ide");
      this.addSeparator();
      this.addAnchor(ModelActions_ActionGroup.LABEL_ID_refactoring);
      this.addSeparator();
      this.addAnchor(ModelActions_ActionGroup.LABEL_ID_vcs);
      this.addSeparator();
      this.addAction("jetbrains.mps.ide.actions.ModelProperties_Action", "jetbrains.mps.ide");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
