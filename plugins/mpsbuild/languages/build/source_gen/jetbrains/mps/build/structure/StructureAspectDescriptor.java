package jetbrains.mps.build.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.impl.CompiledConceptDescriptor;
import jetbrains.mps.smodel.runtime.interpreted.StructureAspectInterpreted;

public class StructureAspectDescriptor implements jetbrains.mps.smodel.runtime.StructureAspectDescriptor {
  private static String[] stringSwitchCases_1htk8d_a0a0a = new String[]{"jetbrains.mps.build.structure.BuildAspect", "jetbrains.mps.build.structure.BuildCompositePath", "jetbrains.mps.build.structure.BuildCustomWorkflow", "jetbrains.mps.build.structure.BuildDependency", "jetbrains.mps.build.structure.BuildExternalDependency", "jetbrains.mps.build.structure.BuildExternalLayout", "jetbrains.mps.build.structure.BuildExternalLayoutDependency", "jetbrains.mps.build.structure.BuildFileExcludeSelector", "jetbrains.mps.build.structure.BuildFileIncludeSelector", "jetbrains.mps.build.structure.BuildFileIncludesSelector", "jetbrains.mps.build.structure.BuildFileSelector", "jetbrains.mps.build.structure.BuildFileSelectorInAttribute", "jetbrains.mps.build.structure.BuildFolderMacro", "jetbrains.mps.build.structure.BuildInputFileSet", "jetbrains.mps.build.structure.BuildInputFiles", "jetbrains.mps.build.structure.BuildInputFolderSet", "jetbrains.mps.build.structure.BuildInputFolders", "jetbrains.mps.build.structure.BuildInputResourceSet", "jetbrains.mps.build.structure.BuildInputSingleFile", "jetbrains.mps.build.structure.BuildInputSingleFolder", "jetbrains.mps.build.structure.BuildJavaPlugin", "jetbrains.mps.build.structure.BuildLayout", "jetbrains.mps.build.structure.BuildLayout_AbstractContainer", "jetbrains.mps.build.structure.BuildLayout_CompileOutputOf", "jetbrains.mps.build.structure.BuildLayout_Container", "jetbrains.mps.build.structure.BuildLayout_ContainerAcceptingFileSet", "jetbrains.mps.build.structure.BuildLayout_Copy", "jetbrains.mps.build.structure.BuildLayout_ExportAsJavaLibrary", "jetbrains.mps.build.structure.BuildLayout_FileSet", "jetbrains.mps.build.structure.BuildLayout_FileStub", "jetbrains.mps.build.structure.BuildLayout_Folder", "jetbrains.mps.build.structure.BuildLayout_Import", "jetbrains.mps.build.structure.BuildLayout_ImportContent", "jetbrains.mps.build.structure.BuildLayout_Jar", "jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildLayout_PathElement", "jetbrains.mps.build.structure.BuildLayout_PureNode", "jetbrains.mps.build.structure.BuildLayout_TransparentContainer", "jetbrains.mps.build.structure.BuildLayout_Zip", "jetbrains.mps.build.structure.BuildMacro", "jetbrains.mps.build.structure.BuildNamedLayout", "jetbrains.mps.build.structure.BuildPlugin", "jetbrains.mps.build.structure.BuildProject", "jetbrains.mps.build.structure.BuildProjectDependency", "jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.build.structure.BuildRelativePath", "jetbrains.mps.build.structure.BuildSourceMacroRelativePath", "jetbrains.mps.build.structure.BuildSourcePath", "jetbrains.mps.build.structure.BuildSourceProjectRelativePath", "jetbrains.mps.build.structure.BuildSourceSetContainer", "jetbrains.mps.build.structure.BuildSource_CompilablePart", "jetbrains.mps.build.structure.BuildSource_JavaCP", "jetbrains.mps.build.structure.BuildSource_JavaClassFolder", "jetbrains.mps.build.structure.BuildSource_JavaContentFolder", "jetbrains.mps.build.structure.BuildSource_JavaContentRoot", "jetbrains.mps.build.structure.BuildSource_JavaDependency", "jetbrains.mps.build.structure.BuildSource_JavaDependencyExternalJar", "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar", "jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary", "jetbrains.mps.build.structure.BuildSource_JavaDependencyModule", "jetbrains.mps.build.structure.BuildSource_JavaExternalJarRef", "jetbrains.mps.build.structure.BuildSource_JavaFiles", "jetbrains.mps.build.structure.BuildSource_JavaJar", "jetbrains.mps.build.structure.BuildSource_JavaJars", "jetbrains.mps.build.structure.BuildSource_JavaLibrary", "jetbrains.mps.build.structure.BuildSource_JavaLibraryCP", "jetbrains.mps.build.structure.BuildSource_JavaLibraryElement", "jetbrains.mps.build.structure.BuildSource_JavaModule", "jetbrains.mps.build.structure.BuildSource_JavaSources", "jetbrains.mps.build.structure.BuildSource_SingleFile", "jetbrains.mps.build.structure.BuildString", "jetbrains.mps.build.structure.BuildStringNotEmpty", "jetbrains.mps.build.structure.BuildStringPart", "jetbrains.mps.build.structure.BuildTextStringPart", "jetbrains.mps.build.structure.BuildVarRefStringPart", "jetbrains.mps.build.structure.BuildVariableMacro"};

