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

import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;


public abstract class InlineCellProvider extends AbstractCellProvider {
  private SNode myRefNode;
  private LinkDeclaration myLinkDeclaration;

  public void setRefNode(SNode refNode) {
    myRefNode = refNode;
  }

  public SNode getRefNode() {
    return myRefNode;
  }

  public void setLinkDeclaration(LinkDeclaration linkDeclaration) {
    myLinkDeclaration = linkDeclaration;
  }

  public LinkDeclaration getLinkDeclaration() {
    return myLinkDeclaration;
  }
}
