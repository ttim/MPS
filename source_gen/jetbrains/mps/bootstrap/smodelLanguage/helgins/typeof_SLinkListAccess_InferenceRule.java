package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import java.util.List;
import jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration;
import jetbrains.mps.smodel.search.SModelSearchUtil_new;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SLinkListAccess_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SLinkListAccess_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    if(RulesUtil.checkAppliedCorrectly_generic(argument) && (SLinkOperations.getTarget(argument, "link", false) != null)) {
      SNode inputNodeConcept = RulesUtil.get_inputNodeConcept(argument);
      if(!((inputNodeConcept != null))) {
        TypeChecker.getInstance().reportTypeError(argument, "couldn't define node concept from left expression", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178559874465");
      }
      List<LinkDeclaration> declaredLinks = SModelSearchUtil_new.getLinkDeclarationsExcludingOverridden(((AbstractConceptDeclaration)SNodeOperations.getAdapter(inputNodeConcept)));
      SNode linkDecl = SLinkOperations.getTarget(argument, "link", false);
      if(!(declaredLinks.contains(((LinkDeclaration)SNodeOperations.getAdapter(linkDecl))))) {
        TypeChecker.getInstance().reportTypeError(argument, "access to link '" + SPropertyOperations.getString(linkDecl, "role") + "' is not expected here", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178559874485");
      }
    }
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_12().createNode(SLinkOperations.getTarget(SLinkOperations.getTarget(argument, "link", false), "target", false)), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178559874507");
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
