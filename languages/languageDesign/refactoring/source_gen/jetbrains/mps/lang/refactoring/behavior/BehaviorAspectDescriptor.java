package jetbrains.mps.lang.refactoring.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.refactoring.structure.AbstractMoveNodeExpression", "jetbrains.mps.lang.refactoring.structure.AffectedNodesClause", "jetbrains.mps.lang.refactoring.structure.AskBooleanExpression", "jetbrains.mps.lang.refactoring.structure.AskExpression", "jetbrains.mps.lang.refactoring.structure.BooleanMPSParameterType", "jetbrains.mps.lang.refactoring.structure.ChangeFeatureNameExpression", "jetbrains.mps.lang.refactoring.structure.ChangeFeatureNameOperation", "jetbrains.mps.lang.refactoring.structure.ChooseComponentClause", "jetbrains.mps.lang.refactoring.structure.ChooserRefactoringContext_ConceptFunctionParameter", "jetbrains.mps.lang.refactoring.structure.CommitClause", "jetbrains.mps.lang.refactoring.structure.ComponentExpression", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_Model", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_Module", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_RefactoringParameter", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_SModel", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_SNode", "jetbrains.mps.lang.refactoring.structure.ConceptFunctionParameter_UserArgument", "jetbrains.mps.lang.refactoring.structure.ContextType", "jetbrains.mps.lang.refactoring.structure.CreateRefactoringContext", "jetbrains.mps.lang.refactoring.structure.CustomParameterChooser", "jetbrains.mps.lang.refactoring.structure.DeleteFeatureExpression", "jetbrains.mps.lang.refactoring.structure.DeleteFeatureOperation", "jetbrains.mps.lang.refactoring.structure.DoRefactorClause", "jetbrains.mps.lang.refactoring.structure.DoWhenDoneClause", "jetbrains.mps.lang.refactoring.structure.ErrorStatement", "jetbrains.mps.lang.refactoring.structure.ExecuteFindersExpression", "jetbrains.mps.lang.refactoring.structure.FilterArgumentClause", "jetbrains.mps.lang.refactoring.structure.FilterParameterClause", "jetbrains.mps.lang.refactoring.structure.FinderReference", "jetbrains.mps.lang.refactoring.structure.GetModelsToGenerateClause", "jetbrains.mps.lang.refactoring.structure.GetModelsToUpdateClause", "jetbrains.mps.lang.refactoring.structure.InitClause", "jetbrains.mps.lang.refactoring.structure.InitialPropertyValueClause", "jetbrains.mps.lang.refactoring.structure.InitialValueClause", "jetbrains.mps.lang.refactoring.structure.IntMPSParameterType", "jetbrains.mps.lang.refactoring.structure.IsApplicableClause", "jetbrains.mps.lang.refactoring.structure.IsApplicableToModelClause", "jetbrains.mps.lang.refactoring.structure.IsApplicableToModuleClause", "jetbrains.mps.lang.refactoring.structure.IsApplicableToNodeClause", "jetbrains.mps.lang.refactoring.structure.IsRefactoringApplicable", "jetbrains.mps.lang.refactoring.structure.MPSParameterChooser", "jetbrains.mps.lang.refactoring.structure.MainProjectOperation", "jetbrains.mps.lang.refactoring.structure.MergeNodeWithAnotherNodeExpression", "jetbrains.mps.lang.refactoring.structure.ModelDescriptorExpression", "jetbrains.mps.lang.refactoring.structure.ModelDescriptorOperation", "jetbrains.mps.lang.refactoring.structure.ModelMPSParameterType", "jetbrains.mps.lang.refactoring.structure.ModelTarget", "jetbrains.mps.lang.refactoring.structure.ModelsToGenerateByDefault", "jetbrains.mps.lang.refactoring.structure.ModelsToGenerateClause", "jetbrains.mps.lang.refactoring.structure.ModuleExpression", "jetbrains.mps.lang.refactoring.structure.ModuleMPSParameterType", "jetbrains.mps.lang.refactoring.structure.ModuleOperation", "jetbrains.mps.lang.refactoring.structure.ModuleTarget", "jetbrains.mps.lang.refactoring.structure.MoveNodeToModelExpression", "jetbrains.mps.lang.refactoring.structure.MoveNodeToNodeExpression", "jetbrains.mps.lang.refactoring.structure.MoveNodesToModelExpression", "jetbrains.mps.lang.refactoring.structure.MoveNodesToNodeExpression", "jetbrains.mps.lang.refactoring.structure.NodeExpression", "jetbrains.mps.lang.refactoring.structure.NodeMPSParameterType", "jetbrains.mps.lang.refactoring.structure.NodeOperation", "jetbrains.mps.lang.refactoring.structure.NodeTarget", "jetbrains.mps.lang.refactoring.structure.NodesExpression", "jetbrains.mps.lang.refactoring.structure.NodesOperation", "jetbrains.mps.lang.refactoring.structure.NodesToOpenClause", "jetbrains.mps.lang.refactoring.structure.OldRefactoring", "jetbrains.mps.lang.refactoring.structure.OperationContextExpression", "jetbrains.mps.lang.refactoring.structure.OperationContextOperation", "jetbrains.mps.lang.refactoring.structure.ProjectExpression", "jetbrains.mps.lang.refactoring.structure.ProjectOperation", "jetbrains.mps.lang.refactoring.structure.Refactoring", "jetbrains.mps.lang.refactoring.structure.RefactoringContextExpression", "jetbrains.mps.lang.refactoring.structure.RefactoringContext_ConceptFunctionParameter", "jetbrains.mps.lang.refactoring.structure.RefactoringField", "jetbrains.mps.lang.refactoring.structure.RefactoringFieldReference", "jetbrains.mps.lang.refactoring.structure.RefactoringParameter", "jetbrains.mps.lang.refactoring.structure.RefactoringParameterReference", "jetbrains.mps.lang.refactoring.structure.RequiredAdditionalArgument", "jetbrains.mps.lang.refactoring.structure.RequiredAdditionalArgumentReference", "jetbrains.mps.lang.refactoring.structure.RequiredUserEnteredArgument", "jetbrains.mps.lang.refactoring.structure.ScopeExpression", "jetbrains.mps.lang.refactoring.structure.ScopeOperation", "jetbrains.mps.lang.refactoring.structure.SetValueStatement", "jetbrains.mps.lang.refactoring.structure.SettingsRefactoringContext_ConceptFunctionParameter", "jetbrains.mps.lang.refactoring.structure.StringMPSParameterType", "jetbrains.mps.lang.refactoring.structure.UpdateModelByDefaultOperation", "jetbrains.mps.lang.refactoring.structure.UpdateModelClause", "jetbrains.mps.lang.refactoring.structure.UpdateModelProcedure"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 64:
        return new OldRefactoring_BehaviorDescriptor();
      case 76:
        return new RequiredAdditionalArgument_BehaviorDescriptor();
      case 35:
        return new IsApplicableClause_BehaviorDescriptor();
      case 22:
        return new DoRefactorClause_BehaviorDescriptor();
      case 77:
        return new RequiredAdditionalArgumentReference_BehaviorDescriptor();
      case 85:
        return new UpdateModelClause_BehaviorDescriptor();
      case 14:
        return new ConceptFunctionParameter_SModel_BehaviorDescriptor();
      case 29:
        return new GetModelsToGenerateClause_BehaviorDescriptor();
      case 78:
        return new RequiredUserEnteredArgument_BehaviorDescriptor();
      case 26:
        return new FilterArgumentClause_BehaviorDescriptor();
      case 16:
        return new ConceptFunctionParameter_UserArgument_BehaviorDescriptor();
      case 84:
        return new UpdateModelByDefaultOperation_BehaviorDescriptor();
      case 6:
        return new ChangeFeatureNameOperation_BehaviorDescriptor();
      case 7:
        return new ChooseComponentClause_BehaviorDescriptor();
      case 86:
        return new UpdateModelProcedure_BehaviorDescriptor();
      case 33:
        return new InitialValueClause_BehaviorDescriptor();
      case 0:
        return new AbstractMoveNodeExpression_BehaviorDescriptor();
      case 53:
        return new MoveNodeToModelExpression_BehaviorDescriptor();
      case 54:
        return new MoveNodeToNodeExpression_BehaviorDescriptor();
      case 55:
        return new MoveNodesToModelExpression_BehaviorDescriptor();
      case 56:
        return new MoveNodesToNodeExpression_BehaviorDescriptor();
      case 1:
        return new AffectedNodesClause_BehaviorDescriptor();
      case 21:
        return new DeleteFeatureOperation_BehaviorDescriptor();
      case 36:
        return new IsApplicableToModelClause_BehaviorDescriptor();
      case 11:
        return new ConceptFunctionParameter_Model_BehaviorDescriptor();
      case 30:
        return new GetModelsToUpdateClause_BehaviorDescriptor();
      case 25:
        return new ExecuteFindersExpression_BehaviorDescriptor();
      case 28:
        return new FinderReference_BehaviorDescriptor();
      case 63:
        return new NodesToOpenClause_BehaviorDescriptor();
      case 61:
        return new NodesExpression_BehaviorDescriptor();
      case 57:
        return new NodeExpression_BehaviorDescriptor();
      case 43:
        return new ModelDescriptorExpression_BehaviorDescriptor();
      case 49:
        return new ModuleExpression_BehaviorDescriptor();
      case 67:
        return new ProjectExpression_BehaviorDescriptor();
      case 79:
        return new ScopeExpression_BehaviorDescriptor();
      case 65:
        return new OperationContextExpression_BehaviorDescriptor();
      case 42:
        return new MergeNodeWithAnotherNodeExpression_BehaviorDescriptor();
      case 46:
        return new ModelTarget_BehaviorDescriptor();
      case 52:
        return new ModuleTarget_BehaviorDescriptor();
      case 60:
        return new NodeTarget_BehaviorDescriptor();
      case 37:
        return new IsApplicableToModuleClause_BehaviorDescriptor();
      case 12:
        return new ConceptFunctionParameter_Module_BehaviorDescriptor();
      case 38:
        return new IsApplicableToNodeClause_BehaviorDescriptor();
      case 15:
        return new ConceptFunctionParameter_SNode_BehaviorDescriptor();
      case 72:
        return new RefactoringField_BehaviorDescriptor();
      case 74:
        return new RefactoringParameter_BehaviorDescriptor();
      case 3:
        return new AskExpression_BehaviorDescriptor();
      case 75:
        return new RefactoringParameterReference_BehaviorDescriptor();
      case 73:
        return new RefactoringFieldReference_BehaviorDescriptor();
      case 31:
        return new InitClause_BehaviorDescriptor();
      case 40:
        return new MPSParameterChooser_BehaviorDescriptor();
      case 27:
        return new FilterParameterClause_BehaviorDescriptor();
      case 13:
        return new ConceptFunctionParameter_RefactoringParameter_BehaviorDescriptor();
      case 19:
        return new CustomParameterChooser_BehaviorDescriptor();
      case 9:
        return new CommitClause_BehaviorDescriptor();
      case 69:
        return new Refactoring_BehaviorDescriptor();
      case 23:
        return new DoWhenDoneClause_BehaviorDescriptor();
      case 32:
        return new InitialPropertyValueClause_BehaviorDescriptor();
      case 44:
        return new ModelDescriptorOperation_BehaviorDescriptor();
      case 51:
        return new ModuleOperation_BehaviorDescriptor();
      case 59:
        return new NodeOperation_BehaviorDescriptor();
      case 62:
        return new NodesOperation_BehaviorDescriptor();
      case 66:
        return new OperationContextOperation_BehaviorDescriptor();
      case 68:
        return new ProjectOperation_BehaviorDescriptor();
      case 80:
        return new ScopeOperation_BehaviorDescriptor();
      case 71:
        return new RefactoringContext_ConceptFunctionParameter_BehaviorDescriptor();
      case 17:
        return new ContextType_BehaviorDescriptor();
      case 48:
        return new ModelsToGenerateClause_BehaviorDescriptor();
      case 82:
        return new SettingsRefactoringContext_ConceptFunctionParameter_BehaviorDescriptor();
      case 8:
        return new ChooserRefactoringContext_ConceptFunctionParameter_BehaviorDescriptor();
      case 81:
        return new SetValueStatement_BehaviorDescriptor();
      case 24:
        return new ErrorStatement_BehaviorDescriptor();
      case 10:
        return new ComponentExpression_BehaviorDescriptor();
      case 70:
        return new RefactoringContextExpression_BehaviorDescriptor();
      case 5:
        return new ChangeFeatureNameExpression_BehaviorDescriptor();
      case 20:
        return new DeleteFeatureExpression_BehaviorDescriptor();
      case 45:
        return new ModelMPSParameterType_BehaviorDescriptor();
      case 50:
        return new ModuleMPSParameterType_BehaviorDescriptor();
      case 58:
        return new NodeMPSParameterType_BehaviorDescriptor();
      case 83:
        return new StringMPSParameterType_BehaviorDescriptor();
      case 4:
        return new BooleanMPSParameterType_BehaviorDescriptor();
      case 34:
        return new IntMPSParameterType_BehaviorDescriptor();
      case 2:
        return new AskBooleanExpression_BehaviorDescriptor();
      case 41:
        return new MainProjectOperation_BehaviorDescriptor();
      case 47:
        return new ModelsToGenerateByDefault_BehaviorDescriptor();
      case 18:
        return new CreateRefactoringContext_BehaviorDescriptor();
      case 39:
        return new IsRefactoringApplicable_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
