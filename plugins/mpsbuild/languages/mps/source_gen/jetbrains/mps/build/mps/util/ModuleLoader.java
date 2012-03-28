package jetbrains.mps.build.mps.util;

/*Generated by MPS */

import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.build.util.DependenciesHelper;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.build.behavior.BuildSourcePath_Behavior;
import jetbrains.mps.build.util.Context;
import java.io.File;
import java.io.IOException;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.util.MacroHelper;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.project.persistence.LanguageDescriptorPersistence;
import jetbrains.mps.project.persistence.SolutionDescriptorPersistence;
import jetbrains.mps.project.persistence.DevkitDescriptorPersistence;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Map;
import java.util.HashMap;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.project.ProjectPathUtil;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.vfs.IFileUtils;

public class ModuleLoader {
  private final TemplateQueryContext genContext;
  private final SNode myModule;
  private SNode myOriginalModule;
  private ModuleDescriptor myModuleDescriptor;
  private IFile myModuleFile;
  private VisibleModules visible;
  private PathConverter pathConverter;

  public ModuleLoader(SNode module, VisibleModules visible, PathConverter pathConverter, TemplateQueryContext genContext) {
    this.genContext = genContext;
    this.myModule = module;
    this.myOriginalModule = SNodeOperations.as(DependenciesHelper.getOriginalNode(module, genContext), "jetbrains.mps.build.mps.structure.BuildMps_Module");
    if (this.myOriginalModule == null) {
      this.myOriginalModule = module;
    }
    this.visible = visible;
    this.pathConverter = pathConverter;
  }

