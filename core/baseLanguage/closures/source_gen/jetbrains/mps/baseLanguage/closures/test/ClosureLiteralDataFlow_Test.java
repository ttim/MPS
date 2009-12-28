package jetbrains.mps.baseLanguage.closures.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.lang.test.runtime.SubtreeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

@MPSLaunch
public class ClosureLiteralDataFlow_Test extends BaseTransformationTest {
  @Test
  public void test_ClosureLiteralDataFlow() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/closures/closures.mpr", "r:3d6db45f-d7e0-45ba-9835-ff824ffe21a1(jetbrains.mps.baseLanguage.closures.test)");
    this.runTest("jetbrains.mps.baseLanguage.closures.test.ClosureLiteralDataFlow_Test$TestBody", "test_ClosureLiteralDataFlow", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_ClosureLiteralDataFlow() throws Exception {
      this.addNodeById("1227886714784");
      SubtreeChecker.checkNodeForErrors(SNodeOperations.cast(this.getNodeById("1227886714787"), "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"));
    }
  }
}
