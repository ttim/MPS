package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Ide_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide");

  public Ide_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new AddLanguageImport_Action());
    addAction(new AddMissingImportsInProject_Action());
    addAction(new AddMissingImports_Action());
    addAction(new AddModelImportByRoot_Action());
    addAction(new AddModelImport_Action());
    addAction(new AddModuleToProject_Action());
    addAction(new AddToNewFavoritesList_Action());
    addAction(new AnalyzeClasspath_Action());
    addAction(new AnalyzeDependencies_Action());
    addAction(new AnalyzeModuleDependencies_Action());
    addAction(new AnalyzeStacktrace_Action());
    addAction(new CloneModel_Action());
    addAction(new CloneRoot_Action());
    addAction(new CollapseAll_Action());
    addAction(new Collapse_Action());
    addAction(new CopyModelName_Action());
    addAction(new CopyModuleName_Action());
    addAction(new CopyNodeName_Action());
    addAction(new CopyNodeReference_Action());
    addAction(new CopyNode_Action());
    addAction(new CreateAspect_Action());
    addAction(new CutNode_Action());
    addAction(new DeleteFavoritesList_Action());
    addAction(new DeleteModels_Action());
    addAction(new DeleteModules_Action());
    addAction(new DeleteNode_Action());
    addAction(new DeletePropertyAction_Action());
    addAction(new DeleteReferenceAction_Action());
    addAction(new EditNode_Action());
    addAction(new ExpandAll_Action());
    addAction(new ExpandNode_Action());
    addAction(new Expand_Action());
    addAction(new FastFindNodeUsages_Action());
    addAction(new FindNext_Action());
    addAction(new FindPrevious_Action());
    addAction(new FindSpecificNodeUsages_Action());
    addAction(new Find_Action());
    addAction(new FoldSelection_Action());
    addAction(new GoByCurrentReference_Action());
    addAction(new GoToNodeById_Action());
    addAction(new GoToNode_Action());
    addAction(new GoToRule_Action());
    addAction(new HighlightInstances_Action());
    addAction(new HighlightUsages_Action());
    addAction(new MPSProjectPaths_Action());
    addAction(new ModelProperties_Action());
    addAction(new ModuleProperties_Action());
    addAction(new MoveFileOrDirectory_Action());
    addAction(new NewDirectory_Action());
    addAction(new NewFile_Action());
    addAction(new NewModel_Action());
    addAction(new NewRuntimeModule_Action());
    addAction(new NewSolution_Action());
    addAction(new NewSubModel_Action());
    addAction(new NewSubTestModel_Action());
    addAction(new OptimizeModelImports_Action());
    addAction(new OptimizeModuleImports_Action());
    addAction(new OptimizeProjectImports_Action());
    addAction(new PasteNode_Action());
    addAction(new PrintNodePosition_Action());
    addAction(new QuickCreate_Action());
    addAction(new RemoveAllBookmarks_Action());
    addAction(new RemoveFromFavorites_Action());
    addAction(new RemoveModuleFromProject_Action());
    addAction(new RemoveTransientModels_Action());
    addAction(new RenameFavoritesList_Action());
    addAction(new RenameFileOrDirectory_Action());
    addAction(new RenameModel_Action());
    addAction(new RenameNamespace_Action());
    addAction(new RenamePackage_Action());
    addAction(new RenameSolution_Action());
    addAction(new RevertMemoryChanges_Action());
    addAction(new SafeDeleteModuleDependency_Action());
    addAction(new SetBookmarkNoNumber_Action());
    addAction(new SetModuleFolder_Action());
    addAction(new SetNodePackage_Action());
    addAction(new ShowBookmarksDialog_Action());
    addAction(new ShowBookmarks_Action());
    addAction(new ShowClassInHierarchy_Action());
    addAction(new ShowConceptInHierarchy_Action());
    addAction(new ShowErrorMessage_Action());
    addAction(new ShowImplementations_Action());
    addAction(new ShowInDependenciesViewer_Action());
    addAction(new ShowInLogicalView_Action());
    addAction(new ShowModuleDependencyLoop_Action());
    addAction(new ShowNodeInInspector_Action());
    addAction(new ShowNodeInfo_Action());
    addAction(new ShowParameters_Action());
    addAction(new ShowStructure_Action());
    addAction(new SubmitToTracker_Action());
    // groups 
    addGroup(new AbstractFileActions_ActionGroup());
    addGroup(new AddToFavoritesGroup_ActionGroup());
    addGroup(new AnalyzeModule_ActionGroup());
    addGroup(new Analyze_ActionGroup());
    addGroup(new Bookmarks_ActionGroup());
    addGroup(new Build_ActionGroup());
    addGroup(new Code_ActionGroup());
    addGroup(new CommonModuleActions_ActionGroup());
    addGroup(new CreateRootNode_ActionGroup());
    addGroup(new DebugActions_ActionGroup());
    addGroup(new DevkitActions_ActionGroup());
    addGroup(new Edit_ActionGroup());
    addGroup(new EditorInternal_ActionGroup());
    addGroup(new EditorLeftPanelMenu_ActionGroup());
    addGroup(new EditorPopup_ActionGroup());
    addGroup(new EditorTabActions_ActionGroup());
    addGroup(new FavoritesPopupWrapper_ActionGroup());
    addGroup(new FavoritesPopup_ActionGroup());
    addGroup(new Favorites_ActionGroup());
    addGroup(new FileActions_ActionGroup());
    addGroup(new FileSystemNewActions_ActionGroup());
    addGroup(new FindUsages_ActionGroup());
    addGroup(new FolderActions_ActionGroup());
    addGroup(new Folding_ActionGroup());
    addGroup(new GeneratorActions_ActionGroup());
    addGroup(new GeneratorNewActions_ActionGroup());
    addGroup(new GoByReference_ActionGroup());
    addGroup(new GoToEditorPopupAddition_ActionGroup());
    addGroup(new Goto_ActionGroup());
    addGroup(new JUnitTestCaseActions_ActionGroup());
    addGroup(new JUnitTestMethodActions_ActionGroup());
    addGroup(new LanguageActions_ActionGroup());
    addGroup(new LanguageNewActions_ActionGroup());
    addGroup(new LibraryActions_ActionGroup());
    addGroup(new MessagesViewActions_ActionGroup());
    addGroup(new ModelActionsInternal_ActionGroup());
    addGroup(new ModelActions_ActionGroup());
    addGroup(new ModelNewActions_ActionGroup());
    addGroup(new ModelRefactoring_ActionGroup());
    addGroup(new ModuleActions_ActionGroup());
    addGroup(new NamespaceActions_ActionGroup());
    addGroup(new NamespaceInternalActions_ActionGroup());
    addGroup(new NamespaceMakeActions_ActionGroup());
    addGroup(new NamespaceNewActions_ActionGroup());
    addGroup(new NodeActionsInternal_ActionGroup());
    addGroup(new NodeActions_ActionGroup());
    addGroup(new NodeRefactoring_ActionGroup());
    addGroup(new PackageActions_ActionGroup());
    addGroup(new PackageNewActions_ActionGroup());
    addGroup(new PrintNodePosition_Addition_ActionGroup());
    addGroup(new ProjectActions_ActionGroup());
    addGroup(new ProjectNewActions_ActionGroup());
    addGroup(new PropertyNodeActions_ActionGroup());
    addGroup(new ReferenceNodeActions_ActionGroup());
    addGroup(new RuntimeFolderActions_ActionGroup());
    addGroup(new Search_ActionGroup());
    addGroup(new SolutionActions_ActionGroup());
    addGroup(new SolutionNewActions_ActionGroup());
    addGroup(new SolutionRefactoring_ActionGroup());
    addGroup(new ToolsInternal_ActionGroup());
    addGroup(new Tools_ActionGroup());
    addGroup(new TransientModulesActions_ActionGroup());
    addGroup(new View_ActionGroup());
  }

  public void adjustInterfaceGroups() {
    insertInterfaceGroupIntoAnother("VcsGroup", AbstractFileActions_ActionGroup.ID, AbstractFileActions_ActionGroup.LABEL_ID_vcs);
    insertInterfaceGroupIntoAnother("VcsGroup", CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_ideavcs);
    insertInterfaceGroupIntoAnother("VcsGroup", EditorPopup_ActionGroup.ID, EditorPopup_ActionGroup.LABEL_ID_vcs);
    insertInterfaceGroupIntoAnother("VcsGroup", ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_ideavcs);
    insertInterfaceGroupIntoAnother("NavbarPopupMenu", AbstractFileActions_ActionGroup.ID, AbstractFileActions_ActionGroup.LABEL_ID_ideaActions);
    insertInterfaceGroupIntoAnother("RunContextGroup", CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_run);
    insertInterfaceGroupIntoAnother("RunContextGroup", EditorPopup_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", EditorTabActions_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", JUnitTestCaseActions_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", JUnitTestMethodActions_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", ModelActions_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", NodeActions_ActionGroup.ID, null);
    insertInterfaceGroupIntoAnother("RunContextGroup", ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_runConfig);
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(FavoritesPopup_ActionGroup.ID, FavoritesPopupWrapper_ActionGroup.ID, null);
    insertGroupIntoAnother(AnalyzeModule_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_analyze);
    insertGroupIntoAnother(Bookmarks_ActionGroup.ID, "EditMenu", null);
    insertGroupIntoAnother(Build_ActionGroup.ID, "BuildMenu", null);
    insertGroupIntoAnother(Edit_ActionGroup.ID, "EditMenu", null);
    insertGroupIntoAnother(Folding_ActionGroup.ID, EditorPopup_ActionGroup.ID, EditorPopup_ActionGroup.LABEL_ID_folding);
    insertGroupIntoAnother(Goto_ActionGroup.ID, "GoToMenu", null);
    insertGroupIntoAnother(GoToEditorPopupAddition_ActionGroup.ID, EditorPopup_ActionGroup.ID, EditorPopup_ActionGroup.LABEL_ID_goto);
    insertGroupIntoAnother(GoByReference_ActionGroup.ID, GoToEditorPopupAddition_ActionGroup.ID, GoToEditorPopupAddition_ActionGroup.LABEL_ID_refs);
    insertGroupIntoAnother(NodeActionsInternal_ActionGroup.ID, NodeActions_ActionGroup.ID, null);
    insertGroupIntoAnother(EditorInternal_ActionGroup.ID, EditorPopup_ActionGroup.ID, null);
    insertGroupIntoAnother(ToolsInternal_ActionGroup.ID, Tools_ActionGroup.ID, Tools_ActionGroup.LABEL_ID_internal);
    insertGroupIntoAnother(DebugActions_ActionGroup.ID, EditorPopup_ActionGroup.ID, EditorPopup_ActionGroup.LABEL_ID_debug);
    insertGroupIntoAnother(DebugActions_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_debug);
    insertGroupIntoAnother(ProjectNewActions_ActionGroup.ID, ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_projectNew);
    insertGroupIntoAnother(SolutionNewActions_ActionGroup.ID, SolutionActions_ActionGroup.ID, SolutionActions_ActionGroup.LABEL_ID_solutionNew);
    insertGroupIntoAnother(GeneratorNewActions_ActionGroup.ID, GeneratorActions_ActionGroup.ID, GeneratorActions_ActionGroup.LABEL_ID_generatorNew);
    insertGroupIntoAnother(LanguageNewActions_ActionGroup.ID, LanguageActions_ActionGroup.ID, LanguageActions_ActionGroup.LABEL_ID_newGroup);
    insertGroupIntoAnother(ModelNewActions_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_newActions);
    insertGroupIntoAnother(FileSystemNewActions_ActionGroup.ID, AbstractFileActions_ActionGroup.ID, AbstractFileActions_ActionGroup.LABEL_ID_new);
    insertGroupIntoAnother(PackageNewActions_ActionGroup.ID, PackageActions_ActionGroup.ID, PackageActions_ActionGroup.LABEL_ID_newActions);
    insertGroupIntoAnother(NodeRefactoring_ActionGroup.ID, FindUsages_ActionGroup.ID, FindUsages_ActionGroup.LABEL_ID_refactoring);
    insertGroupIntoAnother(ModelRefactoring_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_refactoring);
    insertGroupIntoAnother(SolutionRefactoring_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_refactoring);
    insertGroupIntoAnother(CreateRootNode_ActionGroup.ID, ModelNewActions_ActionGroup.ID, ModelNewActions_ActionGroup.LABEL_ID_newRoot);
    insertGroupIntoAnother(CreateRootNode_ActionGroup.ID, PackageNewActions_ActionGroup.ID, null);
    insertGroupIntoAnother(Tools_ActionGroup.ID, "ToolsMenu", null);
    insertGroupIntoAnother(AbstractFileActions_ActionGroup.ID, FileActions_ActionGroup.ID, FileActions_ActionGroup.LABEL_ID_abstractFileActions);
    insertGroupIntoAnother(AbstractFileActions_ActionGroup.ID, FolderActions_ActionGroup.ID, FolderActions_ActionGroup.LABEL_ID_abstractFileActions);
    insertGroupIntoAnother(AbstractFileActions_ActionGroup.ID, ModuleActions_ActionGroup.ID, ModuleActions_ActionGroup.LABEL_ID_abstractFileActions);
    insertGroupIntoAnother(NamespaceInternalActions_ActionGroup.ID, NamespaceActions_ActionGroup.ID, NamespaceActions_ActionGroup.LABEL_ID_namespaceInternal);
    insertGroupIntoAnother(FindUsages_ActionGroup.ID, EditorPopup_ActionGroup.ID, EditorPopup_ActionGroup.LABEL_ID_find);
    insertGroupIntoAnother(FindUsages_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_find);
    insertGroupIntoAnother(AddToFavoritesGroup_ActionGroup.ID, FavoritesPopup_ActionGroup.ID, FavoritesPopup_ActionGroup.LABEL_ID_addToFavorites);
    insertGroupIntoAnother(Analyze_ActionGroup.ID, "AnalyzeMenu", null);
    insertGroupIntoAnother(CommonModuleActions_ActionGroup.ID, GeneratorActions_ActionGroup.ID, GeneratorActions_ActionGroup.LABEL_ID_commonModule);
    insertGroupIntoAnother(CommonModuleActions_ActionGroup.ID, LanguageActions_ActionGroup.ID, LanguageActions_ActionGroup.LABEL_ID_commonModule);
    insertGroupIntoAnother(CommonModuleActions_ActionGroup.ID, SolutionActions_ActionGroup.ID, SolutionActions_ActionGroup.LABEL_ID_commonModule);
    insertGroupIntoAnother(MessagesViewActions_ActionGroup.ID, "MPS.MessagesView", null);
    insertGroupIntoAnother(PrintNodePosition_Addition_ActionGroup.ID, EditorInternal_ActionGroup.ID, null);
    insertGroupIntoAnother(Search_ActionGroup.ID, "SearchMenu", null);
    insertGroupIntoAnother(Code_ActionGroup.ID, "CodeMenu", null);
    insertGroupIntoAnother(FavoritesPopupWrapper_ActionGroup.ID, Favorites_ActionGroup.ID, Favorites_ActionGroup.LABEL_ID_popup);
    insertGroupIntoAnother(Favorites_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_favorites);
    insertGroupIntoAnother(Favorites_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_favorites);
    insertGroupIntoAnother(Favorites_ActionGroup.ID, NodeActions_ActionGroup.ID, NodeActions_ActionGroup.LABEL_ID_favorites);
    insertGroupIntoAnother(View_ActionGroup.ID, "ViewMenu", null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    ListSequence.fromList(res).addElement(new DependenciesKeyMap_KeymapChanges());
    ListSequence.fromList(res).addElement(new Mac_KeymapChanges());
    ListSequence.fromList(res).addElement(new TraceActions_KeymapChanges());
    return res;
  }
}
