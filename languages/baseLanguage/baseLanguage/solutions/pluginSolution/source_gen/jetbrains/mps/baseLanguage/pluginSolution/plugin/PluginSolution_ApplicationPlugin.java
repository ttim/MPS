package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.lang.intentions.pluginSolution.plugin.GenerationActions_ActionGroup;
import jetbrains.mps.ide.actions.ModelActionsInternal_ActionGroup;
import jetbrains.mps.ide.actions.NodeActionsInternal_ActionGroup;
import jetbrains.mps.ide.actions.Tools_ActionGroup;
import jetbrains.mps.lang.dataFlow.pluginSolution.plugin.DFAActions_ActionGroup;
import jetbrains.mps.ide.actions.Code_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class PluginSolution_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.baseLanguage.pluginSolution");

  public PluginSolution_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new ChangeMethodSignature_Action());
    addAction(new CommentLine_Action());
    addAction(new CommentStatements_Action());
    addAction(new ConvertAnonymousClass_Action());
    addAction(new ExtractMethod_Action());
    addAction(new GenerateConstructor_Action());
    addAction(new GenerateEqualsAndHashCode_Action());
    addAction(new GenerateGettersAndSetters_Action());
    addAction(new GenerateGetters_Action());
    addAction(new GenerateMainMethod_Action());
    addAction(new GenerateSetters_Action());
    addAction(new GenerateToString_Action());
    addAction(new GoToInheritedClassifier_Action());
    addAction(new GoToOverridenMethod_Action());
    addAction(new ImplementMethod_Action());
    addAction(new ImplementMethodsAsIntention_Action());
    addAction(new InlineLocalVariable_Action());
    addAction(new InlineMethod_Action());
    addAction(new IntroduceConstant_Action());
    addAction(new IntroduceField_Action());
    addAction(new IntroduceVariable_Action());
    addAction(new MakeFieldFinal_Action());
    addAction(new MakeFieldStatic_Action());
    addAction(new MoveStaticField_Action());
    addAction(new MoveStaticMethod_Action());
    addAction(new OverrideMethod_Action());
    addAction(new OverrideMethodsAsIntention_Action());
    addAction(new RenameMethod_Action());
    addAction(new RenameVariable_Action());
    addAction(new ShowMembers_Action());
    addAction(new ShowNullDFA_Action());
    addAction(new ShowTodoViewer_Action());
    addAction(new UncommentStatements_Action());
    // groups 
    addGroup(new AnalyzersActions_ActionGroup());
    addGroup(new BaseLangaugeCodeCommentsMenuGroup_ActionGroup());
    addGroup(new BaseLanguageEditorPopup_ActionGroup());
    addGroup(new BaseLanguageModelActionsInternal_ActionGroup());
    addGroup(new BaseLanguageNodeActionsInternal_ActionGroup());
    addGroup(new BaseLanguageToolsAddition_ActionGroup());
    addGroup(new BaseLangugeCodeOverrideImplementMenuGroup_ActionGroup());
    addGroup(new GenerateActions_ActionGroup());
    addGroup(new RefactoringAddition_ActionGroup());
    addGroup(new RefactoringAdditions_ActionGroup());
    addGroup(new ShowAsIntentions_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(GenerateActions_ActionGroup.ID, GenerationActions_ActionGroup.ID, null);
    insertGroupIntoAnother(BaseLanguageModelActionsInternal_ActionGroup.ID, ModelActionsInternal_ActionGroup.ID, null);
    insertGroupIntoAnother(RefactoringAddition_ActionGroup.ID, "jetbrains.mps.ide.platform.actions.NodeRefactoring_ActionGroup", null);
    insertGroupIntoAnother(BaseLanguageEditorPopup_ActionGroup.ID, "jetbrains.mps.ide.editor.actions.EditorPopup_ActionGroup", null);
    insertGroupIntoAnother(BaseLanguageNodeActionsInternal_ActionGroup.ID, NodeActionsInternal_ActionGroup.ID, null);
    insertGroupIntoAnother(BaseLanguageToolsAddition_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_customTools);
    insertGroupIntoAnother(AnalyzersActions_ActionGroup.ID, DFAActions_ActionGroup.ID, null);
    insertGroupIntoAnother(BaseLangugeCodeOverrideImplementMenuGroup_ActionGroup.ID, Code_ActionGroup.ID, Code_ActionGroup.LABEL_ID_overrideImplement);
    insertGroupIntoAnother(BaseLangaugeCodeCommentsMenuGroup_ActionGroup.ID, Code_ActionGroup.ID, Code_ActionGroup.LABEL_ID_comments);
    insertGroupIntoAnother(RefactoringAdditions_ActionGroup.ID, "jetbrains.mps.ide.platform.actions.NodeRefactoring_ActionGroup", null);
    insertGroupIntoAnother(ShowAsIntentions_ActionGroup.ID, "ActionsAsIntentions", null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
