/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.smodel;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.fileTypes.FileTypeManager;
import jetbrains.mps.generator.fileGenerator.BaseModelCache;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.*;
import jetbrains.mps.project.StubPath;
import jetbrains.mps.project.structure.model.RootReference;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.util.ManyToManyMap;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.MPSExtentions;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MPSModuleRepository implements ApplicationComponent {
  private static final Logger LOG = Logger.getLogger(MPSModuleRepository.class);

  public static MPSModuleRepository getInstance() {
    return ApplicationManager.getApplication().getComponent(MPSModuleRepository.class);
  }

  private Map<String, IModule> myFileToModuleMap = new ConcurrentHashMap<String, IModule>();
  private Map<String, IModule> myFqNameToModulesMap = new ConcurrentHashMap<String, IModule>();
  private Map<ModuleId, IModule> myIdToModuleMap = new ConcurrentHashMap<ModuleId, IModule>();

  private Set<IModule> myModules = new LinkedHashSet<IModule>();

  private ManyToManyMap<IModule, MPSModuleOwner> myModuleToOwners = new ManyToManyMap<IModule, MPSModuleOwner>();

  private List<ModuleRepositoryListener> myModuleListeners = new CopyOnWriteArrayList<ModuleRepositoryListener>();
  private List<MPSModuleRepositoryListener> myListeners = new CopyOnWriteArrayList<MPSModuleRepositoryListener>();

  private boolean myDirtyFlag = false;

  private Map<String, Class<? extends IModule>> myExtensionsToModuleTypes = new LinkedHashMap<String, Class<? extends IModule>>();

  public MPSModuleRepository() {
    initializeExtensionsToModuleTypesMap();
  }

  public void initComponent() {
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "MPS Module Repository";
  }

  public void disposeComponent() {

  }

  private void initializeExtensionsToModuleTypesMap() {
    myExtensionsToModuleTypes.put(MPSExtentions.LANGUAGE, Language.class);
    myExtensionsToModuleTypes.put(MPSExtentions.SOLUTION, Solution.class);
    myExtensionsToModuleTypes.put(MPSExtentions.DEVKIT, DevKit.class);
  }

  public Set<String> getModuleExtensions() {
    return new HashSet<String>(myExtensionsToModuleTypes.keySet());
  }

  public void addRepositoryListener(MPSModuleRepositoryListener l) {
    myListeners.add(l);
  }

  public void removeRepositoryListener(MPSModuleRepositoryListener l) {
    myListeners.remove(l);
  }

  private void fireRepositoryChanged() {
    invalidateCaches();

    for (MPSModuleRepositoryListener l : myListeners) {
      l.repositoryChanged();
    }
  }

  public void invalidateCaches() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        MPSProjects projects = MPSProjects.instance();
        if (projects != null) {
          for (MPSProject p : projects.getProjects()) {
            p.getProject().getComponent(ProjectScope.class).invalidateCaches();
          }
        }

        for (IModule m : getAllModules()) {
          m.invalidateCaches();
        }
        SModelUtil_new.clearCaches();
      }
    });
  }

  public void addModuleRepositoryListener(ModuleRepositoryListener l) {
    myModuleListeners.add(l);
  }

  public void removeModuleRepositoryListener(ModuleRepositoryListener l) {
    myModuleListeners.remove(l);
  }

  private void fireModuleAdded(IModule module) {
    for (ModuleRepositoryListener l : myModuleListeners) {
      try {
        l.moduleAdded(module);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  private void fireBeforeModuleRemoved(IModule module) {
    for (ModuleRepositoryListener l : myModuleListeners) {
      try {
        l.beforeModuleRemoved(module);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  private void fireModuleRemoved(IModule module) {
    for (ModuleRepositoryListener l : myModuleListeners) {
      try {
        l.moduleRemoved(module);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  public boolean isKnownModule(IModule m) {
    return myModules.contains(m);
  }

  public void fireModuleChanged(IModule m) {
    if (!myModules.contains(m)) return;

    for (ModuleRepositoryListener l : myModuleListeners) {
      try {
        l.moduleChanged(m);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  public void fireModuleInitialized(IModule module) {
    assertCanRead();

    for (ModuleRepositoryListener l : myModuleListeners) {
      l.moduleInitialized(module);
    }
  }

  public Set<MPSModuleOwner> getOwners(IModule module) {
    assertCanRead();

    return myModuleToOwners.getByFirst(module);
  }

  public Language registerLanguage(IFile file, MPSModuleOwner owner) {
    return registerModule(file, owner, Language.class);
  }

  public DevKit registerDevKit(IFile file, MPSModuleOwner owner) {
    return registerModule(file, owner, DevKit.class);
  }

  public Solution registerSolution(IFile file, MPSModuleOwner owner) {
    return registerModule(file, owner, Solution.class);
  }

  public IModule getModuleByFile(File file) {
    assertCanRead();

    return myFileToModuleMap.get(FileUtil.getCanonicalPath(file));
  }

  public IModule getModuleByPath(String path) {
    assertCanRead();

    return myFileToModuleMap.get(path);
  }

  //todo rename to getByFqName
  public IModule getModuleByUID(String moduleUID) {
    return myFqNameToModulesMap.get(moduleUID);
  }

  public IModule getModuleById(ModuleId moduleId) {
    assertCanRead();

    if (moduleId == null) return null;
    return myIdToModuleMap.get(moduleId);
  }

  public void moduleFqNameChanged(IModule module, String oldName) {
    assertCanWrite();

    if (myFqNameToModulesMap.get(oldName) != module || myFqNameToModulesMap.containsKey(module.getModuleFqName())) {
      throw new IllegalStateException();
    }
    myFqNameToModulesMap.remove(oldName);
    myFqNameToModulesMap.put(module.getModuleFqName(), module);
  }

  public IModule getModule(@NotNull ModuleReference ref) {
    if (ref.getModuleId() != null) {
      return myIdToModuleMap.get(ref.getModuleId());
    }
    return myFqNameToModulesMap.get(ref.getModuleFqName());
  }

  public <TM extends IModule> TM registerModule(IFile file, MPSModuleOwner owner, Class<TM> cls) {
    assertCanWrite();

    myDirtyFlag = true;
    String canonicalPath = file.getCanonicalPath();
    IModule module = myFileToModuleMap.get(canonicalPath);
    if (module == null) {
      if (cls == Language.class) {
        module = Language.createLanguage(null, file, owner);
      } else if (cls == Solution.class) {
        module = Solution.newInstance(file, owner);
      } else {
        module = DevKit.newInstance(file, owner);
      }
      /* if (module instanceof AbstractModule) {
        ((AbstractModule)module).convertRenamedDependencies();
      }*/
    } else {
      if (!cls.isInstance(module)) {
        LOG.error("can't register module " + module + " : module of another kind with the same name already exists", module);
      }
      if (owner == module) {
        LOG.warning("module " + module + " wants to owe itself: will be collected very quickly", module);
      }
      myModuleToOwners.addLink(module, owner);
      myModules.add(module);
    }
    fireRepositoryChanged();
    return (TM) module;
  }

  public boolean existsModule(ModuleReference ref) {
    return getModule(ref) != null;
  }

  public boolean existsModule(IModule module, MPSModuleOwner owner) {
    assertCanRead();

    return myModuleToOwners.contains(module, owner);
  }

  public void addModule(IModule module, MPSModuleOwner owner) {
    assertCanWrite();

    myDirtyFlag = true;
    if (existsModule(module, owner)) {
      throw new RuntimeException("Couldn't add module \"" + module.getModuleFqName() + "\" : this module is already registered with this very owner: " + owner);
    }
    IFile descriptorFile = module.getDescriptorFile();
    String canonicalDescriptorPath;
    if (descriptorFile == null) {
      canonicalDescriptorPath = null;
    } else {
      canonicalDescriptorPath = descriptorFile.getCanonicalPath();
    }
    if (canonicalDescriptorPath != null && !myFileToModuleMap.containsKey(canonicalDescriptorPath)) {
      myFileToModuleMap.put(canonicalDescriptorPath, module);
    }

    String moduleFqName = module.getModuleFqName();

    if (myFqNameToModulesMap.containsKey(moduleFqName)) {
      IModule m = myFqNameToModulesMap.get(moduleFqName);
      LOG.error("duplicate module name " + moduleFqName + " : module with the same UID exists at " + m.getDescriptorFile() + " and " + module.getDescriptorFile(), m);
    }

    myFqNameToModulesMap.put(moduleFqName, module);

    ModuleId moduleId = module.getModuleReference().getModuleId();
    if (moduleId != null) {
      if (myIdToModuleMap.containsKey(moduleId)) {
        LOG.warning("duplicate module name " + module.getModuleReference() + " module with the same id already exists " + myIdToModuleMap.get(moduleId).getModuleReference());
      }

      myIdToModuleMap.put(module.getModuleReference().getModuleId(), module);
    }

    myModuleToOwners.addLink(module, owner);
    myModules.add(module);

    fireModuleAdded(module);
  }

  public void unRegisterModules(MPSModuleOwner owner, Condition<IModule> condition) {
    assertCanWrite();

    myDirtyFlag = true;
    Set<IModule> modules = new HashSet<IModule>(myModuleToOwners.getBySecond(owner));
    for (IModule m : modules) {
      if (condition.met(m)) {
        myModuleToOwners.removeLink(m, owner);
      }
    }
    fireRepositoryChanged();
  }

  public void unRegisterModules(MPSModuleOwner owner) {
    assertCanWrite();

    myDirtyFlag = true;
    myModuleToOwners.clearSecond(owner);
    fireRepositoryChanged();
  }

  public void removeUnusedModules() {
    assertCanWrite();

    if (!myDirtyFlag) return;

    myDirtyFlag = false;
    for (IModule m : getModulesToBeRemoved()) {
      fireBeforeModuleRemoved(m);
      m.dispose();
      removeModule(m);
    }
    //todo: do the similar thing with module stubs
  }

  private Set<IModule> getModulesToBeRemoved() {
    Set<MPSModuleOwner> rootOwners = new HashSet<MPSModuleOwner>();
    for (IModule m : myModules) {
      for (MPSModuleOwner owner : myModuleToOwners.getByFirst(m)) {
        if (owner instanceof IModule) continue;
        rootOwners.add(owner);
      }
    }

    Set<IModule> visibleModules = new HashSet<IModule>();
    for (IModule m : myModules) {
      if (m instanceof Solution && ((Solution) m).isStub()) {
        visibleModules.add(m);
        continue;
      }

      for (MPSModuleOwner r : rootOwners) {
        if (myModuleToOwners.contains(m, r)) {
          visibleModules.add(m);
        }
      }
    }

    Set<IModule> toAdd;
    do {
      toAdd = new HashSet<IModule>();
      for (IModule m : myModules) {
        if (visibleModules.contains(m)) continue;
        for (IModule v : visibleModules) {
          if (!(v instanceof MPSModuleOwner)) continue;
          if (!myModuleToOwners.contains(m, (MPSModuleOwner) v)) continue;
          toAdd.add(m);
        }
      }
      visibleModules.addAll(toAdd);
    } while (!toAdd.isEmpty());

    Set<IModule> toBeRemoved = new HashSet<IModule>(myModules);
    toBeRemoved.removeAll(visibleModules);
    return toBeRemoved;
  }

  public void removeModule(IModule module) {
    assertCanWrite();

    if (!myModules.contains(module)) {
      return;
    }

    IFile descriptorFile = module.getDescriptorFile();

    myModuleToOwners.clearFirst(module);
    myModules.remove(module);
    myFqNameToModulesMap.remove(module.getModuleFqName());
    if (module.getModuleReference().getModuleId() != null) {
      myIdToModuleMap.remove(module.getModuleReference().getModuleId());
    }

    if (descriptorFile != null) {
      myFileToModuleMap.remove(descriptorFile.getCanonicalPath());
    }

    fireModuleRemoved(module);
  }

  public void readModuleDescriptors(Iterator<? extends RootReference> roots, MPSModuleOwner owner) {
    assertCanWrite();

    while (roots.hasNext()) {
      RootReference root = roots.next();
      IFile moduleRoot = FileSystem.getFile(root.getPath());

      if (moduleRoot.exists()) {
        readModuleDescriptors(moduleRoot, owner);
      } else {
        String error = "Couldn't load modules from " + moduleRoot.getAbsolutePath() + " for owner " + owner +
          "\nDirectory doesn't exist: ";
        LOG.error(error);
      }
    }
  }

  public List<IModule> readModuleDescriptors(IFile dir, MPSModuleOwner owner) {
    return readModuleDescriptors(dir, owner, new HashSet<IFile>());
  }

  private List<IModule> readModuleDescriptors(IFile dir, MPSModuleOwner owner, Set<IFile> excludes) {
    assertCanWrite();

    List<IModule> result = new ArrayList<IModule>();
    String dirName = dir.getName();

    if (FileTypeManager.getInstance().isFileIgnored(dirName)) return result;

    List<IFile> files = dir.list();
    if (files == null) {
      return result;
    }

    for (IFile file : files) {
      if (hasModuleExtension(file.getName())) {
        IModule module = readModuleDescriptor_internal(file, owner, getModuleExtension(file.getName()), excludes);
        if (module != null) {
          result.add(module);
        }
      }
    }

    for (IFile childDir : files) {
      if (FileTypeManager.getInstance().isFileIgnored(childDir.getName())) continue;
      if (hasModuleExtension(childDir.getName())) continue;
      if (excludes.contains(childDir)) continue;

      if (childDir.getName().endsWith(MPSExtentions.MPS_ARCH)) {
        IFile dirInJar = FileSystem.getFile(childDir.getAbsolutePath() + "!/" + AbstractModule.MODULE_DIR);
        result.addAll(readModuleDescriptors(dirInJar, owner, excludes));
      }

      result.addAll(readModuleDescriptors(childDir, owner, excludes));
    }
    return result;
  }

  private boolean hasModuleExtension(String name) {
    return getModuleExtension(name) != null;
  }

  private String getModuleExtension(String name) {
    if (name.endsWith(MPSExtentions.DOT_LANGUAGE)) return MPSExtentions.LANGUAGE;
    if (name.endsWith(MPSExtentions.DOT_SOLUTION)) return MPSExtentions.SOLUTION;
    if (name.endsWith(MPSExtentions.DOT_DEVKIT)) return MPSExtentions.DEVKIT;
    return null;
  }

  private IModule readModuleDescriptor_internal(IFile dir, MPSModuleOwner owner, String extension, Set<IFile> excludes) {
    AbstractModule module = null;
    try {
      Class<? extends IModule> cls = myExtensionsToModuleTypes.get(extension);
      module = (AbstractModule) registerModule(dir, owner, cls);

      for (String sourceDir : module.getSourcePaths()) {
        excludes.add(FileSystem.getFile(sourceDir));
      }
      if (module.getGeneratorOutputPath() != null) {
        excludes.add(BaseModelCache.getCachesDir(module, module.getGeneratorOutputPath()));
      }
      if (module.getTestsGeneratorOutputPath() != null) {
        excludes.add(BaseModelCache.getCachesDir(module, module.getTestsGeneratorOutputPath()));
      }
      for (SModelRoot root : module.getSModelRoots()) {
        excludes.add(FileSystem.getFile(root.getPath()));
      }

      if (module.getClassesGen() != null) {
        excludes.add(module.getClassesGen());
      }
      for (StubPath sp : module.getStubPaths()) {
        excludes.add(FileSystem.getFile(sp.getPath()));
      }
    } catch (Throwable t) {
      LOG.error("Fail to load module from descriptor " + dir.getAbsolutePath(), t);
    }

    return module;
  }

  public Language getLanguageSafe(String namespace) {
    assertCanRead();

    Language result = getLanguage(namespace);
    if (result == null) {
      throw new NullPointerException();
    }
    return result;
  }

  public Language getLanguage(String namespace) {
    return (Language) myFqNameToModulesMap.get(namespace);
  }

  public Language getLanguage(ModuleReference ref) {
    return (Language) getModule(ref);
  }

  public Generator getGenerator(ModuleReference ref) {
    return (Generator) getModule(ref);
  }

  public DevKit getDevKit(String namespace) {
    return (DevKit) myFqNameToModulesMap.get(namespace);
  }

  public DevKit getDevKit(ModuleReference ref) {
    return (DevKit) getModule(ref);
  }

  public Solution getSolution(String namespace) {
    return (Solution) myFqNameToModulesMap.get(namespace);
  }

  public Solution getSolution(ModuleReference ref) {
    return (Solution) getModule(ref);
  }

  public <MT extends IModule> List<MT> getModules(MPSModuleOwner moduleOwner, Class<MT> cls) {
    assertCanRead();

    List<MT> list = new LinkedList<MT>();
    Set<IModule> modules = myModuleToOwners.getBySecond(moduleOwner);
    if (modules != null) {
      for (IModule m : modules) {
        if (cls == null || cls.isInstance(m)) {
          list.add((MT) m);
        }
      }
    }
    return list;
  }

  public List<Language> getLanguages(MPSModuleOwner moduleOwner) {
    return getModules(moduleOwner, Language.class);
  }

  public List<DevKit> getDevKits(MPSModuleOwner moduleOwner) {
    return getModules(moduleOwner, DevKit.class);
  }

  public List<IModule> getModules(MPSModuleOwner moduleOwner) {
    return getModules(moduleOwner, IModule.class);
  }

  public <MT extends IModule> List<MT> getAllModules(Class<MT> cls) {
    assertCanRead();

    List<MT> result = new ArrayList<MT>();
    for (IModule module : myModules) {
      if (cls.isInstance(module)) result.add((MT) module);
    }
    return result;
  }

  public List<Language> getAllLanguages() {
    return getAllModules(Language.class);
  }

  public List<Solution> getAllSolutions() {
    return getAllModules(Solution.class);
  }

  public List<DevKit> getAllDevkits() {
    return getAllModules(DevKit.class);
  }

  public List<Generator> getAllGenerators() {
    return getAllModules(Generator.class);
  }

  public List<IModule> getAllModules() {
    return getAllModules(IModule.class);
  }

  public List<IModule> getAllModulesInDirectory(File file) {
    assertCanRead();

    String path = FileUtil.getCanonicalPath(file);
    List<IModule> result = new ArrayList<IModule>();
    for (IModule m : getAllModules()) {
      IFile descriptorFile = m.getDescriptorFile();

      if (descriptorFile == null) {
        continue;
      }

      String modulePath = descriptorFile.getCanonicalPath();
      if (modulePath != null && modulePath.startsWith(path)) {
        result.add(m);
      }
    }
    return result;
  }

  public Set<Language> getAllExtendingLanguages(Language l) {
    Set<Language> result = new HashSet<Language>();
    for (Language lang : getAllLanguages()) {
      if (lang.getExtendedLanguages().contains(l)) {
        result.add(lang);
      }
    }
    return result;
  }

  public IModule getModuleForModelFile(String path) {
    assertCanRead();

    for (IModule module : getAllModules()) {
      List<SModelRoot> smodelRoots = module.getSModelRoots();
      for (SModelRoot root : smodelRoots) {
        String rootPath = root.getPath();
        if (path.startsWith(rootPath)) {
          return module;
        }
      }
    }
    return null;
  }

  public void updateReferences() {
    assertCanWrite();

    for (IModule m : getAllModules()) {
      AbstractModule module = (AbstractModule) m;

      boolean needSaving = false;

      if (module.updateSModelReferences()) {
        needSaving = true;
      }

      if (module.updateModuleReferences()) {
        needSaving = true;
      }

      if (needSaving && !module.isPackaged()) {
        module.save();
      }
    }
  }

  private void assertCanRead() {
    if (!ModelAccess.instance().canRead()) {
      throw new IllegalStateException("Can't read");
    }
  }

  private void assertCanWrite() {
    if (!ModelAccess.instance().canWrite()) {
      throw new IllegalStateException("Can't write");
    }
  }
}
