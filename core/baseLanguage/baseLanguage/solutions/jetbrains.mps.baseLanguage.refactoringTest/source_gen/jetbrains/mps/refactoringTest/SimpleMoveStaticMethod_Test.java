package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MoveStaticMethodRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.findusages.model.SearchResult;

@MPSLaunch
public class SimpleMoveStaticMethod_Test extends BaseTransformationTest {
  @Test
  public void test_SimpleMoveStaticMethod() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.SimpleMoveStaticMethod_Test$TestBody", "test_SimpleMoveStaticMethod", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_SimpleMoveStaticMethod() throws Exception {
      this.addNodeById("3014415391767789120");
      this.addNodeById("3014415391767789149");
      this.addNodeById("3014415391767789154");
      this.addNodeById("3014415391767789181");
      MoveStaticMethodRefactoring refactoring = new MoveStaticMethodRefactoring(SNodeOperations.cast(this.getNodeById("3014415391767789137"), "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"), SNodeOperations.cast(this.getNodeById("3014415391767789150"), "jetbrains.mps.baseLanguage.structure.ClassConcept"));
      SearchResults<SNode> results = new SearchResults();
      results.getSearchResults().add(new SearchResult(SNodeOperations.cast(this.getNodeById("3014415391767789131"), "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall"), "usage"));
      refactoring.setUssages(results);
      refactoring.doRefactoring();
    }
  }
}
