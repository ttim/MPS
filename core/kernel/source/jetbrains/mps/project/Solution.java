/*
 * Copyright 2003-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.project;

import jetbrains.mps.ClasspathReader;
import jetbrains.mps.MPSCore;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.library.ModulesMiner.ModuleHandle;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.persistence.SolutionDescriptorPersistence;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.structure.modules.*;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.CommonPaths;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.smodel.MPSModuleOwner;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;

import java.util.*;

/**
 * Igor Alshannikov
 * Aug 26, 2005
 */
public class Solution extends ClassLoadingModule {
  private SolutionDescriptor mySolutionDescriptor;
  public static final String SOLUTION_MODELS = "models";

  private static Map<ModuleReference, ClasspathReader.ClassType> bootstrapCP = initBootstrapSolutions();

  private static Map<ModuleReference, ClasspathReader.ClassType> initBootstrapSolutions() {
    Map<ModuleReference, ClasspathReader.ClassType> result = new HashMap<ModuleReference, ClasspathReader.ClassType>();
    result.put(new ModuleReference("JDK",
      ModuleId.fromString("6354ebe7-c22a-4a0f-ac54-50b52ab9b065")), ClasspathReader.ClassType.JDK);
    result.put(new ModuleReference("JDK.Tools",
      ModuleId.fromString("fdb93da0-59ed-4001-b2aa-4fad79ec058e")), ClasspathReader.ClassType.JDK_TOOLS);
    result.put(new ModuleReference("MPS.Core",
      ModuleId.fromString("6ed54515-acc8-4d1e-a16c-9fd6cfe951ea")), ClasspathReader.ClassType.CORE);
    result.put(new ModuleReference("MPS.Editor",
      ModuleId.fromString("1ed103c3-3aa6-49b7-9c21-6765ee11f224")), ClasspathReader.ClassType.EDITOR);
    result.put(new ModuleReference("MPS.Platform",
      ModuleId.fromString("742f6602-5a2f-4313-aa6e-ae1cd4ffdc61")), ClasspathReader.ClassType.PLATFORM);
    result.put(new ModuleReference("MPS.Workbench",
      ModuleId.fromString("86441d7a-e194-42da-81a5-2161ec62a379")), ClasspathReader.ClassType.WORKBENCH);
    result.put(new ModuleReference("Testbench",
      ModuleId.fromString("920eaa0e-ecca-46bc-bee7-4e5c59213dd6")), ClasspathReader.ClassType.TEST);
    return result;
  }

  public static Solution newInstance(ModuleHandle handle, MPSModuleOwner moduleOwner) {
    SolutionDescriptor descriptor = ((SolutionDescriptor) handle.getDescriptor());
    assert descriptor != null;
    assert descriptor.getId() != null;

    Solution solution = new Solution(descriptor, handle.getFile());

    Solution registered = MPSModuleRepository.getInstance().registerModule(solution, moduleOwner);
    if (registered == solution) {
      solution.setSolutionDescriptor(descriptor, false);
    }

    return registered;
  }

  protected Solution(SolutionDescriptor descriptor, IFile file) {
    myDescriptorFile = file;
    mySolutionDescriptor = descriptor;
    setModuleReference(descriptor.getModuleReference());
  }

  public SolutionDescriptor getModuleDescriptor() {
    return mySolutionDescriptor;
  }

  public void setModuleDescriptor(ModuleDescriptor moduleDescriptor, boolean reloadClasses) {
    super.setModuleDescriptor(moduleDescriptor, reloadClasses);
    setSolutionDescriptor((SolutionDescriptor) moduleDescriptor, reloadClasses);
  }

  public void setSolutionDescriptor(SolutionDescriptor newDescriptor, boolean reloadClasses) {
    mySolutionDescriptor = newDescriptor;

    ModuleReference mp;
    if (mySolutionDescriptor.getNamespace() != null) {
      mp = new ModuleReference(mySolutionDescriptor.getNamespace(), mySolutionDescriptor.getId());
    } else {
      assert myDescriptorFile != null;
      mp = new ModuleReference(myDescriptorFile.getPath(), mySolutionDescriptor.getId());
    }

    setModuleReference(mp);

    reloadAfterDescriptorChange();

    MPSModuleRepository.getInstance().fireModuleChanged(this);

    if (reloadClasses) {
      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
    }

    invalidateDependencies();
    invalidateCaches();
  }

