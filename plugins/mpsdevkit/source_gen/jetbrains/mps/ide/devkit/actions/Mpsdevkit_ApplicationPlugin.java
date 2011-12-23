package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.ProjectNewActions_ActionGroup;
import jetbrains.mps.ide.actions.CommonModuleActions_ActionGroup;
import jetbrains.mps.ide.actions.Tools_ActionGroup;
import jetbrains.mps.ide.actions.DebugActions_ActionGroup;
import jetbrains.mps.ide.actions.LanguageNewActions_ActionGroup;
import jetbrains.mps.ide.actions.GeneratorActions_ActionGroup;
import jetbrains.mps.ide.actions.EditorTabActions_ActionGroup;
import jetbrains.mps.ide.actions.GoToEditorPopupAddition_ActionGroup;
import jetbrains.mps.ide.actions.Goto_ActionGroup;
import jetbrains.mps.ide.actions.AnalyzeModule_ActionGroup;
import jetbrains.mps.ide.actions.NamespaceNewActions_ActionGroup;
import jetbrains.mps.ide.actions.NodeActions_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Mpsdevkit_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.mpsdevkit");

  public Mpsdevkit_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddAccessoryModel_Action());
    addAction(new CellProperties_Action());
    addAction(new DeleteGenerator_Action());
    addAction(new GoToConceptDeclaration_Action());
    addAction(new GoToEditorDeclaration_Action());
    addAction(new GoToRules_Action());
    addAction(new GoToUsageInMappingConfig_Action());
    addAction(new HighlightCellDependencies_Action());
    addAction(new InstallIDEAPlugin_Action());
    addAction(new LanguageHierarchy_Action());
    addAction(new LanguagePaths_Action());
    addAction(new NewAccessoryModel_Action());
    addAction(new NewDevKit_Action());
    addAction(new NewGenerator_Action());
    addAction(new NewLanguage_Action());
    addAction(new PrintNodeID_Action());
    addAction(new ReloadAll_Action());
    addAction(new RenameLanguage_Action());
    addAction(new ShowCellInExplorer_Action());
    addAction(new ShowGenerationTrace_Action());
    addAction(new ShowGenerationTraceback_Action());
    addAction(new ShowModelRepository_Action());
    addAction(new ShowModuleRepository_Action());
    addAction(new ShowNodeInExplorer_Action());
    addAction(new ShowTypeSystemTraceIncremental_Action());
    addAction(new ShowTypeSystemTrace_Action());
    addAction(new TestNodePath_Action());
    // groups 
    addGroup(new AccessoriesGroupActions_ActionGroup());
    addGroup(new DevKitTools_ActionGroup());
    addGroup(new EditorInternalEx_ActionGroup());
    addGroup(new GenerateEditorPopup_ActionGroup());
    addGroup(new GenerationTraceActions_ActionGroup());
    addGroup(new GeneratorActions_Delete_ActionGroup());
    addGroup(new GotoConceptAspect_ActionGroup());
    addGroup(new LanguageActionsEx_ActionGroup());
    addGroup(new LanguageNewActionsEx_ActionGroup());
    addGroup(new LanguageNewCustomPartActions_ActionGroup());
    addGroup(new LanguageNewGenerator_ActionGroup());
    addGroup(new LanguageRefactoring_ActionGroup());
    addGroup(new NamespaceNewActionsEx_ActionGroup());
    addGroup(new ProjectNewActionsEx_ActionGroup());
    addGroup(new RepositoryToolsGroup_ActionGroup());
    addGroup(new ShowNodeIn_ActionGroup());
    addGroup(new TraceActions_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(GenerateEditorPopup_ActionGroup.ID, "EditorPopup_ActionGroupgoto", null);
    insertGroupIntoAnother(ProjectNewActionsEx_ActionGroup.ID, ProjectNewActions_ActionGroup.ID, ProjectNewActions_ActionGroup.LABEL_ID_end);
    insertGroupIntoAnother(LanguageRefactoring_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_refactoring);
    insertGroupIntoAnother(RepositoryToolsGroup_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_customTools);
    insertGroupIntoAnother(GenerationTraceActions_ActionGroup.ID, DebugActions_ActionGroup.ID, DebugActions_ActionGroup.LABEL_ID_generator);
    insertGroupIntoAnother(LanguageNewGenerator_ActionGroup.ID, LanguageNewActions_ActionGroup.ID, LanguageNewActions_ActionGroup.LABEL_ID_newSubModule);
    insertGroupIntoAnother(LanguageNewActionsEx_ActionGroup.ID, LanguageNewActions_ActionGroup.ID, LanguageNewActions_ActionGroup.LABEL_ID_newModel);
    insertGroupIntoAnother(GeneratorActions_Delete_ActionGroup.ID, GeneratorActions_ActionGroup.ID, GeneratorActions_ActionGroup.LABEL_ID_delete);
    insertGroupIntoAnother(GotoConceptAspect_ActionGroup.ID, EditorTabActions_ActionGroup.ID, EditorTabActions_ActionGroup.LABEL_ID_gotoConceptAspects);
    insertGroupIntoAnother(GotoConceptAspect_ActionGroup.ID, GoToEditorPopupAddition_ActionGroup.ID, GoToEditorPopupAddition_ActionGroup.LABEL_ID_other);
    insertGroupIntoAnother(GotoConceptAspect_ActionGroup.ID, Goto_ActionGroup.ID, Goto_ActionGroup.LABEL_ID_gotoConceptAspects);
    insertGroupIntoAnother(LanguageActionsEx_ActionGroup.ID, AnalyzeModule_ActionGroup.ID, null);
    insertGroupIntoAnother(DevKitTools_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_devkitTools);
    insertGroupIntoAnother(EditorInternalEx_ActionGroup.ID, DebugActions_ActionGroup.ID, DebugActions_ActionGroup.LABEL_ID_editor);
    insertGroupIntoAnother(LanguageNewCustomPartActions_ActionGroup.ID, LanguageNewActions_ActionGroup.ID, LanguageNewActions_ActionGroup.LABEL_ID_newAspect);
    insertGroupIntoAnother(NamespaceNewActionsEx_ActionGroup.ID, NamespaceNewActions_ActionGroup.ID, null);
    insertGroupIntoAnother(TraceActions_ActionGroup.ID, DebugActions_ActionGroup.ID, DebugActions_ActionGroup.LABEL_ID_trace);
    insertGroupIntoAnother(ShowNodeIn_ActionGroup.ID, EditorTabActions_ActionGroup.ID, EditorTabActions_ActionGroup.LABEL_ID_showIn);
    insertGroupIntoAnother(ShowNodeIn_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_showIn);
    insertGroupIntoAnother(ShowNodeIn_ActionGroup.ID, "EditorPopup_ActionGroupshowIn", null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    ListSequence.fromList(res).addElement(new Trace_KeymapChanges());
    return res;
  }
}
