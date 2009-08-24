/*
 * Copyright 2003-2009 JetBrains s.r.o.
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
package jetbrains.mps.workbench.choose.modules;

import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.workbench.choose.base.BaseMPSChooseModel;

public abstract class BaseModuleModel extends BaseMPSChooseModel<IModule> {
  //---------------------FIND STUFF------------------------

  public BaseModuleModel(MPSProject project, String entityName) {
    super(project, entityName);
  }

  public String doGetFullName(Object element) {
    return ((BaseModuleItem) element).getModule().getModuleNamespace();
  }

  public String doGetObjectName(IModule module) {
    return module.getModuleNamespace();
  }
}
