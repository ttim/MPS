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
package jetbrains.mps.ide.codeStyle;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.project.Project;
import jetbrains.mps.baseLanguage.util.CodeStyleSettings;
import jetbrains.mps.baseLanguage.util.CodeStyleSettingsRegistry;
import jetbrains.mps.ide.project.ProjectHelper;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * Evgeny Gryaznov, 1/6/11
 */
@State(
  name = "CodeStyleSettings",
  storages = {
    @Storage(
      id = "other",
      file = "$PROJECT_FILE$"
    )
  }
)
public class CodeStyleSettingsConfigurable implements PersistentStateComponent<CodeStyleSettings>, ProjectComponent, SearchableConfigurable {

  private CodeStylePreferencesPage myPage;
  private CodeStyleSettings myState = new CodeStyleSettings();
  private Project myProject;

  public CodeStyleSettingsConfigurable(Project project) {
    myProject = project;
  }

  private CodeStylePreferencesPage getPage() {
    if (myPage == null) {
      myPage = new CodeStylePreferencesPage(myState);
    }
    return myPage;
  }

  public CodeStyleSettings getState() {
    return myState;
  }

  public void loadState(CodeStyleSettings state) {
    myState = state;
  }

  public void projectOpened() {
    CodeStyleSettingsRegistry.registerSettings(ProjectHelper.toMPSProject(myProject), myState);
  }

  public void projectClosed() {
    CodeStyleSettingsRegistry.unregisterSettings(ProjectHelper.toMPSProject(myProject));
  }

  @NotNull
  public String getComponentName() {
    return "Code Style Settings Configurable";
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  public JComponent createComponent() {
    return getPage().getComponent();
  }

  public boolean isModified() {
    return getPage().isModified();
  }

  public void apply() throws ConfigurationException {
    getPage().commit();
  }

  public void reset() {
    getPage().update();
  }

  public void disposeUIResources() {
    myPage = null;
  }

  @Nls
  public String getDisplayName() {
    return "Code Style";
  }

  public Icon getIcon() {
    return null;
  }

  public String getHelpTopic() {
    return "reference.settingsdialog.IDE.globalcodestyle";
  }

  public String getId() {
    return "code.style";
  }

  public Runnable enableSearch(String option) {
    return null;
  }

}
