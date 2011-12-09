package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class TypeVariableReference_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    SNode decl = SLinkOperations.getTarget(thisNode, "typeVariableDeclaration", false);
    if (decl != null) {
      return SPropertyOperations.getString(decl, "name");
    }
    return "?typevar_ref?";
  }

  public static SNode virtual_getErasure_702942408396803226(SNode thisNode) {
    if ((SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "typeVariableDeclaration", false), "bound", true) != null)) {
      return Type_Behavior.call_getErasure_702942408396803226(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "typeVariableDeclaration", false), "bound", true));
    }
    return new TypeVariableReference_Behavior.QuotationClass_6i211a_a0b0c().createNode();
  }

  public static SNode virtual_getLooseType_5744862332972792015(SNode thisNode, @NotNull Set<SNode> visitedTypeVariableReferences) {
    SNode bound = SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "typeVariableDeclaration", false), "bound", true);
    if ((bound != null) && !(SetSequence.fromSet(visitedTypeVariableReferences).contains(thisNode))) {
      SetSequence.fromSet(visitedTypeVariableReferences).addElement(thisNode);
      SNode upperBoundType = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.UpperBoundType", null);
      SLinkOperations.setTarget(upperBoundType, "bound", Type_Behavior.call_getLooseType_5744862332972792015(bound, visitedTypeVariableReferences), true);
      SetSequence.fromSet(visitedTypeVariableReferences).removeElement(thisNode);
      return upperBoundType;
    } else {
      return SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.WildCardType", null);
    }

  }

  public static class QuotationClass_6i211a_a0b0c {
    public QuotationClass_6i211a_a0b0c() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
