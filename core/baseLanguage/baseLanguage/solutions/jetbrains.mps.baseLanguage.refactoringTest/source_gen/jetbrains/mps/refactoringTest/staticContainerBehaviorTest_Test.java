package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoringParameters;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodRefactoring;
import jetbrains.mps.baseLanguage.plugin.ExtractMethodFabric;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;

public class staticContainerBehaviorTest_Test extends BaseTransformationTest {

  @Test()
  public void test_staticContainerBehaviorTest() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/mps-lite/mps-lite.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_staticContainerBehaviorTest", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_staticContainerBehaviorTest() throws Exception {
      this.addNodeById("1230052684554");
      this.addNodeById("1230052684570");
      this.addNodeById("1230052684583");
      this.addNodeById("1230052684588");
      SNode call = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", null);
      SLinkOperations.setTarget(call, "baseMethodDeclaration", SNodeOperations.cast(this.getNodeById("1230052684590"), "jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration"), false);
      SNode var = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
      SLinkOperations.setTarget(var, "variableDeclaration", SNodeOperations.cast(this.getNodeById("1230052684575"), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), false);
      SLinkOperations.addChild(call, "actualArgument", var);
      SLinkOperations.setTarget(call, "concept", SLinkOperations.getTarget(SNodeOperations.cast(this.getNodeById("1230052684589"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "concept", false), false);
      SNodeOperations.replaceWithAnother(SNodeOperations.cast(this.getNodeById("1230052684580"), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), call);
      ExtractMethodRefactoringParameters params = new ExtractMethodRefactoringParameters(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052684562"), "jetbrains.mps.baseLanguage.structure.ExpressionStatement")));
      params.setName("foo");
      ExtractMethodRefactoring ref = ExtractMethodFabric.createRefactoring(params);
      ref.setStaticContainer(SNodeOperations.cast(this.getNodeById("1230052684584"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"));
      ref.doRefactor();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052684555"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), SNodeOperations.cast(this.getNodeById("1230052684584"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052684571"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), SNodeOperations.cast(this.getNodeById("1230052684589"), "jetbrains.mps.lang.behavior.structure.ConceptBehavior"))));
    }

}

}
