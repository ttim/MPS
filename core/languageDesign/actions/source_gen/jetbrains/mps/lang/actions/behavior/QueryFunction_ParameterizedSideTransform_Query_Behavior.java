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
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class QueryFunction_ParameterizedSideTransform_Query_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    SNode hostMenuPart = SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.actions.structure.ParameterizedSideTransformMenuPart");
    SNode parameterType = SLinkOperations.getTarget(hostMenuPart, "type", true);
    if (parameterType != null) {
      return new QueryFunction_ParameterizedSideTransform_Query_Behavior.QuotationClass_r69hxy_a0a0c0b().createNode(parameterType);
    }
    return new QueryFunction_ParameterizedSideTransform_Query_Behavior.QuotationClass_r69hxy_a0d0b().createNode();
  }

  public static class QuotationClass_r69hxy_a0a0c0b {
    public QuotationClass_r69hxy_a0a0c0b() {
    }

    public SNode createNode(Object parameter_r69hxy_a0a0a0a2a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_r69hxy_a0a0c0a = null;
      SNode quotedNode_r69hxy_a0a0a2a0 = null;
      {
        quotedNode_r69hxy_a0a0c0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_r69hxy_a0a0c0a = quotedNode_r69hxy_a0a0c0a;
        {
          quotedNode_r69hxy_a0a0a2a0 = (SNode) parameter_r69hxy_a0a0a0a2a0;
          SNode quotedNode1_r69hxy_a0a0a2a0;
          if (_parameterValues_129834374.contains(quotedNode_r69hxy_a0a0a2a0)) {
            quotedNode1_r69hxy_a0a0a2a0 = CopyUtil.copy(quotedNode_r69hxy_a0a0a2a0);
          } else {
            _parameterValues_129834374.add(quotedNode_r69hxy_a0a0a2a0);
            quotedNode1_r69hxy_a0a0a2a0 = quotedNode_r69hxy_a0a0a2a0;
          }
          if (quotedNode1_r69hxy_a0a0a2a0 != null) {
            quotedNode_r69hxy_a0a0c0a.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_r69hxy_a0a0a2a0));
          }
        }
        result = quotedNode1_r69hxy_a0a0c0a;
      }
      return result;
    }
  }

  public static class QuotationClass_r69hxy_a0d0b {
    public QuotationClass_r69hxy_a0d0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_r69hxy_a0d0a = null;
      SNode quotedNode_r69hxy_a0a3a0 = null;
      {
        quotedNode_r69hxy_a0d0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_r69hxy_a0d0a = quotedNode_r69hxy_a0d0a;
        {
          quotedNode_r69hxy_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.WildCardType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_r69hxy_a0a3a0 = quotedNode_r69hxy_a0a3a0;
          quotedNode_r69hxy_a0d0a.addChild("elementType", quotedNode1_r69hxy_a0a3a0);
        }
        result = quotedNode1_r69hxy_a0d0a;
      }
      return result;
    }
  }
}
