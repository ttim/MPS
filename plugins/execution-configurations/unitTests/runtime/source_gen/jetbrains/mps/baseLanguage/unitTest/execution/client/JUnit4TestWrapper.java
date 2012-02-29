package jetbrains.mps.baseLanguage.unitTest.execution.client;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.smodel.search.IsInstanceCondition;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class JUnit4TestWrapper extends AbstractTestWrapper<SNode> {
  public JUnit4TestWrapper(SNode clazz) {
    super(clazz);
  }

  public boolean isTestCase() {
    return true;
  }

  @NonNls
  @Override
  public String getFqName() {
    return check_rdmqn1_a0a1(getNode(), this);
  }

  @NotNull
  @Override
  public Iterable<ITestNodeWrapper> getTestMethods() {
    List<SNode> methodDeclarations = (List<SNode>) new ClassifierAndSuperClassifiersScope(getNode(), IClassifiersSearchScope.INSTANCE_METHOD).getNodes(new IsInstanceCondition("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
    return ListSequence.fromList(methodDeclarations).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return JUnit4MethodWrapper.isJUnit4TestMethod(it);
      }
    }).select(new ISelector<SNode, ITestNodeWrapper>() {
      public ITestNodeWrapper select(SNode it) {
        return TestNodeWrapperFactory.tryToWrap(it);
      }
    }).where(new IWhereFilter<ITestNodeWrapper>() {
      public boolean accept(ITestNodeWrapper it) {
        return it != null;
      }
    });
  }

  public static boolean isJUnit4TestCase(SNode clazz) {
    if (SPropertyOperations.getBoolean(SNodeOperations.cast(clazz, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "abstractClass")) {
      return false;
    }
    for (SNode method : ListSequence.fromList(SLinkOperations.getTargets(clazz, "method", true))) {
      if (JUnit4MethodWrapper.isJUnit4TestMethod(method)) {
        return true;
      }
    }
    return false;
  }

  private static String check_rdmqn1_a0a1(SNode checkedDotOperand, JUnit4TestWrapper checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      return ((String) BehaviorManager.getInstance().invoke(Object.class, checkedDotOperand, "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    }
    return null;
  }
}
