package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.EditorIntention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.baseLanguage.behavior.ClassConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class AddRuntimeExceptionToMethodSignature_Intention extends EditorIntention {
  public AddRuntimeExceptionToMethodSignature_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.ThrowStatement";
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
    return "Add Runtime Exception to Method Signature";
  }

  public boolean isApplicable(final SNode node, final EditorContext editorContext) {
    if (!(this.isApplicableToNode(node, editorContext))) {
      return false;
    }
    return true;
  }

  public boolean isApplicableToNode(final SNode node, final EditorContext editorContext) {
    // check that this is done in a method 
    SNode methodDecl = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    if (methodDecl == null) {
      return false;
    }
    // get exception type 
    final SNode exceptionType = (TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(node, "throwable", true)), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true));
    if (exceptionType == null) {
      return false;
    }
    SNode exceptionJavaType = (SNode)SLinkOperations.getTarget(exceptionType, "classifier", false);
    if (exceptionJavaType == null) {
      return false;
    }
    // check it's instance of RuntimeException 
    if (!(ClassConcept_Behavior.call_isDescendant_1213877355812(exceptionJavaType, (SNode)SLinkOperations.getTarget(new _Quotations.QuotationClass_1().createNode(), "classifier", false)))) {
      return false;
    }
    // check if it's not thrown by a method yet 
    if (ListSequence.fromList(SLinkOperations.getTargets(methodDecl, "throwsItem", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.ClassifierType") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false) == SLinkOperations.getTarget(exceptionType, "classifier", false);
      }
    }).isNotEmpty()) {
      return false;
    }
    return true;
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    SNode methodDecl = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    SLinkOperations.addChild(methodDecl, "throwsItem", SNodeOperations.cast(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(node, "throwable", true)), "jetbrains.mps.baseLanguage.structure.Type"));
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.intentions";
  }
}
