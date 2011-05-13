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
package jetbrains.mps.smodel.persistence;

import jetbrains.mps.project.SModelRoot;
import jetbrains.mps.refactoring.StructureModificationLog;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.persistence.def.DescriptorLoadResult;
import jetbrains.mps.vfs.IFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Set;

public abstract class AbstractModelRootManager implements IModelRootManager {
  public boolean isNewModelsSupported() {
    return false;
  }

  @NotNull
  public SModelDescriptor createNewModel(@NotNull SModelRoot root,
                                         @NotNull SModelFqName fqName,
                                         @NotNull ModelOwner owner) {
    throw new RuntimeException("can't create new model " + fqName + " manager class = " + getClass());
  }

  @Nullable
  @Override
  public Collection<SModelReference> collectModels(@NotNull SModelRoot root) {
    return null;
  }

  public void dispose() {
  }

  public void rename(SModelDescriptor model, SModelFqName modelFqName, boolean changeFile) {
    throw new UnsupportedOperationException();
  }
}
