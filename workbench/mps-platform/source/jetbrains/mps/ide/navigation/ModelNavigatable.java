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
package jetbrains.mps.ide.navigation;

import jetbrains.mps.openapi.navigation.NavigationSupport;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelRepository;

/**
* evgeny, 11/6/11
*/
public class ModelNavigatable extends BaseNavigatable {
  private SModelReference modelReference;

  public ModelNavigatable(Project project, SModelReference modelReference) {
    super(project);
    this.modelReference = modelReference;
  }

  @Override
  protected void doNavigate(boolean focus) {
    SModelDescriptor descriptor = SModelRepository.getInstance().getModelDescriptor(modelReference);
    if (descriptor == null) return;

    IModule module = descriptor.getModule();
    if (module == null) return;

    ModuleContext context = new ModuleContext(module, project);
    NavigationSupport.getInstance().selectInTree(context, descriptor, focus);
  }
}
