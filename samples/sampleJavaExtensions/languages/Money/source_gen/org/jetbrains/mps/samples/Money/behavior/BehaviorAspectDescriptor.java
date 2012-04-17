package org.jetbrains.mps.samples.Money.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"org.jetbrains.mps.samples.Money.structure.ConvertTo", "org.jetbrains.mps.samples.Money.structure.CurrencyDefTable", "org.jetbrains.mps.samples.Money.structure.CurrencyUnit", "org.jetbrains.mps.samples.Money.structure.GetAmount", "org.jetbrains.mps.samples.Money.structure.GetCurrency", "org.jetbrains.mps.samples.Money.structure.MoneyConversionType", "org.jetbrains.mps.samples.Money.structure.MoneyLiteral", "org.jetbrains.mps.samples.Money.structure.MoneyType"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 6:
        return new MoneyLiteral_BehaviorDescriptor();
      case 7:
        return new MoneyType_BehaviorDescriptor();
      case 3:
        return new GetAmount_BehaviorDescriptor();
      case 4:
        return new GetCurrency_BehaviorDescriptor();
      case 0:
        return new ConvertTo_BehaviorDescriptor();
      case 5:
        return new MoneyConversionType_BehaviorDescriptor();
      case 1:
        return new CurrencyDefTable_BehaviorDescriptor();
      case 2:
        return new CurrencyUnit_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
