package jetbrains.mps.makeTest.test;

/*Generated by MPS */

import jetbrains.mps.MPSLaunch;
import junit.framework.TestCase;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

@MPSLaunch
public class CheckDependencies_Test extends TestCase {
  @MPSLaunch
  public void test_staticConst() throws Exception {
    MakeAssert.assertDependenciesChecked("staticConst", new ChangeModel() {
      @Override
      public void change(SModel model) {
        super.change(model);
        SPropertyOperations.set(SNodeOperations.cast(SLinkOperations.getTarget(ListSequence.fromList(SLinkOperations.getTargets(ListSequence.fromList(SModelOperations.getRoots(model, "jetbrains.mps.baseLanguage.structure.ClassConcept")).first(), "staticField", true)).first(), "initializer", true), "jetbrains.mps.baseLanguage.structure.IntegerConstant"), "value", "" + 0);
      }
    });
  }
}
