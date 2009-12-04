package jetbrains.mps.baseLanguage.javadoc.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class AddMethodDocComment_Intention extends BaseIntention implements Intention {
  public AddMethodDocComment_Intention() {
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration";
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
    return ((SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true) == null) ?
      "Add Documentation Comment" :
      "Remove Documentation Comment"
    );
  }

  public void execute(final SNode node, final EditorContext editorContext) {
    if ((SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true) != null)) {
      SLinkOperations.setTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), null, true);
      return;
    }

    SLinkOperations.setTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.MethodDocComment", null), true);
    //  Method parameters 
    for (SNode parameterDeclaration : ListSequence.fromList(SLinkOperations.getTargets(node, "parameter", true))) {
      SNode paramTag = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.ParameterBlockDocTag", null);
      SLinkOperations.setTarget(paramTag, "parameter", new _Quotations.QuotationClass_2().createNode(parameterDeclaration), true);
      SLinkOperations.addChild(SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true), "param", paramTag);
    }

    //  Type variables 
    for (SNode typeVariableDeclaration : ListSequence.fromList(SLinkOperations.getTargets(node, "typeVariableDeclaration", true))) {
      SNode paramTag = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.ParameterBlockDocTag", null);
      SLinkOperations.setTarget(paramTag, "parameter", new _Quotations.QuotationClass_0().createNode(typeVariableDeclaration), true);
      SLinkOperations.addChild(SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true), "param", paramTag);
    }

    //  Thrown exceptions 
    for (SNode throwsItem : ListSequence.fromList(SLinkOperations.getTargets(node, "throwsItem", true))) {
      SNode throwsTag = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.ThrowsBlockDocTag", null);
      SLinkOperations.setTarget(throwsTag, "exceptionType", SNodeOperations.copyNode(throwsItem), true);
      SLinkOperations.addChild(SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true), "throwsTag", throwsTag);
    }

    //  Return value 
    if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"))) {
      SLinkOperations.setTarget(SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("methodDocComment"), true), "return", SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.javadoc.structure.ReturnBlockDocTag", null), true);
    }
  }

  public String getLocationString() {
    return "jetbrains.mps.baseLanguage.javadoc.intentions";
  }
}
