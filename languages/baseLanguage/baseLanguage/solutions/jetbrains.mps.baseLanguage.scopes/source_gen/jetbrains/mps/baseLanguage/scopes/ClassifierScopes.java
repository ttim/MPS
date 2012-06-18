package jetbrains.mps.baseLanguage.scopes;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.FilteringScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class ClassifierScopes {
  protected static Log log = LogFactory.getLog(ClassifierScopes.class);

  private ClassifierScopes() {
  }

  public static Scope filterVisibleClassifiersScope(@NotNull final SNode contextNode, @NotNull Scope inner) {
    return new FilteringScope(inner) {
      @Override
      public boolean isExcluded(SNode node) {
        if ((node == null)) {
          // todo: ? 
          // <node> 
          return true;
        }
        return !(VisibilityUtil.isVisible(contextNode, SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.IVisible")));
      }
    };
  }

  public static Scope filterWithClassExpressionClassifiers(@NotNull Scope inner) {
    return new FilteringScope(inner) {
      @Override
      public boolean isExcluded(SNode node) {
        return SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration");
      }
    };
  }

  public static Scope getReachableClassifiersScope(@NotNull SModel model, @NotNull IScope scope) {
    return new ClassifiersScope(model, scope, "jetbrains.mps.baseLanguage.structure.Classifier");
  }

  public static Scope getVisibleClassifiersScope(@NotNull final SNode contextNode, @NotNull IScope scope) {
    return filterVisibleClassifiersScope(contextNode, getReachableClassifiersScope(SNodeOperations.getModel(contextNode), scope));
  }

  public static Scope getVisibleClassesScope(@NotNull final SNode contextNode, @NotNull IScope scope) {
    return filterVisibleClassifiersScope(contextNode, new ClassifiersScope(SNodeOperations.getModel(contextNode), scope, "jetbrains.mps.baseLanguage.structure.ClassConcept"));
  }

  public static Scope getVisibleInterfacesScope(@NotNull final SNode contextNode, @NotNull IScope scope) {
    return filterVisibleClassifiersScope(contextNode, new ClassifiersScope(SNodeOperations.getModel(contextNode), scope, "jetbrains.mps.baseLanguage.structure.Interface"));
  }

  public static Scope getWithClassExpressionClassifiers(@NotNull SNode contextNode, @NotNull IScope scope) {
    return filterVisibleClassifiersScope(contextNode, filterWithClassExpressionClassifiers(getReachableClassifiersScope(SNodeOperations.getModel(contextNode), scope)));
  }

  public static Scope getAnnotationClassifiersScope(@NotNull final SNode contextNode, @NotNull IScope scope) {
    return filterVisibleClassifiersScope(contextNode, new ClassifiersScope(SNodeOperations.getModel(contextNode), scope, "jetbrains.mps.baseLanguage.structure.Annotation"));
  }

  public static Scope getThrowablesScope(@NotNull SNode contextNode, @NotNull IScope scope) {
    return new FilteringScope(new ClassifiersScope(SNodeOperations.getModel(contextNode), scope, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      @Override
      public boolean isExcluded(SNode node) {
        // todo: change it! need only extended classes here 
        return !(SetSequence.fromSet(ClassifierScopeUtils.getExtendedClassifiers(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier"))).contains(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Throwable")));
      }
    };
  }

  public static Scope getClassesForExtends(@NotNull SNode contextNode, @NotNull IScope scope) {
    // not final ClassConcepts 
    return new FilteringScope(filterWithClassExpressionClassifiers(new ClassifiersScope(SNodeOperations.getModel(contextNode), scope, "jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
      @Override
      public boolean isExcluded(SNode node) {
        return SPropertyOperations.getBoolean(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "isFinal");
      }
    };
  }

  public static Scope getClassesForStaticFieldReference(@NotNull SNode contextNode, @NotNull IScope scope) {
    final Set<SNode> enclosingClassifierAncestors = SetSequence.fromSet(new HashSet<SNode>());
    SetSequence.fromSet(enclosingClassifierAncestors).addSequence(ListSequence.fromList(SNodeOperations.getAncestors(contextNode, "jetbrains.mps.baseLanguage.structure.Classifier", false)));

    return new FilteringScope(getVisibleClassifiersScope(contextNode, scope)) {
      @Override
      public boolean isExcluded(SNode node) {
        if (SetSequence.fromSet(enclosingClassifierAncestors).contains(node)) {
          return false;
        }

        SNode classifier = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier");
        if (SPropertyOperations.getBoolean(classifier, "nonStatic") || SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
          return true;
        }

        List<SNode> ancestors = SNodeOperations.getAncestors(classifier, null, true);
        // Filtering out Classifiers located in third-party containers (not Classifiers) 
        // and having no common Classifier container with enclosing node. 
        // Useful for Classifiers contained in EditorTestCases 
        // ("result" should not be able to access classifiers from "nodeToEdit")... 
        // todo: VOODOO PEOPLE MAGIC PEOPLE 
        return ListSequence.fromList(ancestors).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Classifier"));
          }
        }).isNotEmpty() && ListSequence.fromList(ancestors).intersect(SetSequence.fromSet(enclosingClassifierAncestors)).isEmpty();
      }
    };
  }
}
