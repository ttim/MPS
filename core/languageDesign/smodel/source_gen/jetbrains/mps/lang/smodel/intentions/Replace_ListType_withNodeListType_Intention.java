package jetbrains.mps.lang.smodel.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class Replace_ListType_withNodeListType_Intention extends EditorIntention {
  public Replace_ListType_withNodeListType_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.collections.structure.ListType";
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
    return "Replace with 'nlist < >'";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "elementType", true), "jetbrains.mps.lang.smodel.structure.SNodeType");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.lang.smodel.structure.SNodeListType");
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.smodel.intentions";
  }
}
