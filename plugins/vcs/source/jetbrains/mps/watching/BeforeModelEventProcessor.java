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

import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.vfs.FileSystem;

class BeforeModelEventProcessor extends EventProcessor {
  private static final BeforeModelEventProcessor INSTANCE = new BeforeModelEventProcessor();

  public static BeforeModelEventProcessor getInstance() {
    return INSTANCE;
  }

  @Override
  protected void processDelete(VFileEvent event, ReloadSession reloadSession) {
    final SModelDescriptor model = SModelRepository.getInstance().findModel(FileSystem.getInstance().getFileByPath(event.getPath()));
    if (model != null) {
      // if model is not null, than file was deleted externally
      // we should unload model
      reloadSession.addDeletedModelFilePath(event.getPath());
    }
  }
}
