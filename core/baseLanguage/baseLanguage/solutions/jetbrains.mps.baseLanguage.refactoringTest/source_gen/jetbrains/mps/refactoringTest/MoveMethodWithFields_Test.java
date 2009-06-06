package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.plugin.MoveMethodRefactoring;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

public class MoveMethodWithFields_Test extends BaseTransformationTest {

  @Test()
  public void test_MoveMethodWithFields() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/plugin/plugin.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_MoveMethodWithFields", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_MoveMethodWithFields() throws Exception {
      this.addNodeById("1230053302525");
      this.addNodeById("1230053302541");
      this.addNodeById("1230053302545");
      this.addNodeById("1230053302552");
      MoveMethodRefactoring ref = new MoveMethodRefactoring(SNodeOperations.cast(this.getNodeById("1230053302530"), "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"), SNodeOperations.cast(this.getNodeById("1230053302542"), "jetbrains.mps.baseLanguage.structure.ClassConcept"));
      ref.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053302526"), "jetbrains.mps.baseLanguage.structure.ClassConcept"), SNodeOperations.cast(this.getNodeById("1230053302542"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230053302546"), "jetbrains.mps.baseLanguage.structure.ClassConcept"), SNodeOperations.cast(this.getNodeById("1230053302553"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }

}

}
