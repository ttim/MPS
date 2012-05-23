package jetbrains.mps.build.mps.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.build.mps.structure.BuildMPSPlugin", "jetbrains.mps.build.mps.structure.BuildMpsLayout_FolderWithSources", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleJars", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleSources", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleXml", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleXml_CustomJarLocation", "jetbrains.mps.build.mps.structure.BuildMpsLayout_Plugin", "jetbrains.mps.build.mps.structure.BuildMpsLayout_PluginDescriptor", "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule", "jetbrains.mps.build.mps.structure.BuildMps_Branding", "jetbrains.mps.build.mps.structure.BuildMps_BrandingHelp", "jetbrains.mps.build.mps.structure.BuildMps_BrandingUpdateSite", "jetbrains.mps.build.mps.structure.BuildMps_DevKit", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExport", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution", "jetbrains.mps.build.mps.structure.BuildMps_DevKitRef", "jetbrains.mps.build.mps.structure.BuildMps_ExtractedModuleDependency", "jetbrains.mps.build.mps.structure.BuildMps_Group", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPlugin", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginDependency", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroup", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginModule", "jetbrains.mps.build.mps.structure.BuildMps_Language", "jetbrains.mps.build.mps.structure.BuildMps_Module", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource", "jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot", "jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleSource", "jetbrains.mps.build.mps.structure.BuildMps_Solution"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMPSPlugin", "jetbrains.mps.build.structure.BuildPlugin", false, new String[]{"jetbrains.mps.build.structure.BuildPlugin"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_FolderWithSources", "jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleSources", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleSources"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleJars", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node"}, new String[]{}, new String[]{"module"});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleSources", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node"}, new String[]{"modelsOnly"}, new String[]{"module"});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleXml", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node"}, new String[]{}, new String[]{"module"});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_ModuleXml_CustomJarLocation", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"packagedLocation"}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_Plugin", "jetbrains.mps.build.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_AbstractContainer", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.build.structure.BuildSource_SingleFolder"}, new String[]{}, new String[]{"plugin"});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMpsLayout_PluginDescriptor", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node"}, new String[]{}, new String[]{"plugin"});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_AbstractModule", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{"uuid", "compact"}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_Branding", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.build.structure.BuildSource_FilesetProjectPart"}, new String[]{"major", "minor", "eap"}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_BrandingHelp", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_BrandingUpdateSite", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_DevKit", "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_AbstractModule"}, new String[]{}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_DevKitExport", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExport", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_DevKitExport"}, new String[]{}, new String[]{"language"});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution", "jetbrains.mps.build.mps.structure.BuildMps_DevKitExport", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_DevKitExport"}, new String[]{}, new String[]{"solution"});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_DevKitRef", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"devkit"});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ExtractedModuleDependency", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_Group", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_IdeaPlugin", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.lang.core.structure.ScopeProvider", "jetbrains.mps.build.structure.BuildStringContainer"}, new String[]{"id"}, new String[]{});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 21:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"target"});
      case 22:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginGroup", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent"}, new String[]{}, new String[]{"group"});
      case 23:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginModule", "jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_IdeaPluginContent"}, new String[]{}, new String[]{"target"});
      case 24:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_Language", "jetbrains.mps.build.mps.structure.BuildMps_Module", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_Module"}, new String[]{}, new String[]{});
      case 25:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_Module", "jetbrains.mps.build.mps.structure.BuildMps_AbstractModule", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_AbstractModule", "jetbrains.mps.build.structure.BuildSource_CompilablePart", "jetbrains.mps.build.structure.BuildExternalDependency"}, new String[]{"doNotCompile"}, new String[]{});
      case 26:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 27:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{}, new String[]{"language"});
      case 28:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{}, new String[]{});
      case 29:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{}, new String[]{"devkit"});
      case 30:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnJavaModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{"reexport"}, new String[]{"module"});
      case 31:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{"reexport"}, new String[]{"module"});
      case 32:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage", "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleDependency"}, new String[]{}, new String[]{"language"});
      case 33:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime"}, new String[]{}, new String[]{});
      case 34:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource", "jetbrains.mps.build.mps.structure.BuildMps_ModuleSource", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleSource"}, new String[]{}, new String[]{});
      case 35:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot", "jetbrains.mps.build.mps.structure.BuildMps_ModuleSource", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleSource"}, new String[]{}, new String[]{});
      case 36:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 37:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime", "jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_ModuleRuntime"}, new String[]{}, new String[]{"solution"});
      case 38:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_ModuleSource", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 39:
        return new CompiledConceptDescriptor("jetbrains.mps.build.mps.structure.BuildMps_Solution", "jetbrains.mps.build.mps.structure.BuildMps_Module", false, new String[]{"jetbrains.mps.build.mps.structure.BuildMps_Module"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
