package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoringParameters;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoring;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodFabric;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

public class MethodsWithoutReturnStatement_Test extends BaseTransformationTest {

  @Test()
  public void test_checkReturnWithoutReturn() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_checkReturnWithoutReturn", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_checkReturnWithoutReturn() throws Exception {
      this.addNodeById("1230052642101");
      this.addNodeById("1230052642118");
      ExtractMethodRefactoringParameters params = new ExtractMethodRefactoringParameters(ListSequence.<SNode>fromArray(SNodeOperations.cast(this.getNodeById("1230052642110"), "jetbrains.mps.baseLanguage.structure.ExpressionStatement")));
      params.setName("foo");
      ExtractMethodRefactoring ref = ExtractMethodFabric.createRefactoring(params);
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromArray(SNodeOperations.cast(this.getNodeById("1230052642102"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromArray(SNodeOperations.cast(this.getNodeById("1230052642119"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }

}

}