  public void importRequired() {
    loadFile();
    if (myModuleDescriptor != null) {
      SPropertyOperations.set(myModule, "uuid", myModuleDescriptor.getModuleReference().getModuleId().toString());
      SPropertyOperations.set(myModule, "name", myModuleDescriptor.getModuleReference().getModuleFqName());

      if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module")) {
        SPropertyOperations.set(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module"), "doNotCompile", "" + (myModuleDescriptor instanceof SolutionDescriptor && !(((SolutionDescriptor) myModuleDescriptor).getCompileInMPS())));
        ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module"), "dependencies", true)).clear();
        importDependencies();
        if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language") && myModuleDescriptor instanceof LanguageDescriptor) {
          ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "runtime", true)).clear();
          importRuntime();
          importLanguageDeps();
        }
      }

      if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit")) {
        importDevkit();
      }
    }
  }

  public void checkModule() {
    loadFile();
    if (myModuleDescriptor != null) {
      if (!(checkModuleReference(myModuleDescriptor))) {
        return;
      }

      if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module")) {
        collectDependencies(true);
        if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language") && myModuleDescriptor instanceof LanguageDescriptor) {
          checkRuntime();
          checkLanguageDeps();
        }
      }

      if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit")) {
        checkDevkit();
      }
    }
  }

  public void loadAndCheck() {
    loadFile();
    if (myModuleDescriptor != null) {
      loadModule();
      SLinkOperations.setTarget(myModule, "path", null, true);
    }
  }

  private void loadFile() {
    String moduleFilePath = BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(myModule, "path", true), (genContext != null ?
      Context.defaultContext(genContext) :
      Context.defaultContext()
    ));
    try {
      moduleFilePath = new File(moduleFilePath).getCanonicalPath();
    } catch (IOException ex) {
      // ignore 
    }
    IFile file = FileSystem.getInstance().getFileByPath(moduleFilePath);
    if (!(file.exists()) || file.isDirectory()) {
      report("cannot import module file for " + SPropertyOperations.getString(myModule, "name") + ": file doesn't exist (" + moduleFilePath + ")", myOriginalModule);
      return;
    }

    try {
      ModuleDescriptor md = load(file);
      if (md.getLoadException() != null) {
        report("cannot import module file for " + SPropertyOperations.getString(myModule, "name") + ": exception: " + md.getLoadException().getMessage(), myOriginalModule);
        return;
      }

      myModuleDescriptor = md;
      myModuleFile = file;
    } catch (Exception ex) {
      report("cannot import module file for " + SPropertyOperations.getString(myModule, "name") + ": exception: " + ex.getMessage(), myOriginalModule);
      ex.printStackTrace(System.err);
    }
  }

  private ModuleDescriptor load(IFile file) {
    MacroHelper helper = new ModuleLoader.ModuleMacroHelper(file);
    String path = file.getPath();
    if (path.endsWith(MPSExtentions.DOT_LANGUAGE)) {
      return LanguageDescriptorPersistence.loadLanguageDescriptor(file, helper);
    } else if (path.endsWith(MPSExtentions.DOT_SOLUTION)) {
      return SolutionDescriptorPersistence.loadSolutionDescriptor(file, helper);
    } else if (path.endsWith(MPSExtentions.DOT_DEVKIT)) {
      return DevkitDescriptorPersistence.loadDevKitDescriptor(file);
    }
    throw new RuntimeException("unknown file type: " + file.getName());
  }

  private void loadModule() {
    if (!(checkModuleReference(myModuleDescriptor))) {
      return;
    }

    if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language")) {
      if (!(myModuleDescriptor instanceof LanguageDescriptor)) {
        report("imported file is not a language file " + SPropertyOperations.getString(myModule, "name"), myOriginalModule);
        return;
      }

      checkRuntime();
      checkLanguageDeps();
    } else if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Solution")) {
      if (!(myModuleDescriptor instanceof SolutionDescriptor)) {
        report("imported file is not a solution file " + SPropertyOperations.getString(myModule, "name"), myOriginalModule);
        return;
      }
    } else if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit")) {
      if (!(myModuleDescriptor instanceof DevkitDescriptor)) {
        report("imported file is not a devkit file " + SPropertyOperations.getString(myModule, "name"), myOriginalModule);
        return;
      }

      checkDevkit();
    }

    if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module")) {
      collectDependencies(false);
      collectLocalDependencies();
      collectSources();
    }
  }

  private boolean checkModuleReference(ModuleDescriptor md) {
    boolean success = true;
    ModuleReference moduleReference = md.getModuleReference();
    if (neq_a6ewnz_a0c0g(SPropertyOperations.getString(myModule, "name"), moduleReference.getModuleFqName())) {
      report("name in import doesn't match file content " + SPropertyOperations.getString(myModule, "name") + ", should be: " + moduleReference.getModuleFqName(), myOriginalModule);
      success = false;
    }
    if (neq_a6ewnz_a0d0g(SPropertyOperations.getString(myModule, "uuid"), moduleReference.getModuleId().toString())) {
      report("module id in import doesn't match file content " + SPropertyOperations.getString(myModule, "name") + ", should be: " + moduleReference.getModuleId().toString(), myOriginalModule);
      success = false;
    }
    if (SNodeOperations.isInstanceOf(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module")) {
      boolean inFile = myModuleDescriptor instanceof SolutionDescriptor && !(((SolutionDescriptor) myModuleDescriptor).getCompileInMPS());
      if (SPropertyOperations.getBoolean(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module"), "doNotCompile") != inFile) {
        report("compile in MPS flag doesn't match file content " + SPropertyOperations.getString(myModule, "name") + ", should be: " + inFile, myOriginalModule);
        success = false;
      }
    }
    return success;
  }

  private void checkDevkit() {
    DevkitDescriptor descriptor = ((DevkitDescriptor) myModuleDescriptor);
    SNode devkit = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit");

    for (ModuleReference module : descriptor.getExtendedDevkits()) {
      final SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_DevKit");
      if (resolved == null) {
        report("cannot find devkit in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit"), "extends", true)).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SLinkOperations.getTarget(it, "devkit", false) == resolved;
        }
      }))) {

        report("extends devkit dependency should be extracted into build script: " + module.toString(), myOriginalModule);
      }

    }
    for (ModuleReference module : descriptor.getExportedLanguages()) {
      final SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Language");
      if (resolved == null) {
        report("cannot find exported languages in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit"), "exports", true)).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage"), "language", false) == resolved;
        }
      }))) {

        report("export language dependency should be extracted into build script: " + module.toString(), myOriginalModule);
      }

    }
    for (ModuleReference module : descriptor.getExportedSolutions()) {
      final SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Solution");
      if (resolved == null) {
        report("cannot find exported solution in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit"), "exports", true)).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution"), "solution", false) == resolved;
        }
      }))) {

        report("export solution dependency should be extracted into build script: " + module.toString(), myOriginalModule);
      }
    }
  }

  private void importDevkit() {
    DevkitDescriptor descriptor = ((DevkitDescriptor) myModuleDescriptor);
    SNode devkit = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_DevKit");
    ListSequence.fromList(SLinkOperations.getTargets(devkit, "extends", true)).clear();
    ListSequence.fromList(SLinkOperations.getTargets(devkit, "exports", true)).clear();

    for (ModuleReference module : descriptor.getExtendedDevkits()) {
      SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_DevKit");
      if (resolved == null) {
        report("cannot find devkit in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_DevKitRef", null);
      SLinkOperations.setTarget(ul, "devkit", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(devkit, "extends", true)).addElement(ul);
    }
    for (ModuleReference module : descriptor.getExportedLanguages()) {
      SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Language");
      if (resolved == null) {
        report("cannot find exported languages in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage", null);
      SLinkOperations.setTarget(ul, "language", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(devkit, "exports", true)).addElement(ul);
    }
    for (ModuleReference module : descriptor.getExportedSolutions()) {
      SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Solution");
      if (resolved == null) {
        report("cannot find exported solution in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution", null);
      SLinkOperations.setTarget(ul, "solution", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(devkit, "exports", true)).addElement(ul);
    }
  }

  private void importLanguageDeps() {
    LanguageDescriptor descriptor = ((LanguageDescriptor) myModuleDescriptor);
    for (ModuleReference lang : descriptor.getExtendedLanguages()) {
      SNode resolved = SNodeOperations.as(visible.resolve(lang.getModuleFqName(), lang.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Language");
      if (resolved == null) {
        report("cannot find extended language in dependencies: " + lang.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage", null);
      SLinkOperations.setTarget(ul, "language", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module"), "dependencies", true)).addElement(ul);
    }
  }

  private void checkLanguageDeps() {
    LanguageDescriptor descriptor = ((LanguageDescriptor) myModuleDescriptor);
    for (ModuleReference lang : descriptor.getExtendedLanguages()) {
      final SNode resolved = SNodeOperations.as(visible.resolve(lang.getModuleFqName(), lang.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Language");
      if (resolved == null) {
        report("cannot find extended language in dependencies: " + lang.getModuleFqName(), myModule);
        continue;
      }
      if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "dependencies", true)).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage"), "language", false) == resolved;
        }
      }))) {

        report("extends language dependency should be extracted into build script: " + lang.toString(), myOriginalModule);
      }
    }
  }

  private void importRuntime() {
    LanguageDescriptor descriptor = ((LanguageDescriptor) myModuleDescriptor);
    for (ModuleReference module : descriptor.getRuntimeModules()) {
      SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Solution");
      if (resolved == null) {
        report("cannot find runtime solution in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime", null);
      SLinkOperations.setTarget(ul, "solution", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "runtime", true)).addElement(ul);
    }
    for (ModelRoot entry : descriptor.getRuntimeStubModels()) {
      if (!(LanguageID.JAVA_MANAGER.equals(entry.getManager()))) {
        continue;
      }

      String path = entry.getPath();
      SNode p = convertPath(path, myOriginalModule);
      if (p == null) {
        continue;
      }

      if (path.endsWith(".jar")) {
        SNode jar = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime", null);
        SLinkOperations.setTarget(jar, "path", p, true);
        ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "runtime", true)).addElement(jar);
      } else {
        report("only jar runtimes are supported in runtime stubs, found: " + path, myOriginalModule);
      }
    }
  }

  private void checkRuntime() {
    LanguageDescriptor descriptor = ((LanguageDescriptor) myModuleDescriptor);
    for (ModuleReference module : descriptor.getRuntimeModules()) {
      final SNode resolved = SNodeOperations.as(visible.resolve(module.getModuleFqName(), module.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Solution");
      if (resolved == null) {
        report("cannot find runtime solution in dependencies: " + module.getModuleFqName(), myModule);
        continue;
      }
      if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "runtime", true)).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime"), "solution", false) == resolved;
        }
      }))) {

        report("runtime solution should be extracted into build script: " + module.toString(), myOriginalModule);
      }
    }
    for (ModelRoot entry : descriptor.getRuntimeStubModels()) {
      if (!(LanguageID.JAVA_MANAGER.equals(entry.getManager()))) {
        continue;
      }

      String path = entry.getPath();
      SNode p = convertPath(path, myOriginalModule);
      if (p == null) {
        continue;
      }

      if (path.endsWith(".jar")) {
        final String localPath = BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(p);
        if (!(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Language"), "runtime", true)).any(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime") && eq_a6ewnz_a0a0a0a0a0a0b0g0c0m(BuildSourcePath_Behavior.call_getRelativePath_5481553824944787371(SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"), "path", true)), localPath);
          }
        }))) {
          report("runtime jar should be extracted into build script: " + path, myOriginalModule);
        }

      } else {
        report("only jar runtimes are supported in runtime stubs, found: " + path, myOriginalModule);
      }
    }
  }

  private void collectLocalDependencies() {
    SNode module = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module");
    for (ModelRoot entry : myModuleDescriptor.getStubModelEntries()) {
      if (!(LanguageID.JAVA_MANAGER.equals(entry.getManager()))) {
        continue;
      }

      String path = entry.getPath();
      SNode p = convertPath(path, myOriginalModule);
      if (p == null) {
        continue;
      }

      if (path.endsWith(".jar")) {
        SNode jar = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar", null);
        SLinkOperations.setTarget(jar, "path", p, true);
        ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(jar);
      } else {
        report("only jar stub libraries are supported, found: " + path, myOriginalModule);
      }
    }
    Iterable<ModuleReference> usedLanguages = myModuleDescriptor.getUsedLanguages();
    Iterable<ModuleReference> usedDevkits = myModuleDescriptor.getUsedDevkits();
    if (myModuleDescriptor instanceof LanguageDescriptor) {
      // see j.m.p.dependency.ModuleDependenciesManager#collectAllCompileTimeDependencies 
      Iterable<GeneratorDescriptor> generators = ((LanguageDescriptor) myModuleDescriptor).getGenerators();
      usedLanguages = Sequence.fromIterable(usedLanguages).union(Sequence.fromIterable(generators).translate(new ITranslator2<GeneratorDescriptor, ModuleReference>() {
        public Iterable<ModuleReference> translate(GeneratorDescriptor it) {
          return it.getUsedLanguages();
        }
      }));
      usedDevkits = Sequence.fromIterable(usedDevkits).union(Sequence.fromIterable(generators).translate(new ITranslator2<GeneratorDescriptor, ModuleReference>() {
        public Iterable<ModuleReference> translate(GeneratorDescriptor it) {
          return it.getUsedDevkits();
        }
      }));
    }

    for (ModuleReference lang : usedLanguages) {
      SNode resolved = SNodeOperations.as(visible.resolve(lang.getModuleFqName(), lang.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Language");
      if (resolved == null) {
        report("cannot find used language in dependencies: " + lang.getModuleFqName(), myModule);
        continue;
      }
      SNode ul = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage", null);
      SLinkOperations.setTarget(ul, "language", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(ul);
    }
    for (ModuleReference devkit : usedDevkits) {
      SNode resolved = SNodeOperations.as(visible.resolve(devkit.getModuleFqName(), devkit.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_DevKit");
      if (resolved == null) {
        report("cannot find used devkit in dependencies: " + devkit.getModuleFqName(), myModule);
        continue;
      }
      SNode ud = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit", null);
      SLinkOperations.setTarget(ud, "devkit", resolved, false);
      ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(ud);
    }
  }

  private void collectDependencies(boolean checkOnly) {
    SNode module = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module");
    Map<String, Boolean> usedModuleIds = new HashMap<String, Boolean>();
    for (SNode dep : SLinkOperations.getTargets(module, "dependencies", true)) {
      if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule")) {
        SNode onModule = SNodeOperations.cast(dep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule");
        usedModuleIds.put(SPropertyOperations.getString(SLinkOperations.getTarget(onModule, "module", false), "uuid"), SPropertyOperations.getBoolean(onModule, "reexport"));
      } else if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModuleById")) {
        SNode onModule = SNodeOperations.cast(dep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModuleById");
        usedModuleIds.put(SPropertyOperations.getString(onModule, "targetId"), SPropertyOperations.getBoolean(onModule, "reexport"));
      }
    }

    Iterable<Dependency> dependencies = myModuleDescriptor.getDependencies();
    if (myModuleDescriptor instanceof LanguageDescriptor) {
      // see j.m.p.dependency.ModuleDependenciesManager#collectAllCompileTimeDependencies 
      Iterable<GeneratorDescriptor> generators = ((LanguageDescriptor) myModuleDescriptor).getGenerators();
      dependencies = Sequence.fromIterable(dependencies).union(Sequence.fromIterable(generators).translate(new ITranslator2<GeneratorDescriptor, Dependency>() {
        public Iterable<Dependency> translate(GeneratorDescriptor it) {
          return it.getDependencies();
        }
      }));
    }

    for (Dependency dep : dependencies) {
      boolean reexport = dep.isReexport();
      ModuleReference moduleRef = dep.getModuleRef();
      SNode resolved = SNodeOperations.as(visible.resolve(moduleRef.getModuleFqName(), moduleRef.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Module");

      boolean found = false;
      if (usedModuleIds.containsKey(moduleRef.getModuleId().toString())) {
        found = true;
        boolean foundReexport = usedModuleIds.get(moduleRef.getModuleId().toString());
        if (foundReexport != reexport) {
          report("wrong reexport status for dependency in build script for: " + moduleRef.getModuleId().toString(), myOriginalModule);
        }
      }

      if (!(found)) {
        if (reexport) {
          report("reexport dependency should be extracted into build script: " + dep.getModuleRef().toString(), myOriginalModule);
        }
        if (checkOnly) {
          continue;
        }

        if (resolved != null) {
          SNode res = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule", null);
          SLinkOperations.setTarget(res, "module", resolved, false);
          SPropertyOperations.set(res, "reexport", "" + reexport);
          ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(res);
        } else {
          SNode res = SModelOperations.createNewNode(SNodeOperations.getModel(myModule), "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModuleById", null);
          SPropertyOperations.set(res, "targetId", moduleRef.getModuleId().toString());
          SPropertyOperations.set(res, "targetName", moduleRef.getModuleFqName());
          SPropertyOperations.set(res, "reexport", "" + reexport);
          ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(res);
        }
      }
    }
  }

  private void importDependencies() {
    SNode module = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module");

    Iterable<Dependency> dependencies = myModuleDescriptor.getDependencies();
    if (myModuleDescriptor instanceof LanguageDescriptor) {
      // see j.m.p.dependency.ModuleDependenciesManager#collectAllCompileTimeDependencies 
      Iterable<GeneratorDescriptor> generators = ((LanguageDescriptor) myModuleDescriptor).getGenerators();
      dependencies = Sequence.fromIterable(dependencies).union(Sequence.fromIterable(generators).translate(new ITranslator2<GeneratorDescriptor, Dependency>() {
        public Iterable<Dependency> translate(GeneratorDescriptor it) {
          return it.getDependencies();
        }
      }));
    }

    for (Dependency dep : dependencies) {
      boolean reexport = dep.isReexport();
      if (!(reexport)) {
        continue;
      }

      ModuleReference moduleRef = dep.getModuleRef();
      SNode resolved = SNodeOperations.as(visible.resolve(moduleRef.getModuleFqName(), moduleRef.getModuleId().toString()), "jetbrains.mps.build.mps.structure.BuildMps_Module");

      if (resolved != null) {
        SNode res = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule", null);
        SLinkOperations.setTarget(res, "module", resolved, false);
        SPropertyOperations.set(res, "reexport", "" + reexport);
        ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(res);
      } else {
        SNode res = SModelOperations.createNewNode(SNodeOperations.getModel(myModule), "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModuleById", null);
        SPropertyOperations.set(res, "targetId", moduleRef.getModuleId().toString());
        SPropertyOperations.set(res, "targetName", moduleRef.getModuleFqName());
        SPropertyOperations.set(res, "reexport", "" + reexport);
        ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).addElement(res);
      }
    }
  }

  private void collectSources() {
    SNode module = SNodeOperations.cast(myModule, "jetbrains.mps.build.mps.structure.BuildMps_Module");
    List<String> res = new ArrayList<String>();
    for (String sp : myModuleDescriptor.getSourcePaths()) {
      res.add(sp);
    }
    IFile genPath = ProjectPathUtil.getGeneratorOutputPath(myModuleFile, myModuleDescriptor);
    if (genPath != null) {
      res.add(genPath.getPath());
    }
    for (String path : res) {
      SNode p = convertPath(path, myOriginalModule);
      if (p == null) {
        continue;
      }
      SNode javaSource = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleJavaSource", null);
      SLinkOperations.setTarget(javaSource, "sources", SConceptOperations.createNewNode("jetbrains.mps.build.structure.BuildInputFiles", null), true);
      SLinkOperations.setTarget(SNodeOperations.cast(SLinkOperations.getTarget(javaSource, "sources", true), "jetbrains.mps.build.structure.BuildInputFiles"), "dir", p, true);
      ListSequence.fromList(SLinkOperations.getTargets(module, "sources", true)).addElement(javaSource);
    }
    for (ModelRoot modelRoot : myModuleDescriptor.getModelRoots()) {
      if (modelRoot.getManager() != null) {
        continue;
      }

      String path = modelRoot.getPath();
      SNode p = convertPath(path, myOriginalModule);
      if (p == null) {
        continue;
      }

      SNode mroot = SConceptOperations.createNewNode("jetbrains.mps.build.mps.structure.BuildMps_ModuleModelRoot", null);
      SLinkOperations.setTarget(mroot, "folder", p, true);
      ListSequence.fromList(SLinkOperations.getTargets(module, "sources", true)).addElement(mroot);
    }
  }

  private SNode convertPath(String path, SNode anchor) {
    try {
      return pathConverter.convertPath(path, SNodeOperations.getModel(myModule));
    } catch (PathConverter.PathConvertException ex) {
      report(ex.getMessage(), anchor);
      return null;
    }
  }

  protected void report(String message, SNode node) {
    if (genContext == null) {
      throw new ModuleLoader.ModuleLoaderException(message, node);
    }

    genContext.showErrorMessage(node, message);
  }

  private static boolean neq_a6ewnz_a0c0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean neq_a6ewnz_a0d0g(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean eq_a6ewnz_a0a0a0a0a0a0b0g0c0m(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_a6ewnz_a0c0f0d0a1(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public static class ModuleLoaderException extends RuntimeException {
    private SNode node;

    public ModuleLoaderException(String message, SNode node) {
      super(message);
      this.node = node;
    }

    public SNode getNode() {
      return node;
    }
  }

  public class ModuleMacroHelper implements MacroHelper {
    private IFile moduleFile;

    public ModuleMacroHelper(IFile moduleFile) {
      this.moduleFile = moduleFile;
    }

    public String expandPath(@Nullable String path) {
      if (path == null) {
        return null;
      }

      if (moduleFile != null && (path.startsWith(MacrosFactory.LANGUAGE_DESCRIPTOR) || path.startsWith(MacrosFactory.DEVKIT_DESCRIPTOR) || path.startsWith(MacrosFactory.SOLUTION_DESCRIPTOR))) {
        String relPath = path.substring(path.indexOf('}') + 1);
        return IFileUtils.getCanonicalPath(moduleFile.getParent().getDescendant(relPath));
      }
      if (path.startsWith("${")) {
        int index = path.indexOf("}");
        if (index == -1) {
          report("invalid macro in `" + path + "'", null);
          return path;
        }

        String macroName = path.substring(2, index);
        SNode found = null;
        for (SNode macro : SLinkOperations.getTargets(SNodeOperations.getAncestor(myOriginalModule, "jetbrains.mps.build.structure.BuildProject", false, false), "macros", true)) {
          if (!(SNodeOperations.isInstanceOf(macro, "jetbrains.mps.build.structure.BuildFolderMacro"))) {
            continue;
          }

          if (eq_a6ewnz_a0c0f0d0a1(SPropertyOperations.getString(macro, "name"), macroName)) {
            found = SNodeOperations.cast(macro, "jetbrains.mps.build.structure.BuildFolderMacro");
            break;
          }
        }
        if (found == null) {
          report("macro is not declared in build script: " + path, null);
          return path;
        }

        String localPath = BuildSourcePath_Behavior.call_getLocalPath_5481553824944787364(SLinkOperations.getTarget(found, "defaultPath", true), (genContext != null ?
          Context.defaultContext(genContext) :
          Context.defaultContext()
        ));
        String relPath = path.substring(index + 1);
        return IFileUtils.getCanonicalPath(FileSystem.getInstance().getFileByPath(localPath).getDescendant(relPath));
      }
      return path;
    }

    public String shrinkPath(@Nullable String string) {
      throw new UnsupportedOperationException("cannot shrink");
    }
  }
}
