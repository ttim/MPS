/*
 * Copyright 2003-2012 JetBrains s.r.o.
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

import jetbrains.mps.project.IModule;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.util.Condition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class ModuleRepositoryFacade {
  private static final ModuleRepositoryFacade INSTANCE = new ModuleRepositoryFacade();
  private static final MPSModuleRepository REPO = MPSModuleRepository.getInstance();

  public static ModuleRepositoryFacade getInstance() {
    return INSTANCE;
  }

  public IModule getModule(@NotNull ModuleReference ref) {
    return ref.getModuleId() != null ? REPO.getModuleById(ref.getModuleId()) : REPO.getModuleByFqName(ref.getModuleFqName());
  }

  public <T extends IModule> T getModule(ModuleReference ref, Class<T> cls) {
    IModule m = getModule(ref);
    if (!cls.isInstance(m)) return null;
    return (T) m;
  }

  public <T extends IModule> T getModule(String fqName, Class<T> cls) {
    IModule m = REPO.getModuleByFqName(fqName);
    if (!cls.isInstance(m)) return null;
    return (T) m;
  }

  public <T extends IModule> Collection<T> getAllModules(Class<T> cls) {
    List<T> result = new ArrayList<T>();
    for (IModule module : REPO.getAllModules()) {
      if (cls.isInstance(module)) result.add((T) module);
    }
    return result;
  }

  public <T extends IModule> Collection<T> getModules(MPSModuleOwner moduleOwner, @Nullable Class<T> cls) {
    Set<IModule> modules = REPO.getModules(moduleOwner);
    if (modules == null) return Collections.emptyList();

    List<T> list = new LinkedList<T>();
    for (IModule m : modules) {
      if (cls == null || cls.isInstance(m)) {
        list.add((T) m);
      }
    }
    return list;
  }

  public Collection<Language> getAllExtendingLanguages(Language l) {
    List<Language> result = new LinkedList<Language>();
    for (Language lang : getAllModules(Language.class)) {
      if (lang.getExtendedLanguages().contains(l)) {
        result.add(lang);
      }
    }
    return result;
  }

  public void unregisterModules(MPSModuleOwner owner, Condition<IModule> condition) {
    for (IModule module : REPO.getModules(owner)) {
      if (condition.met(module)) {
        REPO.unregisterModule(module, owner);
      }
    }
  }

  public void unregisterModules(MPSModuleOwner owner) {
    for (IModule module : REPO.getModules(owner)) {
      REPO.unregisterModule(module, owner);
    }
  }

  //intended to use only when module is removed physically
  public void removeModuleForced(IModule module) {
    for (MPSModuleOwner owner : REPO.getOwners(module)) {
      REPO.unregisterModule(module, owner);
    }
  }
}
