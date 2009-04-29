package jetbrains.mpslite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class MPSLiteConceptDeclaration_Behavior {

  public static void init(SNode thisNode) {
  }

  public static void virtual_fillConcept_1239891562930(SNode thisNode, SNode concept, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    LineList_Behavior.call_fillConceptStructure_1238593666753(SLinkOperations.getTarget(thisNode, "lineList", true), ((SNode)MapSequence.fromMap(conceptsToTargets).get(thisNode)), conceptsToTargets, partsToLinks);
  }

  public static SNode virtual_createEditor_1239890004879(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    SNode editor = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration", null);
    SNode lineList = SLinkOperations.getTarget(thisNode, "lineList", true);
    SNode contentCell = GenerationUtils.generateEditorCellModel(lineList, thisNode, partsToLinks);
    if (contentCell == null) {
      return null;
    }
    SLinkOperations.setTarget(editor, "cellModel", contentCell, true);
    return editor;
  }

}
