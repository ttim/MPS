package jetbrains.mps.refactoringTest;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest4;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ChangeMethodSignatureParameters;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ChangeMethodSignatureRefactoring;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

@MPSLaunch
public class AddParameter_Test extends BaseTransformationTest4 {
  @Test
  public void test_AddParameter() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:4dc6ffb5-4bbb-4773-b0b7-e52989ceb56f(jetbrains.mps.refactoringTest)");
    this.runTest("jetbrains.mps.refactoringTest.AddParameter_Test$TestBody", "test_AddParameter", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_AddParameter() throws Exception {
      this.addNodeById("1230052943764");
      this.addNodeById("1230052943773");
      ChangeMethodSignatureParameters params = new ChangeMethodSignatureParameters(SNodeOperations.cast(this.getNodeById("1230052943766"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      ListSequence.fromList(SLinkOperations.getTargets(params.getDeclaration(), "parameter", true)).addElement(new AddParameter_Test.TestBody.QuotationClass_pqwgtw_a0a0d0a0().createNode());
      ChangeMethodSignatureRefactoring ref = new ChangeMethodSignatureRefactoring(params, SNodeOperations.cast(this.getNodeById("1230052943766"), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
      ref.doRefactoring();
      Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052943765"), "jetbrains.mps.baseLanguage.structure.ClassConcept")), ListSequence.fromListAndArray(new ArrayList<SNode>(), SNodeOperations.cast(this.getNodeById("1230052943774"), "jetbrains.mps.baseLanguage.structure.ClassConcept"))));
    }

    public static class QuotationClass_pqwgtw_a0a0d0a0 {
      public QuotationClass_pqwgtw_a0a0d0a0() {
      }

      public SNode createNode() {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        SNode quotedNode_2 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ParameterDeclaration", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_3 = quotedNode_1;
          quotedNode1_3.setProperty("name", "a");
          {
            quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.CharType", null, GlobalScope.getInstance(), false);
            SNode quotedNode1_4 = quotedNode_2;
            quotedNode_1.addChild("type", quotedNode1_4);
          }
          result = quotedNode1_3;
        }
        return result;
      }
    }
  }
}
