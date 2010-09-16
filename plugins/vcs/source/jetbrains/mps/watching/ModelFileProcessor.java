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
package jetbrains.mps.watching;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileMoveEvent;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.logging.Logger;

import java.io.File;

class ModelFileProcessor extends EventProcessor {
  private static final Logger LOG = Logger.getLogger(ModelFileProcessor.class);
  private static final ModelFileProcessor INSTANCE = new ModelFileProcessor();

  public static ModelFileProcessor getInstance() {
    return INSTANCE;
  }

  @Override
  protected void processContentChanged(VFileEvent event, ReloadSession reloadSession) {
    if (!event.isFromRefresh()) {
      return;
    }
    EditableSModelDescriptor model = (EditableSModelDescriptor) SModelRepository.getInstance().findModel(FileSystem.getInstance().getFileByPath(event.getPath()));
    LOG.debug("Content change event for model file " + event.getPath() + ". Found model " + model + "." + (model != null ? " Needs reloading " + model.needsReloading() : ""));
    if ((model != null) && (model.needsReloading())) {
      reloadSession.addChangedModel(model);
    }
  }

  @Override
  protected void processCopy(VFileEvent event, ReloadSession reloadSession) {
    processCreate(event, reloadSession);
  }

  @Override
  protected void processMove(VFileEvent event, ReloadSession reloadSession) {
    processCreate(event, reloadSession);

    VFileMoveEvent moveEvent = (VFileMoveEvent) event;
    String oldPath = moveEvent.getOldParent().getPath() + File.separator + moveEvent.getFile().getName();
    fileDeleted(oldPath, reloadSession);
  }

  @Override
  protected void processCreate(VFileEvent event, ReloadSession reloadSession) {
    IFile ifile = FileSystem.getInstance().getFileByPath(event.getPath());
    SModelDescriptor model = SModelRepository.getInstance().findModel(ifile);
    if (model == null) {
      VirtualFile vfile = refreshAndGetVFile(event);
      if (vfile == null) return;
      reloadSession.addNewModelFile(vfile);
    }
  }

  private void fileDeleted(String path, ReloadSession reloadSession) {
    IFile ifile = FileSystem.getInstance().getFileByPath(path);
    final SModelDescriptor model = SModelRepository.getInstance().findModel(ifile);
    if (model != null) {
      reloadSession.addDeletedModelFilePath(path);
    }
  }
}
