package jetbrains.mps.lang.generator.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.lang.pattern.IMatchingPattern;

public class CopySrcListMacro_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getInputNodeTypeInsideOfMacro_1213877290799(SNode thisNode) {
    SNode queryType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(thisNode, "sourceNodesQuery", true));
    {
      GeneratedMatchingPattern pattern_26ny8p_b0a = new CopySrcListMacro_Behavior.Pattern_26ny8p_a0a0a1a1();
      SNode coercedNode_26ny8p_b0a = TypeChecker.getInstance().getRuntimeSupport().coerce_(queryType, pattern_26ny8p_b0a);
      if (coercedNode_26ny8p_b0a != null) {
        return ((SNode) pattern_26ny8p_b0a.getFieldValue("PatternVar_concept"));
      } else {
      }
    }
    return null;
  }

  public static class Pattern_26ny8p_a0a0a1a1 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode PatternVar_concept;

    public Pattern_26ny8p_a0a0a1a1() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_26ny8p_a0a1a0;
        nodeToMatch_26ny8p_a0a1a0 = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.collections.structure.SequenceType".equals(nodeToMatch_26ny8p_a0a1a0.getConceptFqName()))) {
          return false;
        }
        {
          String childRole_26ny8p_ = "elementType";
          if (nodeToMatch_26ny8p_a0a1a0.getChildCount(childRole_26ny8p_) != 1) {
            return false;
          }
          {
            SNode childVar_26ny8p_a0a0b0a = nodeToMatch_26ny8p_a0a1a0.getChildren(childRole_26ny8p_).get(0);
            {
              SNode nodeToMatch_26ny8p_a0a0b0a;
              nodeToMatch_26ny8p_a0a0b0a = childVar_26ny8p_a0a0b0a;
              if (!("jetbrains.mps.lang.smodel.structure.SNodeType".equals(nodeToMatch_26ny8p_a0a0b0a.getConceptFqName()))) {
                return false;
              }
              this.PatternVar_concept = nodeToMatch_26ny8p_a0a0b0a.getReferent("concept");
            }
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
        this.PatternVar_concept = (SNode) pattern.getFieldValue("PatternVar_concept");
      }
    }

    public Object getFieldValue(String fieldName) {
      if ("PatternVar_concept".equals(fieldName)) {
        return this.PatternVar_concept;
      }
      return null;
    }

    public void performActions() {
      throw new RuntimeException("NOT IMPLEMENTED");
    }
  }
}
