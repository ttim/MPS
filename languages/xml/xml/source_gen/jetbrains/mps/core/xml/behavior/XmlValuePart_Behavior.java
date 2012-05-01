package jetbrains.mps.core.xml.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class XmlValuePart_Behavior {
  private static Class[] PARAMETERS_3080189811177340436 = {SNode.class};
  private static Class[] PARAMETERS_3080189811177340441 = {SNode.class};
  private static Class[] PARAMETERS_3080189811177340422 = {SNode.class};
  private static Class[] PARAMETERS_3080189811177340429 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isFirstPositionAllowed_3080189811177340436(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getPrevSibling(thisNode), "jetbrains.mps.core.xml.structure.XmlValuePart")) {
      SNode left = SNodeOperations.cast(SNodeOperations.getPrevSibling(thisNode), "jetbrains.mps.core.xml.structure.XmlValuePart");
      if (SNodeOperations.isInstanceOf(left, "jetbrains.mps.core.xml.structure.XmlTextValue")) {
        return XmlValuePart_Behavior.call_hasNewLineAfter_3080189811177340429(SNodeOperations.cast(left, "jetbrains.mps.core.xml.structure.XmlTextValue"));
      }
      return false;
    }
    return true;
  }

  public static boolean virtual_isLastPositionAllowed_3080189811177340441(SNode thisNode) {
    SNode right = SNodeOperations.getNextSibling(thisNode);
    if (SNodeOperations.isInstanceOf(right, "jetbrains.mps.core.xml.structure.XmlTextValue")) {
      return XmlValuePart_Behavior.call_onNewLine_3080189811177340422(SNodeOperations.cast(right, "jetbrains.mps.core.xml.structure.XmlTextValue"));
    }
    return true;
  }

  public static boolean virtual_onNewLine_3080189811177340422(SNode thisNode) {
    return false;
  }

  public static boolean virtual_hasNewLineAfter_3080189811177340429(SNode thisNode) {
    return false;
  }

  public static boolean call_isFirstPositionAllowed_3080189811177340436(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), "virtual_isFirstPositionAllowed_3080189811177340436", PARAMETERS_3080189811177340436);
  }

  public static boolean call_isLastPositionAllowed_3080189811177340441(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), "virtual_isLastPositionAllowed_3080189811177340441", PARAMETERS_3080189811177340441);
  }

  public static boolean call_onNewLine_3080189811177340422(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), "virtual_onNewLine_3080189811177340422", PARAMETERS_3080189811177340422);
  }

  public static boolean call_hasNewLineAfter_3080189811177340429(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), "virtual_hasNewLineAfter_3080189811177340429", PARAMETERS_3080189811177340429);
  }

  public static boolean callSuper_isFirstPositionAllowed_3080189811177340436(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), callerConceptFqName, "virtual_isFirstPositionAllowed_3080189811177340436", PARAMETERS_3080189811177340436);
  }

  public static boolean callSuper_isLastPositionAllowed_3080189811177340441(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), callerConceptFqName, "virtual_isLastPositionAllowed_3080189811177340441", PARAMETERS_3080189811177340441);
  }

  public static boolean callSuper_onNewLine_3080189811177340422(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), callerConceptFqName, "virtual_onNewLine_3080189811177340422", PARAMETERS_3080189811177340422);
  }

  public static boolean callSuper_hasNewLineAfter_3080189811177340429(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.core.xml.structure.XmlValuePart"), callerConceptFqName, "virtual_hasNewLineAfter_3080189811177340429", PARAMETERS_3080189811177340429);
  }
}
