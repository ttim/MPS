package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class CellMenuPart_AbstractGroup_Query_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode hostMenuGroup = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.editor.structure.CellMenuPart_AbstractGroup", false, false);
    SNode parameterObjectType = SLinkOperations.getTarget(hostMenuGroup, "parameterObjectType", true);
    if (parameterObjectType == null) {
      return null;
    }
    return new CellMenuPart_AbstractGroup_Query_Behavior.QuotationClass_0518_0().createNode(parameterObjectType);
  }

  public static class QuotationClass_0518_0 {
    public QuotationClass_0518_0() {
    }

    public SNode createNode(Object parameter_0518_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0518_0 = null;
      SNode quotedNode_0518_1 = null;
      {
        quotedNode_0518_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0518_0 = quotedNode_0518_0;
        {
          quotedNode_0518_1 = (SNode) parameter_0518_0;
          SNode quotedNode1_0518_1;
          if (_parameterValues_129834374.contains(quotedNode_0518_1)) {
            quotedNode1_0518_1 = CopyUtil.copy(quotedNode_0518_1);
          } else {
            _parameterValues_129834374.add(quotedNode_0518_1);
            quotedNode1_0518_1 = quotedNode_0518_1;
          }
          if (quotedNode1_0518_1 != null) {
            quotedNode_0518_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_0518_1));
          }
        }
        result = quotedNode1_0518_0;
      }
      return result;
    }
  }
}
