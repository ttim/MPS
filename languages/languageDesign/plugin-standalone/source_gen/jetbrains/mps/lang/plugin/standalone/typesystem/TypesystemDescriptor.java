package jetbrains.mps.lang.plugin.standalone.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;

public class TypesystemDescriptor extends BaseHelginsDescriptor {
  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_GetPreferencesComponentInProjectOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_GetToolInProjectOperation_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new Typeof_ApplicationPluginType_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
    {
      SubtypingRule_Runtime subtypingRule = new Typeof_ProjectPluginType_SubtypingRule();
      this.mySubtypingRules.add(subtypingRule);
    }
  }
}
