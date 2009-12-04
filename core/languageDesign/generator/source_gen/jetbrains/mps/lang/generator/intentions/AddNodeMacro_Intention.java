package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.generator.editor.QueriesUtil;

public class AddNodeMacro_Intention extends BaseIntention implements Intention {
  public AddNodeMacro_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
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
    return "Add Node Macro";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(SNodeOperations.getModel(node).getModelDescriptor().getModule() instanceof Generator)) {
      return false;
    }
    return QueriesUtil.isNodeMacroApplicable(node);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode nodeMacro = QueriesUtil.addNodeMacro(node);
    // set caret 
    editorContext.selectAndSetCaret(nodeMacro, 1);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }
}
