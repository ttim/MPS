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
package jetbrains.mps.generator.fileGenerator;

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public abstract class BaseModelCache<T> implements ApplicationComponent {

  @Nullable
  private final AllCaches myAllCaches;

  private final Map<SModelDescriptor, T> myCache = new WeakHashMap<SModelDescriptor, T>();
  private final BaseModelCache<T>.MyCacheGenerator myCacheGenerator;

  @Nullable
  protected abstract T readCache(SModelDescriptor model);

  protected abstract File saveCache(@NotNull T t, SModelDescriptor model);

  protected abstract T generateCache(CacheGenerationContext context);

  protected abstract String getCacheFileName();

  protected BaseModelCache(AllCaches allCaches) {
    myAllCaches = allCaches;
    myCacheGenerator = new MyCacheGenerator();
  }

  public CacheGenerator getGenerator() {
    return myCacheGenerator;
  }

  public void initComponent() {
    if (myAllCaches != null) {
      myAllCaches.registerCache(this);
    }
  }

  public void disposeComponent() {
  }

  @Nullable
  public T get(SModelDescriptor modelDescriptor) {
    synchronized (myCache) {
      if (myCache.containsKey(modelDescriptor)) {
        return myCache.get(modelDescriptor);
      }

      T cache = readCache(modelDescriptor);
      myCache.put(modelDescriptor, cache);

      return cache;
    }
  }

  public List<IFile> getCachesDirs(IModule m) {
    List<IFile> result = new ArrayList<IFile>();

    if (m.getGeneratorOutputPath() != null) {
      IFile file = getCachesDirInternal(m, m.getGeneratorOutputPath());
      if (file != null) {
        result.add(file);
      }
    }

    if (m.getTestsGeneratorOutputPath() != null) {
      IFile file = getCachesDirInternal(m, m.getTestsGeneratorOutputPath());
      if (file != null) {
        result.add(file);
      }
    }

    return result;
  }

  @Nullable
  protected IFile getCachesDirInternal(IModule module, String outputPath) {
    return getCachesDir(module, outputPath);
  }

  @Nullable
  public static IFile getCachesDir(IModule module, String outputPath) {
    if (outputPath == null) return null;

    if (module.isPackaged()) {
      String suffix = outputPath;
      int index = outputPath.replace("\\", "/").lastIndexOf("/");
      if (index >= 0) {
        suffix = outputPath.substring(index + 1);
      }
      IFile descriptorFile;
      if (module instanceof Generator) {
        descriptorFile = ((Generator) module).getSourceLanguage().getDescriptorFile();
      } else {
        descriptorFile = module.getDescriptorFile();
      }
      return descriptorFile.getParent().getParent().child(FileGenerationUtil.getCachesPath(suffix));
    } else {
      return FileSystem.getFile(FileGenerationUtil.getCachesOutputDir(new File(outputPath)));
    }
  }

  public boolean isCacheFile(IFile file) {
    return (file.getName().endsWith(getCacheFileName()));
  }

  protected class MyCacheGenerator implements CacheGenerator {
    public File generateCache(CacheGenerationContext context) {
      T cache = BaseModelCache.this.generateCache(context);
      if (cache == null) return null;

      SModelDescriptor model = context.getOriginalInputModel();

      synchronized (myCache) {
        myCache.put(model, cache);
      }

      return saveCache(cache, model);
    }
  }
}
