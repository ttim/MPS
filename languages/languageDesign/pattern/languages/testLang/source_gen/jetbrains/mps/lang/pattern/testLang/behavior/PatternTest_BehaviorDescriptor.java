package jetbrains.mps.lang.pattern.testLang.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestCase_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestMethod_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestCase_Behavior;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class PatternTest_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor, ITestCase_BehaviorDescriptor, ITestMethod_BehaviorDescriptor {
  public PatternTest_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getTestSet_1216130724401(SNode thisNode) {
    return PatternTest_Behavior.virtual_getTestSet_1216130724401(thisNode);
  }

  public String virtual_getClassName_1216136193905(SNode thisNode) {
    return PatternTest_Behavior.virtual_getClassName_1216136193905(thisNode);
  }

  public boolean virtual_isMpsStartRequired_3310779261129403089(SNode thisNode) {
    return PatternTest_Behavior.virtual_isMpsStartRequired_3310779261129403089(thisNode);
  }

  public SNode virtual_getTestCase_1216134500045(SNode thisNode) {
    return PatternTest_Behavior.virtual_getTestCase_1216134500045(thisNode);
  }

  public List<SNode> virtual_getTestMethods_2148145109766218395(SNode thisNode) {
    return PatternTest_Behavior.virtual_getTestMethods_2148145109766218395(thisNode);
  }

  public String virtual_getSimpleClassName_1229278847513(SNode thisNode) {
    return ITestCase_Behavior.virtual_getSimpleClassName_1229278847513(thisNode);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  public String virtual_getTestName_1216136419751(SNode thisNode) {
    return PatternTest_Behavior.virtual_getTestName_1216136419751(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.lang.pattern.testLang.structure.PatternTest";
  }
}
