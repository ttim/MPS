package jetbrains.mps.lang.core.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.lang.core.structure.ExportScopeModule", "jetbrains.mps.lang.core.structure.ExportScopeNamespace", "jetbrains.mps.lang.core.structure.ExportScopePublic", "jetbrains.mps.lang.core.structure.LinkAttribute", "jetbrains.mps.lang.core.structure.NodeAttribute", "jetbrains.mps.lang.core.structure.PropertyAttribute", "jetbrains.mps.lang.core.structure.SuppressErrorsAnnotation"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 2:
        return new ExportScopePublic_BehaviorDescriptor();
      case 1:
        return new ExportScopeNamespace_BehaviorDescriptor();
      case 0:
        return new ExportScopeModule_BehaviorDescriptor();
      case 3:
        return new LinkAttribute_BehaviorDescriptor();
      case 4:
        return new NodeAttribute_BehaviorDescriptor();
      case 5:
        return new PropertyAttribute_BehaviorDescriptor();
      case 6:
        return new SuppressErrorsAnnotation_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
