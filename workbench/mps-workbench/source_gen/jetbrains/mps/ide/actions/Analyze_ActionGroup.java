package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;

public class Analyze_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(Analyze_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Analyze_ActionGroup";

  public Analyze_ActionGroup() {
    super("Analyze", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      Analyze_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AnalyzeDependencies_Action");
      Analyze_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AnalyzeModuleDependencies_Action");
      Analyze_ActionGroup.this.addSeparator();
      Analyze_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AnalyzeStacktrace_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
