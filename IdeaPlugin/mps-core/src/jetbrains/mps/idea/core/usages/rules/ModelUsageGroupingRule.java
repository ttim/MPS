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

package jetbrains.mps.idea.core.usages.rules;


import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.usages.Usage;
import com.intellij.usages.UsageGroup;
import com.intellij.usages.impl.rules.FileGroupingRule;
import jetbrains.mps.workbench.ModelUtil;
import org.jetbrains.annotations.NotNull;

public class ModelUsageGroupingRule extends FileGroupingRule {
  private Project project;

  public ModelUsageGroupingRule(Project project) {
    super(project);
    this.project = project;
  }

  @Override
  public UsageGroup groupUsage(@NotNull Usage usage) {
    if (usage instanceof UsageInModel) {
      final UsageInModel usageInModel = (UsageInModel) usage;
      final VirtualFile modelFile = ModelUtil.getFileByModel(usageInModel.getModel());
      return new FileUsageGroup(project, modelFile) {
        public boolean canNavigate() {
          return false;
        }
      };
    }
    return null;
  }
}
