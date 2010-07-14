package jetbrains.mps.lang.refactoring.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class NodeMPSParameterType_Behavior {
  private static Class[] PARAMETERS_4413749148913760565 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getCreatorMethod_4413749148913760555(SNode thisNode) {
    return new NodeMPSParameterType_Behavior.QuotationClass_58bmda_a0a0b().createNode();
  }

  public static SNode call_getCreatorMethod_4413749148913760565(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.NodeMPSParameterType"), "virtual_getCreatorMethod_4413749148913760555", PARAMETERS_4413749148913760565);
  }

  public static SNode callSuper_getCreatorMethod_4413749148913760565(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.refactoring.structure.NodeMPSParameterType"), callerConceptFqName, "virtual_getCreatorMethod_4413749148913760555", PARAMETERS_4413749148913760565);
  }

  public static class QuotationClass_58bmda_a0a0b {
    public QuotationClass_58bmda_a0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classConcept", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.refactoring.framework.paramchooser.mps(jetbrains.mps.refactoring.framework.paramchooser.mps@java_stub)"), SNodeId.fromString("~MPSChooserFactory")));
        quotedNode1_2.addReference(SReference.create("baseMethodDeclaration", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.refactoring.framework.paramchooser.mps(jetbrains.mps.refactoring.framework.paramchooser.mps@java_stub)"), SNodeId.fromString("~MPSChooserFactory.createNodeChooser(jetbrains.mps.refactoring.framework.RefactoringContext,java.lang.String,jetbrains.mps.refactoring.framework.paramchooser.mps.IChooserSettings):jetbrains.mps.refactoring.framework.paramchooser.IChooser")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
