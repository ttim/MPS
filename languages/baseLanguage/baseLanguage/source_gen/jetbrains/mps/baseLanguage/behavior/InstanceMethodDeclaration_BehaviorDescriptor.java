package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.IResolveInfo_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import javax.swing.Icon;
import java.util.List;

public class InstanceMethodDeclaration_BehaviorDescriptor extends BaseMethodDeclaration_BehaviorDescriptor implements ClassifierMember_BehaviorDescriptor, IResolveInfo_BehaviorDescriptor {
  public InstanceMethodDeclaration_BehaviorDescriptor() {
  }

  public boolean virtual_isStatic_8986964027630462944(SNode thisNode) {
    return ClassifierMember_Behavior.virtual_isStatic_8986964027630462944(thisNode);
  }

  public Object virtual_getSignatureForOverriding_274804607996650333(SNode thisNode, SNode contextClassifier) {
    return InstanceMethodDeclaration_Behavior.virtual_getSignatureForOverriding_274804607996650333(thisNode, contextClassifier);
  }

  public boolean virtual_isAbstract_1232982539764(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_isAbstract_1232982539764(thisNode);
  }

  public boolean virtual_isDataFlowChecked_1227714048980(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_isDataFlowChecked_1227714048980(thisNode);
  }

  public Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_getAdditionalIcon_5017341185733863694(thisNode);
  }

  public SNode virtual_getNearestOverriddenMethod_5358895268254685434(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_getNearestOverriddenMethod_5358895268254685434(thisNode);
  }

  public boolean virtual_isVisible_8083692786967482069(SNode thisNode, SNode contextClassifier, SNode contextNode) {
    return ClassifierMember_Behavior.virtual_isVisible_8083692786967482069(thisNode, contextClassifier, contextNode);
  }

  public List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_getChildrenToDisplayIntention_4025276038182319200(thisNode);
  }

  public boolean virtual_canBeAnnotated_1233076312117(SNode thisNode) {
    return InstanceMethodDeclaration_Behavior.virtual_canBeAnnotated_1233076312117(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration";
  }
}