  public void save() {
    SolutionDescriptorPersistence.saveSolutionDescriptor(myDescriptorFile, getModuleDescriptor(), MacrosFactory.forModuleFile(myDescriptorFile));
  }

  @Override
  public void updateModelsSet() {
    updateBootstrapSolutionLibraries();
    super.updateModelsSet();
  }

  private void updateBootstrapSolutionLibraries() {
    // temp HACK

    ModuleDescriptor descriptor = getModuleDescriptor();
    if (descriptor == null) return;

    ClasspathReader.ClassType classType = bootstrapCP.get(descriptor.getModuleReference());
    if (classType == null) return;

    List<String> javaCP = CommonPaths.getMPSPaths(classType);
    descriptor.getModelRoots().clear();
    descriptor.getStubModelEntries().clear();

    for (String path : javaCP) {
      ClassPathEntry entry = new ClassPathEntry();
      entry.setPath(path);
      ModelRoot mr = jetbrains.mps.project.structure.model.ModelRootUtil.fromClassPathEntry(entry);
      descriptor.getStubModelEntries().add(mr);
      descriptor.getModelRoots().add(mr);
    }
  }

  public String toString() {
    String namespace = mySolutionDescriptor.getNamespace();
    if (namespace != null && namespace.length() != 0) return namespace;
    assert myDescriptorFile != null;
    namespace = myDescriptorFile.getName();
    return namespace;
  }

  @Override
  public Collection<StubPath> getOwnStubPaths() {
    if (isPackaged()) {
      return Collections.singletonList(
        new StubPath(
          FileSystem.getInstance().getBundleHome(getDescriptorFile()).getPath(),
          LanguageID.JAVA_MANAGER));
    }

    if (!isCompileInMPS()) {
      IFile classes = ProjectPathUtil.getClassesFolder(getDescriptorFile());
      if (classes != null && classes.exists()) {
        return Collections.singletonList(new StubPath(classes.getPath(), LanguageID.JAVA_MANAGER));
      }
      return Collections.emptyList();
    }

    return super.getOwnStubPaths();
  }

  @Override
  public boolean isCompileInMPS() {
    ModuleDescriptor descriptor = getModuleDescriptor();
    return descriptor != null && descriptor.getCompileInMPS();
  }

  public String getGeneratorOutputPath() {
    IFile result = ProjectPathUtil.getGeneratorOutputPath(getDescriptorFile(), getModuleDescriptor());
    return result != null ? result.getPath() : null;
  }

  public String getTestsGeneratorOutputPath() {
    IFile result = ProjectPathUtil.getGeneratorTestsOutputPath(getDescriptorFile(), getModuleDescriptor());
    return result != null ? result.getPath() : null;
  }

  public boolean reloadClassesAfterGeneration() {
    SolutionDescriptor descriptor = getModuleDescriptor();
    return descriptor != null && descriptor.getKind() != SolutionKind.NONE;
  }

  @Override
  protected SolutionDescriptor loadDescriptor() {
    IFile file = getDescriptorFile();
    assert file != null;
    return (SolutionDescriptor) ModulesMiner.getInstance().loadModuleDescriptor(file);
  }

  @Override
  public boolean hasClass(String name) {
    if (!canLoad()) return false;
    return super.hasClass(name);
  }

  @Override
  public Class getClass(String fqName) {
    if (!canLoad()) return null;
    return super.getClass(fqName);
  }

  private boolean canLoad() {
    return
      getModuleDescriptor().getCompileInMPS() &&
        (
          MPSCore.getInstance().isTestMode() ||
            getModuleDescriptor().getKind() != SolutionKind.NONE
        );
  }
}
