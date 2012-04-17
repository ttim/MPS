package org.jetbrains.mps.samples.ParallelFor.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;

public class ConstraintsAspectDescriptor implements jetbrains.mps.smodel.runtime.ConstraintsAspectDescriptor {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"org.jetbrains.mps.samples.ParallelFor.structure.ParallelLoopVariable", "org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 0:
        return new ParallelLoopVariable_Constraints();
      case 1:
        return new ThreadPool_Constraints();
      default:
        // todo: illegal in some cases? 
        return new BaseConstraintsDescriptor(fqName);
    }
  }
}
