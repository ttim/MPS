package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ScriptKindClassItem_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isApplicableTo_1214304723440(SNode thisNode, SNode cellModel) {
    do {
      SNode matchedNode_o7mo2_a0a = SNodeOperations.getParent(cellModel);
      {
        boolean matches_o7mo2_a0a0 = false;
        {
          SNode matchingNode_o7mo2_a0a0 = SNodeOperations.getParent(cellModel);
          if (matchingNode_o7mo2_a0a0 != null) {
            matches_o7mo2_a0a0 = SModelUtil_new.isAssignableConcept(matchingNode_o7mo2_a0a0.getConceptFqName(), "jetbrains.mps.lang.editor.structure.CellModel_Collection");
          }
        }
        if (matches_o7mo2_a0a0) {
          return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(matchedNode_o7mo2_a0a, "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Superscript");
        }
      }
      {
        boolean matches_o7mo2_b0a0 = false;
        {
          SNode matchingNode_o7mo2_b0a0 = SNodeOperations.getParent(cellModel);
          if (matchingNode_o7mo2_b0a0 != null) {
            matches_o7mo2_b0a0 = SModelUtil_new.isAssignableConcept(matchingNode_o7mo2_b0a0.getConceptFqName(), "jetbrains.mps.lang.editor.structure.CellModel_ListWithRole");
          }
        }
        if (matches_o7mo2_b0a0) {
          return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(matchedNode_o7mo2_a0a, "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Superscript");
        }
      }
      return false;
    } while(false);
  }
}
