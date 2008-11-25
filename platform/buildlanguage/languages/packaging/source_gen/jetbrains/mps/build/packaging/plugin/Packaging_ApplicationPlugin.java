package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import java.util.List;
import jetbrains.mps.workbench.action.BaseGroup;
import java.util.ArrayList;
import jetbrains.mps.workbench.action.ActionFactory;

public class Packaging_ApplicationPlugin extends BaseApplicationPlugin {

  public List<BaseGroup> initGroups() {
    List<BaseGroup> groups = new ArrayList<BaseGroup>();
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ProjectPaneModelAddition_ActionGroup.class, "jetbrains.mps.build.packaging"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ProjectPaneProjectAddition_ActionGroup.class, "jetbrains.mps.build.packaging"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(SNodeAddition_ActionGroup.class, "jetbrains.mps.build.packaging"));
    return groups;
  }

}
