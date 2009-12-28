package jetbrains.mps.baseLanguage.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.lang.test.runtime.SubtreeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

@MPSLaunch
public class DataFlowInClosure_Test extends BaseTransformationTest {
  @Test
  public void test_DataFlowInClosure() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.DataFlowInClosure_Test$TestBody", "test_DataFlowInClosure", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_DataFlowInClosure() throws Exception {
      this.addNodeById("1217271586413");
      SubtreeChecker.checkNodeForErrors(SNodeOperations.cast(this.getNodeById("1215444268405"), "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"));
    }
  }
}
