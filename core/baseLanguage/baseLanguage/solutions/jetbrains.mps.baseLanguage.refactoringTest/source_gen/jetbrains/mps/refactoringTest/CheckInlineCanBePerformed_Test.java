package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.plugin.InlineMethodRefactoringAnalyzer;
import jetbrains.mps.baseLanguage.plugin.InlineMethodDialogModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class CheckInlineCanBePerformed_Test extends BaseTransformationTest {

  @Test()
  public void test_CheckInlineCanBePerformed() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/plugin/plugin.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_CheckInlineCanBePerformed", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_CheckInlineCanBePerformed() throws Exception {
      this.addNodeById("1230053187318");
      Assert.assertNull(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187326"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)));
      Assert.assertTrue(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187332"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)) != null);
      Assert.assertNull(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187337"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)));
      Assert.assertNull(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187342"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)));
      Assert.assertTrue(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187347"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)) != null);
      Assert.assertNull(InlineMethodRefactoringAnalyzer.getErrors(new InlineMethodDialogModel(SNodeOperations.cast(this.getNodeById("1230053187351"), "jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"), null)));
    }

}

}
