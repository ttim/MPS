package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.UnpackHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.structure.BehaviorDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildLayout_Node_Behavior {
  private static Class[] PARAMETERS_7128123785277723766 = {SNode.class, UnpackHelper.class};
  private static Class[] PARAMETERS_6547494638219603457 = {SNode.class, Object.class};
  private static Class[] PARAMETERS_1368030936106753980 = {SNode.class};
  private static Class[] PARAMETERS_1368030936106753986 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static void virtual_unpack_7128123785277710736(SNode thisNode, UnpackHelper helper) {
    // nop 
  }

  public static boolean virtual_exports_6547494638219603457(SNode thisNode, Object object) {
    return false;
  }

  public static void virtual_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.build.structure.BuildLayout_Node")) {
      sb.append("/");
    }
    sb.append((SConceptPropertyOperations.getString(thisNode, "alias") != null ?
      SConceptPropertyOperations.getString(thisNode, "alias") :
      SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(thisNode), "name")
    ));
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    StringBuilder sb = new StringBuilder();
    BuildLayout_Node_Behavior.appendName_internal_1368030936106708110(thisNode, sb);
    return sb.toString();
  }

  public static boolean virtual_isFolder_1368030936106753980(SNode thisNode) {
    return false;
  }

  public static boolean virtual_isFile_1368030936106753986(SNode thisNode) {
    return false;
  }

  public static void call_unpack_7128123785277723766(SNode thisNode, UnpackHelper helper) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), "virtual_unpack_7128123785277710736", PARAMETERS_7128123785277723766, helper);
  }

  public static boolean call_exports_6547494638219603457(SNode thisNode, Object object) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), "virtual_exports_6547494638219603457", PARAMETERS_6547494638219603457, object);
  }

  public static boolean call_isFolder_1368030936106753980(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), "virtual_isFolder_1368030936106753980", PARAMETERS_1368030936106753980);
  }

  public static boolean call_isFile_1368030936106753986(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), "virtual_isFile_1368030936106753986", PARAMETERS_1368030936106753986);
  }

  public static void callSuper_unpack_7128123785277723766(SNode thisNode, String callerConceptFqName, UnpackHelper helper) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), callerConceptFqName, "virtual_unpack_7128123785277710736", PARAMETERS_7128123785277723766, helper);
  }

  public static boolean callSuper_exports_6547494638219603457(SNode thisNode, String callerConceptFqName, Object object) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), callerConceptFqName, "virtual_exports_6547494638219603457", PARAMETERS_6547494638219603457, object);
  }

  public static boolean callSuper_isFolder_1368030936106753980(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), callerConceptFqName, "virtual_isFolder_1368030936106753980", PARAMETERS_1368030936106753980);
  }

  public static boolean callSuper_isFile_1368030936106753986(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Node"), callerConceptFqName, "virtual_isFile_1368030936106753986", PARAMETERS_1368030936106753986);
  }

  public static void appendName_internal_1368030936106708110(SNode node, StringBuilder sb) {
    SNode parent = SNodeOperations.as(SNodeOperations.getParent(node), "jetbrains.mps.build.structure.BuildLayout_PathElement");
    if (parent != null) {
      BuildLayout_Node_Behavior.appendName_internal_1368030936106708110(parent, sb);
    }
    BuildLayout_PathElement_Behavior.call_appendName_1368030936106665465(node, parent, sb);
  }
}
