package jetbrains.mps.lang.test.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestMethod_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestRunParameters;
import jetbrains.mps.smodel.SNode;

public abstract class NodeOperation_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements ITestMethod_BehaviorDescriptor {
  public NodeOperation_BehaviorDescriptor() {
  }

  public TestRunParameters virtual_getTestRunParameters_1216045139515(SNode thisNode) {
    return NodeOperation_Behavior.virtual_getTestRunParameters_1216045139515(thisNode);
  }

  public String virtual_getName_1217435265700(SNode thisNode) {
    return NodeOperation_Behavior.virtual_getName_1217435265700(thisNode);
  }

  public SNode virtual_getTestCase_1216134500045(SNode thisNode) {
    return NodeOperation_Behavior.virtual_getTestCase_1216134500045(thisNode);
  }

  public void virtual_perform_1215601182156(SNode thisNode, SNode node) {
    NodeOperation_Behavior.virtual_perform_1215601182156(thisNode, node);
  }

  public String virtual_getTestName_1216136419751(SNode thisNode) {
    return NodeOperation_Behavior.virtual_getTestName_1216136419751(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.lang.test.structure.NodeOperation";
  }
}
