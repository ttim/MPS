package jetbrains.mps.project.structure.stub;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.modules.StubSolution;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.project.structure.model.ModelRootManager;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingPriorityRule;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_AbstractRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllGlobal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllLocal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefSet;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_ExternalRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_SimpleRef;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public abstract class ProjectStructureBuilder {
  private final ModuleDescriptor mySource;
  private final IFile myFile;
  private SModel myModel;
  private SNode myTarget;

  public ProjectStructureBuilder(ModuleDescriptor descriptor, IFile file, SModel model) {
    mySource = descriptor;
    myFile = file;
    myModel = model;
  }

  public SNode convert() {
    if (mySource instanceof LanguageDescriptor) {
      myTarget = convertLanguage((LanguageDescriptor) mySource);
    } else if (mySource instanceof SolutionDescriptor) {
      myTarget = convertSolution((SolutionDescriptor) mySource);
    } else if (mySource instanceof DevkitDescriptor) {
      myTarget = convertDevkit((DevkitDescriptor) mySource);
    }
    return myTarget;
  }

  private SNode convertLanguage(LanguageDescriptor source) {
    SNode result = SConceptOperations.createNewNode("jetbrains.mps.lang.project.structure.Language", null);
    result.setId(SNodeId.fromString("~root"));
    SModelOperations.addRootNode(myModel, result);
    fill(result, source);
    SPropertyOperations.set(result, "doNotGenerateAdapters", "" + source.isDoNotGenerateAdapters());
    SPropertyOperations.set(result, "genPath", source.getGenPath());
    SPropertyOperations.set(result, "languagePath", myFile.getPath());
    for (SModelReference ref : source.getAccessoryModels()) {
      SLinkOperations.getTargets(result, "accessoryModels", true).add(convert(ref));
    }
    for (GeneratorDescriptor descriptor : source.getGenerators()) {
      SLinkOperations.getTargets(result, "generator", true).add(convert(descriptor));
    }
    for (ModuleReference ref : source.getExtendedLanguages()) {
      SLinkOperations.getTargets(result, "extendedLanguages", true).add(convert(ref));
    }
    for (ModuleReference dep : source.getRuntimeModules()) {
      SLinkOperations.getTargets(result, "runtimeModules", true).add(convert(dep));
    }
    for (ModelRoot entry : source.getRuntimeStubModels()) {
      SLinkOperations.getTargets(result, "runtimeStubModels", true).add(convert(entry));
    }
    for (StubSolution sol : source.getStubSolutions()) {
      SLinkOperations.getTargets(result, "stubSolutions", true).add(convert(sol));
    }
    collectModels(result, source);
    return result;
  }

  private SNode convertSolution(SolutionDescriptor source) {
    SNode result = SConceptOperations.createNewNode("jetbrains.mps.lang.project.structure.Solution", null);
    result.setId(SNodeId.fromString("~root"));
    SModelOperations.addRootNode(myModel, result);
    fill(result, source);
    SPropertyOperations.set(result, "outputPath", source.getOutputPath());
    SPropertyOperations.set(result, "solutionPath", myFile.getPath());
    collectModels(result, source);
    return result;
  }

  private SNode convertDevkit(DevkitDescriptor source) {
    SNode result = SConceptOperations.createNewNode("jetbrains.mps.lang.project.structure.DevKit", null);
    result.setId(SNodeId.fromString("~root"));
    SModelOperations.addRootNode(myModel, result);
    fill(result, source);
    SPropertyOperations.set(result, "devkitPath", myFile.getPath());
    for (ModuleReference ref : source.getExtendedDevkits()) {
      SLinkOperations.getTargets(result, "extendedDevkits", true).add(convert(ref));
    }
    for (ModuleReference ref : source.getExportedLanguages()) {
      SLinkOperations.getTargets(result, "exportedLanguages", true).add(convert(ref));
    }
    for (ModuleReference ref : source.getExportedSolutions()) {
      SLinkOperations.getTargets(result, "exportedSolutions", true).add(convert(ref));
    }
    return result;
  }

  private SNode convert(StubSolution source) {
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.StubSolution", null);
    SPropertyOperations.set(result, "name", source.getName());
    SPropertyOperations.set(result, "uuid", source.getId().toString());
    return result;
  }

  private SNode convert(SModelReference source) {
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.ModelReference", null);
    SPropertyOperations.set(result, "uuid", source.getSModelId().toString());
    SPropertyOperations.set(result, "qualifiedName", source.getSModelFqName().getLongName());
    SPropertyOperations.set(result, "stereotype", source.getSModelFqName().getStereotype());
    return result;
  }

  private void fill(SNode module, ModuleDescriptor source) {
    SPropertyOperations.set(module, "uuid", source.getUUID());
    SPropertyOperations.set(module, "namespace", source.getNamespace());
    SPropertyOperations.set(module, "compileInMPS", "" + source.getCompileInMPS());

    for (ModelRoot root : source.getModelRoots()) {
      SLinkOperations.getTargets(module, "modelRoots", true).add(convert(root));
    }
    for (Dependency mdep : source.getDependencies()) {
      SLinkOperations.getTargets(module, "dependencies", true).add(convert(mdep));
    }
    for (ModuleReference ref : source.getUsedDevkits()) {
      SLinkOperations.getTargets(module, "usedDevkits", true).add(convert(ref));
    }
    for (ModuleReference ref : source.getUsedLanguages()) {
      SLinkOperations.getTargets(module, "usedLanguages", true).add(convert(ref));
    }
    for (ModelRoot entry : source.getStubModelEntries()) {
      SLinkOperations.getTargets(module, "stubModels", true).add(convert(entry));
    }
    for (String s : source.getSourcePaths()) {
      SLinkOperations.getTargets(module, "sourcePaths", true).add(convertSourcePath(s));
    }
  }

  private SNode convert(ModelRoot source) {
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.ModelRoot", null);
    SPropertyOperations.set(result, "path", source.getPath());
    SPropertyOperations.set(result, "prefix", source.getPrefix());
    SLinkOperations.setTarget(result, "manager", convert(source.getManager()), true);
    return result;
  }

  private SNode convert(ModelRootManager source) {
    if (source == null) {
      return null;
    }
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.ModelRootManager", null);
    SPropertyOperations.set(result, "moduleId", source.getModuleId());
    SPropertyOperations.set(result, "className", source.getClassName());
    return result;
  }

  private SNode convertSourcePath(String s) {
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.SourcePath", null);
    SPropertyOperations.set(result, "value", s);
    return result;
  }

  private SNode convert(Dependency source) {
    SNode dep = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.ModuleDependency", null);
    SPropertyOperations.set(dep, "reexport", "" + source.isReexport());
    SLinkOperations.setTarget(dep, "moduleRef", convert(source.getModuleRef()), true);
    return dep;
  }

  private SNode convert(GeneratorDescriptor source) {
    SNode generator = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.Generator", null);
    fill(generator, source);
    SPropertyOperations.set(generator, "generatorUID", source.getGeneratorUID());
    SPropertyOperations.set(generator, "generateTemplates", "" + source.isGenerateTemplates());
    SPropertyOperations.set(generator, "namespace", (StringUtils.isNotEmpty(source.getNamespace()) ?
      source.getNamespace() :
      null
    ));
    for (MappingPriorityRule rule : source.getPriorityRules()) {
      SLinkOperations.getTargets(generator, "priorityRules", true).add(convert(rule));
    }
    for (ModuleReference ref : source.getDepGenerators()) {
      SLinkOperations.getTargets(generator, "depGenerators", true).add(convert(ref));
    }
    collectModels(generator, source);
    return generator;
  }

  private SNode convert(MappingPriorityRule source) {
    SNode rule = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingPriorityRule", null);
    switch (source.getType()) {
      case BEFORE_OR_TOGETHER:
        SPropertyOperations.set(rule, "type", "before_or_together");
        break;
      case STRICTLY_BEFORE:
        SPropertyOperations.set(rule, "type", "strictly_before");
        break;
      case STRICTLY_AFTER:
        SPropertyOperations.set(rule, "type", "strictly_after");
        break;
      case AFTER_OR_TOGETHER:
        SPropertyOperations.set(rule, "type", "after_or_together");
        break;
      default:
        SPropertyOperations.set(rule, "type", "strictly_together");
    }
    SLinkOperations.setTarget(rule, "left", convert(source.getLeft()), true);
    SLinkOperations.setTarget(rule, "right", convert(source.getRight()), true);
    return rule;
  }

  private SNode convert(ModuleReference ref) {
    SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.ModuleReference", null);
    SPropertyOperations.set(result, "uuid", ref.getModuleId().toString());
    SPropertyOperations.set(result, "qualifiedName", ref.getModuleFqName());
    return result;
  }

  private SNode convert(MappingConfig_AbstractRef source) {
    if (source instanceof MappingConfig_RefAllGlobal) {
      return SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingConfigRefAllGlobal", null);
    } else if (source instanceof MappingConfig_RefAllLocal) {
      return SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingConfigRefAllLocal", null);
    } else if (source instanceof MappingConfig_RefSet) {
      SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingConfigRefSet", null);
      for (MappingConfig_AbstractRef ref : ((MappingConfig_RefSet) source).getMappingConfigs()) {
        SLinkOperations.getTargets(result, "refs", true).add(convert(ref));
      }
      return result;
    } else if (source instanceof MappingConfig_ExternalRef) {
      SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingConfigExternalRef", null);
      SLinkOperations.setTarget(result, "generator", convert(((MappingConfig_ExternalRef) source).getGenerator()), true);
      SLinkOperations.setTarget(result, "innerRef", convert(((MappingConfig_ExternalRef) source).getMappingConfig()), true);
      return result;
    } else if (source instanceof MappingConfig_SimpleRef) {
      SNode result = SModelOperations.createNewNode(myModel, "jetbrains.mps.lang.project.structure.MappingConfigNormalRef", null);
      SPropertyOperations.set(result, "modelUID", ((MappingConfig_SimpleRef) source).getModelUID());
      SPropertyOperations.set(result, "nodeID", ((MappingConfig_SimpleRef) source).getNodeID());
      return result;
    }
    return null;
  }

  protected void collectModels(SNode module, ModuleDescriptor descriptor) {
    for (SModelReference ref : Sequence.fromIterable(loadReferences(module, descriptor))) {
      ListSequence.fromList(SLinkOperations.getTargets(module, "model", true)).addElement(convert(ref));
    }
  }

  public abstract Iterable<SModelReference> loadReferences(SNode module, ModuleDescriptor descriptor);
}
