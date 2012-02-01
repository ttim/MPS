package jetbrains.mps.buildScript.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.buildScript.structure.BuildArtifact", "jetbrains.mps.buildScript.structure.BuildAspect", "jetbrains.mps.buildScript.structure.BuildDependency", "jetbrains.mps.buildScript.structure.BuildFolderMacro", "jetbrains.mps.buildScript.structure.BuildLayout", "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer", "jetbrains.mps.buildScript.structure.BuildLayout_Folder", "jetbrains.mps.buildScript.structure.BuildLayout_InputDirContainer", "jetbrains.mps.buildScript.structure.BuildLayout_Jar", "jetbrains.mps.buildScript.structure.BuildLayout_JavaOutput", "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", "jetbrains.mps.buildScript.structure.BuildLayout_Node", "jetbrains.mps.buildScript.structure.BuildLayout_Zip", "jetbrains.mps.buildScript.structure.BuildMacro", "jetbrains.mps.buildScript.structure.BuildPath", "jetbrains.mps.buildScript.structure.BuildProject", "jetbrains.mps.buildScript.structure.BuildProjectDependency", "jetbrains.mps.buildScript.structure.BuildProjectPart", "jetbrains.mps.buildScript.structure.BuildRelativePath", "jetbrains.mps.buildScript.structure.BuildSourceMacroRelativePath", "jetbrains.mps.buildScript.structure.BuildSourcePath", "jetbrains.mps.buildScript.structure.BuildSourceProjectRelativePath", "jetbrains.mps.buildScript.structure.BuildSource_JavaContentFolder", "jetbrains.mps.buildScript.structure.BuildSource_JavaContentRoot", "jetbrains.mps.buildScript.structure.BuildSource_JavaDependency", "jetbrains.mps.buildScript.structure.BuildSource_JavaDependencyLibrary", "jetbrains.mps.buildScript.structure.BuildSource_JavaDependencyModule", "jetbrains.mps.buildScript.structure.BuildSource_JavaLibrary", "jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryElement", "jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryJar", "jetbrains.mps.buildScript.structure.BuildSource_JavaModule", "jetbrains.mps.buildScript.structure.CompositePath", "jetbrains.mps.buildScript.structure.Environment"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildArtifact", "jetbrains.mps.buildScript.structure.BuildAspect", false, new String[]{"jetbrains.mps.buildScript.structure.BuildAspect", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildAspect", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildFolderMacro", "jetbrains.mps.buildScript.structure.BuildMacro", false, new String[]{"jetbrains.mps.buildScript.structure.BuildMacro"}, new String[]{"defaultValue"}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout", "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer", "jetbrains.mps.buildScript.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_Node"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_Folder", "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", "jetbrains.mps.buildScript.structure.BuildLayout_InputDirContainer"}, new String[]{}, new String[]{});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_InputDirContainer", null, true, new String[]{}, new String[]{}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_Jar", "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer"}, new String[]{}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_JavaOutput", "jetbrains.mps.buildScript.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_Node"}, new String[]{}, new String[]{"module"});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_Node", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildLayout_Zip", "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer"}, new String[]{}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildMacro", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildPath", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildProject", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.ScopeProvider", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.buildScript.structure.Environment"}, new String[]{}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildProjectDependency", "jetbrains.mps.buildScript.structure.BuildDependency", false, new String[]{"jetbrains.mps.buildScript.structure.BuildDependency"}, new String[]{}, new String[]{"script"});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildRelativePath", "jetbrains.mps.buildScript.structure.BuildSourcePath", false, new String[]{"jetbrains.mps.buildScript.structure.BuildSourcePath"}, new String[]{"relativePath"}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSourceMacroRelativePath", "jetbrains.mps.buildScript.structure.BuildRelativePath", false, new String[]{"jetbrains.mps.buildScript.structure.BuildRelativePath"}, new String[]{}, new String[]{"macro"});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSourcePath", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 21:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSourceProjectRelativePath", "jetbrains.mps.buildScript.structure.BuildRelativePath", false, new String[]{"jetbrains.mps.buildScript.structure.BuildRelativePath"}, new String[]{}, new String[]{});
      case 22:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaContentFolder", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"relativePath"}, new String[]{});
      case 23:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaContentRoot", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 24:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 25:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaDependencyLibrary", "jetbrains.mps.buildScript.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.buildScript.structure.BuildSource_JavaDependency"}, new String[]{}, new String[]{"library"});
      case 26:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaDependencyModule", "jetbrains.mps.buildScript.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.buildScript.structure.BuildSource_JavaDependency"}, new String[]{}, new String[]{"module"});
      case 27:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaLibrary", "jetbrains.mps.buildScript.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.buildScript.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 28:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryElement", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 29:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryJar", "jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryElement", false, new String[]{"jetbrains.mps.buildScript.structure.BuildSource_JavaLibraryElement"}, new String[]{}, new String[]{});
      case 30:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.BuildSource_JavaModule", "jetbrains.mps.buildScript.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.buildScript.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 31:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.CompositePath", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"head"}, new String[]{});
      case 32:
        return new CompiledConceptDescriptor("jetbrains.mps.buildScript.structure.Environment", null, true, new String[]{}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
