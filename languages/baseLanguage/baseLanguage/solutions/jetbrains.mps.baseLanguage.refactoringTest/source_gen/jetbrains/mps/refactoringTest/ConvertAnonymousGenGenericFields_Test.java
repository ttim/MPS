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
public class ConvertAnonymousGenGenericFields_Test extends BaseTransformationTest4 {
  @Test
  public void test_TypeParametersTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ConvertAnonymousGenGenericFields_Test$TestBody", "test_TypeParametersTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_TypeParametersTest() throws Exception {
      this.addNodeById("5907083257159818799");
      this.addNodeById("5907083257159818958");
      new ConvertAnonymousRefactoring(SNodeOperations.cast(this.getNodeById("5907083257159818820"), "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "MyIterable").doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("5907083257159818800"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("5907083257159818959"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
