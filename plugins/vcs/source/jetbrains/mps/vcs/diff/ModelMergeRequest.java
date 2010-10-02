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
package jetbrains.mps.vcs.diff;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diff.ActionButtonPresentation;
import com.intellij.openapi.diff.SimpleContent;
import com.intellij.openapi.diff.impl.mergeTool.MergeRequestImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.vcs.ModelMergeRequestConstants;
import jetbrains.mps.vcs.ModelUtils;
import org.jetbrains.annotations.NotNull;

public class ModelMergeRequest extends MergeRequestImpl {
  private final VirtualFile myFile;

  ModelMergeRequest(String leftText, String rightText, String originalContent, @NotNull VirtualFile file, Project project, ActionButtonPresentation actionButtonPresentation) {
    super(leftText, originalContent, rightText, project, actionButtonPresentation);

    ApplicationManager.getApplication().saveAll();
    myFile = file;
  }

  @NotNull
  public VirtualFile getFile() {
    return myFile;
  }

  public void resolved(final byte[] result) {
    ((SimpleContent) getContents()[ModelMergeRequestConstants.ORIGINAL]).setBOM(result);
    setResult(DialogWrapper.OK_EXIT_CODE);
    ModelUtils.replaceWithNewModelFromBytes(myFile, result);
  }
}
