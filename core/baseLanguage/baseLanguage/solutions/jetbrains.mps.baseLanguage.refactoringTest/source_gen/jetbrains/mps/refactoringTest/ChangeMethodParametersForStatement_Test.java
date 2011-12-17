package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoringParameters;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodFactory;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MethodParameter;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoring;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

@MPSLaunch
public class ChangeMethodParametersForStatement_Test extends BaseTransformationTest {
  @Test
  public void test_changeMethodParametersForStatement() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ChangeMethodParametersForStatement_Test$TestBody", "test_changeMethodParametersForStatement", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_changeMethodParametersForStatement() throws Exception {
      this.addNodeById("1230052406554");
      this.addNodeById("1230052406581");
      {
        SNode c_ref = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
        SLinkOperations.setTarget(c_ref, "variableDeclaration", SNodeOperations.cast(this.getNodeById("1230052406612"), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), false);
        ExtractMethodRefactoringParameters params = ExtractMethodFactory.createParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406572"), "jetbrains.mps.baseLanguage.structure.ReturnStatement")));
        ListSequence.fromList(params.getParameters()).getElement(0).setSelected(false);
        MethodParameter p2 = ListSequence.fromList(params.getParameters()).getElement(1);
        MethodParameter p1 = ListSequence.fromList(params.getParameters()).getElement(2);
        ListSequence.fromList(params.getParameters()).setElement(1, p1);
        ListSequence.fromList(params.getParameters()).setElement(2, p2);
        p1.setName("p1");
        p2.setName("p2");
        params.setName("foo");
        ExtractMethodRefactoring ref = ExtractMethodFactory.createRefactoring(params);
        ref.doRefactor();
        Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406555"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052406582"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
      }
    }
  }
}
