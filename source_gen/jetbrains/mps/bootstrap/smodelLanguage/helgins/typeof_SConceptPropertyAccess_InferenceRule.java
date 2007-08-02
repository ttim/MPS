package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SConceptPropertyAccess_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SConceptPropertyAccess_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    if(RulesUtil.checkAppliedCorrectly_generic(argument)) {
      SNode leftConcept = null;
      SNode leftType = RulesUtil.typeOf_leftExpression(argument);
      // sconcept ?
      SNode maybeSConceptType = TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType"), false);
      if(maybeSConceptType != null) {
        leftConcept = SLinkOperations.getTarget(maybeSConceptType, "conceptDeclaraton", false);
      } else
      {
        SNode maybeSNodeType = TypeChecker.getInstance().getRuntimeSupport().coerce(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"), false);
        if(maybeSNodeType != null) {
          leftConcept = SLinkOperations.getTarget(maybeSNodeType, "concept", false);
          if(leftConcept == null) {
            leftConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.core.structure.BaseConcept");
          }
        } else
        {
          if(!(false)) {
            TypeChecker.getInstance().reportTypeError(argument, "can't compute SNodeType from left expression", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1180485372640");
          }
        }
      }
      // ==================
      SNode conceptPropertyDecl = SLinkOperations.getTarget(argument, "conceptProperty", false);
      if(!((conceptPropertyDecl != null))) {
        TypeChecker.getInstance().reportTypeError(argument, "no concept property", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178325408416");
      }
      SNode declaringConcept = SNodeOperations.getParent(conceptPropertyDecl, null, false, false);
      RulesUtil.checkAssignableConcept(leftConcept, declaringConcept, argument, "operation is applied to wrong concept");
      // ==========
      if(SNodeOperations.isInstanceOf(conceptPropertyDecl, "jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptPropertyDeclaration")) {
        TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_19().createNode(), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178325979088");
      } else
      if(SNodeOperations.isInstanceOf(conceptPropertyDecl, "jetbrains.mps.bootstrap.structureLanguage.structure.IntegerConceptPropertyDeclaration")) {
        TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_20().createNode(), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178326120352");
      } else
      if(SNodeOperations.isInstanceOf(conceptPropertyDecl, "jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptPropertyDeclaration")) {
        TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_21().createNode(), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178326127988");
      } else
      {
        TypeChecker.getInstance().reportTypeError(argument, "unknown type of concept property: " + conceptPropertyDecl, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178326152635");
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptPropertyAccess";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
