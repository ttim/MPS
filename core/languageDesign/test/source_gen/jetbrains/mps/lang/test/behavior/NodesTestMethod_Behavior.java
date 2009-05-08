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
package jetbrains.mps.lang.test.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.unitTest.runtime.TestRunParameters;

public class NodesTestMethod_Behavior {

  public static void init(SNode thisNode) {
    SLinkOperations.setTarget(thisNode, "returnType", SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.VoidType", null), true);
  }

  public static SNode virtual_getTestCase_1216134500045(SNode thisNode) {
    return SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.test.structure.NodesTestCase", false, false);
  }

  public static String virtual_getTestName_1216136419751(SNode thisNode) {
    return "test_" + SPropertyOperations.getString(thisNode, "name");
  }

  public static TestRunParameters virtual_getTestRunParameters_1216045139515(SNode thisNode) {
    return NodesTestCase_Behavior.getTestRunParameters_1217424543047();
  }

}
