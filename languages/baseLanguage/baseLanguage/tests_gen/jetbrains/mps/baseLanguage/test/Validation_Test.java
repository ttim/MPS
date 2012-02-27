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
public class Validation_Test extends BaseTransformationTest {
  @Test
  public void test_TypesCheck7868761255934329326() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.Validation_Test$TestBody", "test_TypesCheck7868761255934329326", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_TypesCheck7868761255934329326() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("7868761255934329326"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, operation, "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("7868761255934329296"));
    }
  }
}
