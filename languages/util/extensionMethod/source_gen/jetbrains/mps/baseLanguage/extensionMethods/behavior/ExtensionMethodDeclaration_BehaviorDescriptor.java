package jetbrains.mps.baseLanguage.extensionMethods.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.BaseMethodDeclaration_BehaviorDescriptor;
import jetbrains.mps.baseLanguage.behavior.ClassifierMember_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.behavior.ClassifierMember_Behavior;

public class ExtensionMethodDeclaration_BehaviorDescriptor extends BaseMethodDeclaration_BehaviorDescriptor implements ClassifierMember_BehaviorDescriptor {
  public ExtensionMethodDeclaration_BehaviorDescriptor() {
  }

  public boolean virtual_isStatic_8986964027630462944(SNode thisNode) {
    return ClassifierMember_Behavior.virtual_isStatic_8986964027630462944(thisNode);
  }

  public Object virtual_getSignatureForOverriding_274804607996650333(SNode thisNode, SNode contextClassifier) {
    return ClassifierMember_Behavior.virtual_getSignatureForOverriding_274804607996650333(thisNode, contextClassifier);
  }

  public boolean virtual_isVisible_8083692786967482069(SNode thisNode, SNode contextClassifier, SNode contextNode) {
    return ClassifierMember_Behavior.virtual_isVisible_8083692786967482069(thisNode, contextClassifier, contextNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.extensionMethods.structure.ExtensionMethodDeclaration";
  }
}
