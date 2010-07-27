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
package jetbrains.mps.findUsages.caches;

import com.intellij.ide.caches.CacheUpdater;
import com.intellij.ide.startup.StartupManagerEx;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.DumbServiceImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectManagerAdapter;
import com.intellij.openapi.roots.ContentIterator;
import com.intellij.openapi.roots.ex.ProjectRootManagerEx;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.indexing.IndexableFileSet;
import jetbrains.mps.make.StartupModuleMaker;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.reloading.ReloadListener;
import jetbrains.mps.smodel.ModelAccess;

import java.util.Collections;
import java.util.Set;


public class MPSFileBasedIndexProjectHandler extends AbstractProjectComponent implements IndexableFileSet {
  private ProjectManager myProjectManager;
  private final FileBasedIndex myIndex;
  private Set<VirtualFile> myRootFiles = null;
  private ReloadListener myReloadHandler = new ReloadAdapter() {
    public void unload() {
      myRootFiles = null;
    }
  };
  private ProjectManagerAdapter myProjectListener = new ProjectManagerAdapter() {
    public void projectClosing(Project project) {
      myIndex.removeIndexableSet(MPSFileBasedIndexProjectHandler.this);
    }
  };

  public MPSFileBasedIndexProjectHandler(final Project project, final ProjectRootManagerEx rootManager, ProjectManager projectManager, FileBasedIndex index, StartupModuleMaker maker) {
    super(project);
    myProjectManager = projectManager;
    myIndex = index;

    final MPSUnindexedFilesUpdater updater = new MPSUnindexedFilesUpdater(myIndex);

    final StartupManagerEx startupManager = (StartupManagerEx) StartupManager.getInstance(myProject);
    if (startupManager == null) return;

    startupManager.registerPreStartupActivity(new Runnable() {
      public void run() {
        startupManager.registerCacheUpdater(updater);
        myIndex.registerIndexableSet(MPSFileBasedIndexProjectHandler.this);
        DumbServiceImpl.getInstance(myProject).queueCacheUpdate(Collections.<CacheUpdater>singletonList(new MPSUnindexedFilesUpdater(myIndex)));
      }
    });
  }

  public void initComponent() {
    ClassLoaderManager.getInstance().addReloadHandler(myReloadHandler);
    myProjectManager.addProjectManagerListener(myProject, myProjectListener);
  }

  public void disposeComponent() {
    myProjectManager.addProjectManagerListener(myProject, myProjectListener);
    ClassLoaderManager.getInstance().removeReloadHandler(myReloadHandler);
  }

  private Set<VirtualFile> getRootFiles() {
    if (myRootFiles == null) {
      myRootFiles = ModelAccess.instance().runReadAction(new Computable<Set<VirtualFile>>() {
        public Set<VirtualFile> compute() {
          return CacheUtil.getIndexableRoots();
        }
      });
    }
    return myRootFiles;
  }

  public boolean isInSet(VirtualFile file) {
    return (CacheUtil.checkFile(file) && checkUnderModule(file));
  }

  public void iterateIndexableFilesIn(VirtualFile file, ContentIterator iterator) {
    if (!isInSet(file)) return;
    iterateIndexableFilesIn_internal(file, iterator);
  }

  public void iterateIndexableFilesIn_internal(VirtualFile file, ContentIterator iterator) {
    if (!CacheUtil.checkFile(file)) return;

    if (file.isDirectory()) {
      for (VirtualFile child : file.getChildren()) {
        iterateIndexableFilesIn_internal(child, iterator);
      }
    } else {
      iterator.processFile(file);
    }
  }

  private boolean checkUnderModule(VirtualFile file) {
    for (VirtualFile vf : getRootFiles()) {
      if (VfsUtil.isAncestor(vf, file, true)) return true;
    }
    return false;
  }
}
