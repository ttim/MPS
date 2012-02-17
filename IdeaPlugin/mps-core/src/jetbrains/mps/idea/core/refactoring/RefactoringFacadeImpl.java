/*
 * Copyright 2003-2012 JetBrains s.r.o.
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

package jetbrains.mps.idea.core.refactoring;

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.ide.MPSCoreComponents;
import jetbrains.mps.ide.platform.refactoring.RefactoringFacade;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import org.jetbrains.annotations.NotNull;

/**
 * User: shatalin
 * Date: 2/17/12
 */
public class RefactoringFacadeImpl extends RefactoringFacade implements ApplicationComponent {
  public RefactoringFacadeImpl(MPSCoreComponents coreComponents) {
  }

  @Override
  public void initComponent() {
    RefactoringFacade.setInstance(this);
  }

  @Override
  public void disposeComponent() {
    RefactoringFacade.setInstance(null);
  }

  @NotNull
  @Override
  public String getComponentName() {
    return "IDEA Plugin-specific Refactoring Facade implementation";
  }

  @Override
  public void execute(RefactoringContext context) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void executeInThread(RefactoringContext context) {
    throw new UnsupportedOperationException();
  }
}
