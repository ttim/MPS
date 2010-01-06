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
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueryFunction_STVariableInitializer_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.actions.structure.SideTransformVariableDeclaration")) {
      return SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.actions.structure.SideTransformVariableDeclaration"), "type", true));
    }
    return new QueryFunction_STVariableInitializer_Behavior.QuotationClass_6219_0().createNode();
  }

  public static class QuotationClass_6219_0 {
    public QuotationClass_6219_0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_16 = null;
      {
        quotedNode_16 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_16 = quotedNode_16;
        quotedNode1_16.addReference(SReference.create("classifier", quotedNode1_16, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_16;
      }
      return result;
    }
  }
}
