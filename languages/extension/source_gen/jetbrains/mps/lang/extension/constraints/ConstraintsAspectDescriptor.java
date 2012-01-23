package jetbrains.mps.lang.extension.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;

public class ConstraintsAspectDescriptor implements jetbrains.mps.smodel.runtime.ConstraintsAspectDescriptor {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"jetbrains.mps.lang.extension.structure.ExtensionDeclaration", "jetbrains.mps.lang.extension.structure.ExtensionPointDeclaration"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 1:
        return new ExtensionPointDeclaration_Constraints();
      case 0:
        return new ExtensionDeclaration_Constraints();
      default:
        // todo: illegal in some cases? 
        return new BaseConstraintsDescriptor(fqName);
    }
  }
}
