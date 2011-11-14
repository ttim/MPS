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
package jetbrains.mps.smodel.persistence;

import jetbrains.mps.project.IModule;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelFqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractModelRootManager implements IModelRootManager {
  public boolean canCreateModel(IModule module, @Nullable ModelRoot root, @Nullable SModelFqName fqName) {
    return false;
  }

  public SModelDescriptor createModel(IModule module, @NotNull ModelRoot root, @NotNull SModelFqName fqName) {
    throw new RuntimeException("can't create new model " + fqName + " manager class = " + getClass());
  }
}
