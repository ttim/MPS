package jetbrains.mps.lang.core.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import javax.swing.Icon;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.presentation.ReferenceConceptUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BaseConcept_Behavior {
  private static Class[] PARAMETERS_5017341185733863694 = {SNode.class};
  private static Class[] PARAMETERS_3923831204883340393 = {SNode.class};
  private static Class[] PARAMETERS_7941158526576616752 = {SNode.class};
  private static Class[] PARAMETERS_1213877396640 = {SNode.class};
  private static Class[] PARAMETERS_2354269628709769373 = {SNode.class};
  private static Class[] PARAMETERS_3981318653438234726 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean call_isInTemplates_1213877396627(SNode thisNode) {
    return SModelStereotype.isGeneratorModel(SNodeOperations.getModel(thisNode));
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return null;
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    return new ArrayList<Icon>();
  }

  public static boolean virtual_isRunnable_7941158526576616752(SNode thisNode) {
    return false;
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.core.structure.INamedConcept")) {
      String name = SPropertyOperations.getString(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
      if (name != null) {
        return name;
      }
      return "<no name>[" + SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(thisNode), "name") + "]";
    }
    // -- 
    String smartRefPresentation = ReferenceConceptUtil.getPresentation(thisNode);
    if (smartRefPresentation != null) {
      return smartRefPresentation;
    }
    // -- 
    String conceptAlias = SConceptPropertyOperations.getString(thisNode, "alias");
    if (conceptAlias != null) {
      return conceptAlias;
    }
    // -- 
    return SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(thisNode), "name");
  }

  public static String virtual_getDetailedPresentation_2354269628709769373(SNode thisNode) {
    return BaseConcept_Behavior.call_getPresentation_1213877396640(thisNode);
  }

  public static int virtual_getMetaLevel_3981318653438234726(SNode thisNode) {
    if (thisNode.isRoot()) {
      return 0;
    }
    int metalevel = 0;
    for (SNode metaLevelChanger : SNodeOperations.getAncestors(thisNode, "jetbrains.mps.lang.core.structure.IMetaLevelChanger", false)) {
      metalevel += IMetaLevelChanger_Behavior.call_getMetaLevelChange_201537367881074474(metaLevelChanger);
    }
    return metalevel;
  }

  public static Icon call_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Icon) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_5017341185733863694, new Object[]{});
  }

  public static List<Icon> call_getMarkIcons_3923831204883340393(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<Icon>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_3923831204883340393, new Object[]{});
  }

  public static boolean call_isRunnable_7941158526576616752(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_isRunnable_7941158526576616752", PARAMETERS_7941158526576616752, new Object[]{});
  }

  public static String call_getPresentation_1213877396640(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_getPresentation_1213877396640", PARAMETERS_1213877396640, new Object[]{});
  }

  public static String call_getDetailedPresentation_2354269628709769373(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_getDetailedPresentation_2354269628709769373", PARAMETERS_2354269628709769373, new Object[]{});
  }

  public static int call_getMetaLevel_3981318653438234726(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Integer) descriptor.invoke(Integer.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), "virtual_getMetaLevel_3981318653438234726", PARAMETERS_3981318653438234726, new Object[]{});
  }

  public static Icon callSuper_getAdditionalIcon_5017341185733863694(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_5017341185733863694, new Object[]{});
  }

  public static List<Icon> callSuper_getMarkIcons_3923831204883340393(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_3923831204883340393, new Object[]{});
  }

  public static boolean callSuper_isRunnable_7941158526576616752(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_isRunnable_7941158526576616752", PARAMETERS_7941158526576616752, new Object[]{});
  }

  public static String callSuper_getPresentation_1213877396640(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_getPresentation_1213877396640", PARAMETERS_1213877396640, new Object[]{});
  }

  public static String callSuper_getDetailedPresentation_2354269628709769373(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_getDetailedPresentation_2354269628709769373", PARAMETERS_2354269628709769373, new Object[]{});
  }

  public static int callSuper_getMetaLevel_3981318653438234726(SNode thisNode, String callerConceptFqName) {
    return (Integer) BehaviorManager.getInstance().invokeSuper(Integer.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.core.structure.BaseConcept"), callerConceptFqName, "virtual_getMetaLevel_3981318653438234726", PARAMETERS_3981318653438234726, new Object[]{});
  }
}
