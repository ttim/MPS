package jetbrains.mps.lang.scopes.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.scopes.structure.ComeFromExpression", "jetbrains.mps.lang.scopes.structure.CompositeWithParentScopeExpression", "jetbrains.mps.lang.scopes.structure.ParentScope"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 1:
        return new CompositeWithParentScopeExpression_BehaviorDescriptor();
      case 2:
        return new ParentScope_BehaviorDescriptor();
      case 0:
        return new ComeFromExpression_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
