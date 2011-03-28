package jetbrains.mps.baseLanguage.dates.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FormatPeriodExpression_Behavior {
  private static Class[] PARAMETERS_34521615669576867 = {SNode.class, SNode.class};
  private static Class[] PARAMETERS_34521615669576905 = {SNode.class, SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    if ((expression != null)) {
      String role = thisNode.getRoleOf(expression);
      if (SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression", "period"), "role").equals(role)) {
        return new FormatPeriodExpression_Behavior.QuotationClass_tjsbw0_a0a0b0a0b().createNode();
      }
    }
    return null;
  }

  public static SNode virtual_deriveType_4555537781928374706(SNode thisNode, SNode expression, SNode link) {
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression", "period") == link) {
      return new FormatPeriodExpression_Behavior.QuotationClass_tjsbw0_a0a0a0c().createNode();
    }
    return null;
  }

  public static SNode call_deriveType_34521615669576867(SNode thisNode, SNode expression) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression"), "virtual_deriveType_1213877435747", PARAMETERS_34521615669576867, expression);
  }

  public static SNode call_deriveType_34521615669576905(SNode thisNode, SNode expression, SNode link) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression"), "virtual_deriveType_4555537781928374706", PARAMETERS_34521615669576905, expression, link);
  }

  public static SNode callSuper_deriveType_34521615669576867(SNode thisNode, String callerConceptFqName, SNode expression) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression"), callerConceptFqName, "virtual_deriveType_1213877435747", PARAMETERS_34521615669576867, expression);
  }

  public static SNode callSuper_deriveType_34521615669576905(SNode thisNode, String callerConceptFqName, SNode expression, SNode link) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.dates.structure.FormatPeriodExpression"), callerConceptFqName, "virtual_deriveType_4555537781928374706", PARAMETERS_34521615669576905, expression, link);
  }

  public static class QuotationClass_tjsbw0_a0a0b0a0b {
    public QuotationClass_tjsbw0_a0a0b0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.PeriodType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_tjsbw0_a0a0a0c {
    public QuotationClass_tjsbw0_a0a0a0c() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.PeriodType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
