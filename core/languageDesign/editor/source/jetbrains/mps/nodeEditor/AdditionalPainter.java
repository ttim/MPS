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
package jetbrains.mps.nodeEditor;

import java.awt.Graphics;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 01.12.2009
 * Time: 14:57:26
 * To change this template use File | Settings | File Templates.
 */
public interface AdditionalPainter<Item> {
  public void paint(Graphics g, EditorComponent editorComponent);
  public boolean paintsAbove();

  //returns an item which this painter paints. if it paints itself then just return this
  public Item getItem();

  public void afterAdding(EditorComponent editorComponent);
  public void beforeRemoval(EditorComponent editorComponent);
}
