package jetbrains.mps.execution.configurations.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor", "jetbrains.mps.execution.configurations.structure.BeforeTask", "jetbrains.mps.execution.configurations.structure.BeforeTaskCall", "jetbrains.mps.execution.configurations.structure.BeforeTaskParameter", "jetbrains.mps.execution.configurations.structure.BeforeTaskParameterReference", "jetbrains.mps.execution.configurations.structure.ConfigurationFromExecutorReference", "jetbrains.mps.execution.configurations.structure.Create_ConceptFunction", "jetbrains.mps.execution.configurations.structure.DebuggerSettings_Parameter", "jetbrains.mps.execution.configurations.structure.ExecuteBeforeTask_ConceptFunction", "jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function", "jetbrains.mps.execution.configurations.structure.ModelSource", "jetbrains.mps.execution.configurations.structure.ModuleSource", "jetbrains.mps.execution.configurations.structure.NodeListSource", "jetbrains.mps.execution.configurations.structure.NodeSource", "jetbrains.mps.execution.configurations.structure.ProjectSource", "jetbrains.mps.execution.configurations.structure.Project_Parameter", "jetbrains.mps.execution.configurations.structure.RunConfiguration", "jetbrains.mps.execution.configurations.structure.RunConfigurationCreator", "jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor", "jetbrains.mps.execution.configurations.structure.RunConfigurationKind", "jetbrains.mps.execution.configurations.structure.RunConfigurationProducer", "jetbrains.mps.execution.configurations.structure.RunConfigurationProducerPart", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", "jetbrains.mps.execution.configurations.structure.Source_ConceptFunctionParameter", "jetbrains.mps.execution.configurations.structure.StartProcessHandlerStatement", "jetbrains.mps.execution.configurations.structure.StartedProcessType"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.execution.common.structure.IGeneratedToClass", "jetbrains.mps.execution.settings.structure.PersistentConfigurationAssistent"}, new String[]{"configurationName", "canRun"}, new String[]{"runConfiguration"});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.BeforeTask", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.execution.common.structure.IGeneratedToClass"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.BeforeTaskCall", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"beforeTask"});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.BeforeTaskParameter", "jetbrains.mps.baseLanguage.structure.VariableDeclaration", false, new String[]{"jetbrains.mps.baseLanguage.structure.VariableDeclaration"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.BeforeTaskParameterReference", "jetbrains.mps.baseLanguage.structure.VariableReference", false, new String[]{"jetbrains.mps.baseLanguage.structure.VariableReference"}, new String[]{}, new String[]{"parameterDeclaration"});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ConfigurationFromExecutorReference", "jetbrains.mps.baseLanguage.structure.Expression", false, new String[]{"jetbrains.mps.baseLanguage.structure.Expression", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.Create_ConceptFunction", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.DebuggerSettings_Parameter", "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ExecuteBeforeTask_ConceptFunction", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction"}, new String[]{}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ExecuteConfiguration_Function", "jetbrains.mps.baseLanguage.structure.ConceptFunction", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunction", "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList"}, new String[]{}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ModelSource", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", false, new String[]{"jetbrains.mps.execution.configurations.structure.RunConfigurationSource"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ModuleSource", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", false, new String[]{"jetbrains.mps.execution.configurations.structure.RunConfigurationSource"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.NodeListSource", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", false, new String[]{"jetbrains.mps.execution.configurations.structure.RunConfigurationSource"}, new String[]{}, new String[]{"concept"});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.NodeSource", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", false, new String[]{"jetbrains.mps.execution.configurations.structure.RunConfigurationSource"}, new String[]{}, new String[]{"concept"});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.ProjectSource", "jetbrains.mps.execution.configurations.structure.RunConfigurationSource", false, new String[]{"jetbrains.mps.execution.configurations.structure.RunConfigurationSource"}, new String[]{}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.Project_Parameter", "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"}, new String[]{}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfiguration", "jetbrains.mps.execution.settings.structure.PersistentConfiguration", false, new String[]{"jetbrains.mps.execution.settings.structure.PersistentConfiguration"}, new String[]{}, new String[]{"configurationKind"});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationCreator", "jetbrains.mps.baseLanguage.structure.AbstractCreator", false, new String[]{"jetbrains.mps.baseLanguage.structure.AbstractCreator"}, new String[]{}, new String[]{"configuration"});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor", "jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor", false, new String[]{"jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor"}, new String[]{"canDebug"}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationKind", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.execution.common.structure.IGeneratedToClass"}, new String[]{}, new String[]{});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationProducer", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.execution.common.structure.IGeneratedToClass"}, new String[]{}, new String[]{});
      case 21:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationProducerPart", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.execution.common.structure.IGeneratedToClass"}, new String[]{}, new String[]{});
      case 22:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.RunConfigurationSource", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 23:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.Source_ConceptFunctionParameter", "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter", false, new String[]{"jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"}, new String[]{}, new String[]{});
      case 24:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.StartProcessHandlerStatement", "jetbrains.mps.baseLanguage.structure.ReturnStatement", false, new String[]{"jetbrains.mps.baseLanguage.structure.ReturnStatement"}, new String[]{}, new String[]{});
      case 25:
        return new CompiledConceptDescriptor("jetbrains.mps.execution.configurations.structure.StartedProcessType", "jetbrains.mps.baseLanguage.structure.Type", false, new String[]{"jetbrains.mps.baseLanguage.structure.Type"}, new String[]{}, new String[]{"process"});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
