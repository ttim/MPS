package jetbrains.mps.bootstrap.helgins.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.actions.EditorPopup_ActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.action.BaseGroup;
import jetbrains.mps.workbench.actions.nodes.ShowNodeTypeAction;

public class TypesystemActions_ActionGroup extends GeneratedActionGroup {
  public static Logger LOG = Logger.getLogger(TypesystemActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.bootstrap.helgins.plugin.TypesystemActions";

  public TypesystemActions_ActionGroup() {
    super("Type System", ID);
    this.setIsAlwaysVisible(true);
    this.setIsInternal(false);
    this.setMnemonic("T".charAt(0));
    this.setPopup(true);
    try {
      this.add(new ShowNodeTypeAction());
      this.add(new GoToTypeErrorRule_Action());
      this.add(new ShowRulesWhichAffectNodeType_Action());
      this.add(new GoToNodeThisDependsOn_Action());
      this.add(new ShowSupertypes_Action());
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    {
      BaseGroup gToBase = ActionUtils.getGroup(EditorPopup_ActionGroup.ID);
      BaseGroup gWhat = ActionUtils.getGroup(TypesystemActions_ActionGroup.ID);
      if (gToBase == null || gWhat == null) {
        return;
      }
      gToBase.add(gWhat);
    }
  }

}
