package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.generator.editor.QueriesUtil;

public class AddPropertyMacro_Intention extends BaseIntention {

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Add property macro";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.getModel(node).getModelDescriptor().getModule() instanceof Generator)) {
      return false;
    }
    return QueriesUtil.isPropertyMacroApplicable(node, editorContext.getSelectedCell());
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode propertyMacro = QueriesUtil.addPropertyMacro(node, editorContext.getSelectedCell());
    // set caret
    editorContext.selectAndSetCaret(propertyMacro, 0);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }

}
