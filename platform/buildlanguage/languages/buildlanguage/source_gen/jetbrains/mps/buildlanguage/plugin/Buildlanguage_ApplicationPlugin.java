package jetbrains.mps.buildlanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import java.util.List;
import jetbrains.mps.workbench.action.BaseGroup;
import java.util.ArrayList;

public class Buildlanguage_ApplicationPlugin extends BaseApplicationPlugin {

  public List<BaseGroup> initGroups() {
    List<BaseGroup> groups = new ArrayList<BaseGroup>();
    groups.add(new ProjectPaneLanguageAddition_ActionGroup());
    return groups;
  }

}
