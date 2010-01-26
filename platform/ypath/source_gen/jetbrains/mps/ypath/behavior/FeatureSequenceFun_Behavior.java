package jetbrains.mps.ypath.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class FeatureSequenceFun_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode nodeType = SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getAncestor(thisNode, "jetbrains.mps.ypath.structure.TreePath", false, false), "treePathType", true), "nodeType", true);
    return new FeatureSequenceFun_Behavior.QuotationClass_1511_0().createNode(nodeType);
  }

  public static class QuotationClass_1511_0 {
    public QuotationClass_1511_0() {
    }

    public SNode createNode(Object parameter_1511_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1511_0 = null;
      SNode quotedNode_1511_1 = null;
      {
        quotedNode_1511_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1511_0 = quotedNode_1511_0;
        {
          quotedNode_1511_1 = (SNode) parameter_1511_0;
          SNode quotedNode1_1511_1;
          if (_parameterValues_129834374.contains(quotedNode_1511_1)) {
            quotedNode1_1511_1 = CopyUtil.copy(quotedNode_1511_1);
          } else {
            _parameterValues_129834374.add(quotedNode_1511_1);
            quotedNode1_1511_1 = quotedNode_1511_1;
          }
          if (quotedNode1_1511_1 != null) {
            quotedNode_1511_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_1511_1));
          }
        }
        result = quotedNode1_1511_0;
      }
      return result;
    }
  }
}
