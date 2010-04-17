package jetbrains.mps.lang.refactoring.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class NodeOperation_Behavior {
  private static Class[] PARAMETERS_7012097027058652506 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_createType_7012097027058652452(SNode thisNode) {
    SNode refactoringNode = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.refactoring.structure.Refactoring", false, false);
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(refactoringNode, "target", true), "jetbrains.mps.lang.refactoring.structure.NodeTarget")) {
      return new NodeOperation_Behavior.QuotationClass_qyvi86_a0a0b0b().createNode(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(refactoringNode, "target", true), "jetbrains.mps.lang.refactoring.structure.NodeTarget"), "concept", false));
    }
    return new NodeOperation_Behavior.QuotationClass_qyvi86_a0c0b().createNode();
  }

  public static SNode call_createType_7012097027058652506(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.NodeOperation"), "virtual_createType_7012097027058652452", PARAMETERS_7012097027058652506);
  }

  public static SNode callSuper_createType_7012097027058652506(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.NodeOperation"), callerConceptFqName, "virtual_createType_7012097027058652452", PARAMETERS_7012097027058652506);
  }

  public static class QuotationClass_qyvi86_a0a0b0b {
    public QuotationClass_qyvi86_a0a0b0b() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("concept", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_qyvi86_a0c0b {
    public QuotationClass_qyvi86_a0c0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
