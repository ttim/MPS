package jetbrains.mps.lang.constraints.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ConstraintFunction_ReferentSearchScope_Factory_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return new ConstraintFunction_ReferentSearchScope_Factory_Behavior.QuotationClass_8721_l523emneskiu().createNode();
  }

  public static class QuotationClass_8721_l523emneskiu {
    public QuotationClass_8721_l523emneskiu() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8721_fjbx1q27 = null;
      SNode quotedNode_8721_fjbx1q28 = null;
      SNode quotedNode_8721_fjbx1q29 = null;
      SNode quotedNode_8721_fjbx1q2a = null;
      {
        quotedNode_8721_fjbx1q27 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.JoinType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8721_fjbx1q27 = quotedNode_8721_fjbx1q27;
        {
          quotedNode_8721_fjbx1q28 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_8721_fjbx1q28 = quotedNode_8721_fjbx1q28;
          quotedNode1_8721_fjbx1q28.addReference(SReference.create("classifier", quotedNode1_8721_fjbx1q28, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel.search(jetbrains.mps.smodel.search@java_stub)"), SNodeId.fromString("~ISearchScope")));
          quotedNode_8721_fjbx1q27.addChild("argument", quotedNode1_8721_fjbx1q28);
        }
        {
          quotedNode_8721_fjbx1q29 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_8721_fjbx1q29 = quotedNode_8721_fjbx1q29;
          {
            quotedNode_8721_fjbx1q2a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
            SNode quotedNode1_8721_fjbx1q2a = quotedNode_8721_fjbx1q2a;
            quotedNode_8721_fjbx1q29.addChild("elementType", quotedNode1_8721_fjbx1q2a);
          }
          quotedNode_8721_fjbx1q27.addChild("argument", quotedNode1_8721_fjbx1q29);
        }
        result = quotedNode1_8721_fjbx1q27;
      }
      return result;
    }
  }
}
