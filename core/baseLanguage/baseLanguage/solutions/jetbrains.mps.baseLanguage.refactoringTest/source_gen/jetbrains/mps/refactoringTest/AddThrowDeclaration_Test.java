package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.plugin.ChangeMethodSignatureParameters;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.plugin.ChangeMethodSignatureRefactoring;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;

public class AddThrowDeclaration_Test extends BaseTransformationTest {

  @Test()
  public void test_AddThrowDeclaration() throws Throwable {
    this.initTest("${mps_home}/core/languageDesign/plugin/plugin.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest(this.getClass().getCanonicalName() + "$TestBody", "test_AddThrowDeclaration", true);
  }

  public static class TestBody extends BaseTestBody {

    public void test_AddThrowDeclaration() throws Exception {
      this.addNodeById("1230052902926");
      this.addNodeById("1230052902935");
      ChangeMethodSignatureParameters params = new ChangeMethodSignatureParameters(SNodeOperations.cast(this.getNodeById("1230052902928"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      SLinkOperations.addChild(params.getDeclaration(), "throwsItem", new _Quotations.QuotationClass_0().createNode());
      ChangeMethodSignatureRefactoring ref = new ChangeMethodSignatureRefactoring(params, SNodeOperations.cast(this.getNodeById("1230052902928"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      ref.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052902927"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052902936"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }

}

}
