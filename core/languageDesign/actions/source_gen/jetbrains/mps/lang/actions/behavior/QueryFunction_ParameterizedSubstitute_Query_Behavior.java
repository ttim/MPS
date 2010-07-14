package jetbrains.mps.lang.actions.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class QueryFunction_ParameterizedSubstitute_Query_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode ancestor = SNodeOperations.getAncestorWhereConceptInList(thisNode, new String[]{"jetbrains.mps.lang.actions.structure.AddMenuPart", "jetbrains.mps.lang.actions.structure.ParameterizedSubstituteMenuPart"}, false, false);
    if (SNodeOperations.isInstanceOf(ancestor, "jetbrains.mps.lang.actions.structure.AddMenuPart")) {
      return new QueryFunction_ParameterizedSubstitute_Query_Behavior.QuotationClass_6qptm2_a0a0b0b().createNode(SLinkOperations.getTarget(SNodeOperations.cast(ancestor, "jetbrains.mps.lang.actions.structure.AddMenuPart"), "concept", false));
    }
    SNode expectedType = null;
    if (SNodeOperations.isInstanceOf(ancestor, "jetbrains.mps.lang.actions.structure.ParameterizedSubstituteMenuPart")) {
      expectedType = SLinkOperations.getTarget(SNodeOperations.cast(ancestor, "jetbrains.mps.lang.actions.structure.ParameterizedSubstituteMenuPart"), "type", true);
    }
    // ========== 
    if (expectedType == null) {
      return new QueryFunction_ParameterizedSubstitute_Query_Behavior.QuotationClass_6qptm2_a0a0f0b().createNode();
    }
    return new QueryFunction_ParameterizedSubstitute_Query_Behavior.QuotationClass_6qptm2_a0g0b().createNode(expectedType);
  }

  public static class QuotationClass_6qptm2_a0a0b0b {
    public QuotationClass_6qptm2_a0a0b0b() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode1_4.setReferent("conceptDeclaraton", (SNode) parameter_5);
          quotedNode_1.addChild("elementType", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_6qptm2_a0a0f0b {
    public QuotationClass_6qptm2_a0a0f0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.WildCardType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_4 = quotedNode_2;
          quotedNode_1.addChild("elementType", quotedNode1_4);
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_6qptm2_a0g0b {
    public QuotationClass_6qptm2_a0g0b() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = CopyUtil.copy(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
