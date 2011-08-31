package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoringParameters;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodFactory;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoring;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MethodMatch;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

@MPSLaunch
public class SimpleFindForExtractFromStatement_Test extends BaseTransformationTest {
  @Test
  public void test_SimpleFindForExtractFromStatementTest() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.SimpleFindForExtractFromStatement_Test$TestBody", "test_SimpleFindForExtractFromStatementTest", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_SimpleFindForExtractFromStatementTest() throws Exception {
      this.addNodeById("8556882668095222065");
      this.addNodeById("8556882668095222149");
      ExtractMethodRefactoringParameters params = ExtractMethodFactory.createParameters(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("8556882668095222071"), "jetbrains.mps.baseLanguage.structure.ExpressionStatement")));
      params.setName("print");
      ExtractMethodRefactoring ref = ExtractMethodFactory.createRefactoring(params);
      SNode res = ref.doRefactor();
      for (MethodMatch match : ListSequence.<MethodMatch>fromList(ref.getMatches())) {
        ExtractMethodRefactoring matchRef = ExtractMethodFactory.createRefactoring(ExtractMethodFactory.createParameters(match.getNodes()));
        matchRef.replaceMatch(match, res);
      }
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("8556882668095222066"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.<SNode>fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("8556882668095222150"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
