package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ConvertAnonymousRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

@MPSLaunch
public class ConvertAnonymousAbstractClassWithConstructorTest_Test extends BaseTransformationTest4 {
  @Test
  public void test_AbstractClassWithConstructorTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ConvertAnonymousAbstractClassWithConstructorTest_Test$TestBody", "test_AbstractClassWithConstructorTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_AbstractClassWithConstructorTest() throws Exception {
      this.addNodeById("3145818413497245832");
      this.addNodeById("3145818413497245858");
      this.addNodeById("3145818413497257580");
      new ConvertAnonymousRefactoring(SNodeOperations.cast(this.getNodeById("3145818413497246005"), "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "MyAConst").doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("3145818413497245980"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("3145818413497698452"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
