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
package jetbrains.mps.openapi.editor;

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;

import javax.swing.JComponent;

/**
 * evgeny, 11/17/11
 */
public interface EditorComponent {
  JComponent getEditorComponent();

  SNode getEditedNode();

  SNodePointer getEditedNodePointer();

  SNode getSelectedNode();

  IOperationContext getOperationContext();

  EditorCell getRootCell();

  EditorCell findNodeCell(final SNode node);

  void scrollToNode(SNode node);

  void scrollToCell(@NotNull EditorCell cell);

  void changeSelection(EditorCell newSelectedCell);

  void selectNode(SNode node);

  boolean isDisposed();

  EditorContext getEditorContext();

  void dispose();
}
