package jetbrains.mps.lang.smodel.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class OperationParm_LinkQualifier_Behavior {
  private static Class[] PARAMETERS_2906110183022538865 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getOperation_5815925154349134240(SNode thisNode) {
    return SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.smodel.structure.SNodeOperation");
  }

  public static Iterable<SNode> virtual_getLinkAccessScope_2906110183022538642(SNode thisNode) {
    final boolean acceptAggregations = SNodeOperations.isInstanceOf(OperationParm_LinkQualifier_Behavior.call_getOperation_5815925154349134240(thisNode), "jetbrains.mps.lang.smodel.structure.Node_GetChildrenOperation");
    return ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(IOperation_Behavior.call_getOperand_1213877410070(OperationParm_LinkQualifier_Behavior.call_getOperation_5815925154349134240(thisNode))), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.lang.smodel.structure.SNodeType"), true), "concept", false))).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (acceptAggregations ?
          SPropertyOperations.hasValue(it, "metaClass", "aggregation", "reference") :
          SPropertyOperations.hasValue(it, "metaClass", "reference", "reference")
        );
      }
    });
  }

  public static Iterable<SNode> call_getLinkAccessScope_2906110183022538865(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Iterable<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.smodel.structure.OperationParm_LinkQualifier"), "virtual_getLinkAccessScope_2906110183022538642", PARAMETERS_2906110183022538865, new Object[]{});
  }

  public static Iterable<SNode> callSuper_getLinkAccessScope_2906110183022538865(SNode thisNode, String callerConceptFqName) {
    return (Iterable<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.smodel.structure.OperationParm_LinkQualifier"), callerConceptFqName, "virtual_getLinkAccessScope_2906110183022538642", PARAMETERS_2906110183022538865, new Object[]{});
  }
}
