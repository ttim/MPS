package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import javax.swing.Icon;
import java.util.ArrayList;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.baseLanguage.plugin.IconResourceBundle_Behavior;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class EnumConstantDeclaration_Behavior {
  private static Class[] PARAMETERS_5039675756633083396 = {SNode.class};
  private static Class[] PARAMETERS_8986964027630472402 = {SNode.class};
  private static Class[] PARAMETERS_8884554759541376072 = {SNode.class};
  private static Class[] PARAMETERS_7448855087283424807 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getAvailableMethodDeclarations_5776618742611315379(SNode thisNode, String methodName) {
    SNode enumClass = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.EnumClass", false, false);
    return SLinkOperations.getTargets(enumClass, "constructor", true);
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    List<Icon> markIcons = new ArrayList<Icon>(BaseConcept_Behavior.callSuper_getMarkIcons_3923831204883340393(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"));
    markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("STATICMARK"));
    markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("FINALMARK"));
    return markIcons;
  }

  public static boolean virtual_isStatic_8986964027630462944(SNode thisNode) {
    return true;
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return IVisible_Behavior.call_getVisibilityIcon_5017341185733869581(thisNode);
  }

  public static String virtual_getFqName_1213877404258(SNode thisNode) {
    SNode containingEnum = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.EnumClass", false, false);
    return (containingEnum != null ?
      EnumConstantDeclaration_Behavior.call_getEnumConstantDeclarationPresentation_8767021959483237039(thisNode) + INamedConcept_Behavior.call_getFqName_1213877404258(containingEnum) :
      INamedConcept_Behavior.call_getFqName_1213877404258(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.INamedConcept"))
    );
  }

  public static String call_getEnumConstantDeclarationPresentation_8767021959483237039(SNode thisNode) {
    return "Enum constant '" + SPropertyOperations.getString(thisNode, "name") + "' in ";
  }

  public static List<Icon> call_getMarkIcons_5039675756633083396(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<Icon>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633083396);
  }

  public static boolean call_isStatic_8986964027630472402(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), "virtual_isStatic_8986964027630462944", PARAMETERS_8986964027630472402);
  }

  public static Icon call_getAdditionalIcon_8884554759541376072(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Icon) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541376072);
  }

  public static String call_getFqName_7448855087283424807(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), "virtual_getFqName_1213877404258", PARAMETERS_7448855087283424807);
  }

  public static List<Icon> callSuper_getMarkIcons_5039675756633083396(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633083396);
  }

  public static boolean callSuper_isStatic_8986964027630472402(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), callerConceptFqName, "virtual_isStatic_8986964027630462944", PARAMETERS_8986964027630472402);
  }

  public static Icon callSuper_getAdditionalIcon_8884554759541376072(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541376072);
  }

  public static String callSuper_getFqName_7448855087283424807(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration"), callerConceptFqName, "virtual_getFqName_1213877404258", PARAMETERS_7448855087283424807);
  }
}
