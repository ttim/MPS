package jetbrains.mps.lang.script.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import java.util.Set;
import com.intellij.openapi.util.Pair;
import jetbrains.mps.workbench.ActionPlace;
import jetbrains.mps.util.Condition;
import jetbrains.mps.workbench.action.BaseAction;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.workbench.action.BaseGroup;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.Nullable;

public class ScriptsForSelection_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ScriptsForSelection_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.script.pluginSolution.plugin.ScriptsForSelection_ActionGroup";

  private Set<Pair<ActionPlace, Condition<BaseAction>>> myPlaces = SetSequence.fromSet(new HashSet<Pair<ActionPlace, Condition<BaseAction>>>());

  public ScriptsForSelection_ActionGroup() {
    super("Scripts", ID);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void doUpdate(AnActionEvent event) {
    try {
      ScriptsForSelection_ActionGroup.this.removeAll();
      event.getPresentation().setVisible(true);
      IOperationContext context = event.getData(MPSCommonDataKeys.OPERATION_CONTEXT);
      if (context == null || context.getProject() == null) {
        event.getPresentation().setEnabled(false);
        return;
      }
      event.getPresentation().setEnabled(true);

      ScriptsMenuBuilder menuBuilder = new ScriptsMenuBuilder(true);
      BaseGroup catGroup = menuBuilder.create_ByCategoryPopup();
      for (AnAction a : catGroup.getChildren(null)) {
        ScriptsForSelection_ActionGroup.this.add(a);
      }
      ScriptsForSelection_ActionGroup.this.addParameterizedAction(new RunMigrationScripts_Action(menuBuilder.getAllScripts(), true), PluginId.getId("jetbrains.mps.lang.script.pluginSolution"), menuBuilder.getAllScripts(), true);
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
    for (Pair<ActionPlace, Condition<BaseAction>> p : this.myPlaces) {
      this.addPlace(p.first, p.second);
    }
  }

  public void addPlace(ActionPlace place, @Nullable Condition<BaseAction> cond) {
    SetSequence.fromSet(this.myPlaces).addElement(new Pair<ActionPlace, Condition<BaseAction>>(place, cond));
  }

  public boolean isStrict() {
    return false;
  }
}
