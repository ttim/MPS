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
package jetbrains.mps.runconfigs.runner;

import com.intellij.execution.runners.DefaultProgramRunner;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.Executor;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class ProgramRunner extends DefaultProgramRunner{
  @NotNull
  public String getRunnerId() {
    return "Default Runner";
  }

  public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
    return true;
  }
}