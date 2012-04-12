package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.build.structure.BuildCompositePath", "jetbrains.mps.build.structure.BuildCustomWorkflow", "jetbrains.mps.build.structure.BuildExternalLayout", "jetbrains.mps.build.structure.BuildExternalLayoutDependency", "jetbrains.mps.build.structure.BuildFileExcludeSelector", "jetbrains.mps.build.structure.BuildFileIncludeSelector", "jetbrains.mps.build.structure.BuildFileIncludesSelector", "jetbrains.mps.build.structure.BuildFolderMacro", "jetbrains.mps.build.structure.BuildInputFiles", "jetbrains.mps.build.structure.BuildInputFolders", "jetbrains.mps.build.structure.BuildInputSingleFile", "jetbrains.mps.build.structure.BuildInputSingleFolder", "jetbrains.mps.build.structure.BuildJavaPlugin", "jetbrains.mps.build.structure.BuildLayout", "jetbrains.mps.build.structure.BuildLayout_CompileOutputOf", "jetbrains.mps.build.structure.BuildLayout_Copy", "jetbrains.mps.build.structure.BuildLayout_ExportAsJavaLibrary", "jetbrains.mps.build.structure.BuildLayout_FileStub", "jetbrains.mps.build.structure.BuildLayout_Folder", "jetbrains.mps.build.structure.BuildLayout_Import", "jetbrains.mps.build.structure.BuildLayout_Jar", "jetbrains.mps.build.structure.BuildLayout_Zip", "jetbrains.mps.build.structure.BuildNamedLayout", "jetbrains.mps.build.structure.BuildProject", "jetbrains.mps.build.structure.BuildProjectDependency", "jetbrains.mps.build.structure.BuildSourceMacroRelativePath", "jetbrains.mps.build.structure.BuildSourceProjectRelativePath", "jetbrains.mps.build.structure.BuildSource_JavaClassFolder", "jetbrains.mps.build.structure.BuildSource_JavaContentFolder", "jetbrains.mps.build.structure.BuildSource_JavaContentRoot", "jetbrains.mps.build.structure.BuildSource_JavaDependencyImportedJar", "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar", "jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary", "jetbrains.mps.build.structure.BuildSource_JavaDependencyModule", "jetbrains.mps.build.structure.BuildSource_JavaFiles", "jetbrains.mps.build.structure.BuildSource_JavaJar", "jetbrains.mps.build.structure.BuildSource_JavaJars", "jetbrains.mps.build.structure.BuildSource_JavaLibrary", "jetbrains.mps.build.structure.BuildSource_JavaLibraryCP", "jetbrains.mps.build.structure.BuildSource_JavaModule", "jetbrains.mps.build.structure.BuildString", "jetbrains.mps.build.structure.BuildStringNotEmpty", "jetbrains.mps.build.structure.BuildTextStringPart", "jetbrains.mps.build.structure.BuildVarRefStringPart", "jetbrains.mps.build.structure.BuildVariableMacro"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 23:
        return new BuildProject_BehaviorDescriptor();
      case 13:
        return new BuildLayout_BehaviorDescriptor();
      case 18:
        return new BuildLayout_Folder_BehaviorDescriptor();
      case 21:
        return new BuildLayout_Zip_BehaviorDescriptor();
      case 20:
        return new BuildLayout_Jar_BehaviorDescriptor();
      case 39:
        return new BuildSource_JavaModule_BehaviorDescriptor();
      case 29:
        return new BuildSource_JavaContentRoot_BehaviorDescriptor();
      case 7:
        return new BuildFolderMacro_BehaviorDescriptor();
      case 25:
        return new BuildSourceMacroRelativePath_BehaviorDescriptor();
      case 28:
        return new BuildSource_JavaContentFolder_BehaviorDescriptor();
      case 33:
        return new BuildSource_JavaDependencyModule_BehaviorDescriptor();
      case 37:
        return new BuildSource_JavaLibrary_BehaviorDescriptor();
      case 32:
        return new BuildSource_JavaDependencyLibrary_BehaviorDescriptor();
      case 24:
        return new BuildProjectDependency_BehaviorDescriptor();
      case 22:
        return new BuildNamedLayout_BehaviorDescriptor();
      case 26:
        return new BuildSourceProjectRelativePath_BehaviorDescriptor();
      case 0:
        return new BuildCompositePath_BehaviorDescriptor();
      case 12:
        return new BuildJavaPlugin_BehaviorDescriptor();
      case 44:
        return new BuildVariableMacro_BehaviorDescriptor();
      case 5:
        return new BuildFileIncludeSelector_BehaviorDescriptor();
      case 8:
        return new BuildInputFiles_BehaviorDescriptor();
      case 43:
        return new BuildVarRefStringPart_BehaviorDescriptor();
      case 42:
        return new BuildTextStringPart_BehaviorDescriptor();
      case 15:
        return new BuildLayout_Copy_BehaviorDescriptor();
      case 10:
        return new BuildInputSingleFile_BehaviorDescriptor();
      case 4:
        return new BuildFileExcludeSelector_BehaviorDescriptor();
      case 40:
        return new BuildString_BehaviorDescriptor();
      case 35:
        return new BuildSource_JavaJar_BehaviorDescriptor();
      case 27:
        return new BuildSource_JavaClassFolder_BehaviorDescriptor();
      case 19:
        return new BuildLayout_Import_BehaviorDescriptor();
      case 41:
        return new BuildStringNotEmpty_BehaviorDescriptor();
      case 1:
        return new BuildCustomWorkflow_BehaviorDescriptor();
      case 16:
        return new BuildLayout_ExportAsJavaLibrary_BehaviorDescriptor();
      case 34:
        return new BuildSource_JavaFiles_BehaviorDescriptor();
      case 31:
        return new BuildSource_JavaDependencyJar_BehaviorDescriptor();
      case 38:
        return new BuildSource_JavaLibraryCP_BehaviorDescriptor();
      case 36:
        return new BuildSource_JavaJars_BehaviorDescriptor();
      case 9:
        return new BuildInputFolders_BehaviorDescriptor();
      case 11:
        return new BuildInputSingleFolder_BehaviorDescriptor();
      case 6:
        return new BuildFileIncludesSelector_BehaviorDescriptor();
      case 14:
        return new BuildLayout_CompileOutputOf_BehaviorDescriptor();
      case 30:
        return new BuildSource_JavaDependencyImportedJar_BehaviorDescriptor();
      case 2:
        return new BuildExternalLayout_BehaviorDescriptor();
      case 17:
        return new BuildLayout_FileStub_BehaviorDescriptor();
      case 3:
        return new BuildExternalLayoutDependency_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
