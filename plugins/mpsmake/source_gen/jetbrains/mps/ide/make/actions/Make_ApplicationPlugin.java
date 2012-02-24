package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.applicationplugins.BaseApplicationPlugin;
import com.intellij.openapi.extensions.PluginId;
import jetbrains.mps.ide.actions.ToolsInternal_ActionGroup;
import jetbrains.mps.ide.actions.ProjectActions_ActionGroup;
import jetbrains.mps.ide.actions.CommonModuleActions_ActionGroup;
import jetbrains.mps.ide.actions.Build_ActionGroup;
import jetbrains.mps.ide.actions.ModelActions_ActionGroup;
import jetbrains.mps.ide.actions.NamespaceMakeActions_ActionGroup;
import java.util.List;
import jetbrains.mps.workbench.action.BaseKeymapChanges;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Make_ApplicationPlugin extends BaseApplicationPlugin {
  private PluginId myId = PluginId.getId("jetbrains.mps.ide.make");

  public Make_ApplicationPlugin() {
  }

  public PluginId getId() {
    return myId;
  }

  public void createGroups() {
    // actions w/o parameters 
    addAction(new BuildAllBehaviors_Action());
    addAction(new BuildAllConstraints_Action());
    addAction(new BuildAllGenerators_Action());
    addAction(new BuildAllLanguageDescriptors_Action());
    addAction(new BuildAllStructures_Action());
    addAction(new CheckModelsBeforeGeneration_Action());
    addAction(new CleanModule_Action());
    addAction(new CleanProject_Action());
    addAction(new CompileProject_Action());
    addAction(new MakeModule_Action());
    addAction(new MakeProject_Action());
    addAction(new MakeSelectedModels_Action());
    addAction(new MakeSelectedModules_Action());
    addAction(new Options_Action());
    addAction(new RebuildModule_Action());
    addAction(new RebuildProject_Action());
    addAction(new RebuildRequiredModels_Action());
    addAction(new RebuildSelectedModels_Action());
    addAction(new RebuildSelectedModules_Action());
    addAction(new RecompileProject_Action());
    addAction(new ShowMappingsPartitioning_Action());
    addAction(new TextPreviewModel_Action());
    // groups 
    addGroup(new GenerateOptions_ActionGroup());
    addGroup(new GlobalMake_ActionGroup());
    addGroup(new JavaModuleActions_ActionGroup());
    addGroup(new MakeAddition_ActionGroup());
    addGroup(new Make_ActionGroup());
    addGroup(new NamespaceMake_ActionGroup());
    addGroup(new ProjectCompileActions_ActionGroup());
    addGroup(new ProjectMake_ActionGroup());
    addGroup(new SaveTransientModels_ActionGroup());
    addGroup(new TextPreviewGroup_ActionGroup());
    addGroup(new ToolbarMake_ActionGroup());
  }

  public void adjustRegularGroups() {
    insertGroupIntoAnother(MakeAddition_ActionGroup.ID, ToolsInternal_ActionGroup.ID, null);
    insertGroupIntoAnother(ProjectCompileActions_ActionGroup.ID, ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_compileJava);
    insertGroupIntoAnother(JavaModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_compileJava);
    insertGroupIntoAnother(GenerateOptions_ActionGroup.ID, Build_ActionGroup.ID, Build_ActionGroup.LABEL_ID_options);
    insertGroupIntoAnother(SaveTransientModels_ActionGroup.ID, GenerateOptions_ActionGroup.ID, GenerateOptions_ActionGroup.LABEL_ID_saveTransientModels);
    insertGroupIntoAnother(Make_ActionGroup.ID, CommonModuleActions_ActionGroup.ID, CommonModuleActions_ActionGroup.LABEL_ID_make);
    insertGroupIntoAnother(Make_ActionGroup.ID, ModelActions_ActionGroup.ID, ModelActions_ActionGroup.LABEL_ID_make);
    insertGroupIntoAnother(ProjectMake_ActionGroup.ID, ProjectActions_ActionGroup.ID, ProjectActions_ActionGroup.LABEL_ID_make);
    insertGroupIntoAnother(GlobalMake_ActionGroup.ID, Build_ActionGroup.ID, Build_ActionGroup.LABEL_ID_make);
    insertGroupIntoAnother(TextPreviewGroup_ActionGroup.ID, "EditorPopup_ActionGrouppreview", null);
    insertGroupIntoAnother(TextPreviewGroup_ActionGroup.ID, Make_ActionGroup.ID, Make_ActionGroup.LABEL_ID_preview);
    insertGroupIntoAnother(NamespaceMake_ActionGroup.ID, NamespaceMakeActions_ActionGroup.ID, NamespaceMakeActions_ActionGroup.LABEL_ID_make);
    insertGroupIntoAnother(ToolbarMake_ActionGroup.ID, "MPSToolbarRunGroup", null);
  }

  public List<BaseKeymapChanges> initKeymaps() {
    List<BaseKeymapChanges> res = ListSequence.fromList(new ArrayList<BaseKeymapChanges>());
    ListSequence.fromList(res).addElement(new Default_KeymapChanges());
    return res;
  }
}
