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
public class StaticMethod_Test extends BaseTransformationTest {
  @Test
  public void test_StaticMethod() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.StaticMethod_Test$TestBody", "test_StaticMethod", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_StaticMethod() throws Exception {
      this.addNodeById("1230053223884");
      this.addNodeById("1230053223910");
      InlineMethodRefactoring ref = new InlineMethodRefactoring(SNodeOperations.cast(this.getNodeById("1230053223905"), "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall"));
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053223885"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053223911"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
