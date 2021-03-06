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
package jetbrains.mps.nodeEditor.cellLayout;

import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * User: Alexander Shatalin
 * Date: 05.05.2010
 * <p/>
 * TODO: shouldn't we merge this interface with CellLayout ?
 */
public interface CellLayoutExt extends CellLayout {
  @Nullable
  List<? extends EditorCell> getSelectionCells(EditorCell_Collection editorCells);
}
