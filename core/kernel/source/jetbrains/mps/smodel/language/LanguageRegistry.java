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
package jetbrains.mps.smodel.language;

import jetbrains.mps.components.CoreComponent;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static jetbrains.mps.smodel.structure.DescriptorUtils.getObjectByClassNameForLanguage;

/**
 * evgeny, 3/11/11
 */
public class LanguageRegistry implements CoreComponent {
  private static final Logger LOG = Logger.getLogger(LanguageRegistry.class);

  private static LanguageRegistry INSTANCE;

  public static LanguageRegistry getInstance() {
    return INSTANCE;
  }

  /*
  *  Language namespace can be changed.
  */
  private Map<Language, String> myLanguageToNamespace;
  private Map<String, LanguageRuntime> myLanguages;

  private final ConceptRegistry myConceptRegistry;

  private final List<LanguageRegistryListener> myLanguageListeners = new CopyOnWriteArrayList<LanguageRegistryListener>();

  public LanguageRegistry(MPSModuleRepository repository, ClassLoaderManager loaderManager, ConceptRegistry registry) {
    myConceptRegistry = registry;
  }

  @Override
  public void init() {
    if (INSTANCE != null) {
      throw new IllegalStateException("double initialization");
    }
    INSTANCE = this;
  }

  @Override
  public void dispose() {
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        notifyUnload(myLanguages.values(), true);
        myLanguageToNamespace.clear();
        myLanguages.clear();
        myLanguages = null;
      }
    });
    INSTANCE = null;
  }

  public void loadLanguages() {
    if (myLanguages != null) return;

    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        myLanguageToNamespace = new HashMap<Language, String>();
        myLanguages = new HashMap<String, LanguageRuntime>();

        MPSModuleRepository.getInstance().addModuleRepositoryListener(new MyModuleRepositoryAdapter());

        reloadLanguages();
      }
    });
  }

  public void reloadLanguages() {
    ModelAccess.assertLegalWrite();

    notifyUnload(myLanguages.values(), true);
    myLanguages.clear();
    Set<Language> existing = new HashSet<Language>(myLanguageToNamespace.keySet());
    for (Language l : (List<Language>) ModuleRepositoryFacade.getInstance().getAllModules(Language.class)) {
      String namespace = l.getModuleFqName();
      if (!myLanguages.containsKey(namespace)) {
        existing.remove(l);
        myLanguageToNamespace.put(l, namespace);
        LanguageRuntime runtime = createRuntime(l, false);
        myLanguages.put(namespace, runtime);
      } else {
        // duplicate language, ignore
      }
    }
    for (Language l : existing) {
      myLanguageToNamespace.remove(l);
    }

    notifyLoad(myLanguages.values());
  }

  private void notifyUnload(Collection<LanguageRuntime> languages, boolean unloadAll) {
    if (languages.isEmpty()) return;

    for (LanguageRegistryListener l : myLanguageListeners) {
      try {
        l.languagesUnloaded(languages, unloadAll);
      } catch (Exception ex) {
        LOG.error(ex);
      }
    }
    myConceptRegistry.languagesUnloaded(languages, unloadAll);
  }

  private void notifyLoad(Collection<LanguageRuntime> languages) {
    if (languages.isEmpty()) return;

    myConceptRegistry.languagesLoaded(languages);
    for (LanguageRegistryListener l : myLanguageListeners) {
      try {
        l.languagesLoaded(languages);
      } catch (Exception ex) {
        LOG.error(ex);
      }
    }
  }

  private static LanguageRuntime createRuntime(Language l, boolean tryToLoad) {
    // TODO FIXME hack to avoid errors in LOG
    LanguageRuntime languageRuntime = null;
    try{
      languageRuntime = getObjectByClassNameForLanguage(l.getModuleFqName() + ".Language", LanguageRuntime.class, l, tryToLoad);
    }
    catch (RuntimeException unexpected) {
      LOG.error("Exception loading language: "+unexpected);
    }
    if (languageRuntime == null) {
      languageRuntime = new LanguageRuntimeInterpreted(l);
    }
    return languageRuntime;
  }

  public String toString() {
    return "LanguageRegistry";
  }

  public void addRegistryListener(LanguageRegistryListener listener) {
    myLanguageListeners.add(listener);
  }

  public void removeRegistryListener(LanguageRegistryListener listener) {
    myLanguageListeners.remove(listener);
  }

  /*
   *   Collection is valid until the end of the current read action.
   */
  public Collection<LanguageRuntime> getAvailableLanguages() {
    ModelAccess.assertLegalRead();

    return myLanguages == null ? null : myLanguages.values();
  }

  @Nullable
  public LanguageRuntime getLanguage(String namespace) {
    return myLanguages == null ? null : myLanguages.get(namespace);
  }

  public LanguageRuntime getLanguage(Language language) {
    return getLanguage(language.getModuleFqName());
  }

  private class MyModuleRepositoryAdapter extends ModuleRepositoryAdapter {
    public void moduleAdded(IModule module) {
      if (!(module instanceof Language)) return;

      Language l = (Language) module;
      String namespace = l.getModuleFqName();
      // avoid duplicates in registry
      if (myLanguages.containsKey(namespace)) return;

      LanguageRuntime runtime = createRuntime(l, true);
      if (runtime == null) return;

      myLanguages.put(namespace, runtime);
      myLanguageToNamespace.put(l, namespace);
      notifyLoad(Collections.singleton(runtime));
    }

    @Override
    public void moduleInitialized(IModule module) {

    }

    @Override
    public void moduleChanged(IModule module) {

    }

    @Override
    public void moduleRemoved(IModule module) {
      if (!(module instanceof Language)) return;

      Language l = (Language) module;
      String namespace = myLanguageToNamespace.get(l);
      if (namespace == null) return;

      LanguageRuntime runtime = myLanguages.remove(namespace);
      if (runtime == null) return;

      myLanguageToNamespace.remove(l);
      notifyUnload(Collections.singleton(runtime), false);
    }

    @Override
    public void repositoryChanged() {
      // TODO FIXME cleanup
    }
  }
}
