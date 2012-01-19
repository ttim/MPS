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
package jetbrains.mps.ide.editor.warningPanel;

import com.intellij.openapi.project.Project;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PackagedModelWarningsProvider implements EditorWarningsProvider {
  @Override
  @Nullable
  public WarningPanel getWarningPanel(@NotNull SNode node, @NotNull Project project) {
    SModel model = node.getModel();
    if (model != null) {
      SModelDescriptor md = model.getModelDescriptor();
      IModule module = md.getModule();
      if (module != null && module.isPackaged()) {
        return new WarningPanel(this, "Warning: the node is in a packaged model. Your changes won't be saved");
      }
    }
    return null;
  }
}
