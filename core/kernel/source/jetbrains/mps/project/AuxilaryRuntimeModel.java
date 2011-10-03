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
package jetbrains.mps.project;

import jetbrains.mps.components.ComponentManager;
import jetbrains.mps.smodel.*;

/**
 * Igor Alshannikov
 * May 31, 2007
 */
public class AuxilaryRuntimeModel implements ModelOwner {
  private static final SModelFqName myModelFqName = new SModelFqName("" + System.currentTimeMillis(), "$orphan-stuff$");
  private static final SModelReference MY_MODEL_REFERENCE = new SModelReference(myModelFqName, SModelId.generate());

  public AuxilaryRuntimeModel() {
  }

  private static final Object LOCK = new Object();
  private static volatile SModelDescriptor ourInstance = null;

  public static SModelDescriptor getDescriptor() {
    if (ourInstance != null) return ourInstance;
    synchronized (LOCK) {
      if (ourInstance != null) return ourInstance;
      AuxilaryRuntimeModel instance = ComponentManager.getInstance().getComponent(AuxilaryRuntimeModel.class);
      ourInstance = SModelRepository.getInstance().getModelDescriptor(MY_MODEL_REFERENCE);
      if (ourInstance == null) {
        ourInstance = new AuxModelDescriptor();
        SModelRepository.getInstance().registerModelDescriptor(ourInstance, instance);
      }
      return ourInstance;
    }
  }

  public static boolean isAuxModel(SModel model) {
    if (model == null) return false;
    SModelDescriptor descriptor = getDescriptor();
    return model.getModelDescriptor() == descriptor;
  }

  private static class AuxModelDescriptor extends BaseSModelDescriptor {
    public AuxModelDescriptor() {
      super(AuxilaryRuntimeModel.MY_MODEL_REFERENCE, false);
    }

    protected ModelLoadResult initialLoad() {
      SModel model = new SModel(getSModelReference()){
        protected void performUndoableAction(SNodeUndoableAction action) {
          if (!UndoHelper.getInstance().needRegisterUndo(this)) return;
          UndoHelper.getInstance().addUndoableAction(action);
        }
      };
      return new ModelLoadResult(model, ModelLoadingState.FULLY_LOADED);
    }


    @Override
    protected void setLoadingState(ModelLoadingState state) {
      throw new UnsupportedOperationException();
    }
  }
}
