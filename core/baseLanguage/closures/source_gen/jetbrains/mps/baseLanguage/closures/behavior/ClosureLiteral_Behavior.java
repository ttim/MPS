package jetbrains.mps.baseLanguage.closures.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ClosureLiteral_Behavior {
  private static Class[] PARAMETERS_1229718192182 = {SNode.class ,List.class ,SNode.class ,SNode.class ,SNode.class ,List.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    StringBuilder sb = new StringBuilder("{");
    String sep = " ";
    for (SNode pd : SLinkOperations.getTargets(thisNode, "parameter", true)) {
      sb.append(sep).append(BaseConcept_Behavior.call_getPresentation_1213877396640(pd));
      sep = ", ";
    }
    return sb.append(" => <body> }").toString();
  }

  public static String call_getFunctionInterfaceName_1213877338544(SNode thisNode) {
    return "_function_" + ((SNode) thisNode).getId();
  }

  public static SNode virtual_getType_1229718192182(SNode thisNode, List<SNode> paramTypes, SNode resultType, SNode returnType, SNode termType, List<SNode> throwsTypes) {
    return new ClosureLiteral_Behavior.QuotationClass_l77foe_a0a0d().createNode(paramTypes, resultType, throwsTypes);
  }

  public static boolean virtual_isStatementListCompactable_1237546012856(SNode thisNode) {
    return true;
  }

  public static SNode virtual_getBody_1239354440022(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "body", true);
  }

  public static SNode virtual_getExpectedRetType_1239354342632(SNode thisNode) {
    // everything which is not void and null is good, 
    // look at ExpressionStatement.canServeAsReturn 
    return new ClosureLiteral_Behavior.QuotationClass_l77foe_a0c0g().createNode();
  }

  public static SNode call_getType_1229718192182(SNode thisNode, List<SNode> paramTypes, SNode resultType, SNode returnType, SNode termType, List<SNode> throwsTypes) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "virtual_getType_1229718192182", PARAMETERS_1229718192182, paramTypes, resultType, returnType, termType, throwsTypes);
  }

  public static SNode callSuper_getType_1229718192182(SNode thisNode, String callerConceptFqName, List<SNode> paramTypes, SNode resultType, SNode returnType, SNode termType, List<SNode> throwsTypes) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), callerConceptFqName, "virtual_getType_1229718192182", PARAMETERS_1229718192182, paramTypes, resultType, returnType, termType, throwsTypes);
  }

  public static class QuotationClass_l77foe_a0a0d {
    public QuotationClass_l77foe_a0a0d() {
    }

    public SNode createNode(Object parameter_l77foe_a0a0a0a2, Object parameter_l77foe_a0a0a0a2_0, Object parameter_l77foe_a0a0a0a2_1) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_l77foe_a0a0c = null;
      SNode quotedNode_l77foe_a0a0a2 = null;
      SNode quotedNode_l77foe_a0a0a2_0 = null;
      SNode quotedNode_l77foe_a0a0a2_1 = null;
      {
        quotedNode_l77foe_a0a0c = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.FunctionType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_l77foe_a0a0c = quotedNode_l77foe_a0a0c;
        {
          List<SNode> nodes = (List<SNode>) parameter_l77foe_a0a0a0a2;
          for (SNode child : nodes) {
            quotedNode_l77foe_a0a0c.addChild("parameterType", HUtil.copyIfNecessary(child));
          }
        }
        {
          quotedNode_l77foe_a0a0a2_0 = (SNode) parameter_l77foe_a0a0a0a2_0;
          SNode quotedNode1_l77foe_a0a0a2;
          if (_parameterValues_129834374.contains(quotedNode_l77foe_a0a0a2_0)) {
            quotedNode1_l77foe_a0a0a2 = CopyUtil.copy(quotedNode_l77foe_a0a0a2_0);
          } else {
            _parameterValues_129834374.add(quotedNode_l77foe_a0a0a2_0);
            quotedNode1_l77foe_a0a0a2 = quotedNode_l77foe_a0a0a2_0;
          }
          if (quotedNode1_l77foe_a0a0a2 != null) {
            quotedNode_l77foe_a0a0c.addChild("resultType", HUtil.copyIfNecessary(quotedNode1_l77foe_a0a0a2));
          }
        }
        {
          List<SNode> nodes = (List<SNode>) parameter_l77foe_a0a0a0a2_1;
          for (SNode child : nodes) {
            quotedNode_l77foe_a0a0c.addChild("throwsType", HUtil.copyIfNecessary(child));
          }
        }
        result = quotedNode1_l77foe_a0a0c;
      }
      return result;
    }
  }

  public static class QuotationClass_l77foe_a0c0g {
    public QuotationClass_l77foe_a0c0g() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_l77foe_a0c0f = null;
      {
        quotedNode_l77foe_a0c0f = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_l77foe_a0c0f = quotedNode_l77foe_a0c0f;
        quotedNode1_l77foe_a0c0f.addReference(SReference.create("classifier", quotedNode1_l77foe_a0c0f, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_l77foe_a0c0f;
      }
      return result;
    }
  }
}
