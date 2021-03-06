package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.CreateFromUsageUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNodeUtil;

public class NewTemplateInSwitchDefault_Intention extends BaseIntention implements Intention {
  public NewTemplateInSwitchDefault_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.generator.structure.TemplateSwitch";
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
    return "New Default Template";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SLinkOperations.getTarget(node, "defaultConsequence", true) == null;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    String name = CreateFromUsageUtil.getText(editorContext);
    if (name == null || name.length() == 0) {
      name = "default_" + SPropertyOperations.getString(node, "name");
    }
    SNode t = SNodeFactoryOperations.createNewRootNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.generator.structure.TemplateDeclaration", null);
    SPropertyOperations.set(t, "name", name);
    t.setProperty(SNodeUtil.property_BaseConcept_virtualPackage, SPropertyOperations.getString(SNodeOperations.cast(SNodeOperations.getContainingRoot(node), "jetbrains.mps.lang.core.structure.BaseConcept"), "virtualPackage"));
    // make reference 
    SNode tr = SNodeFactoryOperations.createNewNode("jetbrains.mps.lang.generator.structure.TemplateDeclarationReference", null);
    SLinkOperations.setTarget(tr, "template", t, false);
    SLinkOperations.setTarget(node, "defaultConsequence", tr, true);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }
}
