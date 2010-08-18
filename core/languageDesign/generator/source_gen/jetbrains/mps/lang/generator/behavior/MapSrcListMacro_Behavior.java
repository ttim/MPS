package jetbrains.mps.lang.generator.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.pattern.IMatchingPattern;

public class MapSrcListMacro_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getInputNodeTypeInsideOfMacro_1213877290799(SNode thisNode) {
    {
      GeneratedMatchingPattern pattern_wn5chh_a0a = new MapSrcListMacro_Behavior.Pattern_wn5chh_a0a0a0a1();
      SNode coercedNode_wn5chh_a0a = TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(thisNode, "sourceNodesQuery", true)), pattern_wn5chh_a0a);
      if (coercedNode_wn5chh_a0a != null) {
        return ((SNode) pattern_wn5chh_a0a.getFieldValue("PatternVar_concept"));
      } else {
      }
    }
    return null;
  }

  public static class Pattern_wn5chh_a0a0a0a1 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ SNode PatternVar_concept;

    public Pattern_wn5chh_a0a0a0a1() {
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_wn5chh_a0a0a0;
        nodeToMatch_wn5chh_a0a0a0 = nodeToMatch;
        if (!("jetbrains.mps.baseLanguage.collections.structure.ListType".equals(nodeToMatch_wn5chh_a0a0a0.getConceptFqName()))) {
          return false;
        }
        {
          String childRole_wn5chh_ = "elementType";
          if (nodeToMatch_wn5chh_a0a0a0.getChildCount(childRole_wn5chh_) != 1) {
            return false;
          }
          {
            SNode childVar_wn5chh_a0a0a0a = nodeToMatch_wn5chh_a0a0a0.getChildren(childRole_wn5chh_).get(0);
            {
              SNode nodeToMatch_wn5chh_a0a0a0a;
              nodeToMatch_wn5chh_a0a0a0a = childVar_wn5chh_a0a0a0a;
              if (!("jetbrains.mps.lang.smodel.structure.SNodeType".equals(nodeToMatch_wn5chh_a0a0a0a.getConceptFqName()))) {
                return false;
              }
              this.PatternVar_concept = nodeToMatch_wn5chh_a0a0a0a.getReferent("concept");
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

    public void performActions(Object o) {
    }
  }
}
