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

package jetbrains.mps.idea.core;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupManager;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.stubs.LibrariesLoader;
import org.jetbrains.annotations.NotNull;

public class IdeaLibLoader implements ProjectComponent {
  public IdeaLibLoader(StartupManager m) {
    m.registerPreStartupActivity(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteAction(new Runnable() {
          public void run() {
            LibrariesLoader.getInstance().loadNewLibs();
          }
        });
      }
    });
  }

  public void initComponent() {

  }

  public void disposeComponent() {

  }

  @NotNull
  public String getComponentName() {
    return "LibLoader";
  }

  @Override
  public void projectOpened() {

  }

  @Override
  public void projectClosed() {

  }
}
