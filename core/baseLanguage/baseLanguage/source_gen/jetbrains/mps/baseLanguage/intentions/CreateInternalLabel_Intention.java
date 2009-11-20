package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class CreateInternalLabel_Intention extends EditorIntention {
  public CreateInternalLabel_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.Statement";
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
    return "Create Internal Label";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.BreakStatement") && StringUtils.isEmpty(SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.BreakStatement"), "label"))) || (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ContinueStatement") && StringUtils.isEmpty(SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ContinueStatement"), "label"))) || (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement") && StringUtils.isEmpty(SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement"), "label"))) || (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.SwitchStatement") && StringUtils.isEmpty(SPropertyOperations.getString(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.SwitchStatement"), "label")));
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    String value = "label";
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.BreakStatement")) {
      SPropertyOperations.set(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.BreakStatement"), "label", value);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ContinueStatement")) {
      SPropertyOperations.set(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ContinueStatement"), "label", value);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")) {
      SPropertyOperations.set(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement"), "label", value);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.SwitchStatement")) {
      SPropertyOperations.set(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.SwitchStatement"), "label", value);
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
