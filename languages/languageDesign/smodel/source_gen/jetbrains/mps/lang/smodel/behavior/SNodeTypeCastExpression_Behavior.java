package jetbrains.mps.lang.smodel.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SNodeTypeCastExpression_Behavior {
  private static Class[] PARAMETERS_2749027262099690841 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean call_isSNodeCast_1238686302573(SNode thisNode) {
    SNode leftType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(thisNode, "leftExpression", true));
    return !(TypeChecker.getInstance().getSubtypingManager().isSubtype(leftType, new SNodeTypeCastExpression_Behavior.QuotationClass_cjhknp_a1a0a1a1().createNode(), false));
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    return (SPropertyOperations.getBoolean(thisNode, "asCast") ?
      "as" :
      ":"
    );
  }

  public static String call_getPresentation_2749027262099690841(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression"), "virtual_getPresentation_1213877396640", PARAMETERS_2749027262099690841, new Object[]{});
  }

  public static String callSuper_getPresentation_2749027262099690841(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression"), callerConceptFqName, "virtual_getPresentation_1213877396640", PARAMETERS_2749027262099690841, new Object[]{});
  }

  public static class QuotationClass_cjhknp_a1a0a1a1 {
    public QuotationClass_cjhknp_a1a0a1a1() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
