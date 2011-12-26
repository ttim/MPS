package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.InlineMethodRefactoringAnalyzer;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.InlineMethodDialogModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

@MPSLaunch
public class InlineWithNoSourcesAttached_Test extends BaseTransformationTest {
  @Test
  public void test_InlineWithNoSourcesAttached() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.InlineWithNoSourcesAttached_Test$TestBody", "test_InlineWithNoSourcesAttached", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_InlineWithNoSourcesAttached() throws Exception {
      this.addNodeById("1230052989307");
      Assert.assertTrue(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230052989317"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)) != null);
    }
  }
}
