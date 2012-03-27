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
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopes;
import jetbrains.mps.project.GlobalScope;

public class CheckClassifierClassExpressionScopes_MigrationScript extends BaseMigrationScript {
  public CheckClassifierClassExpressionScopes_MigrationScript(IOperationContext operationContext) {
    super("Check classifier class expression scopes");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Testing";
      }

      public String getAdditionalInfo() {
        return "Testing";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.ClassifierClassExpression";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        String excludingPrefix = "123collection";
        String startsFrom = "";

        final SReference ref = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", "classifier"));

        if (ref == null) {
          return false;
        }
        if (Utils.isInComment(node)) {
          return false;
        }

        String name = SPropertyOperations.getString(SLinkOperations.getTarget(node, "classifier", false), "name");
        if (StringUtils.isEmpty(name)) {
          return false;
        }
        if (name.startsWith(excludingPrefix)) {
          return false;
        }
        if (!(name.startsWith(startsFrom))) {
          return false;
        }

        return !(Utils.checkScopes(node, Utils.getOldScopeFromRef(ref), Utils.getNodes("new scope/from ioperation", new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ClassifierScopes.getVisibleClassifiersScope(ref.getSourceNode(), GlobalScope.getInstance());
          }
        }, ref), true));
      }

      public void doUpdateInstanceNode(SNode node) {
        final SReference ref = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", "classifier"));
        Utils.checkScopes(node, Utils.getOldScopeFromRef(ref), Utils.getNodes("new scope/from ioperation", new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ClassifierScopes.getVisibleClassifiersScope(ref.getSourceNode(), GlobalScope.getInstance());
          }
        }, ref), true);
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
