package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.InlineMethodRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;

@MPSLaunch
public class SimpleInlineWithOneReturn_Test extends BaseTransformationTest {
  @Test
  public void test_SimpleInlineWithOneReturn() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.SimpleInlineWithOneReturn_Test$TestBody", "test_SimpleInlineWithOneReturn", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_SimpleInlineWithOneReturn() throws Exception {
      this.addNodeById("1230052989335");
      this.addNodeById("1230052989358");
      InlineMethodRefactoring ref = new InlineMethodRefactoring(SNodeOperations.cast(this.getNodeById("1230052989347"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"));
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052989336"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052989359"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
