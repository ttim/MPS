package org.jetbrains.mps.samples.Money.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;

public class ConstraintsAspectDescriptor implements jetbrains.mps.smodel.runtime.ConstraintsAspectDescriptor {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"org.jetbrains.mps.samples.Money.structure.ConvertTo", "org.jetbrains.mps.samples.Money.structure.GetAmount", "org.jetbrains.mps.samples.Money.structure.GetCurrency", "org.jetbrains.mps.samples.Money.structure.MoneyLiteral"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 1:
        return new GetAmount_Constraints();
      case 2:
        return new GetCurrency_Constraints();
      case 0:
        return new ConvertTo_Constraints();
      case 3:
        return new MoneyLiteral_Constraints();
      default:
        // todo: illegal in some cases? 
        return new BaseConstraintsDescriptor(fqName);
    }
  }
}
