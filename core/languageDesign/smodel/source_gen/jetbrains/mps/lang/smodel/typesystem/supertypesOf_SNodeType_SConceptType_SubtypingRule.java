package jetbrains.mps.lang.smodel.typesystem;

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
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.pattern.runtime.PatternUtil;

public class supertypesOf_SNodeType_SConceptType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  private static SNodePointer SNODE_POINTER_6gcjzy_a0a0a0a0b0c0a0a0a0a0a0c = new SNodePointer("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "1169125787135");

  /*package*/ GeneratedMatchingPattern myMatchingPattern;

  public supertypesOf_SNodeType_SConceptType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode node, TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    return new supertypesOf_SNodeType_SConceptType_SubtypingRule.QuotationClass_6gcjzy_a0a0a().createNode(typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.SNodeType";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      GeneratedMatchingPattern pattern = new supertypesOf_SNodeType_SConceptType_SubtypingRule.Pattern_6gcjzy_a0a0a0a2();
      this.myMatchingPattern = pattern;
      boolean b = pattern.match(argument);
      return new IsApplicableStatus(b, pattern);
    }
  }

  public boolean isWeak() {
    return true;
  }

  public static class QuotationClass_6gcjzy_a0a0a {
    public QuotationClass_6gcjzy_a0a0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class Pattern_6gcjzy_a0a0a0a2 extends GeneratedMatchingPattern implements IMatchingPattern {
    public Pattern_6gcjzy_a0a0a0a2() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_supertypesOf_SNodeType_SConceptType_auyr2c_a0a;
        nodeToMatch_supertypesOf_SNodeType_SConceptType_auyr2c_a0a = nodeToMatch;
        if (!("jetbrains.mps.lang.smodel.structure.SNodeType".equals(nodeToMatch_supertypesOf_SNodeType_SConceptType_auyr2c_a0a.getConceptFqName()))) {
          return false;
        }
        {
          SNodePointer pointer = SNODE_POINTER_6gcjzy_a0a0a0a0b0c0a0a0a0a0a0c;
          if (!(PatternUtil.matchReferentWithNode(pointer, nodeToMatch_supertypesOf_SNodeType_SConceptType_auyr2c_a0a.getReferent("concept")))) {
            return false;
          }
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return false;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
    }

    public Object getFieldValue(String fieldName) {
      return null;
    }

    public void performActions(Object o) {
    }
  }
}
