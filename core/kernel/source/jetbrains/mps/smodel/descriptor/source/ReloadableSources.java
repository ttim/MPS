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
package jetbrains.mps.smodel.descriptor.source;

import gnu.trove.THashSet;
import jetbrains.mps.vfs.IFile;

import java.util.ArrayList;
import java.util.List;

public class ReloadableSources {
  private static ReloadableSources ourInstance = new ReloadableSources();

  public static ReloadableSources getInstance() {
    return ourInstance;
  }

  private ReloadableSources() {

  }

  //--------------

  private final List<FileBasedModelDataSource> mySources = new ArrayList<FileBasedModelDataSource>();
  private final List<FileBasedModelDataSource> myInvalidatedSources = new ArrayList<FileBasedModelDataSource>();

  public void addSource(FileBasedModelDataSource source) {
    mySources.add(source);
  }

  public void removeSource(FileBasedModelDataSource source) {
    mySources.remove(source);
  }

  //--------------

  public void invalidate(IFile file) {
    THashSet<FileBasedModelDataSource> validSources = new THashSet<FileBasedModelDataSource>(mySources);
    validSources.removeAll(myInvalidatedSources);

    for (FileBasedModelDataSource source : validSources) {
      if (source.containFile(file)) {
        myInvalidatedSources.add(source);
      }
    }
  }

  public void reload() {
    for (FileBasedModelDataSource source : myInvalidatedSources) {
      source.reload();
    }
    myInvalidatedSources.clear();
  }
}
