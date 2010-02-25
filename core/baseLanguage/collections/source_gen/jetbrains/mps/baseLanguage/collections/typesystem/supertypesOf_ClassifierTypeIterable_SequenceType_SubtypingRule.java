package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  private static SNodePointer SNODE_POINTERl523emneajys = new SNodePointer("f:java_stub#java.lang(java.lang@java_stub)", "~Iterable");

  /*package*/ GeneratedMatchingPattern myMatchingPattern;

  public supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule() {
  }

  public SNode getSubOrSuperType(SNode iterableClassifierType, TypeCheckingContext typeCheckingContext) {
    return new supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule.QuotationClass_2313_l523emneawh7().createNode(((SNode) this.myMatchingPattern.getFieldValue("PatternVar_p")), typeCheckingContext);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public boolean isApplicable(SNode argument) {
    this.myMatchingPattern = new supertypesOf_ClassifierTypeIterable_SequenceType_SubtypingRule.Pattern_2313_l523emneajzw();
    return this.myMatchingPattern.match(argument);
  }

  public boolean isWeak() {
    return true;
  }

  public static class Pattern_2313_l523emneajzw extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode PatternVar_p;

    public Pattern_2313_l523emneajzw() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_9805_f1kjn6ea;
        nodeToMatch_9805_f1kjn6ea = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.structure.ClassifierType".equals(nodeToMatch_9805_f1kjn6ea.getConceptFqName()))) {
          return false;
        }
        {
          SNode referent;
          referent = SNODE_POINTERl523emneajys.getNode();
          if (nodeToMatch_9805_f1kjn6ea.getReferent("classifier") != referent) {
            return false;
          }
        }
        {
          String childRole9805_l523emneajyt = "parameter";
          if (nodeToMatch_9805_f1kjn6ea.getChildCount(childRole9805_l523emneajyt) != 1) {
            return false;
          }
          {
            this.PatternVar_p = null;
            SNode childVar_9805_f1kjn7ya = nodeToMatch_9805_f1kjn6ea.getChildren(childRole9805_l523emneajyt).get(0);
            this.PatternVar_p = childVar_9805_f1kjn7ya;
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
        this.PatternVar_p = (SNode) pattern.getFieldValue("PatternVar_p");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("PatternVar_p".equals(fieldName)) {
        return this.PatternVar_p;
      }
      return null;
    }
  }

  public static class QuotationClass_2313_l523emneawh7 {
    public QuotationClass_2313_l523emneawh7() {
    }

    public SNode createNode(Object parameter_2313_l523emneajz3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_2313_l523emneajyp = null;
      SNode quotedNode_2313_l523emneajyq = null;
      {
        quotedNode_2313_l523emneajyp = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2313_l523emneajyp = quotedNode_2313_l523emneajyp;
        {
          quotedNode_2313_l523emneajyq = (SNode) parameter_2313_l523emneajz3;
          SNode quotedNode1_2313_l523emneajyq;
          if (_parameterValues_129834374.contains(quotedNode_2313_l523emneajyq)) {
            quotedNode1_2313_l523emneajyq = CopyUtil.copy(quotedNode_2313_l523emneajyq);
          } else {
            _parameterValues_129834374.add(quotedNode_2313_l523emneajyq);
            quotedNode1_2313_l523emneajyq = quotedNode_2313_l523emneajyq;
          }
          if (quotedNode1_2313_l523emneajyq != null) {
            quotedNode_2313_l523emneajyp.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_2313_l523emneajyq, typeCheckingContext));
          }
        }
        result = quotedNode1_2313_l523emneajyp;
      }
      return result;
    }

    public SNode createNode(Object parameter_2313_l523emneajz3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_2313_l523emneajyp = null;
      SNode quotedNode_2313_l523emneajyq = null;
      {
        quotedNode_2313_l523emneajyp = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2313_l523emneajyp = quotedNode_2313_l523emneajyp;
        {
          quotedNode_2313_l523emneajyq = (SNode) parameter_2313_l523emneajz3;
          SNode quotedNode1_2313_l523emneajyq;
          if (_parameterValues_129834374.contains(quotedNode_2313_l523emneajyq)) {
            quotedNode1_2313_l523emneajyq = CopyUtil.copy(quotedNode_2313_l523emneajyq);
          } else {
            _parameterValues_129834374.add(quotedNode_2313_l523emneajyq);
            quotedNode1_2313_l523emneajyq = quotedNode_2313_l523emneajyq;
          }
          if (quotedNode1_2313_l523emneajyq != null) {
            quotedNode_2313_l523emneajyp.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_2313_l523emneajyq));
          }
        }
        result = quotedNode1_2313_l523emneajyp;
      }
      return result;
    }
  }
}
