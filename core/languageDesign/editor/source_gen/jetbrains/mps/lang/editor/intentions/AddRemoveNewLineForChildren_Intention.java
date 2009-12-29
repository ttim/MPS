package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.editor.behavior.IStyleContainer_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class AddRemoveNewLineForChildren_Intention extends BaseIntention implements Intention {
  public AddRemoveNewLineForChildren_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.editor.structure.EditorCellModel";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    if (ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem"))).isEmpty()) {
      return "Add New Line for Children";
    } else {
      return "Remove New Line for Children";
    }
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.editor.structure.CellModel_Collection")) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.editor.structure.CellModel_Collection"), "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Indent")) {
        return true;
      }
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.editor.structure.CellModel_RefNodeList")) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.editor.structure.CellModel_RefNodeList"), "cellLayout", true), "jetbrains.mps.lang.editor.structure.CellLayout_Indent")) {
        return true;
      }
    }
    return false;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    if (ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem"))).isEmpty()) {
      SNode styleItem = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem", null);
      SPropertyOperations.set(styleItem, "flag", "" + true);
      ListSequence.fromList(SLinkOperations.getTargets(node, "styleItem", true)).addElement(styleItem);
    } else {
      SNodeOperations.deleteNode(ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutNewLineChildrenStyleClassItem"))).first());
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.intentions";
  }
}
