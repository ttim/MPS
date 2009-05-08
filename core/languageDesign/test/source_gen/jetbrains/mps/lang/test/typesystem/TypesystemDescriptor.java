/*
 * Copyright 2003-2009 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.lang.test.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.BaseHelginsDescriptor;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;

public class TypesystemDescriptor extends BaseHelginsDescriptor {

  public TypesystemDescriptor() {
    {
      InferenceRule_Runtime inferenceRule = new typeof_TestNodeReference_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_AssertMatch_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_NodeTypeProperty_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_EditorExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ModelExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      InferenceRule_Runtime inferenceRule = new typeof_ProjectExpression_InferenceRule();
      this.myInferenceRules.add(inferenceRule);
    }
    {
      NonTypesystemRule_Runtime nonTypesystemRule = new CheckTestMethodDataflow_NonTypesystemRule();
      this.myNonTypesystemRules.add(nonTypesystemRule);
    }
  }
}
