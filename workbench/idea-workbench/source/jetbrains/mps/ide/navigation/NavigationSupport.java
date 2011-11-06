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

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;

/**
 * evgeny, 11/5/11
 */
public abstract class NavigationSupport implements ApplicationComponent {

  public static NavigationSupport getInstance() {
    return ApplicationManager.getApplication().getComponent(NavigationSupport.class);
  }

  /**
   * Opens node in the editor. Requires: model read, EDT.
   *
   * @param node    alive node from model repository
   * @param context context
   * @param focus   move focus if needed - to editor or to inspector
   * @param select  select node (or its parent) in editor and inspector (if exist)
   */
  public abstract void openNode(@NotNull IOperationContext context, @NotNull SNode node, boolean focus, boolean select);

  /**
   * Opens project tree tool and selects the node. Requires: model read, EDT.
   *
   * @param node  node to select
   * @param focus focus on project tree tool
   */
  public abstract void selectInTree(@NotNull IOperationContext context, @NotNull SNode node, boolean focus);

  /**
   * Activates project tree tool and selects the model. Requires: model read, EDT.
   *
   * @param model model to select
   * @param focus focus on project tree tool
   */
  public abstract void selectInTree(@NotNull IOperationContext context, @NotNull SModelDescriptor model, boolean focus);

  /**
   * Activates project tree tool and selects the module. Requires: module read, EDT.
   *
   * @param module module to select
   * @param focus  focus on project tree tool
   */
  public abstract void selectInTree(@NotNull IOperationContext context, @NotNull IModule module, boolean focus);

  @Override
  public void initComponent() {
  }

  @Override
  public void disposeComponent() {
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "Navigation support";
  }
}
