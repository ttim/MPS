package jetbrains.mps.bootstrap.smodelLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class Replace_ListType_withNodeListType_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "replace with nlist < >";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "elementType", true), "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.replaceWithNewChild(node, "jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType");
  }

  public String getLocationString() {
    return "jetbrains.mps.bootstrap.smodelLanguage.intentions";
  }

}
