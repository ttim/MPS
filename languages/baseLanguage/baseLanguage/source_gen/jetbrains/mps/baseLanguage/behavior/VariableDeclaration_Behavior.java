package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.Project;
import java.util.List;
import javax.swing.Icon;
import java.util.ArrayList;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.plugin.IconResourceBundle_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class VariableDeclaration_Behavior {
  private static Class[] PARAMETERS_5039675756633082307 = {SNode.class};
  private static Class[] PARAMETERS_1213877517482 = {SNode.class};
  private static Class[] PARAMETERS_1213877517488 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182325660 = {SNode.class};
  private static Class[] PARAMETERS_3012473318495495520 = {SNode.class, Project.class};
  private static Class[] PARAMETERS_3012473318495499856 = {SNode.class, Project.class};

  public static void init(SNode thisNode) {
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    List<Icon> markIcons = new ArrayList<Icon>(BaseConcept_Behavior.callSuper_getMarkIcons_3923831204883340393(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"));
    if (SPropertyOperations.getBoolean(thisNode, "isFinal")) {
      markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("FINALMARK"));
    }
    return markIcons;
  }

  public static SNode virtual_createReference_1213877517482(SNode thisNode) {
    throw new RuntimeException();
  }

  public static boolean virtual_isInitializable_1213877517488(SNode thisNode) {
    return false;
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    ListSequence.fromList(result).addElement(SLinkOperations.getTarget(thisNode, "type", true));
    return result;
  }

  public static SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    SNode type = null;
    if (SNodeOperations.getParent(expression) == thisNode && SNodeOperations.hasRole(expression, "jetbrains.mps.baseLanguage.structure.VariableDeclaration", "initializer")) {
      type = SNodeOperations.copyNode(SLinkOperations.getTarget(thisNode, "type", true));
    }
    return type;
  }

  public static String virtual_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    return "";
  }

  public static String virtual_getSuffix_3012473318495499856(SNode thisNode, Project project) {
    return "";
  }

  public static SNode virtual_getTypeAnnotation_1233920952262(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "type", true);
  }

  public static List<Icon> call_getMarkIcons_5039675756633082307(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<Icon>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082307);
  }

  public static SNode call_createReference_1213877517482(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_createReference_1213877517482", PARAMETERS_1213877517482);
  }

  public static boolean call_isInitializable_1213877517488(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_isInitializable_1213877517488", PARAMETERS_1213877517488);
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182325660(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182325660);
  }

  public static String call_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495495520, project);
  }

  public static String call_getSuffix_3012473318495499856(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495499856, project);
  }

  public static List<Icon> callSuper_getMarkIcons_5039675756633082307(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082307);
  }

  public static SNode callSuper_createReference_1213877517482(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_createReference_1213877517482", PARAMETERS_1213877517482);
  }

  public static boolean callSuper_isInitializable_1213877517488(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_isInitializable_1213877517488", PARAMETERS_1213877517488);
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182325660(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182325660);
  }

  public static String callSuper_getPrefix_3012473318495495520(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495495520, project);
  }

  public static String callSuper_getSuffix_3012473318495499856(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.VariableDeclaration"), callerConceptFqName, "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495499856, project);
  }
}
