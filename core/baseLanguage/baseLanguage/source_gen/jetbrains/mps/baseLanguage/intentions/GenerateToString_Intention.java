package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.GenerateIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class GenerateToString_Intention extends GenerateIntention {
  public GenerateToString_Intention() {
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "toString()";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return !(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "method", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode method) {
        return "toString".equals(SPropertyOperations.getString(method, "name")) && ListSequence.fromList(SLinkOperations.getTargets(method, "parameter", true)).isEmpty() && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "returnType", true), "jetbrains.mps.baseLanguage.structure.StringType");
      }
    }));
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    final SNode classConcept = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    List<SNode> fields = SLinkOperations.getTargets(classConcept, "field", true);
    final SNode rightmostExpression;
    SNode firstField = ListSequence.fromList(fields).first();
    SNode currentExpression = null;
    for (SNode field : fields) {
      SNode fieldRef = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.FieldReferenceOperation", null);
      SLinkOperations.setTarget(fieldRef, "fieldDeclaration", field, false);
      SNode item = new _Quotations.QuotationClass_6().createNode(((field == firstField ?
        "" :
        ", "
      )) + SPropertyOperations.getString(field, "name") + "=");
      SNode dotExpression = new _Quotations.QuotationClass_33().createNode(SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ThisExpression", null), fieldRef);
      if (field == firstField) {
        currentExpression = new _Quotations.QuotationClass_26().createNode(SPropertyOperations.getString(classConcept, "name") + "{", item);
        currentExpression = new _Quotations.QuotationClass_35().createNode(dotExpression, currentExpression);
      } else {
        currentExpression = new _Quotations.QuotationClass_7().createNode(item, currentExpression);
        currentExpression = new _Quotations.QuotationClass_34().createNode(dotExpression, currentExpression);
      }
    }
    rightmostExpression = new _Quotations.QuotationClass_8().createNode(currentExpression);
    SLinkOperations.addChild(classConcept, "method", new _Quotations.QuotationClass_5().createNode(rightmostExpression));
  }

  public boolean executeUI(final SNode node, final EditorContext editorContext) {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }
}
