package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IMethodLike_Behavior {
  private static Class[] PARAMETERS_1239354342632 = {SNode.class};
  private static Class[] PARAMETERS_1239354409446 = {SNode.class};
  private static Class[] PARAMETERS_1239354440022 = {SNode.class};
  private static Class[] PARAMETERS_6204026822016975623 = {SNode.class};
  private static Class[] PARAMETERS_4989157187872658723 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getLastStatement_1239354409446(SNode thisNode) {
    return IMethodLike_Behavior.call_getLastStatement_2432385533253965663(thisNode, IMethodLike_Behavior.call_getBody_1239354440022(thisNode));
  }

  public static SNode call_getLastStatement_2432385533253965663(SNode thisNode, SNode statementList) {
    List<SNode> statements = new ArrayList<SNode>();
    ListSequence.fromList(statements).addSequence(ListSequence.fromList(SLinkOperations.getTargets(statementList, "statement", true)));
    while (SNodeOperations.getConceptDeclaration(ListSequence.fromList(statements).last()) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Statement") || SNodeOperations.getConceptDeclaration(ListSequence.fromList(statements).last()) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.RemarkStatement") || SNodeOperations.getConceptDeclaration(ListSequence.fromList(statements).last()) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.SingleLineComment")) {
      ListSequence.fromList(statements).removeLastElement();
    }
    SNode lastStatement = ListSequence.fromList(statements).last();
    if (SNodeOperations.isInstanceOf(lastStatement, "jetbrains.mps.baseLanguage.structure.BlockStatement")) {
      SNode innerStatementList = SLinkOperations.getTarget(SNodeOperations.cast(lastStatement, "jetbrains.mps.baseLanguage.structure.BlockStatement"), "statements", true);
      if (ListSequence.fromList(SLinkOperations.getTargets(innerStatementList, "statement", true)).isEmpty()) {
        return lastStatement;
      } else {
        return IMethodLike_Behavior.call_getLastStatement_2432385533253965663(thisNode, innerStatementList);
      }
    }
    return lastStatement;
  }

  public static boolean virtual_implicitThrows_4989157187872658723(SNode thisNode) {
    return false;
  }

  public static SNode call_getExpectedRetType_1239354342632(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), "virtual_getExpectedRetType_1239354342632", PARAMETERS_1239354342632);
  }

  public static SNode call_getLastStatement_1239354409446(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), "virtual_getLastStatement_1239354409446", PARAMETERS_1239354409446);
  }

  public static SNode call_getBody_1239354440022(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), "virtual_getBody_1239354440022", PARAMETERS_1239354440022);
  }

  public static List<SNode> call_getThrowableTypes_6204026822016975623(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), "virtual_getThrowableTypes_6204026822016975623", PARAMETERS_6204026822016975623);
  }

  public static boolean call_implicitThrows_4989157187872658723(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), "virtual_implicitThrows_4989157187872658723", PARAMETERS_4989157187872658723);
  }

  public static SNode callSuper_getExpectedRetType_1239354342632(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), callerConceptFqName, "virtual_getExpectedRetType_1239354342632", PARAMETERS_1239354342632);
  }

  public static SNode callSuper_getLastStatement_1239354409446(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), callerConceptFqName, "virtual_getLastStatement_1239354409446", PARAMETERS_1239354409446);
  }

  public static SNode callSuper_getBody_1239354440022(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), callerConceptFqName, "virtual_getBody_1239354440022", PARAMETERS_1239354440022);
  }

  public static List<SNode> callSuper_getThrowableTypes_6204026822016975623(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), callerConceptFqName, "virtual_getThrowableTypes_6204026822016975623", PARAMETERS_6204026822016975623);
  }

  public static boolean callSuper_implicitThrows_4989157187872658723(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.IMethodLike"), callerConceptFqName, "virtual_implicitThrows_4989157187872658723", PARAMETERS_4989157187872658723);
  }
}
