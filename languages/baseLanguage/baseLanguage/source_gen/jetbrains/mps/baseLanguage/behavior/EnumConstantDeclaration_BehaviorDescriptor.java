package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.lang.core.behavior.IResolveInfo_BehaviorDescriptor;
import java.util.List;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.Nullable;

public class EnumConstantDeclaration_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements IValidIdentifier_BehaviorDescriptor, IResolveInfo_BehaviorDescriptor, HasAnnotation_BehaviorDescriptor, ClassifierMember_BehaviorDescriptor, IMethodCall_BehaviorDescriptor {
  public EnumConstantDeclaration_BehaviorDescriptor() {
  }

  public List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    return EnumConstantDeclaration_Behavior.virtual_getMarkIcons_3923831204883340393(thisNode);
  }

  public SNode virtual_getTypeAnnotation_1233920952262(SNode thisNode) {
    return IMethodCall_Behavior.virtual_getTypeAnnotation_1233920952262(thisNode);
  }

  public Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return EnumConstantDeclaration_Behavior.virtual_getAdditionalIcon_5017341185733863694(thisNode);
  }

  public SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    return IMethodCall_Behavior.virtual_deriveType_1213877435747(thisNode, expression);
  }

  public Map<SNode, SNode> virtual_getTypesByTypeVars_851115533308208851(SNode thisNode) {
    return IMethodCall_Behavior.virtual_getTypesByTypeVars_851115533308208851(thisNode);
  }

  public List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    return HasAnnotation_Behavior.virtual_getChildrenToDisplayIntention_4025276038182319200(thisNode);
  }

  public boolean virtual_canBeAnnotated_1233076312117(SNode thisNode) {
    return HasAnnotation_Behavior.virtual_canBeAnnotated_1233076312117(thisNode);
  }

  public SNode virtual_deriveType_4555537781928374706(SNode thisNode, SNode expression, SNode link) {
    return TypeDerivable_Behavior.virtual_deriveType_4555537781928374706(thisNode, expression, link);
  }

  public List<SNode> virtual_getAvailableMethodDeclarations_5776618742611315379(SNode thisNode, String methodName) {
    return EnumConstantDeclaration_Behavior.virtual_getAvailableMethodDeclarations_5776618742611315379(thisNode, methodName);
  }

  public boolean virtual_isStatic_8986964027630462944(SNode thisNode) {
    return EnumConstantDeclaration_Behavior.virtual_isStatic_8986964027630462944(thisNode);
  }

  public Scope virtual_getScopeForClass_1251851371723365193(SNode thisNode, SNode classNode, @Nullable SNode extendsClass, SNode[] implementsInterfaces) {
    return EnumConstantDeclaration_Behavior.virtual_getScopeForClass_1251851371723365193(thisNode, classNode, extendsClass, implementsInterfaces);
  }

  public boolean virtual_isVisible_8083692786967482069(SNode thisNode, SNode contextClassifier, SNode contextNode) {
    return EnumConstantDeclaration_Behavior.virtual_isVisible_8083692786967482069(thisNode, contextClassifier, contextNode);
  }

  public SNode virtual_getInstanceType_8008512149545154471(SNode thisNode) {
    return IMethodCall_Behavior.virtual_getInstanceType_8008512149545154471(thisNode);
  }

  public Scope virtual_getScopeForInterface_1251851371723365208(SNode thisNode, SNode interfaceNode, SNode[] extendsInterfaces) {
    return EnumConstantDeclaration_Behavior.virtual_getScopeForInterface_1251851371723365208(thisNode, interfaceNode, extendsInterfaces);
  }

  public String virtual_getFqName_1213877404258(SNode thisNode) {
    return EnumConstantDeclaration_Behavior.virtual_getFqName_1213877404258(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration";
  }
}
