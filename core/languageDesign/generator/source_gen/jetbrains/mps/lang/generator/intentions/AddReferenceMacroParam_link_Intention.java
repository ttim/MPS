package jetbrains.mps.lang.generator.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.generator.editor.QueriesUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.intentions.Intention;

public class AddReferenceMacroParam_link_Intention extends EditorIntention {
  private SNode myParameter;

  public AddReferenceMacroParam_link_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.lang.core.structure.BaseConcept";
  }

  public boolean isParameterized() {
    return true;
  }

  public boolean isErrorIntention() {
    return false;
  }

  public boolean isAvailableInChildNodes() {
    return false;
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Add Reference Macro: node." + this.myParameter.getPresentation();
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
    return QueriesUtil.isReferenceMacroApplicable(node, editorContext.getSelectedCell());
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode referenceMacro = QueriesUtil.addReferenceMacro(node, editorContext.getSelectedCell());
    SNode referentValue = SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.ReferenceMacro_GetReferent", null);
    SNode dotExpression = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.DotExpression", null);
    SNode linkAccess = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.SLinkAccess", null);
    SLinkOperations.setTarget(linkAccess, "link", this.myParameter, false);
    SLinkOperations.setTarget(dotExpression, "operation", linkAccess, true);
    SLinkOperations.setTarget(dotExpression, "operand", SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode", null), true);
    SNode expressionStatement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null);
    SLinkOperations.setTarget(expressionStatement, "expression", dotExpression, true);
    SLinkOperations.addChild(SLinkOperations.getTarget(referentValue, "body", true), "statement", expressionStatement);
    SLinkOperations.setTarget(referenceMacro, "referentFunction", referentValue, true);
    // set caret 
    editorContext.selectAndSetCaret(referenceMacro, 2);
  }

  public String getLocationString() {
    return "jetbrains.mps.lang.generator.intentions";
  }

  private static List<SNode> parameter(final SNode node, final EditorContext editorContext) {
    SNode sourceNode = MacroIntentionsUtil.getContextNodeConcept(node);
    if (sourceNode == null) {
      return null;
    }
    List<SNode> result = ListSequence.fromList(new ArrayList<SNode>());
    for (SNode child : AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(sourceNode)) {
      if (SPropertyOperations.hasValue(child, "sourceCardinality", "0..1", "0..1") || SPropertyOperations.hasValue(child, "sourceCardinality", "1", "0..1")) {
        ListSequence.fromList(result).addElement(child);
      }
    }
    return result;
  }

  public static List<Intention> instances(final SNode node, final EditorContext editorContext) {
    List<Intention> list = ListSequence.fromList(new ArrayList<Intention>());
    List<SNode> paramList = parameter(node, editorContext);
    if (paramList != null) {
      for (SNode param : paramList) {
        AddReferenceMacroParam_link_Intention intention = new AddReferenceMacroParam_link_Intention();
        intention.myParameter = param;
        ListSequence.fromList(list).addElement(intention);
      }
    }
    return list;
  }
}
