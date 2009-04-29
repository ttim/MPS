package jetbrains.mpslite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class GenerationUtils {

  public GenerationUtils() {
  }

  public static SNode generateEditorCellModel(SNode lineList, SNode concept, Map<SNode, SNode> partsToLinks) {
    List<SNode> lines = SLinkOperations.getTargets(lineList, "line", true);
    if (ListSequence.fromList(lines).count() == 0) {
      if (SPropertyOperations.getBoolean(concept, "abstract")) {
        SNode errorCell = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Error", null);
        SPropertyOperations.set(errorCell, "text", "abstract " + SPropertyOperations.getString(concept, "name"));
        return errorCell;
      } else
      {
        return null;
      }
    } else if (ListSequence.fromList(lines).count() == 1) {
      List<SNode> lineParts = SLinkOperations.getTargets(ListSequence.fromList(lines).first(), "linePart", true);
      if (ListSequence.fromList(lineParts).count() == 1) {
        return LinePart_Behavior.call_createCellModel_1238614099938(ListSequence.fromList(lineParts).first(), partsToLinks);
      } else
      {
        SNode hCollection = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Collection", null);
        SLinkOperations.setTarget(hCollection, "cellLayout", SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellLayout_Horizontal", null), true);
        for(SNode linePart : lineParts) {
          SLinkOperations.addChild(hCollection, "childCellModel", LinePart_Behavior.call_createCellModel_1238614099938(linePart, partsToLinks));
        }
        return hCollection;
      }
    } else
    {
      SNode vCollection = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Collection", null);
      SLinkOperations.setTarget(vCollection, "cellLayout", SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellLayout_Vertical", null), true);
      for(SNode line : lines) {
        SNode hCollection = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellModel_Collection", null);
        SLinkOperations.setTarget(hCollection, "cellLayout", SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.CellLayout_Horizontal", null), true);
        SLinkOperations.addChild(vCollection, "childCellModel", hCollection);
        for(SNode linePart : SLinkOperations.getTargets(line, "linePart", true)) {
          SLinkOperations.addChild(hCollection, "childCellModel", LinePart_Behavior.call_createCellModel_1238614099938(linePart, partsToLinks));
        }
      }
      return vCollection;
    }
  }

  public static void fillBinarySideTransformActions(SNode binaryOperationConcept, SNode actions, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> linePartsToLinks) {
    SNode expressionConcept = (SNode)MapSequence.fromMap(conceptsToTargets).get(SLinkOperations.getTarget(SNodeOperations.getAncestor(binaryOperationConcept, "jetbrains.mpslite.structure.ConceptContainer", false, false), "expressionConcept", true));
    if ((expressionConcept != null)) {
      SNode rtBuilder = new _Quotations.QuotationClass_5().createNode(SNodeOperations.cast(MapSequence.fromMap(linePartsToLinks).get(SLinkOperations.getTarget(binaryOperationConcept, "leftTarget", true)), "jetbrains.mps.lang.structure.structure.LinkDeclaration"), MapSequence.fromMap(conceptsToTargets).get(binaryOperationConcept), expressionConcept);
      SNode ltBuilder = new _Quotations.QuotationClass_6().createNode(SNodeOperations.cast(MapSequence.fromMap(linePartsToLinks).get(SLinkOperations.getTarget(binaryOperationConcept, "rightTarget", true)), "jetbrains.mps.lang.structure.structure.LinkDeclaration"), MapSequence.fromMap(conceptsToTargets).get(binaryOperationConcept), expressionConcept);
      SLinkOperations.addChild(actions, "actionsBuilder", rtBuilder);
      SLinkOperations.addChild(actions, "actionsBuilder", ltBuilder);
    }
  }

}
