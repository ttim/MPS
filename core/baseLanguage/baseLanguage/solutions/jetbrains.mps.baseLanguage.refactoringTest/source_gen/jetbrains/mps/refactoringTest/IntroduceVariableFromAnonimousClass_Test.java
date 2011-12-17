package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.IntroduceLocalVariableRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

@MPSLaunch
public class IntroduceVariableFromAnonimousClass_Test extends BaseTransformationTest {
  @Test
  public void test_IntroduceVariableFromAnonimousClassTest() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.IntroduceVariableFromAnonimousClass_Test$TestBody", "test_IntroduceVariableFromAnonimousClassTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_IntroduceVariableFromAnonimousClassTest() throws Exception {
      this.addNodeById("3109730807963543192");
      this.addNodeById("3109730807963543200");
      this.addNodeById("3109730807963545002");
      IntroduceLocalVariableRefactoring refactoring = new IntroduceLocalVariableRefactoring();
      refactoring.init(SNodeOperations.cast(this.getNodeById("3109730807963543246"), "jetbrains.mps.baseLanguage.structure.GenericNewExpression"), null);
      refactoring.setName("i");
      refactoring.setReplacingAll(true);
      refactoring.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("3109730807963543202"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("3109730807963601732"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
