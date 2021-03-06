package jetbrains.mps.baseLanguage.unitTest.execution.client;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class JUnit3MethodWrapper extends AbstractTestWrapper<SNode> {
  public JUnit3MethodWrapper(SNode method) {
    super(method);
  }

  public boolean isTestCase() {
    return false;
  }

  @Nullable
  @Override
  public ITestNodeWrapper getTestCase() {
    SNode clazz = check_pj3jcm_a0a0b(getNode(), this);
    if ((clazz != null)) {
      return new JUnit3TestWrapper(clazz);
    }
    return null;
  }

  public static boolean isTestMethod(@NotNull SNode method) {
    return !(((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, method, "virtual_isAbstract_1232982539764", new Class[]{SNode.class}))) && (SLinkOperations.getTarget(method, "visibility", true) != null) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PublicVisibility") && (SPropertyOperations.getString(method, "name") != null) && SPropertyOperations.getString(method, "name").startsWith("test");
  }

  private static SNode check_pj3jcm_a0a0b(SNode checkedDotOperand, JUnit3MethodWrapper checkedDotThisExpression) {
    if (null != checkedDotOperand) {
      return SNodeOperations.getAncestor(checkedDotOperand, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    }
    return null;
  }
}
