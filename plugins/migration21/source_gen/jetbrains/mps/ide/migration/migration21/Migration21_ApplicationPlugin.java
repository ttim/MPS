package jetbrains.mps.ide.migration.migration21;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.Tools_ActionGroup;

public class Migration21_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.migration21");

  public Migration21_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddPluginDependencies_Action());
    addAction(new AddSourcesToModelRoots_Action());
    addAction(new AddStubsToModelRoots_Action());
    addAction(new CorrectIconsAfterPluhinMove_Action());
    addAction(new MovePluginsOutOfLanguages_Action());
    // groups 
    addGroup(new Migrations21_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(Migrations21_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_migration);
  }
}
