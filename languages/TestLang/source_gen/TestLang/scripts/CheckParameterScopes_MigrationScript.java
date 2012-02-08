package TestLang.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class CheckParameterScopes_MigrationScript extends BaseMigrationScript {
  public CheckParameterScopes_MigrationScript(IOperationContext operationContext) {
    super("Check parameter scopes");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Testing";
      }

      public String getAdditionalInfo() {
        return "Testing";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.ParameterReference";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        String excludingPrefix = "123collection";
        String startsFrom = "";

        SReference ref = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ParameterReference", "parameterDeclaration"));

        if (ref == null) {
          return false;
        }
        if (Utils.isInComment(node)) {
          return false;
        }

        String name = SPropertyOperations.getString(SLinkOperations.getTarget(node, "variableDeclaration", false), "name");
        if (StringUtils.isEmpty(name)) {
          return false;
        }
        if (name.startsWith(excludingPrefix)) {
          return false;
        }
        if (!(name.startsWith(startsFrom))) {
          return false;
        }

        return !(Utils.checkScopes(node, Utils.getOldScopeFromRef(ref), Utils.getNewScopeFromRef(ref, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterDeclaration")), true));
      }

      public void doUpdateInstanceNode(SNode node) {
        SReference ref = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ParameterReference", "parameterDeclaration"));
        Utils.checkScopes(node, Utils.getOldScopeFromRef(ref), Utils.getNewScopeFromRef(ref, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterDeclaration")), true);
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
