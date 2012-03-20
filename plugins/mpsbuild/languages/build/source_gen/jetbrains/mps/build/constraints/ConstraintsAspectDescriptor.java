package jetbrains.mps.build.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;

public class ConstraintsAspectDescriptor implements jetbrains.mps.smodel.runtime.ConstraintsAspectDescriptor {
  private static String[] stringSwitchCases_2qnle6_a0a0a = new String[]{"jetbrains.mps.build.structure.BuildAspect", "jetbrains.mps.build.structure.BuildLayout", "jetbrains.mps.build.structure.BuildLayout_Import", "jetbrains.mps.build.structure.BuildLayout_JavaOutput", "jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildSourceMacroRelativePath", "jetbrains.mps.build.structure.BuildSourcePath", "jetbrains.mps.build.structure.BuildSource_JavaLibrary", "jetbrains.mps.build.structure.BuildSource_JavaLibraryClassFiles", "jetbrains.mps.build.structure.BuildSource_JavaLibraryClasses", "jetbrains.mps.build.structure.BuildSource_JavaLibraryJar", "jetbrains.mps.build.structure.BuildSource_JavaModule", "jetbrains.mps.build.structure.BuildSource_JavaSources", "jetbrains.mps.build.structure.BuildStringPart", "jetbrains.mps.build.structure.BuildTextStringPart", "jetbrains.mps.build.structure.BuildVarRefStringPart", "jetbrains.mps.build.structure.BuildVariableMacro"};

  public ConstraintsAspectDescriptor() {
  }

  public ConstraintsDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_2qnle6_a0a0a, fqName)) {
      case 5:
        return new BuildSourceMacroRelativePath_Constraints();
      case 1:
        return new BuildLayout_Constraints();
      case 0:
        return new BuildAspect_Constraints();
      case 3:
        return new BuildLayout_JavaOutput_Constraints();
      case 11:
        return new BuildSource_JavaModule_Constraints();
      case 7:
        return new BuildSource_JavaLibrary_Constraints();
      case 14:
        return new BuildTextStringPart_Constraints();
      case 12:
        return new BuildSource_JavaSources_Constraints();
      case 15:
        return new BuildVarRefStringPart_Constraints();
      case 4:
        return new BuildLayout_NamedContainer_Constraints();
      case 16:
        return new BuildVariableMacro_Constraints();
      case 13:
        return new BuildStringPart_Constraints();
      case 9:
        return new BuildSource_JavaLibraryClasses_Constraints();
      case 10:
        return new BuildSource_JavaLibraryJar_Constraints();
      case 6:
        return new BuildSourcePath_Constraints();
      case 8:
        return new BuildSource_JavaLibraryClassFiles_Constraints();
      case 2:
        return new BuildLayout_Import_Constraints();
      default:
        // todo: illegal in some cases? 
        return new BaseConstraintsDescriptor(fqName);
    }
  }
}
