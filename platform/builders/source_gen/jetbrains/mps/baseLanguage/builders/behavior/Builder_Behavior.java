package jetbrains.mps.baseLanguage.builders.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class Builder_Behavior {
  private static Class[] PARAMETERS_7057666463730595159 = {SNode.class};
  private static Class[] PARAMETERS_7057666463730718251 = {SNode.class};
  private static Class[] PARAMETERS_7057666463730727863 = {SNode.class ,SNode.class};
  private static Class[] PARAMETERS_7288041816792215495 = {SNode.class ,SNode.class ,SNode.class ,SNode.class};
  private static Class[] PARAMETERS_4797501453850305563 = {SNode.class ,SNode.class ,SNode.class ,SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getContextBuilder_7057666463730306577(SNode thisNode) {
    return Builder_Behavior.getContextBuilder_7057666463730366732(SNodeOperations.getParent(thisNode));
  }

  public static boolean virtual_isLeaf_7057666463730595159(SNode thisNode) {
    return SConceptPropertyOperations.getBoolean(thisNode, "leaf");
  }

  public static SNode virtual_getResultType_7057666463730718251(SNode thisNode) {
    return null;
  }

  public static SNode virtual_getAttachStatement_7288041816792215495(SNode thisNode, SNode childBuilder, SNode parentRef, SNode childRef) {
    return Builder_Behavior.call_getAttachStatementChild_4797501453850305563(childBuilder, thisNode, parentRef, childRef);
  }

  public static SNode virtual_getAttachStatementChild_4797501453850305563(SNode thisNode, SNode parentBuilder, SNode parentRef, SNode childRef) {
    throw new UnsupportedOperationException();
  }

  public static boolean call_isLeaf_7057666463730595159(SNode thisNode) {
    return (Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), "virtual_isLeaf_7057666463730595159", PARAMETERS_7057666463730595159);
  }

  public static SNode call_getResultType_7057666463730718251(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), "virtual_getResultType_7057666463730718251", PARAMETERS_7057666463730718251);
  }

  public static SNode call_getCreatorExpression_7057666463730727863(SNode thisNode, SNode parentRef) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), "virtual_getCreatorExpression_7057666463730727863", PARAMETERS_7057666463730727863, parentRef);
  }

  public static SNode call_getAttachStatement_7288041816792215495(SNode thisNode, SNode childBuilder, SNode parentRef, SNode childRef) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), "virtual_getAttachStatement_7288041816792215495", PARAMETERS_7288041816792215495, childBuilder, parentRef, childRef);
  }

  public static SNode call_getAttachStatementChild_4797501453850305563(SNode thisNode, SNode parentBuilder, SNode parentRef, SNode childRef) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), "virtual_getAttachStatementChild_4797501453850305563", PARAMETERS_4797501453850305563, parentBuilder, parentRef, childRef);
  }

  public static boolean callSuper_isLeaf_7057666463730595159(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), callerConceptFqName, "virtual_isLeaf_7057666463730595159", PARAMETERS_7057666463730595159);
  }

  public static SNode callSuper_getResultType_7057666463730718251(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), callerConceptFqName, "virtual_getResultType_7057666463730718251", PARAMETERS_7057666463730718251);
  }

  public static SNode callSuper_getCreatorExpression_7057666463730727863(SNode thisNode, String callerConceptFqName, SNode parentRef) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), callerConceptFqName, "virtual_getCreatorExpression_7057666463730727863", PARAMETERS_7057666463730727863, parentRef);
  }

  public static SNode callSuper_getAttachStatement_7288041816792215495(SNode thisNode, String callerConceptFqName, SNode childBuilder, SNode parentRef, SNode childRef) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), callerConceptFqName, "virtual_getAttachStatement_7288041816792215495", PARAMETERS_7288041816792215495, childBuilder, parentRef, childRef);
  }

  public static SNode callSuper_getAttachStatementChild_4797501453850305563(SNode thisNode, String callerConceptFqName, SNode parentBuilder, SNode parentRef, SNode childRef) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.builders.structure.Builder"), callerConceptFqName, "virtual_getAttachStatementChild_4797501453850305563", PARAMETERS_4797501453850305563, parentBuilder, parentRef, childRef);
  }

  public static SNode getContextBuilder_7057666463730366732(SNode context) {
    List<SNode> ancestors = SNodeOperations.getAncestors(context, "jetbrains.mps.baseLanguage.builders.structure.BuilderContainer", false);
    Iterable<SNode> nonLeaves = ListSequence.fromList(ancestors).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(BuilderContainer_Behavior.call_isLeaf_932644095877881871(it));
      }
    });
    return SLinkOperations.getTarget(Sequence.fromIterable(nonLeaves).first(), "builder", true);
  }
}
