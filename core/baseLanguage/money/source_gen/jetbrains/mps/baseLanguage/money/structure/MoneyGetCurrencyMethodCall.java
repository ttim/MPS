package jetbrains.mps.baseLanguage.money.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MoneyGetCurrencyMethodCall extends MoneyMethodCall {
  public static final String concept = "jetbrains.mps.baseLanguage.money.structure.MoneyGetCurrencyMethodCall";

  public MoneyGetCurrencyMethodCall(SNode node) {
    super(node);
  }

  public static MoneyGetCurrencyMethodCall newInstance(SModel sm, boolean init) {
    return (MoneyGetCurrencyMethodCall)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.money.structure.MoneyGetCurrencyMethodCall", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MoneyGetCurrencyMethodCall newInstance(SModel sm) {
    return MoneyGetCurrencyMethodCall.newInstance(sm, false);
  }
}
