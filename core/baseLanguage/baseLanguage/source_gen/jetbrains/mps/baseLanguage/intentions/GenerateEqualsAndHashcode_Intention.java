package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.GenerateIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.Pair;

public class GenerateEqualsAndHashcode_Intention extends GenerateIntention {
  public GenerateEqualsAndHashcode_Intention() {
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "equals() and hashCode()";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    SNode classConcept = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    return !(ListSequence.fromList(SLinkOperations.getTargets(classConcept, "method", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode method) {
        return SPropertyOperations.getString(method, "name").equals("equals") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.BooleanType");
      }
    })) && ListSequence.fromList(SLinkOperations.getTargets(classConcept, "field", true)).isNotEmpty();
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode classConcept = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    final List<SNode> fields = SLinkOperations.getTargets(classConcept, "field", true);
    SNode equalsDeclaration = SLinkOperations.addNewChild(classConcept, "method", "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
    SPropertyOperations.set(equalsDeclaration, "name", "equals");
    SLinkOperations.setNewChild(equalsDeclaration, "returnType", "jetbrains.mps.baseLanguage.structure.BooleanType");
    SNode paramDeclaration = SLinkOperations.addNewChild(equalsDeclaration, "parameter", "jetbrains.mps.baseLanguage.structure.ParameterDeclaration");
    SPropertyOperations.set(paramDeclaration, "name", "o");
    SLinkOperations.setTarget(paramDeclaration, "type", new _Quotations.QuotationClass_10().createNode(), true);
    SLinkOperations.setNewChild(equalsDeclaration, "body", "jetbrains.mps.baseLanguage.structure.StatementList");
    SNode thisExpression = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ThisExpression", null);
    SNode paramReference = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ParameterReference", null);
    SLinkOperations.setTarget(paramReference, "variableDeclaration", paramDeclaration, false);
    SNode classifierType = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
    SLinkOperations.setTarget(classifierType, "classifier", classConcept, false);
    SNode that = new _Quotations.QuotationClass_16().createNode(classifierType, classifierType, paramReference);
    SNode thisCheckStatement = new _Quotations.QuotationClass_13().createNode(thisExpression, paramReference);
    SNode nullCheckStatement = new _Quotations.QuotationClass_14().createNode(paramReference, paramReference);
    SNode classifierStatement = new _Quotations.QuotationClass_11().createNode(that);
    SLinkOperations.addChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", thisCheckStatement);
    SLinkOperations.addChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", nullCheckStatement);
    SLinkOperations.addNewChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.Statement");
    SLinkOperations.addChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", classifierStatement);
    SLinkOperations.addNewChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.Statement");
    SNode thatReference = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
    SLinkOperations.setTarget(thatReference, "variableDeclaration", that, false);
    SNode fieldReferenceOperation = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", null);
    for (SNode field : fields) {
      if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(field, "type", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType"))) {
        continue;
      }
      SLinkOperations.setTarget(fieldReferenceOperation, "fieldDeclaration", field, false);
      Pair<Object, Object> p;
      SNode checkStmt = new _Quotations.QuotationClass_4().createNode(thatReference, fieldReferenceOperation, thisExpression, fieldReferenceOperation);
      SLinkOperations.addChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", checkStmt);
    }
    SLinkOperations.addNewChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", "jetbrains.mps.baseLanguage.structure.Statement");
    SLinkOperations.addChild(SLinkOperations.getTarget(equalsDeclaration, "body", true), "statement", new _Quotations.QuotationClass_15().createNode());

    SNode hashCodeDeclaration = SLinkOperations.addNewChild(classConcept, "method", "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
    SPropertyOperations.set(hashCodeDeclaration, "name", "hashCode");
    SLinkOperations.setNewChild(hashCodeDeclaration, "returnType", "jetbrains.mps.baseLanguage.structure.IntegerType");
    SNode resultDeclaration = new _Quotations.QuotationClass_5().createNode();
    SNode resultReference = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
    SLinkOperations.setTarget(resultReference, "variableDeclaration", SLinkOperations.getTarget(resultDeclaration, "localVariableDeclaration", true), false);
    SLinkOperations.setNewChild(hashCodeDeclaration, "body", "jetbrains.mps.baseLanguage.structure.StatementList");
    SLinkOperations.addChild(SLinkOperations.getTarget(hashCodeDeclaration, "body", true), "statement", resultDeclaration);
    for (SNode field : fields) {
      if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(field, "type", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType"))) {
        continue;
      }
      SLinkOperations.setTarget(fieldReferenceOperation, "fieldDeclaration", field, false);
      Pair<Object, Object> p;
      SNode checkStatement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.Statement", null);
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(field, "type", true), "jetbrains.mps.baseLanguage.structure.IntegerType")) {
        checkStatement = new _Quotations.QuotationClass_7().createNode(fieldReferenceOperation, resultReference, resultReference);
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(field, "type", true), "jetbrains.mps.baseLanguage.structure.FloatType")) {
        checkStatement = new _Quotations.QuotationClass_8().createNode(fieldReferenceOperation, resultReference, fieldReferenceOperation, resultReference);
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(field, "type", true), "jetbrains.mps.baseLanguage.structure.StringType")) {
        checkStatement = new _Quotations.QuotationClass_9().createNode(resultReference, resultReference, fieldReferenceOperation, fieldReferenceOperation);
      }
      SLinkOperations.addChild(SLinkOperations.getTarget(hashCodeDeclaration, "body", true), "statement", checkStatement);
    }
    SLinkOperations.addChild(SLinkOperations.getTarget(hashCodeDeclaration, "body", true), "statement", new _Quotations.QuotationClass_6().createNode(resultReference));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }
}
