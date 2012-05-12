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
package jetbrains.mps.ide.findusages;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.impl.cache.impl.id.IdIndex;
import com.intellij.psi.impl.cache.impl.id.IdIndexEntry;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.findUsages.FindUsagesManagerFactory;
import jetbrains.mps.ide.MPSCoreComponents;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.vfs.IFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class FastFindUsagesManager extends FindUsagesManager implements ApplicationComponent {
  private final FindUsagesManagerFactory myFactory;

  public FastFindUsagesManager(MPSCoreComponents coreComponents) {
    myFactory = coreComponents.getFindUsagesManager();
  }

  @NotNull
  public String getComponentName() {
    return "MPS Fast Find Usages Manager";
  }

  public void initComponent() {
    myFactory.setManager(this);
  }

  public void disposeComponent() {
    myFactory.setManager(null);
  }

  public Set<SNode> findInstances(SNode concept, boolean exact, IScope scope, @Nullable ProgressMonitor monitor) {
    if (monitor == null) monitor = new EmptyProgressMonitor();
    Set<SNode> result = new HashSet<SNode>();

    final Iterable<SModelDescriptor> models = scope.getModelDescriptors();
    int count = 0;
    for (SModelDescriptor model : models) {
      if ((model instanceof EditableSModelDescriptor) && ((EditableSModelDescriptor) model).isChanged()) {
        count++;
      }
    }

    monitor.start("Finding instances...", 5 + count);
    try {
      monitor.step("Loading cache");
      result.addAll(findInstancesOfNodeInCache(concept, scope, exact));
      monitor.advance(5);

      for (SModelDescriptor model : models) {
        if ((model instanceof EditableSModelDescriptor) && ((EditableSModelDescriptor) model).isChanged()) {
          monitor.step(model.getLongName());
          result.addAll(new ModelFindOperations(model).findInstances(concept, exact));
          monitor.advance(1);
        }
        if (monitor.isCanceled()) {
          return result;
        }
      }
    } finally {
      monitor.done();
    }
    return result;
  }

  public Set<SReference> findUsages(Set<SNode> nodes, final IScope scope, @Nullable ProgressMonitor monitor) {
    Set<SReference> result = new HashSet<SReference>();
    if (monitor == null) monitor = new EmptyProgressMonitor();

    final Iterable<SModelDescriptor> models = scope.getModelDescriptors();
    int count = 0;
    for (SModelDescriptor model : models) {
      if ((model instanceof EditableSModelDescriptor) && ((EditableSModelDescriptor) model).isChanged()) {
        count++;
      }
    }

    monitor.start("Finding usages...", nodes.size() + count);
    try {
      monitor.step("Loading cache");

      for (SNode node : nodes) {
        result.addAll(findUsagesOfNodeInCache(node, scope));
        monitor.advance(1);
      }
      for (SModelDescriptor model : models) {
        if ((model instanceof EditableSModelDescriptor) && ((EditableSModelDescriptor) model).isChanged()) {
          monitor.step(model.getLongName());
          model.getSModel();
          result.addAll(new ModelFindOperations(model).findUsages(nodes));
          monitor.advance(1);
        }
        if (monitor.isCanceled()) {
          return result;
        }
      }
    } finally {
      monitor.done();
    }
    return result;
  }

  private Set<SNode> findInstancesOfNodeInCache(SNode concept, final IScope scope, boolean isExact) {
    Set<VirtualFile> candidates = new HashSet<VirtualFile>();
    final Set<VirtualFile> scopeFiles = getScopeFiles(scope);
    // quick fix for new persistence, todo: should be persistence dependent
    //candidates.addAll(getCandidates(scopeFiles, NameUtil.nodeFQName(concept)));
    if (concept != null) candidates.addAll(getCandidates(scopeFiles, concept.getName()));
    if (!isExact) {
      Set<String> fqNames = LanguageHierarchyCache.getInstance().getAllDescendantsOfConcept(NameUtil.nodeFQName(concept));
      for (String fqName : fqNames) {
        candidates.addAll(getCandidates(scopeFiles, fqName.substring(fqName.lastIndexOf('.') + 1)));
      }
    }
    Set<SNode> result = new HashSet<SNode>();
    for (VirtualFile file : candidates) {
      SModelDescriptor sm = SModelRepository.getInstance().findModel(VirtualFileUtils.toIFile(file));
      if (sm == null) continue;
      sm.getSModel();
      result.addAll(new ModelFindOperations(sm).findInstances(concept, isExact));
    }
    return result;
  }

  public Set<SReference> findUsagesOfNodeInCache(SNode node, final IScope scope) {
    final Set<VirtualFile> scopeFiles = getScopeFiles(scope);
    String nodeId = node.getId();
    final Set<VirtualFile> candidates = getCandidates(scopeFiles, nodeId);
    Set<SReference> result = new HashSet<SReference>();
    for (VirtualFile file : candidates) {
      SModelDescriptor sm = SModelRepository.getInstance().findModel(VirtualFileUtils.toIFile(file));
      if (sm == null) continue;
      sm.getSModel();
      result.addAll(new ModelFindOperations(sm).findUsages(node));
    }
    return result;
  }

  private Set<VirtualFile> getScopeFiles(IScope scope) {
    final Set<VirtualFile> scopeFiles = new HashSet<VirtualFile>();
    for (SModelDescriptor sm : scope.getModelDescriptors()) {
      if (!(sm instanceof EditableSModelDescriptor)) continue;
      IFile modelFile = ((EditableSModelDescriptor) sm).getModelFile();
      if (modelFile == null) continue;
      scopeFiles.add(VirtualFileUtils.getVirtualFile(modelFile));
    }
    return scopeFiles;
  }

  private Set<VirtualFile> getCandidates(final Set<VirtualFile> scopeFiles, final String nodeId) {
    final Set<VirtualFile> candidates = new HashSet<VirtualFile>();
    FileBasedIndex.getInstance().processValues(IdIndex.NAME, new IdIndexEntry(nodeId, true), null,
      new FileBasedIndex.ValueProcessor<Integer>() {
        public boolean process(final VirtualFile file, final Integer value) {
          candidates.add(file);
          return true;
        }
      }, new GlobalSearchScope(null) {
        public boolean contains(VirtualFile file) {
          return scopeFiles.contains(file);
        }

        public int compare(VirtualFile file1, VirtualFile file2) {
          return file1.getPath().compareTo(file2.getPath());
        }

        public boolean isSearchInModuleContent(@NotNull Module aModule) {
          return true;
        }

        public boolean isSearchInLibraries() {
          return false;
        }
      }
    );
    return candidates;
  }
}
