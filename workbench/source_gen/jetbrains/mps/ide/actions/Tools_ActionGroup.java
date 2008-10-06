package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.actions.ReloadAllAction;
import jetbrains.mps.workbench.actions.tools.InstallIDEAPluginAction;
import jetbrains.mps.smodel.persistence.def.v3.UpgradeModelsAction;
import jetbrains.mps.project.actions.UpgradeProjectsAction;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.action.BaseGroup;

public class Tools_ActionGroup extends GeneratedActionGroup {
  public static Logger LOG = Logger.getLogger(Tools_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.Tools";
  public static final String LABEL_ID_customTools = ID + "customTools";
  public static final String INTERNAL_LABEL_ID_Internal = ID + "Internal";

  public Tools_ActionGroup() {
    super("Tools", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.add(new ShowModuleRepository_Action());
      this.add(new ShowModelRepository_Action());
      this.addAnchor(Tools_ActionGroup.LABEL_ID_customTools);
      this.addSeparator();
      this.add(new ReloadAllAction());
      this.addSeparator();
      this.add(new InstallIDEAPluginAction());
      this.add(new UpgradeModelsAction());
      this.add(new UpgradeProjectsAction());
      this.addSeparator();
      this.addAnchor(Tools_ActionGroup.INTERNAL_LABEL_ID_Internal);
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
    {
      DefaultActionGroup gToDef = ActionUtils.getDefaultGroup("ToolsMenu");
      BaseGroup gWhat = ActionUtils.getGroup(Tools_ActionGroup.ID);
      if (gToDef == null || gWhat == null) {
        return;
      }
      gToDef.add(gWhat);
    }
  }

}
