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
package jetbrains.mps.nodeEditor.leftHighlighter;

import jetbrains.mps.nodeEditor.EditorComponent;
import org.jetbrains.annotations.Nullable;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * User: Cyril.Konopko
 * Date: 12.10.2010
 * Time: 16:46:30
 */
// todo look at com.intellij.openapi.editor.TextAnnotationGutterProvider
public abstract class AbstractLeftColumn {
  private int myX = 0;

  public abstract void paint(Graphics g, EditorComponent editorComponent);

  public abstract int getWidth();

  public final int getX() {
    return myX;
  }

  // This method is only called from LeftEditorHighlighter
  void setX(int x) {
    myX = x;
  }

  @Nullable
  public String getTooltipText(MouseEvent e) {
    return null;
  }

  @Nullable
  public Cursor getCursor(MouseEvent e, EditorComponent editorComponent) {
    return null;
  }

  public abstract void relayout(EditorComponent editorComponent);

  public void mousePressed(MouseEvent e, final EditorComponent editorComponent) {
    if (e.isPopupTrigger()) {
      JPopupMenu menu = getPopupMenu(e);
      if (isCloseable()) {
        menu.insert(new AbstractAction("Close " + getName()) {
          @Override
          public void actionPerformed(ActionEvent e) {
            editorComponent.getLeftEditorHighlighter().removeTextColumn(AbstractLeftColumn.this);
          }
        }, 0);
        menu.insert(new JPopupMenu.Separator(), 1);
      }
      if (menu.getSubElements().length > 0) {
        LeftEditorHighlighter editorHighlighter = editorComponent.getLeftEditorHighlighter();
        menu.show(editorHighlighter, e.getX(), e.getY());
      }
    }
  }

  public JPopupMenu getPopupMenu(MouseEvent event) {
    return new JPopupMenu();
  }

  protected boolean isCloseable() {
    return true;
  }

  public abstract String getName();
}
