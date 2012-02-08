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
package jetbrains.mps.ide.editorTabs;

import com.intellij.openapi.extensions.ExtensionPointName;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;

public interface TabColorProvider {
  ExtensionPointName<TabColorProvider> EP_NAME = new ExtensionPointName<TabColorProvider>("com.intellij.mps.TabColorProvider");

  @Nullable
  Color getNodeColor(@NotNull SNode node);

  @Nullable
  Color getAspectColor(Iterable<SNodePointer> aspectNodes);
}
