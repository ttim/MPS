package jetbrains.mps.baseLanguage.test;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.lang.test.runtime.TypeSystemCheckUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

@MPSLaunch
public class TestGenerationMode_Test extends BaseTransformationTest4 {
  @Test
  public void test_GenerationMode() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.TestGenerationMode_Test$TestBody", "test_GenerationMode", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_GenerationMode() throws Exception {
      this.addNodeById("7187651930235347759");
      TypeSystemCheckUtil.checkGenerationMode(SNodeOperations.cast(this.getNodeById("7187651930235347762"), "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"));
    }
  }
}
