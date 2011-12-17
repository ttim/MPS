package jetbrains.mps.baseLanguage.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

@MPSLaunch
public class UnusedVariableDeclaration_Test extends BaseTransformationTest {
  @Test
  public void test_UnusedVariableDeclaration() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.UnusedVariableDeclaration_Test$TestBody", "test_UnusedVariableDeclaration", true);
  }

  @Test
  public void test_TypesCheck1216889859700() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.UnusedVariableDeclaration_Test$TestBody", "test_TypesCheck1216889859700", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_UnusedVariableDeclaration() throws Exception {
      this.addNodeById("1217271587025");
    }

    public void test_TypesCheck1216889859700() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("1216889859700"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("1216889573147"));
    }
  }
}
