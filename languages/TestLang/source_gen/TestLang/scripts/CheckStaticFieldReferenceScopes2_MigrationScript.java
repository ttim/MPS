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
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.baseLanguage.search.VisibleClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.project.GlobalScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopes;

public class CheckStaticFieldReferenceScopes2_MigrationScript extends BaseMigrationScript {
  public CheckStaticFieldReferenceScopes2_MigrationScript(IOperationContext operationContext) {
    super("Check static field reference scopes (classifier)");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Testing";
      }

      public String getAdditionalInfo() {
        return "Testing";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.baseLanguage.structure.StaticFieldReference";
      }

      public boolean isApplicableInstanceNode(final SNode node) {
        String excludingPrefix = "123collection";
        String startsFrom = "";

        SReference ref = SNodeOperations.getReference(node, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", "classifier"));

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

        _FunctionTypes._return_P0_E0<? extends Scope> oldScopeProvider = new _FunctionTypes._return_P0_E0<ISearchScope.Adapter>() {
          public ISearchScope.Adapter invoke() {
            return new ISearchScope.Adapter(new VisibleClassifiersScope(node, IClassifiersSearchScope.CLASSIFFIER, GlobalScope.getInstance()) {
              @NotNull
              @Override
              public List<SNode> getClassifiers() {
                Set<SNode> enclosingClassifierAncestors = SetSequence.fromSet(new HashSet<SNode>());
                SetSequence.fromSet(enclosingClassifierAncestors).addSequence(ListSequence.fromList(SNodeOperations.getAncestors(node, "jetbrains.mps.baseLanguage.structure.Classifier", false)));

                List<SNode> result = new ArrayList<SNode>();
                for (SNode classifier : ListSequence.fromList(super.getClassifiers())) {
                  if (SPropertyOperations.getBoolean(classifier, "nonStatic")) {
                    continue;
                  }
                  if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
                    continue;
                  }
                  List<SNode> ancestors = SNodeOperations.getAncestors(classifier, null, true);
                  // Filtering out Classifiers located in third-party containers (not Classifiers) 
                  // and having no common Classifier container with enclosing node. 
                  // Useful for Classifiers contained in EditorTestCases 
                  // ("result" should not be able to access classifiers from "nodeToEdit")... 
                  if (ListSequence.fromList(ancestors).where(new IWhereFilter<SNode>() {
                    public boolean accept(SNode it) {
                      return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Classifier"));
                    }
                  }).isNotEmpty() && ListSequence.fromList(ancestors).intersect(SetSequence.fromSet(enclosingClassifierAncestors)).isEmpty()) {
                    continue;
                  }
                  result.add(classifier);
                }
                return result;
              }
            });
          }
        };
        _FunctionTypes._return_P0_E0<? extends Scope> newScopeProvider = new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ClassifierScopes.getClassesForStaticFieldReference(node, GlobalScope.getInstance());
          }
        };

        return !(Utils.checkScopes(node, Utils.getNodes("old scope", oldScopeProvider), Utils.getNodes("new scope/from ioperation", newScopeProvider), true));
      }

      public void doUpdateInstanceNode(final SNode node) {
        _FunctionTypes._return_P0_E0<? extends Scope> oldScopeProvider = new _FunctionTypes._return_P0_E0<ISearchScope.Adapter>() {
          public ISearchScope.Adapter invoke() {
            return new ISearchScope.Adapter(new VisibleClassifiersScope(node, IClassifiersSearchScope.CLASSIFFIER, GlobalScope.getInstance()) {
              @NotNull
              @Override
              public List<SNode> getClassifiers() {
                Set<SNode> enclosingClassifierAncestors = SetSequence.fromSet(new HashSet<SNode>());
                SetSequence.fromSet(enclosingClassifierAncestors).addSequence(ListSequence.fromList(SNodeOperations.getAncestors(node, "jetbrains.mps.baseLanguage.structure.Classifier", false)));

                List<SNode> result = new ArrayList<SNode>();
                for (SNode classifier : ListSequence.fromList(super.getClassifiers())) {
                  if (SPropertyOperations.getBoolean(classifier, "nonStatic")) {
                    continue;
                  }
                  if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
                    continue;
                  }
                  List<SNode> ancestors = SNodeOperations.getAncestors(classifier, null, true);
                  // Filtering out Classifiers located in third-party containers (not Classifiers) 
                  // and having no common Classifier container with enclosing node. 
                  // Useful for Classifiers contained in EditorTestCases 
                  // ("result" should not be able to access classifiers from "nodeToEdit")... 
                  if (ListSequence.fromList(ancestors).where(new IWhereFilter<SNode>() {
                    public boolean accept(SNode it) {
                      return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Classifier"));
                    }
                  }).isNotEmpty() && ListSequence.fromList(ancestors).intersect(SetSequence.fromSet(enclosingClassifierAncestors)).isEmpty()) {
                    continue;
                  }
                  result.add(classifier);
                }
                return result;
              }
            });
          }
        };
        _FunctionTypes._return_P0_E0<? extends Scope> newScopeProvider = new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ClassifierScopes.getAnnotationClassifiersScope(node, GlobalScope.getInstance());
          }
        };

        Utils.checkScopes(node, Utils.getNodes("old scope", oldScopeProvider), Utils.getNodes("new scope/from ioperation", newScopeProvider), true);
      }

      public boolean isShowAsIntention() {
        return false;
      }
    });
  }
}
