package jetbrains.mps.lang.typesystem.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.ide.actions.EditorPopup_ActionGroup;

public class TypesystemActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(TypesystemActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.typesystem.plugin.TypesystemActions";

  public TypesystemActions_ActionGroup() {
    super("Type System", ID);
    this.setIsInternal(false);
    this.setMnemonic("T".charAt(0));
    this.setPopup(true);
    try {
      TypesystemActions_ActionGroup.this.addAction("jetbrains.mps.lang.typesystem.plugin.ShowNodeType_Action", "jetbrains.mps.lang.typesystem");
      TypesystemActions_ActionGroup.this.addAction("jetbrains.mps.lang.typesystem.plugin.GoToTypeErrorRule_Action", "jetbrains.mps.lang.typesystem");
      TypesystemActions_ActionGroup.this.addAction("jetbrains.mps.lang.typesystem.plugin.ShowRulesWhichAffectNodeType_Action", "jetbrains.mps.lang.typesystem");
      TypesystemActions_ActionGroup.this.addAction("jetbrains.mps.lang.typesystem.plugin.ShowInferredNodeType_Action", "jetbrains.mps.lang.typesystem");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    this.insertGroupIntoAnother(EditorPopup_ActionGroup.ID, null);
  }
}
