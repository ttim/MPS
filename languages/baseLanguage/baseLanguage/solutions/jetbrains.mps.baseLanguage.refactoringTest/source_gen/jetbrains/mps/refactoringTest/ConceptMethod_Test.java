package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoringParameters;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodFactory;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoring;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

@MPSLaunch
public class ConceptMethod_Test extends BaseTransformationTest {
  @Test
  public void test_conceptMethod() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ConceptMethod_Test$TestBody", "test_conceptMethod", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_conceptMethod() throws Exception {
      this.addNodeById("1230052406798");
      this.addNodeById("1230052406829");
      SLinkOperations.setTarget(SNodeOperations.cast(this.getNodeById("4226967154353807230"), "jetbrains.mps.lang.behavior.structure.LocalBehaviorMethodCall"), "baseMethodDeclaration", SNodeOperations.cast(this.getNodeById("1230052406844"), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), false);
      ExtractMethodRefactoringParameters params = ExtractMethodFactory.createParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406805"), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"), SNodeOperations.cast(this.getNodeById("6195342755327921671"), "jetbrains.mps.baseLanguage.structure.ExpressionStatement")));
      params.setName("foo");
      ExtractMethodRefactoring ref = ExtractMethodFactory.createRefactoring(params);
      this.fff(ref);
      params = ExtractMethodFactory.createParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406818"), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement")));
      params.setName("bar");
      ref = ExtractMethodFactory.createRefactoring(params);
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406799"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406830"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"))));
    }

    public void fff(ExtractMethodRefactoring ref) {
      ref.doRefactor();
    }
  }
}
