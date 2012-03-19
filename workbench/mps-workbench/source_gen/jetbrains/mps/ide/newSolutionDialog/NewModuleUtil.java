package jetbrains.mps.ide.newSolutionDialog;

/*Generated by MPS */

import javax.lang.model.SourceVersion;
import jetbrains.mps.ide.NewModuleCheckUtil;
import java.io.File;

import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.project.*;
import jetbrains.mps.project.persistence.LanguageDescriptorPersistence;
import jetbrains.mps.project.persistence.SolutionDescriptorPersistence;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.smodel.MPSModuleOwner;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vfs.FileSystem;

public class NewModuleUtil {
  public NewModuleUtil() {
  }

  public static String check(String extension, String namespace, String rootPath) {
    if (!(SourceVersion.isName(namespace))) {
      return "Module namespace should be valid Java package";
    }
    if (rootPath.length() == 0) {
      return "Path should be specified";
    }
    String message = NewModuleCheckUtil.checkModuleDirectory(new File(rootPath), MPSExtentions.DOT_LANGUAGE, "Module");
    if (message != null) {
      return message;
    }
    if (namespace.length() == 0) {
      return "Namespace should be specified";
    }
    if (MPSModuleRepository.getInstance().getModuleByFqName(namespace) != null) {
      return "Module namespace already exists";
    }
    if (NameUtil.shortNameFromLongName(namespace).length() == 0) {
      return "Enter valid namespace";
    }
    IFile moduleDir = getModuleFile(namespace, rootPath, extension).getParent();
    if (moduleDir.getDescendant(Language.LANGUAGE_MODELS).exists() || moduleDir.getDescendant(Solution.SOLUTION_MODELS).exists()) {
      return "Module already exists in this folder";
    }

    return null;
  }

  public static <T extends IModule> T createModule(String extension, String namespace, String rootPath, MPSProject project, _FunctionTypes._return_P3_E0<? extends T, ? super String, ? super IFile, ? super MPSProject> creator, _FunctionTypes._void_P1_E0<? super ModuleDescriptor> adjuster, boolean reload) {
    IFile descriptorFile = NewModuleUtil.getModuleFile(namespace, rootPath, extension);
    final IModule module = creator.invoke(namespace, descriptorFile, project);
    ModuleDescriptor d = module.getModuleDescriptor();
    adjuster.invoke(d);
    module.setModuleDescriptor(d, reload);
    ModelAccess.instance().writeFilesInEDT(new Runnable() {
      public void run() {
        module.save();
      }
    });
    project.addModule(module.getModuleReference());
    if (reload) {
      ((StandaloneMPSProject) project).update();
    }
    return ((T) module);
  }

  private static IFile getModuleFile(String namespace, String rootPath, String extension) {
    String shortName = NameUtil.shortNameFromLongName(namespace);
    String path = rootPath + File.separator + shortName + extension;
    return FileSystem.getInstance().getFileByPath(path);
  }

  public static Solution createSolution(String namespace, String rootPath, MPSProject p, boolean reload) {
    return NewModuleUtil.createModule(MPSExtentions.DOT_SOLUTION, namespace, rootPath, p, new _FunctionTypes._return_P3_E0<Solution, String, IFile, MPSProject>() {
      public Solution invoke(String s, IFile f, MPSProject p) {
        return createNewSolution(s, f, p);
      }
    }, new _FunctionTypes._void_P1_E0<ModuleDescriptor>() {
      public void invoke(ModuleDescriptor d) {
      }
    }, reload);
  }

  public static Solution createNewSolution(String namespace, IFile descriptorFile, MPSModuleOwner moduleOwner) {
    assert !descriptorFile.exists();

    SolutionDescriptor descriptor = createNewSolutionDescriptor(namespace, descriptorFile);
    SolutionDescriptorPersistence.saveSolutionDescriptor(descriptorFile, descriptor);

    return Solution.newInstance(ModulesMiner.getInstance().loadModuleHandle(descriptorFile),moduleOwner);
  }

  private static SolutionDescriptor createNewSolutionDescriptor(String namespace, IFile descriptorFile) {
    SolutionDescriptor descriptor = new SolutionDescriptor();
    descriptor.setNamespace(namespace);
    descriptor.setId(ModuleId.regular());

    IFile modelsDir = descriptorFile.getParent().getDescendant(Solution.SOLUTION_MODELS);
    if (modelsDir.exists() && modelsDir.getChildren().size() != 0) {
      throw new IllegalStateException("Trying to create a solution in an existing solution's directory");
    } else {
      modelsDir.mkdirs();
    }

    // default descriptorModel roots
    ModelRoot modelRoot = new ModelRoot();
    modelRoot.setPath(modelsDir.getPath());
    descriptor.getModelRoots().add(modelRoot);
    return descriptor;
  }
  
  public static Language createNewLanguage(String namespace, IFile descriptorFile, MPSModuleOwner moduleOwner) {
    assert !descriptorFile.exists();

    LanguageDescriptor descriptor = createNewLanguageDescriptor(namespace, descriptorFile);
    LanguageDescriptorPersistence.saveLanguageDescriptor(descriptorFile, descriptor);

    return Language.newInstance(ModulesMiner.getInstance().loadModuleHandle(descriptorFile), moduleOwner);
  }

  private static LanguageDescriptor createNewLanguageDescriptor(String languageNamespace, IFile descriptorFile) {
    LanguageDescriptor languageDescriptor = new LanguageDescriptor();
    languageDescriptor.setNamespace(languageNamespace);
    languageDescriptor.setId(ModuleId.regular());

    IFile languageModels = descriptorFile.getParent().getDescendant(Language.LANGUAGE_MODELS);
    if (languageModels.exists()) {
      throw new IllegalStateException("Trying to create a language in an existing language's directory");
    }

    // default descriptorModel roots
    ModelRoot modelRoot = new jetbrains.mps.project.structure.model.ModelRoot();
    modelRoot.setPath(languageModels.getPath());
    languageDescriptor.getModelRoots().add(modelRoot);
    return languageDescriptor;
  }

}
