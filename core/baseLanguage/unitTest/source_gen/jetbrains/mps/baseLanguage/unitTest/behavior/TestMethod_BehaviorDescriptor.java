package jetbrains.mps.baseLanguage.unitTest.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.InstanceMethodDeclaration_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;

public class TestMethod_BehaviorDescriptor extends InstanceMethodDeclaration_BehaviorDescriptor implements ITestMethod_BehaviorDescriptor {
  public TestMethod_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getThrowableTypes_6204026822016975623(SNode thisNode) {
    return TestMethod_Behavior.virtual_getThrowableTypes_6204026822016975623(thisNode);
  }

  public boolean virtual_isMpsStartRequired_3310779261129403089(SNode thisNode) {
    return ITestable_Behavior.virtual_isMpsStartRequired_3310779261129403089(thisNode);
  }

  public SNode virtual_getTestCase_1216134500045(SNode thisNode) {
    return TestMethod_Behavior.virtual_getTestCase_1216134500045(thisNode);
  }

  public String virtual_getTestName_1216136419751(SNode thisNode) {
    return TestMethod_Behavior.virtual_getTestName_1216136419751(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.unitTest.structure.TestMethod";
  }
}
