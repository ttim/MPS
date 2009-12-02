package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.GenerateIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.intentions.structure.IntentionContext;

public class GenerateMainMethod_Intention extends GenerateIntention {
  public GenerateMainMethod_Intention() {
  }

  public String getDescription(final SNode node, final EditorContext editorContext) {
    return "main (String[] args)";
  }

  public boolean isAvailableInChildNodes() {
    return true;
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    return !(ListSequence.fromList(SLinkOperations.getTargets(node, "staticMethod", true)).any(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return "main".equals(SPropertyOperations.getString(it, "name")) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(it, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType") && ListSequence.fromList(SLinkOperations.getTargets(it, "parameter", true)).count() == 1 && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getTargets(it, "parameter", true)).first(), "type", true), "jetbrains.mps.baseLanguage.structure.ArrayType");
      }
    })) && !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.AnonymousClass"));
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode methodNode = new _Quotations.QuotationClass_5().createNode();
    SLinkOperations.addChild(node, "staticMethod", methodNode);
    editorContext.select(SLinkOperations.getTarget(methodNode, "body", true));
  }

  

  public boolean executeUI(final SNode node, final EditorContext editorContext, IntentionContext intentionContext) {
    return true;
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ClassConcept";
  }
}
