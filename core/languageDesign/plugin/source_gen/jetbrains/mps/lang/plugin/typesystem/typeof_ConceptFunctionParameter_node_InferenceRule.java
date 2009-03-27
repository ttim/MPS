package jetbrains.mps.lang.plugin.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.plugin.typesystem._Quotations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ConceptFunctionParameter_node_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_ConceptFunctionParameter_node_InferenceRule() {
  }

  public void applyRule(final SNode conceptFunctionParameter_node, final TypeCheckingContext typeCheckingContext) {
    SNode captionBlockNode = SNodeOperations.getAncestor(conceptFunctionParameter_node, "jetbrains.mps.lang.plugin.structure.GetInnerTabCaptionBlock", false, false);
    SNode mainConceptBlockNode = SNodeOperations.getAncestor(conceptFunctionParameter_node, "jetbrains.mps.lang.plugin.structure.GetBaseNodeBlock", false, false);
    if (captionBlockNode != null || mainConceptBlockNode != null) {
      {
        SNode _nodeToCheck_1029348928467 = conceptFunctionParameter_node;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(conceptFunctionParameter_node, "r:00000000-0000-4000-0000-011c89590364(jetbrains.mps.lang.plugin.typesystem)", "1206186129666", true), new _Quotations.QuotationClass_0().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590364(jetbrains.mps.lang.plugin.typesystem)", "1206186129664", intentionProvider);
      }
    } else
    {
      SNode tabbedEditor = SNodeOperations.getAncestor(conceptFunctionParameter_node, "jetbrains.mps.lang.plugin.structure.TabbedEditorDeclaration", false, false);
      if (tabbedEditor != null && SLinkOperations.getTarget(tabbedEditor, "mainConcept", false) != null) {
        {
          SNode _nodeToCheck_1029348928467 = conceptFunctionParameter_node;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createEquation(typeCheckingContext.typeOf(conceptFunctionParameter_node, "r:00000000-0000-4000-0000-011c89590364(jetbrains.mps.lang.plugin.typesystem)", "1206186126287", true), new _Quotations.QuotationClass_1().createNode(SLinkOperations.getTarget(tabbedEditor, "mainConcept", false), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590364(jetbrains.mps.lang.plugin.typesystem)", "1206186126285", intentionProvider);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_node";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
