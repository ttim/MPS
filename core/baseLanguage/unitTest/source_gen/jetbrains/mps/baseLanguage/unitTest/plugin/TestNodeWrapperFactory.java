package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import junit.framework.TestCase;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public enum TestNodeWrapperFactory {
  LanguageTestCaseNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.unitTest.structure.BTestCase") && SPropertyOperations.getBoolean(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.unitTest.structure.BTestCase"), "abstractClass")) {
        return null;
      }
      return new LanguageTestWrapper(node);
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.structure.ITestCase");
    }

    public boolean isRoot() {
      return true;
    }

  },
  LanguageTestMethodNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      return new LanguageTestWrapper(node);
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod");
    }

    public boolean isRoot() {
      return false;
    }

  },
  JUnit3TestCaseNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      return new JUnit3TestWrapper(node);
    }

    public boolean canWrap(@NotNull SNode node) {
      if (eq_kl7j79_a0a0b2(SNodeOperations.getConceptDeclaration(node), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
        SNode ancestor = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.Classifier");
        while (ancestor != null && SNodeOperations.isInstanceOf(ancestor, "jetbrains.mps.baseLanguage.structure.ClassConcept") && !(INamedConcept_Behavior.call_getFqName_1213877404258(ancestor).equals(TestCase.class.getCanonicalName()))) {
          ancestor = check_kl7j79_a0a0b0a0b2(SLinkOperations.getTarget(SNodeOperations.cast(ancestor, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true));
        }
        return ancestor != null;
      }
      return false;
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept");
    }

    public boolean isRoot() {
      return true;
    }

  },
  JUnit3MethodsNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      return new JUnit3MethodWrapper(node);
    }

    public boolean canWrap(@NotNull SNode node) {
      return SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration") && JUnit3MethodWrapper.isTestMethod(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
    }

    public boolean isRoot() {
      return false;
    }

  },
  JUnit4TestNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      return new JUnit4TestWrapper(node);
    }

    public boolean canWrap(@NotNull SNode node) {
      if (eq_kl7j79_a0a0b4(SNodeOperations.getConceptDeclaration(node), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
        return JUnit4TestWrapper.isJUnit4TestCase(node);
      }
      return false;
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept");
    }

    public boolean isRoot() {
      return true;
    }

  },
  JUnit4MethodsNodeWrapperFactory() {

    @Nullable
    public ITestNodeWrapper<SNode> wrap(@NotNull SNode node) {
      return new JUnit4MethodWrapper(node);
    }

    public boolean canWrap(@NotNull SNode node) {
      return SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration") && JUnit4MethodWrapper.isJUnit4TestMethod(SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
    }

    public SNode getWrappedConcept() {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
    }

    public boolean isRoot() {
      return false;
    }

  };

  TestNodeWrapperFactory() {
  }

  @Nullable
  public abstract ITestNodeWrapper wrap(@NotNull SNode node);

  public boolean canWrap(@NotNull SNode node) {
    return node.isInstanceOfConcept(((AbstractConceptDeclaration) SNodeOperations.getAdapter(getWrappedConcept())));
  }

  public abstract SNode getWrappedConcept();

  public abstract boolean isRoot();

  @Nullable
  public static ITestNodeWrapper tryToWrap(@NotNull SNode node) {
    for (TestNodeWrapperFactory factory : Sequence.fromIterable(Sequence.fromArray(TestNodeWrapperFactory.values()))) {
      if (factory.canWrap(node)) {
        return factory.wrap(node);
      }
    }
    return null;
  }

  public static Iterable<SNode> getWrappedConcepts() {
    return Sequence.fromIterable(Sequence.fromArray(TestNodeWrapperFactory.values())).select(new ISelector<TestNodeWrapperFactory, SNode>() {
      public SNode select(TestNodeWrapperFactory it) {
        return it.getWrappedConcept();
      }
    });
  }

  public static Iterable<SNode> getWrappedRootConcepts() {
    return Sequence.fromIterable(Sequence.fromArray(TestNodeWrapperFactory.values())).where(new IWhereFilter<TestNodeWrapperFactory>() {
      public boolean accept(TestNodeWrapperFactory it) {
        return it.isRoot();
      }
    }).select(new ISelector<TestNodeWrapperFactory, SNode>() {
      public SNode select(TestNodeWrapperFactory it) {
        return it.getWrappedConcept();
      }
    });
  }

  private static SNode check_kl7j79_a0a0b0a0b2(SNode p) {
    if (null == p) {
      return null;
    }
    return SLinkOperations.getTarget(p, "classifier", false);
  }

  private static boolean eq_kl7j79_a0a0b2(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_kl7j79_a0a0b4(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
