package jetbrains.mps.ide.newSolutionDialog;

/*Generated by MPS */

import javax.lang.model.SourceVersion;
import jetbrains.mps.ide.NewModuleCheckUtil;
import java.io.File;
import jetbrains.mps.project.MPSExtentions;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.StandaloneMPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.structure.model.ModelRoot;

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
    if (MPSModuleRepository.getInstance().getModuleByUID(namespace) != null) {
      return "Module namespace already exists";
    }
    if (NameUtil.shortNameFromLongName(namespace).length() == 0) {
      return "Enter valid namespace";
    }

    return null;
  }

  public static <T extends IModule> T createModule(String extension, String namespace, String rootPath, MPSProject project, _FunctionTypes._return_P3_E0<? extends T, ? super String, ? super IFile, ? super MPSProject> creator, _FunctionTypes._void_P1_E0<? super ModuleDescriptor> adjuster, boolean reload) {
    String shortName = NameUtil.shortNameFromLongName(namespace);
    String path = rootPath + File.separator + shortName + extension;
    IFile descriptorFile = FileSystem.getInstance().getFileByPath(path);
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

  public static Solution createSolution(String namespace, final String rootPath, MPSProject p, boolean reload) {
    return NewModuleUtil.createModule(MPSExtentions.DOT_SOLUTION, namespace, rootPath, p, new _FunctionTypes._return_P3_E0<Solution, String, IFile, MPSProject>() {
      public Solution invoke(String s, IFile f, MPSProject p) {
        return Solution.createSolution(s, f, p);
      }
    }, new _FunctionTypes._void_P1_E0<ModuleDescriptor>() {
      public void invoke(ModuleDescriptor d) {
        ModelRoot modelRoot = new ModelRoot();
        modelRoot.setPath(rootPath);
        d.getModelRoots().add(modelRoot);

        d.setCompileInMPS(true);
      }
    }, reload);
  }
}
