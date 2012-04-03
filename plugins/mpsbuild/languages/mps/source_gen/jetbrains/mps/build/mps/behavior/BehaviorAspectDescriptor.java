package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  private static String[] stringSwitchCases_846f5o_a0a0a = new String[]{"jetbrains.mps.build.mps.structure.BuildMPSPlugin", "jetbrains.mps.build.mps.structure.BuildMpsLayout_FolderWithSources", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleJars", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleOutput", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleSources", "jetbrains.mps.build.mps.structure.BuildMps_DevKit", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution", "jetbrains.mps.build.mps.structure.BuildMps_DevKitRef", "jetbrains.mps.build.mps.structure.BuildMps_ExtractedModuleDependency", "jetbrains.mps.build.mps.structure.BuildMps_Group", "jetbrains.mps.build.mps.structure.BuildMps_Language", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource", "jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot", "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime", "jetbrains.mps.build.mps.structure.BuildMps_Solution"};

  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0a, fqName)) {
      case 16:
        return new BuildMps_ModuleDependencyOnModule_BehaviorDescriptor();
      case 19:
        return new BuildMps_ModuleJavaSource_BehaviorDescriptor();
      case 22:
        return new BuildMps_Solution_BehaviorDescriptor();
      case 11:
        return new BuildMps_Language_BehaviorDescriptor();
      case 17:
        return new BuildMps_ModuleDependencyUseLanguage_BehaviorDescriptor();
      case 15:
        return new BuildMps_ModuleDependencyOnJavaModule_BehaviorDescriptor();
      case 21:
        return new BuildMps_ModuleSolutionRuntime_BehaviorDescriptor();
      case 12:
        return new BuildMps_ModuleDependencyExtendLanguage_BehaviorDescriptor();
      case 18:
        return new BuildMps_ModuleJarRuntime_BehaviorDescriptor();
      case 20:
        return new BuildMps_ModuleModelRoot_BehaviorDescriptor();
      case 13:
        return new BuildMps_ModuleDependencyJar_BehaviorDescriptor();
      case 5:
        return new BuildMps_DevKit_BehaviorDescriptor();
      case 8:
        return new BuildMps_DevKitRef_BehaviorDescriptor();
      case 6:
        return new BuildMps_DevKitExportLanguage_BehaviorDescriptor();
      case 7:
        return new BuildMps_DevKitExportSolution_BehaviorDescriptor();
      case 14:
        return new BuildMps_ModuleDependencyOnDevKit_BehaviorDescriptor();
      case 10:
        return new BuildMps_Group_BehaviorDescriptor();
      case 4:
        return new BuildMpsLayout_ModuleSources_BehaviorDescriptor();
      case 9:
        return new BuildMps_ExtractedModuleDependency_BehaviorDescriptor();
      case 3:
        return new BuildMpsLayout_ModuleOutput_BehaviorDescriptor();
      case 1:
        return new BuildMpsLayout_FolderWithSources_BehaviorDescriptor();
      case 2:
        return new BuildMpsLayout_ModuleJars_BehaviorDescriptor();
      case 0:
        return new BuildMPSPlugin_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }
}
