package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodFabric;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class OneReturnStatement_Test extends BaseTransformationTest {

  @Test()
  public void test_oneReturnStatement() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_oneReturnStatement", true);
  }

  @Test()
  public void test_returnAndOutVariable() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_returnAndOutVariable", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_oneReturnStatement() throws Exception {
      this.addNodeById("1230052642175");
      Assert.assertNull(ExtractMethodFabric.getErrors(ListSequence.<SNode>fromArray(SNodeOperations.cast(this.getNodeById("1230052642181"), "jetbrains.mps.baseLanguage.structure.IfStatement"))));
    }

    public void test_returnAndOutVariable() throws Exception {
      this.addNodeById("1230052642175");
      Assert.assertTrue(ExtractMethodFabric.getErrors(ListSequence.<SNode>fromArray(SNodeOperations.cast(this.getNodeById("1230052642191"), "jetbrains.mps.baseLanguage.structure.ExpressionStatement"), SNodeOperations.cast(this.getNodeById("1230052642198"), "jetbrains.mps.baseLanguage.structure.IfStatement"))) != null);
    }

}

}
