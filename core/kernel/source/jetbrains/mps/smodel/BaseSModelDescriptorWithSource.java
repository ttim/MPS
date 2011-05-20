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

import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.smodel.descriptor.source.ModelDataSource;
import jetbrains.mps.smodel.descriptor.source.changes.ChangeListener;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import org.jetbrains.annotations.NotNull;

public abstract class BaseSModelDescriptorWithSource extends BaseSModelDescriptor {
  @NotNull
  private final ModelDataSource mySource;
  private ChangeListener mySourceListener = new ChangeListener() {
    public void changed(ProgressIndicator progressIndicator) {
      if (!needsReloading()) return;

      progressIndicator.setText2("Reloading " + getLongName());

      reloadFromDisk();
    }
  };


  protected BaseSModelDescriptorWithSource(@NotNull SModelReference modelReference, @NotNull ModelDataSource source, boolean checkDup) {
    super(modelReference, checkDup);
    mySource = source;
    mySource.getChangeWatcher().startListening(mySourceListener);
  }

  @NotNull
  public ModelDataSource getSource() {
    return mySource;
  }

  public void dispose() {
    mySource.getChangeWatcher().stopListening(mySourceListener);
    super.dispose();
  }

  //----------reloading stuff--------

  private long mySourceTimestamp = -1;

  protected abstract void reloadFromDisk();

  protected long getSourceTimestamp(){
    return mySourceTimestamp;
  }

  protected void updateDiskTimestamp() {
    mySourceTimestamp = mySource.getTimestamp();
  }

  public boolean needsReloading() {
    return mySource.getTimestamp() != mySourceTimestamp;
  }

  public abstract void replaceModel(@NotNull SModel newModel, ModelLoadingState loadingState);
}
