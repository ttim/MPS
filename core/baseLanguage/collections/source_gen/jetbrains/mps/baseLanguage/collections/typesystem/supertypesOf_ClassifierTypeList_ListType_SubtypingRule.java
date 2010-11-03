package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.pattern.IMatchingPattern;

public class supertypesOf_ClassifierTypeList_ListType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  private static SNodePointer SNODE_POINTER_u9nlj8_a0a1a0a1a2a0a0a0a0a0a2 = new SNodePointer("f:java_stub#java.util(java.util@java_stub)", "~List");

  /*package*/ GeneratedMatchingPattern myMatchingPattern;

  public supertypesOf_ClassifierTypeList_ListType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode node, TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    return new supertypesOf_ClassifierTypeList_ListType_SubtypingRule.QuotationClass_u9nlj8_a0a0a().createNode(((SNode) status.getPattern().getFieldValue("PatternVar_elemType")), typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      GeneratedMatchingPattern pattern = new supertypesOf_ClassifierTypeList_ListType_SubtypingRule.Pattern_u9nlj8_a0a0a0a2();
      this.myMatchingPattern = pattern;
      boolean b = pattern.match(argument);
      return new IsApplicableStatus(b, pattern);
    }
  }

  public boolean isWeak() {
    return true;
  }

  public static class QuotationClass_u9nlj8_a0a0a {
    public QuotationClass_u9nlj8_a0a0a() {
    }

    public SNode createNode(Object parameter_5, final TypeCheckingContext typeCheckingContext) {
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
            quotedNode_1.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_4, typeCheckingContext));
          }
        }
        result = quotedNode1_3;
      }
      return result;
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

  public static class Pattern_u9nlj8_a0a0a0a2 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode PatternVar_elemType;

    public Pattern_u9nlj8_a0a0a0a2() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_h8kiwa_a0a;
        nodeToMatch_h8kiwa_a0a = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.ClassifierType".equals(nodeToMatch_h8kiwa_a0a.getConceptFqName()))) {
          return false;
        }
        {
          SNode referent;
          referent = SNODE_POINTER_u9nlj8_a0a1a0a1a2a0a0a0a0a0a2.getNode();
          if (nodeToMatch_h8kiwa_a0a.getReferent("classifier") != referent) {
            return false;
          }
        }
        {
          String childRole_h8kiwa_ = "parameter";
          if (nodeToMatch_h8kiwa_a0a.getChildCount(childRole_h8kiwa_) != 1) {
            return false;
          }
          {
            SNode childVar_h8kiwa_a0a0 = nodeToMatch_h8kiwa_a0a.getChildren(childRole_h8kiwa_).get(0);
            this.PatternVar_elemType = childVar_h8kiwa_a0a0;
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
      if (pattern != null && pattern.getClass() == this.getClass()) {
        this.PatternVar_elemType = (SNode) pattern.getFieldValue("PatternVar_elemType");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("PatternVar_elemType".equals(fieldName)) {
        return this.PatternVar_elemType;
      }
      return null;
    }

    public void performActions(Object o) {
    }
  }
}
