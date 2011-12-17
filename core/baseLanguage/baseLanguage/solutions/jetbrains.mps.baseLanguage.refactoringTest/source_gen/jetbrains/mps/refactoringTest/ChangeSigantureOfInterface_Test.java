package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ChangeMethodSignatureParameters;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ChangeMethodSignatureRefactoring;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

@MPSLaunch
public class ChangeSigantureOfInterface_Test extends BaseTransformationTest {
  @Test
  public void test_ChangeSigantureOfInterface() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.ChangeSigantureOfInterface_Test$TestBody", "test_ChangeSigantureOfInterface", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_ChangeSigantureOfInterface() throws Exception {
      this.addNodeById("418758558327012739");
      this.addNodeById("418758558327019466");
      this.addNodeById("418758558327028811");
      ChangeMethodSignatureParameters parameters = new ChangeMethodSignatureParameters(SNodeOperations.cast(this.getNodeById("418758558327019496"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      SPropertyOperations.set(parameters.getDeclaration(), "name", "myMethod");
      ChangeMethodSignatureRefactoring ref = new ChangeMethodSignatureRefactoring(parameters, SNodeOperations.cast(this.getNodeById("418758558327028802"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      ref.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("418758558327028812"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("418758558327019475"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }
  }
}
