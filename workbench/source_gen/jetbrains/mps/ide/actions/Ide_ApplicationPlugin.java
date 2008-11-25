package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import java.util.List;
import jetbrains.mps.workbench.action.BaseGroup;
import java.util.ArrayList;
import jetbrains.mps.workbench.action.ActionFactory;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.Constraints;
import com.intellij.openapi.actionSystem.Anchor;

public class Ide_ApplicationPlugin extends BaseApplicationPlugin {

  public List<BaseGroup> initGroups() {
    List<BaseGroup> groups = new ArrayList<BaseGroup>();
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(NodeActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ModelActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ProjectActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ProjectNewActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(LanguageActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(LanguageNewActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(SolutionActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(SolutionNewActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(DevkitActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(GeneratorNewActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(GeneratorActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(TransientModulesActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(EditorPopup_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(EditorInternal_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Edit_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Generate_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Goto_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Tools_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Help_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(NodeActionsInternal_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ModelActionsInternal_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(LanguageNewCustomPartActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(Build_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(AbstractFileActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(FileActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(FolderActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ModuleActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(ModelRefactoring_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(LanguageRefactoring_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(SolutionRefactoring_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(PackageActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(NamespaceActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(PackageInternalActions_ActionGroup.class, "jetbrains.mps.ide"));
    groups.add(ActionFactory.getInstance().acquireRegisteredGroup(NamespaceInternalActions_ActionGroup.class, "jetbrains.mps.ide"));
    return groups;
  }

  public void adjustInterfaceGroups() {
    {
      BaseGroup gToBase = ActionUtils.getGroup(ModelActions_ActionGroup.ID);
      ActionGroup gWhat = ActionUtils.getDefaultGroup("VcsGroup");
      if (gToBase == null || gWhat == null) {
        return;
      }
      {
        String labelName = null;
        labelName = ModelActions_ActionGroup.LABEL_ID_vcs;
        Constraints constraints = new Constraints(Anchor.AFTER, labelName);
        gToBase.add(gWhat, constraints);
      }
    }
    {
      BaseGroup gToBase = ActionUtils.getGroup(AbstractFileActions_ActionGroup.ID);
      ActionGroup gWhat = ActionUtils.getDefaultGroup("VcsGroup");
      if (gToBase == null || gWhat == null) {
        return;
      }
      {
        String labelName = null;
        labelName = AbstractFileActions_ActionGroup.LABEL_ID_vcs;
        Constraints constraints = new Constraints(Anchor.AFTER, labelName);
        gToBase.add(gWhat, constraints);
      }
    }
    {
      BaseGroup gToBase = ActionUtils.getGroup(EditorPopup_ActionGroup.ID);
      ActionGroup gWhat = ActionUtils.getDefaultGroup("VcsGroup");
      if (gToBase == null || gWhat == null) {
        return;
      }
      {
        String labelName = null;
        labelName = EditorPopup_ActionGroup.LABEL_ID_vcs;
        Constraints constraints = new Constraints(Anchor.AFTER, labelName);
        gToBase.add(gWhat, constraints);
      }
    }
  }

}
