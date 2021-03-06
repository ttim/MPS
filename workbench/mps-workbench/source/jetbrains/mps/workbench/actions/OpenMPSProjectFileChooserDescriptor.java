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
package jetbrains.mps.workbench.actions;

import com.intellij.openapi.fileChooser.FileChooserDescriptor;
import com.intellij.openapi.fileChooser.FileElement;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.project.MPSExtentions;

import javax.swing.Icon;

public class OpenMPSProjectFileChooserDescriptor extends FileChooserDescriptor{
  public OpenMPSProjectFileChooserDescriptor(boolean chooseFiles) {
    super(chooseFiles, true, chooseFiles, chooseFiles, false, false);
  }

  @Override
  public boolean isFileSelectable(VirtualFile file) {
    return isMpsProjectFile(file);
  }

  @Override
  public boolean isFileVisible(VirtualFile file, boolean showHiddenFiles) {
    if (!showHiddenFiles && FileElement.isFileHidden(file)) return false;
     return isMpsProjectFile(file) || super.isFileVisible(file, showHiddenFiles) && file.isDirectory();
  }

  private boolean isMpsProjectFile(VirtualFile file) {
    return !file.isDirectory() && file.getName().toLowerCase().endsWith(MPSExtentions.DOT_MPS_PROJECT);
  }
}
