package jetbrains.mps.lang.editor.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.editor.behavior.EditorCellModel_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.editor.behavior.IStyleContainer_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class RemoveIndent_Intention extends BaseIntention {

  public RemoveIndent_Intention() {
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
    return "Remove Indent";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    return EditorCellModel_Behavior.call_isIndented_1237383418148(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNodeOperations.deleteNode(ListSequence.fromList(IStyleContainer_Behavior.call_getClassItems_1219419901278(node, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.IndentLayoutIndentStyleClassItem"))).first());
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.editor.intentions";
  }

}
