package org.jetbrains.mps.samples.ParallelFor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass", "org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor", "org.jetbrains.mps.samples.ParallelFor.structure.ParallelLoopVariable", "org.jetbrains.mps.samples.ParallelFor.structure.ThreadPool", "org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 1:
        return new ParallelFor_BehaviorDescriptor();
      case 2:
        return new ParallelLoopVariable_BehaviorDescriptor();
      case 3:
        return new ThreadPool_BehaviorDescriptor();
      case 4:
        return new ThreadSafe_BehaviorDescriptor();
      case 0:
        return new NonThreadSafeClass_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
