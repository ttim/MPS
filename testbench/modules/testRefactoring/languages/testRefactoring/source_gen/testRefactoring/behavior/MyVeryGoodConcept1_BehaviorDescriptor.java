package testRefactoring.behavior;

/*Generated by MPS */

import testRefactoringTargetLang.behavior.AbstractGoodConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.INamedConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;

public class MyVeryGoodConcept1_BehaviorDescriptor extends AbstractGoodConcept_BehaviorDescriptor implements INamedConcept_BehaviorDescriptor {
  public MyVeryGoodConcept1_BehaviorDescriptor() {
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return INamedConcept_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "testRefactoring.structure.MyVeryGoodConcept1";
  }
}
