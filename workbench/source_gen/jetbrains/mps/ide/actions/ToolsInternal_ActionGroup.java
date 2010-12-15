package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class ToolsInternal_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ToolsInternal_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Internal";

  public ToolsInternal_ActionGroup() {
    super("Internal", ID);
    this.setIsInternal(true);
    this.setPopup(true);
    try {
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.RemoveTransientModels_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.DumpKeyStrokes_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.OptimizeImportsInGlobalScope_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.FixDependenciesEverywhere_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.RemoveLanguageDesignDevKitFromModels_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AddGeneralPurposeDevKitToLanguageModels_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AddLanguageDesingDevKitToLanguages_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.FindlAllBrokenReferences_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addAction("jetbrains.mps.ide.actions.LoadNonStubModels_Action", "jetbrains.mps.ide");
      ToolsInternal_ActionGroup.this.addSeparator();
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
  }
}
