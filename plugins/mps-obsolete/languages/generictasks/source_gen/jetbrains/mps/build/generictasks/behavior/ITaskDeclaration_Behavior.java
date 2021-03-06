package jetbrains.mps.build.generictasks.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.buildlanguage.behavior.IDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITaskDeclaration_Behavior {
  private static Class[] PARAMETERS_1449762848926780427 = {SNode.class};
  private static Class[] PARAMETERS_1449762848926780436 = {SNode.class, List.class};
  private static Class[] PARAMETERS_1648602681640249389 = {SNode.class, SNode.class, List.class};
  private static Class[] PARAMETERS_4241383766070759083 = {SNode.class};
  private static Class[] PARAMETERS_4241383766070831847 = {SNode.class};
  private static Class[] PARAMETERS_4710899751214010949 = {SNode.class};
  private static Class[] PARAMETERS_1190349257898147625 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isAbstract_5699548131010533031(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "abstract");
  }

  public static boolean virtual_canBeRootTask_1449762848926780427(SNode thisNode) {
    return !(IDeclaration_Behavior.call_isAbstract_5699548131010533031(thisNode));
  }

  public static Iterable<SNode> virtual_getPossibleNesteds_1449762848926780436(final SNode thisNode, List<SNode> declarations) {
    final List<SNode> nestedTasks = ITaskDeclaration_Behavior.call_getNestedTasks_4241383766070831847(thisNode);
    return ListSequence.fromList(declarations).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return ITaskDeclaration_Behavior.call_isPossibleNested_1648602681640249389(thisNode, it, nestedTasks);
      }
    });
  }

  public static boolean virtual_isPossibleNested_1648602681640249389(SNode thisNode, SNode declaration, List<SNode> nestedTasks) {
    return !(ITaskDeclaration_Behavior.call_filterMeOut_4710899751214010949(declaration)) && IDeclaration_Behavior.call_isHeirOf_5699548131010535105(declaration, nestedTasks) && !(IDeclaration_Behavior.call_isAbstract_5699548131010533031(declaration));
  }

  public static boolean call_isPossibleNested_1648602681640273280(SNode thisNode, SNode declaration) {
    return ITaskDeclaration_Behavior.call_isPossibleNested_1648602681640249389(thisNode, declaration, ITaskDeclaration_Behavior.call_getNestedTasks_4241383766070831847(thisNode));
  }

  public static boolean virtual_hasNested_4241383766070759083(SNode thisNode) {
    return ListSequence.fromList(ITaskDeclaration_Behavior.call_getNestedTasks_4241383766070831847(thisNode)).count() > 0;
  }

  public static boolean virtual_filterMeOut_4710899751214010949(SNode thisNode) {
    return false;
  }

  public static List<SNode> virtual_getAttributesDeclarations_1190349257898147625(SNode thisNode) {
    return SLinkOperations.getTargets(thisNode, "attributesDecl", true);
  }

  public static boolean call_canBeRootTask_1449762848926780427(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_canBeRootTask_1449762848926780427", PARAMETERS_1449762848926780427, new Object[]{});
  }

  public static Iterable<SNode> call_getPossibleNesteds_1449762848926780436(SNode thisNode, List<SNode> declarations) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Iterable<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_getPossibleNesteds_1449762848926780436", PARAMETERS_1449762848926780436, new Object[]{declarations});
  }

  public static boolean call_isPossibleNested_1648602681640249389(SNode thisNode, SNode declaration, List<SNode> nestedTasks) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_isPossibleNested_1648602681640249389", PARAMETERS_1648602681640249389, new Object[]{declaration, nestedTasks});
  }

  public static boolean call_hasNested_4241383766070759083(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_hasNested_4241383766070759083", PARAMETERS_4241383766070759083, new Object[]{});
  }

  public static List<SNode> call_getNestedTasks_4241383766070831847(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_getNestedTasks_4241383766070831847", PARAMETERS_4241383766070831847, new Object[]{});
  }

  public static boolean call_filterMeOut_4710899751214010949(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_filterMeOut_4710899751214010949", PARAMETERS_4710899751214010949, new Object[]{});
  }

  public static List<SNode> call_getAttributesDeclarations_1190349257898147625(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), "virtual_getAttributesDeclarations_1190349257898147625", PARAMETERS_1190349257898147625, new Object[]{});
  }

  public static boolean callSuper_canBeRootTask_1449762848926780427(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_canBeRootTask_1449762848926780427", PARAMETERS_1449762848926780427, new Object[]{});
  }

  public static Iterable<SNode> callSuper_getPossibleNesteds_1449762848926780436(SNode thisNode, String callerConceptFqName, List<SNode> declarations) {
    return (Iterable<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_getPossibleNesteds_1449762848926780436", PARAMETERS_1449762848926780436, new Object[]{declarations});
  }

  public static boolean callSuper_isPossibleNested_1648602681640249389(SNode thisNode, String callerConceptFqName, SNode declaration, List<SNode> nestedTasks) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_isPossibleNested_1648602681640249389", PARAMETERS_1648602681640249389, new Object[]{declaration, nestedTasks});
  }

  public static boolean callSuper_hasNested_4241383766070759083(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_hasNested_4241383766070759083", PARAMETERS_4241383766070759083, new Object[]{});
  }

  public static List<SNode> callSuper_getNestedTasks_4241383766070831847(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_getNestedTasks_4241383766070831847", PARAMETERS_4241383766070831847, new Object[]{});
  }

  public static boolean callSuper_filterMeOut_4710899751214010949(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_filterMeOut_4710899751214010949", PARAMETERS_4710899751214010949, new Object[]{});
  }

  public static List<SNode> callSuper_getAttributesDeclarations_1190349257898147625(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.generictasks.structure.ITaskDeclaration"), callerConceptFqName, "virtual_getAttributesDeclarations_1190349257898147625", PARAMETERS_1190349257898147625, new Object[]{});
  }
}
