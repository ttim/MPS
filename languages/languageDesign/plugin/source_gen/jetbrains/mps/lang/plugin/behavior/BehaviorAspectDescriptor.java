package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.plugin.structure.ActionAccessOperation", "jetbrains.mps.lang.plugin.structure.ActionConstructionParameterDeclaration", "jetbrains.mps.lang.plugin.structure.ActionConstructorParameterReferenceOperation", "jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration", "jetbrains.mps.lang.plugin.structure.ActionDataParameterReferenceOperation", "jetbrains.mps.lang.plugin.structure.ActionDeclaration", "jetbrains.mps.lang.plugin.structure.ActionGroupDeclaration", "jetbrains.mps.lang.plugin.structure.ActionGroupRef", "jetbrains.mps.lang.plugin.structure.ActionInstance", "jetbrains.mps.lang.plugin.structure.ActionParameterDeclaration", "jetbrains.mps.lang.plugin.structure.ActionParameterReference", "jetbrains.mps.lang.plugin.structure.ActionParameterReferenceOperation", "jetbrains.mps.lang.plugin.structure.ActionType", "jetbrains.mps.lang.plugin.structure.AddElementStatement", "jetbrains.mps.lang.plugin.structure.AddKeystrokeStatement", "jetbrains.mps.lang.plugin.structure.AddStatement", "jetbrains.mps.lang.plugin.structure.AddTabOperation", "jetbrains.mps.lang.plugin.structure.ApplicationPluginDeclaration", "jetbrains.mps.lang.plugin.structure.ApplicationPluginDisposeBlock", "jetbrains.mps.lang.plugin.structure.ApplicationPluginInitBlock", "jetbrains.mps.lang.plugin.structure.ApplicationPluginType", "jetbrains.mps.lang.plugin.structure.BaseNodeBlock", "jetbrains.mps.lang.plugin.structure.BaseProjectOperation", "jetbrains.mps.lang.plugin.structure.BuildGroupBlock", "jetbrains.mps.lang.plugin.structure.ButtonCreator", "jetbrains.mps.lang.plugin.structure.CloseTabOperation", "jetbrains.mps.lang.plugin.structure.ConceptCondition", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_AnActionEvent", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_Concept", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_IModule", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_MPSProject", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_Model", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_OperationContext", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_PreferencePage_component", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_Project", "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_node", "jetbrains.mps.lang.plugin.structure.CreateNodeAspectBlock", "jetbrains.mps.lang.plugin.structure.CreateTabBlock", "jetbrains.mps.lang.plugin.structure.CustomCondition", "jetbrains.mps.lang.plugin.structure.DisposeBlock", "jetbrains.mps.lang.plugin.structure.DoUpdateBlock", "jetbrains.mps.lang.plugin.structure.EditableModel", "jetbrains.mps.lang.plugin.structure.EditorTab", "jetbrains.mps.lang.plugin.structure.EditorTabReference", "jetbrains.mps.lang.plugin.structure.ElementListContents", "jetbrains.mps.lang.plugin.structure.EnumerateChildrenFunction", "jetbrains.mps.lang.plugin.structure.EverywhereActionPlace", "jetbrains.mps.lang.plugin.structure.ExecuteBlock", "jetbrains.mps.lang.plugin.structure.GetComponentBlock", "jetbrains.mps.lang.plugin.structure.GetConceptsBlock", "jetbrains.mps.lang.plugin.structure.GetGroupOperation", "jetbrains.mps.lang.plugin.structure.GetNodeBlock", "jetbrains.mps.lang.plugin.structure.GetNodesBlock", "jetbrains.mps.lang.plugin.structure.GetPreferencesComponentInProjectOperation", "jetbrains.mps.lang.plugin.structure.GetSelectedTabOperation", "jetbrains.mps.lang.plugin.structure.GetToolInProjectOperation", "jetbrains.mps.lang.plugin.structure.GroupAccessOperation", "jetbrains.mps.lang.plugin.structure.GroupAnchor", "jetbrains.mps.lang.plugin.structure.GroupType", "jetbrains.mps.lang.plugin.structure.IdeaActionsDescriptor", "jetbrains.mps.lang.plugin.structure.IdeaConfigurationXml", "jetbrains.mps.lang.plugin.structure.IdeaInitializerDescriptor", "jetbrains.mps.lang.plugin.structure.IdeaPluginDependency", "jetbrains.mps.lang.plugin.structure.InitBlock", "jetbrains.mps.lang.plugin.structure.InterfaceExtentionPoint", "jetbrains.mps.lang.plugin.structure.InterfaceGroup", "jetbrains.mps.lang.plugin.structure.IsApplicableBlock", "jetbrains.mps.lang.plugin.structure.IsApplicableTabBlock", "jetbrains.mps.lang.plugin.structure.KeyMapKeystroke", "jetbrains.mps.lang.plugin.structure.KeyStrokeType", "jetbrains.mps.lang.plugin.structure.KeymapChangesDeclaration", "jetbrains.mps.lang.plugin.structure.KeymapRef", "jetbrains.mps.lang.plugin.structure.ListenBlock", "jetbrains.mps.lang.plugin.structure.MPSPluginDependency", "jetbrains.mps.lang.plugin.structure.ModificationStatement", "jetbrains.mps.lang.plugin.structure.NewCreateBlock", "jetbrains.mps.lang.plugin.structure.OnAfterReadBlock", "jetbrains.mps.lang.plugin.structure.OnBeforeWriteBlock", "jetbrains.mps.lang.plugin.structure.Order", "jetbrains.mps.lang.plugin.structure.OrderReference", "jetbrains.mps.lang.plugin.structure.ParameterCondition_ConceptFunctionParameter", "jetbrains.mps.lang.plugin.structure.ParameterizedShortcutChange", "jetbrains.mps.lang.plugin.structure.PersistentPropertyDeclaration", "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference", "jetbrains.mps.lang.plugin.structure.PopupCreator", "jetbrains.mps.lang.plugin.structure.PreferencePage", "jetbrains.mps.lang.plugin.structure.PreferencePageCommitBlock", "jetbrains.mps.lang.plugin.structure.PreferencePageIsModifiedBlock", "jetbrains.mps.lang.plugin.structure.PreferencePageResetBlock", "jetbrains.mps.lang.plugin.structure.PreferencesComponentDeclaration", "jetbrains.mps.lang.plugin.structure.PreferencesComponentType", "jetbrains.mps.lang.plugin.structure.ProjectPluginDeclaration", "jetbrains.mps.lang.plugin.structure.ProjectPluginDisposeBlock", "jetbrains.mps.lang.plugin.structure.ProjectPluginInitBlock", "jetbrains.mps.lang.plugin.structure.ProjectPluginType", "jetbrains.mps.lang.plugin.structure.RequiredCondition", "jetbrains.mps.lang.plugin.structure.Separator", "jetbrains.mps.lang.plugin.structure.SimpleActionPlace", "jetbrains.mps.lang.plugin.structure.SimpleShortcutChange", "jetbrains.mps.lang.plugin.structure.SmartDisposeClosureParameterDeclaration", "jetbrains.mps.lang.plugin.structure.TabbedToolDeclaration", "jetbrains.mps.lang.plugin.structure.ToStringConceptFunction", "jetbrains.mps.lang.plugin.structure.ToStringParameter", "jetbrains.mps.lang.plugin.structure.ToolActionPlace", "jetbrains.mps.lang.plugin.structure.ToolDeclaration", "jetbrains.mps.lang.plugin.structure.ToolInstanceExpression", "jetbrains.mps.lang.plugin.structure.ToolTab", "jetbrains.mps.lang.plugin.structure.ToolType", "jetbrains.mps.lang.plugin.structure.ToolbarCreator", "jetbrains.mps.lang.plugin.structure.UpdateGroupBlock", "jetbrains.mps.lang.plugin.structure.UpdateGroupFunction"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 104:
        return new ToolDeclaration_BehaviorDescriptor();
      case 40:
        return new DoUpdateBlock_BehaviorDescriptor();
      case 27:
        return new ConceptFunctionParameter_AnActionEvent_BehaviorDescriptor();
      case 47:
        return new ExecuteBlock_BehaviorDescriptor();
      case 6:
        return new ActionGroupDeclaration_BehaviorDescriptor();
      case 8:
        return new ActionInstance_BehaviorDescriptor();
      case 74:
        return new ModificationStatement_BehaviorDescriptor();
      case 57:
        return new GroupAnchor_BehaviorDescriptor();
      case 51:
        return new GetNodeBlock_BehaviorDescriptor();
      case 52:
        return new GetNodesBlock_BehaviorDescriptor();
      case 35:
        return new ConceptFunctionParameter_node_BehaviorDescriptor();
      case 32:
        return new ConceptFunctionParameter_OperationContext_BehaviorDescriptor();
      case 65:
        return new InterfaceGroup_BehaviorDescriptor();
      case 64:
        return new InterfaceExtentionPoint_BehaviorDescriptor();
      case 105:
        return new ToolInstanceExpression_BehaviorDescriptor();
      case 29:
        return new ConceptFunctionParameter_IModule_BehaviorDescriptor();
      case 30:
        return new ConceptFunctionParameter_MPSProject_BehaviorDescriptor();
      case 96:
        return new Separator_BehaviorDescriptor();
      case 9:
        return new ActionParameterDeclaration_BehaviorDescriptor();
      case 66:
        return new IsApplicableBlock_BehaviorDescriptor();
      case 12:
        return new ActionType_BehaviorDescriptor();
      case 11:
        return new ActionParameterReferenceOperation_BehaviorDescriptor();
      case 91:
        return new ProjectPluginDeclaration_BehaviorDescriptor();
      case 93:
        return new ProjectPluginInitBlock_BehaviorDescriptor();
      case 92:
        return new ProjectPluginDisposeBlock_BehaviorDescriptor();
      case 94:
        return new ProjectPluginType_BehaviorDescriptor();
      case 23:
        return new BuildGroupBlock_BehaviorDescriptor();
      case 44:
        return new ElementListContents_BehaviorDescriptor();
      case 68:
        return new KeyMapKeystroke_BehaviorDescriptor();
      case 58:
        return new GroupType_BehaviorDescriptor();
      case 107:
        return new ToolType_BehaviorDescriptor();
      case 50:
        return new GetGroupOperation_BehaviorDescriptor();
      case 89:
        return new PreferencesComponentDeclaration_BehaviorDescriptor();
      case 82:
        return new PersistentPropertyDeclaration_BehaviorDescriptor();
      case 83:
        return new PersistentPropertyReference_BehaviorDescriptor();
      case 90:
        return new PreferencesComponentType_BehaviorDescriptor();
      case 77:
        return new OnBeforeWriteBlock_BehaviorDescriptor();
      case 76:
        return new OnAfterReadBlock_BehaviorDescriptor();
      case 85:
        return new PreferencePage_BehaviorDescriptor();
      case 88:
        return new PreferencePageResetBlock_BehaviorDescriptor();
      case 86:
        return new PreferencePageCommitBlock_BehaviorDescriptor();
      case 33:
        return new ConceptFunctionParameter_PreferencePage_component_BehaviorDescriptor();
      case 87:
        return new PreferencePageIsModifiedBlock_BehaviorDescriptor();
      case 63:
        return new InitBlock_BehaviorDescriptor();
      case 39:
        return new DisposeBlock_BehaviorDescriptor();
      case 34:
        return new ConceptFunctionParameter_Project_BehaviorDescriptor();
      case 48:
        return new GetComponentBlock_BehaviorDescriptor();
      case 19:
        return new ApplicationPluginInitBlock_BehaviorDescriptor();
      case 18:
        return new ApplicationPluginDisposeBlock_BehaviorDescriptor();
      case 20:
        return new ApplicationPluginType_BehaviorDescriptor();
      case 17:
        return new ApplicationPluginDeclaration_BehaviorDescriptor();
      case 3:
        return new ActionDataParameterDeclaration_BehaviorDescriptor();
      case 4:
        return new ActionDataParameterReferenceOperation_BehaviorDescriptor();
      case 1:
        return new ActionConstructionParameterDeclaration_BehaviorDescriptor();
      case 2:
        return new ActionConstructorParameterReferenceOperation_BehaviorDescriptor();
      case 15:
        return new AddStatement_BehaviorDescriptor();
      case 101:
        return new ToStringConceptFunction_BehaviorDescriptor();
      case 102:
        return new ToStringParameter_BehaviorDescriptor();
      case 109:
        return new UpdateGroupBlock_BehaviorDescriptor();
      case 110:
        return new UpdateGroupFunction_BehaviorDescriptor();
      case 45:
        return new EnumerateChildrenFunction_BehaviorDescriptor();
      case 70:
        return new KeymapChangesDeclaration_BehaviorDescriptor();
      case 98:
        return new SimpleShortcutChange_BehaviorDescriptor();
      case 81:
        return new ParameterizedShortcutChange_BehaviorDescriptor();
      case 97:
        return new SimpleActionPlace_BehaviorDescriptor();
      case 103:
        return new ToolActionPlace_BehaviorDescriptor();
      case 46:
        return new EverywhereActionPlace_BehaviorDescriptor();
      case 31:
        return new ConceptFunctionParameter_Model_BehaviorDescriptor();
      case 100:
        return new TabbedToolDeclaration_BehaviorDescriptor();
      case 16:
        return new AddTabOperation_BehaviorDescriptor();
      case 25:
        return new CloseTabOperation_BehaviorDescriptor();
      case 54:
        return new GetSelectedTabOperation_BehaviorDescriptor();
      case 99:
        return new SmartDisposeClosureParameterDeclaration_BehaviorDescriptor();
      case 106:
        return new ToolTab_BehaviorDescriptor();
      case 49:
        return new GetConceptsBlock_BehaviorDescriptor();
      case 75:
        return new NewCreateBlock_BehaviorDescriptor();
      case 28:
        return new ConceptFunctionParameter_Concept_BehaviorDescriptor();
      case 53:
        return new GetPreferencesComponentInProjectOperation_BehaviorDescriptor();
      case 22:
        return new BaseProjectOperation_BehaviorDescriptor();
      case 55:
        return new GetToolInProjectOperation_BehaviorDescriptor();
      case 0:
        return new ActionAccessOperation_BehaviorDescriptor();
      case 56:
        return new GroupAccessOperation_BehaviorDescriptor();
      case 61:
        return new IdeaInitializerDescriptor_BehaviorDescriptor();
      case 69:
        return new KeyStrokeType_BehaviorDescriptor();
      case 10:
        return new ActionParameterReference_BehaviorDescriptor();
      case 14:
        return new AddKeystrokeStatement_BehaviorDescriptor();
      case 36:
        return new CreateNodeAspectBlock_BehaviorDescriptor();
      case 42:
        return new EditorTab_BehaviorDescriptor();
      case 67:
        return new IsApplicableTabBlock_BehaviorDescriptor();
      case 21:
        return new BaseNodeBlock_BehaviorDescriptor();
      case 72:
        return new ListenBlock_BehaviorDescriptor();
      case 78:
        return new Order_BehaviorDescriptor();
      case 43:
        return new EditorTabReference_BehaviorDescriptor();
      case 79:
        return new OrderReference_BehaviorDescriptor();
      case 5:
        return new ActionDeclaration_BehaviorDescriptor();
      case 24:
        return new ButtonCreator_BehaviorDescriptor();
      case 84:
        return new PopupCreator_BehaviorDescriptor();
      case 108:
        return new ToolbarCreator_BehaviorDescriptor();
      case 37:
        return new CreateTabBlock_BehaviorDescriptor();
      case 38:
        return new CustomCondition_BehaviorDescriptor();
      case 80:
        return new ParameterCondition_ConceptFunctionParameter_BehaviorDescriptor();
      case 95:
        return new RequiredCondition_BehaviorDescriptor();
      case 41:
        return new EditableModel_BehaviorDescriptor();
      case 62:
        return new IdeaPluginDependency_BehaviorDescriptor();
      case 73:
        return new MPSPluginDependency_BehaviorDescriptor();
      case 59:
        return new IdeaActionsDescriptor_BehaviorDescriptor();
      case 7:
        return new ActionGroupRef_BehaviorDescriptor();
      case 71:
        return new KeymapRef_BehaviorDescriptor();
      case 60:
        return new IdeaConfigurationXml_BehaviorDescriptor();
      case 26:
        return new ConceptCondition_BehaviorDescriptor();
      case 13:
        return new AddElementStatement_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
