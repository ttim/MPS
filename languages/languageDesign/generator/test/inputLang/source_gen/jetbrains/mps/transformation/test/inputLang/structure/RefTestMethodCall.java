package jetbrains.mps.transformation.test.inputLang.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RefTestMethodCall extends RefTestExpression {
  public static final String concept = "jetbrains.mps.transformation.test.inputLang.structure.RefTestMethodCall";
  public static final String METHOD = "method";

  public RefTestMethodCall(SNode node) {
    super(node);
  }

  public RefTestMethod getMethod() {
    return (RefTestMethod) this.getReferent(RefTestMethod.class, RefTestMethodCall.METHOD);
  }

  public void setMethod(RefTestMethod node) {
    super.setReferent(RefTestMethodCall.METHOD, node);
  }

  public static RefTestMethodCall newInstance(SModel sm, boolean init) {
    return (RefTestMethodCall) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.transformation.test.inputLang.structure.RefTestMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RefTestMethodCall newInstance(SModel sm) {
    return RefTestMethodCall.newInstance(sm, false);
  }
}
