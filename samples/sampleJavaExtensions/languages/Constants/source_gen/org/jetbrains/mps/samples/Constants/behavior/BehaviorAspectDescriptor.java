package org.jetbrains.mps.samples.Constants.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"org.jetbrains.mps.samples.Constants.structure.Constant", "org.jetbrains.mps.samples.Constants.structure.ConstantReference", "org.jetbrains.mps.samples.Constants.structure.Constants"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 2:
        return new Constants_BehaviorDescriptor();
      case 0:
        return new Constant_BehaviorDescriptor();
      case 1:
        return new ConstantReference_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
