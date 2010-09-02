/*
 * Copyright 2003-2010 JetBrains s.r.o.
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
package jetbrains.mps.project.listener;

import jetbrains.mps.lang.generator.generationContext.structure.GenerationContext_Language;
import jetbrains.mps.lang.generator.structure.Generator_Language;
import jetbrains.mps.library.GeneralPurpose_DevKit;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;

public class GeneratorModelCreationListener extends ModelCreationListener {
  public boolean isApplicable(SModelDescriptor model) {
    return model.getModule() instanceof Generator;
  }

  public void onCreate(SModelDescriptor model) {
    if (SModelStereotype.isGeneratorModel(model)) {
      model.getSModel().addLanguage(Generator_Language.get());
    } else {
      model.getSModel().addDevKit(GeneralPurpose_DevKit.get());
    }
    model.getSModel().addLanguage(GenerationContext_Language.get());
  }
}
