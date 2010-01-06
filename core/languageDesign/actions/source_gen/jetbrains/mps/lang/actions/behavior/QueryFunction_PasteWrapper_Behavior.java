package jetbrains.mps.lang.actions.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class QueryFunction_PasteWrapper_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode call_getWrapper_1221137519379(SNode thisNode) {
    return SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.actions.structure.PasteWrapper", false, false);
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return new QueryFunction_PasteWrapper_Behavior.QuotationClass_8066_0().createNode(SLinkOperations.getTarget(QueryFunction_PasteWrapper_Behavior.call_getWrapper_1221137519379(thisNode), "targetConcept", false));
  }

  public static class QuotationClass_8066_0 {
    public QuotationClass_8066_0() {
    }

    public SNode createNode(Object parameter_8066_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_15 = null;
      {
        quotedNode_15 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_15 = quotedNode_15;
        quotedNode1_15.setReferent("concept", (SNode) parameter_8066_0);
        result = quotedNode1_15;
      }
      return result;
    }
  }
}
