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

import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.library.ModulesMiner.ModuleHandle;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.dependency.DevkitDependenciesManager;
import jetbrains.mps.project.dependency.ModuleDependenciesManager;
import jetbrains.mps.project.persistence.DevkitDescriptorPersistence;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.ToStringComparator;
import jetbrains.mps.vfs.IFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DevKit extends AbstractModule implements MPSModuleOwner {
  private static final Logger LOG = Logger.getLogger(DevKit.class);

  public static DevKit createDevkit(String namespace, IFile descriptorFile, MPSModuleOwner moduleOwner) {
    DevKit devKit = new DevKit();
    DevkitDescriptor descriptor;
    if (descriptorFile.exists()) {
      descriptor = DevkitDescriptorPersistence.loadDevKitDescriptor(descriptorFile);
      if (descriptor.getId() == null) {
        descriptor.setId(ModuleId.regular());
        DevkitDescriptorPersistence.saveDevKitDescriptor(descriptor, descriptorFile);
      }
    } else {
      descriptor = createNewDescriptor(namespace, descriptorFile);
    }
    devKit.myDescriptorFile = descriptorFile;

    IModule d = checkRegistered(descriptor.getModuleReference(), descriptorFile);
    if (d != null) {
      return (DevKit) d;
    }

    devKit.setDevKitDescriptor(descriptor, false);
    MPSModuleRepository.getInstance().addModule(devKit, moduleOwner);

    return devKit;
  }

  private static DevkitDescriptor createNewDescriptor(String namespace, IFile descriptorFile) {
    DevkitDescriptor descriptor = new DevkitDescriptor();
    descriptor.setNamespace(namespace);
    descriptor.setId(ModuleId.regular());
    return descriptor;
  }

  @Deprecated
  public static DevKit newInstance(IFile descriptorFile, MPSModuleOwner moduleOwner) {
    ModuleDescriptor desciptor = null;
    if (descriptorFile.exists()) {
      desciptor = ModulesMiner.getInstance().loadModuleDescriptor(descriptorFile);
    }
    return newInstance(new ModuleHandle(descriptorFile, desciptor), moduleOwner);
  }

  public static DevKit newInstance(ModuleHandle handle, MPSModuleOwner moduleOwner) {
    DevKit result = new DevKit();

    DevkitDescriptor devKitDescriptor;
    if (handle.getDescriptor() != null) {
      devKitDescriptor = (DevkitDescriptor) handle.getDescriptor();
      if (devKitDescriptor.getId() == null) {
        devKitDescriptor.setId(ModuleId.regular());
        DevkitDescriptorPersistence.saveDevKitDescriptor(devKitDescriptor, handle.getFile());
      }
    } else {
      devKitDescriptor = new DevkitDescriptor();
      devKitDescriptor.setId(ModuleId.regular());
    }


    result.myDescriptorFile = handle.getFile();

    MPSModuleRepository repository = MPSModuleRepository.getInstance();
    if (repository.getModule(devKitDescriptor.getModuleReference()) != null) {
      LOG.error("Loading module " + devKitDescriptor.getNamespace() + " for the second time");
      return ModuleRepositoryFacade.getInstance().getModule(devKitDescriptor.getModuleReference(), DevKit.class);
    }

    result.setDevKitDescriptor(devKitDescriptor, false);
    repository.addModule(result, moduleOwner);

    return result;
  }

  private DevkitDescriptor myDescriptor;
  private IFile myDescriptorFile;
  private MPSModuleOwner myGenerationOnlyModelsModelOwner = this;

  public DevKit() {

  }

  public IFile getDescriptorFile() {
    return myDescriptorFile;
  }

  public DevkitDescriptor getModuleDescriptor() {
    return myDescriptor;
  }

  public void setModuleDescriptor(ModuleDescriptor moduleDescriptor, boolean reloadClasses) {
    setDevKitDescriptor((DevkitDescriptor) moduleDescriptor, reloadClasses);
  }

  public void setDevKitDescriptor(DevkitDescriptor descriptor, boolean reloadClasses) {
    MPSModuleRepository moduleRepo = MPSModuleRepository.getInstance();
    ModuleRepositoryFacade.getInstance().unregisterModules(this);
    ModuleRepositoryFacade.getInstance().unregisterModules(myGenerationOnlyModelsModelOwner);

    myDescriptor = descriptor;

    if (myDescriptor.getNamespace() != null) {
      ModuleReference mp = new ModuleReference(myDescriptor.getNamespace(), myDescriptor.getId());
      setModuleReference(mp);
    }

    reloadAfterDescriptorChange();
    moduleRepo.fireModuleChanged(this);

    if (reloadClasses) {
      ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
    }

    invalidateDependencies();
  }

  public String getGeneratorOutputPath() {
    return null;
  }

  public String getTestsGeneratorOutputPath() {
    return null;
  }

  //why?   [Mihail Muhin]
  protected void reloadAfterDescriptorChange() {
    ModuleRepositoryFacade.getInstance().unregisterModules(this);
    super.reloadAfterDescriptorChange();
  }

  public void dispose() {
    super.dispose();

    SModelRepository.getInstance().unRegisterModelDescriptors(this);
    ModuleRepositoryFacade.getInstance().unregisterModules(this);
    ModuleRepositoryFacade.getInstance().unregisterModules(myGenerationOnlyModelsModelOwner);
  }

  @Override
  protected ModuleDescriptor loadDescriptor() {
    return ModulesMiner.getInstance().loadModuleDescriptor(getDescriptorFile());
  }

  public List<Language> getExportedLanguages() {
    List<Language> langs = new ArrayList<Language>();
    for (ModuleReference l : myDescriptor.getExportedLanguages()) {
      ModuleReference ref = ModuleReference.fromString(l.getModuleFqName());
      Language lang = ModuleRepositoryFacade.getInstance().getModule(ref, Language.class);
      if (lang != null) {
        langs.add(lang);
      }
    }
    Collections.sort(langs, new ToStringComparator());
    return langs;
  }

  public List<Language> getAllExportedLanguages() {
    List<Language> result = new ArrayList<Language>();
    for (DevKit dk : getAllExtendedDevkits()) {
      for (Language l : dk.getExportedLanguages()) {
        if (!result.contains(l)) {
          result.add(l);
        }
      }
    }
    return result;
  }

  Iterable<ModuleReference> getExtendedDevKits_internal() {
    return myDescriptor.getExtendedDevkits();
  }

  Iterable<ModuleReference> getExportedSolutions_internal() {
    return myDescriptor.getExportedSolutions();
  }

  Iterable<ModuleReference> getExportedLanguages_internal() {
    return myDescriptor.getExportedLanguages();
  }

  public List<DevKit> getExtendedDevKits() {
    List<DevKit> result = new ArrayList<DevKit>();
    for (ModuleReference ref : myDescriptor.getExtendedDevkits()) {
      String uid = ref.getModuleFqName();
      DevKit devKit = ModuleRepositoryFacade.getInstance().getModule(uid, DevKit.class);
      if (devKit != null) {
        result.add(devKit);
      }
    }
    return result;
  }

  public List<DevKit> getAllExtendedDevkits() {
    List<DevKit> result = new ArrayList<DevKit>();
    collectDevKits(result);
    return result;
  }

  private void collectDevKits(List<DevKit> result) {
    if (result.contains(this)) return;
    result.add(this);
    for (DevKit dk : getExtendedDevKits()) {
      dk.collectDevKits(result);
    }
  }

  public List<Solution> getExportedSolutions() {
    List<Solution> result = new ArrayList<Solution>();
    for (ModuleReference ref : myDescriptor.getExportedSolutions()) {
      String uid = ref.getModuleFqName();
      Solution solution = ModuleRepositoryFacade.getInstance().getModule(uid, Solution.class);
      if (solution == null) continue;
      result.add(solution);
    }
    return result;
  }

  public List<Solution> getAllExportedSolutions() {
    List<Solution> result = new ArrayList<Solution>();
    for (DevKit dk : getAllExtendedDevkits()) {
      for (Solution s : dk.getExportedSolutions()) {
        if (result.contains(s)) continue;
        result.add(s);
      }
    }
    return result;
  }

  public List<String> getLanguageNamespaces() {
    List<String> result = new ArrayList<String>();
    for (Language l : getExportedLanguages()) {
      result.add(l.getModuleFqName());
    }
    return result;
  }

  protected ModuleDependenciesManager createDependenciesManager() {
    return new DevkitDependenciesManager(this);
  }

  public void save() {
    DevkitDescriptorPersistence.saveDevKitDescriptor(getModuleDescriptor(), myDescriptorFile);
  }

  public String getName() {
    return myDescriptor.getNamespace();
  }

  public String toString() {
    return getName();
  }

}
