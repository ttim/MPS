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
package jetbrains.mps.library;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.util.Macros;
import jetbrains.mps.vfs.IFile;

import java.io.File;

@State(
  name = "ProjectLibraryManager",
  storages = {
    @Storage(
      id = "other",
      file = "$PROJECT_FILE$"
    )
  }
)
public class ProjectLibraryManager extends BaseLibraryManager implements ProjectComponent {
  private Project myProject;

  public ProjectLibraryManager(Project project, MPSModuleRepository repo) {
    super(repo);
    myProject = project;
  }

  public void projectOpened() {

  }

  public void projectClosed() {

  }

  @Override
  protected String addMacros(String path) {
    return Macros.projectDescriptor().shrinkPath(path, new File(myProject.getPresentableUrl()));
  }

  @Override
  protected String removeMacros(String path) {
    return Macros.projectDescriptor().expandPath(path, new File(myProject.getPresentableUrl()));    
  }
}
