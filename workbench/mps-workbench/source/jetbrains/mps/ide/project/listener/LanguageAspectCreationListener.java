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
package jetbrains.mps.ide.project.listener;

import jetbrains.mps.project.IModule;
import jetbrains.mps.project.listener.ModelCreationListener;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModelDescriptor;

public class LanguageAspectCreationListener extends ModelCreationListener {
  public boolean isApplicable(IModule module, SModelDescriptor m) {
    return m.getModule() instanceof Language && ((Language) m.getModule()).getAspectForModel(m) != null;
  }

  public void onCreate(IModule module, final SModelDescriptor model) {
    Language language = (Language) model.getModule();
    LanguageAspect aspect = language.getAspectForModel(model);

    for (ModuleReference impLang : aspect.getAllLanguagesToImport(language)) {
      model.getSModel().addLanguage(impLang);
    }
  }
}
