package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import java.util.List;
import jetbrains.mps.bootstrap.structureLanguage.structure.PropertyDeclaration;
import jetbrains.mps.smodel.search.SModelSearchUtil_new;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.structureLanguage.constraints.DataTypeDeclaration_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_SPropertyAccess_InferenceRule implements InferenceRule_Runtime {

  public  typeof_SPropertyAccess_InferenceRule() {
  }

  public void applyRule(final SNode argument) {
    if(RulesUtil.checkAppliedCorrectly_generic(argument) && (SLinkOperations.getTarget(argument, "property", false) != null)) {
      SNode inputNodeConcept = RulesUtil.get_inputNodeConcept(argument);
      if(!((inputNodeConcept != null))) {
        TypeChecker.getInstance().reportTypeError(argument, "couldn't define node concept from left expression", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178560745786");
      }
      List<PropertyDeclaration> declaredProperties = SModelSearchUtil_new.getPropertyDeclarationsExcludingOverridden(((AbstractConceptDeclaration)SNodeOperations.getAdapter(inputNodeConcept)));
      SNode property = SLinkOperations.getTarget(argument, "property", false);
      if(!(declaredProperties.contains(((PropertyDeclaration)SNodeOperations.getAdapter(property))))) {
        TypeChecker.getInstance().reportTypeError(argument, "access to property '" + SPropertyOperations.getString(property, "name") + "' is not expected here", "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1178560745806");
      }
    }
    SNode dataType = SLinkOperations.getTarget(SLinkOperations.getTarget(argument, "property", false), "dataType", false);
    if(dataType != null) {
      TypeChecker.getInstance().getRuntimeSupport().givetype(DataTypeDeclaration_Behavior.call_toBaseLanguageType_1182472765133(dataType), argument, "jetbrains.mps.bootstrap.smodelLanguage.helgins", "1182474193368");
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
