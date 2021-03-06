package jetbrains.mps.buildlanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CallReference extends PropertyValueExpression {
  public static final String concept = "jetbrains.mps.buildlanguage.structure.CallReference";
  public static final String CPR_CallName = "callName";
  public static final String CALL = "call";

  public CallReference(SNode node) {
    super(node);
  }

  public AbstractCall getCall() {
    return (AbstractCall) this.getReferent(AbstractCall.class, CallReference.CALL);
  }

  public void setCall(AbstractCall node) {
    super.setReferent(CallReference.CALL, node);
  }

  public static CallReference newInstance(SModel sm, boolean init) {
    return (CallReference) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.CallReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CallReference newInstance(SModel sm) {
    return CallReference.newInstance(sm, false);
  }
}
