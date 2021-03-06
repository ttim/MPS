package jetbrains.mps.makeTest.test;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import junit.framework.TestCase;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

@MPSLaunch
public class NotMake_Test extends TestCase {
  @MPSLaunch
  public void test_abstractMethodNotImplement() throws Exception {
    MakeAssert.assertNotMake("abstractMethodNotImplement", new ChangeModel() {
      @Override
      public void change(SModel model) {
        super.change(model);
        SPropertyOperations.set(ListSequence.fromList(SLinkOperations.getTargets(ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.Classifier")).first(), "method", true)).first(), "isAbstract", "" + true);
      }
    });
  }

  @MPSLaunch
  public void test_finalClass() throws Exception {
    MakeAssert.assertNotMake("finalClass", new ChangeModel() {
      @Override
      public void change(SModel model) {
        super.change(model);
        SPropertyOperations.set(ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept")).first(), "isFinal", "" + true);
      }
    });
  }

  @MPSLaunch
  public void test_recursiveInHierarchy() throws Exception {
    MakeAssert.assertNotMake("recursiveInHierarchy", new ChangeModel() {
      @Override
      public void change(SModel model) {
        super.change(model);
        for (SNode root : SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.Interface")) {
          SNode method = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", null);
          SNode voidType = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.VoidType", null);
          SPropertyOperations.set(method, "name", "abc");
          SLinkOperations.setTarget(method, "returnType", voidType, true);
          ListSequence.fromList(SLinkOperations.getTargets(root, "method", true)).addElement(method);
        }
      }
    });
  }

  @MPSLaunch
  public void test_anonymousClass() throws Exception {
    MakeAssert.assertNotMake("anonymousClass", new ChangeModel() {
      @Override
      public void change(SModel model) {
        super.change(model);
        SPropertyOperations.set(ListSequence.fromList(SLinkOperations.getTargets(ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.Classifier")).first(), "method", true)).first(), "isAbstract", "" + true);
      }
    });
  }
}