  public StructureAspectDescriptor() {
  }

  public ConceptDescriptor getDescriptor(String conceptFqName) {
    switch (Arrays.binarySearch(stringSwitchCases_1htk8d_a0a0a, conceptFqName)) {
      case 0:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildAspect", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 1:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildCompositePath", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"head"}, new String[]{});
      case 2:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildCustomWorkflow", "jetbrains.mps.build.structure.BuildAspect", false, new String[]{"jetbrains.mps.build.structure.BuildAspect"}, new String[]{}, new String[]{});
      case 3:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 4:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildExternalDependency", null, true, new String[]{}, new String[]{}, new String[]{});
      case 5:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildExternalLayout", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.build.structure.BuildLayout_Container"}, new String[]{}, new String[]{});
      case 6:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildExternalLayoutDependency", "jetbrains.mps.build.structure.BuildDependency", false, new String[]{"jetbrains.mps.build.structure.BuildDependency", "jetbrains.mps.build.structure.BuildLayout_PathElement"}, new String[]{}, new String[]{"layout"});
      case 7:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFileExcludeSelector", "jetbrains.mps.build.structure.BuildFileSelector", false, new String[]{"jetbrains.mps.build.structure.BuildFileSelector"}, new String[]{"pattern"}, new String[]{});
      case 8:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFileIncludeSelector", "jetbrains.mps.build.structure.BuildFileSelector", false, new String[]{"jetbrains.mps.build.structure.BuildFileSelector"}, new String[]{"pattern"}, new String[]{});
      case 9:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFileIncludesSelector", "jetbrains.mps.build.structure.BuildFileSelector", false, new String[]{"jetbrains.mps.build.structure.BuildFileSelector", "jetbrains.mps.build.structure.BuildFileSelectorInAttribute"}, new String[]{"pattern"}, new String[]{});
      case 10:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFileSelector", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 11:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFileSelectorInAttribute", null, true, new String[]{}, new String[]{}, new String[]{});
      case 12:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildFolderMacro", "jetbrains.mps.build.structure.BuildMacro", false, new String[]{"jetbrains.mps.build.structure.BuildMacro"}, new String[]{}, new String[]{});
      case 13:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputFileSet", "jetbrains.mps.build.structure.BuildInputResourceSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputResourceSet"}, new String[]{}, new String[]{});
      case 14:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputFiles", "jetbrains.mps.build.structure.BuildInputFileSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputFileSet", "jetbrains.mps.build.structure.BuildLayout_FileSet"}, new String[]{}, new String[]{});
      case 15:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputFolderSet", "jetbrains.mps.build.structure.BuildInputResourceSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputResourceSet"}, new String[]{}, new String[]{});
      case 16:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputFolders", "jetbrains.mps.build.structure.BuildInputFolderSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputFolderSet"}, new String[]{}, new String[]{});
      case 17:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputResourceSet", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 18:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputSingleFile", "jetbrains.mps.build.structure.BuildInputFileSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputFileSet", "jetbrains.mps.build.structure.BuildLayout_FileSet", "jetbrains.mps.build.structure.BuildSource_SingleFile"}, new String[]{}, new String[]{});
      case 19:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildInputSingleFolder", "jetbrains.mps.build.structure.BuildInputFolderSet", false, new String[]{"jetbrains.mps.build.structure.BuildInputFolderSet"}, new String[]{}, new String[]{});
      case 20:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildJavaPlugin", "jetbrains.mps.build.structure.BuildPlugin", false, new String[]{"jetbrains.mps.build.structure.BuildPlugin"}, new String[]{}, new String[]{});
      case 21:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout", "jetbrains.mps.build.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_AbstractContainer"}, new String[]{}, new String[]{});
      case 22:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_AbstractContainer", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildLayout_Container"}, new String[]{}, new String[]{});
      case 23:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_CompileOutputOf", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildLayout_FileSet"}, new String[]{}, new String[]{"module"});
      case 24:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Container", null, true, new String[]{}, new String[]{}, new String[]{});
      case 25:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_ContainerAcceptingFileSet", null, true, new String[]{}, new String[]{}, new String[]{});
      case 26:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Copy", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildLayout_FileSet"}, new String[]{}, new String[]{});
      case 27:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_ExportAsJavaLibrary", "jetbrains.mps.build.structure.BuildLayout_TransparentContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_TransparentContainer"}, new String[]{}, new String[]{"library"});
      case 28:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_FileSet", null, true, new String[]{}, new String[]{}, new String[]{});
      case 29:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_FileStub", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildLayout_PureNode", "jetbrains.mps.build.structure.BuildSource_SingleFile"}, new String[]{}, new String[]{});
      case 30:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Folder", "jetbrains.mps.build.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildLayout_PureNode"}, new String[]{}, new String[]{});
      case 31:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Import", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildExternalDependency", "jetbrains.mps.build.structure.BuildLayout_FileSet"}, new String[]{}, new String[]{"target"});
      case 32:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_ImportContent", "jetbrains.mps.build.structure.BuildLayout_Node", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.build.structure.BuildExternalDependency", "jetbrains.mps.build.structure.BuildLayout_FileSet"}, new String[]{}, new String[]{"target"});
      case 33:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Jar", "jetbrains.mps.build.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildLayout_ContainerAcceptingFileSet", "jetbrains.mps.build.structure.BuildLayout_PureNode", "jetbrains.mps.build.structure.BuildSource_SingleFile"}, new String[]{}, new String[]{});
      case 34:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_AbstractContainer", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 35:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Node", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.build.structure.BuildLayout_PathElement"}, new String[]{}, new String[]{});
      case 36:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_PathElement", null, true, new String[]{}, new String[]{}, new String[]{});
      case 37:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_PureNode", null, true, new String[]{}, new String[]{}, new String[]{});
      case 38:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_TransparentContainer", "jetbrains.mps.build.structure.BuildLayout_AbstractContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_AbstractContainer"}, new String[]{}, new String[]{});
      case 39:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildLayout_Zip", "jetbrains.mps.build.structure.BuildLayout_NamedContainer", false, new String[]{"jetbrains.mps.build.structure.BuildLayout_NamedContainer", "jetbrains.mps.build.structure.BuildLayout_ContainerAcceptingFileSet", "jetbrains.mps.build.structure.BuildLayout_PureNode"}, new String[]{}, new String[]{});
      case 40:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildMacro", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 41:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildNamedLayout", "jetbrains.mps.build.structure.BuildAspect", false, new String[]{"jetbrains.mps.build.structure.BuildAspect", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.build.structure.BuildLayout_Container", "jetbrains.mps.build.structure.BuildLayout_PathElement"}, new String[]{}, new String[]{});
      case 42:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildPlugin", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 43:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildProject", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.ScopeProvider", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{"internalBaseDirectory"}, new String[]{});
      case 44:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildProjectDependency", "jetbrains.mps.build.structure.BuildDependency", false, new String[]{"jetbrains.mps.build.structure.BuildDependency", "jetbrains.mps.build.structure.BuildLayout_PathElement"}, new String[]{}, new String[]{"script"});
      case 45:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 46:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildRelativePath", "jetbrains.mps.build.structure.BuildSourcePath", false, new String[]{"jetbrains.mps.build.structure.BuildSourcePath"}, new String[]{}, new String[]{});
      case 47:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSourceMacroRelativePath", "jetbrains.mps.build.structure.BuildRelativePath", false, new String[]{"jetbrains.mps.build.structure.BuildRelativePath"}, new String[]{}, new String[]{"macro"});
      case 48:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSourcePath", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 49:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSourceProjectRelativePath", "jetbrains.mps.build.structure.BuildRelativePath", false, new String[]{"jetbrains.mps.build.structure.BuildRelativePath"}, new String[]{}, new String[]{});
      case 50:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSourceSetContainer", null, true, new String[]{}, new String[]{}, new String[]{});
      case 51:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_CompilablePart", null, true, new String[]{"jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 52:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaCP", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 53:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaClassFolder", "jetbrains.mps.build.structure.BuildSource_JavaCP", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaCP"}, new String[]{}, new String[]{});
      case 54:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaContentFolder", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{"kind", "relativePath"}, new String[]{});
      case 55:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaContentRoot", "jetbrains.mps.build.structure.BuildSource_JavaSources", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaSources"}, new String[]{}, new String[]{});
      case 56:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaDependency", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 57:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaDependencyExternalJar", "jetbrains.mps.build.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaDependency", "jetbrains.mps.build.structure.BuildExternalDependency"}, new String[]{"reexport"}, new String[]{});
      case 58:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaDependencyJar", "jetbrains.mps.build.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaDependency"}, new String[]{"reexport"}, new String[]{});
      case 59:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary", "jetbrains.mps.build.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaDependency", "jetbrains.mps.build.structure.BuildExternalDependency"}, new String[]{"reexport"}, new String[]{"library"});
      case 60:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaDependencyModule", "jetbrains.mps.build.structure.BuildSource_JavaDependency", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaDependency", "jetbrains.mps.build.structure.BuildExternalDependency"}, new String[]{"reexport"}, new String[]{"module"});
      case 61:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaExternalJarRef", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{"jar"});
      case 62:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaFiles", "jetbrains.mps.build.structure.BuildSource_JavaSources", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaSources"}, new String[]{}, new String[]{});
      case 63:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaJar", "jetbrains.mps.build.structure.BuildSource_JavaCP", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaCP"}, new String[]{}, new String[]{});
      case 64:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaJars", "jetbrains.mps.build.structure.BuildSource_JavaCP", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaCP", "jetbrains.mps.build.structure.BuildSourceSetContainer"}, new String[]{}, new String[]{});
      case 65:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaLibrary", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 66:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaLibraryCP", "jetbrains.mps.build.structure.BuildSource_JavaLibraryElement", false, new String[]{"jetbrains.mps.build.structure.BuildSource_JavaLibraryElement"}, new String[]{}, new String[]{});
      case 67:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaLibraryElement", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 68:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaModule", "jetbrains.mps.build.structure.BuildProjectPart", false, new String[]{"jetbrains.mps.build.structure.BuildProjectPart", "jetbrains.mps.lang.core.structure.INamedConcept", "jetbrains.mps.build.structure.BuildSource_CompilablePart"}, new String[]{}, new String[]{});
      case 69:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_JavaSources", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 70:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildSource_SingleFile", null, true, new String[]{}, new String[]{}, new String[]{});
      case 71:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildString", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept"}, new String[]{}, new String[]{});
      case 72:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildStringNotEmpty", "jetbrains.mps.build.structure.BuildString", false, new String[]{"jetbrains.mps.build.structure.BuildString"}, new String[]{}, new String[]{});
      case 73:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildStringPart", "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{"jetbrains.mps.lang.core.structure.BaseConcept", "jetbrains.mps.lang.core.structure.INamedConcept"}, new String[]{}, new String[]{});
      case 74:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildTextStringPart", "jetbrains.mps.build.structure.BuildStringPart", false, new String[]{"jetbrains.mps.build.structure.BuildStringPart"}, new String[]{"text"}, new String[]{});
      case 75:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildVarRefStringPart", "jetbrains.mps.build.structure.BuildStringPart", false, new String[]{"jetbrains.mps.build.structure.BuildStringPart"}, new String[]{}, new String[]{"macro"});
      case 76:
        return new CompiledConceptDescriptor("jetbrains.mps.build.structure.BuildVariableMacro", "jetbrains.mps.build.structure.BuildMacro", false, new String[]{"jetbrains.mps.build.structure.BuildMacro"}, new String[]{}, new String[]{});
      default:
        return StructureAspectInterpreted.getInstance().getDescriptor(conceptFqName);
    }
  }
}
