package jetbrains.mps.bootstrap.smodelLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class Replace_ListType_withNodeListType_Intention extends BaseIntention implements Intention {

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public String getDescription(SNode node, EditorContext editorContext) {
    return "replace with nlist < >";
  }

  public boolean isApplicable(SNode node, EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "elementType", true), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType");
  }

  public void execute(SNode node, EditorContext editorContext) {
    SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType");
  }

}
