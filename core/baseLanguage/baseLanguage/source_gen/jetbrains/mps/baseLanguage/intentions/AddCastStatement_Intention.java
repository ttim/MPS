package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class AddCastStatement_Intention extends EditorIntention {
  public AddCastStatement_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.IfStatement";
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
    return "Insert Cast Variable Declaration";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "condition", true), "jetbrains.mps.baseLanguage.structure.InstanceOfExpression") && (SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(node, "condition", true), "jetbrains.mps.baseLanguage.structure.InstanceOfExpression"), "classType", true) != null);
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode castVariable = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement", null);
    SNode instanceOfExpression = SNodeOperations.cast(SLinkOperations.getTarget(node, "condition", true), "jetbrains.mps.baseLanguage.structure.InstanceOfExpression");
    SNode declaration = SLinkOperations.getTarget(castVariable, "localVariableDeclaration", true);
    SLinkOperations.setTarget(declaration, "type", SNodeOperations.copyNode(SLinkOperations.getTarget(instanceOfExpression, "classType", true)), true);
    List<String> variableSuffixes = Type_Behavior.call_getVariableSuffixes_1213877337304(SLinkOperations.getTarget(instanceOfExpression, "classType", true));
    SPropertyOperations.set(declaration, "name", ListSequence.fromList(variableSuffixes).first());
    SNode castExpression = SLinkOperations.setNewChild(declaration, "initializer", "jetbrains.mps.baseLanguage.structure.CastExpression");
    SLinkOperations.setTarget(castExpression, "type", SNodeOperations.copyNode(SLinkOperations.getTarget(instanceOfExpression, "classType", true)), true);
    SLinkOperations.setTarget(castExpression, "expression", SNodeOperations.copyNode(SLinkOperations.getTarget(instanceOfExpression, "leftExpression", true)), true);
    SLinkOperations.insertChildFirst(SLinkOperations.getTarget(node, "ifTrue", true), "statement", castVariable);
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
