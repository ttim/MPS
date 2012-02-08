package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.pluginSolution.plugin.InlineMethodRefactoringAnalyzer;
import jetbrains.mps.baseLanguage.pluginSolution.plugin.InlineMethodDialogModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

@MPSLaunch
public class CheckInlineWithThrow_Test extends BaseTransformationTest {
  @Test
  public void test_CheckInlineWithThrow() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.CheckInlineWithThrow_Test$TestBody", "test_CheckInlineWithThrow", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_CheckInlineWithThrow() throws Exception {
      this.addNodeById("1230053187489");
      Assert.assertNull(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187517"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)));
    }
  }
}
