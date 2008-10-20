package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class SplitConstantCellIntoWords_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.lang.editor.structure.CellModel_Constant";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "split constant cell into words";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if ((SNodeOperations.getParent(node) == null)) {
      return false;
    }
    if (SPropertyOperations.getString(node, "text").trim().contains(" ")) {
      return true;
    }
    return false;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    String text = SPropertyOperations.getString(node, "text").trim();
    SNode collection = SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.editor.structure.CellModel_Collection", null);
    SLinkOperations.setNewChild(collection, "cellLayout", "jetbrains.mps.lang.editor.structure.CellLayout_Flow");
    SNodeOperations.replaceWithAnother(node, collection);
    String[] strings = text.split(" ");
    for(String word : strings) {
      SNode constantCell = SNodeOperations.copyNode(node);
      SPropertyOperations.set(constantCell, "text", word);
      SLinkOperations.setTarget(constantCell, "styleClass", SLinkOperations.getTarget(node, "styleClass", false), false);
      for(SNode styleClassItem : SLinkOperations.getTargets(node, "styleItem", true)) {
        SLinkOperations.addChild(constantCell, "styleItem", SNodeOperations.copyNode(styleClassItem));
      }
      SLinkOperations.addChild(collection, "childCellModel", constantCell);
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.intentions";
  }

}
