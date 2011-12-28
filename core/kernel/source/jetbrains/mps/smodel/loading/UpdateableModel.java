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
package jetbrains.mps.smodel.loading;

import jetbrains.mps.smodel.NodeReadAccessCasterInEditor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.UndoHelper;
import jetbrains.mps.util.Computable;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/*
 * This class consists of 2 methods
 * getModel(state) returns model loaded up to the given state or further
 * getState() returns the state to which the model is loaded
 * Ass all calls are synchronized and sequential, we can guarantee that getState() will return a real state of a model
 */
public abstract class UpdateableModel {
  private final SModelDescriptor myDescriptor;

  private AtomicReference<ModelLoadingState> myState = new AtomicReference<ModelLoadingState>(ModelLoadingState.NOT_LOADED);
  private AtomicBoolean myLoading = new AtomicBoolean(false);

  private SModel myModel = null;

  public UpdateableModel(SModelDescriptor descriptor) {
    myDescriptor = descriptor;
  }

  public final ModelLoadingState getState() {
    return myState.get();
  }

  public final SModel getModel(ModelLoadingState state) {
    ensureLoadedTo(state);
    return myModel;
  }

  private void ensureLoadedTo(final ModelLoadingState state) {
    if (state.ordinal() <= myState.get().ordinal()) return;

    while (!myLoading.compareAndSet(false, true)) {
      // we are expected to wait until the model is loaded
      synchronized (this) {
        if (state.ordinal() <= myState.get().ordinal()) return; // already loaded by another thread
      }
    }

    synchronized (this) {
      if (state.ordinal() <= myState.get().ordinal()) return; // already loaded by another thread, prevent 2nd loading
//      myState.set(state);  //this is for elimination of infinite recursion

      ModelLoadResult res = NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<ModelLoadResult>() {
        public ModelLoadResult compute() {
          return UndoHelper.getInstance().runNonUndoableAction(new Computable<ModelLoadResult>() {
            public ModelLoadResult compute() {
              return doLoad(state, myModel);
            }
          });
        }
      });
      if (myModel != null) {
        myModel.setModelDescriptor(null);
      }
      myModel = res.getModel();
      myModel.setModelDescriptor(myDescriptor);
      myState.set(res.getState());
      myLoading.set(false);
    }

  }

  protected abstract ModelLoadResult doLoad(ModelLoadingState state,@Nullable SModel current);

  public synchronized void replaceWith(SModel newModel, ModelLoadingState state) {
    myModel = newModel;
    myState.set(state);
  }
}
