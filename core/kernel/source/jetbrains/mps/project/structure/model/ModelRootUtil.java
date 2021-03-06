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
package jetbrains.mps.project.structure.model;

import jetbrains.mps.project.structure.modules.ClassPathEntry;
import jetbrains.mps.smodel.LanguageID;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelRootUtil {
  public static List<ModelRoot> filterJava(Iterable<ModelRoot> list) {
    List<ModelRoot> result = new ArrayList<ModelRoot>();
    for (ModelRoot e : list) {
      if (LanguageID.JAVA_MANAGER.equals(e.getManager())) {
        result.add(e);
      }
    }
    return result;
  }

  public static ModelRoot fromClassPathEntry(ClassPathEntry cpe) {
    ModelRoot result = new ModelRoot();
    result.setPath(cpe.getPath());
    result.setManager(LanguageID.JAVA_MANAGER);
    return result;
  }
}
