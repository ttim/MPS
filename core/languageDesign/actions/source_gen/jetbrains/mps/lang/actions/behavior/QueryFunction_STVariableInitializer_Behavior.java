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
    return new QueryFunction_STVariableInitializer_Behavior.QuotationClass_f9d5ph_a0b0b().createNode();
  }

  public static class QuotationClass_f9d5ph_a0b0b {
    public QuotationClass_f9d5ph_a0b0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_f9d5ph_a0b0a = null;
      {
        quotedNode_f9d5ph_a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_f9d5ph_a0b0a = quotedNode_f9d5ph_a0b0a;
        quotedNode1_f9d5ph_a0b0a.addReference(SReference.create("classifier", quotedNode1_f9d5ph_a0b0a, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_f9d5ph_a0b0a;
      }
      return result;
    }
  }
}
