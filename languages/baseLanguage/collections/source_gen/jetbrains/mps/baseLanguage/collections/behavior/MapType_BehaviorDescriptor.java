package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.Type_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;

public class MapType_BehaviorDescriptor extends Type_BehaviorDescriptor {
  public MapType_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getAbstractCreators_7602110602933317830(SNode thisNode, SModel targetModel) {
    return MapType_Behavior.virtual_getAbstractCreators_7602110602933317830(thisNode, targetModel);
  }

  public String virtual_getPresentation_1213877396640(SNode thisNode) {
    return MapType_Behavior.virtual_getPresentation_1213877396640(thisNode);
  }

  public boolean virtual_canBeCoerced_6321644624958501287(SNode thisNode, String conceptFqName) {
    return MapType_Behavior.virtual_canBeCoerced_6321644624958501287(thisNode, conceptFqName);
  }

  public SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    return MapType_Behavior.virtual_getClassExpression_1213877337357(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.collections.structure.MapType";
  }
}
