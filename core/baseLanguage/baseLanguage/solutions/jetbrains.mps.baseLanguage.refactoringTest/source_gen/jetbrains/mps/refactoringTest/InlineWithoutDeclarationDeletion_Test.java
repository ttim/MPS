package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.InlineVariableRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;

@MPSLaunch
public class InlineWithoutDeclarationDeletion_Test extends BaseTransformationTest {
  @Test
  public void test_inlineWithoutDeclarationDeletion() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.InlineWithoutDeclarationDeletion_Test$TestBody", "test_inlineWithoutDeclarationDeletion", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_inlineWithoutDeclarationDeletion() throws Exception {
      this.addNodeById("1230053266583");
      this.addNodeById("1230053266604");
      InlineVariableRefactoring ref = InlineVariableRefactoring.createRefactoring(SNodeOperations.cast(this.getNodeById("1230053266591"), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"));
      ref.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053266584"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053266605"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
