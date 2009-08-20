package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoringParameters;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoring;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodFabric;
import junit.framework.Assert;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodWithExitPoints;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

public class ExtractBreak_Test extends BaseTransformationTest {
  @Test
  public void test_ExtractBreak() throws Throwable {
    this.initTest("${mps_home}/core/baseLanguage/baseLanguage/baseLanguage.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_ExtractBreak", true);
  }

  public static class TestBody extends BaseTestBody {
    public void test_ExtractBreak() throws Exception {
      this.addNodeById("1230052480333");
      this.addNodeById("1230052480361");
      ExtractMethodRefactoringParameters params = new ExtractMethodRefactoringParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480342"), "jetbrains.mps.baseLanguage.structure.IfStatement")));
      params.setName("foo");
      ExtractMethodRefactoring ref = ExtractMethodFabric.createRefactoring(params);
      Assert.assertTrue(ref instanceof ExtractMethodWithExitPoints);
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480334"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052480362"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
