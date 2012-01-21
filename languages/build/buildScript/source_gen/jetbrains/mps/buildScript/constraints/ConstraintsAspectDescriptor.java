package jetbrains.mps.buildScript.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;

public class ConstraintsAspectDescriptor implements jetbrains.mps.smodel.runtime.ConstraintsAspectDescriptor {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"jetbrains.mps.buildScript.structure.BuildAspect", "jetbrains.mps.buildScript.structure.BuildLayout", "jetbrains.mps.buildScript.structure.BuildRelativePath", "jetbrains.mps.buildScript.structure.BuildSourceMacroRelativePath"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 3:
        return new BuildSourceMacroRelativePath_Constraints();
      case 1:
        return new BuildLayout_Constraints();
      case 0:
        return new BuildAspect_Constraints();
      case 2:
        return new BuildRelativePath_Constraints();
      default:
        // todo: illegal in some cases? 
        return new BaseConstraintsDescriptor(fqName);
    }
  }
}
