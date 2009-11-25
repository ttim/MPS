package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.GenerateIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class GenerateConstructor_Intention extends GenerateIntention {
  public GenerateConstructor_Intention() {
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "Constructor";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "constructor", true)).isEmpty();
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode classConcept = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    List<SNode> fields = SLinkOperations.getTargets(classConcept, "field", true);
    SNode constructor = SLinkOperations.addNewChild(classConcept, "constructor", "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
    SLinkOperations.setNewChild(constructor, "body", "jetbrains.mps.baseLanguage.structure.StatementList");
    for (SNode field : fields) {
      SNode parameterDeclaration = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ParameterDeclaration", null);
      SLinkOperations.setTarget(parameterDeclaration, "type", SNodeOperations.copyNode(SLinkOperations.getTarget(field, "type", true)), true);
      SPropertyOperations.set(parameterDeclaration, "name", SPropertyOperations.getString(field, "name"));
      SLinkOperations.addChild(constructor, "parameter", parameterDeclaration);
      SNode expressionStatement = SLinkOperations.addNewChild(SLinkOperations.getTarget(constructor, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
      SNode assignmentExpression = SLinkOperations.setNewChild(expressionStatement, "expression", "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
      SNode dotExpression = SLinkOperations.setNewChild(assignmentExpression, "lValue", "jetbrains.mps.baseLanguage.structure.DotExpression");
      SLinkOperations.setNewChild(dotExpression, "operand", "jetbrains.mps.baseLanguage.structure.ThisExpression");
      SNode fieldRef = SLinkOperations.setNewChild(dotExpression, "operation", "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation");
      SLinkOperations.setTarget(fieldRef, "fieldDeclaration", field, false);
      SNode parameterReference = SLinkOperations.setNewChild(assignmentExpression, "rValue", "jetbrains.mps.baseLanguage.structure.ParameterReference");
      SLinkOperations.setTarget(parameterReference, "variableDeclaration", parameterDeclaration, false);
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }
}
