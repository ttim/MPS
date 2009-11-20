package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.generator.editor.QueriesUtil;
import jetbrains.mps.nodeEditor.InspectorTool;

public class AddPropertyMacro_Intention extends EditorIntention {
  public AddPropertyMacro_Intention() {
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
    return "Add Property Macro";
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
    return QueriesUtil.isPropertyMacroApplicable(node, editorContext.getSelectedCell());
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode propertyMacro = QueriesUtil.addPropertyMacro(node, editorContext.getSelectedCell());
    // set caret 
    editorContext.selectAndSetCaret(propertyMacro, 0);
    InspectorTool inspector = editorContext.getOperationContext().getComponent(InspectorTool.class);
    assert inspector != null;
    inspector.openTool(true);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }
}
