package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.CreateFromUsageUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;

public class NewTemplateInSwitchCase_Intention extends BaseIntention implements Intention {
  public NewTemplateInSwitchCase_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.generator.structure.Reduction_MappingRule";
  }

  public boolean isParameterized() {
    return false;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "New Template";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    if (!(SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(SNodeOperations.getParent(node)), "jetbrains.mps.lang.generator.structure.TemplateSwitch"))) {
      return false;
    }
    if (editorContext.getSelectedCell().getLinkDeclaration() != ((LinkDeclaration)SNodeOperations.getAdapter(SLinkOperations.findLinkDeclaration("jetbrains.mps.lang.generator.structure.Reduction_MappingRule", "ruleConsequence")))) {
      return false;
    }
    return SLinkOperations.getTarget(node, "ruleConsequence", true) == null || SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(node, "ruleConsequence", true)), "jetbrains.mps.lang.generator.structure.RuleConsequence");
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode applicableConcept = SLinkOperations.getTarget(node, "applicableConcept", false);
    String name = CreateFromUsageUtil.getText(editorContext);
    if (name == null || name.length() == 0) {
      name = "case_";
      if (applicableConcept != null) {
        name += SPropertyOperations.getString(applicableConcept, "name");
      }
    }
    SNode t = SModelOperations.createNewRootNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.generator.structure.TemplateDeclaration", null);
    SPropertyOperations.set(t, "name", name);
    SLinkOperations.setTarget(t, "applicableConcept", applicableConcept, false);
    t.setProperty(SModelTreeNode.PACK, SPropertyOperations.getString(SNodeOperations.cast(SNodeOperations.getContainingRoot(node), "jetbrains.mps.lang.core.structure.BaseConcept"), "virtualPackage"));
    // make reference 
    SNode tr = SLinkOperations.setNewChild(node, "ruleConsequence", "jetbrains.mps.lang.generator.structure.TemplateDeclarationReference");
    SLinkOperations.setTarget(tr, "template", t, false);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }
}
