package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
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
public class SimpleFindAndMoveForIntroduceLocalVar_Test extends BaseTransformationTest4 {
  @Test
  public void test_SimpleFindAndMoveForIntroduceLocalVarTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.SimpleFindAndMoveForIntroduceLocalVar_Test$TestBody", "test_SimpleFindAndMoveForIntroduceLocalVarTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_SimpleFindAndMoveForIntroduceLocalVarTest() throws Exception {
      this.addNodeById("7568753874916167815");
      this.addNodeById("7568753874916167870");
      IntroduceLocalVariableRefactoring refactoring = new IntroduceLocalVariableRefactoring();
      refactoring.init(SNodeOperations.cast(this.getNodeById("7568753874916167842"), "jetbrains.mps.baseLanguage.structure.DotExpression"), null);
      refactoring.setName("i");
      refactoring.setReplacingAll(true);
      refactoring.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("7568753874916167816"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("7568753874916167891"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
