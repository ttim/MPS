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
import jetbrains.mps.baseLanguage.unitTest.runtime.TestRunParameters;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class NodeOperation_Behavior {
  private static Class[] PARAMETERS_1217435265700 = {SNode.class};
  private static Class[] PARAMETERS_1215601182156 = {SNode.class ,SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getName_1217435265700(SNode thisNode) {
    return "operation";
  }

  public static void virtual_perform_1215601182156(SNode thisNode, SNode node) {
  }

  public static TestRunParameters virtual_getTestRunParameters_1216045139515(SNode thisNode) {
    return NodesTestCase_Behavior.getTestRunParameters_1217424543047();
  }

  public static SNode virtual_getTestCase_1216134500045(SNode thisNode) {
    return SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.test.structure.NodesTestCase", false, false);
  }

  public static String virtual_getTestName_1216136419751(SNode thisNode) {
    return "test_" + NodeOperation_Behavior.call_getName_1217435265700(thisNode) + thisNode.getId();
  }

  public static String call_getName_1217435265700(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_getName_1217435265700", PARAMETERS_1217435265700);
  }

  public static void call_perform_1215601182156(SNode thisNode, SNode node) {
    BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", PARAMETERS_1215601182156, node);
  }

  public static String callSuper_getName_1217435265700(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.test.structure.NodeOperation"), callerConceptFqName, "virtual_getName_1217435265700", PARAMETERS_1217435265700);
  }

  public static void callSuper_perform_1215601182156(SNode thisNode, String callerConceptFqName, SNode node) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.test.structure.NodeOperation"), callerConceptFqName, "virtual_perform_1215601182156", PARAMETERS_1215601182156, node);
  }

}
