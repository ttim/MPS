package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;

public class AsUnmodifiableOperation_BehaviorDescriptor extends NoArgumentsSequenceOperation_BehaviorDescriptor implements ICollectionOperation_BehaviorDescriptor, IListOperation_BehaviorDescriptor {
  public AsUnmodifiableOperation_BehaviorDescriptor() {
  }

  public boolean virtual_operandCanBeNull_323410281720656291(SNode thisNode) {
    return IOperation_Behavior.virtual_operandCanBeNull_323410281720656291(thisNode);
  }

  public boolean virtual_isDotExpressionLegalAsStatement_1239212437413(SNode thisNode) {
    return IOperation_Behavior.virtual_isDotExpressionLegalAsStatement_1239212437413(thisNode);
  }

  public String virtual_getVariableExpectedName_1213877410087(SNode thisNode) {
    return IOperation_Behavior.virtual_getVariableExpectedName_1213877410087(thisNode);
  }

  public SNode virtual_expectedOperandType_2141797557973018589(SNode thisNode, SNode elementType) {
    return IContainerOperation_Behavior.virtual_expectedOperandType_2141797557973018589(thisNode, elementType);
  }

  public boolean virtual_isLValue_1213877410080(SNode thisNode) {
    return IOperation_Behavior.virtual_isLValue_1213877410080(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.collections.structure.AsUnmodifiableOperation";
  }
}
