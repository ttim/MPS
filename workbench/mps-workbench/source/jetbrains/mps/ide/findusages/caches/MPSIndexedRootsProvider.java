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
package jetbrains.mps.ide.findusages.caches;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.IndexableSetContributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Shatalin
 * Date: 4/19/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class MPSIndexedRootsProvider extends IndexableSetContributor {
  @Override
  public Set<VirtualFile> getAdditionalRootsToIndex() {
    return EMPTY_FILE_SET;
  }

  @NotNull
  @Override
  public Set<VirtualFile> getAdditionalProjectRootsToIndex(@Nullable Project project) {
    return CacheUtil.getIndexableRoots();
  }
}
