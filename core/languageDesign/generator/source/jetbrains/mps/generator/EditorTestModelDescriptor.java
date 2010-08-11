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
package jetbrains.mps.generator;

import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.*;

import java.util.Collections;
import java.util.Set;

/**
 * @deprecated TODO remove it hahren from generator  
 */
@Deprecated
public class EditorTestModelDescriptor extends TransientModelDescriptor {
  public EditorTestModelDescriptor(TransientModelsModule transientModelsModule, SModelFqName fqName, String longName) {
    super(transientModelsModule, fqName, longName);
  }
}
