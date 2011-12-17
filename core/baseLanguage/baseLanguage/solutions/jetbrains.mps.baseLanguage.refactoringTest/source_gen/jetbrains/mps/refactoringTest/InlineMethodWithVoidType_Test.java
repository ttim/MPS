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
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

@MPSLaunch
public class InlineMethodWithVoidType_Test extends BaseTransformationTest {
  @Test
  public void test_InlineMethodWithVoidType() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.InlineMethodWithVoidType_Test$TestBody", "test_InlineMethodWithVoidType", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_InlineMethodWithVoidType() throws Exception {
      this.addNodeById("1230053187753");
      this.addNodeById("1230053187788");
      InlineMethodRefactoring ref = new InlineMethodRefactoring(SNodeOperations.cast(this.getNodeById("1230053187766"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"));
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053187754"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053187789"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
