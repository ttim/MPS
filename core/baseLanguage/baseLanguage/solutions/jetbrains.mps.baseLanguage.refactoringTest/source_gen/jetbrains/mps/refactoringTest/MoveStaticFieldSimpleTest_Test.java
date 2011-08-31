package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MoveStaticFieldRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;

@MPSLaunch
public class MoveStaticFieldSimpleTest_Test extends BaseTransformationTest {
  @Test
  public void test_SimpleTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.MoveStaticFieldSimpleTest_Test$TestBody", "test_SimpleTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_SimpleTest() throws Exception {
      this.addNodeById("8495840634674645159");
      this.addNodeById("8495840634674645188");
      this.addNodeById("8495840634674645198");
      this.addNodeById("8495840634674645205");
      MoveStaticFieldRefactoring refactoring = new MoveStaticFieldRefactoring(SNodeOperations.cast(this.getNodeById("8495840634674645167"), "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), SNodeOperations.cast(this.getNodeById("8495840634674645189"), "jetbrains.mps.baseLanguage.structure.ClassConcept"));
      refactoring.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("8495840634674645160"), "jetbrains.mps.baseLanguage.structure.ClassConcept"), SNodeOperations.cast(this.getNodeById("8495840634674645189"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("8495840634674645199"), "jetbrains.mps.baseLanguage.structure.ClassConcept"), SNodeOperations.cast(this.getNodeById("8495840634674645206"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
