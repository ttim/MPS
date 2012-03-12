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
package jetbrains.mps.ide.migration.assistant;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.project.MPSProjectMigrationState;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 3/12/12
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class MigrationAssistant extends AbstractProjectComponent {

  private final MPSProjectMigrationState myMigrationState;

  protected MigrationAssistant(Project project, MPSProjectMigrationState migrationState) {
    super(project);
    myMigrationState = migrationState;
    migrationState.setMigrationAgent(this);
  }

  @Override
  public void disposeComponent() {
    myMigrationState.setMigrationAgent(null);
  }

  @Override
  public void projectOpened() {
    if (myProject.getComponent(MPSProjectMigrationState.class).isMigrationRequired()) {
      Messages.showWarningDialog(myProject, "This project requires migration", "Migration Assistant");
    }
  }
}
