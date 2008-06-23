package jetbrains.mps.project;

import jetbrains.mps.logging.Logger;
import jetbrains.mps.projectLanguage.DescriptorsPersistence;
import jetbrains.mps.projectLanguage.structure.ModuleDescriptor;
import jetbrains.mps.projectLanguage.structure.SolutionDescriptor;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.vfs.IFile;

import java.io.File;
import java.util.*;

import com.intellij.openapi.progress.EmptyProgressIndicator;

/**
 * Igor Alshannikov
 * Aug 26, 2005
 */
public class Solution extends AbstractModule {
  private static Logger LOG = Logger.getLogger(Solution.class);

  private SolutionDescriptor mySolutionDescriptor;

  // -------------------------------------------------------------------

  private Solution() {

  }

  public static Solution newInstance(IFile descriptorFile, MPSModuleOwner moduleOwner) {
    Solution solution = new Solution();
    SModel model = ProjectModels.createDescriptorFor(solution).getSModel();
    model.setLoading(true);
    SolutionDescriptor solutionDescriptor;
    if (descriptorFile.exists()) {
      solutionDescriptor = DescriptorsPersistence.loadSolutionDescriptor(descriptorFile, model);
    } else {
      solutionDescriptor = SolutionDescriptor.newInstance(model);
    }
    solution.myDescriptorFile = descriptorFile;
    solution.mySolutionDescriptor = solutionDescriptor;

    solution.reload();

    MPSModuleRepository.getInstance().addModule(solution, moduleOwner);
    return solution;
  }

  protected void reload() {
    super.reload();
    SModelRepository.getInstance().registerModelDescriptor(mySolutionDescriptor.getModel().getModelDescriptor(), this);
  }

  public void onModuleLoad() {
    super.onModuleLoad();
  }


  protected void readModels() {
    if (!isInitialized()) {
      super.readModels();

      if (isInitialized()) {
        fireModuleInitialized();
      }
    }
  }

  public void setModuleDescriptor(ModuleDescriptor moduleDescriptor) {
    if (moduleDescriptor instanceof SolutionDescriptor) {
      setSolutionDescriptor((SolutionDescriptor) moduleDescriptor);
    } else {
      LOG.error("not a dev kit descriptor", new Throwable());
    }
  }

  public void setSolutionDescriptor(SolutionDescriptor newDescriptor) {
    mySolutionDescriptor = newDescriptor;

    reload();

    ClassLoaderManager.getInstance().reloadAll(new EmptyProgressIndicator());
  }

  public void dispose() {
    SModelRepository.getInstance().unRegisterModelDescriptors(this);
    MPSModuleRepository.getInstance().unRegisterModules(this);
  }

  public void save() {
    DescriptorsPersistence.saveSolutionDescriptor(myDescriptorFile, getSolutionDescriptor());
  }

  public SolutionDescriptor getSolutionDescriptor() {
    return mySolutionDescriptor;
  }

  public ModuleDescriptor getModuleDescriptor() {
    return mySolutionDescriptor;
  }

  public String toString() {
    String text = mySolutionDescriptor.getName();
    if (text == null || text.length() == 0) {
      text = myDescriptorFile.getName();
    }
    return text;
  }

  public boolean isExternallyVisible() {
    return mySolutionDescriptor.getExternallyVisible();
  }

  public String getModuleUID() {
    if (isExternallyVisible() && mySolutionDescriptor.getName() != null) {
      return mySolutionDescriptor.getName();
    } else {
      return FileUtil.getCanonicalPath(myDescriptorFile.getAbsolutePath());
    }
  }

  public String getGeneratorOutputPath() {
    String generatorOutputPath = mySolutionDescriptor.getGeneratorOutputPath();
    if (generatorOutputPath == null) {
      generatorOutputPath = myDescriptorFile.getParent().getCanonicalPath() + File.separatorChar + "source_gen";
    }
    return generatorOutputPath;
  }

  public void reloadFromDisk() {
    SModel model = ProjectModels.createDescriptorFor(this).getSModel();
    IFile file = getDescriptorFile();
    assert file != null;
    SolutionDescriptor descriptor = DescriptorsPersistence.loadSolutionDescriptor(file, model);
    setSolutionDescriptor(descriptor);
  }

  protected void collectRuntimePackages(Set<String> result, String current) {
    if (!"".equals(current) && !getClassPathItem().getAvailableClasses(current).isEmpty()) {
      result.add(current);
    }
    for (String subpack : getClassPathItem().getSubpackages(current)) {
      collectRuntimePackages(result, subpack);
    }
  }

  public List<String> getClassPath() {
    List<String> result = new ArrayList<String>();
    if (getClassesGen() != null && getClassesGen().exists()) {
      result.add(getClassesGen().getPath());
    }
    result.addAll(super.getClassPath());
    return result;
  }

  public boolean reloadClassesAfterGeneration() {
    return false;
  }
}
