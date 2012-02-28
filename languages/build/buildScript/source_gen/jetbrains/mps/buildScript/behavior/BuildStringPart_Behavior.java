package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildStringPart_Behavior {
  private static Class[] PARAMETERS_5096397858823356723 = {SNode.class};
  private static Class[] PARAMETERS_624440001685459414 = {SNode.class};
  private static Class[] PARAMETERS_624440001685490925 = {SNode.class};
  private static Class[] PARAMETERS_4380385936562037054 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_punctuationLeft_5096397858823356723(SNode thisNode) {
    if (SNodeOperations.getIndexInParent(thisNode) == 0) {
      return false;
    }
    return eq_cuvs1r_a0b0b(SNodeOperations.getConceptDeclaration(SNodeOperations.getPrevSibling(thisNode)), SNodeOperations.getConceptDeclaration(thisNode));
  }

  public static boolean virtual_isFirstPositionAllowed_624440001685459414(SNode thisNode) {
    return true;
  }

  public static boolean virtual_isLastPositionAllowed_624440001685490925(SNode thisNode) {
    return true;
  }

  public static String virtual_getText_4380385936562037054(SNode thisNode) {
    return "";
  }

  public static boolean call_punctuationLeft_5096397858823356723(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), "virtual_punctuationLeft_5096397858823356723", PARAMETERS_5096397858823356723);
  }

  public static boolean call_isFirstPositionAllowed_624440001685459414(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), "virtual_isFirstPositionAllowed_624440001685459414", PARAMETERS_624440001685459414);
  }

  public static boolean call_isLastPositionAllowed_624440001685490925(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), "virtual_isLastPositionAllowed_624440001685490925", PARAMETERS_624440001685490925);
  }

  public static String call_getText_4380385936562037054(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), "virtual_getText_4380385936562037054", PARAMETERS_4380385936562037054);
  }

  public static boolean callSuper_punctuationLeft_5096397858823356723(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), callerConceptFqName, "virtual_punctuationLeft_5096397858823356723", PARAMETERS_5096397858823356723);
  }

  public static boolean callSuper_isFirstPositionAllowed_624440001685459414(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), callerConceptFqName, "virtual_isFirstPositionAllowed_624440001685459414", PARAMETERS_624440001685459414);
  }

  public static boolean callSuper_isLastPositionAllowed_624440001685490925(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), callerConceptFqName, "virtual_isLastPositionAllowed_624440001685490925", PARAMETERS_624440001685490925);
  }

  public static String callSuper_getText_4380385936562037054(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildScript.structure.BuildStringPart"), callerConceptFqName, "virtual_getText_4380385936562037054", PARAMETERS_4380385936562037054);
  }

  private static boolean eq_cuvs1r_a0b0b(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
