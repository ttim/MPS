package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
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
public class ConvertAnonymousWithTypeParameters_Test extends BaseTransformationTest {
  @Test
  public void test_TypeParametersTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ConvertAnonymousWithTypeParameters_Test$TestBody", "test_TypeParametersTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_TypeParametersTest() throws Exception {
      this.addNodeById("9160497614872088317");
      this.addNodeById("9160497614872003746");
      new ConvertAnonymousRefactoring(SNodeOperations.cast(this.getNodeById("9160497614872088338"), "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "MyIterable").doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("9160497614872088318"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("9160497614872087740"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
