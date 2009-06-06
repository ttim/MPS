package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class AddMainMethod_Intention extends BaseIntention {

  public AddMainMethod_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
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
    return "Add Main Method";
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SLinkOperations.addChild(node, "staticMethod", new _Quotations.QuotationClass_4().createNode());
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

}
