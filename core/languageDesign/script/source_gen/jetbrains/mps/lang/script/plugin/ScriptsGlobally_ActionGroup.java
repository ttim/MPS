package jetbrains.mps.lang.script.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import java.util.Set;
import com.intellij.openapi.util.Pair;
import jetbrains.mps.workbench.ActionPlace;
import jetbrains.mps.util.Condition;
import jetbrains.mps.workbench.action.BaseAction;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.Nullable;

public class ScriptsGlobally_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(ScriptsGlobally_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.script.plugin.ScriptsGlobally_ActionGroup";

  private Set<Pair<ActionPlace, Condition<BaseAction>>> myPlaces = SetSequence.fromSet(new HashSet<Pair<ActionPlace, Condition<BaseAction>>>());

  public ScriptsGlobally_ActionGroup() {
    super("Scripts", ID);
    this.setIsInternal(false);
    this.setMnemonic("S".charAt(0));
    this.setPopup(true);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void doUpdate(AnActionEvent event) {
    try {
      ScriptsGlobally_ActionGroup.this.removeAll();
      event.getPresentation().setVisible(true);
      Project project = event.getData(MPSDataKeys.PROJECT);
      if (project == null) {
        event.getPresentation().setEnabled(false);
        return;
      }
      event.getPresentation().setEnabled(true);
      // 
      ScriptsMenuBuilder menuBuilder = new ScriptsMenuBuilder(false);
      ScriptsGlobally_ActionGroup.this.add(menuBuilder.create_ByCategoryPopup());
      ScriptsGlobally_ActionGroup.this.add(menuBuilder.create_ByBuildPopup());
      ScriptsGlobally_ActionGroup.this.add(menuBuilder.create_ByLanguagePopup());
      // 
      ScriptsGlobally_ActionGroup.this.addParameterizedAction(new RunMigrationScripts_Action(menuBuilder.getAllScripts(), false), PluginId.getId("jetbrains.mps.lang.script"), menuBuilder.getAllScripts(), false);
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
