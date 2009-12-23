package jetbrains.mps.build.packaging.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.SModelFqName;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import java.io.File;
import jetbrains.mps.vfs.MPSExtentions;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.persistence.SolutionDescriptorPersistence;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;

public class BuildGeneratorUtil {
  public BuildGeneratorUtil() {
  }

  public static SModelDescriptor createModel(String modelName, Solution solution) {
    SModelFqName newModelFQName = SModelFqName.fromString(modelName);
    List<SModelDescriptor> ownModelDescriptors = solution.getOwnModelDescriptors();
    SModelDescriptor modelDescriptor = null;
    for (SModelDescriptor descriptor : ListSequence.fromList(ownModelDescriptors)) {
      if (descriptor.getSModelFqName().equals(newModelFQName)) {
        modelDescriptor = descriptor;
        break;
      }
    }
    if (modelDescriptor == null) {
      modelDescriptor = solution.createModel(newModelFQName, solution.getSModelRoots().get(0));
    }
    return modelDescriptor;
  }

  public static Solution createSolution(MPSProject mpsProject, String solutionName, String solutionBaseDir) {
    IFile baseDirFile = FileSystem.getFile(solutionBaseDir);
    if (!(baseDirFile.exists())) {
      baseDirFile.mkdirs();
    }
    String solutionFilePath = solutionBaseDir + File.separator + solutionName + MPSExtentions.DOT_SOLUTION;
    final IFile solutionFile = FileSystem.getFile(solutionFilePath);
    final Solution solution;
    if (solutionFile.exists()) {
      IModule module = ModelAccess.instance().runReadAction(new Computable<IModule>() {
        public IModule compute() {
          return MPSModuleRepository.getInstance().getModuleByFile(solutionFile.toFile());
        }
      });
      if (module instanceof Solution) {
        solution = (Solution) module;
      } else if (module == null) {
        solution = BuildGeneratorUtil.createSolutionFromFile(mpsProject, solutionFile);
      } else {
        return null;
      }
    } else {
      solution = BuildGeneratorUtil.createSolutionFromFile(mpsProject, solutionFile);
    }
    return solution;
  }

  public static Solution createSolutionFromFile(final MPSProject mpsProject, final IFile solutionDescriptorFile) {
    SolutionDescriptor descriptor = new SolutionDescriptor();
    descriptor.setExternallyVisible(true);
    descriptor.setCompileInMPS(true);
    String fileName = solutionDescriptorFile.getName();
    descriptor.setNamespace(fileName.substring(0, fileName.length() - 4));
    ModelRoot mr = new ModelRoot();
    mr.setPrefix("");
    mr.setPath(solutionDescriptorFile.getParent().getAbsolutePath());
    descriptor.getModelRoots().add(mr);
    SolutionDescriptorPersistence.saveSolutionDescriptor(solutionDescriptorFile, descriptor);
    return ModelAccess.instance().runWriteAction(new Computable<Solution>() {
      public Solution compute() {
        return MPSModuleRepository.getInstance().registerSolution(solutionDescriptorFile, mpsProject);
      }
    });
  }

  public static ModuleReference getPackagingLanguageReference() {
    Language packagingLanguage = MPSModuleRepository.getInstance().getLanguage("jetbrains.mps.build.packaging");
    return packagingLanguage.getModuleReference();
  }
}
