package jetbrains.mps.baseLanguage.dates.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FormatExpression_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    if ((expression != null)) {
      String role = thisNode.getRoleOf(expression);
      if (SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression", "dateExpression"), "role").equals(role)) {
        return new FormatExpression_Behavior.QuotationClass_w5avkh_a0a0b0a0b().createNode();
      } else if (SPropertyOperations.getString(SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression", "dateExpression"), "role").equals(role)) {
        return new FormatExpression_Behavior.QuotationClass_w5avkh_a0a0a1a0a1().createNode();
      }
    }
    return null;
  }

  public static SNode virtual_deriveType_4555537781928374706(SNode thisNode, SNode expression, SNode link) {
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression", "dateExpression") == link) {
      return new FormatExpression_Behavior.QuotationClass_w5avkh_a0a0a0c().createNode();
    } else if (SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.dates.structure.FormatExpression", "zone") == link) {
      return new FormatExpression_Behavior.QuotationClass_w5avkh_a0a0a0a2().createNode();
    }
    return null;
  }

  public static class QuotationClass_w5avkh_a0a0b0a0b {
    public QuotationClass_w5avkh_a0a0b0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_w5avkh_a0a0a1a0a1 {
    public QuotationClass_w5avkh_a0a0a1a0a1() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeZoneType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_w5avkh_a0a0a0c {
    public QuotationClass_w5avkh_a0a0a0c() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_w5avkh_a0a0a0a2 {
    public QuotationClass_w5avkh_a0a0a0a2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeZoneType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
